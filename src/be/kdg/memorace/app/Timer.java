package be.kdg.memorace.app;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Van Elias De Hondt
 * 20/02/2023
 */

public class Timer {
    private Timeline timeline;
    private Label label;
    private long startTime;

    public Timer(Label label) {
        this.label = label;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            long now = System.currentTimeMillis();
            long elapsedMillis = now - this.startTime;
            LocalTime elapsedTime = LocalTime.ofSecondOfDay(elapsedMillis / 1000);
            String time = elapsedTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            label.setText(time);
        }));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.timeline.play();
    }

    public void stop() {
        this.timeline.stop();
    }
}
