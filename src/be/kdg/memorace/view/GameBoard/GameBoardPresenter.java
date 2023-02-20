package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter {
    // Attributes
    private Memorace model;
    private GameBoardView gameBoardView;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        // Event Click
        this.gameBoardView.getClick().setOnAction(actionEvent -> {
            // Roll the dice
            this.model.rollDice();
            //
            this.gameBoardView.setDieSidesSides(this.model.getDie().getSide());
        });
    }
    private void updateView() {
        // TODO
    }
}