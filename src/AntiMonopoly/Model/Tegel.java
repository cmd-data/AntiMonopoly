package AntiMonopoly.Model;

import java.util.List;

public class Tegel {

	private int positie;
	private String naam;
	private List<Speler> spelers;

	/**
	 * constructor
	 * Opm. Tasha ==> verder uitwerken zodat alle gemeenschappelijke argumenten van alle straten en transportbedrijven in de constructor zitten
	 * extra constructor voor tegels van speciale vakken
	 */
	public Tegel(String naam, int positie) {
		this.naam = naam;
		this.positie = positie;
	}

	public int getPositie() {
		return positie;
	}//einde Methode

	public String getNaam() {
		return naam;
	}//einde Methode

	public List<Speler> getSpelers() {
		return spelers;
	}

	/**
	 * Kan de tegel gekocht worden? (nog uitwerken)
	 * @return
	 */
	public boolean isKoopbaar(int index){
		if(Spelbord.getTegels().get(index) instanceof Straat){
			return true;
		}
		if(Spelbord.getTegels().get(index) instanceof Transport){
			return true;
		}
		if(Spelbord.getTegels().get(index) instanceof GasEnElektriciteitsbedrijf){
			return true;
		}
		return false;
	}

	/**
	 * Methode om te zien of de tegel een eigenaar heeft
	 */
	public boolean heeftEigenaar(Tegel tegel){
		if(Spelbord.getTegels().get(tegel.positie) instanceof Straat){
			if (((Straat) Spelbord.getTegels().get(tegel.positie)).getEigenaar()==null){
				return false;
			}
		}
		if(Spelbord.getTegels().get(tegel.positie) instanceof Transport){
			if (((Transport) Spelbord.getTegels().get(tegel.positie)).getEigenaar()==null){
				return false;
			}
		}
		if(Spelbord.getTegels().get(tegel.positie) instanceof GasEnElektriciteitsbedrijf){
			if (((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(tegel.positie)).getEigenaar()==null){
				return false;
			}
		}
		return false;
	}

	/**
	 * Methode om te zien of de tegel op hypotheek staat
	 */
	public boolean heeftHypotheek(Tegel tegel){
		if (Hypotheek.getHypotheekLijst().contains(tegel)){
			return true;
		} else { return false; }
	}

}

