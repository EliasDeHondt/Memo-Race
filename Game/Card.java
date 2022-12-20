package Game;

import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Card {
    // Attributes
    private boolean omgedraaid;
    private char type;
    private int x;
    private int y;
    // Constructors
    public Card() {
        this.omgedraaid = false;
        Random random = new Random();
        switch (random.nextInt(0, 8)) { // Neemt een random kaart [A-H | 0-7].
            case 0 -> this.type = 'A';
            case 1 -> this.type = 'B';
            case 2 -> this.type = 'C';
            case 3 -> this.type = 'D';
            case 4 -> this.type = 'E';
            case 5 -> this.type = 'F';
            case 6 -> this.type = 'G';
            case 7 -> this.type = 'H';
        }
    }
    // Methods
    public void setType(char type) { // Set..
        this.type = type;
    }
    public void setX(int x) { // Set..
        this.x = x;
    }
    public void setY(int y) { // Set..
        this.y = y;
    }
    public int getX() { // Get..
        return x;
    }
    public int getY() { // Get..
        return y;
    }
    public char getType() { // Get..
        if(!this.omgedraaid) return 'x';
        else return this.type;
    }
    public void omdraaien() { // If the card is turned over, it will be returned. Set to its default position. Or reversed.
        if (this.omgedraaid) {
            this.omgedraaid = false;
        } else this.omgedraaid = true;
    }
    public boolean isOmgedraaid() { // Checks if the card is flipped. Yes or no?
        return this.omgedraaid;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card kaart = (Card) o;
        return type == kaart.type && x == kaart.x && y == kaart.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(type, x, y);
    }
    @Override
    public String toString() {
        return String.format("%s",this.type);
    }
}
