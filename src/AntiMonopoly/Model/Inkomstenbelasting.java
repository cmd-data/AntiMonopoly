package AntiMonopoly.Model;

public class Inkomstenbelasting extends Tegel {

	static int belasting = 200000;

	public Inkomstenbelasting(String naam, int positie) {
		super(naam, positie);
	}

	public static void betaalBelasting(Speler speler){
		speler.setGeld(-belasting);
		Spel.updateGeld(speler);
	}

	/*public static void betaalBelasting(Speler speler) {
		int inkomstenBelasting;

		if (speler.getIsConcurrent()) {  // '== true' moet er niet aan toe gevoegd worden, dit is automatisch 'if true'
			inkomstenBelasting = (int) (speler.getGeld()*0.1+speler.waardeBezittingen(speler)*0.1);
		} else {
			inkomstenBelasting = (int) (speler.getGeld()*0.2+speler.waardeBezittingen(speler)*0.1);
		}

		if (inkomstenBelasting > 200000) {
			speler.setGeld(-belasting);
		} else {
			speler.setGeld (inkomstenBelasting);
		}
	}*/
}
