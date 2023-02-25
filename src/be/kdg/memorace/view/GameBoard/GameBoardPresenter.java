package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import be.kdg.memorace.view.PresenterInterface;
import javafx.scene.image.Image;

import java.util.concurrent.atomic.AtomicBoolean;

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
        this.gameBoardView.makeCards();

        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            //clickSound(); // Play sound when you click the button
            // Roll the dice
            this.model.getDie().rollDie();
            Player player1 = this.model.Turn();
            this.gameBoardView.getPlayerName().setText(player1.getName());

            this.gameBoardView.makeAllCardsNotVisible();

            updateView();
        });

        int timesClicked = 0;
        AtomicBoolean isClicked = new AtomicBoolean(false);
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                //clickSound(); // Play sound when you click the button
                this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                isClicked.set(true);
            });
            System.out.println(timesClicked);
            if(isClicked.get()){
                timesClicked++;
                System.out.println(timesClicked);
            }

//            if(timesClicked >= 2){
//                break;
//            }
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
            model.setCards(naam,gameBoardView.getCards()[i]);
        }

    }
}