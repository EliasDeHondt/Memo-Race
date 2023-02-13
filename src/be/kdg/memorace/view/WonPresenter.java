package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class WonPresenter {
    // Attributes
    private GameBoard model;
    private WonView wonView;
    // Constructors
    public WonPresenter(GameBoard model, WonView wonView) {
        this.model = model;
        this.wonView = wonView;
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
