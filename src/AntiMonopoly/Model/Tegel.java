package AntiMonopoly.Model;

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
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tegel {

	private int positie;
	private String naam;
	private List<Speler> spelers;

	Rectangle pion = null;
	Speler aanZet = null;

	public Tegel(String naam, int positie) {
		this.naam = naam;
		this.positie = positie;
	}

	public void kopen(){}

	public static void koopEigendom (Tegel tegel, Speler speler){

		if (tegel instanceof Straat){
			Straat.koopStraat(speler,(Straat) tegel);
		}
		if (tegel instanceof Transport){
			((Transport) tegel).koopTransportbedrijf(speler,(Transport) tegel);
		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			((GasEnElektriciteitsbedrijf) tegel).koopGasofElektriciteitsbedrijf(speler,(GasEnElektriciteitsbedrijf) tegel);
		}
		Spel.updateGeld(speler);
	}

	public boolean kopen(Tegel tegel){
		if(tegel instanceof Straat){
			return true;
		}
		if(tegel instanceof Transport){
			return true;
		}
		return tegel instanceof GasEnElektriciteitsbedrijf;
	}

	public static boolean heeftEigenaar(Tegel tegel){
		if(tegel instanceof Straat){
			return (((Straat) Spelbord.getTegels().get(tegel.positie)).getEigenaar() !=null);
		}
		if(tegel instanceof Transport){
			return (((Transport) Spelbord.getTegels().get(tegel.positie)).getEigenaar() !=null);
		}
		if(tegel instanceof GasEnElektriciteitsbedrijf){
			return ((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(tegel.positie)).getEigenaar() != null;
		}
		return true;
	}

	public String Eigenaar (Tegel tegel){
		try {
			if (tegel instanceof Straat) {
				return (((Straat) Spelbord.getTegels().get(tegel.positie)).getEigenaar().getNaam());
			}
			if (tegel instanceof Transport) {
				return (((Transport) Spelbord.getTegels().get(tegel.positie)).getEigenaar().getNaam());
			}
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				return ((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(tegel.positie)).getEigenaar().getNaam();
			}
		} catch (NullPointerException ignored) {}
		return null;
	}

	public boolean heeftHypotheek(Tegel tegel){
		return Hypotheek.getHypotheekLijst().contains(tegel);
	}

	public static void betaalHuur(Tegel tegel, Speler speler){

		if (tegel instanceof Straat){
			speler.setGeld(-Straat.getHuur((Straat) tegel));
			((Straat) tegel).getEigenaar().setGeld(Straat.getHuur((Straat) tegel));
			Spel.updateGeld(((Straat) tegel).getEigenaar());
		}
		if (tegel instanceof Transport){
			speler.setGeld(-Transport.getHuur((Transport) tegel));
			((Transport) tegel).getEigenaar().setGeld(Transport.getHuur((Transport) tegel));
			Spel.updateGeld(((Transport) tegel).getEigenaar());
		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			speler.setGeld(-GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
			((GasEnElektriciteitsbedrijf) tegel).getEigenaar().setGeld(GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
			Spel.updateGeld(((GasEnElektriciteitsbedrijf) tegel).getEigenaar());
		}

		Spel.updateGeld(speler);
	}

	public static void tegelMethode(Rectangle pion, Speler aanZet, int locatie) {

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
				Button button0 = new Button("OK");
				dialogVBox0.getChildren().addAll(new Text("U staat op start en ontvangt: \n€200.000"));
				Scene dialogScene0 = new Scene(dialogVBox0, 300, 250);
				dialogVBox0.setAlignment(Pos.CENTER);
				dialogVBox0.setSpacing(10);
				dialogVBox0.setStyle("-fx-font: 20px Tahoma");
				dialog0.setScene(dialogScene0);
				dialog0.show();

				button0.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog0.close();
					}
				});

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
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog11 = new Stage();
					dialog11.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox11 = new VBox();
					dialog11.setTitle("Rue Grande");
					Button button11 = new Button("Koop");
					dialogVBox11.getChildren().addAll(new Text("Aankoopprijs: €60.000"), new Text("Huur: €6.000"),
							new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"), button11);
					Scene dialogScene11 = new Scene(dialogVBox11, 300, 250);
					dialogVBox11.setAlignment(Pos.CENTER);
					dialogVBox11.setSpacing(10);
					dialogVBox11.setStyle("-fx-font: 20px Tahoma");
					dialog11.setScene(dialogScene11);
					dialog11.show();

					Speler finalAanZet11 = aanZet;
					button11.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet11);

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
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog13 = new Stage();
					dialog13.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox13 = new VBox();
					dialog13.setTitle("Betaal Huur");
					Button button13 = new Button("Betaal huur");
					dialogVBox13.getChildren().addAll(new Text("U dient huur te betalen. "), button13);
					Scene dialogScene13 = new Scene(dialogVBox13, 300, 250);
					dialogVBox13.setAlignment(Pos.CENTER);
					dialogVBox13.setSpacing(10);
					dialogVBox13.setStyle("-fx-font: 20px Tahoma");
					dialog13.setScene(dialogScene13);
					dialog13.show();

					Speler finalAanZet12 = aanZet;
					button13.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet12);

							final Stage dialog14 = new Stage();
							dialog14.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox14 = new VBox();
							dialog14.setTitle("Huur");
							Button button1 = new Button("OK");
							dialogVBox14.getChildren().addAll(new Text("U betaalde huur"),
									button1);
							Scene dialogScene14 = new Scene(dialogVBox14, 300, 250);
							dialogVBox14.setAlignment(Pos.CENTER);
							dialogVBox14.setSpacing(10);
							dialogVBox14.setStyle("-fx-font: 20px Tahoma");
							dialog14.setScene(dialogScene14);
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
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog15 = new Stage();
					dialog15.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox15 = new VBox();
					dialog15.setTitle("Bouw");
					Button button14 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button15 = new Button("Bouw Huis");
					dialogVBox15.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button14, button15);
					Scene dialogScene15 = new Scene(dialogVBox15, 300, 250);
					dialogVBox15.setAlignment(Pos.CENTER);
					dialogVBox15.setSpacing(10);
					dialogVBox15.setStyle("-fx-font: 20px Tahoma");
					dialog15.setScene(dialogScene15);
					dialog15.show();

					//Koop Hotel
					Speler finalAanZet13 = aanZet;
					button14.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet13);

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
									dialog15.close();
									dialog16.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet14 = aanZet;
					button15.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet14);

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
									dialog15.close();
									dialog17.close();
								}
							});
						}
					});
				}
				break;

			case 2:
				TranslateTransition transition2 = new TranslateTransition();
				transition2.setNode(pion);
				transition2.setDuration(Duration.seconds(1));
				transition2.setToX(2 * 150);
				transition2.setToY(0);
				//transition2.setCycleCount(Timeline.INDEFINITE);
				transition2.setInterpolator(Interpolator.EASE_BOTH);
				transition2.play();

				final Stage dialog21 = new Stage();
				dialog21.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox21 = new VBox();
				dialog21.setTitle("Neem Kaart");
				Button button21 = new Button("Neem een kaart");
				dialogVBox21.getChildren().addAll(new Text("Neem een kaart"), button21);
				Scene dialogScene21 = new Scene(dialogVBox21, 300, 250);
				dialogVBox21.setAlignment(Pos.CENTER);
				dialogVBox21.setSpacing(10);
				dialogVBox21.setStyle("-fx-font: 20px Tahoma");
				dialog21.setScene(dialogScene21);
				dialog21.show();

				Speler finalAanZet21 = aanZet;
				button21.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog21.close();

						final Stage dialog22 = new Stage();
						dialog22.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox22 = new VBox();
						dialog22.setTitle("Opdracht");
						Button button22 = new Button("OK");
						dialogVBox22.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet21)), button22);
						Scene dialogScene22 = new Scene(dialogVBox22, 300, 250);
						dialogVBox22.setAlignment(Pos.CENTER);
						dialogVBox22.setSpacing(10);
						dialogVBox22.setStyle("-fx-font: 20px Tahoma");
						dialog22.setScene(dialogScene22);
						dialog22.show();

						button22.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet21);
								dialog21.close();
								dialog22.close();
							}
						});
					}
				});
				break;

			case 3:
				TranslateTransition transition3 = new TranslateTransition();
				transition3.setNode(pion);
				transition3.setDuration(Duration.seconds(1));
				transition3.setToX(3 * 150);
				transition3.setToY(0);
				//transition3.setCycleCount(Timeline.INDEFINITE);
				transition3.setInterpolator(Interpolator.EASE_BOTH);
				transition3.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog31 = new Stage();
					dialog31.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox31 = new VBox();
					dialog31.setTitle("Diestsestraat");
					Button button31 = new Button("Koop");
					dialogVBox31.getChildren().addAll(new Text("Aankoopprijs: €60.000"), new Text("Huur: €6.000"),
							new Text("Hypotheek: €30.000"), new Text("Huisprijs: €50.000"), button31);
					Scene dialogScene31 = new Scene(dialogVBox31, 300, 250);
					dialogVBox31.setAlignment(Pos.CENTER);
					dialogVBox31.setSpacing(10);
					dialogVBox31.setStyle("-fx-font: 20px Tahoma");
					dialog31.setScene(dialogScene31);
					dialog31.show();

					Speler finalAanZet31 = aanZet;
					button31.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet31);

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
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog33 = new Stage();
					dialog33.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox33 = new VBox();
					dialog33.setTitle("Betaal Huur");
					Button button33 = new Button("Betaal Huur");
					dialogVBox33.getChildren().addAll(new Text("U dient huur te betalen. "), button33);
					Scene dialogScene33 = new Scene(dialogVBox33, 300, 250);
					dialogVBox33.setAlignment(Pos.CENTER);
					dialogVBox33.setSpacing(10);
					dialogVBox33.setStyle("-fx-font: 20px Tahoma");
					dialog33.setScene(dialogScene33);
					dialog33.show();


					Speler finalAanZet32 = aanZet;
					button33.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet32);

							final Stage dialog34 = new Stage();
							dialog34.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox34 = new VBox();
							dialog34.setTitle("Huur");
							Button button3 = new Button("OK");
							dialogVBox34.getChildren().addAll(new Text("U betaalde huur"),
									button3);
							Scene dialogScene34 = new Scene(dialogVBox34, 300, 250);
							dialogVBox34.setAlignment(Pos.CENTER);
							dialogVBox34.setSpacing(10);
							dialog34.setScene(dialogScene34);
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
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {// tegel is van de speler zelf

					final Stage dialog35 = new Stage();
					dialog35.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox35 = new VBox();
					dialog35.setTitle("Bouw");
					Button button34 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button35 = new Button("Bouw Huis");
					dialogVBox35.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button34, button35);
					Scene dialogScene35 = new Scene(dialogVBox35, 300, 250);
					dialogVBox35.setAlignment(Pos.CENTER);
					dialogVBox35.setSpacing(10);
					dialog35.setScene(dialogScene35);
					dialogVBox35.setStyle("-fx-font: 20px Tahoma");
					dialog35.show();


					//Koop Hotel
					Speler finalAanZet33 = aanZet;
					button34.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet33);
							final Stage dialog36 = new Stage();
							dialog36.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox36 = new VBox();
							dialog36.setTitle("Hotel");
							Button button36 = new Button("OK");
							dialogVBox36.getChildren().addAll(new Text("U kocht een hotel"), new Text("hoeveel huizen wilt u?"),
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
									dialog35.close();
									dialog36.close();
								}

							});
						}
					});

					//Koop huis
					Speler finalAanZet34 = aanZet;
					button35.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet34);
							final Stage dialog37 = new Stage();
							dialog37.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox37 = new VBox();
							dialog37.setTitle("Hotel");
							Button button37 = new Button("OK");
							dialogVBox37.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button37);
							Scene dialogScene37 = new Scene(dialogVBox37, 300, 250);
							dialogVBox37.setAlignment(Pos.CENTER);
							dialogVBox37.setSpacing(10);
							dialogVBox37.setStyle("-fx-font: 20px Tahoma");
							dialog37.setScene(dialogScene37);
							dialog37.show();

							button37.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog35.close();
									dialog37.close();
								}
							});
						}
					});
				}


				break;

			case 4:
				TranslateTransition transition4 = new TranslateTransition();
				transition4.setNode(pion);
				transition4.setDuration(Duration.seconds(1));
				transition4.setToX(4 * 150);
				transition4.setToY(0);
				//transition4.setCycleCount(Timeline.INDEFINITE);
				transition4.setInterpolator(Interpolator.EASE_BOTH);
				transition4.play();

				final Stage dialog4 = new Stage();
				dialog4.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox4 = new VBox();
				dialog4.setTitle("Inkomstenbelasting");
				Button button4 = new Button("Betaal belasting\n€200.000");
				dialogVBox4.getChildren().addAll(button4);
				Scene dialogScene4 = new Scene(dialogVBox4, 300, 250);
				dialogVBox4.setAlignment(Pos.CENTER);
				dialogVBox4.setSpacing(10);
				dialogVBox4.setStyle("-fx-font: 20px Tahoma");
				dialog4.setScene(dialogScene4);
				dialog4.show();

				Speler finalAanZet = aanZet;
				button4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Inkomstenbelasting.betaalBelasting(finalAanZet);
						dialog4.close();
					}
				});
				break;

			case 5:
				TranslateTransition transition5 = new TranslateTransition();
				transition5.setNode(pion);
				transition5.setDuration(Duration.seconds(1));
				transition5.setToX(5 * 150);
				transition5.setToY(0);
				//transition1.setCycleCount(Timeline.INDEFINITE);
				transition5.setInterpolator(Interpolator.EASE_BOTH);
				transition5.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog51 = new Stage();
					dialog51.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox51 = new VBox();
					dialog51.setTitle("Noord Station");
					Button button51 = new Button("Koop");
					dialogVBox51.getChildren().addAll(new Text("Aankoopprijs: €200.000"), button51);
					Scene dialogScene51 = new Scene(dialogVBox51, 300, 250);
					dialogVBox51.setAlignment(Pos.CENTER);
					dialogVBox51.setSpacing(10);
					dialogVBox51.setStyle("-fx-font: 20px Tahoma");
					dialog51.setScene(dialogScene51);
					dialog51.show();

					Speler finalAanZet51 = aanZet;
					button51.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet51);

							final Stage dialog52 = new Stage();
							dialog52.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox52 = new VBox();
							dialog52.setTitle("Proficiat met uw aankoop!");
							Button button52 = new Button("OK");
							dialogVBox52.getChildren().addAll(new Text("U hebt Station Noord aangekocht"), new Text("voor €200.000"),
									button52);
							Scene dialogScene52 = new Scene(dialogVBox52, 300, 250);
							dialogVBox52.setAlignment(Pos.CENTER);
							dialogVBox52.setSpacing(10);
							dialogVBox52.setStyle("-fx-font: 20px Tahoma");
							dialog52.setScene(dialogScene52);
							dialog52.show();

							button52.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog52.close();
									dialog51.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog53 = new Stage();
					dialog53.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox53 = new VBox();
					dialog53.setTitle("Betaal Huur");
					Button button53 = new Button("Betaal huur");
					dialogVBox53.getChildren().addAll(new Text("U dient huur te betalen. "), button53);
					Scene dialogScene53 = new Scene(dialogVBox53, 300, 250);
					dialogVBox53.setAlignment(Pos.CENTER);
					dialogVBox53.setSpacing(10);
					dialogVBox53.setStyle("-fx-font: 20px Tahoma");
					dialog53.setScene(dialogScene53);
					dialog53.show();

					Speler finalAanZet52 = aanZet;
					button53.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet52);

							final Stage dialog54 = new Stage();
							dialog54.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox54 = new VBox();
							dialog54.setTitle("Huur");
							Button button5 = new Button("OK");
							dialogVBox54.getChildren().addAll(new Text("U betaalde huur"),
									button5);
							Scene dialogScene54 = new Scene(dialogVBox54, 300, 250);
							dialogVBox54.setAlignment(Pos.CENTER);
							dialogVBox54.setSpacing(10);
							dialogVBox54.setStyle("-fx-font: 20px Tahoma");
							dialog54.setScene(dialogScene54);
							dialog54.show();

							button5.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog53.close();
									dialog54.close();
								}
							});
						}
					});
				}
				break;

			case 6:
				TranslateTransition transition6 = new TranslateTransition();
				transition6.setNode(pion);
				transition6.setDuration(Duration.seconds(1));
				transition6.setToX(6 * 150);
				transition6.setToY(0);
				//transition6.setCycleCount(Timeline.INDEFINITE);
				transition6.setInterpolator(Interpolator.EASE_BOTH);
				transition6.play();

				//tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog61 = new Stage();
					dialog61.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox61 = new VBox();
					dialog61.setTitle("Steenstraat");
					Button button61 = new Button("Koop");
					dialogVBox61.getChildren().addAll(new Text("Aankoopprijs: €100.000"), new Text("Huur: €10.000"),
							new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"), button61);
					Scene dialogScene61 = new Scene(dialogVBox61, 300, 250);
					dialogVBox61.setAlignment(Pos.CENTER);
					dialogVBox61.setSpacing(10);
					dialogVBox61.setStyle("-fx-font: 20px Tahoma");
					dialog61.setScene(dialogScene61);
					dialog61.show();

					Speler finalAanZet61 = aanZet;
					button61.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet61);

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
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog63 = new Stage();
					dialog63.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox63 = new VBox();
					dialog63.setTitle("Betaal Huur");
					Button button63 = new Button("Betaal huur");
					dialogVBox63.getChildren().addAll(new Text("U dient huur te betalen. "), button63);
					Scene dialogScene63 = new Scene(dialogVBox63, 300, 250);
					dialogVBox63.setAlignment(Pos.CENTER);
					dialogVBox63.setSpacing(10);
					dialogVBox63.setStyle("-fx-font: 20px Tahoma");
					dialog63.setScene(dialogScene63);
					dialog63.show();

					Speler finalAanZet62 = aanZet;
					button63.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet62);

							final Stage dialog64 = new Stage();
							dialog64.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox64 = new VBox();
							dialog64.setTitle("Huur");
							Button button6 = new Button("OK");
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
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) { //Tegel is van de speler zelf

					final Stage dialog65 = new Stage();
					dialog65.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox65 = new VBox();
					dialog65.setTitle("Bouw");
					Button button64 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button65 = new Button("Bouw Huis");
					dialogVBox65.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button64, button65);
					Scene dialogScene65 = new Scene(dialogVBox65, 300, 250);
					dialogVBox65.setAlignment(Pos.CENTER);
					dialogVBox65.setSpacing(10);
					dialogVBox65.setStyle("-fx-font: 20px Tahoma");
					dialog65.setScene(dialogScene65);
					dialog65.show();

					//Koop Hotel
					Speler finalAanZet63 = aanZet;
					button64.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet63);

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
									dialog65.close();
									dialog66.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet64 = aanZet;
					button65.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet64);
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
									dialog65.close();
									dialog67.close();
								}
							});
						}
					});
				}


				break;

			case 7:
				TranslateTransition transition7 = new TranslateTransition();
				transition7.setNode(pion);
				transition7.setDuration(Duration.seconds(1));
				transition7.setToX(7 * 150);
				transition7.setToY(0);
				//transition7.setCycleCount(Timeline.INDEFINITE);
				transition7.setInterpolator(Interpolator.EASE_BOTH);
				transition7.play();

				final Stage dialog71 = new Stage();
				dialog71.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox71 = new VBox();
				dialog71.setTitle("Neem Kaart");
				Button button71 = new Button("Neem een kaart");
				dialogVBox71.getChildren().addAll(new Text("Neem een kaart"), button71);
				Scene dialogScene71 = new Scene(dialogVBox71, 300, 250);
				dialogVBox71.setAlignment(Pos.CENTER);
				dialogVBox71.setSpacing(10);
				dialogVBox71.setStyle("-fx-font: 20px Tahoma");
				dialog71.setScene(dialogScene71);
				dialog71.show();

				Speler finalAanZet7 = aanZet;
				button71.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog71.close();

						final Stage dialog72 = new Stage();
						dialog72.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox72 = new VBox();
						dialog72.setTitle("Opdracht");
						Button button72 = new Button("OK");
						dialogVBox72.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet7)), button72);
						Scene dialogScene72 = new Scene(dialogVBox72, 300, 250);
						dialogVBox72.setAlignment(Pos.CENTER);
						dialogVBox72.setSpacing(10);
						dialogVBox72.setStyle("-fx-font: 20px Tahoma");
						dialog72.setScene(dialogScene72);
						dialog72.show();

						button72.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet7);
								dialog71.close();
								dialog72.close();
							}
						});
					}
				});

				break;


			case 8:
				TranslateTransition transition8 = new TranslateTransition();
				transition8.setNode(pion);
				transition8.setDuration(Duration.seconds(1));
				transition8.setToX(8 * 150);
				transition8.setToY(0);
				//transition8.setCycleCount(Timeline.INDEFINITE);
				transition8.setInterpolator(Interpolator.EASE_BOTH);
				transition8.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog81 = new Stage();
					dialog81.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox81 = new VBox();
					dialog81.setTitle("Place Du Monument");
					Button button81 = new Button("koop");
					dialogVBox81.getChildren().addAll(new Text("Aankoopprijs: €100.000"), new Text("Huur: €10.000"),
							new Text("Hypotheek: €50.000"), new Text("Huisprijs: €50.000"), button81);
					Scene dialogScene8 = new Scene(dialogVBox81, 300, 250);
					dialogVBox81.setAlignment(Pos.CENTER);
					dialogVBox81.setSpacing(10);
					dialogVBox81.setStyle("-fx-font: 20px Tahoma");
					dialog81.setScene(dialogScene8);
					dialog81.show();

					Speler finalAanZet81 = aanZet;
					button81.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet81);

							final Stage dialog82 = new Stage();
							dialog82.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox82 = new VBox();
							dialog82.setTitle("Proficiat met uw aankoop!");
							Button button82 = new Button("OK");
							dialogVBox82.getChildren().addAll(new Text("U hebt Place Du Monument aangekocht"), new Text("voor €100.000"),
									button82);
							Scene dialogScene82 = new Scene(dialogVBox82, 300, 250);
							dialogVBox82.setAlignment(Pos.CENTER);
							dialogVBox82.setSpacing(10);
							dialogVBox82.setStyle("-fx-font: 20px Tahoma");
							dialog82.setScene(dialogScene82);
							dialog82.show();

							button82.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog81.close();
									dialog82.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog83 = new Stage();
					dialog83.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox83 = new VBox();
					dialog83.setTitle("Betaal Huur");
					Button button83 = new Button("Betaal Huur");
					dialogVBox83.getChildren().addAll(new Text("U dient huur te betalen. "), button83);
					Scene dialogScene83 = new Scene(dialogVBox83, 300, 250);
					dialogVBox83.setAlignment(Pos.CENTER);
					dialogVBox83.setSpacing(10);
					dialogVBox83.setStyle("-fx-font: 20px Tahoma");
					dialog83.setScene(dialogScene83);
					dialog83.show();


					Speler finalAanZet82 = aanZet;
					button83.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet82);

							final Stage dialog84 = new Stage();
							dialog84.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox84 = new VBox();
							dialog84.setTitle("Huur");
							Button button8 = new Button("OK");
							dialogVBox84.getChildren().addAll(new Text("U betaalde huur"),
									button8);
							Scene dialogScene3 = new Scene(dialogVBox84, 300, 250);
							dialogVBox84.setAlignment(Pos.CENTER);
							dialogVBox84.setSpacing(10);
							dialog84.setScene(dialogScene3);
							dialogVBox84.setStyle("-fx-font: 20px Tahoma");
							dialog84.show();

							button8.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog83.close();
									dialog84.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {// tegel is van de speler zelf

					final Stage dialog85 = new Stage();
					dialog85.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox85 = new VBox();
					dialog85.setTitle("Bouw");
					Button button84 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button85 = new Button("Bouw Huis");
					dialogVBox85.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button84, button85);
					Scene dialogScene85 = new Scene(dialogVBox85, 300, 250);
					dialogVBox85.setAlignment(Pos.CENTER);
					dialogVBox85.setSpacing(10);
					dialog85.setScene(dialogScene85);
					dialogVBox85.setStyle("-fx-font: 20px Tahoma");
					dialog85.show();


					//Koop Hotel
					Speler finalAanZet83 = aanZet;
					button84.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(),
									finalAanZet83);
							final Stage dialog86 = new Stage();
							dialog86.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox86 = new VBox();
							dialog86.setTitle("Hotel");
							Button button86 = new Button("OK");
							dialogVBox86.getChildren().addAll(new Text("U kocht een hotel"), new Text("hoeveel huizen wilt u?"),
									button86);
							Scene dialogScene86 = new Scene(dialogVBox86, 300, 250);
							dialogVBox86.setAlignment(Pos.CENTER);
							dialogVBox86.setSpacing(10);
							dialog86.setScene(dialogScene86);
							dialogVBox86.setStyle("-fx-font: 20px Tahoma");
							dialog86.show();

							button86.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog85.close();
									dialog86.close();
								}

							});
						}
					});

					//Koop huis
					Speler finalAanZet84 = aanZet;
					button85.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet84);
							final Stage dialog87 = new Stage();
							dialog87.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox87 = new VBox();
							dialog87.setTitle("Hotel");
							Button button37 = new Button("OK");
							dialogVBox87.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button37);
							Scene dialogScene87 = new Scene(dialogVBox87, 300, 250);
							dialogVBox87.setAlignment(Pos.CENTER);
							dialogVBox87.setSpacing(10);
							dialogVBox87.setStyle("-fx-font: 20px Tahoma");
							dialog87.setScene(dialogScene87);
							dialog87.show();

							button37.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog85.close();
									dialog87.close();
								}
							});
						}
					});
				}


				break;

			case 9:
				TranslateTransition transition9 = new TranslateTransition();
				transition9.setNode(pion);
				transition9.setDuration(Duration.seconds(1));
				transition9.setToX(9 * 150);
				transition9.setToY(0);
				//transition1.setCycleCount(Timeline.INDEFINITE);
				transition9.setInterpolator(Interpolator.EASE_BOTH);
				transition9.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog91 = new Stage();
					dialog91.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox91 = new VBox();
					dialog91.setTitle("Kapellestraat");
					Button button91 = new Button("Koop");
					dialogVBox91.getChildren().addAll(new Text("Aankoopprijs: €120.000"), new Text("Huur: €12.000"),
							new Text("Hypotheek: €60.000"), new Text("Huisprijs: €50.000"), button91);
					Scene dialogScene91 = new Scene(dialogVBox91, 300, 250);
					dialogVBox91.setAlignment(Pos.CENTER);
					dialogVBox91.setSpacing(10);
					dialogVBox91.setStyle("-fx-font: 20px Tahoma");
					dialog91.setScene(dialogScene91);
					dialog91.show();

					Speler finalAanZet91 = aanZet;
					button91.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet91);

							final Stage dialog92 = new Stage();
							dialog92.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox92 = new VBox();
							dialog92.setTitle("Proficiat met uw aankoop!");
							Button button92 = new Button("OK");
							dialogVBox92.getChildren().addAll(new Text("U hebt Kapellestraat aangekocht"), new Text("voor €120.000"),
									button92);
							Scene dialogScene92 = new Scene(dialogVBox92, 300, 250);
							dialogVBox92.setAlignment(Pos.CENTER);
							dialogVBox92.setSpacing(10);
							dialogVBox92.setStyle("-fx-font: 20px Tahoma");
							dialog92.setScene(dialogScene92);
							dialog92.show();

							button92.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog91.close();
									dialog92.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog93 = new Stage();
					dialog93.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox93 = new VBox();
					dialog93.setTitle("Betaal Huur");
					Button button93 = new Button("Betaal huur");
					dialogVBox93.getChildren().addAll(new Text("U dient huur te betalen. "), button93);
					Scene dialogScene93 = new Scene(dialogVBox93, 300, 250);
					dialogVBox93.setAlignment(Pos.CENTER);
					dialogVBox93.setSpacing(10);
					dialogVBox93.setStyle("-fx-font: 20px Tahoma");
					dialog93.setScene(dialogScene93);
					dialog93.show();

					Speler finalAanZet92 = aanZet;
					button93.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet92);

							final Stage dialog94 = new Stage();
							dialog94.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox94 = new VBox();
							dialog94.setTitle("Huur");
							Button button9 = new Button("OK");
							dialogVBox94.getChildren().addAll(new Text("U betaalde huur"),
									button9);
							Scene dialogScene94 = new Scene(dialogVBox94, 300, 250);
							dialogVBox94.setAlignment(Pos.CENTER);
							dialogVBox94.setSpacing(10);
							dialogVBox94.setStyle("-fx-font: 20px Tahoma");
							dialog94.setScene(dialogScene94);
							dialog94.show();

							button9.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog93.close();
									dialog94.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog95 = new Stage();
					dialog95.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox95 = new VBox();
					dialog95.setTitle("Bouw");
					Button button94 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button95 = new Button("Bouw Huis");
					dialogVBox95.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button94, button95);
					Scene dialogScene95 = new Scene(dialogVBox95, 300, 250);
					dialogVBox95.setAlignment(Pos.CENTER);
					dialogVBox95.setSpacing(10);
					dialogVBox95.setStyle("-fx-font: 20px Tahoma");
					dialog95.setScene(dialogScene95);
					dialog95.show();

					//Koop Hotel
					Speler finalAanZet93 = aanZet;
					button94.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet93);

							final Stage dialog96 = new Stage();
							dialog96.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox96 = new VBox();
							dialog96.setTitle("Hotel");
							Button button96 = new Button("OK");
							dialogVBox96.getChildren().addAll(new Text("U kocht een hotel"),
									button96);
							Scene dialogScene96 = new Scene(dialogVBox96, 300, 250);
							dialogVBox96.setAlignment(Pos.CENTER);
							dialogVBox96.setSpacing(10);
							dialogVBox96.setStyle("-fx-font: 20px Tahoma");
							dialog96.setScene(dialogScene96);
							dialog96.show();

							button96.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog95.close();
									dialog96.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet14 = aanZet;
					button95.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet14);

							final Stage dialog97 = new Stage();
							dialog97.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox97 = new VBox();
							dialog97.setTitle("Hotel");
							Button button97 = new Button("OK");
							dialogVBox97.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button97);
							Scene dialogScene97 = new Scene(dialogVBox97, 300, 250);
							dialogVBox97.setAlignment(Pos.CENTER);
							dialogVBox97.setSpacing(10);
							dialogVBox97.setStyle("-fx-font: 20px Tahoma");
							dialog97.setScene(dialogScene97);
							dialog97.show();

							button97.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog95.close();
									dialog97.close();
								}
							});
						}
					});
				}

				break;

			case 10:
				TranslateTransition transition10 = new TranslateTransition();
				transition10.setNode(pion);
				transition10.setDuration(Duration.seconds(1));
				transition10.setToX(10 * 150);
				transition10.setToY(0);
				//transition10.setCycleCount(Timeline.INDEFINITE);
				transition10.setInterpolator(Interpolator.EASE_BOTH);
				transition10.play();

				break;

			case 11:
				TranslateTransition transition11 = new TranslateTransition();
				transition11.setNode(pion);
				transition11.setDuration(Duration.seconds(1));
				transition11.setToX(10 * 150);
				transition11.setToY(90);
				//transition11.setCycleCount(Timeline.INDEFINITE);
				transition11.setInterpolator(Interpolator.EASE_BOTH);
				transition11.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog111 = new Stage();
					dialog111.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox111 = new VBox();
					dialog111.setTitle("Rue De Diekirch");
					Button button111 = new Button("Koop");
					dialogVBox111.getChildren().addAll(new Text("Aankoopprijs: €140.000"), new Text("Huur: €14.000"),
							new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"), button111);
					Scene dialogScene111 = new Scene(dialogVBox111, 300, 250);
					dialogVBox111.setAlignment(Pos.CENTER);
					dialogVBox111.setSpacing(10);
					dialogVBox111.setStyle("-fx-font: 20px Tahoma");
					dialog111.setScene(dialogScene111);
					dialog111.show();

					Speler finalAanZet111 = aanZet;
					button111.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet111);

							final Stage dialog112 = new Stage();
							dialog112.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox112 = new VBox();
							dialog112.setTitle("Proficiat met uw aankoop!");
							Button button112 = new Button("OK");
							dialogVBox112.getChildren().addAll(new Text("U hebt Rue De Diekirch aangekocht"), new Text("voor €140.000"),
									button112);
							Scene dialogScene112 = new Scene(dialogVBox112, 300, 250);
							dialogVBox112.setAlignment(Pos.CENTER);
							dialogVBox112.setSpacing(10);
							dialogVBox112.setStyle("-fx-font: 20px Tahoma");
							dialog112.setScene(dialogScene112);
							dialog112.show();

							button112.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog111.close();
									dialog112.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog113 = new Stage();
					dialog113.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox113 = new VBox();
					dialog113.setTitle("Betaal Huur");
					Button button113 = new Button("Betaal huur");
					dialogVBox113.getChildren().addAll(new Text("U dient huur te betalen. "), button113);
					Scene dialogScene113 = new Scene(dialogVBox113, 300, 250);
					dialogVBox113.setAlignment(Pos.CENTER);
					dialogVBox113.setSpacing(10);
					dialogVBox113.setStyle("-fx-font: 20px Tahoma");
					dialog113.setScene(dialogScene113);
					dialog113.show();

					Speler finalAanZet112 = aanZet;
					button113.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet112);

							final Stage dialog114 = new Stage();
							dialog114.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox114 = new VBox();
							dialog114.setTitle("Huur");
							Button button11 = new Button("OK");
							dialogVBox114.getChildren().addAll(new Text("U betaalde huur"),
									button11);
							Scene dialogScene114 = new Scene(dialogVBox114, 300, 250);
							dialogVBox114.setAlignment(Pos.CENTER);
							dialogVBox114.setSpacing(10);
							dialogVBox114.setStyle("-fx-font: 20px Tahoma");
							dialog114.setScene(dialogScene114);
							dialog114.show();

							button11.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog113.close();
									dialog114.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog115 = new Stage();
					dialog115.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox115 = new VBox();
					dialog115.setTitle("Bouw");
					Button button114 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button115 = new Button("Bouw Huis");
					dialogVBox115.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button114, button115);
					Scene dialogScene115 = new Scene(dialogVBox115, 300, 250);
					dialogVBox115.setAlignment(Pos.CENTER);
					dialogVBox115.setSpacing(10);
					dialogVBox115.setStyle("-fx-font: 20px Tahoma");
					dialog115.setScene(dialogScene115);
					dialog115.show();

					//Koop Hotel
					Speler finalAanZet113 = aanZet;
					button114.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet113);

							final Stage dialog116 = new Stage();
							dialog116.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox116 = new VBox();
							dialog116.setTitle("Hotel");
							Button button116 = new Button("OK");
							dialogVBox116.getChildren().addAll(new Text("U kocht een hotel"),
									button116);
							Scene dialogScene116 = new Scene(dialogVBox116, 300, 250);
							dialogVBox116.setAlignment(Pos.CENTER);
							dialogVBox116.setSpacing(10);
							dialogVBox116.setStyle("-fx-font: 20px Tahoma");
							dialog116.setScene(dialogScene116);
							dialog116.show();

							button116.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog115.close();
									dialog116.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet114 = aanZet;
					button115.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet114);

							final Stage dialog117 = new Stage();
							dialog117.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox117 = new VBox();
							dialog117.setTitle("Hotel");
							Button button117 = new Button("OK");
							dialogVBox117.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button117);
							Scene dialogScene117 = new Scene(dialogVBox117, 300, 250);
							dialogVBox117.setAlignment(Pos.CENTER);
							dialogVBox117.setSpacing(10);
							dialogVBox117.setStyle("-fx-font: 20px Tahoma");
							dialog117.setScene(dialogScene117);
							dialog117.show();

							button117.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog115.close();
									dialog117.close();
								}
							});
						}
					});
				}

				break;

			case 12:
				TranslateTransition transition12 = new TranslateTransition();
				transition12.setNode(pion);
				transition12.setDuration(Duration.seconds(1));
				transition12.setToX(10 * 150);
				transition12.setToY(2 * 90);
				//transition12.setCycleCount(Timeline.INDEFINITE);
				transition12.setInterpolator(Interpolator.EASE_BOTH);
				transition12.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog121 = new Stage();
					dialog121.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox121 = new VBox();
					dialog121.setTitle("Elektricciteitsmaatschappij");
					Button button121 = new Button("Koop");
					dialogVBox121.getChildren().addAll(new Text("Aankoopprijs: €150.000"), button121);
					Scene dialogScene281 = new Scene(dialogVBox121, 300, 250);
					dialogVBox121.setAlignment(Pos.CENTER);
					dialogVBox121.setSpacing(10);
					dialogVBox121.setStyle("-fx-font: 20px Tahoma");
					dialog121.setScene(dialogScene281);
					dialog121.show();

					Speler finalAanZet281 = aanZet;
					button121.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet281);

							final Stage dialog122 = new Stage();
							dialog122.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox122 = new VBox();
							dialog122.setTitle("Proficiat met uw aankoop!");
							Button button122 = new Button("OK");
							dialogVBox122.getChildren().addAll(new Text("U hebt de elektriciteitsmaatschappij aangekocht aangekocht"), new Text("voor €150.000"),
									button122);
							Scene dialogScene282 = new Scene(dialogVBox122, 300, 250);
							dialogVBox122.setAlignment(Pos.CENTER);
							dialogVBox122.setSpacing(10);
							dialogVBox122.setStyle("-fx-font: 20px Tahoma");
							dialog122.setScene(dialogScene282);
							dialog122.show();

							button122.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog122.close();
									dialog121.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog123 = new Stage();
					dialog123.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox123 = new VBox();
					dialog123.setTitle("Betaal Huur");
					Button button123 = new Button("Betaal huur");
					dialogVBox123.getChildren().addAll(new Text("U dient huur te betalen. "), button123);
					Scene dialogScene123 = new Scene(dialogVBox123, 300, 250);
					dialogVBox123.setAlignment(Pos.CENTER);
					dialogVBox123.setSpacing(10);
					dialogVBox123.setStyle("-fx-font: 20px Tahoma");
					dialog123.setScene(dialogScene123);
					dialog123.show();

					Speler finalAanZet122 = aanZet;
					button123.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet122);

							final Stage dialog124 = new Stage();
							dialog124.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox124 = new VBox();
							dialog124.setTitle("Huur");
							Button button12 = new Button("OK");
							dialogVBox124.getChildren().addAll(new Text("U gooide: " + Dice.getWorp1()), new Text("U betaalde huur"),
									button12);
							Scene dialogScene284 = new Scene(dialogVBox124, 300, 250);
							dialogVBox124.setAlignment(Pos.CENTER);
							dialogVBox124.setSpacing(10);
							dialogVBox124.setStyle("-fx-font: 20px Tahoma");
							dialog124.setScene(dialogScene284);
							dialog124.show();

							button12.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog123.close();
									dialog124.close();
								}
							});
						}
					});
				}
				break;


			case 13:
				TranslateTransition transition13 = new TranslateTransition();
				transition13.setNode(pion);
				transition13.setDuration(Duration.seconds(1));
				transition13.setToX(10 * 150);
				transition13.setToY(3 * 90);
				//transition13.setCycleCount(Timeline.INDEFINITE);
				transition13.setInterpolator(Interpolator.EASE_BOTH);
				transition13.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog131 = new Stage();
					dialog131.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox131 = new VBox();
					dialog131.setTitle("Bruul");
					Button button131 = new Button("koop");
					dialogVBox131.getChildren().addAll(new Text("Aankoopprijs: €140.000"), new Text("Huur: €14.000"),
							new Text("Hypotheek: €70.000"), new Text("Huisprijs: €100.000"), button131);
					Scene dialogScene131 = new Scene(dialogVBox131, 300, 250);
					dialogVBox131.setAlignment(Pos.CENTER);
					dialogVBox131.setSpacing(10);
					dialogVBox131.setStyle("-fx-font: 20px Tahoma");
					dialog131.setScene(dialogScene131);
					dialog131.show();

					Speler finalAanZet131 = aanZet;
					button131.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet131);

							final Stage dialog132 = new Stage();
							dialog132.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox132 = new VBox();
							dialog132.setTitle("Proficiat met uw aankoop!");
							Button button132 = new Button("OK");
							dialogVBox132.getChildren().addAll(new Text("U hebt Bruul aangekocht"), new Text("voor €140.000"),
									button132);
							Scene dialogScene132 = new Scene(dialogVBox132, 300, 250);
							dialogVBox132.setAlignment(Pos.CENTER);
							dialogVBox132.setSpacing(10);
							dialogVBox132.setStyle("-fx-font: 20px Tahoma");
							dialog132.setScene(dialogScene132);
							dialog132.show();

							button132.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog131.close();
									dialog132.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog133 = new Stage();
					dialog133.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox133 = new VBox();
					dialog133.setTitle("Betaal Huur");
					Button button133 = new Button("Betaal huur");
					dialogVBox133.getChildren().addAll(new Text("U dient huur te betalen. "), button133);
					Scene dialogScene133 = new Scene(dialogVBox133, 300, 250);
					dialogVBox133.setAlignment(Pos.CENTER);
					dialogVBox133.setSpacing(10);
					dialogVBox133.setStyle("-fx-font: 20px Tahoma");
					dialog133.setScene(dialogScene133);
					dialog133.show();

					Speler finalAanZet132 = aanZet;
					button133.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet132);

							final Stage dialog134 = new Stage();
							dialog134.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox134 = new VBox();
							dialog134.setTitle("Huur");
							Button button13 = new Button("OK");
							dialogVBox134.getChildren().addAll(new Text("U betaalde huur"),
									button13);
							Scene dialogScene134 = new Scene(dialogVBox134, 300, 250);
							dialogVBox134.setAlignment(Pos.CENTER);
							dialogVBox134.setSpacing(10);
							dialogVBox134.setStyle("-fx-font: 20px Tahoma");
							dialog134.setScene(dialogScene134);
							dialog134.show();

							button13.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog133.close();
									dialog134.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog135 = new Stage();
					dialog135.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox135 = new VBox();
					dialog135.setTitle("Bouw");
					Button button134 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button135 = new Button("Bouw Huis");
					dialogVBox135.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button134, button135);
					Scene dialogScene135 = new Scene(dialogVBox135, 300, 250);
					dialogVBox135.setAlignment(Pos.CENTER);
					dialogVBox135.setSpacing(10);
					dialogVBox135.setStyle("-fx-font: 20px Tahoma");
					dialog135.setScene(dialogScene135);
					dialog135.show();

					//Koop Hotel
					Speler finalAanZet133 = aanZet;
					button134.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet133);

							final Stage dialog136 = new Stage();
							dialog136.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox136 = new VBox();
							dialog136.setTitle("Hotel");
							Button button136 = new Button("OK");
							dialogVBox136.getChildren().addAll(new Text("U kocht een hotel"),
									button136);
							Scene dialogScene136 = new Scene(dialogVBox136, 300, 250);
							dialogVBox136.setAlignment(Pos.CENTER);
							dialogVBox136.setSpacing(10);
							dialogVBox136.setStyle("-fx-font: 20px Tahoma");
							dialog136.setScene(dialogScene136);
							dialog136.show();

							button136.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog135.close();
									dialog136.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet134 = aanZet;
					button135.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet134);

							final Stage dialog137 = new Stage();
							dialog137.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox137 = new VBox();
							dialog137.setTitle("Hotel");
							Button button137 = new Button("OK");
							dialogVBox137.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button137);
							Scene dialogScene137 = new Scene(dialogVBox137, 300, 250);
							dialogVBox137.setAlignment(Pos.CENTER);
							dialogVBox137.setSpacing(10);
							dialogVBox137.setStyle("-fx-font: 20px Tahoma");
							dialog137.setScene(dialogScene137);
							dialog137.show();

							button137.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog135.close();
									dialog137.close();
								}
							});
						}
					});
				}


				break;

			case 14:
				TranslateTransition transition14 = new TranslateTransition();
				transition14.setNode(pion);
				transition14.setDuration(Duration.seconds(1));
				transition14.setToX(10 * 150);
				transition14.setToY(4 * 90);
				//transition14.setCycleCount(Timeline.INDEFINITE);
				transition14.setInterpolator(Interpolator.EASE_BOTH);
				transition14.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog141 = new Stage();
					dialog141.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox141 = new VBox();
					dialog141.setTitle("Place Verte");
					Button button141 = new Button("koop");
					dialogVBox141.getChildren().addAll(new Text("Aankoopprijs: €160.000"), new Text("Huur: €16.000"),
							new Text("Hypotheek: €80.000"), new Text("Huisprijs: €100.000"), button141);
					Scene dialogScene141 = new Scene(dialogVBox141, 300, 250);
					dialogVBox141.setAlignment(Pos.CENTER);
					dialogVBox141.setSpacing(10);
					dialogVBox141.setStyle("-fx-font: 20px Tahoma");
					dialog141.setScene(dialogScene141);
					dialog141.show();

					Speler finalAanZet141 = aanZet;
					button141.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet141);

							final Stage dialog142 = new Stage();
							dialog142.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox142 = new VBox();
							dialog142.setTitle("Proficiat met uw aankoop!");
							Button button142 = new Button("OK");
							dialogVBox142.getChildren().addAll(new Text("U hebt Place Verte aangekocht"), new Text("voor €160.000"),
									button142);
							Scene dialogScene142 = new Scene(dialogVBox142, 300, 250);
							dialogVBox142.setAlignment(Pos.CENTER);
							dialogVBox142.setSpacing(10);
							dialogVBox142.setStyle("-fx-font: 20px Tahoma");
							dialog142.setScene(dialogScene142);
							dialog142.show();

							button142.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog141.close();
									dialog142.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog143 = new Stage();
					dialog143.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox143 = new VBox();
					dialog143.setTitle("Betaal Huur");
					Button button143 = new Button("Betaal huur");
					dialogVBox143.getChildren().addAll(new Text("U dient huur te betalen. "), button143);
					Scene dialogScene143 = new Scene(dialogVBox143, 300, 250);
					dialogVBox143.setAlignment(Pos.CENTER);
					dialogVBox143.setSpacing(10);
					dialogVBox143.setStyle("-fx-font: 20px Tahoma");
					dialog143.setScene(dialogScene143);
					dialog143.show();

					Speler finalAanZet142 = aanZet;
					button143.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet142);

							final Stage dialog144 = new Stage();
							dialog144.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox144 = new VBox();
							dialog144.setTitle("Huur");
							Button button14 = new Button("OK");
							dialogVBox144.getChildren().addAll(new Text("U betaalde huur"),
									button14);
							Scene dialogScene144 = new Scene(dialogVBox144, 300, 250);
							dialogVBox144.setAlignment(Pos.CENTER);
							dialogVBox144.setSpacing(10);
							dialogVBox144.setStyle("-fx-font: 20px Tahoma");
							dialog144.setScene(dialogScene144);
							dialog144.show();

							button14.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog143.close();
									dialog144.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog145 = new Stage();
					dialog145.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox145 = new VBox();
					dialog145.setTitle("Bouw");
					Button button144 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button145 = new Button("Bouw Huis");
					dialogVBox145.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button144, button145);
					Scene dialogScene145 = new Scene(dialogVBox145, 300, 250);
					dialogVBox145.setAlignment(Pos.CENTER);
					dialogVBox145.setSpacing(10);
					dialogVBox145.setStyle("-fx-font: 20px Tahoma");
					dialog145.setScene(dialogScene145);
					dialog145.show();

					//Koop Hotel
					Speler finalAanZet143 = aanZet;
					button144.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet143);

							final Stage dialog146 = new Stage();
							dialog146.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox146 = new VBox();
							dialog146.setTitle("Hotel");
							Button button146 = new Button("OK");
							dialogVBox146.getChildren().addAll(new Text("U kocht een hotel"),
									button146);
							Scene dialogScene146 = new Scene(dialogVBox146, 300, 250);
							dialogVBox146.setAlignment(Pos.CENTER);
							dialogVBox146.setSpacing(10);
							dialogVBox146.setStyle("-fx-font: 20px Tahoma");
							dialog146.setScene(dialogScene146);
							dialog146.show();

							button146.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog145.close();
									dialog146.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet144 = aanZet;
					button145.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet144);

							final Stage dialog147 = new Stage();
							dialog147.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox147 = new VBox();
							dialog147.setTitle("Hotel");
							Button button147 = new Button("OK");
							dialogVBox147.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button147);
							Scene dialogScene147 = new Scene(dialogVBox147, 300, 250);
							dialogVBox147.setAlignment(Pos.CENTER);
							dialogVBox147.setSpacing(10);
							dialogVBox147.setStyle("-fx-font: 20px Tahoma");
							dialog147.setScene(dialogScene147);
							dialog147.show();

							button147.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog145.close();
									dialog147.close();
								}
							});
						}
					});
				}

				break;

			case 15:
				TranslateTransition transition15 = new TranslateTransition();
				transition15.setNode(pion);
				transition15.setDuration(Duration.seconds(1));
				transition15.setToX(10 * 150);
				transition15.setToY(5 * 90);
				//transition15.setCycleCount(Timeline.INDEFINITE);
				transition15.setInterpolator(Interpolator.EASE_BOTH);
				transition15.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog151 = new Stage();
					dialog151.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox151 = new VBox();
					dialog151.setTitle("Centraal Station");
					Button button151 = new Button("Koop");
					dialogVBox151.getChildren().addAll(new Text("Aankoopprijs: €200.000"), button151);
					Scene dialogScene151 = new Scene(dialogVBox151, 300, 250);
					dialogVBox151.setAlignment(Pos.CENTER);
					dialogVBox151.setSpacing(10);
					dialogVBox151.setStyle("-fx-font: 20px Tahoma");
					dialog151.setScene(dialogScene151);
					dialog151.show();

					Speler finalAanZet151 = aanZet;
					button151.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet151);

							final Stage dialog152 = new Stage();
							dialog152.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox152 = new VBox();
							dialog152.setTitle("Proficiat met uw aankoop!");
							Button button152 = new Button("OK");
							dialogVBox152.getChildren().addAll(new Text("U hebt Centraal Station aangekocht"), new Text("voor €200.000"),
									button152);
							Scene dialogScene152 = new Scene(dialogVBox152, 300, 250);
							dialogVBox152.setAlignment(Pos.CENTER);
							dialogVBox152.setSpacing(10);
							dialogVBox152.setStyle("-fx-font: 20px Tahoma");
							dialog152.setScene(dialogScene152);
							dialog152.show();

							button152.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog152.close();
									dialog151.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog153 = new Stage();
					dialog153.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox153 = new VBox();
					dialog153.setTitle("Betaal Huur");
					Button button153 = new Button("Betaal huur");
					dialogVBox153.getChildren().addAll(new Text("U dient huur te betalen. "), button153);
					Scene dialogScene153 = new Scene(dialogVBox153, 300, 250);
					dialogVBox153.setAlignment(Pos.CENTER);
					dialogVBox153.setSpacing(10);
					dialogVBox153.setStyle("-fx-font: 20px Tahoma");
					dialog153.setScene(dialogScene153);
					dialog153.show();

					Speler finalAanZet152 = aanZet;
					button153.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet152);

							final Stage dialog154 = new Stage();
							dialog154.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox154 = new VBox();
							dialog154.setTitle("Huur");
							Button button15 = new Button("OK");
							dialogVBox154.getChildren().addAll(new Text("U betaalde huur"),
									button15);
							Scene dialogScene64 = new Scene(dialogVBox154, 300, 250);
							dialogVBox154.setAlignment(Pos.CENTER);
							dialogVBox154.setSpacing(10);
							dialogVBox154.setStyle("-fx-font: 20px Tahoma");
							dialog154.setScene(dialogScene64);
							dialog154.show();

							button15.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog153.close();
									dialog154.close();
								}
							});
						}
					});
				}

				break;

			case 16:
				TranslateTransition transition16 = new TranslateTransition();
				transition16.setNode(pion);
				transition16.setDuration(Duration.seconds(1));
				transition16.setToX(10 * 150);
				transition16.setToY(6 * 90);
				//transition16.setCycleCount(Timeline.INDEFINITE);
				transition16.setInterpolator(Interpolator.EASE_BOTH);
				transition16.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog161 = new Stage();
					dialog161.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox161 = new VBox();
					dialog161.setTitle("Lippenslaan");
					Button button161 = new Button("koop");
					dialogVBox161.getChildren().addAll(new Text("Aankoopprijs: €180.000"), new Text("Huur: €18.000"),
							new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"), button161);
					Scene dialogScene161 = new Scene(dialogVBox161, 300, 250);
					dialogVBox161.setAlignment(Pos.CENTER);
					dialogVBox161.setSpacing(10);
					dialogVBox161.setStyle("-fx-font: 20px Tahoma");
					dialog161.setScene(dialogScene161);
					dialog161.show();

					Speler finalAanZet161 = aanZet;
					button161.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet161);

							final Stage dialog162 = new Stage();
							dialog162.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox162 = new VBox();
							dialog162.setTitle("Proficiat met uw aankoop!");
							Button button162 = new Button("OK");
							dialogVBox162.getChildren().addAll(new Text("U hebt Lippenslaan aangekocht"), new Text("voor €180.000"),
									button162);
							Scene dialogScene162 = new Scene(dialogVBox162, 300, 250);
							dialogVBox162.setAlignment(Pos.CENTER);
							dialogVBox162.setSpacing(10);
							dialogVBox162.setStyle("-fx-font: 20px Tahoma");
							dialog162.setScene(dialogScene162);
							dialog162.show();

							button162.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog161.close();
									dialog162.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog163 = new Stage();
					dialog163.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox163 = new VBox();
					dialog163.setTitle("Betaal Huur");
					Button button163 = new Button("Betaal huur");
					dialogVBox163.getChildren().addAll(new Text("U dient huur te betalen. "), button163);
					Scene dialogScene163 = new Scene(dialogVBox163, 300, 250);
					dialogVBox163.setAlignment(Pos.CENTER);
					dialogVBox163.setSpacing(10);
					dialogVBox163.setStyle("-fx-font: 20px Tahoma");
					dialog163.setScene(dialogScene163);
					dialog163.show();

					Speler finalAanZet162 = aanZet;
					button163.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet162);

							final Stage dialog164 = new Stage();
							dialog164.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox164 = new VBox();
							dialog164.setTitle("Huur");
							Button button16 = new Button("OK");
							dialogVBox164.getChildren().addAll(new Text("U betaalde huur"),
									button16);
							Scene dialogScene164 = new Scene(dialogVBox164, 300, 250);
							dialogVBox164.setAlignment(Pos.CENTER);
							dialogVBox164.setSpacing(10);
							dialogVBox164.setStyle("-fx-font: 20px Tahoma");
							dialog164.setScene(dialogScene164);
							dialog164.show();

							button16.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog163.close();
									dialog164.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog165 = new Stage();
					dialog165.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox165 = new VBox();
					dialog165.setTitle("Bouw");
					Button button164 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button165 = new Button("Bouw Huis");
					dialogVBox165.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button164, button165);
					Scene dialogScene165 = new Scene(dialogVBox165, 300, 250);
					dialogVBox165.setAlignment(Pos.CENTER);
					dialogVBox165.setSpacing(10);
					dialogVBox165.setStyle("-fx-font: 20px Tahoma");
					dialog165.setScene(dialogScene165);
					dialog165.show();

					//Koop Hotel
					Speler finalAanZet163 = aanZet;
					button164.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet163);

							final Stage dialog166 = new Stage();
							dialog166.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox166 = new VBox();
							dialog166.setTitle("Hotel");
							Button button166 = new Button("OK");
							dialogVBox166.getChildren().addAll(new Text("U kocht een hotel"),
									button166);
							Scene dialogScene166 = new Scene(dialogVBox166, 300, 250);
							dialogVBox166.setAlignment(Pos.CENTER);
							dialogVBox166.setSpacing(10);
							dialogVBox166.setStyle("-fx-font: 20px Tahoma");
							dialog166.setScene(dialogScene166);
							dialog166.show();

							button166.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog165.close();
									dialog166.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet164 = aanZet;
					button165.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet164);

							final Stage dialog167 = new Stage();
							dialog167.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox167 = new VBox();
							dialog167.setTitle("Hotel");
							Button button167 = new Button("OK");
							dialogVBox167.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button167);
							Scene dialogScene167 = new Scene(dialogVBox167, 300, 250);
							dialogVBox167.setAlignment(Pos.CENTER);
							dialogVBox167.setSpacing(10);
							dialogVBox167.setStyle("-fx-font: 20px Tahoma");
							dialog167.setScene(dialogScene167);
							dialog167.show();

							button167.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog165.close();
									dialog167.close();
								}
							});
						}
					});
				}

				break;

			case 17:
				TranslateTransition transition17 = new TranslateTransition();
				transition17.setNode(pion);
				transition17.setDuration(Duration.seconds(1));
				transition17.setToX(10 * 150);
				transition17.setToY(7 * 90);
				//transition17.setCycleCount(Timeline.INDEFINITE);
				transition17.setInterpolator(Interpolator.EASE_BOTH);
				transition17.play();

				final Stage dialog171 = new Stage();
				dialog171.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox171 = new VBox();
				dialog171.setTitle("Neem Kaart");
				Button button171 = new Button("Neem een kaart");
				dialogVBox171.getChildren().addAll(new Text("Neem een kaart"), button171);
				Scene dialogScene171 = new Scene(dialogVBox171, 300, 250);
				dialogVBox171.setAlignment(Pos.CENTER);
				dialogVBox171.setSpacing(10);
				dialogVBox171.setStyle("-fx-font: 20px Tahoma");
				dialog171.setScene(dialogScene171);
				dialog171.show();

				Speler finalAanZet17 = aanZet;
				button171.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog171.close();

						final Stage dialog172 = new Stage();
						dialog172.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox172 = new VBox();
						dialog172.setTitle("Opdracht");
						Button button172 = new Button("OK");
						dialogVBox172.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet17)), button172);
						Scene dialogScene172 = new Scene(dialogVBox172, 300, 250);
						dialogVBox172.setAlignment(Pos.CENTER);
						dialogVBox172.setSpacing(10);
						dialogVBox172.setStyle("-fx-font: 20px Tahoma");
						dialog172.setScene(dialogScene172);
						dialog172.show();

						button172.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet17);
								dialog171.close();
								dialog172.close();
							}
						});
					}
				});
				break;

			case 18:
				TranslateTransition transition18 = new TranslateTransition();
				transition18.setNode(pion);
				transition18.setDuration(Duration.seconds(1));
				transition18.setToX(10 * 150);
				transition18.setToY(8 * 90);
				//transition18.setCycleCount(Timeline.INDEFINITE);
				transition18.setInterpolator(Interpolator.EASE_BOTH);
				transition18.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog181 = new Stage();
					dialog181.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox181 = new VBox();
					dialog181.setTitle("Rue Royal");
					Button button181 = new Button("koop");
					dialogVBox181.getChildren().addAll(new Text("Aankoopprijs: €180.000"), new Text("Huur: €18.000"),
							new Text("Hypotheek: €90.000"), new Text("Huisprijs: €100.000"), button181);
					Scene dialogScene181 = new Scene(dialogVBox181, 300, 250);
					dialogVBox181.setAlignment(Pos.CENTER);
					dialogVBox181.setSpacing(10);
					dialogVBox181.setStyle("-fx-font: 20px Tahoma");
					dialog181.setScene(dialogScene181);
					dialog181.show();

					Speler finalAanZet181 = aanZet;
					button181.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet181);

							final Stage dialog182 = new Stage();
							dialog182.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox182 = new VBox();
							dialog182.setTitle("Proficiat met uw aankoop!");
							Button button182 = new Button("OK");
							dialogVBox182.getChildren().addAll(new Text("U hebt Rue Royal aangekocht"), new Text("voor €180.000"),
									button182);
							Scene dialogScene182 = new Scene(dialogVBox182, 300, 250);
							dialogVBox182.setAlignment(Pos.CENTER);
							dialogVBox182.setSpacing(10);
							dialogVBox182.setStyle("-fx-font: 20px Tahoma");
							dialog182.setScene(dialogScene182);
							dialog182.show();

							button182.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog181.close();
									dialog182.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog183 = new Stage();
					dialog183.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox183 = new VBox();
					dialog183.setTitle("Betaal Huur");
					Button button183 = new Button("Betaal huur");
					dialogVBox183.getChildren().addAll(new Text("U dient huur te betalen. "), button183);
					Scene dialogScene183 = new Scene(dialogVBox183, 300, 250);
					dialogVBox183.setAlignment(Pos.CENTER);
					dialogVBox183.setSpacing(10);
					dialogVBox183.setStyle("-fx-font: 20px Tahoma");
					dialog183.setScene(dialogScene183);
					dialog183.show();

					Speler finalAanZet182 = aanZet;
					button183.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet182);

							final Stage dialog184 = new Stage();
							dialog184.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox184 = new VBox();
							dialog184.setTitle("Huur");
							Button button18 = new Button("OK");
							dialogVBox184.getChildren().addAll(new Text("U betaalde huur"),
									button18);
							Scene dialogScene184 = new Scene(dialogVBox184, 300, 250);
							dialogVBox184.setAlignment(Pos.CENTER);
							dialogVBox184.setSpacing(10);
							dialogVBox184.setStyle("-fx-font: 20px Tahoma");
							dialog184.setScene(dialogScene184);
							dialog184.show();

							button18.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog183.close();
									dialog184.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog185 = new Stage();
					dialog185.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox185 = new VBox();
					dialog185.setTitle("Bouw");
					Button button184 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button185 = new Button("Bouw Huis");
					dialogVBox185.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button184, button185);
					Scene dialogScene185 = new Scene(dialogVBox185, 300, 250);
					dialogVBox185.setAlignment(Pos.CENTER);
					dialogVBox185.setSpacing(10);
					dialogVBox185.setStyle("-fx-font: 20px Tahoma");
					dialog185.setScene(dialogScene185);
					dialog185.show();

					//Koop Hotel
					Speler finalAanZet183 = aanZet;
					button184.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet183);

							final Stage dialog186 = new Stage();
							dialog186.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox186 = new VBox();
							dialog186.setTitle("Hotel");
							Button button186 = new Button("OK");
							dialogVBox186.getChildren().addAll(new Text("U kocht een hotel"),
									button186);
							Scene dialogScene186 = new Scene(dialogVBox186, 300, 250);
							dialogVBox186.setAlignment(Pos.CENTER);
							dialogVBox186.setSpacing(10);
							dialogVBox186.setStyle("-fx-font: 20px Tahoma");
							dialog186.setScene(dialogScene186);
							dialog186.show();

							button186.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog185.close();
									dialog186.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet184 = aanZet;
					button185.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet184);

							final Stage dialog187 = new Stage();
							dialog187.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox187 = new VBox();
							dialog187.setTitle("Hotel");
							Button button187 = new Button("OK");
							dialogVBox187.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button187);
							Scene dialogScene187 = new Scene(dialogVBox187, 300, 250);
							dialogVBox187.setAlignment(Pos.CENTER);
							dialogVBox187.setSpacing(10);
							dialogVBox187.setStyle("-fx-font: 20px Tahoma");
							dialog187.setScene(dialogScene187);
							dialog187.show();

							button187.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog185.close();
									dialog187.close();
								}
							});
						}
					});
				}


				break;

			case 19:
				TranslateTransition transition19 = new TranslateTransition();
				transition19.setNode(pion);
				transition19.setDuration(Duration.seconds(1));
				transition19.setToX(10 * 150);
				transition19.setToY(9 * 90);
				//transition19.setCycleCount(Timeline.INDEFINITE);
				transition19.setInterpolator(Interpolator.EASE_BOTH);
				transition19.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog191 = new Stage();
					dialog191.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox191 = new VBox();
					dialog191.setTitle("Groenplaats");
					Button button191 = new Button("koop");
					dialogVBox191.getChildren().addAll(new Text("Aankoopprijs: €200.000"), new Text("Huur: €20.000"),
							new Text("Hypotheek: €100.000"), new Text("Huisprijs: €100.000"), button191);
					Scene dialogScene191 = new Scene(dialogVBox191, 300, 250);
					dialogVBox191.setAlignment(Pos.CENTER);
					dialogVBox191.setSpacing(10);
					dialogVBox191.setStyle("-fx-font: 20px Tahoma");
					dialog191.setScene(dialogScene191);
					dialog191.show();

					Speler finalAanZet191 = aanZet;
					button191.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet191);

							final Stage dialog192 = new Stage();
							dialog192.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox192 = new VBox();
							dialog192.setTitle("Proficiat met uw aankoop!");
							Button button192 = new Button("OK");
							dialogVBox192.getChildren().addAll(new Text("U hebt Groenplaats aangekocht"), new Text("voor €200.000"),
									button192);
							Scene dialogScene192 = new Scene(dialogVBox192, 300, 250);
							dialogVBox192.setAlignment(Pos.CENTER);
							dialogVBox192.setSpacing(10);
							dialogVBox192.setStyle("-fx-font: 20px Tahoma");
							dialog192.setScene(dialogScene192);
							dialog192.show();

							button192.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog191.close();
									dialog192.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog193 = new Stage();
					dialog193.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox193 = new VBox();
					dialog193.setTitle("Betaal Huur");
					Button button193 = new Button("Betaal huur");
					dialogVBox193.getChildren().addAll(new Text("U dient huur te betalen. "), button193);
					Scene dialogScene193 = new Scene(dialogVBox193, 300, 250);
					dialogVBox193.setAlignment(Pos.CENTER);
					dialogVBox193.setSpacing(10);
					dialogVBox193.setStyle("-fx-font: 20px Tahoma");
					dialog193.setScene(dialogScene193);
					dialog193.show();

					Speler finalAanZet192 = aanZet;
					button193.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet192);

							final Stage dialog194 = new Stage();
							dialog194.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox194 = new VBox();
							dialog194.setTitle("Huur");
							Button button19 = new Button("OK");
							dialogVBox194.getChildren().addAll(new Text("U betaalde huur"),
									button19);
							Scene dialogScene194 = new Scene(dialogVBox194, 300, 250);
							dialogVBox194.setAlignment(Pos.CENTER);
							dialogVBox194.setSpacing(10);
							dialogVBox194.setStyle("-fx-font: 20px Tahoma");
							dialog194.setScene(dialogScene194);
							dialog194.show();

							button19.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog193.close();
									dialog194.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog195 = new Stage();
					dialog195.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox195 = new VBox();
					dialog195.setTitle("Bouw");
					Button button194 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button195 = new Button("Bouw Huis");
					dialogVBox195.getChildren().addAll(new Text("Huisprijs: €100.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button194, button195);
					Scene dialogScene195 = new Scene(dialogVBox195, 300, 250);
					dialogVBox195.setAlignment(Pos.CENTER);
					dialogVBox195.setSpacing(10);
					dialogVBox195.setStyle("-fx-font: 20px Tahoma");
					dialog195.setScene(dialogScene195);
					dialog195.show();

					//Koop Hotel
					Speler finalAanZet193 = aanZet;
					button194.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet193);

							final Stage dialog196 = new Stage();
							dialog196.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox196 = new VBox();
							dialog196.setTitle("Hotel");
							Button button196 = new Button("OK");
							dialogVBox196.getChildren().addAll(new Text("U kocht een hotel"),
									button196);
							Scene dialogScene196 = new Scene(dialogVBox196, 300, 250);
							dialogVBox196.setAlignment(Pos.CENTER);
							dialogVBox196.setSpacing(10);
							dialogVBox196.setStyle("-fx-font: 20px Tahoma");
							dialog196.setScene(dialogScene196);
							dialog196.show();

							button196.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog195.close();
									dialog196.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet194 = aanZet;
					button195.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet194);

							final Stage dialog197 = new Stage();
							dialog197.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox197 = new VBox();
							dialog197.setTitle("Hotel");
							Button button197 = new Button("OK");
							dialogVBox197.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button197);
							Scene dialogScene197 = new Scene(dialogVBox197, 300, 250);
							dialogVBox197.setAlignment(Pos.CENTER);
							dialogVBox197.setSpacing(10);
							dialogVBox197.setStyle("-fx-font: 20px Tahoma");
							dialog197.setScene(dialogScene197);
							dialog197.show();

							button197.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog195.close();
									dialog197.close();
								}
							});
						}
					});
				}

				break;

			case 20:
				TranslateTransition transition20 = new TranslateTransition();
				transition20.setNode(pion);
				transition20.setDuration(Duration.seconds(1));
				transition20.setToX(10 * 150);
				transition20.setToY(10 * 90);
				//transition20.setCycleCount(Timeline.INDEFINITE);
				transition20.setInterpolator(Interpolator.EASE_BOTH);
				transition20.play();

				final Stage dialog20 = new Stage();
				dialog20.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox20 = new VBox();
				dialog20.setTitle("Antimonopoly-stichting");

				AntiMonopolyStichting.voerUit(aanZet);

				String soortSpeler, tekst;

				if (aanZet.getIsConcurrent()) {
					soortSpeler = "Concurrent";
					tekst = "\nen ontvangt: €" + AntiMonopolyStichting.getRol();
				} else {
					soortSpeler = "Monopolist";
					tekst = "\nen moet €160.000 betalen";
				}
				Button button20 = new Button("OK");

				dialogVBox20.getChildren().addAll(new Text("Antimonopoly-stichting"), new Text("U bent een " + soortSpeler + tekst),button20);
				Scene dialogScene20 = new Scene(dialogVBox20, 300, 250);
				dialogVBox20.setAlignment(Pos.CENTER);
				dialogVBox20.setSpacing(10);
				dialogVBox20.setStyle("-fx-font: 20px Tahoma");
				dialog20.setScene(dialogScene20);
				dialog20.show();

				button20.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog20.close();
					}
				});
				break;


			case 21:
				TranslateTransition transition21 = new TranslateTransition();
				transition21.setNode(pion);
				transition21.setDuration(Duration.seconds(1));
				transition21.setToX(9 * 150);
				transition21.setToY(10 * 90);
				//transition21.setCycleCount(Timeline.INDEFINITE);
				transition21.setInterpolator(Interpolator.EASE_BOTH);
				transition21.play();

				final Stage dialog211 = new Stage();
				dialog211.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox211 = new VBox();
				dialog211.setTitle("Rue Saint Leonard");
				Button button211 = new Button("koop");
				dialogVBox211.getChildren().addAll(new Text("Aankoopprijs: €220.000"), new Text("Huur: €22.000"),
						new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"), button211);
				Scene dialogScene211 = new Scene(dialogVBox211, 300, 250);
				dialogVBox211.setAlignment(Pos.CENTER);
				dialogVBox211.setSpacing(10);
				dialogVBox211.setStyle("-fx-font: 20px Tahoma");
				dialog211.setScene(dialogScene211);
				dialog211.show();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Speler finalAanZet211 = aanZet;
					button211.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet211);

							final Stage dialog212 = new Stage();
							dialog212.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox212 = new VBox();
							dialog212.setTitle("Proficiat met uw aankoop!");
							Button button212 = new Button("OK");
							dialogVBox212.getChildren().addAll(new Text("Rue Saint Leonard"), new Text("voor €220.000"),
									button212);
							Scene dialogScene212 = new Scene(dialogVBox212, 300, 250);
							dialogVBox212.setAlignment(Pos.CENTER);
							dialogVBox212.setSpacing(10);
							dialogVBox212.setStyle("-fx-font: 20px Tahoma");
							dialog212.setScene(dialogScene212);
							dialog212.show();

							button212.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog211.close();
									dialog212.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog213 = new Stage();
					dialog213.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox213 = new VBox();
					dialog213.setTitle("Betaal Huur");
					Button button213 = new Button("Betaal huur");
					dialogVBox213.getChildren().addAll(new Text("U dient huur te betalen. "), button213);
					Scene dialogScene213 = new Scene(dialogVBox213, 300, 250);
					dialogVBox213.setAlignment(Pos.CENTER);
					dialogVBox213.setSpacing(10);
					dialogVBox213.setStyle("-fx-font: 20px Tahoma");
					dialog213.setScene(dialogScene213);
					dialog213.show();

					Speler finalAanZet212 = aanZet;
					button213.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet212);

							final Stage dialog214 = new Stage();
							dialog214.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox214 = new VBox();
							dialog214.setTitle("Huur");
							Button button21 = new Button("OK");
							dialogVBox214.getChildren().addAll(new Text("U betaalde huur"),
									button21);
							Scene dialogScene214 = new Scene(dialogVBox214, 300, 250);
							dialogVBox214.setAlignment(Pos.CENTER);
							dialogVBox214.setSpacing(10);
							dialogVBox214.setStyle("-fx-font: 20px Tahoma");
							dialog214.setScene(dialogScene214);
							dialog214.show();

							button21.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog213.close();
									dialog214.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog215 = new Stage();
					dialog215.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox215 = new VBox();
					dialog215.setTitle("Bouw");
					Button button214 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button215 = new Button("Bouw Huis");
					dialogVBox215.getChildren().addAll(new Text("Huisprijs: €150.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button214, button215);
					Scene dialogScene215 = new Scene(dialogVBox215, 300, 250);
					dialogVBox215.setAlignment(Pos.CENTER);
					dialogVBox215.setSpacing(10);
					dialogVBox215.setStyle("-fx-font: 20px Tahoma");
					dialog215.setScene(dialogScene215);
					dialog215.show();

					//Koop Hotel
					Speler finalAanZet213 = aanZet;
					button214.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet213);

							final Stage dialog216 = new Stage();
							dialog216.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox216 = new VBox();
							dialog216.setTitle("Hotel");
							Button button216 = new Button("OK");
							dialogVBox216.getChildren().addAll(new Text("U kocht een hotel"),
									button216);
							Scene dialogScene216 = new Scene(dialogVBox216, 300, 250);
							dialogVBox216.setAlignment(Pos.CENTER);
							dialogVBox216.setSpacing(10);
							dialogVBox216.setStyle("-fx-font: 20px Tahoma");
							dialog216.setScene(dialogScene216);
							dialog216.show();

							button216.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog215.close();
									dialog216.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet214 = aanZet;
					button215.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet214);

							final Stage dialog217 = new Stage();
							dialog217.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox217 = new VBox();
							dialog217.setTitle("Hotel");
							Button button217 = new Button("OK");
							dialogVBox217.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button217);
							Scene dialogScene217 = new Scene(dialogVBox217, 300, 250);
							dialogVBox217.setAlignment(Pos.CENTER);
							dialogVBox217.setSpacing(10);
							dialogVBox217.setStyle("-fx-font: 20px Tahoma");
							dialog217.setScene(dialogScene217);
							dialog217.show();

							button217.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog215.close();
									dialog217.close();
								}
							});
						}
					});
				}


				break;

			case 22:
				TranslateTransition transition22 = new TranslateTransition();
				transition22.setNode(pion);
				transition22.setDuration(Duration.seconds(1));
				transition22.setToX(8 * 150);
				transition22.setToY(10 * 90);
				//transition1.setCycleCount(Timeline.INDEFINITE);
				transition22.setInterpolator(Interpolator.EASE_BOTH);
				transition22.play();

				final Stage dialog221 = new Stage();
				dialog221.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox221 = new VBox();
				dialog221.setTitle("Neem Kaart");
				Button button221 = new Button("Neem een kaart");
				dialogVBox221.getChildren().addAll(new Text("Neem een kaart"), button221);
				Scene dialogScene221 = new Scene(dialogVBox221, 300, 250);
				dialogVBox221.setAlignment(Pos.CENTER);
				dialogVBox221.setSpacing(10);
				dialogVBox221.setStyle("-fx-font: 20px Tahoma");
				dialog221.setScene(dialogScene221);
				dialog221.show();

				Speler finalAanZet22 = aanZet;
				button221.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog221.close();

						final Stage dialog222 = new Stage();
						dialog222.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox222 = new VBox();
						dialog222.setTitle("Opdracht");
						Button button222 = new Button("OK");
						dialogVBox222.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet22)), button222);
						Scene dialogScene222 = new Scene(dialogVBox222, 300, 250);
						dialogVBox222.setAlignment(Pos.CENTER);
						dialogVBox222.setSpacing(10);
						dialogVBox222.setStyle("-fx-font: 20px Tahoma");
						dialog222.setScene(dialogScene222);
						dialog222.show();

						button222.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet22);
								dialog221.close();
								dialog222.close();
							}
						});
					}
				});
				break;

			case 23:
				TranslateTransition transition23 = new TranslateTransition();
				transition23.setNode(pion);
				transition23.setDuration(Duration.seconds(1));
				transition23.setToX(7 * 150);
				transition23.setToY(10 * 90);
				//transition1.setCycleCount(Timeline.INDEFINITE);
				transition23.setInterpolator(Interpolator.EASE_BOTH);
				transition23.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog231 = new Stage();
					dialog231.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox231 = new VBox();
					dialog231.setTitle("Lange Steenstraat");
					Button button231 = new Button("koop");
					dialogVBox231.getChildren().addAll(new Text("Aankoopprijs: €220.000"), new Text("Huur: €22.000"),
							new Text("Hypotheek: €110.000"), new Text("Huisprijs: €150.000"), button231);
					Scene dialogScene231 = new Scene(dialogVBox231, 300, 250);
					dialogVBox231.setAlignment(Pos.CENTER);
					dialogVBox231.setSpacing(10);
					dialogVBox231.setStyle("-fx-font: 20px Tahoma");
					dialog231.setScene(dialogScene231);
					dialog231.show();

					Speler finalAanZet231 = aanZet;
					button231.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet231);

							final Stage dialog232 = new Stage();
							dialog232.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox232 = new VBox();
							dialog232.setTitle("Proficiat met uw aankoop!");
							Button button232 = new Button("OK");
							dialogVBox232.getChildren().addAll(new Text("U hebt Lange Steenstraat aangekocht"), new Text("voor €220.000"),
									button232);
							Scene dialogScene232 = new Scene(dialogVBox232, 300, 250);
							dialogVBox232.setAlignment(Pos.CENTER);
							dialogVBox232.setSpacing(10);
							dialogVBox232.setStyle("-fx-font: 20px Tahoma");
							dialog232.setScene(dialogScene232);
							dialog232.show();

							button232.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog231.close();
									dialog232.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog233 = new Stage();
					dialog233.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox233 = new VBox();
					dialog233.setTitle("Betaal Huur");
					Button button233 = new Button("Betaal huur");
					dialogVBox233.getChildren().addAll(new Text("U dient huur te betalen. "), button233);
					Scene dialogScene233 = new Scene(dialogVBox233, 300, 250);
					dialogVBox233.setAlignment(Pos.CENTER);
					dialogVBox233.setSpacing(10);
					dialogVBox233.setStyle("-fx-font: 20px Tahoma");
					dialog233.setScene(dialogScene233);
					dialog233.show();

					Speler finalAanZet232 = aanZet;
					button233.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet232);

							final Stage dialog234 = new Stage();
							dialog234.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox234 = new VBox();
							dialog234.setTitle("Huur");
							Button button23 = new Button("OK");
							dialogVBox234.getChildren().addAll(new Text("U betaalde huur"),
									button23);
							Scene dialogScene234 = new Scene(dialogVBox234, 300, 250);
							dialogVBox234.setAlignment(Pos.CENTER);
							dialogVBox234.setSpacing(10);
							dialogVBox234.setStyle("-fx-font: 20px Tahoma");
							dialog234.setScene(dialogScene234);
							dialog234.show();

							button23.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog233.close();
									dialog234.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog235 = new Stage();
					dialog235.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox235 = new VBox();
					dialog235.setTitle("Bouw");
					Button button234 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button235 = new Button("Bouw Huis");
					dialogVBox235.getChildren().addAll(new Text("Huisprijs: €150.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button234, button235);
					Scene dialogScene235 = new Scene(dialogVBox235, 300, 250);
					dialogVBox235.setAlignment(Pos.CENTER);
					dialogVBox235.setSpacing(10);
					dialogVBox235.setStyle("-fx-font: 20px Tahoma");
					dialog235.setScene(dialogScene235);
					dialog235.show();

					//Koop Hotel
					Speler finalAanZet233 = aanZet;
					button234.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet233);

							final Stage dialog236 = new Stage();
							dialog236.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox236 = new VBox();
							dialog236.setTitle("Hotel");
							Button button236 = new Button("OK");
							dialogVBox236.getChildren().addAll(new Text("U kocht een hotel"),
									button236);
							Scene dialogScene236 = new Scene(dialogVBox236, 300, 250);
							dialogVBox236.setAlignment(Pos.CENTER);
							dialogVBox236.setSpacing(10);
							dialogVBox236.setStyle("-fx-font: 20px Tahoma");
							dialog236.setScene(dialogScene236);
							dialog236.show();

							button236.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog235.close();
									dialog236.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet234 = aanZet;
					button235.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet234);

							final Stage dialog237 = new Stage();
							dialog237.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox237 = new VBox();
							dialog237.setTitle("Hotel");
							Button button237 = new Button("OK");
							dialogVBox237.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button237);
							Scene dialogScene237 = new Scene(dialogVBox237, 300, 250);
							dialogVBox237.setAlignment(Pos.CENTER);
							dialogVBox237.setSpacing(10);
							dialogVBox237.setStyle("-fx-font: 20px Tahoma");
							dialog237.setScene(dialogScene237);
							dialog237.show();

							button237.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog235.close();
									dialog237.close();
								}
							});
						}
					});
				}

				break;

			case 24:
				TranslateTransition transition24 = new TranslateTransition();
				transition24.setNode(pion);
				transition24.setDuration(Duration.seconds(1));
				transition24.setToX(6 * 150);
				;
				transition24.setToY(10 * 90);
				//transition24.setCycleCount(Timeline.INDEFINITE);
				transition24.setInterpolator(Interpolator.EASE_BOTH);
				transition24.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog241 = new Stage();
					dialog241.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox241 = new VBox();
					dialog241.setTitle("Grand Place");
					Button button241 = new Button("Koop");
					dialogVBox241.getChildren().addAll(new Text("Aankoopprijs: €240.000"), new Text("Huur: €24.000"),
							new Text("Hypotheek: €120.000"), new Text("Huisprijs: €150.000"), button241);
					Scene dialogScene241 = new Scene(dialogVBox241, 300, 250);
					dialogVBox241.setAlignment(Pos.CENTER);
					dialogVBox241.setSpacing(10);
					dialogVBox241.setStyle("-fx-font: 20px Tahoma");
					dialog241.setScene(dialogScene241);
					dialog241.show();

					Speler finalAanZet241 = aanZet;
					button241.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet241);

							final Stage dialog242 = new Stage();
							dialog242.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox242 = new VBox();
							dialog242.setTitle("Proficiat met uw aankoop!");
							Button button242 = new Button("OK");
							dialogVBox242.getChildren().addAll(new Text("U hebt Grand Place aangekocht"), new Text("voor €240.000"),
									button242);
							Scene dialogScene242 = new Scene(dialogVBox242, 300, 250);
							dialogVBox242.setAlignment(Pos.CENTER);
							dialogVBox242.setSpacing(10);
							dialogVBox242.setStyle("-fx-font: 20px Tahoma");
							dialog242.setScene(dialogScene242);
							dialog242.show();

							button242.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog241.close();
									dialog242.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog243 = new Stage();
					dialog243.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox243 = new VBox();
					dialog243.setTitle("Betaal Huur");
					Button button243 = new Button("Betaal huur");
					dialogVBox243.getChildren().addAll(new Text("U dient huur te betalen. "), button243);
					Scene dialogScene243 = new Scene(dialogVBox243, 300, 250);
					dialogVBox243.setAlignment(Pos.CENTER);
					dialogVBox243.setSpacing(10);
					dialogVBox243.setStyle("-fx-font: 20px Tahoma");
					dialog243.setScene(dialogScene243);
					dialog243.show();

					Speler finalAanZet242 = aanZet;
					button243.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet242);

							final Stage dialog244 = new Stage();
							dialog244.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox244 = new VBox();
							dialog244.setTitle("Huur");
							Button button24 = new Button("OK");
							dialogVBox244.getChildren().addAll(new Text("U betaalde huur"),
									button24);
							Scene dialogScene244 = new Scene(dialogVBox244, 300, 250);
							dialogVBox244.setAlignment(Pos.CENTER);
							dialogVBox244.setSpacing(10);
							dialogVBox244.setStyle("-fx-font: 20px Tahoma");
							dialog244.setScene(dialogScene244);
							dialog244.show();

							button24.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog243.close();
									dialog244.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog245 = new Stage();
					dialog245.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox245 = new VBox();
					dialog245.setTitle("Bouw");
					Button button244 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button245 = new Button("Bouw Huis");
					dialogVBox245.getChildren().addAll(new Text("Huisprijs: €150.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button244, button245);
					Scene dialogScene245 = new Scene(dialogVBox245, 300, 250);
					dialogVBox245.setAlignment(Pos.CENTER);
					dialogVBox245.setSpacing(10);
					dialogVBox245.setStyle("-fx-font: 20px Tahoma");
					dialog245.setScene(dialogScene245);
					dialog245.show();

					//Koop Hotel
					Speler finalAanZet243 = aanZet;
					button244.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet243);

							final Stage dialog246 = new Stage();
							dialog246.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox246 = new VBox();
							dialog246.setTitle("Hotel");
							Button button246 = new Button("OK");
							dialogVBox246.getChildren().addAll(new Text("U kocht een hotel"),
									button246);
							Scene dialogScene246 = new Scene(dialogVBox246, 300, 250);
							dialogVBox246.setAlignment(Pos.CENTER);
							dialogVBox246.setSpacing(10);
							dialogVBox246.setStyle("-fx-font: 20px Tahoma");
							dialog246.setScene(dialogScene246);
							dialog246.show();

							button246.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog245.close();
									dialog246.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet244 = aanZet;
					button245.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet244);

							final Stage dialog247 = new Stage();
							dialog247.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox247 = new VBox();
							dialog247.setTitle("Hotel");
							Button button247 = new Button("OK");
							dialogVBox247.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button247);
							Scene dialogScene247 = new Scene(dialogVBox247, 300, 250);
							dialogVBox247.setAlignment(Pos.CENTER);
							dialogVBox247.setSpacing(10);
							dialogVBox247.setStyle("-fx-font: 20px Tahoma");
							dialog247.setScene(dialogScene247);
							dialog247.show();

							button247.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog245.close();
									dialog247.close();
								}
							});
						}
					});
				}
				break;

			case 25:
				TranslateTransition transition25 = new TranslateTransition();
				transition25.setNode(pion);
				transition25.setDuration(Duration.seconds(1));
				transition25.setToX(5 * 150);
				transition25.setToY(10 * 90);
				//transition25.setCycleCount(Timeline.INDEFINITE);
				transition25.setInterpolator(Interpolator.EASE_BOTH);
				transition25.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog251 = new Stage();
					dialog251.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox251 = new VBox();
					dialog251.setTitle("Buurtspoorwegen");
					Button button251 = new Button("Koop");
					dialogVBox251.getChildren().addAll(new Text("Aankoopprijs: €200.000"), button251);
					Scene dialogScene251 = new Scene(dialogVBox251, 300, 250);
					dialogVBox251.setAlignment(Pos.CENTER);
					dialogVBox251.setSpacing(10);
					dialogVBox251.setStyle("-fx-font: 20px Tahoma");
					dialog251.setScene(dialogScene251);
					dialog251.show();

					Speler finalAanZet251 = aanZet;
					button251.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet251);

							final Stage dialog252 = new Stage();
							dialog252.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox252 = new VBox();
							dialog252.setTitle("Proficiat met uw aankoop!");
							Button button252 = new Button("OK");
							dialogVBox252.getChildren().addAll(new Text("U hebt Buurtspoorwegen aangekocht"), new Text("voor €200.000"),
									button252);
							Scene dialogScene252 = new Scene(dialogVBox252, 300, 250);
							dialogVBox252.setAlignment(Pos.CENTER);
							dialogVBox252.setSpacing(10);
							dialogVBox252.setStyle("-fx-font: 20px Tahoma");
							dialog252.setScene(dialogScene252);
							dialog252.show();

							button252.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog252.close();
									dialog251.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog253 = new Stage();
					dialog253.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox253 = new VBox();
					dialog253.setTitle("Betaal Huur");
					Button button253 = new Button("Betaal huur");
					dialogVBox253.getChildren().addAll(new Text("U dient huur te betalen. "), button253);
					Scene dialogScene253 = new Scene(dialogVBox253, 300, 250);
					dialogVBox253.setAlignment(Pos.CENTER);
					dialogVBox253.setSpacing(10);
					dialogVBox253.setStyle("-fx-font: 20px Tahoma");
					dialog253.setScene(dialogScene253);
					dialog253.show();

					Speler finalAanZet252 = aanZet;
					button253.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet252);

							final Stage dialog254 = new Stage();
							dialog254.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox254 = new VBox();
							dialog254.setTitle("Huur");
							Button button25 = new Button("OK");
							dialogVBox254.getChildren().addAll(new Text("U betaalde huur"),
									button25);
							Scene dialogScene64 = new Scene(dialogVBox254, 300, 250);
							dialogVBox254.setAlignment(Pos.CENTER);
							dialogVBox254.setSpacing(10);
							dialogVBox254.setStyle("-fx-font: 20px Tahoma");
							dialog254.setScene(dialogScene64);
							dialog254.show();

							button25.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog253.close();
									dialog254.close();
								}
							});
						}
					});
				}
				break;


			case 26:
				TranslateTransition transition26 = new TranslateTransition();
				transition26.setNode(pion);
				transition26.setDuration(Duration.seconds(1));
				transition26.setToX(4 * 150);
				transition26.setToY(10 * 90);
				//transition26.setCycleCount(Timeline.INDEFINITE);
				transition26.setInterpolator(Interpolator.EASE_BOTH);
				transition26.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog261 = new Stage();
					dialog261.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox261 = new VBox();
					dialog261.setTitle("Grote Markt");
					Button button261 = new Button("koop");
					dialogVBox261.getChildren().addAll(new Text("Aankoopprijs: €260.000"), new Text("Huur: €26.000"),
							new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"), button261);
					Scene dialogScene261 = new Scene(dialogVBox261, 300, 250);
					dialogVBox261.setAlignment(Pos.CENTER);
					dialogVBox261.setSpacing(10);
					dialogVBox261.setStyle("-fx-font: 20px Tahoma");
					dialog261.setScene(dialogScene261);
					dialog261.show();

					Speler finalAanZet261 = aanZet;
					button261.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet261);

							final Stage dialog262 = new Stage();
							dialog262.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox262 = new VBox();
							dialog262.setTitle("Proficiat met uw aankoop!");
							Button button262 = new Button("OK");
							dialogVBox262.getChildren().addAll(new Text("U hebt Grote Markt aangekocht"), new Text("voor €260.000"),
									button262);
							Scene dialogScene262 = new Scene(dialogVBox262, 300, 250);
							dialogVBox262.setAlignment(Pos.CENTER);
							dialogVBox262.setSpacing(10);
							dialogVBox262.setStyle("-fx-font: 20px Tahoma");
							dialog262.setScene(dialogScene262);
							dialog262.show();

							button262.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog261.close();
									dialog262.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog263 = new Stage();
					dialog263.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox263 = new VBox();
					dialog263.setTitle("Betaal Huur");
					Button button263 = new Button("Betaal huur");
					dialogVBox263.getChildren().addAll(new Text("U dient huur te betalen. "), button263);
					Scene dialogScene263 = new Scene(dialogVBox263, 300, 250);
					dialogVBox263.setAlignment(Pos.CENTER);
					dialogVBox263.setSpacing(10);
					dialogVBox263.setStyle("-fx-font: 20px Tahoma");
					dialog263.setScene(dialogScene263);
					dialog263.show();

					Speler finalAanZet262 = aanZet;
					button263.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet262);

							final Stage dialog264 = new Stage();
							dialog264.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox264 = new VBox();
							dialog264.setTitle("Huur");
							Button button26 = new Button("OK");
							dialogVBox264.getChildren().addAll(new Text("U betaalde huur"),
									button26);
							Scene dialogScene264 = new Scene(dialogVBox264, 300, 250);
							dialogVBox264.setAlignment(Pos.CENTER);
							dialogVBox264.setSpacing(10);
							dialogVBox264.setStyle("-fx-font: 20px Tahoma");
							dialog264.setScene(dialogScene264);
							dialog264.show();

							button26.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog263.close();
									dialog264.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog265 = new Stage();
					dialog265.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox265 = new VBox();
					dialog265.setTitle("Bouw");
					Button button264 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button265 = new Button("Bouw Huis");
					dialogVBox265.getChildren().addAll(new Text("Huisprijs: €50.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button264, button265);
					Scene dialogScene265 = new Scene(dialogVBox265, 300, 250);
					dialogVBox265.setAlignment(Pos.CENTER);
					dialogVBox265.setSpacing(10);
					dialogVBox265.setStyle("-fx-font: 20px Tahoma");
					dialog265.setScene(dialogScene265);
					dialog265.show();

					//Koop Hotel
					Speler finalAanZet263 = aanZet;
					button264.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet263);

							final Stage dialog266 = new Stage();
							dialog266.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox266 = new VBox();
							dialog266.setTitle("Hotel");
							Button button266 = new Button("OK");
							dialogVBox266.getChildren().addAll(new Text("U kocht een hotel"),
									button266);
							Scene dialogScene266 = new Scene(dialogVBox266, 300, 250);
							dialogVBox266.setAlignment(Pos.CENTER);
							dialogVBox266.setSpacing(10);
							dialogVBox266.setStyle("-fx-font: 20px Tahoma");
							dialog266.setScene(dialogScene266);
							dialog266.show();

							button266.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog265.close();
									dialog266.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet264 = aanZet;
					button265.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet264);

							final Stage dialog267 = new Stage();
							dialog267.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox267 = new VBox();
							dialog267.setTitle("Hotel");
							Button button267 = new Button("OK");
							dialogVBox267.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button267);
							Scene dialogScene267 = new Scene(dialogVBox267, 300, 250);
							dialogVBox267.setAlignment(Pos.CENTER);
							dialogVBox267.setSpacing(10);
							dialogVBox267.setStyle("-fx-font: 20px Tahoma");
							dialog267.setScene(dialogScene267);
							dialog267.show();

							button267.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog265.close();
									dialog267.close();
								}
							});
						}
					});
				}

				break;

			case 27:
				TranslateTransition transition27 = new TranslateTransition();
				transition27.setNode(pion);
				transition27.setDuration(Duration.seconds(1));
				transition27.setToX(3 * 150);
				transition27.setToY(10 * 90);
				//transition27.setCycleCount(Timeline.INDEFINITE);
				transition27.setInterpolator(Interpolator.EASE_BOTH);
				transition27.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog271 = new Stage();
					dialog271.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox271 = new VBox();
					dialog271.setTitle("Place De l'Ange");
					Button button271 = new Button("Koop");
					dialogVBox271.getChildren().addAll(new Text("Aankoopprijs: €260.000"), new Text("Huur: €26.000"),
							new Text("Hypotheek: €130.000"), new Text("Huisprijs: €150.000"), button271);
					Scene dialogScene271 = new Scene(dialogVBox271, 300, 250);
					dialogVBox271.setAlignment(Pos.CENTER);
					dialogVBox271.setSpacing(10);
					dialogVBox271.setStyle("-fx-font: 20px Tahoma");
					dialog271.setScene(dialogScene271);
					dialog271.show();

					Speler finalAanZet271 = aanZet;
					button271.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet271);

							final Stage dialog272 = new Stage();
							dialog272.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox272 = new VBox();
							dialog272.setTitle("Proficiat met uw aankoop!");
							Button button272 = new Button("OK");
							dialogVBox272.getChildren().addAll(new Text("U hebt Place De l'Ange aangekocht"), new Text("voor €260.000"),
									button272);
							Scene dialogScene272 = new Scene(dialogVBox272, 300, 250);
							dialogVBox272.setAlignment(Pos.CENTER);
							dialogVBox272.setSpacing(10);
							dialogVBox272.setStyle("-fx-font: 20px Tahoma");
							dialog272.setScene(dialogScene272);
							dialog272.show();

							button272.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog271.close();
									dialog272.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog273 = new Stage();
					dialog273.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox273 = new VBox();
					dialog273.setTitle("Betaal Huur");
					Button button273 = new Button("Betaal huur");
					dialogVBox273.getChildren().addAll(new Text("U dient huur te betalen. "), button273);
					Scene dialogScene273 = new Scene(dialogVBox273, 300, 250);
					dialogVBox273.setAlignment(Pos.CENTER);
					dialogVBox273.setSpacing(10);
					dialogVBox273.setStyle("-fx-font: 20px Tahoma");
					dialog273.setScene(dialogScene273);
					dialog273.show();

					Speler finalAanZet272 = aanZet;
					button273.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet272);

							final Stage dialog274 = new Stage();
							dialog274.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox274 = new VBox();
							dialog274.setTitle("Huur");
							Button button27 = new Button("OK");
							dialogVBox274.getChildren().addAll(new Text("U betaalde huur"),
									button27);
							Scene dialogScene274 = new Scene(dialogVBox274, 300, 250);
							dialogVBox274.setAlignment(Pos.CENTER);
							dialogVBox274.setSpacing(10);
							dialogVBox274.setStyle("-fx-font: 20px Tahoma");
							dialog274.setScene(dialogScene274);
							dialog274.show();

							button27.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog273.close();
									dialog274.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog275 = new Stage();
					dialog275.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox275 = new VBox();
					dialog275.setTitle("Bouw");
					Button button274 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button275 = new Button("Bouw Huis");
					dialogVBox275.getChildren().addAll(new Text("Huisprijs: €150.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button274, button275);
					Scene dialogScene275 = new Scene(dialogVBox275, 300, 250);
					dialogVBox275.setAlignment(Pos.CENTER);
					dialogVBox275.setSpacing(10);
					dialogVBox275.setStyle("-fx-font: 20px Tahoma");
					dialog275.setScene(dialogScene275);
					dialog275.show();

					//Koop Hotel
					Speler finalAanZet273 = aanZet;
					button274.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet273);

							final Stage dialog276 = new Stage();
							dialog276.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox276 = new VBox();
							dialog276.setTitle("Hotel");
							Button button276 = new Button("OK");
							dialogVBox276.getChildren().addAll(new Text("U kocht een hotel"),
									button276);
							Scene dialogScene276 = new Scene(dialogVBox276, 300, 250);
							dialogVBox276.setAlignment(Pos.CENTER);
							dialogVBox276.setSpacing(10);
							dialogVBox276.setStyle("-fx-font: 20px Tahoma");
							dialog276.setScene(dialogScene276);
							dialog276.show();

							button276.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog275.close();
									dialog276.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet274 = aanZet;
					button275.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet274);

							final Stage dialog277 = new Stage();
							dialog277.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox277 = new VBox();
							dialog277.setTitle("Hotel");
							Button button277 = new Button("OK");
							dialogVBox277.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button277);
							Scene dialogScene277 = new Scene(dialogVBox277, 300, 250);
							dialogVBox277.setAlignment(Pos.CENTER);
							dialogVBox277.setSpacing(10);
							dialogVBox277.setStyle("-fx-font: 20px Tahoma");
							dialog277.setScene(dialogScene277);
							dialog277.show();

							button277.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog275.close();
									dialog277.close();
								}
							});
						}
					});
				}

				break;

			case 28:
				TranslateTransition transition28 = new TranslateTransition();
				transition28.setNode(pion);
				transition28.setDuration(Duration.seconds(1));
				transition28.setToX(2 * 150);
				transition28.setToY(10 * 90);
				//transition28.setCycleCount(Timeline.INDEFINITE);
				transition28.setInterpolator(Interpolator.EASE_BOTH);
				transition28.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog281 = new Stage();
					dialog281.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox281 = new VBox();
					dialog281.setTitle("Gasmaatschappij");
					Button button281 = new Button("Koop");
					dialogVBox281.getChildren().addAll(new Text("Aankoopprijs: €150.000"), button281);
					Scene dialogScene281 = new Scene(dialogVBox281, 300, 250);
					dialogVBox281.setAlignment(Pos.CENTER);
					dialogVBox281.setSpacing(10);
					dialogVBox281.setStyle("-fx-font: 20px Tahoma");
					dialog281.setScene(dialogScene281);
					dialog281.show();

					Speler finalAanZet281 = aanZet;
					button281.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet281);

							final Stage dialog282 = new Stage();
							dialog282.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox282 = new VBox();
							dialog282.setTitle("Proficiat met uw aankoop!");
							Button button282 = new Button("OK");
							dialogVBox282.getChildren().addAll(new Text("U hebt de Gasmaatschappij aangekocht aangekocht"), new Text("voor €150.000"),
									button282);
							Scene dialogScene282 = new Scene(dialogVBox282, 300, 250);
							dialogVBox282.setAlignment(Pos.CENTER);
							dialogVBox282.setSpacing(10);
							dialogVBox282.setStyle("-fx-font: 20px Tahoma");
							dialog282.setScene(dialogScene282);
							dialog282.show();

							button282.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog282.close();
									dialog281.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog283 = new Stage();
					dialog283.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox283 = new VBox();
					dialog283.setTitle("Betaal Huur");
					Button button283 = new Button("Betaal huur");
					dialogVBox283.getChildren().addAll(new Text("U dient huur te betalen. "), button283);
					Scene dialogScene283 = new Scene(dialogVBox283, 300, 250);
					dialogVBox283.setAlignment(Pos.CENTER);
					dialogVBox283.setSpacing(10);
					dialogVBox283.setStyle("-fx-font: 20px Tahoma");
					dialog283.setScene(dialogScene283);
					dialog283.show();

					Speler finalAanZet282 = aanZet;
					button283.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet282);

							final Stage dialog284 = new Stage();
							dialog284.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox284 = new VBox();
							dialog284.setTitle("Huur");
							Button button28 = new Button("OK");
							dialogVBox284.getChildren().addAll(new Text("U gooide: " + Dice.getWorp1()), new Text("U betaalde huur"),
									button28);
							Scene dialogScene284 = new Scene(dialogVBox284, 300, 250);
							dialogVBox284.setAlignment(Pos.CENTER);
							dialogVBox284.setSpacing(10);
							dialogVBox284.setStyle("-fx-font: 20px Tahoma");
							dialog284.setScene(dialogScene284);
							dialog284.show();

							button28.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog283.close();
									dialog284.close();
								}
							});
						}
					});
				}
				break;

			case 29:
				TranslateTransition transition29 = new TranslateTransition();
				transition29.setNode(pion);
				transition29.setDuration(Duration.seconds(1));
				transition29.setToX(150);
				transition29.setToY(10 * 90);
				//transition1.setCycleCount(Timeline.INDEFINITE);
				transition29.setInterpolator(Interpolator.EASE_BOTH);
				transition29.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog291 = new Stage();
					dialog291.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox291 = new VBox();
					dialog291.setTitle("Hoogstraat");
					Button button291 = new Button("Koop");
					dialogVBox291.getChildren().addAll(new Text("Aankoopprijs: €280.000"), new Text("Huur: €28.000"),
							new Text("Hypotheek: €140.000"), new Text("Huisprijs: €150.000"), button291);
					Scene dialogScene291 = new Scene(dialogVBox291, 300, 250);
					dialogVBox291.setAlignment(Pos.CENTER);
					dialogVBox291.setSpacing(10);
					dialogVBox291.setStyle("-fx-font: 20px Tahoma");
					dialog291.setScene(dialogScene291);
					dialog291.show();

					Speler finalAanZet291 = aanZet;
					button291.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet291);

							final Stage dialog292 = new Stage();
							dialog292.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox292 = new VBox();
							dialog292.setTitle("Proficiat met uw aankoop!");
							Button button292 = new Button("OK");
							dialogVBox292.getChildren().addAll(new Text("U hebt Hoogstraat aangekocht"), new Text("voor €280.000"),
									button292);
							Scene dialogScene292 = new Scene(dialogVBox292, 300, 250);
							dialogVBox292.setAlignment(Pos.CENTER);
							dialogVBox292.setSpacing(10);
							dialogVBox292.setStyle("-fx-font: 20px Tahoma");
							dialog292.setScene(dialogScene292);
							dialog292.show();

							button292.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog291.close();
									dialog292.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog293 = new Stage();
					dialog293.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox293 = new VBox();
					dialog293.setTitle("Betaal Huur");
					Button button293 = new Button("Betaal huur");
					dialogVBox293.getChildren().addAll(new Text("U dient huur te betalen. "), button293);
					Scene dialogScene293 = new Scene(dialogVBox293, 300, 250);
					dialogVBox293.setAlignment(Pos.CENTER);
					dialogVBox293.setSpacing(10);
					dialogVBox293.setStyle("-fx-font: 20px Tahoma");
					dialog293.setScene(dialogScene293);
					dialog293.show();

					Speler finalAanZet292 = aanZet;
					button293.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet292);

							final Stage dialog294 = new Stage();
							dialog294.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox294 = new VBox();
							dialog294.setTitle("Huur");
							Button button29 = new Button("OK");
							dialogVBox294.getChildren().addAll(new Text("U betaalde huur"),
									button29);
							Scene dialogScene294 = new Scene(dialogVBox294, 300, 250);
							dialogVBox294.setAlignment(Pos.CENTER);
							dialogVBox294.setSpacing(10);
							dialogVBox294.setStyle("-fx-font: 20px Tahoma");
							dialog294.setScene(dialogScene294);
							dialog294.show();

							button29.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog293.close();
									dialog294.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog295 = new Stage();
					dialog295.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox295 = new VBox();
					dialog295.setTitle("Bouw");
					Button button294 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button295 = new Button("Bouw Huis");
					dialogVBox295.getChildren().addAll(new Text("Huisprijs: €150.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button294, button295);
					Scene dialogScene295 = new Scene(dialogVBox295, 300, 250);
					dialogVBox295.setAlignment(Pos.CENTER);
					dialogVBox295.setSpacing(10);
					dialogVBox295.setStyle("-fx-font: 20px Tahoma");
					dialog295.setScene(dialogScene295);
					dialog295.show();

					//Koop Hotel
					Speler finalAanZet293 = aanZet;
					button294.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet293);

							final Stage dialog296 = new Stage();
							dialog296.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox296 = new VBox();
							dialog296.setTitle("Hotel");
							Button button296 = new Button("OK");
							dialogVBox296.getChildren().addAll(new Text("U kocht een hotel"),
									button296);
							Scene dialogScene296 = new Scene(dialogVBox296, 300, 250);
							dialogVBox296.setAlignment(Pos.CENTER);
							dialogVBox296.setSpacing(10);
							dialogVBox296.setStyle("-fx-font: 20px Tahoma");
							dialog296.setScene(dialogScene296);
							dialog296.show();

							button296.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog295.close();
									dialog296.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet294 = aanZet;
					button295.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet294);

							final Stage dialog297 = new Stage();
							dialog297.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox297 = new VBox();
							dialog297.setTitle("Hotel");
							Button button297 = new Button("OK");
							dialogVBox297.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button297);
							Scene dialogScene297 = new Scene(dialogVBox297, 300, 250);
							dialogVBox297.setAlignment(Pos.CENTER);
							dialogVBox297.setSpacing(10);
							dialogVBox297.setStyle("-fx-font: 20px Tahoma");
							dialog297.setScene(dialogScene297);
							dialog297.show();

							button297.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog295.close();
									dialog297.close();
								}
							});
						}
					});
				}


				break;

			case 30:
				TranslateTransition transition30 = new TranslateTransition();
				transition30.setNode(pion);
				transition30.setDuration(Duration.seconds(1));
				transition30.setToX(0);
				transition30.setToY(10 * 90);
				//transition30.setCycleCount(Timeline.INDEFINITE);
				transition30.setInterpolator(Interpolator.EASE_BOTH);
				transition30.play();

				final Stage dialog301 = new Stage();
				dialog301.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox301 = new VBox();
				dialog301.setTitle("Ga naar de Gevangenis!");
				Button button301 = new Button("OK");
				dialogVBox301.getChildren().addAll(button301);
				Scene dialogScene311 = new Scene(dialogVBox301, 300, 250);
				dialogVBox301.setAlignment(Pos.CENTER);
				dialogVBox301.setSpacing(10);
				dialogVBox301.setStyle("-fx-font: 20px Tahoma");
				dialog301.setScene(dialogScene311);
				dialog301.show();

				Speler finalAanZet3 = aanZet;
				Rectangle finalPion = pion;
				button301.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent actionEvent) {
						GaNaarGevangenis.gaNaarGevangenis(finalAanZet3);

						TranslateTransition transition31 = new TranslateTransition();
						transition31.setNode(finalPion);
						transition31.setDuration(Duration.seconds(1));
						transition31.setToX(10 * 150);
						transition31.setToY(0);
						//transition30.setCycleCount(Timeline.INDEFINITE);
						transition31.setInterpolator(Interpolator.EASE_BOTH);
						transition31.play();

						dialog301.close();
					}
				});

				break;

			case 31:
				TranslateTransition transition31 = new TranslateTransition();
				transition31.setNode(pion);
				transition31.setDuration(Duration.seconds(1));
				transition31.setToX(0);
				transition31.setToY(9 * 90);
				//transition31.setCycleCount(Timeline.INDEFINITE);
				transition31.setInterpolator(Interpolator.EASE_BOTH);
				transition31.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog311 = new Stage();
					dialog311.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox311 = new VBox();
					dialog311.setTitle("Veldstraat");
					Button button311 = new Button("koop");
					dialogVBox311.getChildren().addAll(new Text("Aankoopprijs: €300.000"), new Text("Huur: €30.000"),
							new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"), button311);
					Scene dialogScene312 = new Scene(dialogVBox311, 300, 250);
					dialogVBox311.setAlignment(Pos.CENTER);
					dialogVBox311.setSpacing(10);
					dialogVBox311.setStyle("-fx-font: 20px Tahoma");
					dialog311.setScene(dialogScene312);
					dialog311.show();

					Speler finalAanZet311 = aanZet;
					button311.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet311);

							final Stage dialog312 = new Stage();
							dialog312.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox312 = new VBox();
							dialog312.setTitle("Proficiat met uw aankoop!");
							Button button312 = new Button("OK");
							dialogVBox312.getChildren().addAll(new Text("Veldstraat"), new Text("voor €300.000"),
									button312);
							Scene dialogScene312 = new Scene(dialogVBox312, 300, 250);
							dialogVBox312.setAlignment(Pos.CENTER);
							dialogVBox312.setSpacing(10);
							dialogVBox312.setStyle("-fx-font: 20px Tahoma");
							dialog312.setScene(dialogScene312);
							dialog312.show();

							button312.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog311.close();
									dialog312.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog313 = new Stage();
					dialog313.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox313 = new VBox();
					dialog313.setTitle("Betaal Huur");
					Button button313 = new Button("Betaal huur");
					dialogVBox313.getChildren().addAll(new Text("U dient huur te betalen. "), button313);
					Scene dialogScene313 = new Scene(dialogVBox313, 300, 250);
					dialogVBox313.setAlignment(Pos.CENTER);
					dialogVBox313.setSpacing(10);
					dialogVBox313.setStyle("-fx-font: 20px Tahoma");
					dialog313.setScene(dialogScene313);
					dialog313.show();

					Speler finalAanZet312 = aanZet;
					button313.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet312);

							final Stage dialog314 = new Stage();
							dialog314.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox314 = new VBox();
							dialog314.setTitle("Huur");
							Button button31 = new Button("OK");
							dialogVBox314.getChildren().addAll(new Text("U betaalde huur"),
									button31);
							Scene dialogScene314 = new Scene(dialogVBox314, 300, 250);
							dialogVBox314.setAlignment(Pos.CENTER);
							dialogVBox314.setSpacing(10);
							dialogVBox314.setStyle("-fx-font: 20px Tahoma");
							dialog314.setScene(dialogScene314);
							dialog314.show();

							button31.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog313.close();
									dialog314.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog315 = new Stage();
					dialog315.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox315 = new VBox();
					dialog315.setTitle("Bouw");
					Button button314 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button315 = new Button("Bouw Huis");
					dialogVBox315.getChildren().addAll(new Text("Huisprijs: €200.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button314, button315);
					Scene dialogScene315 = new Scene(dialogVBox315, 300, 250);
					dialogVBox315.setAlignment(Pos.CENTER);
					dialogVBox315.setSpacing(10);
					dialogVBox315.setStyle("-fx-font: 20px Tahoma");
					dialog315.setScene(dialogScene315);
					dialog315.show();

					//Koop Hotel
					Speler finalAanZet313 = aanZet;
					button314.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet313);

							final Stage dialog316 = new Stage();
							dialog316.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox316 = new VBox();
							dialog316.setTitle("Hotel");
							Button button316 = new Button("OK");
							dialogVBox316.getChildren().addAll(new Text("U kocht een hotel"),
									button316);
							Scene dialogScene316 = new Scene(dialogVBox316, 300, 250);
							dialogVBox316.setAlignment(Pos.CENTER);
							dialogVBox316.setSpacing(10);
							dialogVBox316.setStyle("-fx-font: 20px Tahoma");
							dialog316.setScene(dialogScene316);
							dialog316.show();

							button316.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog315.close();
									dialog316.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet314 = aanZet;
					button315.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet314);

							final Stage dialog317 = new Stage();
							dialog317.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox317 = new VBox();
							dialog317.setTitle("Hotel");
							Button button317 = new Button("OK");
							dialogVBox317.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button317);
							Scene dialogScene317 = new Scene(dialogVBox317, 300, 250);
							dialogVBox317.setAlignment(Pos.CENTER);
							dialogVBox317.setSpacing(10);
							dialogVBox317.setStyle("-fx-font: 20px Tahoma");
							dialog317.setScene(dialogScene317);
							dialog317.show();

							button317.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog315.close();
									dialog317.close();
								}
							});
						}
					});
				}
				break;

			case 32:
				TranslateTransition transition32 = new TranslateTransition();
				transition32.setNode(pion);
				transition32.setDuration(Duration.seconds(1));
				transition32.setToX(0);
				transition32.setToY(8 * 90);
				//transition32.setCycleCount(Timeline.INDEFINITE);
				transition32.setInterpolator(Interpolator.EASE_BOTH);
				transition32.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog321 = new Stage();
					dialog321.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox321 = new VBox();
					dialog321.setTitle("Boulevard Tirou");
					Button button321 = new Button("Koop");
					dialogVBox321.getChildren().addAll(new Text("Aankoopprijs: €300.000"), new Text("Huur: €30.000"),
							new Text("Hypotheek: €150.000"), new Text("Huisprijs: €200.000"), button321);
					Scene dialogScene321 = new Scene(dialogVBox321, 300, 250);
					dialogVBox321.setAlignment(Pos.CENTER);
					dialogVBox321.setSpacing(10);
					dialogVBox321.setStyle("-fx-font: 20px Tahoma");
					dialog321.setScene(dialogScene321);
					dialog321.show();

					Speler finalAanZet321 = aanZet;
					button321.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet321);

							final Stage dialog322 = new Stage();
							dialog322.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox322 = new VBox();
							dialog322.setTitle("Proficiat met uw aankoop!");
							Button button322 = new Button("OK");
							dialogVBox322.getChildren().addAll(new Text("U hebt Boulevard Tirou aangekocht"), new Text("voor €300.000"),
									button322);
							Scene dialogScene322 = new Scene(dialogVBox322, 300, 250);
							dialogVBox322.setAlignment(Pos.CENTER);
							dialogVBox322.setSpacing(10);
							dialogVBox322.setStyle("-fx-font: 20px Tahoma");
							dialog322.setScene(dialogScene322);
							dialog322.show();

							button322.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog321.close();
									dialog322.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog323 = new Stage();
					dialog323.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox323 = new VBox();
					dialog323.setTitle("Betaal Huur");
					Button button323 = new Button("Betaal huur");
					dialogVBox323.getChildren().addAll(new Text("U dient huur te betalen. "), button323);
					Scene dialogScene323 = new Scene(dialogVBox323, 300, 250);
					dialogVBox323.setAlignment(Pos.CENTER);
					dialogVBox323.setSpacing(10);
					dialogVBox323.setStyle("-fx-font: 20px Tahoma");
					dialog323.setScene(dialogScene323);
					dialog323.show();

					Speler finalAanZet322 = aanZet;
					button323.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet322);

							final Stage dialog324 = new Stage();
							dialog324.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox324 = new VBox();
							dialog324.setTitle("Huur");
							Button button32 = new Button("OK");
							dialogVBox324.getChildren().addAll(new Text("U betaalde huur"),
									button32);
							Scene dialogScene324 = new Scene(dialogVBox324, 300, 250);
							dialogVBox324.setAlignment(Pos.CENTER);
							dialogVBox324.setSpacing(10);
							dialogVBox324.setStyle("-fx-font: 20px Tahoma");
							dialog324.setScene(dialogScene324);
							dialog324.show();

							button32.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog323.close();
									dialog324.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog325 = new Stage();
					dialog325.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox325 = new VBox();
					dialog325.setTitle("Bouw");
					Button button324 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button325 = new Button("Bouw Huis");
					dialogVBox325.getChildren().addAll(new Text("Huisprijs: €200.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button324, button325);
					Scene dialogScene325 = new Scene(dialogVBox325, 300, 250);
					dialogVBox325.setAlignment(Pos.CENTER);
					dialogVBox325.setSpacing(10);
					dialogVBox325.setStyle("-fx-font: 20px Tahoma");
					dialog325.setScene(dialogScene325);
					dialog325.show();

					//Koop Hotel
					Speler finalAanZet323 = aanZet;
					button324.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet323);

							final Stage dialog326 = new Stage();
							dialog326.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox326 = new VBox();
							dialog326.setTitle("Hotel");
							Button button326 = new Button("OK");
							dialogVBox326.getChildren().addAll(new Text("U kocht een hotel"),
									button326);
							Scene dialogScene326 = new Scene(dialogVBox326, 300, 250);
							dialogVBox326.setAlignment(Pos.CENTER);
							dialogVBox326.setSpacing(10);
							dialogVBox326.setStyle("-fx-font: 20px Tahoma");
							dialog326.setScene(dialogScene326);
							dialog326.show();

							button326.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog325.close();
									dialog326.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet324 = aanZet;
					button325.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet324);

							final Stage dialog327 = new Stage();
							dialog327.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox327 = new VBox();
							dialog327.setTitle("Hotel");
							Button button327 = new Button("OK");
							dialogVBox327.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button327);
							Scene dialogScene327 = new Scene(dialogVBox327, 300, 250);
							dialogVBox327.setAlignment(Pos.CENTER);
							dialogVBox327.setSpacing(10);
							dialogVBox327.setStyle("-fx-font: 20px Tahoma");
							dialog327.setScene(dialogScene327);
							dialog327.show();

							button327.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog325.close();
									dialog327.close();
								}
							});
						}
					});
				}


				break;

			case 33:
				TranslateTransition transition33 = new TranslateTransition();
				transition33.setNode(pion);
				transition33.setDuration(Duration.seconds(1));
				transition33.setToX(0);
				transition33.setToY(7 * 90);
				//transition33.setCycleCount(Timeline.INDEFINITE);
				transition33.setInterpolator(Interpolator.EASE_BOTH);
				transition33.play();

				final Stage dialog331 = new Stage();
				dialog331.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox331 = new VBox();
				dialog331.setTitle("Neem Kaart");
				Button button331 = new Button("Neem een kaart");
				dialogVBox331.getChildren().addAll(new Text("Neem een kaart"), button331);
				Scene dialogScene331 = new Scene(dialogVBox331, 300, 250);
				dialogVBox331.setAlignment(Pos.CENTER);
				dialogVBox331.setSpacing(10);
				dialogVBox331.setStyle("-fx-font: 20px Tahoma");
				dialog331.setScene(dialogScene331);
				dialog331.show();

				Speler finalAanZet33 = aanZet;
				button331.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog331.close();

						final Stage dialog332 = new Stage();
						dialog332.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox332 = new VBox();
						dialog332.setTitle("Opdracht");
						Button button332 = new Button("OK");
						dialogVBox332.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet33)), button332);
						Scene dialogScene332 = new Scene(dialogVBox332, 300, 250);
						dialogVBox332.setAlignment(Pos.CENTER);
						dialogVBox332.setSpacing(10);
						dialogVBox332.setStyle("-fx-font: 20px Tahoma");
						dialog332.setScene(dialogScene332);
						dialog332.show();

						button332.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet33);
								dialog331.close();
								dialog332.close();
							}
						});
					}
				});
				break;


			case 34:
				TranslateTransition transition34 = new TranslateTransition();
				transition34.setNode(pion);
				transition34.setDuration(Duration.seconds(1));
				transition34.setToX(0);
				transition34.setToY(6 * 90);
				//transition34.setCycleCount(Timeline.INDEFINITE);
				transition34.setInterpolator(Interpolator.EASE_BOTH);
				transition34.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog341 = new Stage();
					dialog341.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox341 = new VBox();
					dialog341.setTitle("Boulevard d'Avroy");
					Button button341 = new Button("koop");
					dialogVBox341.getChildren().addAll(new Text("Aankoopprijs: €320.000"), new Text("Huur: €32.000"),
							new Text("Hypotheek: €160.000"), new Text("Huisprijs: €200.000"), button341);
					Scene dialogScene341 = new Scene(dialogVBox341, 300, 250);
					dialogVBox341.setAlignment(Pos.CENTER);
					dialogVBox341.setSpacing(10);
					dialogVBox341.setStyle("-fx-font: 20px Tahoma");
					dialog341.setScene(dialogScene341);
					dialog341.show();

					Speler finalAanZet341 = aanZet;
					button341.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet341);

							final Stage dialog342 = new Stage();
							dialog342.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox342 = new VBox();
							dialog342.setTitle("Proficiat met uw aankoop!");
							Button button342 = new Button("OK");
							dialogVBox342.getChildren().addAll(new Text("U hebt Boulevard d'Avroy aangekocht"), new Text("voor €320.000"),
									button342);
							Scene dialogScene342 = new Scene(dialogVBox342, 300, 250);
							dialogVBox342.setAlignment(Pos.CENTER);
							dialogVBox342.setSpacing(10);
							dialogVBox342.setStyle("-fx-font: 20px Tahoma");
							dialog342.setScene(dialogScene342);
							dialog342.show();

							button342.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog341.close();
									dialog342.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog343 = new Stage();
					dialog343.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox343 = new VBox();
					dialog343.setTitle("Betaal Huur");
					Button button343 = new Button("Betaal huur");
					dialogVBox343.getChildren().addAll(new Text("U dient huur te betalen. "), button343);
					Scene dialogScene343 = new Scene(dialogVBox343, 300, 250);
					dialogVBox343.setAlignment(Pos.CENTER);
					dialogVBox343.setSpacing(10);
					dialogVBox343.setStyle("-fx-font: 20px Tahoma");
					dialog343.setScene(dialogScene343);
					dialog343.show();

					Speler finalAanZet342 = aanZet;
					button343.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet342);

							final Stage dialog344 = new Stage();
							dialog344.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox344 = new VBox();
							dialog344.setTitle("Huur");
							Button button34 = new Button("OK");
							dialogVBox344.getChildren().addAll(new Text("U betaalde huur"),
									button34);
							Scene dialogScene344 = new Scene(dialogVBox344, 300, 250);
							dialogVBox344.setAlignment(Pos.CENTER);
							dialogVBox344.setSpacing(10);
							dialogVBox344.setStyle("-fx-font: 20px Tahoma");
							dialog344.setScene(dialogScene344);
							dialog344.show();

							button34.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog343.close();
									dialog344.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog345 = new Stage();
					dialog345.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox345 = new VBox();
					dialog345.setTitle("Bouw");
					Button button344 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button345 = new Button("Bouw Huis");
					dialogVBox345.getChildren().addAll(new Text("Huisprijs: €200.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button344, button345);
					Scene dialogScene345 = new Scene(dialogVBox345, 300, 250);
					dialogVBox345.setAlignment(Pos.CENTER);
					dialogVBox345.setSpacing(10);
					dialogVBox345.setStyle("-fx-font: 20px Tahoma");
					dialog345.setScene(dialogScene345);
					dialog345.show();

					//Koop Hotel
					Speler finalAanZet343 = aanZet;
					button344.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet343);

							final Stage dialog346 = new Stage();
							dialog346.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox346 = new VBox();
							dialog346.setTitle("Hotel");
							Button button346 = new Button("OK");
							dialogVBox346.getChildren().addAll(new Text("U kocht een hotel"),
									button346);
							Scene dialogScene346 = new Scene(dialogVBox346, 300, 250);
							dialogVBox346.setAlignment(Pos.CENTER);
							dialogVBox346.setSpacing(10);
							dialogVBox346.setStyle("-fx-font: 20px Tahoma");
							dialog346.setScene(dialogScene346);
							dialog346.show();

							button346.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog345.close();
									dialog346.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet344 = aanZet;
					button345.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet344);

							final Stage dialog347 = new Stage();
							dialog347.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox347 = new VBox();
							dialog347.setTitle("Hotel");
							Button button347 = new Button("OK");
							dialogVBox347.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button347);
							Scene dialogScene347 = new Scene(dialogVBox347, 300, 250);
							dialogVBox347.setAlignment(Pos.CENTER);
							dialogVBox347.setSpacing(10);
							dialogVBox347.setStyle("-fx-font: 20px Tahoma");
							dialog347.setScene(dialogScene347);
							dialog347.show();

							button347.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog345.close();
									dialog347.close();
								}
							});
						}
					});
				}

				break;

			case 35:
				TranslateTransition transition35 = new TranslateTransition();
				transition35.setNode(pion);
				transition35.setDuration(Duration.seconds(1));
				transition35.setToX(0);
				transition35.setToY(5 * 90);
				//transition35.setCycleCount(Timeline.INDEFINITE);
				transition35.setInterpolator(Interpolator.EASE_BOTH);
				transition35.play();

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog351 = new Stage();
					dialog351.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox351 = new VBox();
					dialog351.setTitle("Zuid Station");
					Button button351 = new Button("Koop");
					dialogVBox351.getChildren().addAll(new Text("Aankoopprijs: €200.000"), button351);
					Scene dialogScene351 = new Scene(dialogVBox351, 300, 250);
					dialogVBox351.setAlignment(Pos.CENTER);
					dialogVBox351.setSpacing(10);
					dialogVBox351.setStyle("-fx-font: 20px Tahoma");
					dialog351.setScene(dialogScene351);
					dialog351.show();

					Speler finalAanZet351 = aanZet;
					button351.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet351);

							final Stage dialog352 = new Stage();
							dialog352.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox352 = new VBox();
							dialog352.setTitle("Proficiat met uw aankoop!");
							Button button352 = new Button("OK");
							dialogVBox352.getChildren().addAll(new Text("U hebt Zuid Station aangekocht"), new Text("voor €200.000"),
									button352);
							Scene dialogScene352 = new Scene(dialogVBox352, 300, 250);
							dialogVBox352.setAlignment(Pos.CENTER);
							dialogVBox352.setSpacing(10);
							dialogVBox352.setStyle("-fx-font: 20px Tahoma");
							dialog352.setScene(dialogScene352);
							dialog352.show();

							button352.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog352.close();
									dialog351.close();
								}
							});
						}
					});
				}

				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog353 = new Stage();
					dialog353.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox353 = new VBox();
					dialog353.setTitle("Betaal Huur");
					Button button353 = new Button("Betaal huur");
					dialogVBox353.getChildren().addAll(new Text("U dient huur te betalen. "), button353);
					Scene dialogScene353 = new Scene(dialogVBox353, 300, 250);
					dialogVBox353.setAlignment(Pos.CENTER);
					dialogVBox353.setSpacing(10);
					dialogVBox353.setStyle("-fx-font: 20px Tahoma");
					dialog353.setScene(dialogScene353);
					dialog353.show();

					Speler finalAanZet52 = aanZet;
					button353.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet52);

							final Stage dialog354 = new Stage();
							dialog354.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox354 = new VBox();
							dialog354.setTitle("Huur");
							Button button35 = new Button("OK");
							dialogVBox354.getChildren().addAll(new Text("U betaalde huur"),
									button35);
							Scene dialogScene354 = new Scene(dialogVBox354, 300, 250);
							dialogVBox354.setAlignment(Pos.CENTER);
							dialogVBox354.setSpacing(10);
							dialogVBox354.setStyle("-fx-font: 20px Tahoma");
							dialog354.setScene(dialogScene354);
							dialog354.show();

							button35.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog353.close();
									dialog354.close();
								}
							});
						}
					});
				}
				break;

			case 36:
				TranslateTransition transition36 = new TranslateTransition();
				transition36.setNode(pion);
				transition36.setDuration(Duration.seconds(1));
				transition36.setToX(0);
				transition36.setToY(4 * 90);
				//transition36.setCycleCount(Timeline.INDEFINITE);
				transition36.setInterpolator(Interpolator.EASE_BOTH);
				transition36.play();

				final Stage dialog361 = new Stage();
				dialog361.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox361 = new VBox();
				dialog361.setTitle("Neem Kaart");
				Button button361 = new Button("Neem een kaart");
				dialogVBox361.getChildren().addAll(new Text("Neem een kaart"), button361);
				Scene dialogScene361 = new Scene(dialogVBox361, 300, 250);
				dialogVBox361.setAlignment(Pos.CENTER);
				dialogVBox361.setSpacing(10);
				dialogVBox361.setStyle("-fx-font: 20px Tahoma");
				dialog361.setScene(dialogScene361);
				dialog361.show();

				Speler finalAanZet36 = aanZet;
				button361.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog361.close();

						final Stage dialog362 = new Stage();
						dialog362.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox362 = new VBox();
						dialog362.setTitle("Opdracht");
						Button button362 = new Button("OK");
						dialogVBox362.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(finalAanZet36)), button362);
						Scene dialogScene362 = new Scene(dialogVBox362, 300, 250);
						dialogVBox362.setAlignment(Pos.CENTER);
						dialogVBox362.setSpacing(10);
						dialogVBox362.setStyle("-fx-font: 20px Tahoma");
						dialog362.setScene(dialogScene362);
						dialog362.show();

						button362.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(finalAanZet36);
								dialog361.close();
								dialog362.close();
							}
						});
					}
				});
				break;
			case 37:
				TranslateTransition transition37 = new TranslateTransition();
				transition37.setNode(pion);
				transition37.setDuration(Duration.seconds(1));
				transition37.setToX(0);
				transition37.setToY(3 * 90);
				//transition37.setCycleCount(Timeline.INDEFINITE);
				transition37.setInterpolator(Interpolator.EASE_BOTH);
				transition37.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog371 = new Stage();
					dialog371.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox371 = new VBox();
					dialog371.setTitle("Meir");
					Button button371 = new Button("Koop");
					dialogVBox371.getChildren().addAll(new Text("Aankoopprijs: €350.000"), new Text("Huur: €35.000"),
							new Text("Hypotheek: €175.000"), new Text("Huisprijs: €200.000"), button371);
					Scene dialogScene371 = new Scene(dialogVBox371, 300, 250);
					dialogVBox371.setAlignment(Pos.CENTER);
					dialogVBox371.setSpacing(10);
					dialogVBox371.setStyle("-fx-font: 20px Tahoma");
					dialog371.setScene(dialogScene371);
					dialog371.show();

					Speler finalAanZet371 = aanZet;
					button371.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet371);

							final Stage dialog372 = new Stage();
							dialog372.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox372 = new VBox();
							dialog372.setTitle("Proficiat met uw aankoop!");
							Button button372 = new Button("OK");
							dialogVBox372.getChildren().addAll(new Text("U hebt Meir aangekocht"), new Text("voor €350.000"),
									button372);
							Scene dialogScene372 = new Scene(dialogVBox372, 300, 250);
							dialogVBox372.setAlignment(Pos.CENTER);
							dialogVBox372.setSpacing(10);
							dialogVBox372.setStyle("-fx-font: 20px Tahoma");
							dialog372.setScene(dialogScene372);
							dialog372.show();

							button372.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog371.close();
									dialog372.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog373 = new Stage();
					dialog373.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox373 = new VBox();
					dialog373.setTitle("Betaal Huur");
					Button button373 = new Button("Betaal huur");
					dialogVBox373.getChildren().addAll(new Text("U dient huur te betalen. "), button373);
					Scene dialogScene373 = new Scene(dialogVBox373, 300, 250);
					dialogVBox373.setAlignment(Pos.CENTER);
					dialogVBox373.setSpacing(10);
					dialogVBox373.setStyle("-fx-font: 20px Tahoma");
					dialog373.setScene(dialogScene373);
					dialog373.show();

					Speler finalAanZet372 = aanZet;
					button373.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet372);

							final Stage dialog374 = new Stage();
							dialog374.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox374 = new VBox();
							dialog374.setTitle("Huur");
							Button button37 = new Button("OK");
							dialogVBox374.getChildren().addAll(new Text("U betaalde huur"),
									button37);
							Scene dialogScene374 = new Scene(dialogVBox374, 300, 250);
							dialogVBox374.setAlignment(Pos.CENTER);
							dialogVBox374.setSpacing(10);
							dialogVBox374.setStyle("-fx-font: 20px Tahoma");
							dialog374.setScene(dialogScene374);
							dialog374.show();

							button37.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog373.close();
									dialog374.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog375 = new Stage();
					dialog375.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox375 = new VBox();
					dialog375.setTitle("Bouw");
					Button button374 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button375 = new Button("Bouw Huis");
					dialogVBox375.getChildren().addAll(new Text("Huisprijs: €200.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button374, button375);
					Scene dialogScene375 = new Scene(dialogVBox375, 300, 250);
					dialogVBox375.setAlignment(Pos.CENTER);
					dialogVBox375.setSpacing(10);
					dialogVBox375.setStyle("-fx-font: 20px Tahoma");
					dialog375.setScene(dialogScene375);
					dialog375.show();

					//Koop Hotel
					Speler finalAanZet373 = aanZet;
					button374.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet373);

							final Stage dialog376 = new Stage();
							dialog376.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox376 = new VBox();
							dialog376.setTitle("Hotel");
							Button button376 = new Button("OK");
							dialogVBox376.getChildren().addAll(new Text("U kocht een hotel"),
									button376);
							Scene dialogScene376 = new Scene(dialogVBox376, 300, 250);
							dialogVBox376.setAlignment(Pos.CENTER);
							dialogVBox376.setSpacing(10);
							dialogVBox376.setStyle("-fx-font: 20px Tahoma");
							dialog376.setScene(dialogScene376);
							dialog376.show();

							button376.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog375.close();
									dialog376.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet374 = aanZet;
					button375.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet374);

							final Stage dialog377 = new Stage();
							dialog377.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox377 = new VBox();
							dialog377.setTitle("Hotel");
							Button button377 = new Button("OK");
							dialogVBox377.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button377);
							Scene dialogScene377 = new Scene(dialogVBox377, 300, 250);
							dialogVBox377.setAlignment(Pos.CENTER);
							dialogVBox377.setSpacing(10);
							dialogVBox377.setStyle("-fx-font: 20px Tahoma");
							dialog377.setScene(dialogScene377);
							dialog377.show();

							button377.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog375.close();
									dialog377.close();
								}
							});
						}
					});
				}


				break;

			case 38:
				TranslateTransition transition38 = new TranslateTransition();
				transition38.setNode(pion);
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
				Button button38 = new Button("Betaal Eigendomsbelasting\n€75.000");
				dialogVBox38.getChildren().addAll(button38);
				Scene dialogScene38 = new Scene(dialogVBox38, 300, 250);
				dialogVBox38.setAlignment(Pos.CENTER);
				dialogVBox38.setSpacing(10);
				dialogVBox38.setStyle("-fx-font: 20px Tahoma");
				dialog38.setScene(dialogScene38);
				dialog38.show();

				Speler finalAanZet1 = aanZet;
				button38.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Eigendomsbelasting.betaalBelasting(finalAanZet1);
						dialog38.close();
					}
				});

				break;

			case 39:
				TranslateTransition transition39 = new TranslateTransition();
				transition39.setNode(pion);
				transition39.setDuration(Duration.seconds(1));
				transition39.setToX(0);
				transition39.setToY(90);
				//transition39.setCycleCount(Timeline.INDEFINITE);
				transition39.setInterpolator(Interpolator.EASE_BOTH);
				transition39.play();

				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					final Stage dialog391 = new Stage();
					dialog391.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox391 = new VBox();
					dialog391.setTitle("Nieuwstraat");
					Button button391 = new Button("Koop");
					dialogVBox391.getChildren().addAll(new Text("Aankoopprijs: €400.000"), new Text("Huur: €400.000"),
							new Text("Hypotheek: €200.000"), new Text("Huisprijs: €200.000"), button391);
					Scene dialogScene391 = new Scene(dialogVBox391, 300, 250);
					dialogVBox391.setAlignment(Pos.CENTER);
					dialogVBox391.setSpacing(10);
					dialogVBox391.setStyle("-fx-font: 20px Tahoma");
					dialog391.setScene(dialogScene391);
					dialog391.show();

					Speler finalAanZet391 = aanZet;
					button391.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), finalAanZet391);

							final Stage dialog392 = new Stage();
							dialog392.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox392 = new VBox();
							dialog392.setTitle("Proficiat met uw aankoop!");
							Button button392 = new Button("OK");
							dialogVBox392.getChildren().addAll(new Text("U hebt Nieuwstraat aangekocht"), new Text("voor €60.000"),
									button392);
							Scene dialogScene392 = new Scene(dialogVBox392, 300, 250);
							dialogVBox392.setAlignment(Pos.CENTER);
							dialogVBox392.setSpacing(10);
							dialogVBox392.setStyle("-fx-font: 20px Tahoma");
							dialog392.setScene(dialogScene392);
							dialog392.show();

							button392.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog391.close();
									dialog392.close();
								}
							});
						}
					});
				}

				//Tegel is van een andere eigenaar
				if (!Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())
						&& Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {

					final Stage dialog393 = new Stage();
					dialog393.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox393 = new VBox();
					dialog393.setTitle("Betaal Huur");
					Button button393 = new Button("Betaal huur");
					dialogVBox393.getChildren().addAll(new Text("U dient huur te betalen. "), button393);
					Scene dialogScene393 = new Scene(dialogVBox393, 300, 250);
					dialogVBox393.setAlignment(Pos.CENTER);
					dialogVBox393.setSpacing(10);
					dialogVBox393.setStyle("-fx-font: 20px Tahoma");
					dialog393.setScene(dialogScene393);
					dialog393.show();

					Speler finalAanZet392 = aanZet;
					button393.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), finalAanZet392);

							final Stage dialog394 = new Stage();
							dialog394.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox394 = new VBox();
							dialog394.setTitle("Huur");
							Button button39 = new Button("OK");
							dialogVBox394.getChildren().addAll(new Text("U betaalde huur"),
									button39);
							Scene dialogScene394 = new Scene(dialogVBox394, 300, 250);
							dialogVBox394.setAlignment(Pos.CENTER);
							dialogVBox394.setSpacing(10);
							dialogVBox394.setStyle("-fx-font: 20px Tahoma");
							dialog394.setScene(dialogScene394);
							dialog394.show();

							button39.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog393.close();
									dialog394.close();
								}
							});
						}
					});
				}
				if (Spelbord.getTegels().get(locatie).getNaam().equals(aanZet.getNaam())) {

					// tegel is van de speler zelf

					final Stage dialog395 = new Stage();
					dialog395.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox395 = new VBox();
					dialog395.setTitle("Bouw");
					Button button394 = new Button("Bouw Hotel");
					ComboBox<Integer> comboBox = new ComboBox<>();
					ObservableList<Integer> hetAantalHuizen =
							FXCollections.observableArrayList(0, 1, 2, 3, 4);
					comboBox.setItems(hetAantalHuizen);
					Button button395 = new Button("Bouw Huis");
					dialogVBox395.getChildren().addAll(new Text("Huisprijs: €200.000"), new Text("hoeveel huizen wilt u?"),
							comboBox, button394, button395);
					Scene dialogScene395 = new Scene(dialogVBox395, 300, 250);
					dialogVBox395.setAlignment(Pos.CENTER);
					dialogVBox395.setSpacing(10);
					dialogVBox395.setStyle("-fx-font: 20px Tahoma");
					dialog395.setScene(dialogScene395);
					dialog395.show();

					//Koop Hotel
					Speler finalAanZet393 = aanZet;
					button394.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHotel((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Hotel(), finalAanZet393);

							final Stage dialog396 = new Stage();
							dialog396.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox396 = new VBox();
							dialog396.setTitle("Hotel");
							Button button396 = new Button("OK");
							dialogVBox396.getChildren().addAll(new Text("U kocht een hotel"),
									button396);
							Scene dialogScene396 = new Scene(dialogVBox396, 300, 250);
							dialogVBox396.setAlignment(Pos.CENTER);
							dialogVBox396.setSpacing(10);
							dialogVBox396.setStyle("-fx-font: 20px Tahoma");
							dialog396.setScene(dialogScene396);
							dialog396.show();

							button396.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog395.close();
									dialog396.close();
								}
							});
						}
					});

					//Koop huis
					Speler finalAanZet394 = aanZet;
					button395.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Gebouwen.koopHuis((Straat) Spelbord.getTegels().get(locatie), new Gebouwen.Huis(),
									comboBox.getValue(), finalAanZet394);

							final Stage dialog397 = new Stage();
							dialog397.initModality(Modality.APPLICATION_MODAL);
							VBox dialogVBox397 = new VBox();
							dialog397.setTitle("Hotel");
							Button button397 = new Button("OK");
							dialogVBox397.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + " huizen"),
									button397);
							Scene dialogScene397 = new Scene(dialogVBox397, 300, 250);
							dialogVBox397.setAlignment(Pos.CENTER);
							dialogVBox397.setSpacing(10);
							dialogVBox397.setStyle("-fx-font: 20px Tahoma");
							dialog397.setScene(dialogScene397);
							dialog397.show();

							button397.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									dialog395.close();
									dialog397.close();
								}
							});
						}
					});
				}


				break;
		}
	}

	public int getPositie() {
		return positie;
	}//einde Methode

	public String getNaam() {
		return naam;
	}//einde Methode

	public List<Speler> getSpelers() {
		return spelers;
	}

}

