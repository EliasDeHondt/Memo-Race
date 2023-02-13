package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Van Elias De Hondt
 * 13/02/2023
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