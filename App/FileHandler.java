import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 8/12/2022
 */
public class FileHandler {
    // Methods
    public static void readFile(String url) { // Read
        try {
            Scanner file = new Scanner(new File(url));
            while (file.hasNext()) {
                String regel = file.nextLine();
                String[] regelData = regel.split(";");
                int score = Integer.parseInt(regelData[1]);
                System.out.printf("""
                        ╠═════════════════════════════════╗
                        ║     Player name:  %-13s ║
                        ║     Player score: %-13d ║
                        ╠═════════════════════════════════╝
                        """,regelData[0],score);
            }
            file.close();
            Conclusion.exit();
        } catch (FileNotFoundException e) {
            System.out.println(Colour.ANSI_BLACK + "The specified file was not found.\nFor example: GameLog/players.csv");
        }
    }
    public static void writeFile(String url, List<Player> players) { // Write
        try {
            Formatter formatter = new Formatter(url);
            for (Player player : players) {
                formatter.format("%s;%d\n", player.getNaam(), player.getScore());
            }
            formatter.close();
        } catch (IOException e) {
            System.out.println(Colour.ANSI_BLACK + "Specify a correct path and also a correct file name with the correct extension.\nFor example: GameLog/players.csv");
        }
    }
    public Image[] loadImages() {
        Image[] images = {
        new ImageIcon("Resources/Image/path_1.png").getImage(),
        new ImageIcon("Resources/Image/path_2.png").getImage(),
        new ImageIcon("Resources/Image/path_3.png").getImage(),
        new ImageIcon("Resources/Image/path_4.png").getImage(),
        new ImageIcon("Resources/Image/path_5.png").getImage(),
        new ImageIcon("Resources/Image/path_6.png").getImage(),
        new ImageIcon("Resources/Image/path_7.png").getImage(),
        new ImageIcon("Resources/Image/path_8.png").getImage(),
        new ImageIcon("Resources/Image/path_9.png").getImage(),
        new ImageIcon("Resources/Image/path_10.png").getImage(),
        new ImageIcon("Resources/Image/path_11.png").getImage(),
        new ImageIcon("Resources/Image/path_12.png").getImage(),
        new ImageIcon("Resources/Image/path_13.png").getImage(),
        new ImageIcon("Resources/Image/path_14.png").getImage(),
        new ImageIcon("Resources/Image/path_15.png").getImage(),
        new ImageIcon("Resources/Image/path_16.png").getImage(),
        };
        return images;
    }
}
