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
    private static Rectangle rectangle1,rectangle2,rectangle3,rectangle4;
    private DiceView diceView;


    public  MainMetPionView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.animate();
    }

    private void initialiseNodes() {
        this.canvas = new Canvas(1500,1000);
        rectangle1 = new Rectangle(130, 40, 20, 20);
        rectangle1.setFill(Color.VIOLET);
        rectangle2 = new Rectangle(130, 60, 20, 20);
        rectangle2.setFill(Color.GRAY);
        rectangle3 = new Rectangle(130, 80, 20, 20);
        rectangle3.setFill(Color.ALICEBLUE);
        rectangle4 = new Rectangle(130, 100, 20, 20);
        rectangle4.setFill(Color.DARKTURQUOISE);
        this.mainView = new MainView();
        //this.rectangle1.toFront();
        this.diceView = new DiceView(2);
        this.diceView.setLayoutX(750);
        this.diceView.setLayoutY(500);
    }

    private void layoutNodes() {
        this.getChildren().add(this.canvas);
        this.getChildren().add(this.mainView);
        this.getChildren().add(rectangle1);
        this.getChildren().add(rectangle2);
        this.getChildren().add(rectangle3);
        this.getChildren().add(rectangle4);
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

    public static Rectangle getRectangle1() {
        return rectangle1;
    }

    public static Rectangle getRectangle2() {
        return rectangle2;
    }

    public static Rectangle getRectangle3() {
        return rectangle3;
    }

    public static Rectangle getRectangle4() {
        return rectangle4;
    }



}
