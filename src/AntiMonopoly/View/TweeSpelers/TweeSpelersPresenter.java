package AntiMonopoly.View.TweeSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

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

                Spel.maakSpelers();

                mainView.getMainView().getS11().setText(Spel.getSpelers().get(0).getNaam());
                mainView.getMainView().getS21().setText(Spel.getSpelers().get(1).getNaam());

                mainView.getMainView().getS12().setText("€1500000");
                mainView.getMainView().getS22().setText("€1500000");

                mainView.getMainView().getS13().setImage(new Image("images/" + Spel.getSpelers().get(0).getPion() + ".png"));
                mainView.getMainView().getS23().setImage(new Image("images/" + Spel.getSpelers().get(1).getPion() + ".png"));

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
