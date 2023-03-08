package be.kdg.memorace.view.Won;

import be.kdg.memorace.model.Memorace;
import javafx.scene.control.Alert;

import java.io.IOException;

import static be.kdg.memorace.app.FileHandler.writePlayersLog;

/**
 * Van Elias De Hondt
 * 13/02/2023
 */
public class WonPresenter {
    // Attributes
    private final Memorace model;
    private final WonView wonView;
    // Constructors
    public WonPresenter(Memorace model, WonView wonView) {
        this.model = model;
        this.wonView = wonView;
        this.addEventHandlers();
    }

    // Methods
    private void addEventHandlers() {
        try {
            writePlayersLog("resources/log/playerLog.csv", this.model.getplayers());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("(writePlayersLog) Our apologies, there seem to be an issue with our file system handler. :-(");
            alert.setTitle("File Handler ERROR");
            alert.showAndWait();
        }

    }
}
