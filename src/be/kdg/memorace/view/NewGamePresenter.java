package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGamePresenter {
    // Attributes
    private GameBoard model;
    private NewGameView newGameView;
    // Constructors
    public NewGamePresenter(GameBoard model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
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