package AntiMonopoly.View.TweeSpelers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TweeSpelersView extends GridPane {

    private Label ts1,ts2,ts3;
    private static TextField ts4, ts5;
    private static ComboBox<String> ts6,ts7;
    private Button ts8;
    private VBox tweeSpelers;

    public TweeSpelersView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.ts1 = new Label("Geef de namen van de twee spelers in: ");
        //Speler1
        this.ts2 = new Label("Naam speler 1: ");
        ts4 = new TextField();
        ts6 = new ComboBox<>();
        ObservableList<String> deTweeSpelers =
                FXCollections.observableArrayList("Monopolist","Concurrent");
        ts6.setItems(deTweeSpelers);
        ts6.getSelectionModel().select(0);
        //speler2
        this.ts3 = new Label("Naam speler 2: ");
        ts5 = new TextField();
        ts7 = new ComboBox<>();
        ts7.setItems(deTweeSpelers);
        ts7.getSelectionModel().select(0);
        //knop
        this.ts8 = new Button("OK");
    }

    private void layoutNodes() {
        this.tweeSpelers = new VBox();
        tweeSpelers.getChildren().addAll(ts1,ts2,ts4,ts6,ts3,ts5,ts7,ts8);
        this.add(tweeSpelers,0,0);
        tweeSpelers.setId("ts");
    }

    public static ComboBox<String> getTs6() {
        return ts6;
    }

    public static ComboBox<String> getTs7() {
        return ts7;
    }

    public Button getTs8() {
        return ts8;
    }

    public static TextField getTs4() {
        return ts4;
    }

    public static TextField getTs5() {
        return ts5;
    }

}
