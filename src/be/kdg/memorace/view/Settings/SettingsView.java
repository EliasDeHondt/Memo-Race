package be.kdg.memorace.view.Settings;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @author Vera Wise
 * @author Elias De Hondt
 * @since 08/12/2022
 */
public class SettingsView extends BorderPane {
    // Attributes
    private MenuItem miBack;
    private MenuItem miExit;
    private Slider backgroundSoundS;
    private Slider buttonSoundS;
    private ComboBox<String> themeC;
    private Label backgroundSoundL;
    private Label buttonSoundL;
    private Label themeL;
    private Button save;
    private Stage primaryStage;

    // Constructors
    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // Methods
    public void initialiseNodes() {
        this.miBack = new MenuItem("Back");
        this.miExit = new MenuItem("Exit");

        this.backgroundSoundS = new Slider(0, 100, 50);
        this.backgroundSoundS.setShowTickLabels(true);
        this.backgroundSoundS.setShowTickMarks(true);
        this.backgroundSoundS.setMajorTickUnit(10);
        this.backgroundSoundS.setMinorTickCount(0);
        this.backgroundSoundS.setSnapToTicks(true);

        this.buttonSoundS = new Slider(0, 100, 50);
        this.buttonSoundS.setShowTickLabels(true);
        this.buttonSoundS.setShowTickMarks(true);
        this.buttonSoundS.setMajorTickUnit(10);
        this.buttonSoundS.setMinorTickCount(0);
        this.buttonSoundS.setSnapToTicks(true);

        this.themeC = new ComboBox<>();
        this.backgroundSoundL = new Label("Background Sound Volume");
        this.buttonSoundL = new Label("Button Sound Volume");
        this.themeL = new Label("Card Theme");
        this.save = new Button("Save");
    }

    public void layoutNodes() {
        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack, this.miExit);
        MenuBar menuBar = new MenuBar(menu);
        this.setTop(menuBar);

        // Add the dropdown menu for the theme
        this.themeC.getItems().addAll("Meme Theme", "Fruit Theme", "Teacher Theme");
        this.themeC.setValue("Meme Theme");


        // Create the layout for the settings menu
        GridPane settingsLayout = new GridPane();
        settingsLayout.setHgap(10);
        settingsLayout.setVgap(10);
        settingsLayout.setPadding(new Insets(10));
        settingsLayout.setAlignment(Pos.CENTER);
        settingsLayout.add(this.backgroundSoundL, 0, 0);
        settingsLayout.add(this.backgroundSoundS, 1, 0);
        settingsLayout.add(this.buttonSoundL, 0, 1);
        settingsLayout.add(this.buttonSoundS, 1, 1);
        settingsLayout.add(this.themeL, 0, 2);
        settingsLayout.add(this.themeC, 1, 2);
        VBox buttonsLayout = new VBox(10);
        buttonsLayout.setAlignment(Pos.CENTER);
        buttonsLayout.getChildren().addAll(this.save);
        settingsLayout.add(buttonsLayout, 0, 3, 2, 1);

        setCenter(settingsLayout);
    }

    MenuItem getMiBack() { // Get..
        return this.miBack;
    }

    MenuItem getMiExit() { // Get..
        return this.miExit;
    }

    Slider getBackgroundSoundS() { // Get..
        return this.backgroundSoundS;
    }

    Slider getButtonSoundS() { // Get..
        return this.buttonSoundS;
    }

    ComboBox<String> getTheme() { // Get..
        return this.themeC;
    }

    Button getSave() { // Get..
        return this.save;
    }

    public void setCustomStage(Stage primaryStage) { // Set..
        this.primaryStage = primaryStage;
    }

    public Stage getCustomStage() { // Get..
        return this.primaryStage;
    }
}