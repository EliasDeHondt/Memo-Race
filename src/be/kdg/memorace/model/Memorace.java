package be.kdg.memorace.model;

import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Memorace {
    // Attributes
    private List<Player> player;
    private Die die;
    private Pawn pawn;
    private int turn;
    private Map<String, ImageView> cards;

    // Constructors
    public Memorace() {
        this.turn = 0;
        this.player = new LinkedList<>();  // Creates a new player list.
        this.die = new Die(); // Creates a new die.
        this.pawn = new Pawn(); // Creates a new pawn.
        this.cards = new HashMap<String, ImageView>();
    }
    // Methods
    public void rollDice() {
        int side = die.getSide();
        this.pawn.setPosition(side);
    }
    public void setPlayer(String playerName) { // Set..
        this.player.add(new Player(playerName));
    }

    public List<Player> getPlayer() { // Get..
        return this.player;
    }

    public Player Turn(){
        if (turn < player.size()) {
            return player.get(turn++);
        }
        else{
            turn = 0;
            return player.get(turn++);
        }
    }
/*
    public Card getACard(int x, int y) {
        // Gives a card back using the given x and y.
        for (Card kaart : cards) {
            if (kaart.getY() == y && kaart.getX() == x) {
                return kaart;
            }
        }
        return null;
    }
    public Card turnChosenCard(int option, List<Card> newCards) {
        switch (option) {
            case 1:
                getACard(newCards.get(0).getX(), newCards.get(0).getY()).turned();
                return getACard(newCards.get(0).getX(), newCards.get(0).getY());
            case 2:
                getACard(newCards.get(1).getX(), newCards.get(1).getY()).turned();
                return getACard(newCards.get(1).getX(), newCards.get(1).getY());
            case 3:
                getACard(newCards.get(2).getX(), newCards.get(2).getY()).turned();
                return getACard(newCards.get(2).getX(), newCards.get(2).getY());
            case 4:
                getACard(newCards.get(3).getX(), newCards.get(3).getY()).turned();
                return getACard(newCards.get(3).getX(), newCards.get(3).getY());
            default:
                return null;
        }
    }*/

    public Die getDie() { // Get..
        return this.die;
    }

    public void setCards(String s, ImageView iv) {
        this.cards.put(s,iv);
    }

    public Map<String, ImageView> getCards() {
        return cards;
    }
}
