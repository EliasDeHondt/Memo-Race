package App;

import Game.*;

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
    public static String[] readFile(String url, int index) { // Read
        // The URL variable is the path where the file to be read is located. The index is the line that will be read and returned.
        // A little obvious if I say so myself, but still useful I guess :). [And Vera If you're reading this, no touchy :) ].
        int i = 0;
        try {
            Scanner file = new Scanner(new File(url));
            while (file.hasNext()) {
                String regel = file.nextLine();
                String[] regelData = regel.split(";");
                if (i ==index ) return regelData;
                else i++;

            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println(Colour.ANSI_BLACK + "The specified file was not found.\nFor example: GameLog/players.csv");
        }
        return null;
    }

    public static void writeFile(String url, List<Player> players) { // Write
        // The URL variable is the path where the file to be read is located.
        // The list That is specified will be added. At the file location.
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

    public static Image loadImages(int index) {
        return switch (index) {
            case 0 -> new ImageIcon("Resources/Image/question_mark.png").getImage();
            case 1 -> new ImageIcon("Resources/Image/path_1.png").getImage();
            case 2 -> new ImageIcon("Resources/Image/path_2.png").getImage();
            case 3 -> new ImageIcon("Resources/Image/path_3.png").getImage();
            case 4 -> new ImageIcon("Resources/Image/path_4.png").getImage();
            case 5 -> new ImageIcon("Resources/Image/path_5.png").getImage();
            case 6 -> new ImageIcon("Resources/Image/path_6.png").getImage();
            case 7 -> new ImageIcon("Resources/Image/path_7.png").getImage();
            case 8 -> new ImageIcon("Resources/Image/path_8.png").getImage();
            case 9 -> new ImageIcon("Resources/Image/path_9.png").getImage();
            case 10 -> new ImageIcon("Resources/Image/path_10.png").getImage();
            case 11 -> new ImageIcon("Resources/Image/path_11.png").getImage();
            case 12 -> new ImageIcon("Resources/Image/path_12.png").getImage();
            case 13 -> new ImageIcon("Resources/Image/path_13.png").getImage();
            case 14 -> new ImageIcon("Resources/Image/path_14.png").getImage();
            case 15 -> new ImageIcon("Resources/Image/path_15.png").getImage();
            case 16 -> new ImageIcon("Resources/Image/path_16.png").getImage();
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }
}
