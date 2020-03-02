package AntiMonopoly.Model;

public class Tegel {

	private int positie;        //positie van de tegel op het spelbord
	private String naam;        //naam van de tegel

	/**
	 * constructor
	 */
	public Tegel(String naam, int positie) {
		this.positie = positie;
	}//einde constructor

	/**
	 * default constructor
	 */
	public Tegel () {}
	//einde constructor


	/**
	 * Methode om de positie van de tegel op te vragen
	 */
	public int getPositie() {
		return positie;
	}//einde Methode

	/**
	 * Methode om de naam van de tegel op te vragen
	 */
	public String getNaam() {
		return naam;
	}//einde Methode
}

