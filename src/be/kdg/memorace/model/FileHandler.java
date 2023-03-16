package be.kdg.memorace.model;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * A class for handling file input and output.
 * Allows reading from and writing to log files, as well as writing player information to a CSV file.
 *
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class FileHandler {
    // Methods

    /**
     * Reads a log file and returns its contents as a String array.
     *
     * @param url the URL of the file to be read
     * @return a String array containing the contents of the file
     * @throws IOException if an I/O error occurs
     */
    public static String[] readLog(String url) throws IOException { // Read
        List<String> lines = Files.readAllLines(Paths.get(url));
        return lines.toArray(new String[0]);
    }

    /**
     * Writes a message to a log file with a timestamp.
     *
     * @param filename the name of the file to be written to
     * @param message  the message to be written
     * @throws IOException if an I/O error occurs
     */
    public static void writeStartUpLog(String filename, String message) throws IOException { // Write
        write(filename, message);
    }

    /**
     * Writes an error message to a log file with a timestamp.
     *
     * @param filename     the name of the file to be written to
     * @param errorMessage the error message to be written
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Writes player information to a CSV file, with one row per player.
     *
     * @param filename the name of the file to be written to
     * @param players  a List of Player objects to be written to the file
     * @throws IOException if an I/O error occurs
     */
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