package be.kdg.memorace;

import be.kdg.memorace.model.GameBoard;
import be.kdg.memorace.view.Presenter;
import be.kdg.memorace.view.NewGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class MainMemoRace extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Making Model (GameBoard.class).
        GameBoard model = new GameBoard();
        // Making NewGameView (NewGameView.class).
        NewGameView newGameView = new NewGameView();
        // Making Presenter (NewGameView.class).
        // new Presenter(model, newGameView);
        // Making Scene.
        Scene scene = new Scene(newGameView);
        // Making stage (scene).
        stage.setScene(scene);
        // Making Title.
        stage.setTitle("Memo-Race");
        // Making Icon.
        stage.getIcons().add(new Image("/question_mark.png"));
        // Show Stage.
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
