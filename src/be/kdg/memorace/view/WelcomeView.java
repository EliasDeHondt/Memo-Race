package be.kdg.memorace.view;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WelcomeView extends GridPane {
    // Attributes
    private Image logo;
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
        this.logo = new Image("/logo.png");
        this.playNewGame = new Button("Play new game");
        this.viewGameLog = new Button("View game log");
        this.quit = new Button("    Quit     ");
    }
    public void layoutNodes() {
        // Set Padding (20)
        setPadding(new Insets(60));
        // Creating the top layer of the screen to place the logo in.
        VBox top = new VBox(new ImageView(this.logo));
        top.setAlignment(Pos.CENTER);
        // Add (top), (playNewGame), (viewGameLog) and (quit) in to (GridPane)
        this.add(top,1,0);
        this.add(this.playNewGame,1,1);
        this.add(this.viewGameLog,1,2);
        this.add(this.quit,1,3);
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