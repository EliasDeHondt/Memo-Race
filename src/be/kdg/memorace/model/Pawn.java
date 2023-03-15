package be.kdg.memorace.model;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
 */
public class Pawn {
    // Attributes
    private int position;
    // Constructors
    public Pawn() {
        this.position = 0;
    }
    // Methods
    public void setPosition(int position) {
        // Checks whether the position fits on the game board, if not, the position is set equal to the current position - the newPosition - 1.
        if ((this.position+ position) >= 16) {
            this.position = position - 1;
        }
        else this.position += position;
    }

    public int getPosition() {
        return position;
    }
}
