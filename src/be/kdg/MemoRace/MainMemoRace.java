package be.kdg.MemoRace;

import be.kdg.MemoRace.model.Model;
import be.kdg.MemoRace.view.Presenteer;
import be.kdg.MemoRace.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Vera Wise
 * 8/02/2023
 */
public class MainMemoRace extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new Model();
        View view = new View();
        Presenteer presenter = new Presenteer(model, view);
        Scene scene = new Scene(view);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
