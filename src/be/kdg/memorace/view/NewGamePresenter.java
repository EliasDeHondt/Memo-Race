package be.kdg.memorace.view;

import be.kdg.memorace.model.GameBoard;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGamePresenter {
    // Attributes
    private GameBoard model;
    private NewGameView newGameView;
    // Constructors
    public NewGamePresenter(GameBoard model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        this.newGameView.getStartGame().setOnAction(actionEvent -> {
            GameBoardView gameBoardView = new GameBoardView(); // Making View (NewGameView.class).
            new GameBoardPresenter(this.model, gameBoardView); // Making Presenter (NewGamePresenter.class).
            this.newGameView.getScene().setRoot(gameBoardView); // Add (NewGameView.class) to (WelcomeView.class).
            gameBoardView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.newGameView.getCustomStage().setTitle("Memo-Race / Game Bord"); // Making Title (Memo-Race / Game Bord).
        });
    }
    private void updateView() {
        // TODO
    }
}