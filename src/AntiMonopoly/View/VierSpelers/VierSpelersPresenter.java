package AntiMonopoly.View.VierSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

                Spel.maakSpelers();

                mainView.getMainView().getS11().setText(Spel.getSpelers().get(0).getNaam());
                mainView.getMainView().getS21().setText(Spel.getSpelers().get(1).getNaam());
                mainView.getMainView().getS31().setText(Spel.getSpelers().get(2).getNaam());
                mainView.getMainView().getS41().setText(Spel.getSpelers().get(3).getNaam());

                MainView.getS12().setText("€1500000");
                MainView.getS22().setText("€1500000");
                MainView.getS32().setText("€1500000");
                MainView.getS42().setText("€1500000");

                mainView.getMainView().getS13().setImage(new Image("images/" + Spel.getSpelers().get(0).getPion() + ".png"));
                mainView.getMainView().getS23().setImage(new Image("images/" + Spel.getSpelers().get(1).getPion() + ".png"));
                mainView.getMainView().getS33().setImage(new Image("images/" + Spel.getSpelers().get(2).getPion() + ".png"));
                mainView.getMainView().getS43().setImage(new Image("images/" + Spel.getSpelers().get(3).getPion() + ".png"));

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
