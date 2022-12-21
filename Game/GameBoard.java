import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class GameBoard implements Colour {
    // Attributes
    private final Random dobbelsteen;
    private final Path pad;
    private final Pawn pion;
    private final List<Card> kaarten;
    private final List<Player> spelers;
    private final Scanner keyboard = new Scanner(System.in);
    // Constructors
    public GameBoard() {
        // Creates a new die.
        this.dobbelsteen = new Random();
        // Makes the path from 1 to 16.
        this.pad = new Path();
        // Creates a new pawn.
        this.pion = new Pawn();
        // Adds 8 pairs of unique cards.
        this.kaarten = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Card newKaart = new Card();
            if (!this.kaarten.contains(newKaart)) {
                this.kaarten.add(newKaart);
                this.kaarten.add(newKaart);
            } else i--;
            if (this.kaarten.size() == 16) break;}
        Collections.shuffle(this.kaarten);
        // Save position.
        Card[] k = new Card[16];
        int x = 1; int y = 4; int teller = -1;
        for (int i = 0; i < this.kaarten.size(); i++) {
            k[i] = new Card();
            // Set the x position.
            k[i].setX(x);
            kaarten.get(i).setX(x);
            x++; teller++;
            if (x == 5) x = 1; // Go to next column.
            // Set the Y position.
            if (teller%4 == 0) y++;
            if (y == 9) y = 5;
            k[i].setY(y);
            kaarten.get(i).setY(y); // Go to next row.
        }
        this.kaarten.clear();
        this.kaarten.addAll(List.of(k));
        // List of all players.
        this.spelers = new LinkedList<>();
    }
    // Methods
    public void start() {
        System.out.print(
        """
        ╔════════════════════════════╗
        ║    Welcome to Memo Race    ║
        ╠════════════════════════════╝
        ╠[1 Play new game⌛]
        ╠[2 Test Print Bord☢]
        ╠[3 View game log📁]
        ╠[4 Exit❌]
        ║
        """);
        System.out.print("╠➤ ");
        switch (this.keyboard.nextInt()) {
            case 1 -> this.nieuwSpel();
            case 2 -> this.printBord();
            case 3 -> FileHandler.readFile("Resources/GameLog/players.csv");
            case 4 -> Conclusion.exit();
        }
    }
    public void nieuwSpel() {
        System.out.print("""
        ╠════════════════════════════╗
        ║     How many players?      ║
        ╠════════════════════════════╝
        """);
        System.out.print("╠➤ ");
        int aantal = this.keyboard.nextInt();
        // Checks if that. The number of players is not too much or too little.
        if (aantal<2 || aantal>6) {
            System.out.print("""
            ╠═════════════════════════════════════════════════════════════╗
            ║ Be aware: the number of players must be above 1 and below 6 ║
            ╠═════════════════════════════════════════════════════════════╝
            """);
            this.nieuwSpel();
        }
        for (int i = 1; aantal >= i; i++) {
            System.out.printf("""
            ╠════════════════════════════╗
            ║     Name of player: %1d      ║
            ╠════════════════════════════╝
            """,i);
            System.out.print("╠➤ ");
            this.spelers.add(new Player(this.keyboard.next()));
        }
        this.ronde();
    }
    // TODO:  Must get its own class in [Game.Round] (If this has been done properly, this line can be removed.)
    public void ronde() {
        // Checks that all cards have been turned over and the game can end.
        Boolean endGame = null; // This is for the do-while below
        for (int i = 0; i < this.kaarten.size(); i++) {
            if (!this.kaarten.get(i).isOmgedraaid()) endGame = true;
            // else if (this.kaarten.get(i).isOmgedraaid()) this.draw();
            else if (i == this.kaarten.size()-1) this.won();
        }
        // Makes a throw.
        for (int i = 0; i < this.spelers.size(); i++) {
            // Make a roll and determine the possible cards.
            List<Card> newCards = worp(this.spelers.get(i));
            // Specify the options from the list of possible first options.
            this.printOpties_1(newCards);

            System.out.print("╠➤ ");
            int optie = keyboard.nextInt();
            // Turns over the chosen card and puts it in the players cards.
            Card kaart1 = draaiGekozenKaart(optie,newCards);
            System.out.print("║\n");
            System.out.print("╠");

            this.printOpties_2();

            this.printBord();
            System.out.print("╠➤ ");

            optie = keyboard.nextInt();
            // Determine the next turned over card.
            Card kaart2 = new Card();
            for (int o = 0; o < kaarten.size();o++){
                kaarten.get(o).omdraaien();
                if((optie-1) == o){
                    kaart2 = kaarten.get(o);
                }
            }
            // Check if the 2 flipped cards are the same.
            this.vergelijk2kaarten(kaart1,kaart2);

            this.printBord();
            this.printSpelerKaarten();
        }
    }
    public void printSpelerKaarten(){
        for (Player speler : this.spelers) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Player cards %s        ║
                    ╠════════════════════════════╝
                    """, speler.getKaarten()[0]);
        }
    }
    public void printOpties_1(List<Card> newCards){
        System.out.println("╠════════════════════════════╣");
        for (int j = 0; j < newCards.size(); j++) System.out.printf(
                """
                ║      Option %d: %2d,%2d       ║
                 """,j+1,newCards.get(j).getX(),newCards.get(j).getY());
        System.out.println("╠════════════════════════════╝");
    }
    public void printOpties_2(){
        for (int J = 0; J < 80; J++) System.out.print("═");
        System.out.println("╗");
        for (int j = 0; j < kaarten.size(); j++) {
            if ((j)%4 == 0) System.out.print("║");
            System.out.printf(" Option %-3d: %d,%-5d",j+1,kaarten.get(j).getX(),kaarten.get(j).getY());
            if ((j+1)%4 == 0) System.out.println("║");
        }
        System.out.print("╠");
        for (int J = 0; J < 80; J++) System.out.print("═");
        System.out.println("╝");
    }
    public void vergelijk2kaarten(Card kaart1, Card kaart2){
        for (int i = 0; i < this.spelers.size(); i++) {
            if (kaart1.getType() == kaart2.getType()) {
                System.out.println(kaart2.getX() + ", " + kaart2.getY());
                spelers.get(i).getKaarten()[i] = kaart1;
                for (Card kaart : kaarten) {
                    if (kaart1 == kaart) {
                        this.printSpelerKaarten();
                        kaart.setType(' ');
                    }
                }
                for (Card kaart : kaarten) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.setType(' ');
                }
                this.printBord();
            } else {
                for (Card kaart : kaarten) {
                    if (kaart1.getX() == kaart.getX() && kaart1.getY() == kaart.getY()) kaart.omdraaien();
                }
                for (Card kaart : kaarten) {
                    if (kaart2.getX() == kaart.getX() && kaart2.getY() == kaart.getY()) kaart.omdraaien();
                }
            }
        }
    }
    public List<Card> worp(Player s){
        int tempWorp = this.dobbelsteen.nextInt(1,7);
        this.pion.setPositie(tempWorp);
        List<Card> newCards = GetValidCards(tempWorp);
        System.out.printf("""
        ╠════════════════════════════╗
        ║%8s you rolled an %-5d║
        ║      Your choices are:     ║
        """,s.getNaam(),tempWorp);
        return newCards;
    }
    public void exit() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║         Goodbye 🤙         ║
        ╚════════════════════════════╝
        """);
        System.exit(0);
    }
    public void won() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║      You have won 🤙       ║
        ╚════════════════════════════╝
        """);
        System.exit(0);
    }
    public void draw() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║       It's a draw 🤙       ║
        ╚════════════════════════════╝
        """);
        System.exit(0);
    }
    public void printBord() {
        // Top game board.
        System.out.print(ANSI_BLUE +
        """
        ╠═════╦═════╦═════╦═════╦═════╦═════╗
        ║ GO! ║""");
        for (int i = 0; i < 4; i++) System.out.printf("  %d  ║",this.pad.getPosities().get(i));
        System.out.println("     ║");
        // The middle part of the game board.
        int teller1 = 11;
        int teller2 = 0;
        for (int i = 4; i < 8; i++) {
            System.out.printf("""
            ╠═════╬═════╬═════╬═════╬═════╬═════╣
            ║ %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
            """,this.pad.getPosities().get(i+teller1),this.kaarten.get(teller2).getType(),this.kaarten.get(1+teller2).getType(),
                this.kaarten.get(2+teller2).getType(),this.kaarten.get(3+teller2).getType(),this.pad.getPosities().get(i));
            teller1--; teller1--; teller2+=4;
        }
        // Bottom game board.
        System.out.print("╠═════╬═════╬═════╬═════╬═════╬═════╣\n║     ");
        for (int i = 11; i > 7; i--) System.out.printf("║ %2d  ",this.pad.getPosities().get(i));
        System.out.println("║     ║\n╠═════╩═════╩═════╩═════╩═════╩═════╝" + ANSI_RESET);
    }
    public List<Card> GetGeldigeKaarten(int i){
        // Gives the card to draw options based on the position.
        List<Card> kaarts = new ArrayList<>(kaarten.size());
        // Top game board.
        if(i >= 0 && i <= 4){
            kaarts.add(kaarten.get(i-1));
            kaarts.add(kaarten.get(i-1+4));
            kaarts.add(kaarten.get(i-1+8));
            kaarts.add(kaarten.get(i-1+12));
            return kaarts;
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
            kaarts.add(kaarten.get(i));
            kaarts.add(kaarten.get(i+1));
            kaarts.add(kaarten.get(i+2));
            kaarts.add(kaarten.get(i+3));
            return kaarts;
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
            kaarts.add(kaarten.get(i));
            kaarts.add(kaarten.get(i-4));
            kaarts.add(kaarten.get(i-8));
            kaarts.add(kaarten.get(i-12));
            return kaarts;
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
            kaarts.add(kaarten.get(i));
            kaarts.add(kaarten.get(i+1));
            kaarts.add(kaarten.get(i+2));
            kaarts.add(kaarten.get(i+3));
            return kaarts;
        }
    }
    public Card getEenKaart(int x, int y){
        // Gives a card back using the given x and y.
        for (Card kaart : kaarten) {
            if(kaart.getY() == y && kaart.getX() == x){
                return kaart;
            }
        }
        return null;
    }
    public Card draaiGekozenKaart(int option, List<Card> newCards){
        switch (option){
            case 1: getEenKaart(newCards.get(0).getX(),newCards.get(0).getY()).omdraaien();
                    return getEenKaart(newCards.get(0).getX(),newCards.get(0).getY());
            case 2: getEenKaart(newCards.get(1).getX(),newCards.get(1).getY()).omdraaien();
                    return getEenKaart(newCards.get(1).getX(),newCards.get(1).getY());
            case 3: getEenKaart(newCards.get(2).getX(),newCards.get(2).getY()).omdraaien();
                    return getEenKaart(newCards.get(2).getX(),newCards.get(2).getY());
            case 4: getEenKaart(newCards.get(3).getX(),newCards.get(3).getY()).omdraaien();
                    return getEenKaart(newCards.get(3).getX(),newCards.get(3).getY());
            default: return null;
        }
    }
}