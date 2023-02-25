package be.kdg.memorace.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;
import java.util.Random;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Card{
    // Attributes
    private boolean turned;
    private String type;
    private int x;
    private int y;
    private ImageView imageView;
    // Constructors
    public Card() {
        Random random = new Random();
        this.turned = false;
    }

    public Card(ImageView imageView) {
        this.imageView = imageView;
    }
    // Methods

    public void setType(String type) {
        this.type = type;
    }
    public void setX(int x) { // Set..
        this.x = x;
    }
    public void setY(int y) { // Set..
        this.y = y;
    }

    public int getCardX() {
        return x;
    }
    public int getCardY() {
        return y;
    }
    public String getType() { // Get..
        if(this.isTurned()) return this.type;
        else return "?";
    }
    public void turned() { // If the card is turned over, it will be returned. Set to its default position. Or reversed.
        this.turned = !this.turned;
    }
    public boolean isTurned() { // Checks if the card is flipped. Yes or no?
        return this.turned;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card kaart = (Card) o;
        return type == kaart.type && x == kaart.x && y == kaart.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(type, x, y);
    }
    @Override
    public String toString() {
        return String.format("%s",this.type);
    }
}
