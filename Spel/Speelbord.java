import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class Speelbord {
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
        System.out.println(kaarten);
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
    public void playNewGame() { // Temp
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
        int aantal = this.key.nextInt();
        for (int i = 1; aantal >= i; i++) {
            System.out.printf(
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
            int tempWorp = this.dobbelsteen.nextInt(0,7);
            System.out.printf("""
                    ║
                    ╠[%s you rolled an %d.]
                    ║
                    """,this.spelers.get(i).getNaam(),tempWorp);
            this.pion.setPositie(tempWorp);
            this.printBord();
        }
        //Geeft de te trekken kaart mogelijkheden adhv de positie.
        pion.setPositie(1);
        //GetValidCards();
        System.out.println(GetValidCards()); //test of het werkt.
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
        System.out.print(
                """
                ║
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

    public List<Kaart> GetValidCards(){
        List<Kaart> kaarts = new ArrayList<>(kaarten.size());
        kaarts.addAll(GetCards(pion.getPositie()));
        return kaarts;
    }
    public List<Kaart> GetCards(int i){
        List<Kaart> kaarts = new ArrayList<>(kaarten.size());
        if(i >= 0 && i <= 4){
            kaarts.add(kaarten.get(i-1));
            kaarts.add(kaarten.get(i-1+4));
            kaarts.add(kaarten.get(i-1+8));
            kaarts.add(kaarten.get(i-1+12));
//            kaarts.add(kaarten.get(0));
//            kaarts.add(kaarten.get(4));
//            kaarts.add(kaarten.get(8));
//            kaarts.add(kaarten.get(12));
            return kaarts;
        }
        else if (i >= 5 && i <= 8) {
            kaarts.add(kaarten.get(i-2-3));
            kaarts.add(kaarten.get(i-2-2));
            kaarts.add(kaarten.get(i-2-1));
            kaarts.add(kaarten.get(i-2));
            return kaarts;
        }
        else if (i >= 9 && i <= 12) {
            switch (i) {
                case 9 -> i = 0;
                case 10 -> i = 1;
                case 11 -> i = 2;
                case 12 -> i = 3;
                default -> i = 0;
            }
            kaarts.add(kaarten.get(i)); //3
            kaarts.add(kaarten.get(i+3)); //7
            kaarts.add(kaarten.get(i+8)); //11
            kaarts.add(kaarten.get(i-12)); //15
            return kaarts;
        }
        else { //(i >= 13 && i <= 16)
            kaarts.add(kaarten.get(i+2-3));
            kaarts.add(kaarten.get(i+2-2));
            kaarts.add(kaarten.get(i+2-1));
            kaarts.add(kaarten.get(i+2));
            return kaarts;
        }
    }
}
