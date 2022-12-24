import App.FileHandler;
import Game.GameBoard;

import javax.swing.*;

/**
 * Vera Wise & Elias De Hondt
 * 08/12/2022
 */
public class DemeJavaFX extends JFrame {
    public void memoRace() {
        GameBoard gameBord = new GameBoard();
    }
    public static void main(String[] args) {
        DemeJavaFX memoRace = new DemeJavaFX();
        memoRace.setVisible(true);
        memoRace.setTitle("Memo Race");
        memoRace.setSize(380,420);
        memoRace.setDefaultCloseOperation(EXIT_ON_CLOSE);
        memoRace.setLocationRelativeTo(null);
        memoRace.setIconImage(FileHandler.loadImages(0));
    }
}
