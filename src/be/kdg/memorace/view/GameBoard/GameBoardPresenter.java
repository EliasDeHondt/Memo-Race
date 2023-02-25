package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.app.ExceptionPlayer;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.PresenterInterface;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import static be.kdg.memorace.app.FileHandler.writeErrorLog;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter implements PresenterInterface {
    // Attributes
    private Memorace model;
    private GameBoardView gameBoardView;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            //clickSound(); // Play sound when you click the button
            // Roll the dice
            this.model.getDie().rollDie();
            // Set (model) Die Sides -> Die Sides (gameBoardView)
            //this.gameBoardView.setDieSides(this.model.getDie().getSide());
            updateView();
        });
    }
    private void updateView() {
        int ogen1 = model.getDie().getSide();
        switch (ogen1) {
            case 1 -> gameBoardView.getDieImg().setImage(new Image("/die_1.png"));
            case 2 -> gameBoardView.getDieImg().setImage(new Image("/die_2.png"));
            case 3 -> gameBoardView.getDieImg().setImage(new Image("/die_3.png"));
            case 4 -> gameBoardView.getDieImg().setImage(new Image("/die_4.png"));
            case 5 -> gameBoardView.getDieImg().setImage(new Image("/die_5.png"));
            case 6 -> gameBoardView.getDieImg().setImage(new Image("/die_6.png"));
        }

        try {
            this.gameBoardView.getPlayerName().setText(this.model.getPlayer().get(0).getName()); // Var 0 -> (x) is TEMP TODO

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