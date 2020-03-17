package AntiMonopoly.Model;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

	/*public void tegelMethode(Tegel tegel, Speler speler) {
		int soortVak = tegel.positie;

		if (kopen(tegel)) {
			if (heeftEigenaar(tegel)) {
				Eigenaar(tegel);																		// pop up van deze methode zodat de eigenaar getoond wordt
				if (!heeftHypotheek(tegel)&&!speler.getNaam().equals(Eigenaar(tegel))) {				// pop-up straat op hypotheek
					betaalHuur(tegel, speler);						 									// pop-up betaal huur?
				}
			} else {
				kopen();                                                                       		// lege method juist voor pop-up met 'koop' knop
				koopEigendom(tegel,speler);}														// Knop koop

		} else {
				switch (soortVak) {
					case 36:
					case 33:
					case 22:
					case 17:
					case 7:
					case 2:
						ConcurrentenOfMonopolistenvak.voerUit(speler);
						break;
					case 4:
						Inkomstenbelasting.betaalBelasting(speler);
						break;
					case 10:
						if (Gevangenis.getGevangenen().contains(speler)) {
							Gevangenis.verlaatGevangenis(speler);
						} else {
							Gevangenis.opBezoek(speler);
						}
						break;
					case 20:
						AntiMonopolyStichting.voerUit(speler);
						break;
					case 30:
						GaNaarGevangenis.gaNaarGevangenis(speler);
						break;
					case 38:
						Eigendomsbelasting.betaalBelasting(speler);
				}
			}
	}*/

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
		}
		if (tegel instanceof Transport){
			speler.setGeld(-Transport.getHuur((Transport) tegel));
			((Transport) tegel).getEigenaar().setGeld(Transport.getHuur((Transport) tegel));

		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			speler.setGeld(-GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
			((GasEnElektriciteitsbedrijf) tegel).getEigenaar().setGeld(GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
		}
		Spel.updateGeld(speler);
	}

	public void tegelMethode(Rectangle pion, Speler aanZet) {

		List<Rectangle> pionnen = new ArrayList<>();

		for (int i = 0; i < Spel.getSpelers().size(); i++) {
			pionnen.add(Spel.getSpelers().get(i).getRectangle());
		}

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

		int locatie = Spel.move(aanZet, Arrays.stream(Dice.getWorp2()).sum()).getPositie();

		switch (locatie) {

			case 0: tegel0(pion,aanZet);
		}
	}

	public void tegel0(Rectangle pion, Speler aanZet) {
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

