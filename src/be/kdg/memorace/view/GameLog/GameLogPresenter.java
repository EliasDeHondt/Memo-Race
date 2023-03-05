package be.kdg.memorace.view.GameLog;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;

import static be.kdg.memorace.app.MusicHandler.clickSound;

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

