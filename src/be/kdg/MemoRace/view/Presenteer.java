package be.kdg.MemoRace.view;

import be.kdg.MemoRace.model.GameBoard;

/**
 * Vera Wise
 * 8/02/2023
 */
public class Presenteer {

    private GameBoard model;
    private View view;

    public Presenteer(GameBoard model, View view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        //TODO
    }

    private void updateView() {
        //TODO
    }
}
