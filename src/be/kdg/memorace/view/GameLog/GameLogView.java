package be.kdg.memorace.view.GameLog;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class GameLogView extends BorderPane {
    // Attributes
    private MenuItem miBack;
    private MenuItem miExit;
    private TextArea startUpLog;
    private TextArea errorLog;
    private Stage primaryStage;

    // Constructors
    public GameLogView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    public void initialiseNodes() {
        this.miBack = new MenuItem("Back");
        this.miExit = new MenuItem("Exit");
        this.startUpLog = new TextArea();
        this.errorLog = new TextArea();
    }

    public void layoutNodes() {
        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack, this.miExit);
        MenuBar menuBar = new MenuBar(menu);
        this.setTop(menuBar);

        // Set the text areas to be read-only
        this.startUpLog.setEditable(false);
        this.errorLog.setEditable(false);

        // Set TextArea (this.startUpLog) in Left
        this.setLeft(this.startUpLog);

        // Set TextArea (this.errorLog) in Right
        this.setRight(this.errorLog);
        this.setPrefSize(600, 600);
    }

    MenuItem getMiBack() {
        return this.miBack;
    }

    MenuItem getMiExit() {
        return this.miExit;
    }

    TextArea getStartUpLog() {
        return this.startUpLog;
    }

    TextArea getErrorLog() {
        return this.errorLog;
    }

    public void setCustomStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getCustomStage() {
        return this.primaryStage;
    }
}