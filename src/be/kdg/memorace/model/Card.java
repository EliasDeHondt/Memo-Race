package be.kdg.memorace.model;
import javafx.scene.image.*;
import java.util.Comparator;
import java.util.Objects;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Card implements Comparator<Card> {
    // Attributes
    private ImageView type;
    private int ID;
    // Constructors
    public Card(int id,ImageView imageView) {
        this.ID = id;
        this.type = imageView;
    }
    public Card(ImageView imageView) {
        this.type = imageView;
    }
    // Methods

    public ImageView getType() {
        return type;
    }

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getType().getImage().getUrl().compareTo(o2.getType().getImage().getUrl());
    }

    @Override
    public boolean equals(Object o) {
        Card card = (Card) o;
        return this.getType().getImage().getUrl().compareTo(card.getType().getImage().getUrl()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
