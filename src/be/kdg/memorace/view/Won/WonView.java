package be.kdg.memorace.view.Won;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WonView extends GridPane {
    // Attributes
    private Label playerName;
    private Label playerScore;
    // Constructors
    public WonView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    public void initialiseNodes() {
        this.playerName = new Label();
        this.playerScore = new Label();
    }
    public void layoutNodes() {
        // Set Padding (20)
        setPadding(new Insets(20));
        // Add (playNewGame) and (viewGameLog) in to (GridPane)
        this.add(this.playerName,1,0);
        this.add(this.playerScore,1,1);
        // Set Hgap and Vgap to 10
        this.setHgap(10);
        this.setVgap(10);
        // CSS For (playNewGame) and (viewGameLog)
        this.playerName.setId("labelNSL");
        this.playerScore.setId("labelNSL");
/*
        Media media = new Media(new File("resources/music/won.mp3").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        mediaPlayer.play(); // Play media (won.mp3)

 */
    }
    Label getPlayerName() { // Get..
        return this.playerName;
    }
    Label getPlayerScore() { // Get..
        return this.playerScore;
    }
}