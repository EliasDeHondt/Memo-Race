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
            if (this.kaarten.size() == 16) break;}
        Collections.shuffle(this.kaarten);
        // Positie opslaan.
        Kaart[] k = new Kaart[16];
        int x = 1; int y = 4; int teller = -1;
        for (int i = 0; i < this.kaarten.size(); i++) {
            k[i] = new Kaart();
            // Zet de x positie.
            k[i].setX(x);
            kaarten.get(i).setX(x);

            x++; teller++;
            if (x == 5) x = 1; // Ga naar volgende kolom.
            // Zet de y positie.
            if (teller%4 == 0) y++;
            if (y == 9) y = 5;
            k[i].setY(y);
            kaarten.get(i).setY(y); // Ga naar volgende rij.

            System.out.println("kaart " + kaarten.get(i) + ": " + kaarten.get(i).getX() + ", " + kaarten.get(i).getY());
        }
        System.out.println();
//        for (int q = 0; q < this.kaarten.size(); q++) {
//            System.out.println("kaart " + k[q] + ": " + k[q].getX() + ", " + k[q].getY());
//        }
        System.out.println(kaarten);
        this.kaarten.clear();
        this.kaarten.addAll(List.of(k));
//        for (int q = 0; q < this.kaarten.size(); q++) {
//            System.out.println("kaart " + kaarten.get(q) + ": " + kaarten.get(q).getX() + ", " + kaarten.get(q).getY());
//        }
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
            //doe een worp en bepaal de mogelijke kaarten
            List<Kaart> newCards = worp(this.spelers.get(i));
            //geef de opties uit de lijst met mogelijke eerste opties:
            for (int j = 0; j < newCards.size(); j++) {
                System.out.printf("╠ \tOption %d: [%d, %d]\n",j+1,newCards.get(j).getX(),newCards.get(j).getY());
            }
            Scanner keyboard = new Scanner(System.in);
            System.out.print(
                            "║\n" +
                            "╠ Your choice: ");
            int option = keyboard.nextInt();
            //draait de gekozen kaart om en zet die in de spelers kaarten
            Kaart kaart1 = turnChosenCard(option,newCards);

            System.out.print("║\n");
            for (int j = 0; j < kaarten.size(); j++) {
                if ((j)%4 == 0) System.out.print("╠ ");
                System.out.printf("Option %-3d: [%d, %d] \t\t",j+1,kaarten.get(j).getX(),kaarten.get(j).getY());
                if ((j+1)%4 == 0){
                    System.out.println();
                }
            }
            this.printBord();
            System.out.println();
            for (int q = 0; q < this.kaarten.size(); q++) {
                System.out.println("kaart " + kaarten.get(q) + ": " + kaarten.get(q).getX() + ", " + kaarten.get(q).getY());
            }
            System.out.print(
                            "║\n" +
                            "╠ Your choice: ");
            option = keyboard.nextInt();
            //draait de volgend gekozen kaart om
            Kaart kaart2 = new Kaart();
            for (int o = 0; o < kaarten.size();o++){
                if((option-1) == o){
                    kaarten.get(o).omdraaien();
                    kaart2 = kaarten.get(o);
                }
            }
            //check of de 2 omgedraaide kaarten gelijk zijn:
            if(kaart1.getType() == kaart2.getType()){
                //spelers.get(i).getKaarten().get(0).setType(' ');
                System.out.println("====== " + kaart2.getX() + " " + kaart2.getY());
                //getNewKaart(kaart2.getX(),kaart2.getY()).setType(' ');
                for (int o = 0; o < kaarten.size();o++){
                    if(kaart1 == kaarten.get(o)){
                        kaarten.set(i,kaart1);
                        kaarten.get(i).setType(' ');
                    }
                }
                //getNewKaart(spelers.get(i).getKaarten().get(0).getX(),spelers.get(i).getKaarten().get(0).getY());
                kaarten.get(option-1).setType(' ');
            }
            else {
                spelers.get(i).getKaarten().get(0).omdraaien();
                kaarten.get(option-1).omdraaien();
            }
            this.printBord();

        }
        //Geeft de te trekken kaart mogelijkheden adhv de positie.
        //GetValidCards(pion.getPositie());

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
            kaarts.get(0).setX(kaarten.get(i-1).getX());
            kaarts.get(1).setX(kaarten.get(i-1+4).getX());
            kaarts.get(2).setX(kaarten.get(i-1+8).getX());
            kaarts.get(3).setX(kaarten.get(i-1+12).getX());
            kaarts.get(0).setY(kaarten.get(i-1).getY());
            kaarts.get(1).setY(kaarten.get(i-1+4).getY());
            kaarts.get(2).setY(kaarten.get(i-1+8).getY());
            kaarts.get(3).setY(kaarten.get(i-1+12).getY());
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

    public Kaart getNewKaart(int x, int y){
        for (Kaart kaart : kaarten) {
            if(kaart.getY() == y && kaart.getX() == x){
                return kaart;
            }
        }
        return null;
    }

    public List<Kaart> worp(Speler s){
        int tempWorp = this.dobbelsteen.nextInt(1,7);
        this.pion.setPositie(tempWorp);
        List<Kaart> newCards = GetValidCards(tempWorp);
        System.out.printf(ANSI_RESET + """
                    ║
                    ╠[%s you rolled an %d.]
                    ║
                    ╠ Your choices are:
                    """,s.getNaam(),tempWorp);
        return newCards;
    }

    public Kaart turnChosenCard(int option,List<Kaart> newCards){
        switch (option){
            case 1: spelers.get(0).getKaarten().add(getNewKaart(newCards.get(0).getX(),newCards.get(0).getY()));
                    spelers.get(0).getKaarten().get(0).omdraaien();
                    return spelers.get(0).getKaarten().get(0);
            case 2: spelers.get(0).getKaarten().add(getNewKaart(newCards.get(1).getX(),newCards.get(1).getY()));
                    spelers.get(0).getKaarten().get(0).omdraaien();
                    return spelers.get(0).getKaarten().get(0);
            case 3: spelers.get(0).getKaarten().add(getNewKaart(newCards.get(2).getX(),newCards.get(2).getY()));
                    spelers.get(0).getKaarten().get(0).omdraaien();
                    return spelers.get(0).getKaarten().get(0);
            case 4: spelers.get(0).getKaarten().add(getNewKaart(newCards.get(3).getX(),newCards.get(3).getY()));
                    spelers.get(0).getKaarten().get(0).omdraaien();
                    return spelers.get(0).getKaarten().get(0);
            default: return spelers.get(0).getKaarten().get(0);
        }
    }
}