package be.kdg.memorace.view.GameLog;

import be.kdg.memorace.model.App.FileHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 * Van Elias De Hondt
 * 15/02/2023
 */
public class GameLogView extends BorderPane {
    // Attributes
    private TextArea log;

    // Constructors
    public GameLogView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.log = new TextArea();
    }
    public void layoutNodes() {
        // Set TextArea (this.log) in Center
        setCenter(this.log);
        // Print log in to (this.log)


        // TEMP
        for (int i = 0; i <= 4; i++) {
            String[] regelData = FileHandler.readFile("resources/log/players.csv", i);
            assert regelData != null;
            int score = Integer.parseInt(regelData[1]);
            this.log.setText(regelData[0] + " " + score);
        }
    }
}
