package be.kdg.memorace.model;

import javafx.scene.image.*;
import java.util.Objects;
import java.util.Random;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Card{
    // Attributes
    private ImageView type;
    // Constructors
    public Card(ImageView imageView) {
        this.type = imageView;
    }
    // Methods

    public ImageView getType() {
        return type;
    }

    public void setType(ImageView type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(type, card.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
