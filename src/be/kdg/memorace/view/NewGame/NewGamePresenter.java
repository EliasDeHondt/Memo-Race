package be.kdg.memorace.view.NewGame;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.GameBoard.GameBoardPresenter;
import be.kdg.memorace.view.GameBoard.GameBoardView;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class NewGamePresenter {
    // Attributes
    private Memorace model;
    private NewGameView newGameView;
    // Constructors
    public NewGamePresenter(Memorace model, NewGameView newGameView) {
        this.model = model;
        this.newGameView = newGameView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        this.newGameView.getStartGame().setOnAction(actionEvent -> {
            GameBoardView gameBoardView = new GameBoardView(); // Making View (NewGameView.class).
            new GameBoardPresenter(this.model, gameBoardView); // Making Presenter (NewGamePresenter.class).
            this.newGameView.getScene().setRoot(gameBoardView); // Add (NewGameView.class) to (WelcomeView.class).
            gameBoardView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.newGameView.getCustomStage().setTitle("Memo-Race / Game Bord"); // Making Title (Memo-Race / Game Bord).
            updateView();
        });
    }
    private void updateView() {
        // This four loop is responsible for the six players.
        for (int i = 1; i <= this.newGameView.getPlayerTxt().length-1; i++) {
            // Takes the player name from the view and puts it in a variable.
            String playerName = this.newGameView.getPlayerName(i).getText();
            // If the variable is not empty, it will be added to the player list.
            if (!playerName.isEmpty()) {
                this.model.setPlayer(playerName);
            }
        }
    }
}











