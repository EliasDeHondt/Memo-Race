package be.kdg.memorace.model;

import java.util.ArrayList;

/**
 * The Player class represents a player in the game.
 * It contains a name, a score and a list of cards that belong to the player.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class Player {
    // Attributes
    private int score;
    private final String Name;
    private final ArrayList<Card> cards;
    // Constructors

    /**
     * The Player constructor initializes the name of the player, the score of the player and the list of cards.
     *
     * @param Name the name of the player
     */
    public Player(String Name) {
        this.score = 0;
        this.Name = Name;
        this.cards = new ArrayList<>();
    }
    // Methods

    /**
     * The player's score is calculated as the number of cards in the player's possession multiplied by 1000.
     *
     * @return the score of the player
     */
    public int getScore() {
        this.score = cards.size() * 1000;
        return this.score;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Returns the list of cards that belong to the player.
     *
     * @return the list of cards that belong to the player
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }
}