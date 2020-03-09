package AntiMonopoly;

import AntiMonopoly.Model.Dice;
import AntiMonopoly.View.Dice.DicePresenter;
import AntiMonopoly.View.Dice.DiceView;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class DiceMain extends Application {

    /**
     * Exception in Application start method?
     * @param stage
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
        Dice model = new Dice();
        DiceView view = new DiceView();
        DicePresenter presenter = new DicePresenter(model,view);
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();
    }
}
