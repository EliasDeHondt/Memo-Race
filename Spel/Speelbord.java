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
    private List<Kaart> kaarten;
    private List<Speler> spelers;
    private final Scanner key = new Scanner(System.in);
    // Constructors
    public Speelbord() {
        // Initializing [dobbelsteen]
        this.dobbelsteen = new Random();
        // Initializing [pad]
        this.pad = new Pad();
        this.kaarten = new LinkedList<>();
        // Vult de lijst kaarten volledig met Kaarten. Altijd twee dezelfde.
        for (int i = 0; i <= 8; i++ ){
            Kaart newKaart = new Kaart();
            if (!this.kaarten.contains(newKaart)) {
                this.kaarten.add(newKaart);
                this.kaarten.add(newKaart);
            } else i--;
            if (this.kaarten.size() == 16) break; // Dit if statement stopt de for loop, anders blijft het eindeloos doorgaan.
        }
        // Zet alle kaarten In de lijst (kaarten) op een random plaats.
        Collections.shuffle(this.kaarten);
        // Initializing [spelers]
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
                this.pad.getPosities().get(15),this.kaarten.get(0),this.kaarten.get(1),this.kaarten.get(2),this.kaarten.get(3),this.pad.getPosities().get(4),
                this.pad.getPosities().get(14),this.kaarten.get(4),this.kaarten.get(5),this.kaarten.get(6),this.kaarten.get(7),this.pad.getPosities().get(5),
                this.pad.getPosities().get(13),this.kaarten.get(8),this.kaarten.get(9),this.kaarten.get(10),this.kaarten.get(11),this.pad.getPosities().get(6),
                this.pad.getPosities().get(12),this.kaarten.get(12),this.kaarten.get(13),this.kaarten.get(14),this.kaarten.get(15),this.pad.getPosities().get(7),
                this.pad.getPosities().get(11),this.pad.getPosities().get(10),this.pad.getPosities().get(9),this.pad.getPosities().get(8));
    }
}
