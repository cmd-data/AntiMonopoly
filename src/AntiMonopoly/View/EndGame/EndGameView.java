package AntiMonopoly.View.EndGame;

import AntiMonopoly.Model.FaillietWinnaar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EndGameView extends GridPane {

    private Label label1, label2, label3;
    private Button button;


    public EndGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        label1 = new Label("Proficiat " + FaillietWinnaar.isWinnaar().getNaam() + "!");
        label2 = new Label("De andere spelers zijn failliet, u bent gewonnen!");
        label3 = new Label("U beschikt over een kapitaal van €" + FaillietWinnaar.isWinnaar().getGeld());
        button = new Button("OK");
    }

    private void layoutNodes() {
        VBox winnaar = new VBox();
        winnaar.getChildren().addAll(label1,label2,label3,button);
        this.add(winnaar,0,0);
        winnaar.setId("winnaar");
    }

    public Button getButton() {
        return button;
    }
}

