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
    private TextField vs6,vs7,vs8,vs9;
    private ComboBox<String> vs10,vs11,vs12,vs13;
    private Button vs14;
    private VBox vierSpelers;

    public VierSpelersView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        this.vs1 = new Label("Geef de namen van de drie spelers in: ");
        //Speler1
        this.vs2 = new Label("Naam speler 1: ");
        this.vs6 = new TextField();
        this.vs10 = new ComboBox<>();
        ObservableList<String> deTweeSpelers =
                FXCollections.observableArrayList("Monopolist","Concurrent");
        this.vs10.setItems(deTweeSpelers);
        this.vs10.getSelectionModel().select(0);
        //Speler2
        this.vs3 = new Label("Naam speler 2: ");
        this.vs7 = new TextField();
        this.vs11 = new ComboBox<>();
        this.vs11.setItems(deTweeSpelers);
        this.vs11.getSelectionModel().select(0);
        //Speler3
        this.vs4 = new Label("Naam speler 3: ");
        this.vs8 = new TextField();
        this.vs12 = new ComboBox<>();
        this.vs12.setItems(deTweeSpelers);
        this.vs12.getSelectionModel().select(0);
        //Speler4
        this.vs5 = new Label("Naam speler 4: ");
        this.vs9 = new TextField();
        this.vs13 = new ComboBox<>();
        this.vs13.setItems(deTweeSpelers);
        this.vs13.getSelectionModel().select(0);
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

    public TextField getVs6() {
        return vs6;
    }

    public TextField getVs7() {
        return vs7;
    }

    public TextField getVs8() {
        return vs8;
    }

    public TextField getVs9() {
        return vs9;
    }

    public ComboBox<String> getVs10() {
        return vs10;
    }

    public ComboBox<String> getVs11() {
        return vs11;
    }

    public ComboBox<String> getVs12() {
        return vs12;
    }

    public ComboBox<String> getVs13() {
        return vs13;
    }
}
