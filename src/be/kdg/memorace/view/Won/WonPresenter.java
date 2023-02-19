package be.kdg.memorace.view.Won;

import be.kdg.memorace.model.Memorace;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class WonPresenter {
    // Attributes
    private Memorace model;
    private WonView wonView;
    // Constructors
    public WonPresenter(Memorace model, WonView wonView) {
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
