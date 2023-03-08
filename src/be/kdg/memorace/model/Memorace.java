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
    private Die die;
    private List<Pawn> pawns;
    private int turn;
    private Map<Integer, Card> cards;
    private double volumeBackground;
    private double volumeButton;
    private String cardTheme;

    // Constructors
    public Memorace() {
        this.turn = 0;
        this.players = new LinkedList<>();  // Creates a new player list.
        this.die = new Die(); // Creates a new die.
        this.pawns = new LinkedList<>(); // Creates a new pawn.
        this.cards = new HashMap<Integer, Card>();
        this.volumeBackground = 0.5; // default 50%
        this.volumeButton = 1.0; // default 100%
    }

    // Methods
    public void setPawnPosition(int player){
        this.pawns.get(player).setPosition(this.die.getSide());
        //System.out.println("p ;" + player);
    }
    public void setPlayer(String playerName) { // Set..
        this.players.add(new Player(playerName));
    }

    public void setPawn() {
        this.pawns.add(new Pawn());
    }

    public List<Player> getplayers() { // Get..
        return this.players;
    }

    public Player Turn(){
        if (this.turn < this.players.size()) {
            return this.players.get(this.turn++);
        }
        else{
            this.turn = 0;
            return this.players.get(this.turn++);
        }
    }
    public int getPlayerID(){
        return this.turn;
    }
    public int currentPlayer(Player playe){
        int current = 1;
        for (int i = 0; i < getplayers().size(); i++) {
            if(playe.getName().equals(getplayers().get(i).getName())){
                current = i;
                //System.out.println(current);
            }
        }
        return current;
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
    /*
    public void compare2Cards(Card kaart1, Card kaart2) {
        for (int i = 0; i < this.getPlayer().size(); i++) {
            if (kaart1.getType() == kaart2.getType()) {
                System.out.println(kaart2.getX() + ", " + kaart2.getY());
                //this.getPlayer().get(i).getCards()[i] = kaart1;
                for (Card kaart : cards.values()) {
                    if (kaart1 == kaart) {
                        //this.printSpelerKaarten();
                        kaart.setType(" ");
                    }
                }
                for (Card kaart : cards.values()) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.setType(" ");
                }
                System.out.println(this); // PrintBoard
            } else {
                for (Card kaart : cards.values()) {
                    if (kaart1.getX() == kaart.getX() && kaart1.getY() == kaart.getY()) kaart.turned();
                }
                for (Card kaart : cards.values()) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.turned();
                }
            }
        }
    }
    public Card getACard(int x, int y) {
        // Gives a card back using the given x and y.
        for (Card card : cards.values()) {
            if (card.getY() == y && card.getX() == x) {
                return card;
            }
        }
        return null;
    }
    public Card turnChosenCard(int option, List<Card> newCards) {
        newCards.get(0).getX();
        switch (option) {
            case 1:
                getACard(newCards.get(0).getCardX(), newCards.get(0).getCardY()).turned();
                return getACard(newCards.get(0).getCardX(), newCards.get(0).getCardY());
            case 2:
                getACard(newCards.get(1).getCardX(), newCards.get(1).getCardY()).turned();
                return getACard(newCards.get(1).getCardX(), newCards.get(1).getCardY());
            case 3:
                getACard(newCards.get(2).getCardX(), newCards.get(2).getCardY()).turned();
                return getACard(newCards.get(2).getCardX(), newCards.get(2).getCardY());
            case 4:
                getACard(newCards.get(3).getCardX(), newCards.get(3).getCardY()).turned();
                return getACard(newCards.get(3).getCardX(), newCards.get(3).getCardY());
            default:
                return null;
        }
    }
*/
    public Die getDie() { // Get..
        return this.die;
    }
    public Pawn getPawn(int pawn) {
        return this.pawns.get(pawn);
    }
    public void setCards(int i, ImageView iv) {
        Card card = new Card(iv);
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
}
