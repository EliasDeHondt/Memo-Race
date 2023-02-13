package be.kdg.memorace;

import be.kdg.memorace.model.GameBoard;
import be.kdg.memorace.view.WelcomePresenter;
import be.kdg.memorace.view.WelcomeView;
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
        WelcomeView welcomeView = new WelcomeView();
        // Making Presenter (WelcomeView.class).
        new WelcomePresenter(model, welcomeView);
        // Making Scene.
        Scene scene = new Scene(welcomeView);
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
