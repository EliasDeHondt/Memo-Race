package be.kdg.memorace.view.Welcome;

import be.kdg.memorace.model.Memorace;
import be.kdg.memorace.view.About.AboutPresenter;
import be.kdg.memorace.view.About.AboutView;
import be.kdg.memorace.view.GameLog.GameLogPresenter;
import be.kdg.memorace.view.GameLog.GameLogView;
import be.kdg.memorace.view.NewGame.NewGamePresenter;
import be.kdg.memorace.view.NewGame.NewGameView;
import be.kdg.memorace.view.PresenterInterface;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class WelcomePresenter implements PresenterInterface {
    // Attributes
    private final Memorace model;
    private final WelcomeView welcomeView;
    // Constructors
    public WelcomePresenter(Memorace model, WelcomeView welcomeView) {
        this.model = model;
        this.welcomeView = welcomeView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        // Action-> [Play New Game] (getPlayNewGame)
        this.welcomeView.getPlayNewGame().setOnAction((e -> {
           //clickSound(); // Play sound when you click the button

            NewGameView newGameView = new NewGameView(); // Making View (NewGameView.class).
            this.welcomeView.getScene().setRoot(newGameView); // Add (NewGameView.class) to (WelcomeView.class).
            newGameView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / New Game"); // Making Title (Memo-Race / New Game).
            newGameView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (NewGameView.class)
            new NewGamePresenter(model, newGameView); // Making Presenter (NewGamePresenter.class).
        }));
        // Action-> [View Game Log] (getViewGameLog)
        this.welcomeView.getViewGameLog().setOnAction((e -> {
            //clickSound(); // Play sound when you click the button

            GameLogView gameLogView = new GameLogView(); // Making View (GameLogView.class).
            this.welcomeView.getScene().setRoot(gameLogView); // Add (GameLogView.class) to (WelcomeView.class).
            gameLogView.getScene().getWindow().sizeToScene(); // Add new Size.
            this.welcomeView.getCustomStage().setTitle("Memo-Race / Game Log"); // Making Title (Memo-Race / Game Log).
            gameLogView.setCustomStage(this.welcomeView.getCustomStage());  // Send primaryStage to (GameLogView.class)
            new GameLogPresenter(model, gameLogView); // Making Presenter (GameLogPresenter.class).
        }));
        // Action-> [About] (getAbout)
        this.welcomeView.getAbout().setOnAction(event -> {
            //clickSound(); // Play sound when you click the button

            AboutView aboutView = new AboutView();
            new AboutPresenter(model, aboutView);
            Stage aboutStage = new Stage();
            aboutStage.initOwner(this.welcomeView.getScene().getWindow());
            aboutStage.initModality(Modality.APPLICATION_MODAL); // Gebonden venster!
            Scene scene = new Scene(aboutView); // New scene
            scene.getStylesheets().add("/style.css"); // CSS
            aboutStage.setScene(scene); // Set new stage
            aboutStage.getIcons().add(new Image("/logo.png")); // Making Icon.
            aboutStage.setTitle("Memo-Race / About"); // Making Title.
            aboutStage.showAndWait();
        });
        // Action-> [Exit Game] (getExit)
        this.welcomeView.getExit().setOnAction((e -> {
            //clickSound(); // Play sound when you click the button
            Platform.exit(); // exit
        }));
    }
}