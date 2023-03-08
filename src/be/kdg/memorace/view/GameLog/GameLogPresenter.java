package be.kdg.memorace.view.GameLog;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.model.FileHandler.readLog;
import static be.kdg.memorace.model.FileHandler.writeErrorLog;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 1/03/2023
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
}

