package be.kdg.memorace.view.Won;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.model.FileHandler.writePlayersLog;
import static be.kdg.memorace.model.MusicHandler.*;

/**
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class WonPresenter {
    // Attributes
    private final Memorace model;
    private final WonView wonView;

    // Constructors
    public WonPresenter(Memorace model, WonView wonView) {
        this.model = model;
        this.wonView = wonView;
        this.addEventHandlers();

        this.model.getMusicHandler().getBackgroundMusic().pause();
        wonMusic(1.0);
    }

    // Methods
    private void addEventHandlers() {
        // Action-> [Back (welcomeView)] (getMiBack)
        this.wonView.getMiBack().setOnAction(actionEvent -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.wonView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.wonView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.wonView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });

        // Action-> [Exit Game] (getMiExit)
        this.wonView.getMiExit().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            Platform.exit(); // exit
        }));

        this.wonView.getPlayerName().setText(String.format("Name: %s", this.model.winner().getName()));
        this.wonView.getPlayerScore().setText(String.format("Score: %d", this.model.winner().getScore()));


        try {
            writePlayersLog("resources/log/playerLog.csv", this.model.getplayers());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("(writePlayersLog) Our apologies, there seem to be an issue with our file system handler. :-(");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
        }

    }
}