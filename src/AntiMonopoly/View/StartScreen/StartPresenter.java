package AntiMonopoly.View.StartScreen;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.DrieSpelers.DrieSpelersPresenter;
import AntiMonopoly.View.DrieSpelers.DrieSpelersView;
import AntiMonopoly.View.TweeSpelers.TweeSpelersPresenter;
import AntiMonopoly.View.TweeSpelers.TweeSpelersView;
import AntiMonopoly.View.VierSpelers.VierSpelersPresenter;
import AntiMonopoly.View.VierSpelers.VierSpelersView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class StartPresenter {

    private AntiMonopolyMain model;
    private StartView view;

    public StartPresenter(AntiMonopolyMain model, StartView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        view.getAs3().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (StartView.getAs2().getValue().equals("2")) {
                    TweeSpelersView tweeSpelersView = new TweeSpelersView();
                    TweeSpelersPresenter tweeSpelersPresenter = new TweeSpelersPresenter(model, tweeSpelersView);
                    view.getScene().getStylesheets().add("/stylesheets/aantalSpelers.css");
                    view.getScene().setRoot(tweeSpelersView);
                    tweeSpelersView.getScene().getWindow().sizeToScene();
                } else {
                    if (StartView.getAs2().getValue().equals("3")) {
                        DrieSpelersView drieSpelersView = new DrieSpelersView();
                        DrieSpelersPresenter drieSpelersPresenter = new DrieSpelersPresenter(model, drieSpelersView);
                        view.getScene().getStylesheets().add("/stylesheets/aantalSpelers.css");
                        view.getScene().setRoot(drieSpelersView);
                        drieSpelersView.getScene().getWindow().sizeToScene();
                    } else {
                        if(StartView.getAs2().getValue().equals("4")) {
                            VierSpelersView vierSpelersView = new VierSpelersView();
                            VierSpelersPresenter vierSpelersPresenter = new VierSpelersPresenter(model, vierSpelersView);
                            view.getScene().getStylesheets().add("/stylesheets/aantalSpelers.css");
                            view.getScene().setRoot(vierSpelersView);
                            vierSpelersView.getScene().getWindow().sizeToScene();
                        }
                    }
                }
            }
        });
    }

    private void updateView () {
        // Vult de view met data uit model
    }

    public void addWindowEventHandlers () {                                                 // melding als je spel wilt afsluiten
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Spel afsluiten");
                alert.setContentText("Bent u zeker?");
                alert.setTitle("Afsluiten");
                alert.getButtonTypes().clear();
                ButtonType nee = new ButtonType("Nee");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(nee,ja);
                alert.showAndWait();
                if(alert.getResult() == null || alert.getResult().equals(nee)) {
                    windowEvent.consume();
                }
            }
        });
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }


}

