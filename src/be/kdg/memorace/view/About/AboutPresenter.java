package be.kdg.memorace.view.About;

import be.kdg.memorace.model.Memorace;

import static be.kdg.memorace.app.MusicHandler.clickSound;

/**
 * Van Elias De Hondt
 * 1/03/2023
 */
public class AboutPresenter {
    // Attributes
    private final Memorace model;
    private final AboutView aboutView;
    // Constructors
    public AboutPresenter(Memorace model, AboutView aboutView) {
        this.model = model;
        this.aboutView = aboutView;
        this.addEventHandlers();
    }
    // Methods
    private void addEventHandlers() {
        this.aboutView.getOk().setOnAction(event -> {
            clickSound(this.model.getVolumeButton()); // Play sound when you click the button
            this.aboutView.getScene().getWindow().hide();
        });
    }
}
