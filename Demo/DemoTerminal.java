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
            case 1: break;
            case 2: System.out.println(gameBord); break; // PrintBoard
            case 3: FileHandler.readFile("Resources/GameLog/players.csv"); break;
            case 4: Conclusion.exit(); break;
        }

        // New Player.
        System.out.print("""
                ╠════════════════════════════╗
                ║     How many players?      ║
                ╠════════════════════════════╝
                """);
        System.out.print("╠➤ ");
        boolean goed = true;
        do {
            try {
                gameBord.newPlayerAantal(keyboard.nextInt());
            } catch (ExceptionPlayer e) {
                System.out.print("""
                        ╠═════════════════════════════════════════════════════════════╗
                        ║ Be aware: the number of players must be above 1 and below 6 ║
                        ╠═════════════════════════════════════════════════════════════╝
                        """);
                goed = false;
            }
        } while (goed);

        for (int i = 1; gameBord.getPlayerAantal() >= i; i++) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Name of player: %1d      ║
                    ╠════════════════════════════╝
                    """, i);
            System.out.print("╠➤ ");
            gameBord.newPlayerName(keyboard.next());
        }

    }
}
