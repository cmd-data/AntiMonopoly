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

	public void addSpeler(Speler speler){
		spelers.add(speler);
	}

	public void removeSpeler(Speler speler){
		spelers.remove(speler);
	}

	/**
	 * default constructor
	 */
	public Tegel () {}

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
	 * Kan de tegel gekocht worden?
	 * @return
	 */
	public boolean isKoopbaar(){ return false; }

	/**
	 * Methode om te zien of de tegel een eigenaar heeft
	 */
	public boolean heeftEigenaar(){ return false; }

	/**
	 * Methode om te zien of de tegel op hypotheek staat
	 */
	public boolean heeftHypotheek(){ return false; }

	/**
	 * Methode om te zien of er gebouwen op staan
	 */
	public boolean isBebouwd(){ return false; }

}

