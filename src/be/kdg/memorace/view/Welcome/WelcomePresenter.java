package be.kdg.memorace.view.Welcome;

import be.kdg.memorace.model.GameBoard;
import be.kdg.memorace.view.GameLog.GameLogView;
import be.kdg.memorace.view.NewGame.NewGamePresenter;
import be.kdg.memorace.view.NewGame.NewGameView;
import javafx.application.Platform;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WelcomePresenter {
    // Attributes
    private GameBoard model;
    private WelcomeView welcomeView;
    // Constructors
    public WelcomePresenter(GameBoard model, WelcomeView welcomeView) {
        this.model = model;
        this.welcomeView = welcomeView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        // Action-> [Play New Game] (getPlayNewGame)
        this.welcomeView.getPlayNewGame().setOnAction((e -> {
            NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
            new NewGamePresenter(model, newGameView); // Making Presenter (NewGamePresenter.class).
            this.welcomeView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
            newGameView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / New Game"); // Making Title (Memo-Race / New Game).
            newGameView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (NewGameView.class)
        }));
        // Action-> [View Game Log] (getViewGameLog)
        this.welcomeView.getViewGameLog().setOnAction((e -> {
            GameLogView gameLogView = new GameLogView(); // Making View (GameLogView.class).
            this.welcomeView.getScene().setRoot(gameLogView); // Add (GameLogView.class) to (WelcomeView.class).
            gameLogView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / Game Log"); // Making Title (Memo-Race / Game Log).
        }));
        // Action-> [Exit Game] (getQuit)
        this.welcomeView.getQuit().setOnAction((e -> {
            Platform.exit(); // exit
        }));
    }
    private void updateView() {
        // TODO
    }
}