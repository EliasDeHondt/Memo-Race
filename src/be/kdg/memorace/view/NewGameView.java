package be.kdg.memorace.view;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class NewGameView extends GridPane {
    // Attributes
    private Button playNewGame;
    private Button viewGameLog;
    // Constructors
    public NewGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes(){
        this.playNewGame = new Button("Play new game");
        this.viewGameLog = new Button("View game log");
    }
    public void layoutNodes(){
        // Set Padding (20)
        setPadding(new Insets(20));
        // Add (playNewGame) and (viewGameLog) in to (GridPane)
        this.add(this.playNewGame,1,0);
        this.add(this.viewGameLog,1,1);
        //
        this.setHgap(10);
        this.setVgap(10);
        // CSS
        this.playNewGame.setStyle("""
                                  -fx-background-color: #4F94F0;
                                  -fx-font-size: 28px;
                                  -fx-color: #FFFFFF;
                                  -fx-padding: 20px;
                                  -fx-width: 200px;
                                  """);
        this.viewGameLog.setStyle("""
                                  -fx-background-color: #4F94F0;
                                  -fx-font-size: 28px;
                                  -fx-color: #FFFFFF;
                                  -fx-padding: 20px;
                                  -fx-width: 200px;
                                  """);
    }
}
