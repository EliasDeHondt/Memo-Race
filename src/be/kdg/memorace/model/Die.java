package be.kdg.memorace.model;

import java.util.Random;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Die {
    // Attributes
    private int side;

    private Random random = new Random();
    // Constructors
    public Die() {
        rollDie();
    }
    // Methods
    public int getSide() {
        return this.side;
    }
    public void rollDie() {
        this.side = random.nextInt(1, 7);
    }
}
