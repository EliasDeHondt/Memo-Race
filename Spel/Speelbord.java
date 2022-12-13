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
        Integer[] nr_Array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        List<Integer> nr = new ArrayList<>(Arrays.asList(nr_Array));
        pad = new Pad(nr);

        System.out.print(
                """
                ║
                ╠═════╦═════╦═════╦═════╦═════╦═════╗
                ║ GO! ║""");
        for (int i = 0; i < 5; i++) {
            System.out.printf("  %d  ║",pad.getPosities().get(i));
        }
        System.out.println();
        int k = 13;
        for (int j = 5; j < 9; j++) {
            System.out.println("╠═════╬═════╬═════╬═════╬═════╬═════╣");
            System.out.printf("║ %d  ║  %s  ║  %s  ║  %s  ║  %s  ║  %d  ║\n",
                    pad.getPosities().get(j+k),"A","B","C","D",pad.getPosities().get(j));
            k--; k--;
        }
        System.out.printf(
                """
                ╠═════╬═════╬═════╬═════╬═════╬═════╣
                ║ %d  ║ %d  ║ %d  ║ %d  ║ %d  ║ %d  ║
                ╠═════╩═════╩═════╩═════╩═════╩═════╝
                """,15,14,13,12,11,10); // Minder Temp, maar nog steeds Temp
    }
}
