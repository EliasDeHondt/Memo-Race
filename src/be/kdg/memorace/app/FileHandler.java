package be.kdg.memorace.app;

import be.kdg.memorace.model.Player;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Vera Wise & Elias De Hondt
 * 8/12/2022
 */
public class FileHandler {
    // Methods
    public static String[] readLog(String url) throws IOException { // Read
        List<String> lines = Files.readAllLines(Paths.get(url));
        return lines.toArray(new String[0]);
    }
    public static void writeStartUpLog(String filename, String message) throws IOException { // Write
        write(filename, message);
    }
    public static void writeErrorLog(String filename, String errorMessage) throws IOException { // Write
        write(filename, errorMessage);
    }

    private static void write(String filename, String errorMessage) throws IOException { // Write
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String[] data = {timestamp, errorMessage};
        FileWriter writer = new FileWriter(filename, true);
        writer.append(String.join(" ", data));
        writer.append("\n");
        writer.flush();
        writer.close();
    }

    public static void writePlayersLog(String filename, List<Player> players) throws IOException { // Write
        FileWriter writer = new FileWriter(filename, true);
        File file = new File(filename); // Temp file
        boolean fileExists = file.exists(); // Check if the file already exists
        if (!fileExists) { // Check if the file already exists
            writer.append("name,score\n"); // Add name columns
        }
        for (Player player : players) {
            String name = player.getName();
            String score = String.valueOf(player.getScore());
            writer.append(name);
            writer.append(",");
            writer.append(score);
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }
}
