package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.App.Timer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardView extends BorderPane {
    // Attributes
    private Label playerName, gameTime;
    private Image[] path;
    private Image[] cards;
    private Image[] die;
    private Button click;
    private ImageView dieSidesSides;
    private Timer timer;
    // Constructors
    public GameBoardView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.playerName = new Label();
        this.gameTime = new Label();
        this.path = new Image[18];
        this.cards = new Image[8];
        this.die = new Image[7];
        this.click = new Button("Click");
        this.dieSidesSides = new ImageView(this.die[0]);
        this.timer = new Timer(this.gameTime); // Set ....

        // Images, Loading the path.
        for (int i = 0; i < 17; i++) {
            this.path[i] = new Image("/path_" + i + ".png");
        }

        // Images, Loading cards.
        for (int i = 0; i < 8; i++) {
            this.cards[i] = new Image("/card_" + (i+1) + ".png"); // kan de images niet vinden?
        }

        // Images, Loading the path.
        for (int i = 0; i < 7; i++) {
            this.die[i] = new Image("/die_" + i + ".png");
        }

    }
    public void layoutNodes() {
        BorderPane top = new BorderPane(); // Making new BorderPane (TOP)
        top.setLeft(this.playerName); // Set (this.playerName) on LEFT
        top.setRight(this.gameTime); // Set (this.gameTime) on RIGHT
        this.playerName.setId("top"); // Set CSS (this.playerName)
        this.gameTime.setId("top"); // Set CSS (this.gameTime)
        setTop(top); // set (top) on top in (BorderPane | this. )
        GridPane gridGameBoard = new GridPane(); // Making new GridPane (CENTER)
        gridGameBoard.setId("background"); // Set CSS background
        setAlignment(gridGameBoard, Pos.CENTER); // Set (gridGameBoard) on CENTER.

        // Set row 0. Example -> gridGameBoard.add(new ImageView(this.path1),1,0);
        for (int i = 0; i < 5; i++) {
            gridGameBoard.add(new ImageView(this.path[i]),i,0);
        }

        // Set row 1, 2, 3, 4. Example -> gridGameBoard.add(new ImageView(this.path16),0,1);
        int p1 = 16, p2 = 5;
        for (int i = 1; i < 5; i++) {
            gridGameBoard.add(new ImageView(this.path[p1--]),0,i);
            gridGameBoard.add(new ImageView(this.path[p2++]),5,i);
        }

        // Set row 5. Example -> gridGameBoard.add(new ImageView(this.path12),1,5);
        int teller = 12;
        for (int i = 1; i < 5; i++) {
            gridGameBoard.add(new ImageView(this.path[teller]),i,5);
            teller--;
        }

        // Set gridGameBoard (GameBoard Layout) Center
        setCenter(gridGameBoard);

        BorderPane buttom = new BorderPane(); // Making new BorderPane (BUTTOM)
        buttom.setId("background"); // Set CSS background
        this.click.setId("button");
        setBottom(buttom); // Set (buttom) in Buttom
        buttom.setRight(this.click); // Set (this.click) Right in buttom
        buttom.setLeft(this.dieSidesSides); // Set (this.dieSidesSides) Left in buttom

        this.timer.start(); // Start Game Time


    }

    Button getClick() { // Get..
        return this.click;
    }

    void setDieSidesSides(int dieSides) { // Set..
        this.dieSidesSides.setImage(this.die[dieSides]);

    }

}