package AntiMonopoly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.MainScreen.AntiMonopolyPresenter;
import AntiMonopoly.View.MainScreen.AntiMonopolyView;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AntiMonopolyMain model = new AntiMonopolyMain();
        AntiMonopolyView view = new AntiMonopolyView();
        AntiMonopolyPresenter antiMonopolyPresenter = new AntiMonopolyPresenter(model,view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/stylesheets/main.css");
        primaryStage.setScene(scene);
        antiMonopolyPresenter.addWindowEventHandlers();
        primaryStage.setTitle("AntiMonopoly");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
