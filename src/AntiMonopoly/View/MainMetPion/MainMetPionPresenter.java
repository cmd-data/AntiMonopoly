package AntiMonopoly.View.MainMetPion;

import AntiMonopoly.Model.*;
import AntiMonopoly.View.Dice.DiceView;
import AntiMonopoly.View.EndGame.EndGamePresenter;
import AntiMonopoly.View.EndGame.EndGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainMetPionPresenter {

    private AntiMonopolyMain model;
    private MainMetPionView view;
    private DiceView diceView;

    public MainMetPionPresenter(AntiMonopolyMain model, MainMetPionView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Spelopties

        view.getMainView().getHypotheekKnop().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVBox = new VBox();

                Button button = new Button("Op hypotheek");
                ObservableList<String> eigendommen =
                        FXCollections.observableArrayList(Speler.eigendommen(Spel.getSpelers().get(Dice.getCount()-1))); //eigendommen van de speler die aan de beurt is
                view.getMainView().getEigendommen().setItems(eigendommen);

                dialog.setTitle("Eigendom op hypotheek zetten");
                dialogVBox.getChildren().addAll(new Text("Eigendommen: "),view.getMainView().getEigendommen(), button);
                Scene dialogScene = new Scene(dialogVBox, 300, 250);
                dialogVBox.setAlignment(Pos.CENTER);
                dialogVBox.setSpacing(10);
                dialogVBox.setStyle("-fx-font: 20px Tahoma");
                dialog.setScene(dialogScene);
                dialog.show();

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        for (Tegel tegel : Spelbord.getTegels()) {
                            if (view.getMainView().getEigendommen().getValue().equals(tegel.getNaam())){
                                Hypotheek.neemHypotheek(tegel,Spel.getSpelers().get(Dice.getCount()-1));
                                dialog.close();
                            }
                        }
                    }
                });
            }
        });

        view.getDiceView().getRolButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int worp = Dice.rollDice();
                Spel.updateAanZet();

                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVBox = new VBox();
                dialog.setTitle("Worp");
                Button button = new Button("Zet Pion");
                DiceView.getDie1().setImage(new Image("/images/die" + Dice.getWorp2()[0] + ".png"));
                DiceView.getDie2().setImage(new Image("/images/die" + Dice.getWorp2()[1] + ".png"));
                Label label2 = new Label (String.valueOf(Dice.getWorp2()[1]));
                dialogVBox.getChildren().addAll(button, DiceView.getDie1(), DiceView.getDie2());
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

                        switch (Dice.getCount()) {
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

                        int locatie = Spel.move(aanZet, worp).getPositie();
                        dialog.close();                                                          // sluit het venster als je op 'Zet pion' klikt

                        Tegel.tegelMethode(pion, aanZet, locatie);

                        if(Spel.eindeSpel()){
                            EndGameView view = new EndGameView();
                            new EndGamePresenter(model,view);
                        }



                    }
                });
            }
        });

        view.getMainView().getRg2().setOnAction(
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
        view.getMainView().getDs2().setOnAction(
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
        view.getMainView().getSs2().setOnAction(
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
        view.getMainView().getPdm2().setOnAction(
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
        view.getMainView().getKs2().setOnAction(
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
        view.getMainView().getRdd2().setOnAction(
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
        view.getMainView().getB2().setOnAction(
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
        view.getMainView().getPv2().setOnAction(
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
        view.getMainView().getLl2().setOnAction(
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
        view.getMainView().getRr2().setOnAction(
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
        view.getMainView().getGp2().setOnAction(
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
        view.getMainView().getRsl2().setOnAction(
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
        view.getMainView().getLs2().setOnAction(
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
        view.getMainView().getGpm2().setOnAction(
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
        view.getMainView().getGm2().setOnAction(
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
        view.getMainView().getPdl2().setOnAction(
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
        view.getMainView().getH2().setOnAction(
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
        view.getMainView().getV2().setOnAction(
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
        view.getMainView().getBv2().setOnAction(
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
        view.getMainView().getBda2().setOnAction(
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
        view.getMainView().getM2().setOnAction(
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
        view.getMainView().getN2().setOnAction(
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
        view.getMainView().getNs2().setOnAction(
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
        view.getMainView().getZs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Buurtspoorwegen");
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
        view.getMainView().getOs2().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        VBox dialogVBox = new VBox();
                        dialog.setTitle("Centraal Station");
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
        view.getMainView().getWs2().setOnAction(
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

        //Spelregels
        view.getMainView().getSpelregelsMI().setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Stage dialog = new Stage();
                        dialog.initModality(Modality.APPLICATION_MODAL);
                        dialog.setTitle("Spelregels");
                        Spelregels spelregels = new Spelregels();
                        VBox vBoxSR = new VBox();
                        vBoxSR.setPadding(new Insets(30));
                        vBoxSR.getChildren().addAll(new Text(spelregels.getSpelregels()));
                        ScrollPane scrollPane = new ScrollPane();
                        scrollPane.setContent(vBoxSR);
                        Scene dialogScene = new Scene(scrollPane, 1500, 800);
                        scrollPane.setStyle("-fx-font: 20px Tahoma");
                        dialog.setScene(dialogScene);
                        dialog.show();
                    }
                }
        );
    }

    public void addWindowEventHandlers() {
    }


    private void updateView() {
    }
}

