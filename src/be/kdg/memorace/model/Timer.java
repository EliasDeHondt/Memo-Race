package be.kdg.memorace.model;

/**
 * The Timer class keeps track of time and contains methods to manipulate time.
 * The time can be queried in hours, minutes and seconds, and there is a duration of 1000 milliseconds.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @version 1.0
 * @since 08/12/2022
 */
public class Timer {
    // Attributes
    private static final int DURATION = 1000;
    private int hours;
    private int minutes;
    private int seconds;
    // Constructors

    /**
     * Creates a Timer object with an initial time of 0 hours, 0 minutes, and 0 seconds.
     */
    public Timer() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    // Methods

    /**
     * Increases the time by 1 second. When the time reaches 60 seconds, the minute is incremented and the seconds are reset to 0.
     * When the minute reaches 60 minutes, the hour is incremented and the minutes are reset to 0.
     */
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

    /**
     * @return The number of hours the timer has tracked.
     */
    public int getHours() {
        return this.hours;
    }

    /**
     * @return The number of minutes the timer has tracked.
     */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     * @return The number of seconds the timer has tracked.
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * @return The duration of 1000 milliseconds that the timer uses to keep time.
     */
    public int getDuration() {
        return DURATION;
    }
}