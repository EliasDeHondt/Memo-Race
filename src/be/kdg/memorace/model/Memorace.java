package be.kdg.memorace.model;

import javafx.scene.image.ImageView;
import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
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
    // Constructors
    public Memorace() {
        this.turn = 0;
        this.players = new LinkedList<>();  // Creates a new player list.
        this.die = new Die(); // Creates a new die.
        this.pawns = new LinkedList<>(); // Creates a new pawn.
        this.cards = new HashMap<>();
        this.volumeBackground = 0.5; // default 50%
        this.volumeButton = 1.0; // default 100%
        this.timer = new Timer(); // Set timer
    }
    // Methods
    public Player Turn() {
        if (this.turn >= this.players.size()) {
            this.turn = 0;
        }
        return this.players.get(this.turn++);
    }
    public int currentPlayer(Player playe) {
        int current = 1;
        for (int i = 0; i < getplayers().size(); i++) {
            if(playe.getName().equals(getplayers().get(i).getName())){
                current = i;
            }
        }
        return current;
    }
    public boolean compare2Cards(ImageView imageView1,ImageView imageView2){
        Card card1 = new Card(imageView1);
        Card card2 = new Card(imageView2);

        if (card1.equals(card2)) {
            System.out.println("yaaay");
            return true;
        } else return false;
    }
    public void addCardToPlayer(int playerID, ImageView imageView){
        Player player = players.get(playerID);
        Card card = new Card(imageView);
        player.getCards().add(card);
        //System.out.println(players.get(playerID) + player.getCards().get(0).getType().getImage().getUrl());
    }
    public List<Integer> GetValidCardsIDs(int i) {
        // Gives the card to draw options based on the position.
        List<Integer> newCards = new ArrayList<>(this.cards.size());
        //String[] a = this.cards.keySet().toArray(new String[this.cards.size()]);
        // Top game board.
        System.out.println("i = " + i);
        if (i > 0 && i <= 4) {
            newCards.add((i- 1));
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
            newCards.add((i- 1));
            newCards.add((i - 1 + 4));
            newCards.add((i - 1 + 8));
            newCards.add((i - 1 + 12));
            return newCards;
        }
        // Left game board.
        else { //(i >= 13 && i <= 16)
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
    public Die getDie() { // Get..
        return this.die;
    }
    public Pawn getPawn(int pawn) {
        return this.pawns.get(pawn);
    }
    public void setCards(int i, ImageView iv) {
        Card card = new Card(i,iv);
        this.cards.put(i,card);
    }
    public void setVolumeBackground(double volumeBackground) { // Set..
        this.volumeBackground = volumeBackground;
    }
    public void setVolumeButton(double volumeButton) { // Set..
        this.volumeButton = volumeButton;
    }
    public void setCardTheme(String cardTheme) { // Set..
        this.cardTheme = cardTheme;
    }
    public double getVolumeBackground() { // Get..
        return this.volumeBackground;
    }
    public double getVolumeButton() { // Get..
        return this.volumeButton;
    }
    public String getCardTheme() { // Get..
        return this.cardTheme;
    }
    public Timer getTimer() { // Get..
        return this.timer;
    }
    public void setPawnPosition(int player) { // Set..
        this.pawns.get(player).setPosition(this.die.getSide());
    }
    public void setPlayer(String playerName) { // Set..
        this.players.add(new Player(playerName));
    }
    public void setPawn() { // Set..
        this.pawns.add(new Pawn());
    }
    public List<Player> getplayers() { // Get..
        return this.players;
    }
    public int getPlayerID() { // Get..
        return this.turn;
    }
}
