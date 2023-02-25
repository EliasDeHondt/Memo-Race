package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import be.kdg.memorace.view.PresenterInterface;
import javafx.scene.image.Image;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter implements PresenterInterface {
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
        Player player = this.model.Turn();
        this.gameBoardView.getPlayerName().setText(player.getName());

        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            //clickSound(); // Play sound when you click the button

            // Roll the dice
            this.model.getDie().rollDie();

            Player player1 = this.model.Turn();
            this.gameBoardView.getPlayerName().setText(player1.getName());

            updateView();
        });

        this.gameBoardView.makeAllCardsNotVisible();
       //this.gameBoardView.addGridPaneCards();
//        for (int i = 0; i < this.gameBoardView.getCards().length; i++) {
//            System.out.println(this.gameBoardView.getEmptyCards()[i].getImage().getUrl());
//        }
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            System.out.println("aaaaa");

            this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(
                    mouseEvent -> {
                        System.out.println("iiiiiii");
                        //this.gameBoardView.addGridPaneCards();
                        this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                        //this.gameBoardView.addGridPaneCards();
                        //this.gameBoardView.getCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                    });
        }


    }
    private void updateView() {
        int ogen1 = model.getDie().getSide();
        switch (ogen1) {
            case 1 -> gameBoardView.getDieImg().setImage(new Image("/die_1.png"));
            case 2 -> gameBoardView.getDieImg().setImage(new Image("/die_2.png"));
            case 3 -> gameBoardView.getDieImg().setImage(new Image("/die_3.png"));
            case 4 -> gameBoardView.getDieImg().setImage(new Image("/die_4.png"));
            case 5 -> gameBoardView.getDieImg().setImage(new Image("/die_5.png"));
            case 6 -> gameBoardView.getDieImg().setImage(new Image("/die_6.png"));
        }
        // put the cards and an unique name for each in a map
        for (int i = 0; i < 16; i++) {
            String naam = String.valueOf((char)(i+65));
            model.setCards(naam,gameBoardView.getEmptyCards()[i]);
        }

    }
}