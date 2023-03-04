package be.kdg.memorace.view.Won;

import be.kdg.memorace.model.Memorace;
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
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {
        writePlayersLog("resources/log/playerLog.csv", this.model.getplayers());
    }
    private void updateView() {
        // TODO
    }
}
