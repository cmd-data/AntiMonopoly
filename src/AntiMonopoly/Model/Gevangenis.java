package AntiMonopoly.Model;

public class Gevangenis extends Tegel {

	private final int boete = 50;
	private Speler speler = null;
	static Gevangenis gevangenis;

	public Gevangenis(String naam, int positie) {
		super(naam, positie);
	}

	public Gevangenis(Speler speler) {
		this.speler = speler;
		speler.setPositie(10,speler);
	}

	/**
	 * Methode kan dan opgeroepen worden als iemand op de tegel gaNaarGevangenis komt
	 * @param speler
	 */
	public static void gaNaarGevangenis(Speler speler){
		gevangenis = new Gevangenis(speler);
	}

	public int getBoete() { return this.boete; }

	public Speler getSpeler() { return speler; }

	public void setSpeler(Speler speler) { this.speler = speler; }


	public void stopStartGeld() {
		/** misschien moeten we de getSpeler gebruiken om te zien of er iemand in de gevangenis zit als men start passeert?
		 */
	}

	/**
	 * ook een isInGevangenis toetsen als je iets wilt kopen of huren? Dus bij elke beurt?
	 */
	public void stopKopen() {
		
	}

	public void stopHuur() {
		
	}

	public void verlaatGevangenis(Gevangenis speler) {		/** als argument geef je het gecreëerd Gevangenis object */
		speler.setSpeler(null);
	}

}