package be.kdg.memorace.view.Won;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
        this.playerName = new Label("(Player Name) Won."); // <- TEMP
        this.playerScore = new Label("(Player Score)"); // <- TEMP
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
    }
    public Label getPlayerName() { // Get..
        return this.playerName;
    }
    public Label getPlayerScore() { // Get..
        return this.playerScore;
    }
}