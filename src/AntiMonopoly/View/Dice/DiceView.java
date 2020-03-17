package AntiMonopoly.View.Dice;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DiceView extends GridPane {
    private static ImageView die1, die2;
    private Button rolButton;
    GridPane pane;

    public DiceView(int aantal) {
       if (aantal == 2) {
           initialiseNodes();
           layoutNodes2();
       } else {
           initialiseNodes();
           layoutNodes();
       }
    }

    private void initialiseNodes() {
        die1 = new ImageView();
        die2 = new ImageView();
        rolButton = new Button();
        rolButton.setGraphic(new ImageView("/images/dice.png"));
        pane = new GridPane();
        pane.setStyle("-fx-background-color: black");
    }

    private void layoutNodes(){
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        this.add(die1,1,0);
        this.add(rolButton,0,1,2,1);
        GridPane.setHalignment(rolButton, HPos.CENTER);
    }

    private void layoutNodes2() {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        this.add(die1,0,0);
        this.add(die2,1,0);
        this.add(rolButton,0,1,2,1);
        GridPane.setHalignment(rolButton, HPos.CENTER);
    }

    public static ImageView getDie1() { return die1; }

    public static ImageView getDie2() { return die2; }

    public Button getRolButton() { return rolButton; }
}
