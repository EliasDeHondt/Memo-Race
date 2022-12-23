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
        start(keyboard,gameBord);

        nieuwSpel(keyboard,gameBord);

        // New Player.
        for (int i = 1; gameBord.getPlayerAantal() >= i; i++) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Name of player: %1d      ║
                    ╠════════════════════════════╝
                    """, i);
            System.out.print("╠➤ ");
            gameBord.newPlayerName(keyboard.next());
            printSpelerKaarten(gameBord);
        }

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
            case 1: nieuwSpel(keyboard,gameBord);
            case 2: System.out.println(gameBord); break; // PrintBoard
            case 3: FileHandler.readFile("Resources/GameLog/players.csv"); break;
            case 4: Conclusion.exit(); break;
        }
    }
    public static void nieuwSpel(Scanner keyboard, GameBoard gameBord) {
        System.out.print("""
        ╠════════════════════════════╗
        ║     How many players?      ║
        ╠════════════════════════════╝
        """);
        System.out.print("╠➤ ");
        int aantal = keyboard.nextInt();
        // Checks if that. The number of players is not too much or too little.
        if (aantal<2 || aantal>6) {
            System.out.print("""
            ╠═════════════════════════════════════════════════════════════╗
            ║ Be aware: the number of players must be above 1 and below 6 ║
            ╠═════════════════════════════════════════════════════════════╝
            """);
            nieuwSpel(keyboard,gameBord);
        }
        for (int i = 1; aantal >= i; i++) {
            System.out.printf("""
            ╠════════════════════════════╗
            ║     Name of player: %1d      ║
            ╠════════════════════════════╝
            """,i);
            System.out.print("╠➤ ");
            gameBord.getSpelers().add(new Player(keyboard.next()));
        }
        gameBord.ronde();
    }

    public static void printSpelerKaarten(GameBoard gameBord) {
        for (Player speler : gameBord.getSpelers()) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Player cards %s        ║
                    ╠════════════════════════════╝
                    """, speler.getKaarten()[0]);
        }
    }
}
