package be.kdg.MemoRace.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
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
