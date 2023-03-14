package be.kdg.memorace.view.Welcome;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.About.*;
import be.kdg.memorace.view.GameLog.*;
import be.kdg.memorace.view.NewGame.*;
import be.kdg.memorace.view.Settings.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static be.kdg.memorace.model.MusicHandler.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WelcomePresenter {
    // Attributes
    private final Memorace model;
    private final WelcomeView welcomeView;
    // Constructors
    public WelcomePresenter(Memorace model, WelcomeView welcomeView) {
        this.model = model;
        this.welcomeView = welcomeView;
        this.addEventHandlers();
        gameMusic(this.model.getVolumeBackground());// Play game Music
    }

    // Methods
    private void addEventHandlers() {
        // Action-> [Play New Game] (getPlayNewGame)
        this.welcomeView.getPlayNewGame().setOnAction((e -> {
           clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
            this.welcomeView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
            newGameView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / New Game"); // Making Title (Memo-Race / New Game).
            newGameView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (NewGameView.class)
            new NewGamePresenter(model, newGameView); // Making Presenter (NewGamePresenter.class).
        }));

        // Action-> [View Game Log] (getViewGameLog)
        this.welcomeView.getViewGameLog().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            GameLogView gameLogView = new GameLogView(); // Making View (GameLogView.class).
            this.welcomeView.getScene().setRoot(gameLogView); // Add (GameLogView.class) to (WelcomeView.class).
            gameLogView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / Game Log"); // Making Title (Memo-Race / Game Log).
            gameLogView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (GameLogView.class)
            new GameLogPresenter(model, gameLogView); // Making Presenter (GameLogPresenter.class).
        }));

        // Action-> [Settings] (getSettings)
        this.welcomeView.getSettings().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            SettingsView settingsView = new SettingsView(); // Making View (SettingsView.class).
            this.welcomeView.getScene().setRoot(settingsView); // Add (SettingsView.class) to (WelcomeView.class).
            settingsView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / Settings"); // Making Title (Memo-Race / Game Log).
            settingsView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (SettingsView.class)
            new SettingsPresenter(model, settingsView); // Making Presenter (GameLogPresenter.class).
        }));

        // Action-> [About] (getAbout)
        this.welcomeView.getAbout().setOnAction(event -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            AboutView aboutView = new AboutView();
            new AboutPresenter(model, aboutView);
            Stage aboutStage = new Stage();
            aboutStage.initOwner(this.welcomeView.getScene().getWindow());
            aboutStage.initModality(Modality.APPLICATION_MODAL); // Gebonden venster!
            Scene scene = new Scene(aboutView); // New scene
            scene.getStylesheets().add("/style.css"); // CSS
            aboutStage.setScene(scene); // Set new stage
            aboutStage.getIcons().add(new Image("/logo.png")); // Making Icon.
            aboutStage.setTitle("Memo-Race / About"); // Making Title.
            aboutStage.showAndWait();
        });

        // Action-> [Exit Game] (getExit)
        this.welcomeView.getExit().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button
            Platform.exit(); // exit
        }));
    }
}