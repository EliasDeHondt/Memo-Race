import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speler {
    // Classes
    // Attributes
    private int score;
    private String naam;
    private List<Kaart> kaarten;
    // Constructors
    public Speler(String naam) {
        this.naam = naam;
    }
    // Methods
    public int getScore() { // Get..
        this.score = this.kaarten.size()*10;
        return this.score;
    }
    public String getNaam() { // Get..
        return this.naam;
    }
}
