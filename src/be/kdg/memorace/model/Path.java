package be.kdg.memorace.model;
import java.util.*;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
 */
public class Path {
    // Attributes
    private List<Integer> positions;
    // Constructors
    public Path() {
        this.positions = new LinkedList<>();
        this.maakPad();
    }
    // Methods
    public void maakPad() {
        for (int i = 1; i <= 16; i++) {
            this.positions.add(i);
        }
    }
    public List<Integer> getPosities() { // Get..
        return this.positions;
    }
}
