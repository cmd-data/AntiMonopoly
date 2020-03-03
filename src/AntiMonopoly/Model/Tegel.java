package AntiMonopoly.Model;

public class Tegel {

	private int positie;        //positie van de tegel op het spelbord
	private String naam;        //naam van de tegel

	/**
	 * constructor
	 * Opm. Tasha ==> verder uitwerken zodat alle gemeenschappelijke argumenten van alle straten en transportbedrijven in de constructor zitten
	 * extra constructor voor tegels van speciale vakken
	 */
	public Tegel(String naam, int positie) {
		this.positie = positie;
	}//einde constructor

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

