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
        this.playerLabels = new Label[6];
        this.playerTxt = new TextField[6];
        this.pawnImages = new Image[6];

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
        // CSS
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
            this.add(playerTxt[i+3],4,i+1);
        }

        // Add (pawnX) in to (GridPane)
        for (int i = 0; i < 3; i++) {
            this.add(new ImageView(pawnImages[i]),2,i+1);
            this.add(new ImageView(pawnImages[i+3]),6,i+1);
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
        this.startGame.setId("button");
    }
    public TextField getPlayerName(int index) { // Get..
        return this.playerTxt[index];
    }

    public TextField[] getPlayerTxt() { // Get..
        return this.playerTxt;
    }

    public Button getStartGame() { // Get..
        return this.startGame;
    }
    public Stage getCustomStage(){ // Get..
        return this.primaryStage;
    }

    public void setCustomStage(Stage primaryStage){ // Set..
        this.primaryStage = primaryStage;
    }

    public void setPlayerTxt(TextField[] playerTxt) {
        this.playerTxt = playerTxt;
    }
}