import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Kaart {
    // Attributes
    private boolean omgedraaid;
    private char type;
    private int x;
    private int y;

    // Constructors
    public Kaart() {
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
    public char getType() {
//        if(!this.omgedraaid) {
//            return 'x';
//        }
//        else
            return this.type;
    }
    public void omdraaien() { // Als de kaart is omgedraaid, wordt het terug. Op zijn standaard positie gezet. Of omgedraaid.
        if (this.omgedraaid) {
            this.omgedraaid = false;
        } else this.omgedraaid = true;
    }
    public boolean isOmgedraaid() { // Controleert of de kaart is omgedraaid. Ja of nee?
        return this.omgedraaid;
    }
    @Override // Override van equals
    public boolean equals(Object tempObject) {
        Kaart tempKaar = (Kaart)tempObject;
        return this.type == tempKaar.type;
    }
    @Override // Override van hashCode
    public int hashCode() {
        return type;
    }
    @Override
    public String toString() {
        return String.format("%s",this.type);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
