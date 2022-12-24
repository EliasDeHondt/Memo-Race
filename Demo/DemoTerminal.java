import App.*;
import Game.*;

import java.util.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class DemoTerminal {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // New Game Board.
        GameBoard gameBord = new GameBoard();

        // Start.
        start(keyboard, gameBord);

        //nieuwSpel(keyboard,gameBord);

        // New Player.
        //gameBord.newPlayerName(keyboard.next());
        printSpelerKaarten(gameBord);

    }

    public static void start(Scanner keyboard, GameBoard gameBord) {
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
        switch (keyboard.nextInt()) {
            case 1 -> nieuwSpel(keyboard, gameBord);
            case 2 -> System.out.println(gameBord); // PrintBoard
            case 3 -> scoreBoard();
            case 4 -> Conclusion.exit();
        }
    }

    public static void nieuwSpel(Scanner keyboard, GameBoard gameBord) {
        boolean x = false;
        do {
            try {
                System.out.print("""
                ╠════════════════════════════╗
                ║     How many players?      ║
                ╠════════════════════════════╝
                """);
                System.out.print("╠➤ ");
                gameBord.newPlayerAantal(keyboard.nextInt());
            } catch (ExceptionPlayer e) {
                System.out.print("""
                ╠═════════════════════════════════════════════════════════════╗
                ║ Be aware: the number of players must be above 1 and below 6 ║
                ╠═════════════════════════════════════════════════════════════╝
                """);
                x = true;
            }
        } while (x);

        for (int i = 1; gameBord.getPlayerAantal() >= i; i++) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Name of player: %1d      ║
                    ╠════════════════════════════╝
                    """, i);
            System.out.print("╠➤ ");
            gameBord.newPlayerName(keyboard.next());
        }


        gameBord.ronde();
    }

    public static void printSpelerKaarten(GameBoard gameBord) {
        for (Player speler : gameBord.getSpelers()) {
            System.out.printf("""
                    ║
                    ╠════════════════════════════════════════════════════╗
                    ║     Player %s cards: %s         ║
                    ╠════════════════════════════════════════════════════╝
                    ║
                    """, speler.getNaam(), Arrays.toString(speler.getKaarten()));
        }
    }

    public static void scoreBoard() {
        for (int i = 0; i <= 3; i++) {
            String[] regelData = FileHandler.readFile("Resources/GameLog/players.csv", i);
            assert regelData != null;
            int score = Integer.parseInt(regelData[1]);
            System.out.printf("""
                    ╠═════════════════════════════════╗
                    ║     Player name:  %-13s ║
                    ║     Player score: %-13d ║
                    ╠═════════════════════════════════╝
                    """, regelData[0], score);
        }
        Conclusion.exit();
    }
}
