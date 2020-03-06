package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class GasEnElektriciteitsbedrijf extends Tegel {

	private List<GasEnElektriciteitsbedrijf> gasEnElektriciteitsbedrijf = new ArrayList<>();

	private final int waarde = 150000;
	private String eigenaar;
	private String naam;
	private int positie;

	public GasEnElektriciteitsbedrijf(String naam, String eigenaar, int positie) {
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	/*public void voegToe(){
		gasEnElektriciteitsbedrijf.add(new GasEnElektriciteitsbedrijf("Elektriciteitsbedrijf",null));
		gasEnElektriciteitsbedrijf.add(new GasEnElektriciteitsbedrijf("Gasbedrijf",null));

	}*/

	public String getEigenaar() {
		return eigenaar;
	}

	public String getNaam() {
		return naam;
	}

	public void setEigenaar(String eigenaar) {
		this.eigenaar = eigenaar;
	}

	Speler speler = new Speler();
	Dice dice = new Dice();
	private void betaalHuur(GasEnElektriciteitsbedrijf gasEnElektriciteitsbedrijf) {
		String eigenaar = gasEnElektriciteitsbedrijf.getEigenaar();
		int aantal = 1;
		if(speler.getIsConcurrent()){
			dice.rollDice();
			int waardeWorp = dice.rollDice();
			speler.setGeld(-waardeWorp*4);
		} else {
			for (int i = 0; i < this.gasEnElektriciteitsbedrijf.size(); i++) {
				if (eigenaar.equals(this.gasEnElektriciteitsbedrijf.get(i).getEigenaar())&&!gasEnElektriciteitsbedrijf.equals(this.gasEnElektriciteitsbedrijf.get(i))){
					aantal++;		/** weet niet goed waarom de get niet werkt ==> Opm. Tasha: 'this.' toegevoegd*/
				}
				dice.rollDice();
				int waardeWorp = dice.rollDice();

				if (aantal == 1) {
					speler.setGeld(-waardeWorp * 4);
				}

				if (aantal == 2) {
					speler.setGeld(-waardeWorp * 10);
				}

			}

		}
	}
}





