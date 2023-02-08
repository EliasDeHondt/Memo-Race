package be.kdg.memorace.model;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Pawn {
    // Attributes
    private int position;
    // Constructors
    public Pawn() {
        this.position = 0;
    }
    // Methods
    public void setPosition(int position) { // Set..
        // Checks whether the position fits on the game board, if not, the position is set equal to the current position - the newPosition - 1.
        if (this.position > 16) this.position = this.position - position - 1;
        this.position += position;
    }
}
