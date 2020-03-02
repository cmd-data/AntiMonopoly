package AntiMonopoly.Model;

public class Eigendomsbelasting extends Tegel {

	private final int belasting = 75000;

	public int getBelasting()	{
		return this.belasting;
	}
	
	Speler speler = new Speler();
	private void betaalBelasting () {
		speler.setGeld(-75000);
	}

}
