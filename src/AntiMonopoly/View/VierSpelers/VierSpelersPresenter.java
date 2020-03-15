package AntiMonopoly.View.VierSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainPresenter;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
