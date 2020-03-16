package AntiMonopoly.View.TweeSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.LocalDateTime;

public class TweeSpelersPresenter {

    private AntiMonopolyMain model;
    private TweeSpelersView view;

    public TweeSpelersPresenter(AntiMonopolyMain model, TweeSpelersView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        view.getTs8().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMetPionView mainView = new MainMetPionView();
                MainMetPionPresenter mainMetPionPresenterain = new MainMetPionPresenter(model, mainView);
                view.getScene().getStylesheets().add("/stylesheets/main.css");
                view.getScene().setRoot(mainView);
                mainView.getScene().getWindow().sizeToScene();
                mainView.getMainView().getS11().setText(TweeSpelersView.getTs4().getText());
                mainView.getMainView().getS21().setText(TweeSpelersView.getTs5().getText());
                mainView.getMainView().getS12().setText("€1500000");
                mainView.getMainView().getS22().setText("€1500000");

                Spel.maakSpelers();
                Spel spel = new Spel(LocalDateTime.now());

            }
        });
    }


    private void updateView() {

    }

    public static void addWindowEventHandlers(){
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
