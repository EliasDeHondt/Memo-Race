package be.kdg.memorace.view.Welcome;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private Button settings;
    private Button about;
    private Button exit;
    private Stage primaryStage;
    // Constructors
    public WelcomeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.logo = new Image("/question_mark.png");
        this.playNewGame = new Button("Play new game");
        this.viewGameLog = new Button("View game log");
        this.settings = new Button("  Settings   ");
        this.about = new Button("    About    ");
        this.exit = new Button("    Exit     ");
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
        this.add(this.settings,1,3);
        this.add(this.about,1,4);
        this.add(this.exit,1,5);
        // Set Vgap to 10
        this.setVgap(30);
        // CSS For (playNewGame), (viewGameLog), (about), (quit) and (this)
        this.playNewGame.setId("button");
        this.viewGameLog.setId("button");
        this.settings.setId("button");
        this.about.setId("button");
        this.exit.setId("button");
        this.setId("pane");
        // Causes all Node to appear with a delay.
        FadeTransition ft = new FadeTransition(Duration.millis(3000), this);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    Button getPlayNewGame() { // Get..
        return this.playNewGame;
    }
    Button getViewGameLog() { // Get..
        return this.viewGameLog;
    }
    Button getSettings() { // Get..
        return this.settings;
    }
    Button getAbout() { // Get..
        return this.about;
    }
    Button getExit() { // Get..
        return this.exit;
    }
    public void setCustomStage(Stage primaryStage){ // Set..
        this.primaryStage = primaryStage;
    }
    public Stage getCustomStage(){ // Get..
        return this.primaryStage;
    }
}