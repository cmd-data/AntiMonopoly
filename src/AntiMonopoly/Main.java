package AntiMonopoly;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.View.StartScreen.StartPresenter;
import AntiMonopoly.View.StartScreen.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AntiMonopolyMain model = new AntiMonopolyMain();
        StartView view = new StartView();
        StartPresenter startPresenter = new StartPresenter(model,view);
        Scene scene = new Scene(view);
        //scene.getStylesheets().add("/stylesheets/main.css");
        scene.getStylesheets().add("/stylesheets/start.css");
        primaryStage.setScene(scene);
        startPresenter.addWindowEventHandlers();
        primaryStage.setTitle("AntiMonopoly");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
