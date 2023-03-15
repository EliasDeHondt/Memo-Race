package be.kdg.memorace.model;
import java.util.Random;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
 */
public class Die {
    // Attributes
    private int side;
    private final Random random = new Random();
    // Constructors
    public Die() {
        this.side = 0;
        this.rollDie();
    }
    // Methods
    public int getSide() { // Get..
        return this.side;
    }
    public void rollDie() {
        this.side = random.nextInt(1, 7);
    }
}