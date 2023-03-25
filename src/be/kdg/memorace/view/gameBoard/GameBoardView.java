package be.kdg.memorace.view.gameBoard;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

/**
 * The GameBoardView class shows the gameboard window.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class GameBoardView extends BorderPane {
    // Attributes
    private Label playerName, gameTime;
    private ImageView[] path;
    private ImageView[] cards;
    private ImageView[] unknownCards;
    private Image[] die;
    private Button rollButton;
    private ImageView dieImg;
    private GridPane gridGameBoard;
    private Stage primaryStage;
    private Label instructions;
    private Label score;

    // Constructors
    public GameBoardView(String cardTheme) { // Receives the theme of the cards as an extra.
        this.initialiseNodes();
        this.layoutNodes(cardTheme);
    }

    // Methods
    private void initialiseNodes() {
        this.playerName = new Label();
        this.gameTime = new Label();
        this.path = new ImageView[18];
        this.cards = new ImageView[16];
        this.unknownCards = new ImageView[16];
        this.die = new Image[7];
        this.rollButton = new Button("roll");
        this.dieImg = new ImageView();
        this.gridGameBoard = new GridPane(); // Making new GridPane (CENTER)
        this.instructions = new Label("Roll the die.");
        this.score = new Label();
        this.gridGameBoard.setId("background"); // Set CSS background
        setAlignment(gridGameBoard, Pos.CENTER); // Set (gridGameBoard) on CENTER.

        // Images, Loading the path.
        for (int i = 0; i < 17; i++) {
            this.path[i] = new ImageView(new Image("/path_" + i + ".png"));
        }

        // Images, Loading the die.
        for (int i = 0; i < 7; i++) {
            this.die[i] = new Image("/die_" + i + ".png");
        }

    }

    private void layoutNodes(String cardTheme) {
        BorderPane top = new BorderPane(); // Making new BorderPane (TOP)
        top.setLeft(this.playerName); // Set (this.playerName) on LEFT
        top.setRight(this.gameTime); // Set (this.gameTime) on RIGHT
        top.setId("background"); // Set CSS background
        top.setPadding(new Insets(10)); // Set padding for (top)
        this.playerName.setId("top"); // Set CSS (this.playerName)
        this.gameTime.setId("top"); // Set CSS (this.gameTime)
        this.score.setId("button");
        top.setCenter(this.score);
        this.setTop(top); // set (top) on top in (BorderPane | this. )

        // Initializing the correct cards related to the theme.
        if (cardTheme == null || cardTheme.equals("Meme Theme")) {
            addCards("/meme_card_");
        } else if (cardTheme.equals("Fruit Theme")) {
            addCards("/fruit_card_");
        } else if (cardTheme.equals("Teacher Theme")) {
            addCards("/teacher_card_");
        }
        this.cards = shuffleCards();

        // Add all card images into the array
        for (int i = 0; i < 8; i++) {
            this.unknownCards[i] = new ImageView(new Image("/question_mark.png"));
            this.unknownCards[i + 8] = new ImageView(new Image("/question_mark.png"));
        }

        // Set gridGameBoard (GameBoard Layout) Center
        this.setCenter(this.gridGameBoard);
        this.gridGameBoard.add(new ImageView(new Image("/path_x.png")), 5, 0);
        this.gridGameBoard.add(new ImageView(new Image("/path_x.png")), 5, 5);
        this.gridGameBoard.add(new ImageView(new Image("/path_x.png")), 0, 5);

        BorderPane bottom = new BorderPane(); // Making new BorderPane (BOTTOM)
        bottom.setId("background"); // Set CSS background
        this.rollButton.setId("button"); // Set CSS button
        setBottom(bottom); // Set (buttom) in Buttom
        bottom.setRight(this.rollButton); // Set (this.click) Right in buttom
        bottom.setLeft(this.dieImg); // Set (this.dieSidesSides) Left in buttom
        this.instructions.setId("instructionButton");
        bottom.setCenter(this.instructions);
        bottom.setPadding(new Insets(10)); // Set padding for (buttom)
    }
    private void addCards(String image){
        for (int i = 0; i < 8; i++) { // Add all card images into the array
            this.cards[i] = new ImageView(new Image(image + (i + 1) + ".png"));
            this.cards[i + 8] = new ImageView(new Image(image + (i + 1) + ".png"));
        }
    }

    void makeCards() {
        ImageView[] imageView = getUnknownCards();
        int j = 1;
        for (int i = 0; i < 4; i++) {
            this.gridGameBoard.add(imageView[i], i + 1, j);
            this.gridGameBoard.add(imageView[i + 4], i + 1, j + 1);
        }
        for (int i = 4; i < 8; i++) {
            this.gridGameBoard.add(imageView[i + 4], i - 3, j + 2);
            this.gridGameBoard.add(imageView[i + 8], i - 3, j + 3);
        }
    }

    void makeAllCardsNotVisible() {
        for (int i = 0; i < 16; i++) {
            if (this.getUnknownCards()[i].getImage() != null) {
                this.getUnknownCards()[i].setImage(new Image("/question_mark.png"));
            }
        }
    }

    void makePath() {
        // Set row 0. Example -> gridGameBoard.add(new ImageView(this.path1),1,0);
        for (int i = 0; i < 5; i++) {
            this.gridGameBoard.add(this.path[i], i, 0);
        }

        // Set row 1, 2, 3, 4. Example -> gridGameBoard.add(new ImageView(this.path16),0,1);
        int p1 = 16, p2 = 5;
        for (int i = 1; i < 5; i++) {
            this.gridGameBoard.add(this.path[p1--], 0, i);
            this.gridGameBoard.add(this.path[p2++], 5, i);
        }

        // Set row 5. Example -> gridGameBoard.add(new ImageView(this.path12),1,5);
        int teller = 12;
        for (int i = 1; i < 5; i++) {
            this.gridGameBoard.add(this.path[teller], i, 5);
            teller--;
        }
    }
    void showPawn(int position, int player) {
        this.path[position].setImage(new Image("/pawn_" + (player + 1) + ".png"));
    }

    void returnPosition() {
        for (int i = 0; i < 17; i++) {
            this.path[i].setImage(new Image("/path_" + i + ".png"));
        }
    }

    void showDie(int side) {
        switch (side) {
            case 1 -> this.getDieImg().setImage(new Image("/die_1.png"));
            case 2 -> this.getDieImg().setImage(new Image("/die_2.png"));
            case 3 -> this.getDieImg().setImage(new Image("/die_3.png"));
            case 4 -> this.getDieImg().setImage(new Image("/die_4.png"));
            case 5 -> this.getDieImg().setImage(new Image("/die_5.png"));
            case 6 -> this.getDieImg().setImage(new Image("/die_6.png"));
        }
    }

    void takeCard(int position) {
        this.getCards()[position].setImage(null);
        this.getUnknownCards()[position].setImage(null);
    }

    private ImageView[] shuffleCards() {
        Random random = new Random();
        int[] shuffleArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ImageView[] newCards = new ImageView[16];

        for (int i = shuffleArray.length - 1; i >= 0; --i) {
            int j = random.nextInt(i + 1);
            int temp = shuffleArray[i];
            shuffleArray[i] = shuffleArray[j];
            shuffleArray[j] = temp;
        }

        for (int i = 0; i < this.cards.length; i++) {
            newCards[i] = this.cards[shuffleArray[i]];
        }

        return newCards;
    }

    Button getRollButton() {
        return this.rollButton;
    }

    ImageView getDieImg() {
        return this.dieImg;
    }

    Label getPlayerName() {
        return this.playerName;
    }

    ImageView[] getCards() {
        return this.cards;
    }

    GridPane getGridGameBoard() {
        return gridGameBoard;
    }

    ImageView[] getUnknownCards() {
        return this.unknownCards;
    }

    Label getGameTime() {
        return this.gameTime;
    }

    Label getInstructions() {
        return this.instructions;
    }

    Label getScore() {
        return this.score;
    }

    public Stage getCustomStage() {
        return this.primaryStage;
    }

    public void setCustomStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}