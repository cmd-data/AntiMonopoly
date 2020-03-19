package AntiMonopoly.View.MainScreen;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Spelregels;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainPresenter {

    private AntiMonopolyMain model;
    private MainView view;


    public MainPresenter(AntiMonopolyMain model, MainView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        //Straten
        //Rue Grande, Dinant
        view.getRg2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Grande");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €60.000"), new Text("Huur: €6.000"),
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Diestsestraat, Leuven
        view.getDs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Diestsestraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €60.000"), new Text("Huur: €6.000"),
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        // Steenstraat, Brugge
        view.getSs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Steenstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €100.000"), new Text("Huur: €10.000"),
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place Du Monument Spa
        view.getPdm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place Du Monument");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €100.000"), new Text("Huur: €10.000"),
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Kapellestraat, Oostende
        view.getKs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Kapellestraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €120.000"), new Text("Huur: €12.000"),
                                new Text("Hypotheek: €60.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue De Diekirch, Arlon
        view.getRdd2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue De Diekirch");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €140.000"), new Text("Huur: €14.000"),
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Bruul, Mechelen
        view.getB2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Bruul");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €140.000"), new Text("Huur: €14.000"),
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place Verte, Verviers
        view.getPv2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place Verte");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €160.000"), new Text("Huur: €16.000"),
                                new Text("Hypotheek: €80.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Lippenslaan, Knokke
        view.getLl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Lippenslaan");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €180.000"), new Text("Huur: €18.000"),
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue Royale, Tournai
        view.getRr2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Royal");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €180.000"), new Text("Huur: €18.000"),
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });


        //Groenplaats, Antwerpen
        view.getGp2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Groenplaats");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Text("Huur: €20.000"),
                                new Text("Hypotheek: €100.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue Saint Leonard, Liege
        view.getRsl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Saint Leonard");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €220.000"), new Text("Huur: €22.000"),
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Lange Steenstraat, Kortrijk
        view.getLs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Lange Steenstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €220.000"), new Text("Huur: €22.000"),
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Grande Place, Mons
        view.getGpm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Grand Place");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €240.000"), new Text("Huur: €24.000"),
                                new Text("Hypotheek: €120.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Grote Markt, Hasselt
        view.getGm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Grote Markt");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €260.000"), new Text("Huur: €26.000"),
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place De l'Ange, Namur
        view.getPdl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place De l'Ange");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €260.000"), new Text("Huur: €26.000"),
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Hoogstraat, Brussel
        view.getH2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Hoogstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €280.000"), new Text("Huur: €28.000"),
                                new Text("Hypotheek: €140.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Veldstraat Gent
        view.getV2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Veldstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €300.000"), new Text("Huur: €30.000"),
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Boulevard Tirou, Charleroi
        view.getBv2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Boulevard Tirou");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €300.000"), new Text("Huur: €30.000"),
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Boulevard d'Avroy, liege
        view.getBda2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Boulevard d'Avroy");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €320.000"), new Text("Huur: €32.000"),
                                new Text("Hypotheek: €160.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Meir, Antwerpen
        view.getM2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Meir");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €350.000"), new Text("Huur: €35.000"),
                                new Text("Hypotheek: €175.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Nieuwstraat, Brussel
        view.getN2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Nieuwstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €400.000"), new Text("Huur: €40.000"),
                                new Text("Hypotheek: €200.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Stations
        //Noord Station
        view.getNs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Noord Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Zuid Station
        view.getZs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Zuid Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Oost Station
        view.getOs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Oost Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //West Station
        view.getWs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("West Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox, 300, 250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Spelregels
        view.getSpelregelsMI().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        dialog.setTitle("Spelregels");
                        Spelregels spelregels = new Spelregels();
                        VBox vBoxSR = new VBox();
                        vBoxSR.getChildren().addAll(new Text(spelregels.getSpelregels()));
                        ScrollPane scrollPane = new ScrollPane();
                        scrollPane.setContent(vBoxSR);
                        Scene dialogScene = new Scene(scrollPane, 1500, 800);
                        scrollPane.setStyle("-fx-font: 10px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                }
        );
    }


    // Koppelt event handlers (anon. inner klassen)
    // aan de controls uit de view.
    // Event handlers: roepen methodes aan uit het
    // model en zorgen voor een update van de view.


    private void updateView() {

    }

    public static void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }

    public AntiMonopolyMain getModel() {
        return model;
    }

    public MainView getView() {
        return view;
    }
}


