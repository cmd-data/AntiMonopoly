package AntiMonopoly.View.VierSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.LocalDateTime;

/**
 * @author Bram Verheyen
 * @version 1.0 13/03/2020 16:38
 */
public class VierSpelersPresenter {
    private AntiMonopolyMain model;
    private VierSpelersView view;


    public VierSpelersPresenter(AntiMonopolyMain model, VierSpelersView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        view.getVs14().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMetPionView mainView = new MainMetPionView();
                MainMetPionPresenter mainMetPionPresenter = new MainMetPionPresenter(model, mainView);
                view.getScene().getStylesheets().add("/stylesheets/main.css");
                view.getScene().setRoot(mainView);
                mainView.getScene().getWindow().sizeToScene();
                mainView.getMainView().getS11().setText(VierSpelersView.getVs6().getText());
                mainView.getMainView().getS21().setText(VierSpelersView.getVs7().getText());
                mainView.getMainView().getS31().setText(VierSpelersView.getVs8().getText());
                mainView.getMainView().getS41().setText(VierSpelersView.getVs9().getText());
                mainView.getMainView().getS12().setText("€1500000");
                mainView.getMainView().getS22().setText("€1500000");
                mainView.getMainView().getS32().setText("€1500000");
                mainView.getMainView().getS42().setText("€1500000");

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
