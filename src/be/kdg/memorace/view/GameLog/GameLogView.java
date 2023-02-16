package be.kdg.memorace.view.GameLog;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import static be.kdg.memorace.model.App.FileHandler.readLog;

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


        // Read log
        String[] lines = readLog("resources/log/startUpLog.csv");
        for (String line : lines) {
            this.log.setText(line);

            System.out.println(line);
        }
    }
}
