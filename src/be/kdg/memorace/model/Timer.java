package be.kdg.memorace.model;

/**
 * Vera Wise & Elias De Hondt
 * 20/02/2023
 */

public class Timer {
    // Attributes
    private static final int DURATION = 1000;
    private int hours;
    private int minutes;
    private int seconds;
    // Constructors
    public Timer() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    // Methods
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
        return this.hours;
    }
    public int getMinutes() { // Get..
        return this.minutes;
    }
    public int getSeconds() { // Get..
        return this.seconds;
    }
    public int getDuration() { // Get..
        return DURATION;
    }
}