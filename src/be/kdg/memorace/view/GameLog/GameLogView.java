package be.kdg.memorace.view.GameLog;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Vera Wise & Elias De Hondt
 * 08/12/2022
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
        menu.getItems().addAll(this.miBack,this.miExit);
        MenuBar menuBar = new MenuBar(menu);
        this.setTop(menuBar);

        // Set the text areas to be read-only
        this.startUpLog.setEditable(false);
        this.errorLog.setEditable(false);

        // Set TextArea (this.startUpLog) in Left
        setLeft(this.startUpLog);

        // Set TextArea (this.errorLog) in Right
        setRight(this.errorLog);
        setPrefSize(600,600);
    }

    MenuItem getMiBack() { // Get..
        return this.miBack;
    }
    MenuItem getMiExit() { // Get..
        return this.miExit;
    }
    public void setCustomStage(Stage primaryStage){ // Set..
        this.primaryStage = primaryStage;
    }
    public Stage getCustomStage(){ // Get..
        return this.primaryStage;
    }
    TextArea getStartUpLog() { // Get
        return this.startUpLog;
    }
    TextArea getErrorLog() { // Get
        return this.errorLog;
    }
}