package be.kdg.memorace.model;

import java.util.Random;

/**
 * The Die class represents a die object which can be rolled to generate a random number between 1 and 6.
 * It contains a side attribute which represents the current side facing up on the die.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class Die {
    // Attributes
    private int side;
    private final Random random = new Random();
    // Constructors

    /**
     * Constructs a new Die object.
     * Initializes the side attribute to 0 and calls the rollDie() method to roll the die.
     */
    public Die() {
        this.side = 0;
        this.rollDie();
    }
    // Methods

    /**
     * Returns the current side facing up on the die.
     *
     * @return an integer representing the current side facing up on the die.
     */
    public int getSide() {
        return this.side;
    }

    /**
     * Rolls the die to generate a random number between 1 and 6.
     * Sets the side attribute to the newly generated random number.
     */
    public void rollDie() {
        this.side = random.nextInt(1, 7);
    }
}