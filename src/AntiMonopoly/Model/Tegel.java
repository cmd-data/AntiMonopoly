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
		Spel.updateGeld();
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
		}
		if (tegel instanceof Transport){
			speler.setGeld(-Transport.getHuur((Transport) tegel));
			((Transport) tegel).getEigenaar().setGeld(Transport.getHuur((Transport) tegel));
		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			speler.setGeld(-GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
			((GasEnElektriciteitsbedrijf) tegel).getEigenaar().setGeld(GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
		}

		Spel.updateGeld();
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
				dialogVBox0.getChildren().addAll(new Text("U staat op start en ontvangt: \n€200.000"), button0);
				Scene dialogScene0 = new Scene(dialogVBox0, 500,300);
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

				caseEigenaarStraat(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
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
				Button button4 = new Button("Betaal €200.000");
				dialogVBox4.getChildren().addAll(new Text("Betaal jouw inkomstenbelasting"), button4);
				Scene dialogScene4 = new Scene(dialogVBox4, 500,300);
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

				caseEigenaarTransport(aanZet, locatie);

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

				caseEigenaarStraat(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarGasElek(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarTransport(aanZet, locatie);

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

				caseEigenaarStraat(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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
				Scene dialogScene20 = new Scene(dialogVBox20, 500,300);
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

				caseEigenaarStraat(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
				break;

			case 24:
				TranslateTransition transition24 = new TranslateTransition();
				transition24.setNode(pion);
				transition24.setDuration(Duration.seconds(1));
				transition24.setToX(6 * 150);
				transition24.setToY(10 * 90);
				//transition24.setCycleCount(Timeline.INDEFINITE);
				transition24.setInterpolator(Interpolator.EASE_BOTH);
				transition24.play();

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarTransport(aanZet, locatie);

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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarGasElek(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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
				dialogVBox301.getChildren().addAll(new Text("Ga naar de gevangenis!"), button301);
				Scene dialogScene311 = new Scene(dialogVBox301, 500,300);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarStraat(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
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

				caseEigenaarTransport(aanZet, locatie);
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

				ConcurrentenOfMonopolistenvak.vakMethode(aanZet);
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

				caseEigenaarStraat(aanZet, locatie);
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
				Button button38 = new Button("Betaal €75.000");
				dialogVBox38.getChildren().addAll(new Text("Betaal jouw eigendomsbelasting"), button38);
				Scene dialogScene38 = new Scene(dialogVBox38, 500,300);
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

				caseEigenaarStraat(aanZet, locatie);
				break;
		}
	}

	private static void caseEigenaarGasElek(Speler aanZet, int locatie) {
		if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
			GasEnElektriciteitsbedrijf.gasElekMethodeKopen((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(locatie), aanZet);
		} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
			GasEnElektriciteitsbedrijf.gasElekMethodeHuur((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(locatie), aanZet);
		}
	}

	private static void caseEigenaarTransport(Speler aanZet, int locatie) {
		if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
			Transport.transportMethodeKopen((Transport) Spelbord.getTegels().get(locatie), aanZet);
		} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
			Transport.transportMethodeHuur((Transport) Spelbord.getTegels().get(locatie), aanZet);
		}
	}

	private static void caseEigenaarStraat(Speler aanZet, int locatie) {
		if (!Tegel.heeftEigenaar(Spelbord.getTegels().get(locatie))) {
			//Tegel heeft geen eigenaar
			Straat.straatMethodeKopen((Straat) Spelbord.getTegels().get(locatie),aanZet);
		} else if (!aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))) {
			//Tegel is van een andere eigenaar
			Straat.straatMethodeHuur((Straat) Spelbord.getTegels().get(locatie),aanZet);
		} else if (aanZet.getNaam().equals(eigenaar(Spelbord.getTegels().get(locatie)))){
			// tegel is van de speler zelf
			Straat.straatMethodeBouwen((Straat) Spelbord.getTegels().get(locatie), aanZet);
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

