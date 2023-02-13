package be.kdg.memorace.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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
        this.quit = new Button("Quit");
    }
    public void layoutNodes() {
        // Set Padding (20)
        setPadding(new Insets(20));
        // Add (playNewGame) and (viewGameLog) in to (GridPane)
        this.add(this.playNewGame,1,0);
        this.add(this.viewGameLog,1,1);
        // Set Hgap and Vgap to 10
        this.setHgap(10);
        this.setVgap(10);
        // CSS For (playNewGame) and (viewGameLog)
        this.playNewGame.setId("buttonNGQB");
        this.viewGameLog.setId("buttonNGQB");
        this.quit.setId("buttonNGQB");
    }
}
