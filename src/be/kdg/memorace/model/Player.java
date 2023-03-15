package be.kdg.memorace.model;
import java.util.ArrayList;

/**
 * @author Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Player {
    // Attributes
    private int score;
    private final String Name;
    private ArrayList<Card> Cards;
    // Constructors
    public Player(String Name) {
        this.score = 0;
        this.Name = Name;
        this.Cards = new ArrayList<>();
    }
    // Methods
    public int getScore() {
        this.score = Cards.size()*100;
        return this.score;
    }
    public String getName() { // Get..
        return this.Name;
    }
    public ArrayList<Card> getCards() {
        return Cards;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCards(ArrayList<Card> cards) {
        Cards = cards;
    }

    @Override
    public String toString() {
        return "player " + getName();
    }

}
