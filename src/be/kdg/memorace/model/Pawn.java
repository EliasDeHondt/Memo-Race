package be.kdg.memorace.model;

/**
 * Represents a pawn on the game board.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class Pawn {
    // Attributes
    private int position;
    // Constructors

    /**
     * Creates a new Pawn object with a position of 0.
     */
    public Pawn() {
        this.position = 0;
    }
    // Methods

    /**
     * Sets the position of the pawn on the game board.
     *
     * @param position the number of spaces the pawn will move.
     *                 If the resulting position is greater than or equal to 16, the pawn will be moved
     *                 to the end of the board and wrapped around to the start.
     */
    public void setPosition(int position) {
        // Checks whether the position fits on the game board, if not, the position is set equal to the current position - the newPosition - 1.
        if ((this.position + position) >= 16) {
            this.position = position - 1;
        } else this.position += position;
    }

    /**
     * Sets the position of the pawn on the game board.
     *
     * @param position the number of spaces the pawn will move.
     *                 If the resulting position is greater than or equal to 16, the pawn will be moved
     *                 to the end of the board and wrapped around to the start.
     */
    public int getPosition() {
        return this.position;
    }
}