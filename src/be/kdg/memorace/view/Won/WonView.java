package be.kdg.memorace.view.Won;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WonView extends BorderPane {
    private MenuItem miBack;
    private MenuItem miExit;
    // Attributes
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
    public void layoutNodes() {
        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack,this.miExit);
        MenuBar menuBar = new MenuBar(menu);

        this.setTop(menuBar);

        GridPane gridPane = new GridPane();

        ImageView wonGIF = new ImageView(new Image("won.gif"));
        wonGIF.setFitWidth(400); // Nieuwe breedte
        wonGIF.setFitHeight(300); // Nieuwe hoogte

        this.setCenter(wonGIF);
        this.setBottom(gridPane);



        // Add (playNewGame) and (viewGameLog) in to (GridPane)
        gridPane.add(this.playerName,0,0);
        gridPane.add(this.playerScore,0,1);

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
    MenuItem getMiBack() { // Get
        return this.miBack;
    }
    MenuItem getMiExit() { // Get
        return this.miExit;
    }
    Label getPlayerName() { // Get..
        return this.playerName;
    }
    Label getPlayerScore() { // Get..
        return this.playerScore;
    }
    public Stage getCustomStage() { // Get..
        return primaryStage;
    }
    public void setCustomStage(Stage primaryStage) { // Set..
        this.primaryStage = primaryStage;
    }
}