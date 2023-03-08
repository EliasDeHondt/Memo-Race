package be.kdg.memorace.view.NewGame;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.GameBoard.GameBoardPresenter;
import be.kdg.memorace.view.GameBoard.GameBoardView;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.app.FileHandler.writeErrorLog;
import static be.kdg.memorace.app.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGamePresenter {
    // Attributes
    private final Memorace model;
    private final NewGameView newGameView;
    // Constructors
    public NewGamePresenter(Memorace model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        // Action-> [Back (welcomeView)] (getMiBack)
        this.newGameView.getMiBack().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.newGameView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.newGameView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.newGameView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });
        // Action-> [Exit Game] (getMiExit)
        this.newGameView.getMiExit().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            Platform.exit(); // exit
        }));

        // Action-> [Start Game] (getStartGame)
        this.newGameView.getStartGame().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button
            this.updateView();
            if (this.model.getplayers().size() < 2) {
                NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
                this.newGameView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
                newGameView.getScene().getWindow().sizeToScene(); // Add new Size.
                this.newGameView.getCustomStage().setTitle("Memo-Race / New Game"); // Making Title (Memo-Race / New Game).
                newGameView.setCustomStage(this.newGameView.getCustomStage());  // Send primaryStage to (NewGameView.class)
                new NewGamePresenter(model, newGameView); // Making Presenter (NewGamePresenter.class).
            }

            GameBoardView gameBoardView = new GameBoardView(this.model.getCardTheme()); // Making View (NewGameView.class) and specify the theme for the cards.
            new GameBoardPresenter(this.model, gameBoardView); // Making Presenter (NewGamePresenter.class).
            this.newGameView.getScene().setRoot(gameBoardView); // Add (NewGameView.class) to (WelcomeView.class).
            gameBoardView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.newGameView.getCustomStage().setTitle("Memo-Race / Game Bord"); // Making Title (Memo-Race / Game Bord).


        });
    }
    private void updateView() {
        try {
            // This four loop is responsible for the six players.
            for (int i = 1; i <= this.newGameView.getPlayerTxt().length-1; i++) {
                // Takes the player name from the view and puts it in a variable.
                String playerName = this.newGameView.getPlayerName(i-1).getText();
                // If the variable is not empty, it will be added to the player list.
                if (!playerName.isEmpty()) {
                    this.model.setPlayer(playerName);
                    this.model.setPawn();
                }
            }
            if (this.model.getplayers().size() < 2) {
                throw new Exception();
            }
        } catch (Exception e1) {
            String errorMessage = "(writeErrorLog) No player names were entered. Please be advised.";
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setHeaderText(errorMessage);
            alert1.setTitle("Player names ERROR");
            alert1.showAndWait();
            try {
                writeErrorLog("resources/log/errorLog.txt", errorMessage); // The player name error will also be placed in a log.
            } catch (IOException e2) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setHeaderText("(writeErrorLog) Our apologies, there seem to be an issue with our file system handler. :-(");
                alert2.setTitle("File Handler ERROR");
                alert2.showAndWait();
            }

        }
    }
}











