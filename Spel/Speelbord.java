import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speelbord {
    // Attributes
    private Random dobbelsteen;
    private Pad pad;
    private List<Kaart> kaarten;
    private List<Speler> spelers;
    private final Scanner key = new Scanner(System.in);
    // Constructors
    public Speelbord() {
        // Maakt het pad van 1 tot 16.
        this.pad = new Pad();
        // Voegt 8 paar unieke kaarten toe.
        this.kaarten = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Kaart newKaart = new Kaart();
            if (!this.kaarten.contains(newKaart)) {
                this.kaarten.add(newKaart);
                this.kaarten.add(newKaart);
            }
            if (this.kaarten.size() == 16) break;
        }
        // Lijst van alle spelers.
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
                ╠[3 Exit❌]
                ║
                """);
        System.out.print("╠➤ ");
        switch (this.key.nextInt()) {
            case 1 -> this.playNewGame();
            case 2 -> this.printBord();
            case 3 -> this.exit();
        }
    }
    public void playNewGame() {
        this.newPlayer();
    }
    public void newPlayer() {
        System.out.print(
                """
                ║
                ╠[How many players?]
                ║
                """);
        System.out.print("╠➤ ");
        int aantal = key.nextInt();
        for (int i = 0; aantal >= i; i++) {
            System.out.printf(
                    """
                    ║
                    ╠[Name of player %d]
                    ║
                    """,i+1);
            System.out.print("╠➤ ");
            key.nextLine();
            this.spelers.add(new Speler(key.nextLine()));
        }
    }
    public void exit() {
        System.out.print("╚[🤙]");
        System.exit(0);
    }
    public void draw() {
        System.out.print("╚[It's a draw🤙]");
        System.exit(0);
    }
    public void printBord() {
        // Bovenkant spelbord
        System.out.print(
                """
                ║
                ╠═════╦═════╦═════╦═════╦═════╦═════╗
                ║ GO! ║""");
        for (int i = 0; i < 4; i++) System.out.printf("  %d  ║",this.pad.getPosities().get(i));
        System.out.println("     ║");
        // Het middelste deel van het spelbord.
        int teller = 11;
        for (int i = 4; i < 8; i++) {
            System.out.printf("""
                            ╠═════╬═════╬═════╬═════╬═════╬═════╣
                            ║ %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                            """, pad.getPosities().get(i+teller),"A","B","C","D",this.pad.getPosities().get(i));
            teller--; teller--;
        }
        // Onderkant spelbord.
        System.out.print("╠═════╬═════╬═════╬═════╬═════╬═════╣\n║     ");
        for (int i = 11; i > 7; i--) System.out.printf("║ %2d  ",this.pad.getPosities().get(i));
        System.out.println("║     ║\n╠═════╩═════╩═════╩═════╩═════╩═════╝");

        // Minder minder minder Temp :-), maar nog steeds Temp
    }
}
