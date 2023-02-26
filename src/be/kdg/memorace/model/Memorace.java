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
    private List<Pawn> pawns;
    private int turn;
    private Map<String, Card> cards;

    // Constructors
    public Memorace() {
        this.turn = 0;
        this.player = new LinkedList<>();  // Creates a new player list.
        this.die = new Die(); // Creates a new die.
        this.pawns = new LinkedList<>(); // Creates a new pawn.
        this.cards = new HashMap<String, Card>();
    }
    // Methods

    public void setPawnPosition(int player){
        die.rollDie();
        this.pawns.get(player).setPosition(die.getSide());
        System.out.println("d ;" + die.getSide());
        System.out.println("p ;" + player);
    }
    public void setPlayer(String playerName) { // Set..
        this.player.add(new Player(playerName));
    }

    public void setPawn() {
        pawns.add(new Pawn());
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
    public int currentPlayer(Player p){
        int current = 1;
        for (int i = 1; i < getPlayer().size(); i++) {
            if(p.getName().equals(getPlayer().get(i).getName())){
                current = i;
            }
        }
        return current;
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

    public void setCards(String s, ImageView iv) {
        Card card = new Card(iv);
        this.cards.put(s,card);
    }

    public Pawn getPawn(int p) {
        return pawns.get(p);
    }

    public Map<String, Card> getCards() {
        return cards;
    }
}
