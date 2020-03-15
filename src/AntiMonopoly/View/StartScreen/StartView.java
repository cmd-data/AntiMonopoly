package AntiMonopoly.View.StartScreen;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class StartView extends GridPane {

    private Label as1;
    private ComboBox<String> as2;
    private Button as3;
    private VBox aantalSpelers;


    public StartView () {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.as1 = new Label("Geef het aantal spelers in: ");
        this.as2 = new ComboBox<>();
        ObservableList<String> hetAantalSpelers =
                FXCollections.observableArrayList("2","3","4");
        this.as2.setItems(hetAantalSpelers);
        this.as2.getSelectionModel().select(0);
        this.as3 = new Button("OK");
    }

    private void layoutNodes() {
        this.aantalSpelers = new VBox();
        aantalSpelers.getChildren().addAll(as1,as2,as3);
        this.add(aantalSpelers,0,0);
        aantalSpelers.setId("as");
    }

    public Button getAs3() {
        return as3;
    }

    public ComboBox<String> getAs2() {
        return as2;
    }


}
