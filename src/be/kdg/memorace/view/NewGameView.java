package be.kdg.memorace.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGameView extends GridPane {
    // Attributes
    private Label howManyPlayers;
    private Label player1;
    private Label player2;
    private Label player3;
    private Label player4;
    private Label player5;
    private Label player6;
    private TextField player1Name;
    private TextField player2Name;
    private TextField player3Name;
    private TextField player4Name;
    private TextField player5Name;
    private TextField player6Name;
    private Image pawn1;
    private Image pawn2;
    private Image pawn3;
    private Image pawn4;
    private Image pawn5;
    private Image pawn6;
    private BorderPane bottom;
    private Button startGame;
    // Constructors
    public NewGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.howManyPlayers = new Label("How Many Players?");
        this.player1 = new Label("Player 1");
        this.player2 = new Label("Player 2");
        this.player3 = new Label("Player 3");
        this.player4 = new Label("Player 4");
        this.player5 = new Label("Player 5");
        this.player6 = new Label("Player 6");
        this.player1Name = new TextField();
        this.player2Name = new TextField();
        this.player3Name = new TextField();
        this.player4Name = new TextField();
        this.player5Name = new TextField();
        this.player6Name = new TextField();
        this.pawn1 = new Image("/pawn_1.png");
        this.pawn2 = new Image("/pawn_2.png");
        this.pawn3 = new Image("/pawn_3.png");
        this.pawn4 = new Image("/pawn_4.png");
        this.pawn5 = new Image("/pawn_5.png");
        this.pawn6 = new Image("/pawn_6.png");
        this.bottom = new BorderPane();
        this.startGame = new Button("Start Game");
    }
    public void layoutNodes() {
        // Set Padding (20)
        setPadding(new Insets(20));
        // Add (playerX) in to (GridPane)
        // column 0, row 0, column span 3, row span 1
        this.add(this.howManyPlayers,0,0,3,1);
        this.add(this.player1,0,1);
        this.add(this.player2,0,2);
        this.add(this.player3,0,3);
        this.add(this.player4,0,4);
        this.add(this.player5,0,5);
        this.add(this.player6,0,6);
        // Add (playerXName) in to (GridPane)
        this.add(this.player1Name,1,1);
        this.add(this.player2Name,1,2);
        this.add(this.player3Name,1,3);
        this.add(this.player4Name,1,4);
        this.add(this.player5Name,1,5);
        this.add(this.player6Name,1,6);
        // Add (pawnX) in to (GridPane)
        this.add(new ImageView(this.pawn1),2,1);
        this.add(new ImageView(this.pawn2),2,2);
        this.add(new ImageView(this.pawn3),2,3);
        this.add(new ImageView(this.pawn4),2,4);
        this.add(new ImageView(this.pawn5),2,5);
        this.add(new ImageView(this.pawn6),2,6);
        // Add (BorderPane) in to (GridPane)
        // column 0, row 7, column span 3, row span 1
        this.add(this.bottom,0,7,3,1);
        // Add (startGame) in to (GridPane)
        this.bottom.setCenter(this.startGame);
        // Set Hgap and Vgap to 10
        this.setHgap(10);
        this.setVgap(10);
        // CSS For (playNewGame) and (viewGameLog)
        this.howManyPlayers.setId("howManyPlayers");
        this.player1.setId("playerX");
        this.player2.setId("playerX");
        this.player3.setId("playerX");
        this.player4.setId("playerX");
        this.player5.setId("playerX");
        this.player6.setId("playerX");
        this.startGame.setId("startGame");
    }
    public TextField getPlayer1Name() { // Get..
        return this.player1Name;
    }
    public TextField getPlayer2Name() { // Get..
        return this.player2Name;
    }
    public TextField getPlayer3Name() { // Get..
        return this.player3Name;
    }
    public TextField getPlayer4Name() { // Get..
        return this.player4Name;
    }
    public TextField getPlayer5Name() { // Get..
        return this.player5Name;
    }
    public TextField getPlayer6Name() { // Get..
        return this.player6Name;
    }
    public Button getStartGame() { // Get..
        return this.startGame;
    }
}