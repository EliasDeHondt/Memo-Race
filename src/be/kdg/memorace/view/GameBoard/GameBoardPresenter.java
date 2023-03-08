package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static be.kdg.memorace.app.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter {
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
        this.gameBoardView.getDieImg().setImage(new Image("/die_0.png"));
    }
    // Methods
    private void addEventHandlers() {
        this.gameBoardView.makePath();
        this.gameBoardView.makeCards();

        //boolean a = false;
        //do {
            //chooseCard();
        //}while (!a);

        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            // Roll the dice and place the pawn
            play();

            this.gameBoardView.getGridGameBoard().setDisable(false);
            this.gameBoardView.makeAllCardsNotVisible();

            List<Integer> ints = firstTurnA();
            System.out.println("ints: " + ints);
            for (int i = 0; i< gameBoardView.getCards().length;i++) {
                int finalI = i;
                this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                    //clickSound(); // Play sound when you click the button
                    System.out.println("fi : " + finalI);
                    System.out.println("llafjlkajl : " + ints);
                    for (int j: ints) {
                        if(finalI == j){
                            this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                        }
                    }

                    //firstTurnA();
                    // Only 2 cards can be clicked at a time
                    //limitCards();
//                   // ints.clear();
//                    if(counter() == 2){
//                        for (int in: ints) {
//                            this.gameBoardView.getEmptyCards()[ints.get(in)].setDisable(true);
//                        }
//                        ints.clear();/////////////
//                        System.out.println("ints end: " + ints);
//                    }
//                    mouseEvent.consume();
                });

            }
            updateView();
            //this.gameBoardView.getGridGameBoard().setDisable(true);
            //System.out.println(ints);
        });

        //int[] ints = this.gameBoardView.getC(model.GetValidCardsIDs(model.getPawn(model.getPlayerID()-1).getPosition()));
        ///System.out.println(ints);

//        for (int i = 0; i < 16; i++) {
//            int finalI = i;
//            // Only click row/column of Die number
//            //if(i < 4){
//                this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
//                    //clickSound(); // Play sound when you click the button
//                    this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
//
//                    // Only 2 cards can be clicked at a time
//                    //limitCards();
//                });
//            //}
//
//        }

    }
    private void firstTurn(){
        List<Integer> newC = model.GetValidCardsIDs(model.getPawn(model.getPlayerID()-1).getPosition());
        System.out.println(newC); // klopt!
        gameBoardView.showValidCards(newC);
    }
    private List<Integer> firstTurnA(){
        List<Integer> newC = model.GetValidCardsIDs(model.getPawn(model.getPlayerID()-1).getPosition());
        System.out.println(newC);
        return newC;
    }
    private void chooseCard(){
        AtomicBoolean a = new AtomicBoolean(false);
        for (int i = 0; i < 16; i++) {
            int finalI = i;
            AtomicBoolean d = new AtomicBoolean(false);
            // Only click row/column of Die number
            //if(i < 4){
            this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                //clickSound(); // Play sound when you click the button
                //Make the image visible
                this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());

                // Only 2 cards can be clicked at a time
                //limitCards();

                if(timesClicked < 2){
                    this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
                        //clickSound(); // Play sound when you click the button

                        // Roll the dice and place the pawn
                        play();

                        this.gameBoardView.getGridGameBoard().setDisable(false);
                        this.gameBoardView.makeAllCardsNotVisible();

                        updateView();
                    });
                }


//                System.out.println(a.get());
//                a.set(true);
//                System.out.println(a.get());
//                boolean e = true;
//                return e;
            });
            //}


//            if(d.get()){
//                return d.get();
//            }

        }
//        System.out.println(a.get());
//        return d.get();
       // return true;
        System.out.println("last: " + a.get());
    }
    private void play(){
        Player p = this.model.Turn();
        this.gameBoardView.getPlayerName().setText(p.getName());
        this.model.getDie().rollDie();
        this.model.setPawnPosition(model.currentPlayer(p));
        this.gameBoardView.returnPosition();
        this.gameBoardView.showPawn(this.model.getPawn(model.currentPlayer(p)).getPosition(),model.currentPlayer(p));
    }
    private int firstCard(){
        this.model.getplayers();
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
            //String naam = String.valueOf((char)(i+65));
            //String naam = String.valueOf(i);
            model.setCards(i,gameBoardView.getCards()[i]);
        }

    }
}