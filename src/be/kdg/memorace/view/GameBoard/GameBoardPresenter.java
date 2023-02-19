package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    }
    // Methods
    private void addEventHandlers() {
        // Get the die images from the view
        Image[] dieImages = gameBoardView.getDie();

        // Add an action to the ImageView of the die
        ImageView dieImageView = new ImageView(this.gameBoardView.getPrimaryDieImage());

        dieImageView.setOnMouseClicked(event -> {
            // Roll the die
            this.model.rollDice();
            // Get the die
            int dieSide = this.model.getDie().getSide();
            // Set new image on action
            dieImageView.setImage(dieImages[dieSide]);
            // Update View
            this.gameBoardView.setPrimaryDieImage(dieImages[dieSide]);
        });
    }
    private void updateView() {
        // TODO
    }
}