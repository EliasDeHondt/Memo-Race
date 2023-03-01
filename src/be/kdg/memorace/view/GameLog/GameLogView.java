package be.kdg.memorace.view.GameLog;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import static be.kdg.memorace.app.FileHandler.readLog;

/**
 * Van Elias De Hondt
 * 15/02/2023
 */
public class GameLogView extends BorderPane {
    // Attributes
    private Menu miBack;
    private TextArea startUpLog;
    private TextArea errorLog;
    // Constructors
    public GameLogView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    public void initialiseNodes() {
        this.startUpLog = new TextArea();
        this.errorLog = new TextArea();
    }
    public void layoutNodes() {
        // Menu opbouwen:
        this.miBack = new Menu("Back");
        MenuBar menuBar = new MenuBar(this.miBack);
        this.setTop(menuBar);

        // Set the text areas to be read-only
        this.startUpLog.setEditable(false);
        this.errorLog.setEditable(false);

        // Set TextArea (this.startUpLog) in Left
        setLeft(this.startUpLog);

        // Set TextArea (this.errorLog) in Right
        setRight(this.errorLog);
        setPrefSize(600,600);

        // Read log in to (this.startUpLog)
        String[] linesStartUp = readLog("resources/log/startUpLog.txt");
        assert linesStartUp != null;
        for (String line : linesStartUp) {
            this.startUpLog.appendText(line + "\n");
        }

        // Read log in to (this.errorLog)
        String[] linesError = readLog("resources/log/errorLog.txt");
        assert linesError != null;
        for (String line : linesError) {
            this.errorLog.appendText(line + "\n");
        }
    }
}
