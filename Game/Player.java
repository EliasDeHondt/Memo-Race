/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Player {
    // Attributes
    private int score;
    private String naam;
    private Card[] kaarten = new Card[4];
    // Constructors
    public Player(String naam) {
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
    public Card[] getKaarten() { // Get..
        return kaarten;
    }
}
