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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €60.000"), new Text("Huisprijs: €50.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €80.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €100.000"), new Text("Huisprijs: €100.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €120.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €140.000"), new Text("Huisprijs: €150.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €160.000"), new Text("Huisprijs: €200.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €175.000"), new Text("Huisprijs: €200.000"), new Button("Koop"));
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
                                new Text("Hypotheek: €200.000"), new Text("Huisprijs: €200.000"), new Button("Koop"));
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
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Button("Koop"));
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
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Button("Koop"));
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
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Button("Koop"));
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
                        dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Button("Koop"));
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
                count = count++;                                                                            //counter werkt niet
                Label label = new Label(String.valueOf(count));
                dialogVBox.getChildren().addAll(new Text(String.valueOf(Dice.rollDice())), button, label);
                Scene dialogScene = new Scene(dialogVBox,300,250);
                dialogVBox.setAlignment(Pos.CENTER);
                dialogVBox.setSpacing(10);
                dialogVBox.setStyle("-fx-font: 20px Tahoma");
                dialog.setScene(dialogScene);
                dialog.show();


                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(view.getRectangle1().getX()<1500) {                                          //if voorwaarde werkt niet
                            for (int i = 0; i < (Dice.getWorp2()[0] + Dice.getWorp2()[1]); i++) {       //For lus werkt niet
                                TranslateTransition transition1 = new TranslateTransition();
                                transition1.setNode(view.getRectangle1());
                                transition1.setDuration(Duration.seconds(1));
                                transition1.setByX(150);
                                //transition1.setCycleCount(Timeline.INDEFINITE);
                                transition1.setInterpolator(Interpolator.EASE_BOTH);
                                transition1.play();
                                updateView();
                            }
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
