import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Pion {
    // Attributes
    private int positie;
    private int beurt;
    // Constructors
    public Pion() {
        this.positie = 0;
        this.beurt = 0;
    }
    // Methods
    public void setPositie(int positie) { // Set..
        this.positie = positie;
    }
    public void setBeurt(int beurt) { // Set..
        this.beurt = beurt;
    }
    public int getPositie() { // Get..
        return positie;
    }
    public int getBeurt() { // Get..
        return beurt;
    }
}
