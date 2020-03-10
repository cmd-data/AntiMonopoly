package AntiMonopoly.View.Dice;

import AntiMonopoly.Model.Dice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class DicePresenter {
    private static final String IMAGES_DICE = "/Dice";

    private Dice model;
    private DiceView view;

    public DicePresenter(Dice model, DiceView view,int aantal) {
        if(aantal == 2) {
            this.model = model;
            this.view = view;
            updateView2();
            addEventHandlers2();
        } else {
            this.model = model;
            this.view = view;
            updateView();
            addEventHandlers();
        }
    }

    private void updateView() {
        view.getDie1().setImage(new Image(IMAGES_DICE + "/" + Dice.getWorp1() + ".png"));
    }

    private void updateView2() {
        view.getDie1().setImage(new Image(IMAGES_DICE + "/" + Dice.getWorp2()[0] + ".png"));
        view.getDie2().setImage(new Image(IMAGES_DICE + "/" + Dice.getWorp2()[1] + ".png"));
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
                Dice.rollDice();
                updateView2();
            }
        });
    }
}
