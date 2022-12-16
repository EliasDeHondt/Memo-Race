import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speelbord implements Kleur{
    // Attributes
    private Random dobbelsteen;
    private Pad pad;
    private Pion pion;
    private List<Kaart> kaarten;
    private List<Speler> spelers;
    private final Scanner key = new Scanner(System.in);
    // Constructors
    public Speelbord() {
        // Maakt een nieuwe dobbelsteen
        this.dobbelsteen = new Random();
        // Maakt het pad van 1 tot 16.
        this.pad = new Pad();
        // Maakt een nieuwe pion
        this.pion = new Pion();
        // Voegt 8 paar unieke kaarten toe.
        this.kaarten = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            Kaart newKaart = new Kaart();
            if (!this.kaarten.contains(newKaart)) {
                this.kaarten.add(newKaart);
                this.kaarten.add(newKaart);
            } else i--;
            if (this.kaarten.size() == 16) break;
        }
        Collections.shuffle(this.kaarten);
        //positie opslaan
        for (int i = 0; i < kaarten.size();i++) {
            kaarten.get(i).setPositie(new int[]{i, i});
        }
        System.out.println(kaarten);
        // Lijst van alle spelers.
        this.spelers = new LinkedList<>();
    }
    // Methods
    public void start() {
        System.out.print(ANSI_RESET +
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
    public void playNewGame() { // Temp
        this.newPlayer();
    }
    public void newPlayer() {
        System.out.print(ANSI_RESET +
                """
                ║
                ╠[How many players?]
                ║
                """);
        System.out.print("╠➤ ");
        int aantal = this.key.nextInt();
        for (int i = 1; aantal >= i; i++) {
            System.out.printf(ANSI_RESET +
                    """
                    ║
                    ╠[Name of player %d]
                    ║
                    """,i);

            System.out.print("╠➤ ");
            this.spelers.add(new Speler(this.key.next()));
        }
        this.turn();
    }
    public void turn() {
        // Controleert of alle kaarten zijn omgedraaid en het spel kan eindigen.
        for (int i = 0; i < this.kaarten.size(); i++) {
            if (!this.kaarten.get(i).isOmgedraaid()) break;
            else if (i == this.kaarten.size()-1) this.win();
        }
        // Doet een eerste worp.
        for (int i = 0; i < this.spelers.size(); i++) {
            int tempWorp = this.dobbelsteen.nextInt(1,7);
            System.out.printf(ANSI_RESET + """
                    ║
                    ╠[%s you rolled an %d.]
                    ║
                    """,this.spelers.get(i).getNaam(),tempWorp);
            this.pion.setPositie(tempWorp);
            //get opties
            GetValidCards(pion.getPositie());


            this.printBord();
        }
        //Geeft de te trekken kaart mogelijkheden adhv de positie.
        //GetValidCards(pion.getPositie());
        System.out.println("positie: " + pion.getPositie() + " " + GetValidCards(pion.getPositie())); //test of het werkt.

    }
    public void exit() {
        System.out.print("╚[🤙]");
        System.exit(0);
    }
    public void win() {
        System.out.print("╚[🤙]");
        System.exit(0);
    }
    public void draw() {
        System.out.print("╚[It's a draw🤙]");
        System.exit(0);
    }
    public void printBord() {
        // Bovenkant spelbord
        System.out.print(ANSI_GREEN +
                """
                ╠═════╦═════╦═════╦═════╦═════╦═════╗
                ║ GO! ║""");
        for (int i = 0; i < 4; i++) System.out.printf("  %d  ║",this.pad.getPosities().get(i));
        System.out.println("     ║");
        // Het middelste deel van het spelbord.
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
        // Onderkant spelbord.
        System.out.print("╠═════╬═════╬═════╬═════╬═════╬═════╣\n║     ");
        for (int i = 11; i > 7; i--) System.out.printf("║ %2d  ",this.pad.getPosities().get(i));
        System.out.println("║     ║\n╠═════╩═════╩═════╩═════╩═════╩═════╝");
        // Minder minder minder Temp :-), maar nog steeds Temp
    }

    public List<Kaart> GetValidCards(int i){
        List<Kaart> kaarts = new ArrayList<>(kaarten.size());
        //boven
        if(i >= 0 && i <= 4){
            kaarts.add(kaarten.get(i-1));
            kaarts.add(kaarten.get(i-1+4));
            kaarts.add(kaarten.get(i-1+8));
            kaarts.add(kaarten.get(i-1+12));
            return kaarts;
        }
        //rechts
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
        //onder
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
        //links
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
}
