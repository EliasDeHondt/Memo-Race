package be.kdg.memorace;

import static be.kdg.memorace.model.FileHandler.*;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.welcome.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main for the game.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class MainMemoRace extends Application {
    // Methods
    public static void main(String[] args) { // Main
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException { // Start
        Memorace model = new Memorace(); // Making Model(Memorace.class).

        WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
        new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        Scene scene = new Scene(welcomeView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setResizable(false); // Making Resizable False
        primaryStage.getIcons().add(new Image("/logo.png")); // Making Icon.
        primaryStage.setTitle("Memo-Race / Welcome"); // Making Title.
        welcomeView.setCustomStage(primaryStage); // Send primaryStage to (WelcomeView.class)

        writeStartUpLog("resources/log/startUpLog.txt", "Startup Time"); // Set log

        primaryStage.show(); // Show Stage.
    }
}