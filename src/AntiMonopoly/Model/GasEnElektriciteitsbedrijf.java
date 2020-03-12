package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class GasEnElektriciteitsbedrijf extends Tegel {

	private List<GasEnElektriciteitsbedrijf> gasEnElektriciteitsbedrijf = new ArrayList<>();

	private final int waarde = 150000;
	private String eigenaar;
	private String naam;
	private int positie;

	/**
	 * Standaard constructor voor 'isKoopbaar' methode in Tegel
	 */

	public GasEnElektriciteitsbedrijf(String naam, String eigenaar, int positie) {
		super(naam,positie);
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	public String getEigenaar() {
		return eigenaar;
	}

	public String getNaam() {
		return naam;
	}

	public void setEigenaar(String eigenaar) {
		this.eigenaar = eigenaar;
	}

	private void betaalHuur(GasEnElektriciteitsbedrijf gasEnElektriciteitsbedrijf, Speler speler) {
		String eigenaar = gasEnElektriciteitsbedrijf.getEigenaar();
		int aantal = 1;
		if(speler.getIsConcurrent()){
			Dice.rollDie();
			int waardeWorp = Dice.rollDie();
			speler.setGeld(-waardeWorp*4);
		} else {
			for (int i = 0; i < this.gasEnElektriciteitsbedrijf.size(); i++) {
				if (eigenaar.equals(this.gasEnElektriciteitsbedrijf.get(i).getEigenaar())&&!gasEnElektriciteitsbedrijf.equals(this.gasEnElektriciteitsbedrijf.get(i))){
					aantal++;
				}
				Dice.rollDie();
				int waardeWorp = Dice.rollDie();

				switch (waardeWorp){
					case 1: speler.setGeld(-waardeWorp * 4); break;
					case 2: speler.setGeld(-waardeWorp * 10); break;
				}
			}

		}
	}
}





