package be.kdg.memorace.view.GameBoard;
import be.kdg.memorace.model.*;
import be.kdg.memorace.view.Won.*;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.util.List;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
 */
public class GameBoardPresenter {
    // Attributes
    private final Memorace model;
    private final GameBoardView gameBoardView;
    private int timesClicked;
    private boolean throwAgain;
    private Timeline stopwatchTimeline;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.timesClicked = 0;
        this.throwAgain = false;
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

            //If there are no cards left on the board:
            if(checkIfAllNull(gameBoardView.getUnknownCards())){
                WonView wonView = new WonView(); // Making View (NewGameView.class).
                this.gameBoardView.getScene().setRoot(wonView); // Add (NewGameView.class) to (WelcomeView.class).
                wonView.getScene().getWindow().sizeToScene(); // Add new Size.
                this.gameBoardView.getCustomStage().setTitle("Memo-Race / Won"); // Making Title (Memo-Race / New Game).
                wonView.setCustomStage(this.gameBoardView.getCustomStage());  // Send primaryStage to (NewGameView.class)
                new WonPresenter(model, wonView); // Making Presenter (NewGamePresenter.class).
            }

            // Change instruction for the player
            this.gameBoardView.getInstructions().setText("Choose 1 card from the row \nor column your pawn is in.");

            this.gameBoardView.getRollButton().setDisable(true);
            this.play(throwAgain); // Roll the dice and place the pawn
            throwAgain = false;

            this.gameBoardView.getGridGameBoard().setDisable(false);
            this.gameBoardView.makeAllCardsNotVisible();

            boolean[] clicked = new boolean[1];

            List<Integer> validCardsFirstTurn = this.model.GetValidCardsIDs(this.model.getPawn(this.model.getPlayerID()-1).getPosition());
            int counter = 0;
            for (Integer i : validCardsFirstTurn) {
                if(gameBoardView.getUnknownCards()[i].getImage() == null){
                    counter++;
                }
            }
            if(counter >= 4){
                this.gameBoardView.getRollButton().setDisable(false); //You can roll the die again
                throwAgain = true; //The turn doesn't change
            }

            for (int i = 0; i < this.gameBoardView.getCards().length; i++) {
                int finalI = i;
                this.gameBoardView.getUnknownCards()[finalI].setOnMouseClicked(new EventHandler<>() {
                    private ImageView firstCard;

                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        clickSound(model.getVolumeButton()); // Play sound when you click the button

                        for (int card : validCardsFirstTurn) {
                            //if the clicked card is in the correct array
                            if (finalI == card) {
                                //show that card; else wait until the correct one is clicked
                                Image shownCard = gameBoardView.getCards()[finalI].getImage();
                                gameBoardView.getUnknownCards()[finalI].setImage(shownCard);
                                clicked[0] = true;
                                firstCard = gameBoardView.getUnknownCards()[finalI];
                                // Change instruction for the player
                                gameBoardView.getInstructions().setText("Choose the 2nd card \nfrom all the cards.");
                            }
                        }
                        if (clicked[0]) { // If you clicked the correct first card, you can click another one:
                            for (int i1 = 0; i1 < gameBoardView.getCards().length; i1++) {
                                int finalI1 = i1;
                                gameBoardView.getUnknownCards()[finalI1].setOnMouseClicked(e -> {
                                    gameBoardView.getUnknownCards()[finalI1].setImage(gameBoardView.getCards()[finalI1].getImage());

                                    limitCards();// Only 2 cards can be clicked at a time
                                    clicked[0] = false;
                                    ImageView secondCard = gameBoardView.getUnknownCards()[finalI1];
                                    if (model.compare2Cards(firstCard, secondCard)) { //compare if the 2 clicked cards are the same
                                        //if yes, place 1 card in the current player and remove the other 2
                                        model.addCardToPlayer(model.getPlayerID() - 1, firstCard);
                                        gameBoardView.takeCard(finalI);
                                        gameBoardView.takeCard(finalI1);
                                    }
                                    gameBoardView.getRollButton().setDisable(false); // you can play again
                                    // Change instruction for the player
                                    gameBoardView.getInstructions().setText("The next player can \nroll the die now.");
                                });
                            }
                        }
                    }
                });
            }
            updateView();
        });
    }
    private void play(boolean b) {
        Player player = b ? model.DontTurn() : this.model.Turn();

        this.gameBoardView.getPlayerName().setText(player.getName());
        this.gameBoardView.getScore().setText(String.valueOf(player.getScore()));// Show the score of the player
        this.model.getDie().rollDie();
        this.model.setPawnPosition(this.model.currentPlayer(player));
        this.gameBoardView.returnPosition();
        this.gameBoardView.showPawn(this.model.getPawn(this.model.currentPlayer(player)).getPosition(), this.model.currentPlayer(player));
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
            this.model.setCards(i,this.gameBoardView.getCards()[i]);
        }
    }
    public static boolean checkIfAllNull(ImageView[] imageViews) {
        for (ImageView i : imageViews) {
            if (i.getImage() != null) {
                return false;
            }
        }
        return true;
    }
}