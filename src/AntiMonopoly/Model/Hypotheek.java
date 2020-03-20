package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Hypotheek {

	private static List<Tegel> hypotheekLijst = new ArrayList<>();

	public Hypotheek (){ }

	public void stopHuur(Tegel tegel) {
		if(hypotheekLijst.contains(tegel)){
			/**
			 * Stop methode betaalHuur als iemand op de straat terecht komt*/
		}
	}

	public static List<Tegel> getHypotheekLijst() { return hypotheekLijst; }

	public static void neemHypotheek(Tegel tegel, Speler speler) {
		hypotheekLijst.add(tegel);

		if (tegel instanceof Straat){
			speler.setGeld(((Straat) tegel).getHypotheek());
		}
		if (tegel instanceof Transport){
			speler.setGeld(((Transport) tegel).getHypotheek());
		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			speler.setGeld(((GasEnElektriciteitsbedrijf) tegel).getHypotheek());
		}

		Spel.updateGeld();
	}

	public void uitHypotheek(Straat straat, Speler speler){
		hypotheekLijst.remove(straat);
		speler.setGeld(-straat.getHypotheek());
		Spel.updateGeld();
	}

}