package AntiMonopoly.View.TweeSpelers;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spel;
import AntiMonopoly.View.MainMetPion.MainMetPionPresenter;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

                MainView.getS15().setText(TweeSpelersView.getTs6().getValue());
                MainView.getS25().setText(TweeSpelersView.getTs7().getValue());

                Spel.updateGeld();

                mainView.getMainView().getS13().setImage(new Image("images/" + Spel.getSpelers().get(0).getPion() + ".png"));
                mainView.getMainView().getS23().setImage(new Image("images/" + Spel.getSpelers().get(1).getPion() + ".png"));

                Spel spel = new Spel(LocalDateTime.now());

                final Stage dialog0 = new Stage();
                dialog0.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVBox0 = new VBox();
                dialog0.setTitle("Volgorde");
                Button button0 = new Button("OK");
                dialogVBox0.getChildren().addAll(new Text("Speler '" + Spel.getSpelers().get(0).getNaam() + "' begint."),button0);
                Scene dialogScene0 = new Scene(dialogVBox0, 300, 250);
                dialogVBox0.setAlignment(Pos.CENTER);
                dialogVBox0.setSpacing(10);
                dialogVBox0.setStyle("-fx-font: 20px Tahoma");
                dialog0.setScene(dialogScene0);
                dialog0.show();

                button0.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Spel.updateAanZet();
                        dialog0.close();
                    }
                });
            }
        });
    }


    private void updateView() {

    }

}
