package be.kdg.memorace.view.About;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * Van Elias De Hondt
 * 1/03/2023
 */
public class AboutView extends BorderPane {
    // Attributes
    private TextArea data;
    private Button ok;
    // Constructors
    public AboutView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    // Methods
    private void initialiseNodes() {
        this.ok = new Button("Ok");
        this.data = new TextArea("""
                Vera en Elias, twee programmeurs zo knap,
                Ze hebben samen iets heel leuks gemaakt:
                MemoRace, een spel om het brein te prikkelen,
                Met kleuren, cijfers en patronen om te onthullen.
                                
                Ze zaten dagenlang achter hun computerscherm,
                Programmeerden en debugden zonder enig gejengel,
                En toen ze het spel eindelijk af hadden,
                Waren ze beiden zo trots als een pauw met z'n vederpracht.
                                
                MemoRace was een succes, iedereen speelde het graag,
                En Vera en Elias bleven samenwerken, dag na dag,
                Ze bedachten nieuwe levels, uitdagingen en twists,
                En hielden het spel fris en interessant voor de spelers, steeds weer een nieuw list.
                                
                Vera en Elias, zo'n geweldig team,
                Ze hadden iets gecreëerd uit hun gezamenlijke droom,
                MemoRace, een spel om nooit te vergeten,
                Dankzij hun inzet en creativiteit, zo onbeperkt en onbeletten.
                """);
    }

    private void layoutNodes() {
        // CSS For (ok)
        this.ok.setId("buttonOK");
        // Set the text areas to be read-only
        this.data.setEditable(false);

        setCenter(this.data);
        setPadding(new Insets(10));
        BorderPane.setAlignment(this.ok, Pos.CENTER_RIGHT);
        BorderPane.setMargin(this.ok, new Insets(10, 0, 0, 0));
        setBottom(this.ok);
    }
    Button getOk() {
        return this.ok;
    }
}
