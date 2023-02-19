package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;

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
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        gameBoardView.getDie().setOnAction(event -> {
            // model.werp();
            updateView();
        });
    }
    private void updateView() {
        // TODO
    }
}