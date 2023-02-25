package be.kdg.memorace.model;

import java.util.LinkedList;
import java.util.List;

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

    // Constructors
    public Memorace() {
        turn=0;
        this.player = new LinkedList<>();  // Creates a new player list.

        this.die = new Die(); // Creates a new die.

        this.pawn = new Pawn(); // Creates a new pawn.
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
    public Die getDie() { // Get..
        return this.die;
    }
}
