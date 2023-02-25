package be.kdg.memorace.view;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Vera Wise
 * 25/02/2023
 */
public interface PresenterInterface {
    default void clickSound(){
        // Play sound when you click the button

        Media media = new Media(new File("resources/music/click.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        mediaPlayer.play(); // Play media (click.wav)
    }
}
