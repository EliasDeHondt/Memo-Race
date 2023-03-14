package be.kdg.memorace.view.Won;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

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
        this.playerScore.setId("labelNSL");
        this.setId("pane");

        Media media = new Media(new File("resources/music/won.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        mediaPlayer.play(); // Play media (won.mp3)

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