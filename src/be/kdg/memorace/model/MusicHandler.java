package be.kdg.memorace.model;
import javafx.scene.media.*;
import java.io.File;

/**
 * @author Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class MusicHandler {
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

    public static void wonMusic(double volumeWon) {
/*
        Media media = new Media(new File("resources/music/won.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        mediaPlayer.setVolume(volumeWon); // Set volume to default 100%
        mediaPlayer.play(); // Play media (won.wav)

 */
    }
}
