package AntiMonopoly.View.VierSpelers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;



/**
 * @author Bram Verheyen
 * @version 1.0 13/03/2020 16:37
 */
public class VierSpelersView extends GridPane {

    private Label vs1,vs2,vs3,vs4,vs5;
    private static TextField vs6,vs7,vs8,vs9;
    private static ComboBox<String> vs10,vs11,vs12,vs13;
    private Button vs14;
    private VBox vierSpelers;

    public VierSpelersView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        this.vs1 = new Label("Geef de namen van de vier spelers in: ");
        //Speler1
        this.vs2 = new Label("Naam speler 1: ");
        vs6 = new TextField();
        vs10 = new ComboBox<>();
        ObservableList<String> deTweeSpelers =
                FXCollections.observableArrayList("Monopolist","Concurrent");
        vs10.setItems(deTweeSpelers);
        vs10.getSelectionModel().select(0);
        //Speler2
        this.vs3 = new Label("Naam speler 2: ");
        vs7 = new TextField();
        vs11 = new ComboBox<>();
        vs11.setItems(deTweeSpelers);
        vs11.getSelectionModel().select(0);
        //Speler3
        this.vs4 = new Label("Naam speler 3: ");
        vs8 = new TextField();
        vs12 = new ComboBox<>();
        vs12.setItems(deTweeSpelers);
        vs12.getSelectionModel().select(0);
        //Speler4
        this.vs5 = new Label("Naam speler 4: ");
        vs9 = new TextField();
        vs13 = new ComboBox<>();
        vs13.setItems(deTweeSpelers);
        vs13.getSelectionModel().select(0);
        //Knop
        this.vs14 = new Button("OK");
    }
    private void layoutNodes() {
        this.vierSpelers = new VBox();
        vierSpelers.getChildren().addAll(vs1,vs2,vs6,vs10,vs3,vs7,vs11,vs4,vs8,vs12,vs5,vs9,vs13,vs14);
        this.add(vierSpelers,0,0);
        vierSpelers.setId("vs");
    }

    public Button getVs14() {
        return vs14;
    }

    public static TextField getVs6() {
        return vs6;
    }

    public static TextField getVs7() {
        return vs7;
    }

    public static TextField getVs8() {
        return vs8;
    }

    public static TextField getVs9() {
        return vs9;
    }

    public static ComboBox<String> getVs10() {
        return vs10;
    }

    public static ComboBox<String> getVs11() {
        return vs11;
    }

    public static ComboBox<String> getVs12() {
        return vs12;
    }

    public static ComboBox<String> getVs13() {
        return vs13;
    }
}
