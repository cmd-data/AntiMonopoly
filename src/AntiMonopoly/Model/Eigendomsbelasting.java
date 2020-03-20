package AntiMonopoly.Model;

public class Eigendomsbelasting extends Tegel {

	private static final int belasting = 75000;

	public Eigendomsbelasting(String naam, int positie) {
		super(naam, positie);
	}

	public static void betaalBelasting (Speler speler) {
		speler.setGeld(-belasting);
		Spel.updateGeld();
	}

}
