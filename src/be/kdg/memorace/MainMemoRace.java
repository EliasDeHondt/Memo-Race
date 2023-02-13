package be.kdg.memorace;

import be.kdg.memorace.model.GameBoard;
import be.kdg.memorace.view.NewGameView;
import be.kdg.memorace.view.Presenter;
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
    public void start(Stage stage) {
        // Making Model(GameBoard.class).
        GameBoard model = new GameBoard();
        // Making WelcomeView (WelcomeView.class).
        NewGameView NewGameView = new NewGameView();
        // Making Presenter (WelcomeView.class).
        new Presenter(model, NewGameView);
        // Making Scene.
        Scene scene = new Scene(NewGameView);
        // CSS
        scene.getStylesheets().add("/style.css");
        // Making stage (scene).
        stage.setScene(scene);
        // Making Title.
        stage.setTitle("Memo-Race");
        // Making Resizable False
        stage.setResizable(false);
        // Making Icon.
        stage.getIcons().add(new Image("/question_mark.png"));
        // Show Stage.
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
