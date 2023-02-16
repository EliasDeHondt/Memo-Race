package be.kdg.memorace.model.App;

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("The specified file was not found.\nFor example: GameLog/players.csv");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
        }
        return null;
    }
    public static void writeLog(String filename, String message) {
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Specify a correct path and also a correct file name with the correct extension.\nFor example: GameLog/players.csv");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
        }
    }
}
