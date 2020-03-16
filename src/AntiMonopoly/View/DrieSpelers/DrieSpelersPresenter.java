package AntiMonopoly.View.DrieSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.LocalDateTime;


public class DrieSpelersPresenter {
    private AntiMonopolyMain model;
    private DrieSpelersView view;

    public DrieSpelersPresenter(AntiMonopolyMain model, DrieSpelersView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        view.getDs11().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMetPionView mainView = new MainMetPionView();
                MainMetPionPresenter mainMetPionPresenter = new MainMetPionPresenter(model, mainView);
                view.getScene().getStylesheets().add("/stylesheets/main.css");
                view.getScene().setRoot(mainView);
                mainView.getScene().getWindow().sizeToScene();
                mainView.getMainView().getS11().setText(DrieSpelersView.getDs5().getText());
                mainView.getMainView().getS21().setText(DrieSpelersView.getDs6().getText());
                mainView.getMainView().getS31().setText(DrieSpelersView.getDs7().getText());
                mainView.getMainView().getS12().setText("€1500000");
                mainView.getMainView().getS22().setText("€1500000");
                mainView.getMainView().getS32().setText("€1500000");

                Spel.maakSpelers();
                Spel spel = new Spel(LocalDateTime.now());
            }
        });
    }


    private void updateView() {
        // Vult de view met data uit model
    }

    public static void addWindowEventHandlers(){
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
