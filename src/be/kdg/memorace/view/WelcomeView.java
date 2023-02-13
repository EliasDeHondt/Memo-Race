package be.kdg.memorace.view;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WelcomeView extends GridPane {
    // Attributes
    private Button playNewGame;
    private Button viewGameLog;
    private Button quit;
    // Constructors
    public WelcomeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.playNewGame = new Button("Play new game");
        this.viewGameLog = new Button("View game log");
        this.quit = new Button("    Quit     ");
    }
    public void layoutNodes() {
        // Set Padding (20)
        setPadding(new Insets(50));
        // Add (playNewGame) and (viewGameLog) and (quit) in to (GridPane)
        this.add(this.playNewGame,1,0);
        this.add(this.viewGameLog,1,1);
        this.add(this.quit,1,2);
        // Set Vgap to 10
        this.setVgap(30);
        // CSS For (playNewGame) and (viewGameLog) and (quit) and (this)
        this.playNewGame.setId("buttonWelcome");
        this.viewGameLog.setId("buttonWelcome");
        this.quit.setId("buttonWelcome");
        this.setId("pane");
        // Causes all Node to appear with a delay.
        FadeTransition ft = new FadeTransition(Duration.millis(3000), this);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    public Button getPlayNewGame() { // Get..
        return this.playNewGame;
    }
    public Button getViewGameLog() { // Get..
        return this.viewGameLog;
    }
    public Button getQuit() { // Get..
        return this.quit;
    }
}