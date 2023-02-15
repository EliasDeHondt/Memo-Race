package be.kdg.memorace.view.NewGame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class NewGameView extends GridPane {
    // Attributes
    private Label howManyPlayers;
    private Label[] playerLabels;
    private TextField[] playerTxt;
    private Image[] pawnImages;
    private BorderPane bottom;
    private Button startGame;
    private Stage primaryStage;
    // Constructors
    public NewGameView() {
        playerLabels = new Label[6];
        playerTxt = new TextField[6];
        pawnImages = new Image[6];

        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.howManyPlayers = new Label("How Many Players?");
        for (int i = 0; i < 6; i++) {
            this.playerLabels[i] = new Label("Player " + (i+1));
        }
        for (int i = 0; i < 6; i++) {
            this.playerTxt[i] = new TextField();
        }
        for (int i = 0; i < 6; i++) {
            this.pawnImages[i] = new Image("/pawn_" + (i+1) + ".png");
        }
        this.bottom = new BorderPane();
        this.startGame = new Button("Start Game");
    }
    public void layoutNodes() {
        setId("pane");
        // Set Padding (20)
        setPadding(new Insets(20));
        // Add (playerX) in to (GridPane)
        // column 0, row 0, column span 3, row span 1
        this.add(this.howManyPlayers,0,0,3,1);
        for (int i = 0; i < 3; i++) {
            this.add(playerLabels[i],0,i+1);
            this.add(playerLabels[i+3],3,(i+1));
        }

        // Add (playerXName) in to (GridPane)
        for (int i = 0; i < 3; i++) {
            this.add(playerTxt[i],1,i+1);
        }
        for (int i = 3; i < 6; i++) {
            this.add(playerTxt[i],4,(i-2));
        }

        // Add (pawnX) in to (GridPane)
        for (int i = 0; i < 3; i++) {
            this.add(new ImageView(pawnImages[i]),2,i+1);
        }
        for (int i = 3; i < 6; i++) {
            this.add(new ImageView(pawnImages[i]),6,(i-2));
        }
        // Add (BorderPane) in to (GridPane)
        // column 0, row 7, column span 7, row span 1
        this.add(this.bottom,0,7,7,1);
        // Add (startGame) in to (GridPane)
        this.bottom.setCenter(this.startGame);
        // Set Hgap and Vgap to 10
        this.setHgap(10);
        this.setVgap(10);
        // CSS For (playNewGame) and (viewGameLog)
        this.howManyPlayers.setId("howManyPlayers");
        for (Label playerLabel : playerLabels) {
            playerLabel.setId("playerX");
        }
        this.startGame.setId("startGame");
    }
    public TextField getPlayer1Name() { // Get..
        return playerTxt[0];
    }
    public TextField getPlayer2Name() { // Get..
        return playerTxt[1];
    }
    public TextField getPlayer3Name() { // Get..
        return playerTxt[2];
    }
    public TextField getPlayer4Name() { // Get..
        return playerTxt[3];
    }
    public TextField getPlayer5Name() { // Get..
        return playerTxt[4];
    }
    public TextField getPlayer6Name() { // Get..
        return playerTxt[6];
    }
    public Button getStartGame() { // Get..
        return this.startGame;
    }
    public void setCustomStage(Stage primaryStage){ // Set..
        this.primaryStage = primaryStage;
    }
    public Stage getCustomStage(){ // Get..
        return this.primaryStage;
    }
}