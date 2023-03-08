package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.app.Timer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardView extends BorderPane {
    // Attributes
    private Label playerName, gameTime;
    private ImageView[] path;
    private ImageView[] cards;
    private ImageView[] emptyCards;
    private Image[] die;
    private Button rollButton;
    private ImageView dieImg;
    private Timer timer;
    private GridPane gridGameBoard;
    // Constructors
    public GameBoardView(String cardTheme) { // Receives the theme of the cards as an extra.
        this.initialiseNodes();
        this.layoutNodes(cardTheme);
    }
    // Methods
    public void initialiseNodes() {
        this.playerName = new Label();
        this.gameTime = new Label();
        this.path = new ImageView[18];
        this.cards = new ImageView[16];
        this.emptyCards = new ImageView[16];
        this.die = new Image[7];
        this.rollButton = new Button("roll");
        this.dieImg = new ImageView();
        this.timer = new Timer(this.gameTime); // Set Game Time to (this.timer)
        this.gridGameBoard = new GridPane(); // Making new GridPane (CENTER)
        this.gridGameBoard.setId("background"); // Set CSS background
        setAlignment(gridGameBoard, Pos.CENTER); // Set (gridGameBoard) on CENTER.
        // Images, Loading the path.
        for (int i = 0; i < 17; i++) {
            this.path[i] = new ImageView(new Image("/path_" + i + ".png"));
        }

        // Images, Loading cards.
//        this.cards[0] = new ImageView(new Image("/question_mark.png"));
//        for (int i = 1; i < 8; i++) {
//            this.cards[i] = new ImageView(new Image("/card_" + (i+1) + ".png"));
//        }

        // Images, Loading the path.
        for (int i = 0; i < 7; i++) {
            this.die[i] = new Image("/die_" + i + ".png");
        }

    }
    public void layoutNodes(String cardTheme) {
        BorderPane top = new BorderPane(); // Making new BorderPane (TOP)
        top.setLeft(this.playerName); // Set (this.playerName) on LEFT
        top.setRight(this.gameTime); // Set (this.gameTime) on RIGHT
        top.setId("background"); // Set CSS background
        top.setPadding(new Insets(10)); // Set padding for (top)
        this.playerName.setId("top"); // Set CSS (this.playerName)
        this.gameTime.setId("top"); // Set CSS (this.gameTime)
        this.setTop(top); // set (top) on top in (BorderPane | this. )

        // Initializing the correct cards related to the theme.
        if (cardTheme == null || cardTheme.equals("Meme Theme") ) {
            for (int i = 0; i < 8; i++) { // Add all card images into the array
                this.cards[i] = new ImageView(new Image("/meme_card_" + (i+1) + ".png"));
                this.cards[i+8] = new ImageView(new Image("/meme_card_" + (i+1) + ".png"));
            }
        } else if (cardTheme.equals("Fruit Theme")) {
            for (int i = 0; i < 8; i++) { // Add all card images into the array
                this.cards[i] = new ImageView(new Image("/fruit_card_" + (i+1) + ".png"));
                this.cards[i+8] = new ImageView(new Image("/fruit_card_" + (i+1) + ".png"));
            }
        } else if (cardTheme.equals("Teacher Theme")) {
            for (int i = 0; i < 8; i++) { // Add all card images into the array
                this.cards[i] = new ImageView(new Image("/teacher_card_" + (i + 1) + ".png"));
                this.cards[i + 8] = new ImageView(new Image("/teacher_card_" + (i + 1) + ".png"));
            }
        }

        // Add all card images into the array
        for (int i = 0; i < 8; i++) {
            this.emptyCards[i] = new ImageView(new Image("/question_mark.png"));
            this.emptyCards[i+8] = new ImageView(new Image("/question_mark.png"));
        }

        //makeAllCardsNotVisible();
        //addGridPaneCards(); // set the cards on the gridpane


        // Set gridGameBoard (GameBoard Layout) Center
        setCenter(this.gridGameBoard);

        BorderPane buttom = new BorderPane(); // Making new BorderPane (BUTTOM)
        buttom.setId("background"); // Set CSS background
        this.rollButton.setId("button"); // Set CSS button
        setBottom(buttom); // Set (buttom) in Buttom
        buttom.setRight(this.rollButton); // Set (this.click) Right in buttom
        buttom.setLeft(this.dieImg); // Set (this.dieSidesSides) Left in buttom

        this.timer.start(); // Start Game Time
        buttom.setPadding(new Insets(10)); // Set padding for (buttom)
    }
    public void addGridPaneCards(){
        for (int i = 0; i < 4; i++) {
            gridGameBoard.add(this.cards[i],i+1,1);
            gridGameBoard.add(this.cards[i+4],i+1,2);
        }
        for (int i = 4; i < 8; i++) {
            gridGameBoard.add(this.cards[i+4],i-3,3);
            gridGameBoard.add(this.cards[i+8],i-3,4);
        }
    }

    public void makeCards() {
        ImageView[] imageView = getEmptyCards();
        int j = 1;
        for (int i = 0; i < 4; i++) {
            //this.getCards()[i].setImage(new Image("/question_mark.png"));
            gridGameBoard.add(imageView[i],i+1,j);
            gridGameBoard.add(imageView[i+4],i+1,j+1);
        }
        for (int i = 4; i < 8; i++) {
            //this.getCards()[i].setImage(new Image("/question_mark.png"));
            gridGameBoard.add(imageView[i+4],i-3,j+2);
            gridGameBoard.add(imageView[i+8],i-3,j+3);
        }
    }
    public void makeAllCardsNotVisible(){
        for (int i = 0; i < 16; i++) {
            this.getEmptyCards()[i].setImage(new Image("/question_mark.png"));
        }
    }

    public void makePath(){
        // Set row 0. Example -> gridGameBoard.add(new ImageView(this.path1),1,0);
        for (int i = 0; i < 5; i++) {
            gridGameBoard.add(this.path[i],i,0);
        }

        // Set row 1, 2, 3, 4. Example -> gridGameBoard.add(new ImageView(this.path16),0,1);
        int p1 = 16, p2 = 5;
        for (int i = 1; i < 5; i++) {
            gridGameBoard.add(this.path[p1--],0,i);
            gridGameBoard.add(this.path[p2++],5,i);
        }

        // Set row 5. Example -> gridGameBoard.add(new ImageView(this.path12),1,5);
        int teller = 12;
        for (int i = 1; i < 5; i++) {
            gridGameBoard.add(this.path[teller],i,5);
            teller--;
        }
    }

    public void showPawn(int position,int player){
        this.path[position].setImage(new Image("/pawn_" + (player+1) + ".png"));
    }
    public void returnPosition(){
        for (int i = 0; i < 17; i++) {
            this.path[i].setImage(new Image("/path_" + i + ".png"));
        }
    }
    public void showDie(int ogen){
        switch (ogen) {
            case 1 -> getDieImg().setImage(new Image("/die_1.png"));
            case 2 -> getDieImg().setImage(new Image("/die_2.png"));
            case 3 -> getDieImg().setImage(new Image("/die_3.png"));
            case 4 -> getDieImg().setImage(new Image("/die_4.png"));
            case 5 -> getDieImg().setImage(new Image("/die_5.png"));
            case 6 -> getDieImg().setImage(new Image("/die_6.png"));
        }
    }
    public void showValidCards(List<Integer> newC){
        for (Integer i: newC) {
            this.getEmptyCards()[i].setImage(null);
        }
    }
    public ImageView[] getValidCards(List<Integer> newC){
        ImageView[] nC = new ImageView[4];
        int j = 0;
        for (Integer i: newC) {
            nC[j++] = this.getEmptyCards()[i];
            //this.getEmptyCards()[i].setImage(null);
        }
        return nC;
    }
    public int[] getC(List<Integer> newC){
        int[] ints = new int[4];
        int j = 0;
        for (Integer i: newC) {
            ints[j++] = i;
        }
        return ints;
    }
    Button getRollButton() { // Get..
        return this.rollButton;
    }
    ImageView getDieImg() { // Get..
        return this.dieImg;
    }
    Label getPlayerName() { // Get..
        return this.playerName;
    }
    ImageView[] getCards() { // Get..
        return this.cards;
    }
    GridPane getGridGameBoard() { // Get..
        return gridGameBoard;
    }
    ImageView[] getEmptyCards(){ // Get..
        return emptyCards;
    }
}