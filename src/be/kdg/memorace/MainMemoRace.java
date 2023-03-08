package be.kdg.memorace;

import static be.kdg.memorace.model.FileHandler.writeErrorLog;
import static be.kdg.memorace.model.FileHandler.writeStartUpLog;
import static be.kdg.memorace.model.MusicHandler.gameMusic;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

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
        gameMusic(0.5);// Play game Music

        try  {
            writeStartUpLog("resources/log/startUpLog.txt", "Startup Time"); // Set log
        } catch (IOException e1) {
            String errorMessage = "(writeStartUpLog) Our apologies, there seem to be an issue with our file system handler. :-(";
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(errorMessage);
            alert1.setTitle("File Handler ERROR");
            alert1.showAndWait();
            try {
                writeErrorLog("resources/log/errorLog.txt", errorMessage); // The file handler error will also be placed in a log.
            } catch (IOException e2) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setHeaderText("(writeErrorLog) Our apologies, there seem to be an issue with our file system handler. :-(");
                alert2.setTitle("File Handler ERROR");
                alert2.showAndWait();
            }
        }
        primaryStage.show(); // Show Stage.
    }
}