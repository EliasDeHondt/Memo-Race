package be.kdg.memorace.model;

import javafx.scene.media.*;

import java.io.File;

/**
 * This class provides methods to handle the background music and sound effects in the game.
 * It allows you to play, stop and adjust the volume of different types of music and sounds.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class MusicHandler {
    // Attributes
    private MediaPlayer backgroundMusic;

    // Methods

    /**
     * Starts playing the game background music.
     *
     * @param volumeBackground the volume of the background music.
     */
    public void gameMusic(double volumeBackground) {

        Media media = new Media(new File("resources/music/introductionMusic.wav").toURI().toString()); // set (Media)
        this.backgroundMusic = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        this.backgroundMusic.setVolume(volumeBackground); // Set volume to default 50%
        this.backgroundMusic.play();
    }

    /**
     * Plays a sound effect when a button is clicked.
     *
     * @param volumeButton the volume of the button click sound.
     */
    public static void clickSound(double volumeButton) { // Play sound when you click the button

        Media media = new Media(new File("resources/music/click.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = mediaPlayer
        mediaPlayer.setVolume(volumeButton); // Set volume to default 100%
        mediaPlayer.play(); // Play media (click.wav)
    }

    /**
     * Plays the winning sound effect when the player wins the game.
     *
     * @param volumeWon the volume of the winning sound effect.
     */
    public static void wonMusic(double volumeWon) {

        Media media = new Media(new File("resources/music/won.wav").toURI().toString()); // set (Media)
        MediaPlayer mediaPlayer = new MediaPlayer(media); // Set media to new (MediaPlayer) = player
        mediaPlayer.setVolume(volumeWon); // Set volume to default 100%
        mediaPlayer.play(); // Play media (won.wav)
    }

    /**
     * Returns the current background music.
     *
     * @return the MediaPlayer object representing the background music.
     */
    public MediaPlayer getBackgroundMusic() {
        return this.backgroundMusic;
    }
}