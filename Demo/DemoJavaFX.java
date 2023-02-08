import console.App.FileHandler;
import console.Game.GameBoard;

import javax.swing.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class DemoJavaFX extends JFrame {
    public void memoRace() {
        GameBoard gameBord = new GameBoard();
    }
    public static void main(String[] args) {
        DemoJavaFX memoRace = new DemoJavaFX();
        memoRace.setVisible(true);
        memoRace.setTitle("Memo Race");
        memoRace.setSize(700,700);
        memoRace.setDefaultCloseOperation(EXIT_ON_CLOSE);
        memoRace.setLocationRelativeTo(null);
        memoRace.setIconImage(FileHandler.loadImages(0));
    }
}
