package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Hypotheek {

	private static List<Tegel> hypotheekLijst = new ArrayList<>();

	public Hypotheek (){ }

	public static boolean stopHuur(Tegel tegel) {
		return hypotheekLijst.contains(tegel);
	}

	public static List<Tegel> getHypotheekLijst() { return hypotheekLijst; }

	public static List<String> getHypotheekLijstNamen(Speler speler) {
		List <String> hypotheken = new ArrayList<>();
		for (Tegel tegel : hypotheekLijst) {
			hypotheken.add(tegel.getNaam());
		}
		hypotheken.retainAll(Speler.eigendommen(speler));			// houdt alleen duplicaten in de hypotheken lijst (eigendommen van de speler die ook op hypotheek staan)
		return hypotheken;
	}

	public static void neemHypotheek(Tegel tegel, Speler speler) {
		if(!hypotheekLijst.contains(tegel)) {

			hypotheekLijst.add(tegel);

			if (tegel instanceof Straat) {
				speler.setGeld(((Straat) tegel).getHypotheek());
			}
			if (tegel instanceof Transport) {
				speler.setGeld(((Transport) tegel).getHypotheek());
			}
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				speler.setGeld(((GasEnElektriciteitsbedrijf) tegel).getHypotheek());
			}

			Spel.updateGeld();
		}
	}

	public static void uitHypotheek(Tegel tegel, Speler speler){
		if (hypotheekLijst.contains(tegel)) {
			hypotheekLijst.remove(tegel);

			if (tegel instanceof Straat) {
				speler.setGeld(-((Straat) tegel).getHypotheek());
			}
			if (tegel instanceof Transport) {
				speler.setGeld(-((Transport) tegel).getHypotheek());
			}
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				speler.setGeld(-((GasEnElektriciteitsbedrijf) tegel).getHypotheek());
			}

			Spel.updateGeld();
		}
	}

}