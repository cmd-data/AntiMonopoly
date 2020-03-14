package AntiMonopoly.View.MainMetPion;

import AntiMonopoly.View.Dice.DiceView;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * @author Bram Verheyen
 * @version 1.0 13/03/2020 20:34
 */
public class MainMetPionView extends Group {
    private Canvas canvas;
    private MainView mainView;
    private Rectangle rectangle1, rectangle2;
    private DiceView diceView;

    public  MainMetPionView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(1500,1000);
        this.rectangle1 = new Rectangle(100, 100, 20, 20);
        this.rectangle1.setFill(Color.VIOLET);
        this.rectangle2 = new Rectangle(100, 70, 20, 20);
        this.rectangle2.setFill(Color.GRAY);
        this.mainView = new MainView();
        this.rectangle1.toFront();
        this.diceView = new DiceView(2);
        this.diceView.setLayoutX(750);
        this.diceView.setLayoutY(500);
    }

    private void layoutNodes() {
        this.getChildren().add(this.canvas);
        this.getChildren().add(this.mainView);
        this.getChildren().add(this.rectangle1);
        this.getChildren().add(this.rectangle2);
        this.getChildren().add(this.diceView);

    }

    private void animate() {
// Hier aanvullen
    }

    public MainView getMainView() {
        return mainView;
    }

    public DiceView getDiceView() {
        return diceView;
    }
}
