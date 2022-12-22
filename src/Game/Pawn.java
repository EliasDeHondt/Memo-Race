package Game;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Pawn {
    // Attributes
    private int positie;
    // Constructors
    public Pawn() {
        this.positie = 0;
    }
    // Methods
    public void setPositie(int positie) { // Set..
        // Checks whether the position fits on the game board, if not, the position is set equal to the current position - the newPosition - 1.
        if (this.positie > 16) this.positie = this.positie - positie - 1;
        this.positie += positie;
    }
}
