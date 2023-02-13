package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Presenter {

    private GameBoard model;
    private NewGameView newGameView;

    public Presenter(GameBoard model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        //TODO
//        this.newGameView.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                updateView();
//            }
//        });
    }

    private void updateView() {
        //TODO
        //get input van namen en aantal players.
//        String txt = newGameView.getGeboorteJaarField().getText();
//        model.setGeboorteJaar(Integer.parseInt(txt));
    }
}
