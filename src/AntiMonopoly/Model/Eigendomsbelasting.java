package AntiMonopoly.Model;

public class Eigendomsbelasting extends Tegel {

	private final int belasting = 75000;

	public Eigendomsbelasting(String naam, int positie) {
		super(naam, positie);
	}

	public int getBelasting()	{
		return this.belasting;
	}

	private void betaalBelasting (Speler speler) {
		speler.setGeld(-75000);
	}

}
