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
        // Controleert of de positie wel op het spelbord past indien niet wordt de positie gelijk gesteld aan de huidige positie - de newPositie - 1.
        if (this.positie > 16) this.positie = this.positie - positie - 1;
        this.positie += positie;
    }
    public void setBeurt(int beurt) { // Set..
        this.beurt = beurt;
    }
    public int getPositie() { // Get..
        return this.positie;
    }
    public int getBeurt() { // Get..
        return this.beurt;
    }
}
