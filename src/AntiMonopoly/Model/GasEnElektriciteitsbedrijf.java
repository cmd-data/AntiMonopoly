package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class GasEnElektriciteitsbedrijf extends Tegel {

	private static List<GasEnElektriciteitsbedrijf> bedrijven = new ArrayList<>();

	private final int waarde = 150000;
	private Speler eigenaar;
	private String naam;
	private int positie;

	/**
	 * Standaard constructor voor 'isKoopbaar' methode in Tegel
	 */

	public GasEnElektriciteitsbedrijf(String naam, Speler eigenaar, int positie) {
		super(naam,positie);
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	public void koopGasofElektriciteitsbedrijf(Speler speler, GasEnElektriciteitsbedrijf bedrijf){
		bedrijf.setEigenaar(speler);
		speler.setGeld(-waarde);
	}

	public static int getHuur(GasEnElektriciteitsbedrijf gasEnElektriciteitsbedrijf) {
		Speler eigenaar = gasEnElektriciteitsbedrijf.getEigenaar();
		int aantal = 0;

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof GasEnElektriciteitsbedrijf){
				bedrijven.add((GasEnElektriciteitsbedrijf) tegel);
			}
		}

		if(eigenaar.getIsConcurrent()){
			Dice.rollDie();
			return Dice.rollDie()*4;
		} else {
			for (GasEnElektriciteitsbedrijf bedrijf : bedrijven) {
				if (eigenaar.equals(bedrijf.getEigenaar())) {
					aantal++;
				}
			}

			int waardeWorp = Dice.rollDie();

			switch (aantal) {
				case 1:
					return (waardeWorp * 4 * 1000);
				case 2:
					return (waardeWorp * 10 * 1000);
			}
		}
		return 0;

	}

	public Speler getEigenaar() {
		return this.eigenaar;
	}

	public String getNaam() {
		return naam;
	}

	public void setEigenaar(Speler eigenaar) {
		this.eigenaar = eigenaar;
	}
}






