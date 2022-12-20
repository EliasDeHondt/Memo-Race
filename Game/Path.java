package Game;

import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Path {
    // Attributes
    private List<Integer> posities;
    private Pawn pion;
    // Constructors
    public Path(List<Integer> posities) {
        this.posities = posities;
    }
    public Path() {
        this.posities = new LinkedList<>();
        this.maakPad();
    }
    // Methods
    public void maakPad() {
        for (int i = 1; i <= 16; i++) {
            this.posities.add(i);
        }
    }
    public List<Integer> getPosities() { // Get..
        return this.posities;
    }
}
