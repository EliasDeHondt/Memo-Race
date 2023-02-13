package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter {
    // Attributes
    private GameBoard model;
    private GameBoardView gameBoardView;
    // Constructors
    public GameBoardPresenter(GameBoard model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        // TODO
    }
    private void updateView() {
        // TODO
    }
}