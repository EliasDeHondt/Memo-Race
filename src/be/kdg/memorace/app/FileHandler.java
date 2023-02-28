package be.kdg.memorace.app;

import javafx.scene.control.Alert;

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
    public static String[] readLog(String url) { // Read
        try {
            List<String> lines = Files.readAllLines(Paths.get(url));
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            String errorMessage = "(readLog) Our apologies, there seem to be an issue with our file system handler. :-(";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(errorMessage);
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
            writeErrorLog("resources/log/errorLog.txt", errorMessage); // The file handler error will also be placed in a log.
        }
        return null;
    }
    public static void writeStartUpLog(String filename, String message) { // Write
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String[] data = {timestamp, message};
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.append(String.join(" ", data));
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            String errorMessage = "(writeStartUpLog) Our apologies, there seem to be an issue with our file system handler. :-(";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(errorMessage);
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
            writeErrorLog("resources/log/errorLog.txt", errorMessage); // The file handler error will also be placed in a log.
        }
    }
    public static void writeErrorLog(String filename, String errorMessage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String[] data = {timestamp, errorMessage};
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.append(String.join(" ", data));
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("(writeErrorLog) Our apologies, there seem to be an issue with our file system handler. :-(");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
        }
    }
}
