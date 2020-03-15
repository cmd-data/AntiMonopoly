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
                if (view.getAs2().getValue().equals("2")) {
                    TweeSpelersView tweeSpelersView = new TweeSpelersView();
                    TweeSpelersPresenter tweeSpelersPresenter = new TweeSpelersPresenter(model, tweeSpelersView);
                    //view.getScene().getStylesheets().add("/stylesheets/main.css");
                    view.getScene().setRoot(tweeSpelersView);
                    tweeSpelersView.getScene().getWindow().sizeToScene();
                } else {
                    if (view.getAs2().getValue().equals("3")) {
                        DrieSpelersView drieSpelersView = new DrieSpelersView();
                        DrieSpelersPresenter drieSpelersPresenter = new DrieSpelersPresenter(model, drieSpelersView);
                        //view.getScene().getStylesheets().add("/stylesheets/main.css");
                        view.getScene().setRoot(drieSpelersView);
                        drieSpelersView.getScene().getWindow().sizeToScene();
                    } else {
                        if(view.getAs2().getValue().equals("4")) {
                            VierSpelersView vierSpelersView = new VierSpelersView();
                            VierSpelersPresenter vierSpelersPresenter = new VierSpelersPresenter(model, vierSpelersView);
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

    public static void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }


}


// view.getAs3().setOnAction(new EventHandler<ActionEvent>() {
//        @Override
//        public void handle(ActionEvent event) {
//            MainView mainView = new MainView();
//            MainPresenter mainPresenter = new MainPresenter(model, mainView);
//            view.getScene().getStylesheets().add("/stylesheets/main.css");
//            view.getScene().setRoot(mainView);
//            mainView.getScene().getWindow().sizeToScene();
//
//        }
//    });


