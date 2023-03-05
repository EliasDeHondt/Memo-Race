package be.kdg.memorace.view.Settings;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;

import static be.kdg.memorace.app.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 5/03/2023
 */
public class SettingsPresenter {
    // Attributes
    private final Memorace model;
    private final SettingsView settingsView;
    // Constructors
    public SettingsPresenter(Memorace model, SettingsView settingsView) {
        this.model = model;
        this.settingsView = settingsView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        // Action-> [Back (welcomeView)] (getMiBack)
        this.settingsView.getMiBack().setOnAction(actionEvent -> {
            clickSound(); // Play sound when you click the button

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.settingsView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.settingsView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.settingsView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });

        // Action-> [Exit Game] (getMiExit)
        this.settingsView.getMiExit().setOnAction((e -> {
            clickSound(); // Play sound when you click the button

            Platform.exit(); // exit
        }));

        // Action-> [Save] (getSaveButton)
        this.settingsView.getSave().setOnAction((e -> {
            clickSound(); // Play sound when you click the button

            // TODO

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.settingsView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.settingsView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.settingsView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        }));

    }
}
