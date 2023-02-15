package be.kdg.memorace;

import be.kdg.memorace.model.GameBoard;
import be.kdg.memorace.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class MainMemoRace extends Application {
    // Attributes
    private final GameBoard model = new GameBoard(); // Making Model(GameBoard.class).
    // Methods
    public static void main(String[] args) { // Main
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) { // Start
        primaryStage.setResizable(false); // Making Resizable False
        primaryStage.getIcons().add(new Image("/question_mark.png")); // Making Icon.

        this.welcomePV(primaryStage);
//        this.newGamePV(primaryStage);
//        this.gameBoardPV(primaryStage);
//        this.wonPV(primaryStage);
    }
    public void welcomePV(Stage primaryStage) {
        WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
        new WelcomePresenter(this.model, welcomeView); // Making Presenter (WelcomePresenter.class).
        Scene scene = new Scene(welcomeView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setTitle("Memo-Race / Welcome"); // Making Title.
        primaryStage.show(); // Show Stage.
    }
    public void newGamePV(Stage primaryStage) {
        NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
        new NewGamePresenter(this.model, newGameView); // Making Presenter (NewGamePresenter.class).
        Scene scene = new Scene(newGameView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setTitle("Memo-Race / New Game"); // Making Title.
        primaryStage.show(); // Show Stage.
    }
    public void gameBoardPV(Stage primaryStage) {
        GameBoardView gameBoardView = new GameBoardView(); // Making View (gameBoardView.class).
        new GameBoardPresenter(this.model, gameBoardView); // Making Presenter (GameBoardPresenter.class).
        Scene scene = new Scene(gameBoardView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setTitle("Memo-Race / Game Board"); // Making Title.
        primaryStage.show(); // Show Stage.
    }
    public void wonPV(Stage primaryStage) {
        WonView wonView = new WonView(); // Making View (WonView.class).
        new WonPresenter(this.model, wonView); // Making Presenter (WonPresenter.class).
        Scene scene = new Scene(wonView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setTitle("Memo-Race / Won"); // Making Title.
        primaryStage.show(); // Show Stage.
    }
}