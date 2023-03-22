package be.kdg.memorace.view.newGame;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.gameBoard.*;
import be.kdg.memorace.view.welcome.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.model.FileHandler.writeErrorLog;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * The NewGamePresenter class that is a presenter for the NewGameView window.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
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
            gameBoardView.setCustomStage(newGameView.getCustomStage());
            new GameBoardPresenter(this.model, gameBoardView); // Making Presenter (NewGamePresenter.class).

            if (newGameView.getScene() != null) { // If no names are entered then null

                this.newGameView.getScene().setRoot(gameBoardView); // Add (NewGameView.class) to (WelcomeView.class).
                gameBoardView.getScene().getWindow().sizeToScene(); // Add new Size.
                this.newGameView.getCustomStage().setTitle("Memo-Race / Game Bord"); // Making Title (Memo-Race / Game Bord).
            }
        });
    }

    private void updateView() {
        try {

            int count = 0;

            // Loop through each element of the array
            for (int i = 1; i <= this.newGameView.getPlayerTxt().length - 1; i++) {

                // If the current element is not empty, increment the counter
                if (!this.newGameView.getPlayerName(i - 1).getText().trim().isEmpty()) {
                    count++;
                }
            }

            // Check if the count is greater than or equal to 2
            if (count < 2) {
                this.model.getplayers().clear();
                throw new Exception();
            }


            // This four loop is responsible for the six players.
            for (int i = 1; i <= this.newGameView.getPlayerTxt().length - 1; i++) {

                // Check if each player name only contains alphabetical characters or is empty
                if(!this.newGameView.getPlayerName(i - 1).getText().matches("[a-zA-Z]*")) {
                    this.model.getplayers().clear();
                    throw new Exception();
                }

                // Checks if the length of the player's name entered greater than 20 characters.
                if (this.newGameView.getPlayerName(i - 1).getText().length() > 20) {
                    this.model.getplayers().clear();
                    throw new Exception();
                }

                // Takes the player name from the view and puts it in a variable.
                String playerName = this.newGameView.getPlayerName(i - 1).getText();

                // If the variable is not empty, it will be added to the player list.
                if (!playerName.isEmpty()) {
                    this.model.setPlayer(playerName);
                    this.model.setPawn();
                }
            }
        } catch (Exception e1) {
            String errorMessage = "(writeErrorLog) Sorry, error occurred. Need at least two players, and only 20 alphabetic characters allowed.";
            showAlert("Player names ERROR",errorMessage,Alert.AlertType.WARNING);

            try {
                writeErrorLog("resources/log/errorLog.txt", errorMessage); // The player name error will also be placed in a log.
            } catch (IOException e2) {
                showAlert("File Handler ERROR","(writeErrorLog) Our apologies, there seem to be an issue with our file system handler. :-(",Alert.AlertType.ERROR);
            }
        }
    }
    private void showAlert(String title,String text, Alert.AlertType at) {
        Alert alert = new Alert(at);
        alert.setHeaderText(text);
        alert.setTitle(title);
        alert.showAndWait();
    }
}