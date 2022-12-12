package Spel;

import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speelbord {
    // Classes
    // Attributes
    private Random dobbelsteen;
    private Pad pad;
    private List<Kaart> kaart;
    private List<Speler> spelers;
    private final Scanner key = new Scanner(System.in);
    // Constructors
    public Speelbord() {
        this.kaart = new LinkedList<>();
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
                ╠[2 Exit❌]
                ║
                """);
        System.out.print("╠➤ ");
        switch (this.key.nextInt()) {
            case 1 -> this.playNewGame();
            case 2 -> this.exit();
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
        System.out.printf(
                """
                ║
                ╠═════╦═════╦═════╦═════╦═════╦═════╗
                ║ GO! ║  %d  ║  %d  ║  %d  ║  %d  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║  %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║  %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║  %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║  %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║  %d  ║  %d  ║  %d  ║  %d  ║  %d  ║  %d  ║
                ╠═════╩═════╩═════╩═════╩═════╩═════╝
                """,1,1,1,1,1,1,"A","B","C","D",1,1,"A","B","C","D",1,1,"A","B","C","D",1,1,"A","B","C","D",1,1,1,1,1,1,1); // Temp [Is voor te testen]
    }
}
