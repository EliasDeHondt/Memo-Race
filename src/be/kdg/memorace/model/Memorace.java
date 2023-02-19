package be.kdg.memorace.model;

import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Memorace {
    // Attributes
    private List<Player> player;

    // Constructors
    public Memorace() {

    }
    // Methods
    public void setPlayer(String playerName) { // Set..
        this.player.add(new Player(playerName));
    }
}
