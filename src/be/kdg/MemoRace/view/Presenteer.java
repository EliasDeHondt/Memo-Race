package be.kdg.MemoRace.view;

import be.kdg.MemoRace.model.GameBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateView();

            }
        });
    }

    private void updateView() {
        //TODO
        //get input van namen en aantal players.
//        String txt = view.getGeboorteJaarField().getText();
//        model.setGeboorteJaar(Integer.parseInt(txt));
    }
}
