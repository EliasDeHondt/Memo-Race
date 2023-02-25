package be.kdg.memorace.view.GameBoard;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.model.Player;
import be.kdg.memorace.view.PresenterInterface;
import javafx.scene.image.Image;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class GameBoardPresenter implements PresenterInterface {
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
        this.model.Turn();
        Player player = this.model.Turn();
        this.gameBoardView.getPlayerName().setText(player.getName());

        this.gameBoardView.getDieButton().setOnAction(actionEvent -> {
            //clickSound(); // Play sound when you click the button

            // Roll the dice
            this.model.getDie().rollDie();

            Player player1 = this.model.Turn();
            this.gameBoardView.getPlayerName().setText(player1.getName());

            updateView();
        });

        this.gameBoardView.getCards()[0].setOnMouseClicked(
                mouseEvent -> {
                    System.out.println("aaaaaaaaaaaa");
                    this.gameBoardView.getCards()[0].setImage(new Image ("/logo.png"));
                });

    }
    private void updateView() {

        int ogen1 = model.getDie().getSide();
        switch (ogen1) {
            case 1 -> gameBoardView.getDieImg().setImage(new Image("/die_1.png"));
            case 2 -> gameBoardView.getDieImg().setImage(new Image("/die_2.png"));
            case 3 -> gameBoardView.getDieImg().setImage(new Image("/die_3.png"));
            case 4 -> gameBoardView.getDieImg().setImage(new Image("/die_4.png"));
            case 5 -> gameBoardView.getDieImg().setImage(new Image("/die_5.png"));
            case 6 -> gameBoardView.getDieImg().setImage(new Image("/die_6.png"));
        }

    }

    private int turn(){
        int player = 0;
        if (player < this.model.getPlayer().size()) {
            this.gameBoardView.getPlayerName().setText(this.model.getPlayer().get(player).getName());
        }
        return ++player;
    }
}