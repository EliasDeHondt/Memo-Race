package be.kdg.memorace.view.newGame;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The NewGameView class shows the window to select the players.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class NewGameView extends BorderPane {
    // Attributes
    private MenuItem miBack;
    private MenuItem miExit;
    private Label howManyPlayers;
    private final Label[] playerLabels;
    private final TextField[] playerTxt;
    private final Image[] pawnImages;
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
    private void initialiseNodes() {
        this.miBack = new MenuItem("Back");
        this.miExit = new MenuItem("Exit");

        this.howManyPlayers = new Label("How Many Players?");
        for (int i = 0; i < 6; i++) {
            this.playerLabels[i] = new Label("Player " + (i + 1));
        }
        for (int i = 0; i < 6; i++) {
            this.playerTxt[i] = new TextField();
        }
        for (int i = 0; i < 6; i++) {
            this.pawnImages[i] = new Image("/pawn_" + (i + 1) + ".png");
        }
        this.bottom = new BorderPane();
        this.startGame = new Button("Start Game");
    }

    private void layoutNodes() {
        GridPane gridPane = new GridPane();

        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack, this.miExit);
        MenuBar menuBar = new MenuBar(menu);

        this.setTop(menuBar);
        this.setCenter(gridPane);

        // CSS
        this.setId("pane");

        // Set Padding (20)
        gridPane.setPadding(new Insets(20));

        // Add (playerX) in to (GridPane)
        // column 0, row 1, column span 3, row span 1
        gridPane.add(this.howManyPlayers, 0, 1, 3, 1);

        for (int i = 0; i < 3; i++) {
            gridPane.add(this.playerLabels[i], 0, i + 2);
            gridPane.add(this.playerLabels[i + 3], 3, (i + 2));
        }

        // Add (playerXName) in to (GridPane)
        for (int i = 0; i < 3; i++) {
            gridPane.add(this.playerTxt[i], 1, i + 2);
            gridPane.add(this.playerTxt[i + 3], 4, i + 2);
        }

        // Add (pawnX) in to (GridPane)
        for (int i = 0; i < 3; i++) {
            gridPane.add(new ImageView(this.pawnImages[i]), 2, i + 2);
            gridPane.add(new ImageView(this.pawnImages[i + 3]), 6, i + 2);
        }

        // Add (BorderPane) in to (GridPane)
        // column 0, row 8, column span 7, row span 1
        gridPane.add(this.bottom, 0, 8, 7, 1);

        // Add (startGame) in to (GridPane)
        this.bottom.setCenter(this.startGame);

        // Set Hgap and Vgap to 10
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // CSS For (playNewGame) and (viewGameLog)
        this.howManyPlayers.setId("howManyPlayers");
        for (Label playerLabel : playerLabels) {
            playerLabel.setId("playerX");
        }
        this.startGame.setId("button");
    }

    MenuItem getMiBack() {
        return this.miBack;
    }

    MenuItem getMiExit() {
        return this.miExit;
    }

    TextField getPlayerName(int index) {
        return this.playerTxt[index];
    }

    TextField[] getPlayerTxt() {
        return this.playerTxt;
    }

    Button getStartGame() {
        return this.startGame;
    }

    public Stage getCustomStage() {
        return this.primaryStage;
    }

    public void setCustomStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}