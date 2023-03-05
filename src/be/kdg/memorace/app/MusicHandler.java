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
    public static void gameMusic() {
        double VolumeBackground = 0.5;

        Media media = new Media(new File("resources/music/introductionMusic.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        mediaPlayer.setVolume(VolumeBackground); // Set volume to default 50%
        mediaPlayer.play(); // Play media (introductionMusic.wav)
    }

    public static void clickSound() { // Play sound when you click the button
        double VolumeButton = 1.0;

        Media media = new Media(new File("resources/music/click.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        mediaPlayer.setVolume(VolumeButton); // Set volume to default 100%
        mediaPlayer.play(); // Play media (click.wav)
    }
}
