import java.util.Scanner;

/**
 * Van Elias De Hondt
 * 8/12/2022
 */
public class Start {
    // Attributen
    // Constructors
    // Methode
    public void menu() {
        Scanner key = new Scanner(System.in);
        System.out.print(
                """
                ╔════════════════════════════╗
                ║    Welcome to Memo Race    ║
                ╠════════════════════════════╝
                ╠[1 Play new game⌛]
                ╠[2 Settings🔧]
                ╠[3 Exit❌]
                ║
                """);
        System.out.print("╠➤ ");
        switch (key.nextInt()) {
            case 1 -> System.exit(0); // this.playNewGame();
            case 2 -> System.exit(0); // this.settings();
            case 3 -> System.exit(0); // this.exit(0)
        }
    }
}
