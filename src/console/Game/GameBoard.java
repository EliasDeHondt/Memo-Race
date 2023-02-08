package console.Game;

import console.App.*;
import console.App.ExceptionPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class GameBoard extends JPanel implements Colour, ActionListener {
    //private final Random dobbelsteen;
    private static class Die {
        private final int silk;

        public Die() {
            final Random dobbelsteen = new Random();
            this.silk = dobbelsteen.nextInt(1, 7);
        }

        public int getZijde() {
            return this.silk;
        }

        @Override
        public String toString() {
            return String.format("Je hebt %d gegooid", this.silk);
        }
    }

    // Attributes
    private final Path path;
    private final Pawn pawn;
    private final List<Card> cards;
    private final List<Player> players;
    private int playerQuantity;
    private final Scanner keyboard = new Scanner(System.in);

    // Constructors
    public GameBoard() {
        // Makes the path from 1 to 16.
        this.path = new Path();

        // Creates a new pawn.
        this.pawn = new Pawn();

        // Adds 8 pairs of unique cards.
        this.cards = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Card newKaart = new Card();
            if (!this.cards.contains(newKaart)) {
                this.cards.add(newKaart);
                this.cards.add(newKaart);
            } else i--;
            if (this.cards.size() == 16) break;
        }
        Collections.shuffle(this.cards);
        // Save position.
        Card[] k = new Card[16];
        int x = 1;
        int y = 4;
        int teller = -1;
        for (int i = 0; i < this.cards.size(); i++) {
            k[i] = new Card();
            // Set the x position.
            k[i].setX(x);
            cards.get(i).setX(x);
            x++;
            teller++;
            if (x == 5) x = 1; // Go to next column.
            // Set the Y position.
            if (teller % 4 == 0) y++;
            if (y == 9) y = 5;
            k[i].setY(y);
            cards.get(i).setY(y); // Go to next row.
        }
        this.cards.clear();
        this.cards.addAll(List.of(k));
        // List of all players.
        this.players = new LinkedList<>();
    }

    // Methods
    public List<Player> getPlayers() { // Get..
        return this.players;
    }

    public int getPlayerQuantity() { // Get..
        return this.playerQuantity;
    }

    public void newPlayerQuantity(int aantal) { // New Player Quantity.
        if (aantal < 2 || aantal > 6) throw new ExceptionPlayer();
        else this.playerQuantity = aantal;
    }

    public void newPlayerName(String name) { // New Player Name.
        this.players.add(new Player(name));
    }

    public void ronde() { // Start ronde.
        // This will check that the game can be ended.
//        for (int i = 0; i < this.getPlayers().size()-1; i++) {
//            if (this.players.size()==2) { // When 2 are two players.
//                if (this.players.get(i).getScore()==800) Conclusion.won(this.players.get(i).getName());
//            } else if (this.players.size()==3) { // When 3 are two players.
//                if (this.players.get(i).getScore()>=533) Conclusion.won(this.players.get(i).getName());
//            } else if (this.players.size()==4) { // When 4 are two players.
//                if (this.players.get(i).getScore()>=400) Conclusion.won(this.players.get(i).getName());
//            } else if (this.players.size()==5) { // When 5 are two players.
//                if (this.players.get(i).getScore()>=320) Conclusion.won(this.players.get(i).getName());
//            } else if (this.players.size()==6) { // When 6 are two players.
//                if (this.players.get(i).getScore()>=266) Conclusion.won(this.players.get(i).getName());
//            }
//        }

        // Makes a throw.
        for (Player speler : this.players) {
            // Make a roll and determine the possible cards.
            List<Card> newCards = worp(speler);
            // Specify the options from the list of possible first options.
            this.printOpties_1(newCards);

            System.out.print("╠➤ ");
            int optie = keyboard.nextInt();
            // Turns over the chosen card and puts it in the players cards.
            Card card1 = draaiGekozenKaart(optie, newCards);
            System.out.println(this); // PrintBoard

            this.printOpties_2();
            System.out.print("╠➤ ");

            optie = keyboard.nextInt();
            // Determine the next turned over card.
            Card card2 = new Card();
            for (int o = 0; o < cards.size(); o++) {
                cards.get(o).turned();
                if ((optie - 1) == o) {
                    card2 = cards.get(o);
                }
            }
            // Check if the 2 flipped cards are the same.
            this.vergelijk2kaarten(card1, card2);
            System.out.println(this); // PrintBoard
        }
    }

    public void printOpties_1(List<Card> newCards) {
        System.out.println("╠════════════════════════════╣");
        for (int j = 0; j < newCards.size(); j++)
            System.out.printf(
                    """
                            ║      Option %d: %2d,%2d       ║
                             """, j + 1, newCards.get(j).getX(), newCards.get(j).getY());
        System.out.println("╠════════════════════════════╝");
    }

    public void printOpties_2() {
        System.out.print("╠");
        for (int J = 0; J < 80; J++) System.out.print("═");
        System.out.println("╗");
        for (int j = 0; j < cards.size(); j++) {
            if ((j) % 4 == 0) System.out.print("║");
            System.out.printf(" Option %-3d: %d,%-5d", j + 1, cards.get(j).getX(), cards.get(j).getY());
            if ((j + 1) % 4 == 0) System.out.println("║");
        }
        System.out.print("╠");
        for (int J = 0; J < 80; J++) System.out.print("═");
        System.out.println("╝");
    }

    public void vergelijk2kaarten(Card kaart1, Card kaart2) {
        for (int i = 0; i < this.players.size(); i++) {
            if (kaart1.getType() == kaart2.getType()) {
                System.out.println(kaart2.getX() + ", " + kaart2.getY());
                players.get(i).getCards()[i] = kaart1;
                for (Card kaart : cards) {
                    if (kaart1 == kaart) {
                        //this.printSpelerKaarten();
                        kaart.setType(' ');
                    }
                }
                for (Card kaart : cards) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.setType(' ');
                }
                System.out.println(this); // PrintBoard
            } else {
                for (Card kaart : cards) {
                    if (kaart1.getX() == kaart.getX() && kaart1.getY() == kaart.getY()) kaart.turned();
                }
                for (Card kaart : cards) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.turned();
                }
            }
        }
    }

    public List<Card> worp(Player s) { // Start Worp
        Die dobbelsteen = new Die();
        int tempWorp = dobbelsteen.getZijde();
        this.pawn.setPosition(tempWorp);
        List<Card> newCards = GetGeldigeKaarten(tempWorp);
        System.out.printf("""
                ╠════════════════════════════╗
                ║%8s you rolled an %-5d║
                ║      Your choices are:     ║
                """, s.getName(), tempWorp);
        return newCards;
    }

    public List<Card> GetGeldigeKaarten(int i) {
        // Gives the card to draw options based on the position.
        List<Card> cards = new ArrayList<>(this.cards.size());
        // Top game board.
        if (i >= 0 && i <= 4) {
            cards.add(this.cards.get(i - 1));
            cards.add(this.cards.get(i - 1 + 4));
            cards.add(this.cards.get(i - 1 + 8));
            cards.add(this.cards.get(i - 1 + 12));
            return cards;
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
            cards.add(this.cards.get(i));
            cards.add(this.cards.get(i + 1));
            cards.add(this.cards.get(i + 2));
            cards.add(this.cards.get(i + 3));
            return cards;
        }
        // Bottom game board.
        else if (i >= 9 && i <= 12) {
            switch (i) {
                case 9 -> i = 12;
                case 10 -> i = 13;
                case 11 -> i = 14;
                case 12 -> i = 15;
                default -> i = 0;
            }
            cards.add(this.cards.get(i));
            cards.add(this.cards.get(i - 4));
            cards.add(this.cards.get(i - 8));
            cards.add(this.cards.get(i - 12));
            return cards;
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
            cards.add(this.cards.get(i));
            cards.add(this.cards.get(i + 1));
            cards.add(this.cards.get(i + 2));
            cards.add(this.cards.get(i + 3));
            return cards;
        }
    }

    public Card getEenKaart(int x, int y) {
        // Gives a card back using the given x and y.
        for (Card kaart : cards) {
            if (kaart.getY() == y && kaart.getX() == x) {
                return kaart;
            }
        }
        return null;
    }

    public Card draaiGekozenKaart(int option, List<Card> newCards) {
        switch (option) {
            case 1:
                getEenKaart(newCards.get(0).getX(), newCards.get(0).getY()).turned();
                return getEenKaart(newCards.get(0).getX(), newCards.get(0).getY());
            case 2:
                getEenKaart(newCards.get(1).getX(), newCards.get(1).getY()).turned();
                return getEenKaart(newCards.get(1).getX(), newCards.get(1).getY());
            case 3:
                getEenKaart(newCards.get(2).getX(), newCards.get(2).getY()).turned();
                return getEenKaart(newCards.get(2).getX(), newCards.get(2).getY());
            case 4:
                getEenKaart(newCards.get(3).getX(), newCards.get(3).getY()).turned();
                return getEenKaart(newCards.get(3).getX(), newCards.get(3).getY());
            default:
                return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // JavaFX
        repaint();
    }

    @Override
    public String toString() { // PrintBoard
        StringBuilder newString = new StringBuilder();
        // Top game board.
        newString.append(ANSI_BLUE +
                """
                        ╠═════╦═════╦═════╦═════╦═════╦═════╗
                        ║ GO! ║""");
        for (int i = 0; i < 4; i++) newString.append(String.format("  %d  ║", this.path.getPosities().get(i)));
        newString.append("     ║\n");
        // The middle part of the game board.
        int counter1 = 11;
        int counter2 = 0;
        for (int i = 4; i < 8; i++) {
            newString.append(String.format("""
                            ╠═════╬═════╬═════╬═════╬═════╬═════╣
                            ║ %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                            """, this.path.getPosities().get(i + counter1), this.cards.get(counter2).getType(), this.cards.get(1 + counter2).getType(),
                    this.cards.get(2 + counter2).getType(), this.cards.get(3 + counter2).getType(), this.path.getPosities().get(i)));
            counter1 -= 2;
            counter2 += 4;
        }
        // Bottom game board.
        newString.append("╠═════╬═════╬═════╬═════╬═════╬═════╣\n║     ");
        for (int i = 11; i > 7; i--) newString.append(String.format("║ %2d  ", this.path.getPosities().get(i)));
        newString.append("║     ║\n╠═════╩═════╩═════╩═════╩═════╩═════╝" + ANSI_RESET);
        return newString.toString();
    }
}