package AntiMonopoly.View.Dice;

import AntiMonopoly.Model.Dice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class DicePresenter {

    private static final String IMAGE_PACKAGE = "/images";
    private DiceView view;

    public DicePresenter(Dice model, DiceView view,int aantal) {
        Dice model1;
        if(aantal == 2) {
            model1 = model;
            this.view = view;
            updateView2();
            addEventHandlers2();
        } else {
            model1 = model;
            this.view = view;
            updateView();
            addEventHandlers();
        }
    }

    private void updateView() {
        DiceView.getDie1().setImage(new Image(IMAGE_PACKAGE + "/die" + Dice.getWorp1() + ".png"));
    }

    private void updateView2() {
        DiceView.getDie1().setImage(new Image(IMAGE_PACKAGE + "/die" + Dice.getWorp2()[0] + ".png"));
        DiceView.getDie2().setImage(new Image(IMAGE_PACKAGE + "/die" + Dice.getWorp2()[1] + ".png"));
    }

    private void addEventHandlers(){
        view.getRolButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Dice.rollDie();
                updateView();
            }
        });
    }
    
    private void addEventHandlers2() {
        view.getRolButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Dice.rollDice();
                updateView2();
            }
        });
    }
}
