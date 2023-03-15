package be.kdg.memorace.model;
import java.util.ArrayList;

/**
 * <p> @author Vera Wise </p>
 * <p> @author Elias De Hondt </p>
 * <p> 08/12/2022 </p>
 */
public class Player {
    // Attributes
    private int score;
    private final String Name;
    private ArrayList<Card> cards;
    // Constructors
    public Player(String Name) {
        this.score = 0;
        this.Name = Name;
        this.cards = new ArrayList<>();
    }
    // Methods
    public int getScore() {
        return this.score = cards.size() * 1000;
    }
    public String getName() {
        return this.Name;
    }
    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
