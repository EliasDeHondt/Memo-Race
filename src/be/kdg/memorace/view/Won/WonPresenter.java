package be.kdg.memorace.view.Won;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.model.FileHandler.writePlayersLog;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 13/02/2023
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

//        this.wonView.getPlayerName().setText(this.model.winner().getName());
//        this.wonView.getPlayerScore().setText(String.format("%d",this.model.winner().getScore()));
        this.wonView.getPlayerName().setText("TEST--------------");
        this.wonView.getPlayerScore().setText("TEST--------------");


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
