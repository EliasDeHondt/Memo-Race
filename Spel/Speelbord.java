package Spel;

import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speelbord {
    // Attributes
    private Random dobbelsteen;
    private Pad pad;
    private List<Kaart> kaart;
    private List<Speler> spelers;
    private final Scanner key = new Scanner(System.in);
    // Constructors
    public Speelbord() {
        dobbelsteen = new Random();
        pad = new Pad();
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
                ║ GO! ║  %d  ║  %d  ║  %d  ║  %d  ║     ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║ %3d ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║ %3d ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║ %3d ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║ %3d ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║     ║ %3d ║ %3d ║ %3d ║  %d  ║     ║
                ╠═════╩═════╩═════╩═════╩═════╩═════╝
                """,
                this.pad.getPosities().get(0),this.pad.getPosities().get(1),this.pad.getPosities().get(2),this.pad.getPosities().get(3),
                this.pad.getPosities().get(15),this.kaart.get(0),this.kaart.get(1),this.kaart.get(2),this.kaart.get(3),this.pad.getPosities().get(4),
                this.pad.getPosities().get(14),this.kaart.get(4),this.kaart.get(5),this.kaart.get(6),this.kaart.get(7),this.pad.getPosities().get(5),
                this.pad.getPosities().get(13),this.kaart.get(8),this.kaart.get(9),this.kaart.get(10),this.kaart.get(11),this.pad.getPosities().get(6),
                this.pad.getPosities().get(12),this.kaart.get(12),this.kaart.get(13),this.kaart.get(14),this.kaart.get(15),this.pad.getPosities().get(7),
                this.pad.getPosities().get(11),this.pad.getPosities().get(10),this.pad.getPosities().get(9),this.pad.getPosities().get(8));
    }
}
