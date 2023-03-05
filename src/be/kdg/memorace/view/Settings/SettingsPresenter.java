package be.kdg.memorace.view.Settings;

import be.kdg.memorace.model.Memorace;

/**
 * Van Elias De Hondt
 * 5/03/2023
 */
public class SettingsPresenter {
    // Attributes
    private final Memorace model;
    private final SettingsView settingsView;
    // Constructors
    public SettingsPresenter(Memorace model, SettingsView settingsView) {
        this.model = model;
        this.settingsView = settingsView;
        this.addEventHandlers();
        this.updateView();
    }
    // Methods
    private void addEventHandlers() {

    }
    private void updateView() {

    }
}
