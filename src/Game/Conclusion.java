package Game;

/**
 * Vera Wise & Elias De Hondt
 * 8/12/2022
 */
public class Conclusion {
    // Methods
    public static void exit() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║         Goodbye 🤙         ║
        ╚════════════════════════════╝
        """);
        System.exit(1);
    }
    public static void won() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║      You have won 🤙       ║
        ╚════════════════════════════╝
        """);
        System.exit(1);
    }
    public static void draw() {
        System.out.print("""
        ║
        ╠════════════════════════════╗
        ║       It's a draw 🤙       ║
        ╚════════════════════════════╝
        """);
        System.exit(1);
    }
}
