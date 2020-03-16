package AntiMonopoly.View.DrieSpelers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DrieSpelersView extends GridPane{

    private Label ds1,ds2,ds3,ds4;
    private static TextField ds5,ds6,ds7;
    private ComboBox<String> ds8,ds9,ds10;
    private Button ds11;
    private VBox drieSpelers;

    public DrieSpelersView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.ds1 = new Label("Geef de namen van de drie spelers in: ");
        //Speler1
        this.ds2 = new Label("Naam speler 1: ");
        this.ds5 = new TextField();
        this.ds8 = new ComboBox<>();
        ObservableList<String> deTweeSpelers =
                FXCollections.observableArrayList("Monopolist","Concurrent");
        this.ds8.setItems(deTweeSpelers);
        this.ds8.getSelectionModel().select(0);
        //Speler2
        this.ds3 = new Label("Naam speler 2: ");
        this.ds6 = new TextField();
        this.ds9 = new ComboBox<>();
        this.ds9.setItems(deTweeSpelers);
        this.ds9.getSelectionModel().select(0);
        //Speler3
        this.ds4 = new Label("Naam speler 3: ");
        this.ds7 = new TextField();
        this.ds10 = new ComboBox<>();
        this.ds10.setItems(deTweeSpelers);
        this.ds10.getSelectionModel().select(0);
        //Knop
        this.ds11 = new Button("OK");
    }

    private void layoutNodes() {
        this.drieSpelers = new VBox();
        drieSpelers.getChildren().addAll(ds1,ds2,ds5,ds8,ds3,ds6,ds9,ds4,ds7,ds10,ds11);
        this.add(drieSpelers,0,0);
        drieSpelers.setId("ds");
    }

    public Button getDs11() {
        return ds11;
    }

    public static TextField getDs5() {
        return ds5;
    }

    public static TextField getDs6() {
        return ds6;
    }

    public static TextField getDs7() {
        return ds7;
    }

    public ComboBox<String> getDs8() {
        return ds8;
    }

    public ComboBox<String> getDs9() {
        return ds9;
    }

    public ComboBox<String> getDs10() {
        return ds10;
    }
}
