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

	public static String eigenaar(Tegel tegel){
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
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button21.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog21.close();

						final Stage dialog22 = new Stage();
						dialog22.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox22 = new VBox();
						dialog22.setTitle("Opdracht");
						Button button22 = new Button("OK");
						dialogVBox22.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button22);
						Scene dialogScene22 = new Scene(dialogVBox22, 300, 250);
						dialogVBox22.setAlignment(Pos.CENTER);
						dialogVBox22.setSpacing(10);
						dialogVBox22.setStyle("-fx-font: 20px Tahoma");
						dialog22.setScene(dialogScene22);
						dialog22.show();

						button22.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(aanZet);
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
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Inkomstenbelasting.betaalBelasting(aanZet);
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

					button51.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button53.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button71.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog71.close();

						final Stage dialog72 = new Stage();
						dialog72.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox72 = new VBox();
						dialog72.setTitle("Opdracht");
						Button button72 = new Button("OK");
						dialogVBox72.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button72);
						Scene dialogScene72 = new Scene(dialogVBox72, 300, 250);
						dialogVBox72.setAlignment(Pos.CENTER);
						dialogVBox72.setSpacing(10);
						dialogVBox72.setStyle("-fx-font: 20px Tahoma");
						dialog72.setScene(dialogScene72);
						dialog72.show();

						button72.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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
					dialog121.setTitle("Elektriciteitsmaatschappij");
					Button button121 = new Button("Koop");
					dialogVBox121.getChildren().addAll(new Text("Aankoopprijs: €150.000"), button121);
					Scene dialogScene281 = new Scene(dialogVBox121, 300, 250);
					dialogVBox121.setAlignment(Pos.CENTER);
					dialogVBox121.setSpacing(10);
					dialogVBox121.setStyle("-fx-font: 20px Tahoma");
					dialog121.setScene(dialogScene281);
					dialog121.show();

					button121.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button123.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

					button151.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button153.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button221.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog221.close();

						final Stage dialog222 = new Stage();
						dialog222.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox222 = new VBox();
						dialog222.setTitle("Opdracht");
						Button button222 = new Button("OK");
						dialogVBox222.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button222);
						Scene dialogScene222 = new Scene(dialogVBox222, 300, 250);
						dialogVBox222.setAlignment(Pos.CENTER);
						dialogVBox222.setSpacing(10);
						dialogVBox222.setStyle("-fx-font: 20px Tahoma");
						dialog222.setScene(dialogScene222);
						dialog222.show();

						button222.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

					button251.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button253.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

					button281.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button283.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button301.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent actionEvent) {
						GaNaarGevangenis.gaNaarGevangenis(aanZet);

						TranslateTransition transition31 = new TranslateTransition();
						transition31.setNode(pion);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button331.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog331.close();

						final Stage dialog332 = new Stage();
						dialog332.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox332 = new VBox();
						dialog332.setTitle("Opdracht");
						Button button332 = new Button("OK");
						dialogVBox332.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button332);
						Scene dialogScene332 = new Scene(dialogVBox332, 300, 250);
						dialogVBox332.setAlignment(Pos.CENTER);
						dialogVBox332.setSpacing(10);
						dialogVBox332.setStyle("-fx-font: 20px Tahoma");
						dialog332.setScene(dialogScene332);
						dialog332.show();

						button332.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

					button351.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.koopEigendom(Spelbord.getTegels().get(locatie), aanZet);

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
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {

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

					button353.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Tegel.betaalHuur(Spelbord.getTegels().get(locatie), aanZet);

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

				button361.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						dialog361.close();

						final Stage dialog362 = new Stage();
						dialog362.initModality(Modality.APPLICATION_MODAL);
						VBox dialogVBox362 = new VBox();
						dialog362.setTitle("Opdracht");
						Button button362 = new Button("OK");
						dialogVBox362.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button362);
						Scene dialogScene362 = new Scene(dialogVBox362, 300, 250);
						dialogVBox362.setAlignment(Pos.CENTER);
						dialogVBox362.setSpacing(10);
						dialogVBox362.setStyle("-fx-font: 20px Tahoma");
						dialog362.setScene(dialogScene362);
						dialog362.show();

						button362.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								ConcurrentenOfMonopolistenvak.voerUit(aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

				button38.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Eigendomsbelasting.betaalBelasting(aanZet);
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

				//Tegel heeft geen eigenaar
				if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
					Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
					//Tegel is van een andere eigenaar
					Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
				} else {
					// tegel is van de speler zelf
					Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

