package be.kdg.MemoRace.model.App;

import be.kdg.MemoRace.view.*;
import be.kdg.MemoRace.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

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
                if (i == index) return regelData;
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
                formatter.format("%s;%d\n", player.getName(), player.getScore());
            }
            formatter.close();
        } catch (IOException e) {
            System.out.println(Colour.ANSI_BLACK + "Specify a correct path and also a correct file name with the correct extension.\nFor example: GameLog/players.csv");
        }
    }
}
