package be.kdg.memorace.view.GameLog;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.Welcome.WelcomePresenter;
import be.kdg.memorace.view.Welcome.WelcomeView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Van Elias De Hondt
 * 1/03/2023
 */
public class GameLogPresenter {
    // Attributes
    private Memorace model;
    private GameLogView gameLogView;
    // Constructors
    public GameLogPresenter(Memorace model, GameLogView gameLogView) {
        this.model = model;
        this.gameLogView = gameLogView;
        this.addEventHandlers();
        this.updateView();
    }

    // Methods
    private void addEventHandlers() {
        this.gameLogView.getMiBack().setOnAction(actionEvent -> {
            WelcomeView welcomeView = new WelcomeView(); // Making View (WelcomeView.class).
            this.gameLogView.getScene().setRoot(welcomeView); // Add (WelcomeView.class) to (GameLogView.class).
            welcomeView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.gameLogView.getCustomStage().setTitle("Memo-Race / Welcome"); // Making Title (Memo-Race / Welcome).
            welcomeView.setCustomStage(this.gameLogView.getCustomStage());  // Send primaryStage to (WelcomeView.class)
            new WelcomePresenter(model, welcomeView); // Making Presenter (WelcomePresenter.class).
        });
        // Action-> [Exit Game] (getMiExit)
        this.gameLogView.getMiExit().setOnAction((e -> {
            Platform.exit(); // exit
        }));

    }
    private void updateView() {

    }
}

