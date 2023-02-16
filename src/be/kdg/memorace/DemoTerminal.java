package be.kdg.memorace;

import be.kdg.memorace.model.App.ExceptionPlayer;
import be.kdg.memorace.model.App.FileHandler;
import be.kdg.memorace.model.*;

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
                        ║
                        """);
        System.out.print("╠➤ ");
        switch (keyboard.nextInt()) {
            case 1 -> nieuwSpel(keyboard, gameBord);
            case 2 -> System.out.println(gameBord); // PrintBoard
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
                gameBord.newPlayerQuantity(keyboard.nextInt());
            } catch (ExceptionPlayer e) {
                System.out.print("""
                ╠═════════════════════════════════════════════════════════════╗
                ║ Be aware: the number of players must be above 1 and below 6 ║
                ╠═════════════════════════════════════════════════════════════╝
                """);
                x = true;
            }
        } while (x);

        for (int i = 1; gameBord.getPlayerQuantity() >= i; i++) {
            System.out.printf("""
                    ╠════════════════════════════╗
                    ║     Name of player: %1d      ║
                    ╠════════════════════════════╝
                    """, i);
            System.out.print("╠➤ ");
            gameBord.newPlayerName(keyboard.next());
        }
//        gameBord.ronde();
    }

    public static void printSpelerKaarten(GameBoard gameBord) {
        for (Player speler : gameBord.getPlayers()) {
            System.out.printf("""
                    ║
                    ╠════════════════════════════════════════════════════╗
                    ║     Player %s cards: %s         ║
                    ╠════════════════════════════════════════════════════╝
                    ║
                    """, speler.getName(), Arrays.toString(speler.getCards()));
        }
    }
}
