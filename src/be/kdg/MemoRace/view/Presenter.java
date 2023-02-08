package be.kdg.MemoRace.view;

import be.kdg.MemoRace.model.GameBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Presenter {

    private GameBoard model;
    private View view;

    public Presenter(GameBoard model, View view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        //TODO
//        this.view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                updateView();
//            }
//        });
    }

    private void updateView() {
        //TODO
        //get input van namen en aantal players.
//        String txt = view.getGeboorteJaarField().getText();
//        model.setGeboorteJaar(Integer.parseInt(txt));
    }
}
