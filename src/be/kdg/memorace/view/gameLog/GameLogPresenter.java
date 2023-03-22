package be.kdg.memorace.view.gameLog;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.welcome.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.model.FileHandler.*;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * The GameLogPresenter class that is a presenter for the GameLogView window.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class GameLogPresenter {
    // Attributes
    private final Memorace model;
    private final GameLogView gameLogView;

    // Constructors
    public GameLogPresenter(Memorace model, GameLogView gameLogView) {
        this.model = model;
        this.gameLogView = gameLogView;
        this.addEventHandlers();

        try {
            // Read log in to (this.startUpLog)
            String[] linesStartUp = readLog("resources/log/startUpLog.txt");
            for (String line : linesStartUp) {
                this.gameLogView.getStartUpLog().appendText(line + "\n");
            }

            // Read log in to (this.errorLog)
            String[] linesError = readLog("resources/log/errorLog.txt");
            for (String line : linesError) {
                this.gameLogView.getErrorLog().appendText(line + "\n");
            }

        } catch (IOException e1) {
            String errorMessage = "(readLog) Our apologies, there seem to be an issue with our file system handler. :-(";
            showAlert(errorMessage);
            try {
                writeErrorLog("resources/log/errorLog.txt", errorMessage); // The file handler error will also be placed in a log.
            } catch (IOException e2) {
                showAlert("(writeErrorLog) Our apologies, there seem to be an issue with our file system handler. :-(");
                showAlert(errorMessage);
            }
        }

    }

    // Methods
    private void addEventHandlers() {
        // Action-> [Back (welcomeView)] (getMiBack)
        this.gameLogView.getMiBack().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.gameLogView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.gameLogView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.gameLogView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });

        // Action-> [Exit Game] (getMiExit)
        this.gameLogView.getMiExit().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            Platform.exit(); // exit
        }));
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(text);
        alert.setTitle("File Handler ERROR");
        alert.showAndWait();
    }
}