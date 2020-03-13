package AntiMonopoly.Model;

public class Inkomstenbelasting extends Tegel {

	public Inkomstenbelasting(String naam, int positie) {
		super(naam, positie);
	}

	public static void betaalBelasting(Speler speler) {
		int inkomstenBelasting;
		int belasting = 200000;
		if (speler.getIsConcurrent()) {  // '== true' moet er niet aan toe gevoegd worden, dit is automatisch 'if true'
			inkomstenBelasting = (int) (speler.getGeld()*0.1+speler.waardeBezittingen(speler)*0.1); /*"10% grondprijs in bezit"+"10% huizen in bezit"*/; /* bij speler nog een int totaal bezit maken, waarbij we al de bezittingen in opnemen? */
		} else {
			inkomstenBelasting = (int) (speler.getGeld()*0.2+speler.waardeBezittingen(speler)*0.1);/*"10% grondprijs in bezit"+"10% huizen in bezit"*/;
		}

		if (inkomstenBelasting > 200000) {
			speler.setGeld(-belasting);
		} else {
			speler.setGeld (inkomstenBelasting);
		}
	}
}
