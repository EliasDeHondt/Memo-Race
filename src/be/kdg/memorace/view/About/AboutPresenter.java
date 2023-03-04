package be.kdg.memorace.view.About;

import be.kdg.memorace.model.Memorace;

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
        this.aboutView.getOk().setOnAction(event -> this.aboutView.getScene().getWindow().hide());
    }
}
