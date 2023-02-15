package be.kdg.memorace.view;

import be.kdg.memorace.MainMemoRace;
import be.kdg.memorace.model.GameBoard;
import javafx.scene.Scene;

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
        welcomeView.setPrefWidth(900);

        this.welcomeView.getPlayNewGame().setOnAction((e -> {

            NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
            new NewGamePresenter(this.model, newGameView); // Making Presenter (NewGamePresenter.class).

            welcomeView.getScene().setRoot(newGameView);
            newGameView.getScene().getWindow().sizeToScene();

            // TODO
        }));
        // Action-> [View Game Log] (getViewGameLog)
        this.welcomeView.getViewGameLog().setOnAction((e -> {
            // TODO
        }));
        // Action-> [Exit Game] (getQuit)
        this.welcomeView.getQuit().setOnAction((e -> {
            System.exit(0);
        }));
    }
    private void updateView() {
        // TODO
    }
}