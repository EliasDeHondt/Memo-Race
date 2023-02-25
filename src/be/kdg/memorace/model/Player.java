package be.kdg.memorace.model;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Player {
    // Attributes
    private int score;
    private String Name;
    private Card[] Cards = new Card[4];
    // Constructors
    public Player(String Name) {
        this.Name = Name;
    }
    // Methods
    public int getScore() { // Get..
        this.score = this.Cards.length*100;
        return this.score;
    }

    public String getName() { // Get..
        return this.Name;
    }

    public Card[] getCards() { // Get..
        if(this.Cards.length == 0){
            Card e = new Card();
            e.setType("0");
            return new Card[]{e};
        }
        else return this.Cards;
    }
}
