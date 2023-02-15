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
    // Methods
    public static void main(String[] args) { // Main
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) { // Start
        GameBoard model = new GameBoard(); // Making Model(GameBoard.class).
        WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
        new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        Scene scene = new Scene(welcomeView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setResizable(false); // Making Resizable False
        primaryStage.getIcons().add(new Image("/question_mark.png")); // Making Icon.
        primaryStage.setTitle("Memo-Race / Welcome"); // Making Title.
        welcomeView.setCustomStage(primaryStage); // Send primaryStage to (WelcomeView.class)
        primaryStage.show(); // Show Stage.
    }
}