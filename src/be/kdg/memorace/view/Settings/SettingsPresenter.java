package be.kdg.memorace.view.Settings;
import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.*;
import javafx.application.Platform;
import static be.kdg.memorace.model.MusicHandler.clickSound;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
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
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.settingsView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.settingsView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.settingsView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });

        // Action-> [Exit Game] (getMiExit)
        this.settingsView.getMiExit().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            Platform.exit(); // exit
        }));

        // Action-> [Save] (getSaveButton)
        this.settingsView.getSave().setOnAction((e -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button

            // Get the values of backgroundSoundS and buttonSoundS
            double volumeBackground = this.settingsView.getBackgroundSoundS().getValue();
            double volumeButton = this.settingsView.getButtonSoundS().getValue();
            String cardTheme = this.settingsView.getTheme().getValue();

            // Pass the values to the MusicHandler methods
            this.model.setVolumeBackground(volumeBackground);
            this.model.setVolumeButton(volumeButton);

            // Pass the values to the Memorace Class
            this.model.setCardTheme(cardTheme);

            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.settingsView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.settingsView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.settingsView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        }));
    }
}
