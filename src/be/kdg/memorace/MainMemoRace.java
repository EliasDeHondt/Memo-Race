package be.kdg.memorace;

import static be.kdg.memorace.App.FileHandler.writeStartUpLog;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

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
        Memorace model = new Memorace(); // Making Model(GameBoard.class).
        WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
        new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        Scene scene = new Scene(welcomeView); // Making Scene.
        scene.getStylesheets().add("/style.css"); // CSS
        primaryStage.setScene(scene); // Making stage (scene).
        primaryStage.setResizable(false); // Making Resizable False
        primaryStage.getIcons().add(new Image("/question_mark.png")); // Making Icon.
        primaryStage.setTitle("Memo-Race / Welcome"); // Making Title.
        welcomeView.setCustomStage(primaryStage); // Send primaryStage to (WelcomeView.class)

        Media media = new Media(new File("resources/music/introductionMusic.wav").toURI().toString()); // set (Media)
        MediaPlayer player = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        player.play(); // Play media (introductionMusic.wav)

        writeStartUpLog("resources/log/startUpLog.csv", "Startup Time"); // Set log
        primaryStage.show(); // Show Stage.
    }
}