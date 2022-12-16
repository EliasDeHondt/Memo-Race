import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speler {
    // Attributes
    private int score;
    private String naam;
    private Kaart[] kaarten = new Kaart[4];
    // Constructors
    public Speler(String naam) {
        this.naam = naam;
    }
    // Methods
    public int getScore() { // Get..
        this.score = this.kaarten.length*10;
        return this.score;
    }
    public String getNaam() { // Get..
        return this.naam;
    }

    public Kaart[] getKaarten() {
        return kaarten;
    }
}
