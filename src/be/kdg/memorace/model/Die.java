package be.kdg.memorace.model;

import java.util.Random;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Die {
    // Attributes
    private final int side;

    // Constructors
    public Die() {
        final Random dobbelsteen = new Random();
        this.side = dobbelsteen.nextInt(1, 7);
    }
    // Methods
    public int getSide() {
        return this.side;
    }
}
