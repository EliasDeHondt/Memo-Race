package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

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
            new NewGamePresenter(this.model, newGameView); // Making Presenter (NewGamePresenter.class).
            welcomeView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
            newGameView.getScene().getWindow().sizeToScene(); // Add new Scene.
            welcomeView.getCustomStage().setTitle("Memo-Race / New Game");
        }));
        // Action-> [View Game Log] (getViewGameLog)
        this.welcomeView.getViewGameLog().setOnAction((e -> {
            welcomeView.getCustomStage().setTitle("Memo-Race / Game Log");
            // TODO
        }));
        // Action-> [Exit Game] (getQuit)
        this.welcomeView.getQuit().setOnAction((e -> {
            System.exit(0); // exit
        }));
    }
    private void updateView() {
        // TODO
    }
}