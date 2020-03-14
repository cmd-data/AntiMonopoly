package AntiMonopoly;

import AntiMonopoly.View.MainScreen.MainPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.MainScreen.MainView;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AntiMonopolyMain model = new AntiMonopolyMain();
        MainView view = new MainView();
        MainPresenter antiMonopolyPresenter = new MainPresenter();
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
