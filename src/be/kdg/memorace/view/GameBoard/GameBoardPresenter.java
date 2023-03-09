package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

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
    private Memorace model;
    private GameBoardView gameBoardView;
    private int timesClicked;
    private boolean firstClick;
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

        this.gameBoardView.getRollButton().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            // Roll the dice and place the pawn
            play();

            this.gameBoardView.getGridGameBoard().setDisable(false);
            this.gameBoardView.makeAllCardsNotVisible();
/*
            ImageView[] imageViews = new ImageView[numImages];
            boolean[] clicked = new boolean[numImages];

            for (int i = 0; i < numImages; i++) {
                ImageView imageView = new ImageView(new Image("your-image-file.png"));
                imageView.setOnMouseClicked(event -> {
                    if (!clicked[i]) {
                        // handle the mouse click event here
                        System.out.println("Image " + i + " clicked!");
                        clicked[i] = true;
                    }
                });
                imageViews[i] = imageView;
            }
*/
            boolean[] clicked = new boolean[4];
            final boolean[] fullCardClicked = {false};

            List<Integer> ints = firstTurnA();
            System.out.println("ints: " + ints);
            firstClick = false;
            boolean b = first(ints);

            for (int i = 0; i< gameBoardView.getCards().length;i++) {
                int finalI = i;
                //if(!clicked[0] && !fullCardClicked[0]) {
                    this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            //clickSound(); // Play sound when you click the button

                            for (int j : ints) {
                                if (finalI == j) {
                                    gameBoardView.getEmptyCards()[finalI].setImage(gameBoardView.getCards()[finalI].getImage());
                                    firstClick = true;
                                    //limitCards(); // Only 2 cards can be clicked at a time
                                    System.out.println("firsts: " + firstClick);
                                    clicked[0] = true;

                                }
                            }
                        }
                        //////
                    });
               // }
                //System.out.println(firstClick);

            }

            List<Integer> otherInts = new ArrayList<>();
            //int[] l = new int[12];
            int lIndex = 0;
            for (int i = 0; i < gameBoardView.getCards().length+1; i++) {
                boolean isInK = false;
                for (int x : ints) {
                    if (i == x) {
                        isInK = true;
                        break;
                    }
                }
                if (!isInK) {
                    otherInts.add(i);
                    lIndex++;
                }
            }
            System.out.println("clicked " + clicked[0]);
            if(firstClick){
                System.out.println("faddaf: " + firstClick);
                for (int i = 0; i<otherInts.size();i++) {
                    int finalI = i;
                    if (clicked[0] && !fullCardClicked[0]) {
                        this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(e -> {
                            this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage());
                            clicked[0] = false;
                            fullCardClicked[0] = true;
                        });

                    }
            }

                //limitCards();
                ///System.out.println("pos: " + finalI);
                //}
            }

//            int[] k = {1, 5, 9, 13};
//            int[] j = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16};
//            int[] l = new int[12];
//            How to add to array l the elements of array j without the elements of k?
           /* List<Integer> otherInts = new ArrayList<>();
            //int[] l = new int[12];
            int lIndex = 0;
            for (int i = 0; i < gameBoardView.getCards().length+1; i++) {
                boolean isInK = false;
                for (int x : ints) {
                    if (i == x) {
                        isInK = true;
                        break;
                    }
                }
                if (!isInK) {
                    otherInts.add(i);
                    lIndex++;
                }
            }
            System.out.println(otherInts);
            for (int i = 0; i<otherInts.size();i++) {
                int finalI = i;
                //if(firstClick == true){
                    //this.gameBoardView.getEmptyCards()[finalI].setOnMouseClicked(e -> this.gameBoardView.getEmptyCards()[finalI].setImage(this.gameBoardView.getCards()[finalI].getImage()));
                    //limitCards();
                    System.out.println("pos: " + finalI);
                //}
            }
            System.out.println(firstClick);*/
            updateView();
        });
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
    private boolean first(List<Integer> ints){
        for (int i = 0; i< gameBoardView.getCards().length;i++) {
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
                    this.gameBoardView.getRollButton().setOnAction(actionEvent -> {
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