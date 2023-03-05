package be.kdg.memorace;

import static be.kdg.memorace.app.FileHandler.writeStartUpLog;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.PresenterInterface;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class MainMemoRace extends Application implements PresenterInterface {
    // Methods
    public static void main(String[] args) { // Main
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) { // Start
        Memorace model = new Memorace(); // Making Model(GameBoard.class).
        WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
        new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        Scene scene = new Scene(welcomeView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setResizable(false); // Making Resizable False
        primaryStage.getIcons().add(new Image("/logo.png")); // Making Icon.
        primaryStage.setTitle("Memo-Race / Welcome"); // Making Title.
        welcomeView.setCustomStage(primaryStage); // Send primaryStage to (WelcomeView.class)
        // gameMusic();// Play game Music
        writeStartUpLog("resources/log/startUpLog.txt", "Startup Time"); // Set log
        primaryStage.show(); // Show Stage.
    }
}