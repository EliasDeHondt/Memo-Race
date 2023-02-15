package be.kdg.memorace.view.GameBoard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardView extends BorderPane {
    // Attributes
    private Label playerName, gameTime;
    private Image go, path1, path2, path3, path4, path5, path6, path7, path8, path9, path10, path11, path12, path13, path14, path15, path16;
    private Image card1, card2, card3, card4, card5, card6, card7, card8;
    private Image die;
    // Constructors
    public GameBoardView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.playerName = new Label("(Player Name)"); // <- TEMP
        this.gameTime = new Label("(Game Time)"); // <- TEMP
        this.go = new Image("/path_0.png");
        this.path1 = new Image("/path_1.png");
        this.path2 = new Image("/path_2.png");
        this.path3 = new Image("/path_3.png");
        this.path4 = new Image("/path_4.png");
        this.path5 = new Image("/path_5.png");
        this.path6 = new Image("/path_6.png");
        this.path7 = new Image("/path_7.png");
        this.path8 = new Image("/path_8.png");
        this.path9 = new Image("/path_9.png");
        this.path10 = new Image("/path_10.png");
        this.path11 = new Image("/path_11.png");
        this.path12 = new Image("/path_12.png");
        this.path13 = new Image("/path_13.png");
        this.path14 = new Image("/path_14.png");
        this.path15 = new Image("/path_15.png");
        this.path16 = new Image("/path_16.png");
//        this.card1 = new Image("");
//        this.card2 = new Image("");
//        this.card3 = new Image("");
//        this.card4 = new Image("");
//        this.card5 = new Image("");
//        this.card6 = new Image("");
//        this.card7 = new Image("");
//        this.card8 = new Image("");
//        this.die = new Image("");
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
        // Set row 0
        gridGameBoard.add(new ImageView(this.go),0,0);
        gridGameBoard.add(new ImageView(this.path1),1,0);
        gridGameBoard.add(new ImageView(this.path2),2,0);
        gridGameBoard.add(new ImageView(this.path3),3,0);
        gridGameBoard.add(new ImageView(this.path4),4,0);
        // Set row 1
        gridGameBoard.add(new ImageView(this.path16),0,1);
        gridGameBoard.add(new ImageView(this.path5),5,1);
        // Set row 2
        gridGameBoard.add(new ImageView(this.path15),0,2);
        gridGameBoard.add(new ImageView(this.path6),5,2);
        // Set row 3
        gridGameBoard.add(new ImageView(this.path14),0,3);
        gridGameBoard.add(new ImageView(this.path7),5,3);
        // Set row 4
        gridGameBoard.add(new ImageView(this.path13),0,4);
        gridGameBoard.add(new ImageView(this.path8),5,4);
        // Set row 5
        gridGameBoard.add(new ImageView(this.path12),1,5);
        gridGameBoard.add(new ImageView(this.path11),2,5);
        gridGameBoard.add(new ImageView(this.path10),3,5);
        gridGameBoard.add(new ImageView(this.path9),4,5);






        setCenter(gridGameBoard); // TEMP
        // TODO
    }
}