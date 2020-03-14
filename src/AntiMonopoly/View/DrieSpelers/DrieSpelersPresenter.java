package AntiMonopoly.View.DrieSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainPresenter;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


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
                MainMetPionPresenter mainMetPionPresenterain = new MainMetPionPresenter(model, mainView);
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
