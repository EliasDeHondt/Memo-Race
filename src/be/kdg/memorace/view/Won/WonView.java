package be.kdg.memorace.view.Won;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The SettingsView class shows the window to select the players.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class WonView extends BorderPane {
    // Attributes
    private MenuItem miBack;
    private MenuItem miExit;
    private Label playerName;
    private Label playerScore;
    private Stage primaryStage;

    // Constructors
    public WonView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    public void initialiseNodes() {
        this.miBack = new MenuItem("Back");
        this.miExit = new MenuItem("Exit");

        this.playerName = new Label();
        this.playerScore = new Label();
    }

    private void layoutNodes() {
        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack, this.miExit);
        MenuBar menuBar = new MenuBar(menu);

        this.setTop(menuBar);

        GridPane gridPane = new GridPane();

        ImageView wonGIF = new ImageView(new Image("won.gif"));
        wonGIF.setFitWidth(400); // Nieuwe breedte
        wonGIF.setFitHeight(300); // Nieuwe hoogte

        this.setCenter(wonGIF);
        this.setBottom(gridPane);


        // Add (playNewGame) and (viewGameLog) in to (GridPane)
        gridPane.add(this.playerName, 0, 0);
        gridPane.add(this.playerScore, 0, 1);

        // Set Hgap and Vgap to 10
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // CSS For (playNewGame) and (viewGameLog)
        this.playerName.setId("labelNSL");
        this.playerName.setAlignment(Pos.CENTER);
        this.playerScore.setId("labelNSL");
        this.playerScore.setAlignment(Pos.CENTER);
        this.setId("pane");
    }

    MenuItem getMiBack() {
        return this.miBack;
    }

    MenuItem getMiExit() {
        return this.miExit;
    }

    Label getPlayerName() {
        return this.playerName;
    }

    Label getPlayerScore() {
        return this.playerScore;
    }

    public Stage getCustomStage() {
        return primaryStage;
    }

    public void setCustomStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}