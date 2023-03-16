package be.kdg.memorace.model;

import javafx.scene.image.ImageView;

import java.util.*;

/**
 * This class represents the game logic of Memorace.
 * It keeps track of the game state, such as the players, pawns, cards, turn, timer, etc.
 * It also provides various methods to manipulate the game state, such as adding cards to a player's hand,
 * checking if two cards match, calculating the winner, etc.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class Memorace {
    // Attributes
    private final List<Player> players;
    private final Die die;
    private final List<Pawn> pawns;
    private int turn;
    private final Map<Integer, Card> cards;
    private double volumeBackground;
    private double volumeButton;
    private String cardTheme;
    private final Timer timer;
    private final MusicHandler musicHandler;
    // Constructors

    /**
     * Initializes a new instance of the Memorace class.
     * Creates a new player list, a new die, a new pawn list, and a new card map.
     * Sets the default background and button volume to 50% and 100%, respectively.
     * Creates a new music handler and plays the game music with the default button volume.
     * Creates a new timer.
     */

    public Memorace() {
        this.turn = 0;
        this.players = new LinkedList<>();  // Creates a new player list.
        this.die = new Die(); // Creates a new die.
        this.pawns = new LinkedList<>(); // Creates a new pawn.
        this.cards = new HashMap<>();

        this.volumeBackground = 0.5; // default 50%
        this.volumeButton = 1.0; // default 100%

        this.musicHandler = new MusicHandler();
        this.musicHandler.gameMusic(this.volumeButton); // Play game Music (default 100%)

        this.timer = new Timer(); // Set timer
    }
    // Methods

    /**
     * Returns the current player whose turn it is.
     * If the current turn is greater than or equal to the number of players, sets the turn to 0.
     *
     * @return The current player whose turn it is.
     */
    public Player Turn() {
        if (this.turn >= this.players.size()) {
            this.turn = 0;
        }
        return this.players.get(this.turn++);
    }

    /**
     * Returns the player who is not currently taking their turn.
     *
     * @return The player who is not currently taking their turn.
     */
    public Player DontTurn() {
        return this.players.get(getPlayerID() - 1);
    }

    /**
     * Returns the index of the given player in the list of players.
     *
     * @param player The player to find the index of.
     * @return The index of the given player in the list of players.
     */
    public int currentPlayer(Player player) {
        int current = 1;
        for (int i = 0; i < getplayers().size(); i++) {
            if (player.getName().equals(getplayers().get(i).getName())) {
                current = i;
            }
        }
        return current;
    }

    /**
     * Compares two cards represented by the given ImageViews.
     *
     * @param imageView1 The first ImageView representing a card.
     * @param imageView2 The second ImageView representing a card.
     * @return True if the cards match, false otherwise.
     */
    public boolean compare2Cards(ImageView imageView1, ImageView imageView2) {
        Card card1 = new Card(imageView1);
        Card card2 = new Card(imageView2);

        return card1.equals(card2);
    }

    /**
     * Adds a card represented by the specified ImageView to the player with the given ID.
     *
     * @param playerID  the ID of the player to add the card to
     * @param imageView the ImageView representing the card to be added
     */
    public void addCardToPlayer(int playerID, ImageView imageView) {
        Player player = players.get(playerID);
        Card card = new Card(imageView);
        player.getCards().add(card);
    }

    /**
     * This method returns the player with the highest score among all the players.
     *
     * @return The player with the highest score among all the players.
     */
    public Player winner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (winner.getScore() < player.getScore()) {
                winner = player;
            }
        }
        return winner;
    }

    /**
     * This method generates a list of valid card IDs based on the position on the game board.
     *
     * @param i The position on the game board
     * @return List of valid card IDs
     */
    public List<Integer> GetValidCardsIDs(int i) {
        // Gives the card to draw options based on the position.
        List<Integer> newCards = new ArrayList<>(this.cards.size());
        // Top game board.
        if (i > 0 && i <= 4) {
            newCards.add((i - 1));
            newCards.add((i - 1 + 4));
            newCards.add((i - 1 + 8));
            newCards.add((i - 1 + 12));
            return newCards;
        }
        // Right game board.
        else if (i >= 5 && i <= 8) {
            switch (i) {
                case 5 -> i = 0;
                case 6 -> i = 4;
                case 7 -> i = 8;
                case 8 -> i = 12;
                default -> i = 0;
            }
            newCards.add((i));
            newCards.add((i + 1));
            newCards.add((i + 2));
            newCards.add((i + 3));
            return newCards;
        }
        // Bottom game board.
        else if (i >= 9 && i <= 12) {
            switch (i) {
                case 9 -> i = 4;
                case 10 -> i = 3;
                case 11 -> i = 2;
                case 12 -> i = 1;
                default -> i = 0;
            }
            newCards.add((i - 1));
            newCards.add((i - 1 + 4));
            newCards.add((i - 1 + 8));
            newCards.add((i - 1 + 12));
            return newCards;
        }
        // Left game board.
        else { // so (i >= 13 && i <= 16)
            switch (i) {
                case 13 -> i = 12;
                case 14 -> i = 8;
                case 15 -> i = 4;
                case 16 -> i = 0;
                default -> i = 0;
            }
            newCards.add((i));
            newCards.add((i + 1));
            newCards.add((i + 2));
            newCards.add((i + 3));
            return newCards;
        }
    }

    /**
     * Returns the Die object associated with the Board.
     *
     * @return the Die object associated with the Board.
     */
    public Die getDie() {
        return this.die;
    }

    /**
     * Returns the Pawn object associated with the specified pawn index.
     *
     * @param pawn - the index of the pawn.
     * @return the Pawn object associated with the specified pawn index.
     */
    public Pawn getPawn(int pawn) {
        return this.pawns.get(pawn);
    }

    /**
     * Adds a Card object to the Board's cards collection.
     *
     * @param i  - the index of the Card.
     * @param imageView - the ImageView object associated with the Card.
     */
    public void setCards(int i, ImageView imageView) {
        Card card = new Card(i, imageView);
        this.cards.put(i, card);
    }

    /**
     * Sets the volume of the background music for the Board.
     *
     * @param volumeBackground - the volume of the background music for the Board.
     */
    public void setVolumeBackground(double volumeBackground) {
        this.volumeBackground = volumeBackground;
    }

    /**
     * Sets the volume of the button sounds for the Board.
     *
     * @param volumeButton - the volume of the button sounds for the Board.
     */
    public void setVolumeButton(double volumeButton) {
        this.volumeButton = volumeButton;
    }

    /**
     * Sets the theme of the cards for the Board.
     *
     * @param cardTheme - the theme of the cards for the Board.
     */
    public void setCardTheme(String cardTheme) {
        this.cardTheme = cardTheme;
    }

    /**
     * Returns the volume of the button sounds for the Board.
     *
     * @return the volume of the button sounds for the Board.
     */
    public double getVolumeButton() {
        return this.volumeButton;
    }

    /**
     * Returns the theme of the cards for the Board.
     *
     * @return the theme of the cards for the Board.
     */
    public String getCardTheme() {
        return this.cardTheme;
    }

    /**
     * Returns the Timer object associated with the Board.
     *
     * @return the Timer object associated with the Board.
     */
    public Timer getTimer() {
        return this.timer;
    }

    /**
     * Sets the position of the specified player's pawn.
     *
     * @param player - the index of the player.
     */
    public void setPawnPosition(int player) {
        this.pawns.get(player).setPosition(this.die.getSide());
    }

    /**
     * Adds a Player object to the Board's players collection.
     *
     * @param playerName - the name of the new player.
     */
    public void setPlayer(String playerName) {
        this.players.add(new Player(playerName));
    }

    /**
     * Adds a Pawn object to the Board's pawns collection.
     */
    public void setPawn() {
        this.pawns.add(new Pawn());
    }

    /**
     * Returns the players collection of the Board.
     *
     * @return the players collection of the Board.
     */
    public List<Player> getplayers() {
        return this.players;
    }

    /**
     * Returns the ID of the current player whose turn it is.
     *
     * @return the ID of the current player.
     */
    public int getPlayerID() {
        return this.turn;
    }

    /**
     * Returns the MusicHandler object associated with the game.
     *
     * @return the MusicHandler object.
     */
    public MusicHandler getMusicHandler() {
        return this.musicHandler;
    }
}