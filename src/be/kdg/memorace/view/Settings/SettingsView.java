package be.kdg.memorace.view.Settings;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Van Elias De Hondt
 * 5/03/2023
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
        this.buttonSoundS = new Slider(0, 100, 50);
        this.themeC = new ComboBox<>();
        this.backgroundSoundL = new Label("Background Sound Volume");
        this.buttonSoundL = new Label("Button Sound Volume");
        this.themeL = new Label("Theme");
        this.save = new Button("Save");
    }
    public void layoutNodes() {
        // Menu opbouwen:
        Menu menu = new Menu("Help");
        menu.getItems().addAll(this.miBack,this.miExit);
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
    public MenuItem getMiBack() { // Get..
        return this.miBack;
    }
    public MenuItem getMiExit() { // Get..
        return this.miExit;
    }
    public Slider getBackgroundSoundS() { // Get..
        return this.backgroundSoundS;
    }
    public Slider getButtonSoundS() { // Get..
        return this.buttonSoundS;
    }
    public ComboBox<String> getTheme() { // Get..
        return this.themeC;
    }
    public Button getSave() { // Get..
        return this.save;
    }
    public void setCustomStage(Stage primaryStage){ // Set..
        this.primaryStage = primaryStage;
    }
    public Stage getCustomStage(){ // Get..
        return this.primaryStage;
    }
}
