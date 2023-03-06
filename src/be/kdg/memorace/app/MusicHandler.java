package be.kdg.memorace.app;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Van Elias De Hondt
 * 5/03/2023
 */
public class MusicHandler {
    private double volumeBackground;
    private double volumeButton;
    // Methods
    public static void gameMusic(double volumeBackground) {
        /*
        Media media = new Media(new File("resources/music/introductionMusic.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        mediaPlayer.setVolume(volumeBackground); // Set volume to default 50%
        mediaPlayer.play(); // Play media (introductionMusic.wav)
         */
    }

    public static void clickSound(double volumeButton) { // Play sound when you click the button
       /*
        Media media = new Media(new File("resources/music/click.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        mediaPlayer.setVolume(volumeButton); // Set volume to default 100%
        mediaPlayer.play(); // Play media (click.wav)
        */
    }
}
