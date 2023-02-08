package be.kdg.MemoRace.view;

import be.kdg.MemoRace.model.Model;

/**
 * Vera Wise
 * 8/02/2023
 */
public class Presenteer {

    private Model model;
    private View view;

    public Presenteer(Model model, View view) {
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
