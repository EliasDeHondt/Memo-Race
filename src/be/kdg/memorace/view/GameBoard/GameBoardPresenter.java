package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter {
    // Attributes
    private Memorace model;
    private GameBoardView gameBoardView;
    // Constructors
    public GameBoardPresenter(Memorace model, GameBoardView gameBoardView) {
        this.model = model;
        this.gameBoardView = gameBoardView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        // Event Click
        this.gameBoardView.getClick().setOnAction(actionEvent -> {
            Media media = new Media(new File("resources/music/click.wav").toURI().toString()); // set (Media)
            MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
            mediaPlayer.play(); // Play media (click.wav)

            // Roll the dice
            this.model.rollDice();
            // Set (model) Die Sides -> Die Sides (gameBoardView)
            this.gameBoardView.setDieSides(this.model.getDie().getSide());
        });
    }
    private void updateView() {
        this.gameBoardView.getPlayerName().setText(this.model.getPlayer().get(0).getName()); // Var 0 is TEMP TODO
    }
}