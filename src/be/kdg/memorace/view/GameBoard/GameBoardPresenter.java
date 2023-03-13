package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter {
    // Attributes
    private final Memorace model;
    private final GameBoardView gameBoardView;
    private int timesClicked;
    private boolean firstClick;
    private Timeline stopwatchTimeline;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.timesClicked = 0;
        this.addEventHandlers();
        this.updateView();
        this.gameBoardView.getDieImg().setImage(new Image("/die_0.png"));
        this.setupTimeline();
        this.stopwatchTimeline.play();
    }
    // Methods
    private void setupTimeline() {
        this.stopwatchTimeline = new Timeline();
        this.stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        this.stopwatchTimeline.getKeyFrames().clear();

        this.stopwatchTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.model.getTimer().getDuration()), event -> {
            this.model.getTimer().tick();
            this.gameBoardView.getGameTime().setText(String.format("%02d:%02d:%02d",
                    this.model.getTimer().getHours(),this.model.getTimer().getMinutes(),this.model.getTimer().getSeconds()));
        }));
    }

    private void addEventHandlers() {
        this.gameBoardView.makePath();
        this.gameBoardView.makeCards();

        this.gameBoardView.getRollButton().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button
            this.gameBoardView.getRollButton().setDisable(true);

            this.play(); // Roll the dice and place the pawn

            this.gameBoardView.getGridGameBoard().setDisable(false);
            this.gameBoardView.makeAllCardsNotVisible();

            boolean[] clicked = new boolean[4];

            List<Integer> ints = this.model.GetValidCardsIDs(this.model.getPawn(this.model.getPlayerID()-1).getPosition());
            firstClick = false;

            for (int i = 0; i < this.gameBoardView.getCards().length; i++) {
                int finalI = i;
                this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        //clickSound(); // Play sound when you click the button

                        for (int j : ints) {
                            if (finalI == j) {
                                gameBoardView.getEmptyCards()[finalI].setImage(gameBoardView.getCards()[finalI].getImage());
                                firstClick = true;
                                System.out.println("firsts: " + firstClick);
                                clicked[0] = true;

                            }
                        }
                        System.out.println(clicked[0]);
                        if(clicked[0]){
                            for (int i1 = 0; i1 < gameBoardView.getCards().length; i1++) {
                                int finalI1 = i1;
                                gameBoardView.getEmptyCards()[finalI1].setOnMouseClicked(e -> {
                                    gameBoardView.getEmptyCards()[finalI1].setImage(gameBoardView.getCards()[finalI1].getImage());
                                    limitCards();// Only 2 cards can be clicked at a time
                                    clicked[0] = false;
                                    gameBoardView.getRollButton().setDisable(false);
                                });
                            }
                        }}
                });
            }
            updateView();
        });
    }
    private boolean first(List<Integer> ints){
        for (int i = 0; i < this.gameBoardView.getCards().length; i++) {
            int finalI = i;
            //if(!clicked[0] && !fullCardClicked[0]) {
            this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                //clickSound(); // Play sound when you click the button

                for (int j : ints) {
                    if (finalI == j) {
                        this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                        firstClick = true;
                        //limitCards(); // Only 2 cards can be clicked at a time
                        System.out.println("firsts: " + firstClick);

                    }
                }

                //////
            });
            // }
            //System.out.println(firstClick);
            if(firstClick){
                return true;
            }
        }
        return false;
    }
    private void chooseCard(){
        AtomicBoolean a = new AtomicBoolean(false);
        for (int i = 0; i < 16; i++) {
            int finalI = i;

            // AtomicBoolean d = new AtomicBoolean(false);

            // Only click row/column of Die number
            //if(i < 4){
            this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(mouseEvent -> {
                //clickSound(); // Play sound when you click the button
                //Make the image visible
                this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());


                //limitCards(); // Only 2 cards can be clicked at a time

                if(timesClicked < 2){
                    this.gameBoardView.getRollButton().setOnAction(actionEvent -> {
                        //clickSound(); // Play sound when you click the button

                        this.play(); // Roll the dice and place the pawn

                        this.gameBoardView.getGridGameBoard().setDisable(false);
                        this.gameBoardView.makeAllCardsNotVisible();

                        this.updateView();
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

    private void play() {
        Player player = this.model.Turn();
        this.gameBoardView.getPlayerName().setText(player.getName());
        this.model.getDie().rollDie();
        this.model.setPawnPosition(this.model.currentPlayer(player));
        this.gameBoardView.returnPosition();
        this.gameBoardView.showPawn(this.model.getPawn(this.model.currentPlayer(player)).getPosition(), this.model.currentPlayer(player));
    }

    private int firstCard() {
        this.model.getplayers();
        return switch (this.model.getDie().getSide()) {
            case 1, 2, 3, 5 -> 4;
            case 4, 6 -> 1;
            default -> 0;
        };
    }

    private void limitCards() {
        this.timesClicked++;
        if(this.timesClicked >= 1){
            this.gameBoardView.getGridGameBoard().setDisable(true);
            this.timesClicked = 0;
        }
    }

    private void updateView() {
        int side = this.model.getDie().getSide();
        this.gameBoardView.showDie(side);

        // put the cards and an unique name for each in a map
        for (int i = 0; i < 16; i++) {
            //String naam = String.valueOf((char)(i+65));
            //String naam = String.valueOf(i);
            this.model.setCards(i,this.gameBoardView.getCards()[i]);
        }
    }
}