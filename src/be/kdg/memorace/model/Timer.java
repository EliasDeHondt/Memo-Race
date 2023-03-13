package be.kdg.memorace.model;

/**
 * Van Elias De Hondt
 * 20/02/2023
 */

public class Timer {
    private static final int DURATION = 1000;
    private int hours;
    private int minutes;
    private int seconds;
    private final int tickDurationMillis;

    public Timer() {
        this.tickDurationMillis = DURATION;
    }

    public void tick() {
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
            if (this.minutes == 60) {
                this.minutes = 0;
                this.hours++;
            }
        }
    }

    public int getHours() { // Get..
        return hours;
    }
    public int getMinutes() { // Get..
        return minutes;
    }
    public int getSeconds() { // Get..
        return seconds;
    }
    public int getTickDurationMillis() { // Get..
        return tickDurationMillis;
    }

}