package AntiMonopoly.View.MainMetPion;

import AntiMonopoly.Model.AntiMonopolyMain;
import AntiMonopoly.Model.Dice;
import AntiMonopoly.Model.Spelregels;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainMetPionPresenter {

    private AntiMonopolyMain model;
    private MainMetPionView view;
    private int count = 0 ;



    public MainMetPionPresenter(AntiMonopolyMain model, MainMetPionView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }



    private void addEventHandlers() {
        view.getMainView().getRg2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Grande");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €60.000"),new Text("Huur: €6.000"),
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Diestsestraat, Leuven
        view.getMainView().getDs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Diestsestraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €60.000"),new Text("Huur: €6.000"),
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        // Steenstraat, Brugge
        view.getMainView().getSs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Steenstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €100.000"),new Text("Huur: €10.000"),
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place Du Monument Spa
        view.getMainView().getPdm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place Du Monument");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €100.000"),new Text("Huur: €10.000"),
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Kapellestraat, Oostende
        view.getMainView().getKs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Kapellestraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €120.000"),new Text("Huur: €12.000"),
                                new Text("Hypotheek: €60.000"), new Text("Huisprijs: €50.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue De Diekirch, Arlon
        view.getMainView().getRdd2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue De Diekirch");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €140.000"),new Text("Huur: €14.000"),
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Bruul, Mechelen
        view.getMainView().getB2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Bruul");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €140.000"),new Text("Huur: €14.000"),
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place Verte, Verviers
        view.getMainView().getPv2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place Verte");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €160.000"),new Text("Huur: €16.000"),
                                new Text("Hypotheek: €80.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Lippenslaan, Knokke
        view.getMainView().getLl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Lippenslaan");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €180.000"),new Text("Huur: €18.000"),
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue Royale, Tournai
        view.getMainView().getRr2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Royal");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €180.000"),new Text("Huur: €18.000"),
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });


        //Groenplaats, Antwerpen
        view.getMainView().getGp2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Groenplaats");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"),new Text("Huur: €20.000"),
                                new Text("Hypotheek: €100.000"), new Text("Huisprijs: €100.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Rue Saint Leonard, Liege
        view.getMainView().getRsl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Rue Saint Leonard");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €220.000"),new Text("Huur: €22.000"),
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Lange Steenstraat, Kortrijk
        view.getMainView().getLs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Lange Steenstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €220.000"),new Text("Huur: €22.000"),
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Grande Place, Mons
        view.getMainView().getGpm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Grand Place");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €240.000"),new Text("Huur: €24.000"),
                                new Text("Hypotheek: €120.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Grote Markt, Hasselt
        view.getMainView().getGm2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Grote Markt");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €260.000"),new Text("Huur: €26.000"),
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Place De l'Ange, Namur
        view.getMainView().getPdl2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Place De l'Ange");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €260.000"),new Text("Huur: €26.000"),
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Hoogstraat, Brussel
        view.getMainView().getH2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Hoogstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €280.000"),new Text("Huur: €28.000"),
                                new Text("Hypotheek: €140.000"), new Text("Huisprijs: €150.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Veldstraat Gent
        view.getMainView().getV2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Veldstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €300.000"),new Text("Huur: €30.000"),
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Boulevard Tirou, Charleroi
        view.getMainView().getBv2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Boulevard Tirou");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €300.000"),new Text("Huur: €30.000"),
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Boulevard d'Avroy, liege
        view.getMainView().getBda2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Boulevard d'Avroy");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €320.000"),new Text("Huur: €32.000"),
                                new Text("Hypotheek: €160.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Meir, Antwerpen
        view.getMainView().getM2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Meir");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €350.000"),new Text("Huur: €35.000"),
                                new Text("Hypotheek: €175.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Nieuwstraat, Brussel
        view.getMainView().getN2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Nieuwstraat");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €400.000"),new Text("Huur: €40.000"),
                                new Text("Hypotheek: €200.000"), new Text("Huisprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Stations
        //Noord Station
        view.getMainView().getNs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Noord Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Zuid Station
        view.getMainView().getZs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Zuid Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Oost Station
        view.getMainView().getOs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Oost Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //West Station
        view.getMainView().getWs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("West Station");
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                        Scene dialogScene = new Scene(dialogVBox,300,250);
                        dialogVBox.setAlignment(Pos.CENTER);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                });

        //Spelregels
        view.getMainView().getSpelregelsMI().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Spelregels");
                        Spelregels spelregels = new Spelregels();
                        dialogVBox.getChildren().addAll(new Text(spelregels.getSpelregels()));
                        Scene dialogScene = new Scene(dialogVBox,2000,1000);
                        dialogVBox.setSpacing(10);
                        dialogVBox.setStyle("-fx-font: 10px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                }
        );

        //Aanpassingen aan het aanbrengen



        view.getDiceView().getRolButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Dice.rollDice();

                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVBox = new VBox();
                dialog.setTitle("Worp");
                Button button = new Button("Zet Pion");
                Label label = new Label(String.valueOf(count));
                dialogVBox.getChildren().addAll(new Text(String.valueOf(Dice.rollDice())), button, label);
                Scene dialogScene = new Scene(dialogVBox, 300, 250);
                dialogVBox.setAlignment(Pos.CENTER);
                dialogVBox.setSpacing(10);
                dialogVBox.setStyle("-fx-font: 20px Tahoma");
                dialog.setScene(dialogScene);
                dialog.show();


                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        switch (2) {

                            case 0:
                                TranslateTransition transition0 = new TranslateTransition();
                                transition0.setNode(MainMetPionView.getRectangle1());
                                transition0.setDuration(Duration.seconds(1));
                                transition0.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition0.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition0.setCycleCount(Timeline.INDEFINITE);
                                transition0.setInterpolator(Interpolator.EASE_BOTH);
                                transition0.play();
                                break;

                            case 1:
                                TranslateTransition transition1 = new TranslateTransition();
                                transition1.setNode(MainMetPionView.getRectangle1());
                                transition1.setDuration(Duration.seconds(1));
                                transition1.setByX(-MainMetPionView.getRectangle1().getX()+130+150);
                                transition1.setByY(-MainMetPionView.getRectangle1().getY()+40);
                               //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition1.setInterpolator(Interpolator.EASE_BOTH);
                                transition1.play();
                                break;

                            case 2:
                                TranslateTransition transition2 = new TranslateTransition();
                                transition2.setNode(MainMetPionView.getRectangle1());
                                transition2.setDuration(Duration.seconds(1));
                                transition2.setByX(-MainMetPionView.getRectangle1().getX()+130+ 2*150);
                                transition2.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition2.setCycleCount(Timeline.INDEFINITE);
                                transition2.setInterpolator(Interpolator.EASE_BOTH);
                                transition2.play();
                                break;

                            case 3:
                                TranslateTransition transition3 = new TranslateTransition();
                                transition3.setNode(MainMetPionView.getRectangle1());
                                transition3.setDuration(Duration.seconds(1));
                                transition3.setByX(-MainMetPionView.getRectangle1().getX()+130+ 3*150);
                                transition3.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition3.setCycleCount(Timeline.INDEFINITE);
                                transition3.setInterpolator(Interpolator.EASE_BOTH);
                                transition3.play();
                                break;

                            case 4:
                                TranslateTransition transition4 = new TranslateTransition();
                                transition4.setNode(MainMetPionView.getRectangle1());
                                transition4.setDuration(Duration.seconds(1));
                                transition4.setByX(-MainMetPionView.getRectangle1().getX()+130+ 4*150);
                                transition4.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition4.setCycleCount(Timeline.INDEFINITE);
                                transition4.setInterpolator(Interpolator.EASE_BOTH);
                                transition4.play();
                                break;

                            case 5:
                                TranslateTransition transition5 = new TranslateTransition();
                                transition5.setNode(MainMetPionView.getRectangle1());
                                transition5.setDuration(Duration.seconds(1));
                                transition5.setByX(-MainMetPionView.getRectangle1().getX()+130+ 5*150);
                                transition5.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition5.setInterpolator(Interpolator.EASE_BOTH);
                                transition5.play();
                                break;

                            case 6:
                                TranslateTransition transition6 = new TranslateTransition();
                                transition6.setNode(MainMetPionView.getRectangle1());
                                transition6.setDuration(Duration.seconds(1));
                                transition6.setByX(-MainMetPionView.getRectangle1().getX()+130+ 6*150);
                                transition6.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition6.setCycleCount(Timeline.INDEFINITE);
                                transition6.setInterpolator(Interpolator.EASE_BOTH);
                                transition6.play();
                                break;

                            case 7:
                                TranslateTransition transition7 = new TranslateTransition();
                                transition7.setNode(MainMetPionView.getRectangle1());
                                transition7.setDuration(Duration.seconds(1));
                                transition7.setByX(-MainMetPionView.getRectangle1().getX()+130+ 7*150);
                                transition7.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition7.setCycleCount(Timeline.INDEFINITE);
                                transition7.setInterpolator(Interpolator.EASE_BOTH);
                                transition7.play();
                                break;

                            case 8:
                                TranslateTransition transition8 = new TranslateTransition();
                                transition8.setNode(MainMetPionView.getRectangle1());
                                transition8.setDuration(Duration.seconds(1));
                                transition8.setByX(-MainMetPionView.getRectangle1().getX()+130+ 8*150);
                                transition8.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition8.setCycleCount(Timeline.INDEFINITE);
                                transition8.setInterpolator(Interpolator.EASE_BOTH);
                                transition8.play();
                                break;

                            case 9:
                                TranslateTransition transition9 = new TranslateTransition();
                                transition9.setNode(MainMetPionView.getRectangle1());
                                transition9.setDuration(Duration.seconds(1));
                                transition9.setByX(-MainMetPionView.getRectangle1().getX()+130+ 9*150);
                                transition9.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition9.setInterpolator(Interpolator.EASE_BOTH);
                                transition9.play();
                                break;

                            case 10:
                                TranslateTransition transition10 = new TranslateTransition();
                                transition10.setNode(MainMetPionView.getRectangle1());
                                transition10.setDuration(Duration.seconds(1));
                                transition10.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition10.setByY(-MainMetPionView.getRectangle1().getY()+40);
                                //transition10.setCycleCount(Timeline.INDEFINITE);
                                transition10.setInterpolator(Interpolator.EASE_BOTH);
                                transition10.play();
                                break;

                            case 11:
                                TranslateTransition transition11 = new TranslateTransition();
                                transition11.setNode(MainMetPionView.getRectangle1());
                                transition11.setDuration(Duration.seconds(1));
                                transition11.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition11.setByY(-MainMetPionView.getRectangle1().getY()+40 + 90);
                                //transition11.setCycleCount(Timeline.INDEFINITE);
                                transition11.setInterpolator(Interpolator.EASE_BOTH);
                                transition11.play();
                                break;

                            case 12:
                                TranslateTransition transition12 = new TranslateTransition();
                                transition12.setNode(MainMetPionView.getRectangle1());
                                transition12.setDuration(Duration.seconds(1));
                                transition12.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition12.setByY(-MainMetPionView.getRectangle1().getY()+40 + 2*90);
                                //transition12.setCycleCount(Timeline.INDEFINITE);
                                transition12.setInterpolator(Interpolator.EASE_BOTH);
                                transition12.play();
                                break;

                            case 13:
                                TranslateTransition transition13 = new TranslateTransition();
                                transition13.setNode(MainMetPionView.getRectangle1());
                                transition13.setDuration(Duration.seconds(1));
                                transition13.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition13.setByY(-MainMetPionView.getRectangle1().getY()+40 + 3*90);
                                //transition13.setCycleCount(Timeline.INDEFINITE);
                                transition13.setInterpolator(Interpolator.EASE_BOTH);
                                transition13.play();
                                break;

                            case 14:
                                TranslateTransition transition14 = new TranslateTransition();
                                transition14.setNode(MainMetPionView.getRectangle1());
                                transition14.setDuration(Duration.seconds(1));
                                transition14.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition14.setByY(-MainMetPionView.getRectangle1().getY()+40 +4*90);
                                //transition14.setCycleCount(Timeline.INDEFINITE);
                                transition14.setInterpolator(Interpolator.EASE_BOTH);
                                transition14.play();
                                break;

                            case 15:
                                TranslateTransition transition15 = new TranslateTransition();
                                transition15.setNode(MainMetPionView.getRectangle1());
                                transition15.setDuration(Duration.seconds(1));
                                transition15.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition15.setByY(-MainMetPionView.getRectangle1().getY()+40 + 5*90);
                                //transition15.setCycleCount(Timeline.INDEFINITE);
                                transition15.setInterpolator(Interpolator.EASE_BOTH);
                                transition15.play();
                                break;

                            case 16:
                                TranslateTransition transition16 = new TranslateTransition();
                                transition16.setNode(MainMetPionView.getRectangle1());
                                transition16.setDuration(Duration.seconds(1));
                                transition16.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition16.setByY(-MainMetPionView.getRectangle1().getY()+40 + 6*90);
                                //transition16.setCycleCount(Timeline.INDEFINITE);
                                transition16.setInterpolator(Interpolator.EASE_BOTH);
                                transition16.play();
                                break;

                            case 17:
                                TranslateTransition transition17 = new TranslateTransition();
                                transition17.setNode(MainMetPionView.getRectangle1());
                                transition17.setDuration(Duration.seconds(1));
                                transition17.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition17.setByY(-MainMetPionView.getRectangle1().getY()+40 + 7*90);
                                //transition17.setCycleCount(Timeline.INDEFINITE);
                                transition17.setInterpolator(Interpolator.EASE_BOTH);
                                transition17.play();
                                break;

                            case 18:
                                TranslateTransition transition18 = new TranslateTransition();
                                transition18.setNode(MainMetPionView.getRectangle1());
                                transition18.setDuration(Duration.seconds(1));
                                transition18.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition18.setByY(-MainMetPionView.getRectangle1().getY()+40 +8*90);
                                //transition18.setCycleCount(Timeline.INDEFINITE);
                                transition18.setInterpolator(Interpolator.EASE_BOTH);
                                transition18.play();
                                break;

                            case 19:
                                TranslateTransition transition19 = new TranslateTransition();
                                transition19.setNode(MainMetPionView.getRectangle1());
                                transition19.setDuration(Duration.seconds(1));
                                transition19.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition19.setByY(-MainMetPionView.getRectangle1().getY()+40 +9*90);
                                //transition19.setCycleCount(Timeline.INDEFINITE);
                                transition19.setInterpolator(Interpolator.EASE_BOTH);
                                transition19.play();
                                break;

                            case 20:
                                TranslateTransition transition20 = new TranslateTransition();
                                transition20.setNode(MainMetPionView.getRectangle1());
                                transition20.setDuration(Duration.seconds(1));
                                transition20.setByX(-MainMetPionView.getRectangle1().getX()+130+ 10*150);
                                transition20.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition20.setCycleCount(Timeline.INDEFINITE);
                                transition20.setInterpolator(Interpolator.EASE_BOTH);
                                transition20.play();
                                break;

                            case 21:
                                TranslateTransition transition21 = new TranslateTransition();
                                transition21.setNode(MainMetPionView.getRectangle1());
                                transition21.setDuration(Duration.seconds(1));
                                transition21.setByX(-MainMetPionView.getRectangle1().getX()+130+ 9*150);
                                transition21.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition21.setCycleCount(Timeline.INDEFINITE);
                                transition21.setInterpolator(Interpolator.EASE_BOTH);
                                transition21.play();
                                break;

                            case 22:
                                TranslateTransition transition22 = new TranslateTransition();
                                transition22.setNode(MainMetPionView.getRectangle1());
                                transition22.setDuration(Duration.seconds(1));
                                transition22.setByX(-MainMetPionView.getRectangle1().getX()+130+ 8*150);
                                transition22.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition22.setInterpolator(Interpolator.EASE_BOTH);
                                transition22.play();
                                break;

                            case 23:
                                TranslateTransition transition23= new TranslateTransition();
                                transition23.setNode(MainMetPionView.getRectangle1());
                                transition23.setDuration(Duration.seconds(1));
                                transition23.setByX(-MainMetPionView.getRectangle1().getX()+130+ 7*150);
                                transition23.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition23.setInterpolator(Interpolator.EASE_BOTH);
                                transition23.play();
                                break;

                            case 24:
                                TranslateTransition transition24 = new TranslateTransition();
                                transition24.setNode(MainMetPionView.getRectangle1());
                                transition24.setDuration(Duration.seconds(1));
                                transition24.setByX(-MainMetPionView.getRectangle1().getX()+130+ 6*150);
                                transition24.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition24.setCycleCount(Timeline.INDEFINITE);
                                transition24.setInterpolator(Interpolator.EASE_BOTH);
                                transition24.play();
                                break;

                            case 25:
                                TranslateTransition transition25 = new TranslateTransition();
                                transition25.setNode(MainMetPionView.getRectangle1());
                                transition25.setDuration(Duration.seconds(1));
                                transition25.setByX(-MainMetPionView.getRectangle1().getX()+130+ 5*150);
                                transition25.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition25.setCycleCount(Timeline.INDEFINITE);
                                transition25.setInterpolator(Interpolator.EASE_BOTH);
                                transition25.play();
                                break;

                            case 26:
                                TranslateTransition transition26 = new TranslateTransition();
                                transition26.setNode(MainMetPionView.getRectangle1());
                                transition26.setDuration(Duration.seconds(1));
                                transition26.setByX(-MainMetPionView.getRectangle1().getX()+130+ 4*150);
                                transition26.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition26.setCycleCount(Timeline.INDEFINITE);
                                transition26.setInterpolator(Interpolator.EASE_BOTH);
                                transition26.play();
                                break;

                            case 27:
                                TranslateTransition transition27 = new TranslateTransition();
                                transition27.setNode(MainMetPionView.getRectangle1());
                                transition27.setDuration(Duration.seconds(1));
                                transition27.setByX(-MainMetPionView.getRectangle1().getX()+130+ 3*150);
                                transition27.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition27.setCycleCount(Timeline.INDEFINITE);
                                transition27.setInterpolator(Interpolator.EASE_BOTH);
                                transition27.play();
                                break;

                            case 28:
                                TranslateTransition transition28 = new TranslateTransition();
                                transition28.setNode(MainMetPionView.getRectangle1());
                                transition28.setDuration(Duration.seconds(1));
                                transition28.setByX(-MainMetPionView.getRectangle1().getX()+130+ 2*150);
                                transition28.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition28.setCycleCount(Timeline.INDEFINITE);
                                transition28.setInterpolator(Interpolator.EASE_BOTH);
                                transition28.play();
                                break;

                            case 29:
                                TranslateTransition transition29 = new TranslateTransition();
                                transition29.setNode(MainMetPionView.getRectangle1());
                                transition29.setDuration(Duration.seconds(1));
                                transition29.setByX(-MainMetPionView.getRectangle1().getX()+130+ 1*150);
                                transition29.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition29.setInterpolator(Interpolator.EASE_BOTH);
                                transition29.play();
                                break;

                            case 30:
                                TranslateTransition transition30 = new TranslateTransition();
                                transition30.setNode(MainMetPionView.getRectangle1());
                                transition30.setDuration(Duration.seconds(1));
                                transition30.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition30.setByY(-MainMetPionView.getRectangle1().getY()+40 + 10*90);
                                //transition30.setCycleCount(Timeline.INDEFINITE);
                                transition30.setInterpolator(Interpolator.EASE_BOTH);
                                transition30.play();
                                break;

                            case 31:
                                TranslateTransition transition31 = new TranslateTransition();
                                transition31.setNode(MainMetPionView.getRectangle1());
                                transition31.setDuration(Duration.seconds(1));
                                transition31.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition31.setByY(-MainMetPionView.getRectangle1().getY()+40 + 9*90);
                                //transition31.setCycleCount(Timeline.INDEFINITE);
                                transition31.setInterpolator(Interpolator.EASE_BOTH);
                                transition31.play();
                                break;

                            case 32:
                                TranslateTransition transition32 = new TranslateTransition();
                                transition32.setNode(MainMetPionView.getRectangle1());
                                transition32.setDuration(Duration.seconds(1));
                                transition32.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition32.setByY(-MainMetPionView.getRectangle1().getY()+40 + 8*90);
                                //transition32.setCycleCount(Timeline.INDEFINITE);
                                transition32.setInterpolator(Interpolator.EASE_BOTH);
                                transition32.play();
                                break;

                            case 33:
                                TranslateTransition transition33 = new TranslateTransition();
                                transition33.setNode(MainMetPionView.getRectangle1());
                                transition33.setDuration(Duration.seconds(1));
                                transition33.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition33.setByY(-MainMetPionView.getRectangle1().getY()+40 + 7*90);
                                //transition33.setCycleCount(Timeline.INDEFINITE);
                                transition33.setInterpolator(Interpolator.EASE_BOTH);
                                transition33.play();
                                break;

                            case 34:
                                TranslateTransition transition34 = new TranslateTransition();
                                transition34.setNode(MainMetPionView.getRectangle1());
                                transition34.setDuration(Duration.seconds(1));
                                transition34.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition34.setByY(-MainMetPionView.getRectangle1().getY()+40 + 6*90);
                                //transition34.setCycleCount(Timeline.INDEFINITE);
                                transition34.setInterpolator(Interpolator.EASE_BOTH);
                                transition34.play();
                                break;

                            case 35:
                                TranslateTransition transition35 = new TranslateTransition();
                                transition35.setNode(MainMetPionView.getRectangle1());
                                transition35.setDuration(Duration.seconds(1));
                                transition35.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition35.setByY(-MainMetPionView.getRectangle1().getY()+40 + 5*90);
                                //transition35.setCycleCount(Timeline.INDEFINITE);
                                transition35.setInterpolator(Interpolator.EASE_BOTH);
                                transition35.play();
                                break;

                            case 36:
                                TranslateTransition transition36 = new TranslateTransition();
                                transition36.setNode(MainMetPionView.getRectangle1());
                                transition36.setDuration(Duration.seconds(1));
                                transition36.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition36.setByY(-MainMetPionView.getRectangle1().getY()+40 + 4*90);
                                //transition36.setCycleCount(Timeline.INDEFINITE);
                                transition36.setInterpolator(Interpolator.EASE_BOTH);
                                transition36.play();
                                break;

                            case 37:
                                TranslateTransition transition37 = new TranslateTransition();
                                transition37.setNode(MainMetPionView.getRectangle1());
                                transition37.setDuration(Duration.seconds(1));
                                transition37.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition37.setByY(-MainMetPionView.getRectangle1().getY()+40 + 3*90);
                                //transition37.setCycleCount(Timeline.INDEFINITE);
                                transition37.setInterpolator(Interpolator.EASE_BOTH);
                                transition37.play();
                                break;

                            case 38:
                                TranslateTransition transition38 = new TranslateTransition();
                                transition38.setNode(MainMetPionView.getRectangle1());
                                transition38.setDuration(Duration.seconds(1));
                                transition38.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition38.setByY(-MainMetPionView.getRectangle1().getY()+40 + 2*90);
                                //transition38.setCycleCount(Timeline.INDEFINITE);
                                transition38.setInterpolator(Interpolator.EASE_BOTH);
                                transition38.play();
                                break;

                            case 39:
                                TranslateTransition transition39 = new TranslateTransition();
                                transition39.setNode(MainMetPionView.getRectangle1());
                                transition39.setDuration(Duration.seconds(1));
                                transition39.setByX(-MainMetPionView.getRectangle1().getX()+130);
                                transition39.setByY(-MainMetPionView.getRectangle1().getY()+40 + 1*90);
                                //transition39.setCycleCount(Timeline.INDEFINITE);
                                transition39.setInterpolator(Interpolator.EASE_BOTH);
                                transition39.play();
                                break;




                        }
                    }
                });
            }
        });
    }
    public void addWindowEventHandlers() {

    }


    private void updateView() {
        //view.getDiceView().getDie1().setImage(new Image("/images/Dice/die1.png" /* + Dice.getWorp2()[0] + ".png"*/));
        // view.getDiceView().getDie2().setImage(new Image("/images/Dice/die2.png" /*+ Dice.getWorp2()[10] + ".png"*/));
    }

    public int getCount() {
        return count;
    }
}

