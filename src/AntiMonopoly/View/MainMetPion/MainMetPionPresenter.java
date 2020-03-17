package AntiMonopoly.View.MainMetPion;

import AntiMonopoly.Model.*;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


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
                int worp = Dice.rollDice();

                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVBox = new VBox();
                dialog.setTitle("Worp");
                Button button = new Button("Zet Pion");
                Label label1 = new Label (String.valueOf(Dice.getWorp2()[0]));
                Label label2 = new Label (String.valueOf(Dice.getWorp2()[1]));
                Label label3 = new Label (String.valueOf(Dice.getCount()));
                dialogVBox.getChildren().addAll(button, label1, label2, label3);
                Scene dialogScene = new Scene(dialogVBox, 300, 250);
                dialogVBox.setAlignment(Pos.CENTER);
                dialogVBox.setSpacing(10);
                dialogVBox.setStyle("-fx-font: 20px Tahoma");
                dialog.setScene(dialogScene);
                dialog.show();


                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        List<Rectangle> pionnen = new ArrayList<>();

                        for (int i = 0; i < Spel.getSpelers().size(); i++) {
                            pionnen.add(Spel.getSpelers().get(i).getRectangle());
                        }

                        Rectangle pion = null;
                        Speler aanZet = null;

                        switch (Dice.getCount()){
                            case 1:
                                pion = pionnen.get(0);
                                aanZet = Spel.getSpelers().get(0);
                                break;
                            case 2:
                                pion = pionnen.get(1);
                                aanZet = Spel.getSpelers().get(1);
                                break;
                            case 3:
                                pion = pionnen.get(2);
                                aanZet = Spel.getSpelers().get(2);
                                break;
                            case 4:
                                pion = pionnen.get(3);
                                aanZet = Spel.getSpelers().get(3);
                        }

                        int locatie = Spel.move(aanZet,worp).getPositie();
                        dialog.close();                                                          // sluit het venster als je op 'Zet pion' klikt


                        switch (locatie) {

                                case 0:
                                    TranslateTransition transition0 = new TranslateTransition();
                                    transition0.setNode(pion);
                                    transition0.setDuration(Duration.seconds(1));
                                    transition0.setToX(0);
                                    transition0.setToY(0);
                                    //transition0.setCycleCount(Timeline.INDEFINITE);
                                    transition0.setInterpolator(Interpolator.EASE_BOTH);
                                    transition0.play();

                                    final Stage dialog0 = new Stage();
                                    dialog0.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox0 = new VBox();
                                    dialog0.setTitle("Start");
                                    dialogVBox0.getChildren().addAll(new Text("U staat op start."));
                                    Scene dialogScene0 = new Scene(dialogVBox0, 300, 250);
                                    dialogVBox0.setAlignment(Pos.CENTER);
                                    dialogVBox0.setSpacing(10);
                                    dialogVBox0.setStyle("-fx-font: 20px Tahoma");
                                    dialog0.setScene(dialogScene0);
                                    dialog0.show();
                                    break;

                                case 1:
                                    TranslateTransition transition1 = new TranslateTransition();
                                    transition1.setNode(pion);
                                    transition1.setDuration(Duration.seconds(1));
                                    transition1.setToX(150);
                                    transition1.setToY(0);
                                    //transition1.setCycleCount(Timeline.INDEFINITE);
                                    transition1.setInterpolator(Interpolator.EASE_BOTH);
                                    transition1.play();

                                //Tegel heeft geen eigenaar
                                if(!Tegel.heeftEigenaar(Spelbord.getTegels().get(1))){
                                    final Stage dialog11 = new Stage();
                                    dialog11.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox11 = new VBox();
                                    dialog11.setTitle("Rue Grande");
                                    Button button11 = new Button("Koop");
                                    dialogVBox11.getChildren().addAll(new Text("Aankoopprijs: €60.000"), new Text("Huur: €6.000"),
                                            new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"),button11);
                                    Scene dialogScene11 = new Scene(dialogVBox11, 300, 250);
                                    dialogVBox11.setAlignment(Pos.CENTER);
                                    dialogVBox11.setSpacing(10);
                                    dialogVBox11.setStyle("-fx-font: 20px Tahoma");
                                    dialog11.setScene(dialogScene11);
                                    dialog11.show();

                                    Speler finalAanZet1 = aanZet;
                                    button11.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                dialog1.close();                                        // sluit koop venster
                                                Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet1);

                                                final Stage dialog12 = new Stage();
                                                dialog12.initModality(Modality.APPLICATION_MODAL);
                                                VBox dialogVBox12 = new VBox();
                                                dialog12.setTitle("Proficiat met uw aankoop!");
                                                Button button12 = new Button("OK");
                                                dialogVBox12.getChildren().addAll(new Text("U hebt Rue Grande aangekocht"), new Text("voor €60.000"),
                                                        button12);
                                                Scene dialogScene12 = new Scene(dialogVBox12, 300, 250);
                                                dialogVBox12.setAlignment(Pos.CENTER);
                                                dialogVBox12.setSpacing(10);
                                                dialogVBox12.setStyle("-fx-font: 20px Tahoma");
                                                dialog12.setScene(dialogScene12);
                                                dialog12.show();

                                                button12.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        dialog11.close();
                                                        dialog12.close();
                                                    }
                                                });
                                            }
                                    });
                                }

                                //Tegel is van een andere eigenaar
                                if(!Spelbord.getTegels().get(1).getNaam().equals(Spel.getSpelers().get(0).getNaam())) {

                                    final Stage dialog13 = new Stage();
                                    dialog13.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox13 = new VBox();
                                    dialog13.setTitle("Betaal Huur");
                                    Button button13 = new Button("Betaal huur");
                                    dialogVBox13.getChildren().addAll(new Text("U dient huur te betalen. "),button13);
                                    Scene dialogScene13 = new Scene(dialogVBox13, 300, 250);
                                    dialogVBox13.setAlignment(Pos.CENTER);
                                    dialogVBox13.setSpacing(10);
                                    dialogVBox13.setStyle("-fx-font: 20px Tahoma");
                                    dialog13.setScene(dialogScene13);
                                    dialog13.show();

                                    Speler finalAanZet = aanZet;
                                    button13.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            dialog1.close();
                                            Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet);

                                            final Stage dialog14 = new Stage();
                                            dialog14.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox14 = new VBox();
                                            dialog14.setTitle("Huur");
                                            Button button1 = new Button("OK");
                                            dialogVBox14.getChildren().addAll(new Text("U betaalde huur"),
                                                    button1);
                                            Scene dialogScene1 = new Scene(dialogVBox14, 300, 250);
                                            dialogVBox14.setAlignment(Pos.CENTER);
                                            dialogVBox14.setSpacing(10);
                                            dialogVBox14.setStyle("-fx-font: 20px Tahoma");
                                            dialog14.setScene(dialogScene1);
                                            dialog14.show();

                                            button1.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog13.close();
                                                    dialog14.close();
                                                }
                                            });
                                        }
                                    });
                                } else {

                                    // tegel is van de speler zelf

                                    final Stage dialog1 = new Stage();
                                    dialog1.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox1 = new VBox();
                                    dialog1.setTitle("Bouw");
                                    Button button14 = new Button("Bouw Hotel");
                                    ComboBox<Integer> comboBox = new ComboBox<>();
                                    ObservableList<Integer> hetAantalHuizen =
                                            FXCollections.observableArrayList(0,1,2,3,4);
                                    comboBox.setItems(hetAantalHuizen);
                                    Button button15 = new Button("Bouw Huis");
                                    dialogVBox15.getChildren().addAll( new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
                                            comboBox , button14, button15);
                                    Scene dialogScene1 = new Scene(dialogVBox15, 300, 250);
                                    dialogVBox15.setAlignment(Pos.CENTER);
                                    dialogVBox15.setSpacing(10);
                                    dialogVBox15.setStyle("-fx-font: 20px Tahoma");
                                    dialog15.setScene(dialogScene1);
                                    dialog15.show();

                                    //Koop Hotel
                                    Speler finalAanZet2 = aanZet;
                                    button14.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            dialog1.close();
                                            Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet2);

                                            final Stage dialog16 = new Stage();
                                            dialog16.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox16 = new VBox();
                                            dialog16.setTitle("Hotel");
                                            Button button16 = new Button("OK");
                                            dialogVBox16.getChildren().addAll(new Text("U kocht een hotel"),
                                                    button16);
                                            Scene dialogScene16 = new Scene(dialogVBox16, 300, 250);
                                            dialogVBox16.setAlignment(Pos.CENTER);
                                            dialogVBox16.setSpacing(10);
                                            dialogVBox16.setStyle("-fx-font: 20px Tahoma");
                                            dialog16.setScene(dialogScene16);
                                            dialog16.show();

                                            button16.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog16.close();
                                                }
                                            });
                                        }
                                    });

                                    //Koop huis
                                    Speler finalAanZet3 = aanZet;
                                    button15.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                dialog1.close();
                                                Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(), comboBox.getValue(), finalAanZet3);

                                                final Stage dialog17 = new Stage();
                                                dialog17.initModality(Modality.APPLICATION_MODAL);
                                                VBox dialogVBox17 = new VBox();
                                                dialog17.setTitle("Hotel");
                                                Button button17 = new Button("OK");
                                                dialogVBox17.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
                                                        button17);
                                                Scene dialogScene17 = new Scene(dialogVBox17, 300, 250);
                                                dialogVBox17.setAlignment(Pos.CENTER);
                                                dialogVBox17.setSpacing(10);
                                                dialogVBox17.setStyle("-fx-font: 20px Tahoma");
                                                dialog17.setScene(dialogScene17);
                                                dialog17.show();

                                                button17.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        dialog17.close();
                                                    }
                                                });
                                            }
                                    });
                                }
                                break;

                            case 2:
                                TranslateTransition transition2 = new TranslateTransition();
                                transition2.setNode(MainMetPionView.getRectangle1());
                                transition2.setDuration(Duration.seconds(1));
                                transition2.setToX(2*150);
                                transition2.setToY(0);
                                //transition2.setCycleCount(Timeline.INDEFINITE);
                                transition2.setInterpolator(Interpolator.EASE_BOTH);
                                transition2.play();

                                final Stage dialog2 = new Stage();
                                dialog2.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox2 = new VBox();
                                dialog2.setTitle("Neem Kaart");
                                Button button2 = new Button("Neem een kaart");
                                dialogVBox2.getChildren().addAll(new Text("Neem een kaart"),button2);
                                Scene dialogScene2 = new Scene(dialogVBox2,300,250);
                                dialogVBox2.setAlignment(Pos.CENTER);
                                dialogVBox2.setSpacing(10);
                                dialogVBox2.setStyle("-fx-font: 20px Tahoma");
                                dialog2.setScene(dialogScene2);
                                dialog2.show();

                                    Speler finalAanZet3 = aanZet;
                                    button2.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            dialog2.close();

                                            final Stage dialog = new Stage();
                                            dialog.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox2 = new VBox();
                                            dialog.setTitle("Opdracht");
                                            Button button2 = new Button("OK");
                                            dialogVBox2.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet3)), button2);
                                            Scene dialogScene2 = new Scene(dialogVBox2, 300, 250);
                                            dialogVBox2.setAlignment(Pos.CENTER);
                                            dialogVBox2.setSpacing(10);
                                            dialogVBox2.setStyle("-fx-font: 20px Tahoma");
                                            dialog.setScene(dialogScene2);
                                            dialog.show();

                                            button2.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent actionEvent) {
                                                    ConcurrentenOfMonopolistenvak.voerUit(finalAanZet3);
                                                    dialog.close();
                                                }
                                            });
                                        }
                                    });
                                    break;

                            case 3:
                                TranslateTransition transition3 = new TranslateTransition();
                                transition3.setNode(MainMetPionView.getRectangle1());
                                transition3.setDuration(Duration.seconds(1));
                                transition3.setToX(3*150);
                                transition3.setToY(0);
                                //transition3.setCycleCount(Timeline.INDEFINITE);
                                transition3.setInterpolator(Interpolator.EASE_BOTH);
                                transition3.play();

                                //Tegel heeft geen eigenaar
                                if(!Tegel.heeftEigenaar(Spelbord.getTegels().get(3))){
                                final Stage dialog31 = new Stage();
                                dialog31.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox31 = new VBox();
                                dialog31.setTitle("Diestsestraat");
                                Button button31 = new Button("Koop");
                                dialogVBox31.getChildren().addAll(new Text("Aankoopprijs: €60.000"),new Text("Huur: €6.000"),
                                        new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"),button31);
                                Scene dialogScene31 = new Scene(dialogVBox31,300,250);
                                dialogVBox31.setAlignment(Pos.CENTER);
                                dialogVBox31.setSpacing(10);
                                dialogVBox31.setStyle("-fx-font: 20px Tahoma");
                                dialog31.setScene(dialogScene31);
                                dialog31.show();

                                    button31.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Tegel.koopEigendom(Spelbord.getTegels().get(3),Spel.getSpelers().get(0));

                                            final Stage dialog32 = new Stage();
                                            dialog32.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox32 = new VBox();
                                            dialog32.setTitle("Proficiat met uw aankoop!");
                                            Button button32 = new Button("OK");
                                            dialogVBox32.getChildren().addAll(new Text("U hebt Diestsestraat aangekocht"), new Text("voor €60.000"),
                                                    button32);
                                            Scene dialogScene32 = new Scene(dialogVBox32, 300, 250);
                                            dialogVBox32.setAlignment(Pos.CENTER);
                                            dialogVBox32.setSpacing(10);
                                            dialogVBox32.setStyle("-fx-font: 20px Tahoma");
                                            dialog32.setScene(dialogScene32);
                                            dialog32.show();

                                            button32.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog31.close();
                                                    dialog32.close();
                                                }
                                            });
                                        }
                                    });
                                }

                                //Tegel is van een andere eigenaar
                                if(!Spelbord.getTegels().get(3).getNaam().equals(Spel.getSpelers().get(0).getNaam())) {

                                    final Stage dialog33 = new Stage();
                                    dialog33.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox33 = new VBox();
                                    dialog33.setTitle("Betaal Huur");
                                    Button button33 = new Button("Betaal Huur");
                                    dialogVBox33.getChildren().addAll(new Text("U dient huur te betalen. "),button33);
                                    Scene dialogScene33 = new Scene(dialogVBox33,300,250);
                                    dialogVBox33.setAlignment(Pos.CENTER);
                                    dialogVBox33.setSpacing(10);
                                    dialogVBox33.setStyle("-fx-font: 20px Tahoma");
                                    dialog33.setScene(dialogScene33);
                                    dialog33.show();

                                    button33.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Tegel.betaalHuur(Spelbord.getTegels().get(3),Spel.getSpelers().get(0));

                                            final Stage dialog34 = new Stage();
                                            dialog34.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox34 = new VBox();
                                            dialog34.setTitle("Huur");
                                            Button button3 = new Button("OK");
                                            dialogVBox34.getChildren().addAll(new Text("U betaalde huur"),
                                                    button3);
                                            Scene dialogScene3 = new Scene(dialogVBox34, 300, 250);
                                            dialogVBox34.setAlignment(Pos.CENTER);
                                            dialogVBox34.setSpacing(10);
                                            dialog34.setScene(dialogScene3);
                                            dialogVBox34.setStyle("-fx-font: 20px Tahoma");
                                            dialog34.show();

                                            button3.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog33.close();
                                                    dialog34.close();
                                                }
                                            });
                                        }
                                    });
                                }

                                //Tegel is van de speler zelf
                                if(Spelbord.getTegels().get(3).getNaam().equals(Spel.getSpelers().get(0).getNaam())) {
                                    Tegel.betaalHuur(Spelbord.getTegels().get(3),Spel.getSpelers().get(0));

                                    final Stage dialog35 = new Stage();
                                    dialog35.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox35 = new VBox();
                                    dialog35.setTitle("Bouw");
                                    Button button34 = new Button("Bouw Hotel");
                                    ComboBox<Integer> comboBox = new ComboBox<>();
                                    ObservableList<Integer> hetAantalHuizen =
                                            FXCollections.observableArrayList(0,1,2,3,4);
                                    comboBox.setItems(hetAantalHuizen);
                                    Button button35 = new Button("Bouw Huis");
                                    dialogVBox35.getChildren().addAll( new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
                                            comboBox , button34, button35);
                                    Scene dialogScene35 = new Scene(dialogVBox35, 300, 250);
                                    dialogVBox35.setAlignment(Pos.CENTER);
                                    dialogVBox35.setSpacing(10);
                                    dialog35.setScene(dialogScene35);
                                    dialogVBox35.setStyle("-fx-font: 20px Tahoma");
                                    dialog35.show();


                                //Koop Hotel
                                button34.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(3), new Gebouwen.Hotel(), Spel.getSpelers().get(0));
                                        final Stage dialog36 = new Stage();
                                        dialog36.initModality(Modality.APPLICATION_MODAL);
                                        VBox dialogVBox36 = new VBox();
                                        dialog36.setTitle("Hotel");
                                        Button button36 = new Button("OK");
                                        dialogVBox36.getChildren().addAll( new Text("U kocht een hotel"), new Text("hoeveel huizen wilt u?"),
                                                button36);
                                        Scene dialogScene36 = new Scene(dialogVBox36, 300, 250);
                                        dialogVBox36.setAlignment(Pos.CENTER);
                                        dialogVBox36.setSpacing(10);
                                        dialog36.setScene(dialogScene36);
                                        dialogVBox36.setStyle("-fx-font: 20px Tahoma");
                                        dialog36.show();

                                        button36.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                dialog36.close();
                                            }

                                        });
                                    }
                                });

                                //Koop huis
                                button35.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(3), new Gebouwen.Huis(),
                                                comboBox.getValue(),Spel.getSpelers().get(0));
                                        final Stage dialog17 = new Stage();
                                        dialog17.initModality(Modality.APPLICATION_MODAL);
                                        VBox dialogVBox17 = new VBox();
                                        dialog17.setTitle("Hotel");
                                        Button button37 = new Button("OK");
                                        dialogVBox17.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
                                                button37);
                                        Scene dialogScene17 = new Scene(dialogVBox17, 300, 250);
                                        dialogVBox17.setAlignment(Pos.CENTER);
                                        dialogVBox17.setSpacing(10);
                                        dialogVBox17.setStyle("-fx-font: 20px Tahoma");
                                        dialog17.setScene(dialogScene17);
                                        dialog17.show();

                                        button37.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                dialog17.close();
                                            }
                                        });
                                    }
                                });
                                }


                                        break;

                            case 4:
                                TranslateTransition transition4 = new TranslateTransition();
                                transition4.setNode(MainMetPionView.getRectangle1());
                                transition4.setDuration(Duration.seconds(1));
                                transition4.setToX(4*150);
                                transition4.setToY(0);
                                //transition4.setCycleCount(Timeline.INDEFINITE);
                                transition4.setInterpolator(Interpolator.EASE_BOTH);
                                transition4.play();

                                final Stage dialog4 = new Stage();
                                dialog4.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox4 = new VBox();
                                dialog4.setTitle("Inkomstenbelasting");
                                Button button4 = new Button();
                                dialogVBox4.getChildren().addAll(new Text("Betaal"),button4);
                                Scene dialogScene4 = new Scene(dialogVBox4,300,250);
                                dialogVBox4.setAlignment(Pos.CENTER);
                                dialogVBox4.setSpacing(10);
                                dialogVBox4.setStyle("-fx-font: 20px Tahoma");
                                dialog4.setScene(dialogScene4);
                                dialog4.show();
                                break;

                            case 5:
                                TranslateTransition transition5 = new TranslateTransition();
                                transition5.setNode(MainMetPionView.getRectangle1());
                                transition5.setDuration(Duration.seconds(1));
                                transition5.setToX(5*150);
                                transition5.setToY(0);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition5.setInterpolator(Interpolator.EASE_BOTH);
                                transition5.play();

                                final Stage dialog5 = new Stage();
                                dialog5.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox5 = new VBox();
                                dialog5.setTitle("Noord Station");
                                dialogVBox5.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                                Scene dialogScene5 = new Scene(dialogVBox5,300,250);
                                dialogVBox5.setAlignment(Pos.CENTER);
                                dialogVBox5.setSpacing(10);
                                dialogVBox5.setStyle("-fx-font: 20px Tahoma");
                                dialog5.setScene(dialogScene5);
                                dialog5.show();
                                break;

                            case 6:
                                TranslateTransition transition6 = new TranslateTransition();
                                transition6.setNode(MainMetPionView.getRectangle1());
                                transition6.setDuration(Duration.seconds(1));
                                transition6.setToX(6*150);
                                transition6.setToY(0);
                                //transition6.setCycleCount(Timeline.INDEFINITE);
                                transition6.setInterpolator(Interpolator.EASE_BOTH);
                                transition6.play();

                                //tegel heeft geen eigenaar
                                if(!Tegel.heeftEigenaar(Spelbord.getTegels().get(6))){
                                final Stage dialog61 = new Stage();
                                dialog61.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox61 = new VBox();
                                dialog61.setTitle("Steenstraat");
                                Button button61 = new Button("Koop");
                                dialogVBox61.getChildren().addAll(new Text("Aankoopprijs: €100.000"),new Text("Huur: €10.000"),
                                        new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"),button61);
                                Scene dialogScene61 = new Scene(dialogVBox61,300,250);
                                dialogVBox61.setAlignment(Pos.CENTER);
                                dialogVBox61.setSpacing(10);
                                dialogVBox61.setStyle("-fx-font: 20px Tahoma");
                                dialog61.setScene(dialogScene61);
                                dialog61.show();

                                button61.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Tegel.koopEigendom(Spelbord.getTegels().get(6),Spel.getSpelers().get(0));

                                            final Stage dialog62 = new Stage();
                                            dialog62.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox62 = new VBox();
                                            dialog62.setTitle("Proficiat met uw aankoop!");
                                            Button button62 = new Button("OK");
                                            dialogVBox62.getChildren().addAll(new Text("U hebt Steenstraat aangekocht"), new Text("voor €100.000"),
                                                    button62);
                                            Scene dialogScene62 = new Scene(dialogVBox62, 300, 250);
                                            dialogVBox62.setAlignment(Pos.CENTER);
                                            dialogVBox62.setSpacing(10);
                                            dialogVBox62.setStyle("-fx-font: 20px Tahoma");
                                            dialog62.setScene(dialogScene62);
                                            dialog62.show();

                                            button62.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog62.close();
                                                    dialog61.close();
                                                }
                                            });
                                        }
                                });
                                }

                                //Tegel is van een andere eigenaar
                                if(!Spelbord.getTegels().get(6).getNaam().equals(Spel.getSpelers().get(0).getNaam())
                                        && Tegel.heeftEigenaar(Spelbord.getTegels().get(6))) {

                                    final Stage dialog63 = new Stage();
                                    dialog63.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox63 = new VBox();
                                    dialog63.setTitle("Betaal Huur");
                                    Button button63 = new Button("Betaal huur");
                                    dialogVBox63.getChildren().addAll(new Text("U dient huur te betalen. "),button63);
                                    Scene dialogScene63 = new Scene(dialogVBox63, 300, 250);
                                    dialogVBox63.setAlignment(Pos.CENTER);
                                    dialogVBox63.setSpacing(10);
                                    dialogVBox63.setStyle("-fx-font: 20px Tahoma");
                                    dialog63.setScene(dialogScene63);
                                    dialog63.show();

                                    button63.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Tegel.betaalHuur(Spelbord.getTegels().get(6),Spel.getSpelers().get(0));

                                            final Stage dialog64 = new Stage();
                                            dialog64.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox64 = new VBox();
                                            dialog64.setTitle("Huur");
                                            Button button6= new Button("OK");
                                            dialogVBox64.getChildren().addAll(new Text("U betaalde huur"),
                                                    button6);
                                            Scene dialogScene64 = new Scene(dialogVBox64, 300, 250);
                                            dialogVBox64.setAlignment(Pos.CENTER);
                                            dialogVBox64.setSpacing(10);
                                            dialogVBox64.setStyle("-fx-font: 20px Tahoma");
                                            dialog64.setScene(dialogScene64);
                                            dialog64.show();

                                            button6.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog63.close();
                                                    dialog64.close();
                                                }
                                            });
                                        }
                                    });
                                }

                                //Tegel is van de speler zelf
                                if(Spelbord.getTegels().get(6).getNaam().equals(Spel.getSpelers().get(0).getNaam())) {
                                    final Stage dialog65 = new Stage();
                                    dialog65.initModality(Modality.APPLICATION_MODAL);
                                    VBox dialogVBox65 = new VBox();
                                    dialog65.setTitle("Bouw");
                                    Button button64 = new Button("Bouw Hotel");
                                    ComboBox<Integer> comboBox = new ComboBox<>();
                                    ObservableList<Integer> hetAantalHuizen =
                                            FXCollections.observableArrayList(0,1,2,3,4);
                                    comboBox.setItems(hetAantalHuizen);
                                    Button button65 = new Button("Bouw Huis");
                                    dialogVBox65.getChildren().addAll( new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
                                            comboBox , button64, button65);
                                    Scene dialogScene65 = new Scene(dialogVBox65, 300, 250);
                                    dialogVBox65.setAlignment(Pos.CENTER);
                                    dialogVBox65.setSpacing(10);
                                    dialogVBox65.setStyle("-fx-font: 20px Tahoma");
                                    dialog65.setScene(dialogScene65);
                                    dialog65.show();

                                    //Koop Hotel
                                    button64.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(6), new Gebouwen.Hotel(), Spel.getSpelers().get(0));

                                            final Stage dialog66 = new Stage();
                                            dialog66.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox66 = new VBox();
                                            dialog66.setTitle("Hotel");
                                            Button button66 = new Button("OK");
                                            dialogVBox66.getChildren().addAll(new Text("U kocht een hotel"),
                                                    button66);
                                            Scene dialogScene66 = new Scene(dialogVBox66, 300, 250);
                                            dialogVBox66.setAlignment(Pos.CENTER);
                                            dialogVBox66.setSpacing(10);
                                            dialogVBox66.setStyle("-fx-font: 20px Tahoma");
                                            dialog66.setScene(dialogScene66);
                                            dialog66.show();

                                            button66.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog66.close();
                                                }
                                            });
                                        }
                                    });

                                    //Koop huis
                                    button65.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(6), new Gebouwen.Huis(), comboBox.getValue(),Spel.getSpelers().get(0));

                                            final Stage dialog67 = new Stage();
                                            dialog67.initModality(Modality.APPLICATION_MODAL);
                                            VBox dialogVBox67 = new VBox();
                                            dialog67.setTitle("Hotel");
                                            Button button67 = new Button("OK");
                                            dialogVBox67.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
                                                    button67);
                                            Scene dialogScene67 = new Scene(dialogVBox67, 300, 250);
                                            dialogVBox67.setAlignment(Pos.CENTER);
                                            dialogVBox67.setSpacing(10);
                                            dialogVBox67.setStyle("-fx-font: 20px Tahoma");
                                            dialog67.setScene(dialogScene67);
                                            dialog67.show();

                                            button67.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    dialog67.close();
                                                }
                                            });
                                        }
                                    });
                                }



                                break;

                            case 7:
                                TranslateTransition transition7 = new TranslateTransition();
                                transition7.setNode(MainMetPionView.getRectangle1());
                                transition7.setDuration(Duration.seconds(1));
                                transition7.setToX(7*150);
                                transition7.setToY(0);
                                //transition7.setCycleCount(Timeline.INDEFINITE);
                                transition7.setInterpolator(Interpolator.EASE_BOTH);
                                transition7.play();

                                final Stage dialog7 = new Stage();
                                dialog7.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox7 = new VBox();
                                dialog7.setTitle("Neem Kaart");
                                Button button7 = new Button("Neem een kaart");
                                dialogVBox7.getChildren().addAll(new Text("Neem een kaart"),button7);
                                Scene dialogScene7 = new Scene(dialogVBox7,300,250);
                                dialogVBox7.setAlignment(Pos.CENTER);
                                dialogVBox7.setSpacing(10);
                                dialogVBox7.setStyle("-fx-font: 20px Tahoma");
                                dialog7.setScene(dialogScene7);
                                dialog7.show();

                                button7.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        dialog7.close();
                                    }
                                });
                                break;


                            case 8:
                                TranslateTransition transition8 = new TranslateTransition();
                                transition8.setNode(MainMetPionView.getRectangle1());
                                transition8.setDuration(Duration.seconds(1));
                                transition8.setToX(8*150);
                                transition8.setToY(0);
                                //transition8.setCycleCount(Timeline.INDEFINITE);
                                transition8.setInterpolator(Interpolator.EASE_BOTH);
                                transition8.play();

                                final Stage dialog8 = new Stage();
                                dialog8.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox8 = new VBox();
                                dialog8.setTitle("Place Du Monument");
                                dialogVBox8.getChildren().addAll(new Text("Aankoopprijs: €100.000"),new Text("Huur: €10.000"),
                                        new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"));
                                Scene dialogScene8 = new Scene(dialogVBox8,300,250);
                                dialogVBox8.setAlignment(Pos.CENTER);
                                dialogVBox8.setSpacing(10);
                                dialogVBox8.setStyle("-fx-font: 20px Tahoma");
                                dialog8.setScene(dialogScene8);
                                dialog8.show();
                                break;

                            case 9:
                                TranslateTransition transition9 = new TranslateTransition();
                                transition9.setNode(MainMetPionView.getRectangle1());
                                transition9.setDuration(Duration.seconds(1));
                                transition9.setToX(9*150);
                                transition9.setToY(0);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition9.setInterpolator(Interpolator.EASE_BOTH);
                                transition9.play();

                                final Stage dialog9 = new Stage();
                                dialog9.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox9 = new VBox();
                                dialog9.setTitle("Kapellestraat");
                                dialogVBox9.getChildren().addAll(new Text("Aankoopprijs: €120.000"),new Text("Huur: €12.000"),
                                        new Text("Hypotheek: €60.000"), new Text("Huisprijs: €50.000"));
                                Scene dialogScene9 = new Scene(dialogVBox9,300,250);
                                dialogVBox9.setAlignment(Pos.CENTER);
                                dialogVBox9.setSpacing(10);
                                dialogVBox9.setStyle("-fx-font: 20px Tahoma");
                                dialog9.setScene(dialogScene9);
                                dialog9.show();
                                break;

                            case 10:
                                TranslateTransition transition10 = new TranslateTransition();
                                transition10.setNode(MainMetPionView.getRectangle1());
                                transition10.setDuration(Duration.seconds(1));
                                transition10.setToX(10*150);
                                transition10.setToY(0);
                                //transition10.setCycleCount(Timeline.INDEFINITE);
                                transition10.setInterpolator(Interpolator.EASE_BOTH);
                                transition10.play();

                                final Stage dialog10 = new Stage();
                                dialog10.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox10 = new VBox();
                                dialog10.setTitle("Start");
                                dialogVBox10.getChildren().addAll(new Text("U bent op bezoek in de gevangenis."));
                                Scene dialogScene10 = new Scene(dialogVBox10,300,250);
                                dialogVBox10.setAlignment(Pos.CENTER);
                                dialogVBox10.setSpacing(10);
                                dialogVBox10.setStyle("-fx-font: 20px Tahoma");
                                dialog10.setScene(dialogScene10);
                                dialog10.show();
                                break;

                            case 11:
                                TranslateTransition transition11 = new TranslateTransition();
                                transition11.setNode(MainMetPionView.getRectangle1());
                                transition11.setDuration(Duration.seconds(1));
                                transition11.setToX(10*150);
                                transition11.setToY(90);
                                //transition11.setCycleCount(Timeline.INDEFINITE);
                                transition11.setInterpolator(Interpolator.EASE_BOTH);
                                transition11.play();

                                final Stage dialog11 = new Stage();
                                dialog11.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox11 = new VBox();
                                dialog11.setTitle("Rue De Diekirch");
                                dialogVBox11.getChildren().addAll(new Text("Aankoopprijs: €140.000"),new Text("Huur: €14.000"),
                                        new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene11 = new Scene(dialogVBox11,300,250);
                                dialogVBox11.setAlignment(Pos.CENTER);
                                dialogVBox11.setSpacing(10);
                                dialogVBox11.setStyle("-fx-font: 20px Tahoma");
                                dialog11.setScene(dialogScene11);
                                dialog11.show();
                                break;

                            case 12:
                                TranslateTransition transition12 = new TranslateTransition();
                                transition12.setNode(MainMetPionView.getRectangle1());
                                transition12.setDuration(Duration.seconds(1));
                                transition12.setToX(10*150);
                                transition12.setToY(2 * 90);
                                //transition12.setCycleCount(Timeline.INDEFINITE);
                                transition12.setInterpolator(Interpolator.EASE_BOTH);
                                transition12.play();

                                final Stage dialog12 = new Stage();
                                dialog12.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox12 = new VBox();
                                dialog12.setTitle("Elektriciteitsmaatschappij");
                                Button button12 = new Button("Dobbelen");
                                dialogVBox12.getChildren().addAll(new Text("Gasmaatschappij"),new Text("Dobbel voor rekening"),
                                        button12);
                                Scene dialogScene12 = new Scene(dialogVBox12,300,250);
                                dialogVBox12.setAlignment(Pos.CENTER);
                                dialogVBox12.setSpacing(10);
                                dialogVBox12.setStyle("-fx-font: 20px Tahoma");
                                dialog12.setScene(dialogScene12);
                                dialog12.show();
                                break;
                              

                            case 13:
                                TranslateTransition transition13 = new TranslateTransition();
                                transition13.setNode(MainMetPionView.getRectangle1());
                                transition13.setDuration(Duration.seconds(1));
                                transition13.setToX(10*150);
                                transition13.setToY(3 * 90);
                                //transition13.setCycleCount(Timeline.INDEFINITE);
                                transition13.setInterpolator(Interpolator.EASE_BOTH);
                                transition13.play();

                                final Stage dialog13 = new Stage();
                                dialog13.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox13 = new VBox();
                                dialog13.setTitle("Bruul");
                                dialogVBox13.getChildren().addAll(new Text("Aankoopprijs: €140.000"),new Text("Huur: €14.000"),
                                        new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene13 = new Scene(dialogVBox13,300,250);
                                dialogVBox13.setAlignment(Pos.CENTER);
                                dialogVBox13.setSpacing(10);
                                dialogVBox13.setStyle("-fx-font: 20px Tahoma");
                                dialog13.setScene(dialogScene13);
                                dialog13.show();
                                break;

                            case 14:
                                TranslateTransition transition14 = new TranslateTransition();
                                transition14.setNode(MainMetPionView.getRectangle1());
                                transition14.setDuration(Duration.seconds(1));
                                transition14.setToX(10*150);
                                transition14.setToY(4 * 90);
                                //transition14.setCycleCount(Timeline.INDEFINITE);
                                transition14.setInterpolator(Interpolator.EASE_BOTH);
                                transition14.play();

                                final Stage dialog14 = new Stage();
                                dialog14.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox14 = new VBox();
                                dialog14.setTitle("Place Verte");
                                dialogVBox14.getChildren().addAll(new Text("Aankoopprijs: €160.000"),new Text("Huur: €16.000"),
                                        new Text("Hypotheek: €80.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene14 = new Scene(dialogVBox14,300,250);
                                dialogVBox14.setAlignment(Pos.CENTER);
                                dialogVBox14.setSpacing(10);
                                dialogVBox14.setStyle("-fx-font: 20px Tahoma");
                                dialog14.setScene(dialogScene14);
                                dialog14.show();
                                break;

                            case 15:
                                TranslateTransition transition15 = new TranslateTransition();
                                transition15.setNode(MainMetPionView.getRectangle1());
                                transition15.setDuration(Duration.seconds(1));
                                transition15.setToX(10*150);
                                transition15.setToY(5 * 90);
                                //transition15.setCycleCount(Timeline.INDEFINITE);
                                transition15.setInterpolator(Interpolator.EASE_BOTH);
                                transition15.play();

                                final Stage dialog15 = new Stage();
                                dialog15.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox15 = new VBox();
                                dialog15.setTitle("Oost Station");
                                dialogVBox15.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                                Scene dialogScene15 = new Scene(dialogVBox15,300,250);
                                dialogVBox15.setAlignment(Pos.CENTER);
                                dialogVBox15.setSpacing(10);
                                dialogVBox15.setStyle("-fx-font: 20px Tahoma");
                                dialog15.setScene(dialogScene15);
                                dialog15.show();
                                break;

                            case 16:
                                TranslateTransition transition16 = new TranslateTransition();
                                transition16.setNode(MainMetPionView.getRectangle1());
                                transition16.setDuration(Duration.seconds(1));
                                transition16.setToX(10*150);
                                transition16.setToY(6 * 90);
                                //transition16.setCycleCount(Timeline.INDEFINITE);
                                transition16.setInterpolator(Interpolator.EASE_BOTH);
                                transition16.play();

                                final Stage dialog16 = new Stage();
                                dialog16.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox16 = new VBox();
                                dialog16.setTitle("Lippenslaan");
                                dialogVBox16.getChildren().addAll(new Text("Aankoopprijs: €180.000"),new Text("Huur: €18.000"),
                                        new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene16 = new Scene(dialogVBox16,300,250);
                                dialogVBox16.setAlignment(Pos.CENTER);
                                dialogVBox16.setSpacing(10);
                                dialogVBox16.setStyle("-fx-font: 20px Tahoma");
                                dialog16.setScene(dialogScene16);
                                dialog16.show();
                                break;

                            case 17:
                                TranslateTransition transition17 = new TranslateTransition();
                                transition17.setNode(MainMetPionView.getRectangle1());
                                transition17.setDuration(Duration.seconds(1));
                                transition17.setToX(10*150);
                                transition17.setToY(7 * 90);
                                //transition17.setCycleCount(Timeline.INDEFINITE);
                                transition17.setInterpolator(Interpolator.EASE_BOTH);
                                transition17.play();

                                final Stage dialog17 = new Stage();
                                dialog17.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox17 = new VBox();
                                dialog17.setTitle("Neem Kaart");
                                Button button17 = new Button("Neem een kaart");
                                dialogVBox17.getChildren().addAll(new Text("Neem een kaart"),button17);
                                Scene dialogScene17 = new Scene(dialogVBox17,300,250);
                                dialogVBox17.setAlignment(Pos.CENTER);
                                dialogVBox17.setSpacing(10);
                                dialogVBox17.setStyle("-fx-font: 20px Tahoma");
                                dialog17.setScene(dialogScene17);
                                dialog17.show();

                                button17.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        dialog17.close();
                                    }
                                });
                                break;

                            case 18:
                                TranslateTransition transition18 = new TranslateTransition();
                                transition18.setNode(MainMetPionView.getRectangle1());
                                transition18.setDuration(Duration.seconds(1));
                                transition18.setToX(10*150);
                                transition18.setToY(8 * 90);
                                //transition18.setCycleCount(Timeline.INDEFINITE);
                                transition18.setInterpolator(Interpolator.EASE_BOTH);
                                transition18.play();

                                final Stage dialog18 = new Stage();
                                dialog18.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox18 = new VBox();
                                dialog18.setTitle("Rue Royal");
                                dialogVBox18.getChildren().addAll(new Text("Aankoopprijs: €180.000"),new Text("Huur: €18.000"),
                                        new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene18 = new Scene(dialogVBox18,300,250);
                                dialogVBox18.setAlignment(Pos.CENTER);
                                dialogVBox18.setSpacing(10);
                                dialogVBox18.setStyle("-fx-font: 20px Tahoma");
                                dialog18.setScene(dialogScene18);
                                dialog18.show();
                                break;

                            case 19:
                                TranslateTransition transition19 = new TranslateTransition();
                                transition19.setNode(MainMetPionView.getRectangle1());
                                transition19.setDuration(Duration.seconds(1));
                                transition19.setToX(10*150);
                                transition19.setToY(9 * 90);
                                //transition19.setCycleCount(Timeline.INDEFINITE);
                                transition19.setInterpolator(Interpolator.EASE_BOTH);
                                transition19.play();

                                final Stage dialog19 = new Stage();
                                dialog19.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox19 = new VBox();
                                dialog19.setTitle("Groenplaats");
                                dialogVBox19.getChildren().addAll(new Text("Aankoopprijs: €200.000"),new Text("Huur: €20.000"),
                                        new Text("Hypotheek: €100.000"), new Text("Huisprijs: €100.000"));
                                Scene dialogScene19 = new Scene(dialogVBox19,300,250);
                                dialogVBox19.setAlignment(Pos.CENTER);
                                dialogVBox19.setSpacing(10);
                                dialogVBox19.setStyle("-fx-font: 20px Tahoma");
                                dialog19.setScene(dialogScene19);
                                dialog19.show();
                                break;

                            case 20:
                                TranslateTransition transition20 = new TranslateTransition();
                                transition20.setNode(MainMetPionView.getRectangle1());
                                transition20.setDuration(Duration.seconds(1));
                                transition20.setToX(10*150);
                                transition20.setToY(10 * 90);
                                //transition20.setCycleCount(Timeline.INDEFINITE);
                                transition20.setInterpolator(Interpolator.EASE_BOTH);
                                transition20.play();

                                final Stage dialog20 = new Stage();
                                dialog20.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox20 = new VBox();
                                dialog20.setTitle("Antimonopoly-stichting");
                                Button button201 = new Button("Concurrent");
                                Button button202 = new Button("Monopolist");
                                dialogVBox20.getChildren().addAll(new Text("Antimonopoly-stichting"),new Text("Ik ben een: "),
                                        button201,button202);
                                Scene dialogScene20 = new Scene(dialogVBox20,300,250);
                                dialogVBox20.setAlignment(Pos.CENTER);
                                dialogVBox20.setSpacing(10);
                                dialogVBox20.setStyle("-fx-font: 20px Tahoma");
                                dialog20.setScene(dialogScene20);
                                dialog20.show();
                                break;


                            case 21:
                                TranslateTransition transition21 = new TranslateTransition();
                                transition21.setNode(MainMetPionView.getRectangle1());
                                transition21.setDuration(Duration.seconds(1));
                                transition21.setToX(9*150);
                                transition21.setToY(10 * 90);
                                //transition21.setCycleCount(Timeline.INDEFINITE);
                                transition21.setInterpolator(Interpolator.EASE_BOTH);
                                transition21.play();

                                final Stage dialog21 = new Stage();
                                dialog21.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox21 = new VBox();
                                dialog21.setTitle("Rue Saint Leonard");
                                dialogVBox21.getChildren().addAll(new Text("Aankoopprijs: €220.000"),new Text("Huur: €22.000"),
                                        new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene21 = new Scene(dialogVBox21,300,250);
                                dialogVBox21.setAlignment(Pos.CENTER);
                                dialogVBox21.setSpacing(10);
                                dialogVBox21.setStyle("-fx-font: 20px Tahoma");
                                dialog21.setScene(dialogScene21);
                                dialog21.show();
                                break;

                            case 22:
                                TranslateTransition transition22 = new TranslateTransition();
                                transition22.setNode(MainMetPionView.getRectangle1());
                                transition22.setDuration(Duration.seconds(1));
                                transition22.setToX(8*150);
                                transition22.setToY(10 * 90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition22.setInterpolator(Interpolator.EASE_BOTH);
                                transition22.play();

                                final Stage dialog22 = new Stage();
                                dialog22.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox22 = new VBox();
                                dialog22.setTitle("Neem Kaart");
                                Button button22 = new Button("Neem een kaart");
                                dialogVBox22.getChildren().addAll(new Text("Neem een kaart"),button22);
                                Scene dialogScene22 = new Scene(dialogVBox22,300,250);
                                dialogVBox22.setAlignment(Pos.CENTER);
                                dialogVBox22.setSpacing(10);
                                dialogVBox22.setStyle("-fx-font: 20px Tahoma");
                                dialog22.setScene(dialogScene22);
                                dialog22.show();

                                button22.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        dialog22.close();
                                    }
                                });
                                break;

                            case 23:
                                TranslateTransition transition23= new TranslateTransition();
                                transition23.setNode(MainMetPionView.getRectangle1());
                                transition23.setDuration(Duration.seconds(1));
                                transition23.setToX(7*150);
                                transition23.setToY(10 * 90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition23.setInterpolator(Interpolator.EASE_BOTH);
                                transition23.play();

                                final Stage dialog23 = new Stage();
                                dialog23.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox23 = new VBox();
                                dialog23.setTitle("Lange Steenstraat");
                                dialogVBox23.getChildren().addAll(new Text("Aankoopprijs: €220.000"),new Text("Huur: €22.000"),
                                        new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene23 = new Scene(dialogVBox23,300,250);
                                dialogVBox23.setAlignment(Pos.CENTER);
                                dialogVBox23.setSpacing(10);
                                dialogVBox23.setStyle("-fx-font: 20px Tahoma");
                                dialog23.setScene(dialogScene23);
                                dialog23.show();
                                break;

                            case 24:
                                TranslateTransition transition24 = new TranslateTransition();
                                transition24.setNode(MainMetPionView.getRectangle1());
                                transition24.setDuration(Duration.seconds(1));
                                transition24.setToX(6*150);;
                                transition24.setToY(10 * 90);
                                //transition24.setCycleCount(Timeline.INDEFINITE);
                                transition24.setInterpolator(Interpolator.EASE_BOTH);
                                transition24.play();

                                final Stage dialog24 = new Stage();
                                dialog24.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox24 = new VBox();
                                dialog24.setTitle("Grand Place");
                                dialogVBox24.getChildren().addAll(new Text("Aankoopprijs: €240.000"),new Text("Huur: €24.000"),
                                        new Text("Hypotheek: €120.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene24 = new Scene(dialogVBox24,300,250);
                                dialogVBox24.setAlignment(Pos.CENTER);
                                dialogVBox24.setSpacing(10);
                                dialogVBox24.setStyle("-fx-font: 20px Tahoma");
                                dialog24.setScene(dialogScene24);
                                dialog24.show();
                                break;

                            case 25:
                                TranslateTransition transition25 = new TranslateTransition();
                                transition25.setNode(MainMetPionView.getRectangle1());
                                transition25.setDuration(Duration.seconds(1));
                                transition25.setToX(5*150);
                                transition25.setToY(10 * 90);
                                //transition25.setCycleCount(Timeline.INDEFINITE);
                                transition25.setInterpolator(Interpolator.EASE_BOTH);
                                transition25.play();

                                final Stage dialog25 = new Stage();
                                dialog25.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox25 = new VBox();
                                dialog25.setTitle("Zuid Station");
                                dialogVBox25.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                                Scene dialogScene25 = new Scene(dialogVBox25,300,250);
                                dialogVBox25.setAlignment(Pos.CENTER);
                                dialogVBox25.setSpacing(10);
                                dialogVBox25.setStyle("-fx-font: 20px Tahoma");
                                dialog25.setScene(dialogScene25);
                                dialog25.show();
                                break;

                            case 26:
                                TranslateTransition transition26 = new TranslateTransition();
                                transition26.setNode(MainMetPionView.getRectangle1());
                                transition26.setDuration(Duration.seconds(1));
                                transition26.setToX(4*150);
                                transition26.setToY(10 * 90);
                                //transition26.setCycleCount(Timeline.INDEFINITE);
                                transition26.setInterpolator(Interpolator.EASE_BOTH);
                                transition26.play();

                                final Stage dialog26 = new Stage();
                                dialog26.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox26 = new VBox();
                                dialog26.setTitle("Grote Markt");
                                dialogVBox26.getChildren().addAll(new Text("Aankoopprijs: €260.000"),new Text("Huur: €26.000"),
                                        new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene26 = new Scene(dialogVBox26,300,250);
                                dialogVBox26.setAlignment(Pos.CENTER);
                                dialogVBox26.setSpacing(10);
                                dialogVBox26.setStyle("-fx-font: 20px Tahoma");
                                dialog26.setScene(dialogScene26);
                                dialog26.show();
                                break;

                            case 27:
                                TranslateTransition transition27 = new TranslateTransition();
                                transition27.setNode(MainMetPionView.getRectangle1());
                                transition27.setDuration(Duration.seconds(1));
                                transition27.setToX(3*150);
                                transition27.setToY(10 * 90);
                                //transition27.setCycleCount(Timeline.INDEFINITE);
                                transition27.setInterpolator(Interpolator.EASE_BOTH);
                                transition27.play();

                                final Stage dialog27 = new Stage();
                                dialog27.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox27 = new VBox();
                                dialog27.setTitle("Place De l'Ange");
                                dialogVBox27.getChildren().addAll(new Text("Aankoopprijs: €260.000"),new Text("Huur: €26.000"),
                                        new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene27 = new Scene(dialogVBox27,300,250);
                                dialogVBox27.setAlignment(Pos.CENTER);
                                dialogVBox27.setSpacing(10);
                                dialogVBox27.setStyle("-fx-font: 20px Tahoma");
                                dialog27.setScene(dialogScene27);
                                dialog27.show();
                                break;

                            case 28:
                                TranslateTransition transition28 = new TranslateTransition();
                                transition28.setNode(MainMetPionView.getRectangle1());
                                transition28.setDuration(Duration.seconds(1));
                                transition28.setToX(2*150);
                                transition28.setToY(10 * 90);
                                //transition28.setCycleCount(Timeline.INDEFINITE);
                                transition28.setInterpolator(Interpolator.EASE_BOTH);
                                transition28.play();

                                final Stage dialog28 = new Stage();
                                dialog28.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox28 = new VBox();
                                dialog28.setTitle("Gasmaatschappij");
                                Button button28 = new Button("Dobbelen");
                                dialogVBox28.getChildren().addAll(new Text("Gasmaatschappij"),new Text("Dobbel voor rekening"),
                                        button28);
                                Scene dialogScene28 = new Scene(dialogVBox28,300,250);
                                dialogVBox28.setAlignment(Pos.CENTER);
                                dialogVBox28.setSpacing(10);
                                dialogVBox28.setStyle("-fx-font: 20px Tahoma");
                                dialog28.setScene(dialogScene28);
                                dialog28.show();
                                break;


                            case 29:
                                TranslateTransition transition29 = new TranslateTransition();
                                transition29.setNode(MainMetPionView.getRectangle1());
                                transition29.setDuration(Duration.seconds(1));
                                transition29.setToX(150);
                                transition29.setToY(10 * 90);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition29.setInterpolator(Interpolator.EASE_BOTH);
                                transition29.play();

                                final Stage dialog29 = new Stage();
                                dialog29.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox29 = new VBox();
                                dialog29.setTitle("Hoogstraat");
                                dialogVBox29.getChildren().addAll(new Text("Aankoopprijs: €280.000"),new Text("Huur: €28.000"),
                                        new Text("Hypotheek: €140.000"), new Text("Huisprijs: €150.000"));
                                Scene dialogScene29 = new Scene(dialogVBox29,300,250);
                                dialogVBox29.setAlignment(Pos.CENTER);
                                dialogVBox29.setSpacing(10);
                                dialogVBox29.setStyle("-fx-font: 20px Tahoma");
                                dialog29.setScene(dialogScene29);
                                dialog29.show();
                                break;

                            case 30:
                                TranslateTransition transition30 = new TranslateTransition();
                                transition30.setNode(MainMetPionView.getRectangle1());
                                transition30.setDuration(Duration.seconds(1));
                                transition30.setToX(0);
                                transition30.setToY(10 * 90);
                                //transition30.setCycleCount(Timeline.INDEFINITE);
                                transition30.setInterpolator(Interpolator.EASE_BOTH);
                                transition30.play();
                                break;

                            case 31:
                                TranslateTransition transition31 = new TranslateTransition();
                                transition31.setNode(MainMetPionView.getRectangle1());
                                transition31.setDuration(Duration.seconds(1));
                                transition31.setToX(0);
                                transition31.setToY(9 * 90);
                                //transition31.setCycleCount(Timeline.INDEFINITE);
                                transition31.setInterpolator(Interpolator.EASE_BOTH);
                                transition31.play();

                                final Stage dialog31 = new Stage();
                                dialog31.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox31 = new VBox();
                                dialog31.setTitle("Veldstraat");
                                dialogVBox31.getChildren().addAll(new Text("Aankoopprijs: €300.000"),new Text("Huur: €30.000"),
                                        new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                                Scene dialogScene31 = new Scene(dialogVBox31,300,250);
                                dialogVBox31.setAlignment(Pos.CENTER);
                                dialogVBox31.setSpacing(10);
                                dialogVBox31.setStyle("-fx-font: 20px Tahoma");
                                dialog31.setScene(dialogScene31);
                                dialog31.show();
                                break;

                            case 32:
                                TranslateTransition transition32 = new TranslateTransition();
                                transition32.setNode(MainMetPionView.getRectangle1());
                                transition32.setDuration(Duration.seconds(1));
                                transition32.setToX(0);
                                transition32.setToY(8 * 90);
                                //transition32.setCycleCount(Timeline.INDEFINITE);
                                transition32.setInterpolator(Interpolator.EASE_BOTH);
                                transition32.play();

                                final Stage dialog32 = new Stage();
                                dialog32.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox32 = new VBox();
                                dialog32.setTitle("Boulevard Tirou");
                                dialogVBox32.getChildren().addAll(new Text("Aankoopprijs: €300.000"),new Text("Huur: €30.000"),
                                        new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"));
                                Scene dialogScene32 = new Scene(dialogVBox32,300,250);
                                dialogVBox32.setAlignment(Pos.CENTER);
                                dialogVBox32.setSpacing(10);
                                dialogVBox32.setStyle("-fx-font: 20px Tahoma");
                                dialog32.setScene(dialogScene32);
                                dialog32.show();
                                break;

                            case 33:
                                TranslateTransition transition33 = new TranslateTransition();
                                transition33.setNode(MainMetPionView.getRectangle1());
                                transition33.setDuration(Duration.seconds(1));
                                transition33.setToX(0);
                                transition33.setToY(7 * 90);
                                //transition33.setCycleCount(Timeline.INDEFINITE);
                                transition33.setInterpolator(Interpolator.EASE_BOTH);
                                transition33.play();

                                final Stage dialog33 = new Stage();
                                dialog33.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox33 = new VBox();
                                dialog33.setTitle("Neem Kaart");
                                Button button33 = new Button("Neem een kaart");
                                dialogVBox33.getChildren().addAll(new Text("Neem een kaart"),button33);
                                Scene dialogScene33 = new Scene(dialogVBox33,300,250);
                                dialogVBox33.setAlignment(Pos.CENTER);
                                dialogVBox33.setSpacing(10);
                                dialogVBox33.setStyle("-fx-font: 20px Tahoma");
                                dialog33.setScene(dialogScene33);
                                dialog33.show();

                                button33.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        dialog33.close();
                                    }
                                });
                                break;

                            case 34:
                                TranslateTransition transition34 = new TranslateTransition();
                                transition34.setNode(MainMetPionView.getRectangle1());
                                transition34.setDuration(Duration.seconds(1));
                                transition34.setToX(0);
                                transition34.setToY(6 * 90);
                                //transition34.setCycleCount(Timeline.INDEFINITE);
                                transition34.setInterpolator(Interpolator.EASE_BOTH);
                                transition34.play();

                                final Stage dialog34 = new Stage();
                                dialog34.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox34 = new VBox();
                                dialog34.setTitle("Boulevard d'Avroy");
                                dialogVBox34.getChildren().addAll(new Text("Aankoopprijs: €320.000"),new Text("Huur: €32.000"),
                                        new Text("Hypotheek: €160.000"), new Text("Huisprijs: €200.000"));
                                Scene dialogScene34 = new Scene(dialogVBox34,300,250);
                                dialogVBox34.setAlignment(Pos.CENTER);
                                dialogVBox34.setSpacing(10);
                                dialogVBox34.setStyle("-fx-font: 20px Tahoma");
                                dialog34.setScene(dialogScene34);
                                dialog34.show();
                                break;

                            case 35:
                                TranslateTransition transition35 = new TranslateTransition();
                                transition35.setNode(MainMetPionView.getRectangle1());
                                transition35.setDuration(Duration.seconds(1));
                                transition35.setToX(0);
                                transition35.setToY(5 * 90);
                                //transition35.setCycleCount(Timeline.INDEFINITE);
                                transition35.setInterpolator(Interpolator.EASE_BOTH);
                                transition35.play();

                                final Stage dialog35 = new Stage();
                                dialog35.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox35 = new VBox();
                                dialog35.setTitle("West Station");
                                dialogVBox35.getChildren().addAll(new Text("Aankoopprijs: €200.000"));
                                Scene dialogScene35 = new Scene(dialogVBox35,300,250);
                                dialogVBox35.setAlignment(Pos.CENTER);
                                dialogVBox35.setSpacing(10);
                                dialogVBox35.setStyle("-fx-font: 20px Tahoma");
                                dialog35.setScene(dialogScene35);
                                dialog35.show();
                                break;

                            case 36:
                                TranslateTransition transition36 = new TranslateTransition();
                                transition36.setNode(MainMetPionView.getRectangle1());
                                transition36.setDuration(Duration.seconds(1));
                                transition36.setToX(0);
                                transition36.setToY(4 * 90);
                                //transition36.setCycleCount(Timeline.INDEFINITE);
                                transition36.setInterpolator(Interpolator.EASE_BOTH);
                                transition36.play();

                                final Stage dialog36 = new Stage();
                                dialog36.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox36 = new VBox();
                                dialog36.setTitle("Neem Kaart");
                                Button button36 = new Button("Neem een kaart");
                                dialogVBox36.getChildren().addAll(new Text("Neem een kaart"),button36);
                                Scene dialogScene36 = new Scene(dialogVBox36,300,250);
                                dialogVBox36.setAlignment(Pos.CENTER);
                                dialogVBox36.setSpacing(10);
                                dialogVBox36.setStyle("-fx-font: 20px Tahoma");
                                dialog36.setScene(dialogScene36);
                                dialog36.show();

                                button36.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        dialog36.close();
                                    }
                                });
                                break;

                            case 37:
                                TranslateTransition transition37 = new TranslateTransition();
                                transition37.setNode(MainMetPionView.getRectangle1());
                                transition37.setDuration(Duration.seconds(1));
                                transition37.setToX(0);
                                transition37.setToY(3 * 90);
                                //transition37.setCycleCount(Timeline.INDEFINITE);
                                transition37.setInterpolator(Interpolator.EASE_BOTH);
                                transition37.play();

                                final Stage dialog37 = new Stage();
                                dialog37.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox37 = new VBox();
                                dialog37.setTitle("Meir");
                                dialogVBox37.getChildren().addAll(new Text("Aankoopprijs: €350.000"),new Text("Huur: €35.000"),
                                        new Text("Hypotheek: €175.000"), new Text("Huisprijs: €200.000"));
                                Scene dialogScene37 = new Scene(dialogVBox37,300,250);
                                dialogVBox37.setAlignment(Pos.CENTER);
                                dialogVBox37.setSpacing(10);
                                dialogVBox37.setStyle("-fx-font: 20px Tahoma");
                                dialog37.setScene(dialogScene37);
                                dialog37.show();
                                break;

                            case 38:
                                TranslateTransition transition38 = new TranslateTransition();
                                transition38.setNode(MainMetPionView.getRectangle1());
                                transition38.setDuration(Duration.seconds(1));
                                transition38.setToX(0);
                                transition38.setToY(2 * 90);
                                //transition38.setCycleCount(Timeline.INDEFINITE);
                                transition38.setInterpolator(Interpolator.EASE_BOTH);
                                transition38.play();

                                final Stage dialog38 = new Stage();
                                dialog38.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox38 = new VBox();
                                dialog38.setTitle("Eigendomsbelasting");
                                Button button38 = new Button();
                                dialogVBox38.getChildren().addAll(new Text("Betaal"),button38);
                                Scene dialogScene38 = new Scene(dialogVBox38,300,250);
                                dialogVBox38.setAlignment(Pos.CENTER);
                                dialogVBox38.setSpacing(10);
                                dialogVBox38.setStyle("-fx-font: 20px Tahoma");
                                dialog38.setScene(dialogScene38);
                                dialog38.show();
                                break;

                            case 39:
                                TranslateTransition transition39 = new TranslateTransition();
                                transition39.setNode(MainMetPionView.getRectangle1());
                                transition39.setDuration(Duration.seconds(1));
                                transition39.setToX(0);
                                transition39.setToY(90);
                                //transition39.setCycleCount(Timeline.INDEFINITE);
                                transition39.setInterpolator(Interpolator.EASE_BOTH);
                                transition39.play();

                                final Stage dialog39 = new Stage();
                                dialog39.initModality(Modality.APPLICATION_MODAL);
                                VBox dialogVBox39 = new VBox();
                                dialog39.setTitle("Nieuwstraat");
                                dialogVBox39.getChildren().addAll(new Text("Aankoopprijs: €400.000"),new Text("Huur: €40.000"),
                                        new Text("Hypotheek: €200.000"), new Text("Huisprijs: €200.000"));
                                Scene dialogScene39 = new Scene(dialogVBox39,300,250);
                                dialogVBox39.setAlignment(Pos.CENTER);
                                dialogVBox39.setSpacing(10);
                                dialogVBox39.setStyle("-fx-font: 20px Tahoma");
                                dialog39.setScene(dialogScene39);
                                dialog39.show();
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

