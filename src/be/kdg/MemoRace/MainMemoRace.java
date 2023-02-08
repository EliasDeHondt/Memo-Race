package be.kdg.MemoRace;

import be.kdg.MemoRace.model.GameBoard;
import be.kdg.MemoRace.view.Presenter;
import be.kdg.MemoRace.view.View;
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
        // Making View (View.class).
        View view = new View();
        // Making Presenter (View.class).
        new Presenter(model,view);
        // Making Scene.
        Scene scene = new Scene(view);
        // Making Title.
        stage.setTitle("Memo-Race");
        // Making Icon.
        stage.getIcons().add(new Image("be\\kdg\\MemoRace\\resources\\img\\question_mark.png"));
        // Show Stage.
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
