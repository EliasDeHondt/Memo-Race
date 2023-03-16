package be.kdg.memorace.model;

import javafx.scene.image.*;

import java.util.Comparator;
import java.util.Objects;

/**
 * The Card class represents a card object in a memory matching game.
 * It contains an ImageView attribute which represents the image displayed on the card,
 * as well as an id attribute which is used to identify the card within the game.
 * This class also implements the Comparator and equals methods, which are used to compare and
 * check for equality between card objects based on their ImageView attributes.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class Card implements Comparator<Card> {
    // Attributes
    private final ImageView type;
    private int id;
    // Constructors

    /**
     * Constructs a new Card object with the specified id and image view.
     *
     * @param id        the id of the card.
     * @param imageView the ImageView object representing the image displayed on the card.
     */
    public Card(int id, ImageView imageView) {
        this.id = id;
        this.type = imageView;
    }

    /**
     * Constructs a new Card object with the specified image view.
     * The id of the card is set to 0 by default.
     *
     * @param imageView the ImageView object representing the image displayed on the card.
     */
    public Card(ImageView imageView) {
        this.type = imageView;
    }
    // Methods

    /**
     * Returns the ImageView object representing the image displayed on the card.
     *
     * @return the ImageView object representing the image displayed on the card.
     */
    public ImageView getType() {
        return this.type;
    }

    /**
     * Compares two Card objects based on their ImageView attributes.
     * Used for sorting Card objects in a list.
     *
     * @param o1 the first Card object to compare.
     * @param o2 the second Card object to compare.
     * @return a negative integer, zero, or a positive integer as the first Card object
     * is less than, equal to, or greater than the second Card object based on their ImageView attributes.
     */
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getType().getImage().getUrl().compareTo(o2.getType().getImage().getUrl());
    }

    /**
     * Checks if the specified object is equal to this Card object.
     * Two Card objects are considered equal if their ImageView attributes are equal.
     *
     * @param o the object to compare to this Card object.
     * @return true if the specified object is equal to this Card object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        Card card = (Card) o;
        return this.getType().getImage().getUrl().compareTo(card.getType().getImage().getUrl()) == 0;
    }

    /**
     * Returns a hash code value for this Card object based on its ImageView attribute.
     *
     * @return a hash code value for this Card object based on its ImageView attribute.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }
}