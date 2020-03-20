package AntiMonopoly.View.EndGame;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.Model.Speler;
import AntiMonopoly.View.StartScreen.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EndGamePresenter {

    AntiMonopolyMain model;
    private EndGameView view;

    public EndGamePresenter(AntiMonopolyMain model, EndGameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getScene().getStylesheets().add("/stylesheets/EndGame.css");
        view.getScene().setRoot(view);
        view.getScene().getWindow().sizeToScene();

        view.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                Stage stage = (Stage) view.getButton().getScene().getWindow();
                stage.close();
            }
        });
    }
}
