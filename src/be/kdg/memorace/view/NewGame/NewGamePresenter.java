package be.kdg.memorace.view.NewGame;

import be.kdg.memorace.app.ExceptionPlayer;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.GameBoard.GameBoardPresenter;
import be.kdg.memorace.view.GameBoard.GameBoardView;
import be.kdg.memorace.view.PresenterInterface;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Arrays;

import static be.kdg.memorace.app.FileHandler.writeErrorLog;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGamePresenter implements PresenterInterface {
    // Attributes
    private Memorace model;
    private NewGameView newGameView;
    // Constructors
    public NewGamePresenter(Memorace model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
//        // This four loop is responsible for the six players.
//        for (int i = 1; i <= this.newGameView.getPlayerTxt().length-1; i++) {
//            // Takes the player name from the view and puts it in a variable.
//            String playerName = this.newGameView.getPlayerName(i-1).getText();
//            // If the variable is not empty, it will be added to the player list.
//            if (!playerName.isEmpty()) {
//                this.model.setPlayer(playerName);
//                //a++;
//            }
//        }


        this.newGameView.getStartGame().setOnAction(actionEvent -> {
            this.updateView();
            if (this.model.getPlayer().size() < 2) {
                NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
                this.newGameView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
                newGameView.getScene().getWindow().sizeToScene(); // Add new Size.
                this.newGameView.getCustomStage().setTitle("Memo-Race / New Game"); // Making Title (Memo-Race / New Game).
                newGameView.setCustomStage(this.newGameView.getCustomStage());  // Send primaryStage to (NewGameView.class)
                new NewGamePresenter(model, newGameView); // Making Presenter (NewGamePresenter.class).
            }
            //clickSound(); // Play sound when you click the button

            GameBoardView gameBoardView = new GameBoardView(); // Making View (NewGameView.class).
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
            if (this.model.getPlayer().size() < 2) {
                throw new Exception();
            }
        } catch (Exception e) {
            String errorMessage = "(writeErrorLog) No player names were entered. Please be advised.";
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(errorMessage);
            alert.setTitle("Player names ERROR");
            alert.showAndWait();
            writeErrorLog("resources/log/errorLog.csv", errorMessage); // The player name error will also be placed in a log.
        }
    }
}











