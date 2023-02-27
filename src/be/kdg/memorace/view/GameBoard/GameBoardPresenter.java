package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import be.kdg.memorace.view.PresenterInterface;
import javafx.scene.image.Image;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter implements PresenterInterface {
    // Attributes
    private Memorace model;
    private GameBoardView gameBoardView;
    private int timesClicked;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.timesClicked = 0;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        this.gameBoardView.makePath();
        this.gameBoardView.makeCards();
//        Player p = play();
//        this.gameBoardView.returnPosition(this.model.getPawn(model.currentPlayer(p)).getPosition());

        int lastPawnPos = 0;
        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            //clickSound(); // Play sound when you click the button
            //this.gameBoardView.returnPosition(this.model.getPawn(model.currentPlayer(player)).getPosition());
            //this.gameBoardView.returnPosition(this.model.getPawn(model.currentPlayer(p)).getPosition());
            //System.out.println("player 1");
            // Roll the dice and place the pawn
            //System.out.println(model.currentPlayer(player1));
            play();
            //this.gameBoardView.returnPosition(this.model.getPawn(model.currentPlayer(p1)).getPosition());
            //this.gameBoardView.returnPosition(this.model.getPawn(model.currentPlayer(player1)).getPosition());

            ///System.out.println(this.model.getPawn().getPosition()); //juist
            //if(model.getPlayer.)
            //this.gameBoardView.showPawn(this.model.getPawn().getPosition(),model.currentPlayer(player1));

            this.gameBoardView.getGridGameBoard().setDisable(false);

            //player1 = this.model.Turn();
            //System.out.println("player 2");

//            this.gameBoardView.getPlayerName().setText(player1.getName());
//            this.model.getDie().rollDie();
//            this.model.setPawnPosition(model.currentPlayer(player1));
//            this.gameBoardView.showPawn(this.model.getPawn(model.currentPlayer(player1)).getPosition(),model.currentPlayer(player1));
//
            this.gameBoardView.makeAllCardsNotVisible();

            updateView();
        });
        //lastPawnPos = this.model.getPawn().getPosition();

        for (int i = 0; i < 16; i++) {
            int finalI = i;
            // Only click row/column of Die number
            //if(i < 4){
                this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                    //clickSound(); // Play sound when you click the button
                    this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());

                    // Only 2 cards can be clicked at a time
                    //limitCards();
                });
            //}

        }

    }

    private void play(){
        Player p = this.model.Turn();
        this.gameBoardView.getPlayerName().setText(p.getName());
        this.model.getDie().rollDie();
        this.model.setPawnPosition(model.currentPlayer(p));
        this.gameBoardView.showPawn(this.model.getPawn(model.currentPlayer(p)).getPosition(),model.currentPlayer(p));

    }
    private int firstCard(){
        model.getPlayer();
        switch (this.model.getDie().getSide()){
            case 1: return 4;
            case 2: return 4;
            case 3: return 4;
            case 4: return 1;
            case 5: return 4;
            case 6: return 1;
            default: return 0;
        }
    }
    private void limitCards(){
        counter();
        if(timesClicked >= 2){
            this.gameBoardView.getGridGameBoard().setDisable(true);
            timesClicked = 0;
        }
    }
    private int counter(){
        timesClicked = timesClicked +1;
        return timesClicked;
    }
    private void updateView() {
        int ogen = model.getDie().getSide();
        gameBoardView.showDie(ogen);

        // put the cards and an unique name for each in a map
        for (int i = 0; i < 16; i++) {
            String naam = String.valueOf((char)(i+65));
            model.setCards(naam,gameBoardView.getCards()[i]);
        }

    }
}