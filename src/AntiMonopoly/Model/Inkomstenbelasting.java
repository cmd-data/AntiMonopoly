package AntiMonopoly.Model;

public class Inkomstenbelasting extends Tegel {

	private final int belasting = 200000;
	private int inkomstenBelasting;

	public Inkomstenbelasting(String naam, int positie) {
		super(naam, positie);
	}

	public int getBelasting()	{
		return this.belasting;
	}

	/**
	 * Instantie van speler verwijderd en als argument aan betaalBelasting meegegeven
	 * @param speler
	 */
	public void betaalBelasting(Speler speler) {
		if (speler.getIsConcurrent()) {  // '== true' moet er niet aan toe gevoegd worden, dit is automatisch 'if true'
			this.inkomstenBelasting = (int) (speler.getGeld()*0.1+speler.waardeBezittingen(speler)*0.1); /*"10% grondprijs in bezit"+"10% huizen in bezit"*/; /* bij speler nog een int totaal bezit maken, waarbij we al de bezittingen in opnemen? */
		} else {
			this.inkomstenBelasting = (int) (speler.getGeld()*0.2+speler.waardeBezittingen(speler)*0.1);/*"10% grondprijs in bezit"+"10% huizen in bezit"*/;
		}

		if (this.inkomstenBelasting > 200000) {
			speler.setGeld(-belasting);
		} else {
			speler.setGeld (-this.inkomstenBelasting);
		}
	}

}
