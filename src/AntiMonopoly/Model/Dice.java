package AntiMonopoly.Model;

import java.util.Random;

public class Dice {
	/**
	 * We kunnen de methode rollDice zo oproepen (doordat die statisch is) zodat we niet telkens een 'Dice' object moeten aanmaken.
	 */

	/**
	 * constructor
	 * (Opm. Tasha ==> Aantalzijden verwijderd want het zijn er altijd 6
	 * en hebben we de constructor eigenlijk nodig? is De rollDice methode niet voldoende?)
	 */

	/*public Dice() {
		Random random = new Random();
		this.waardeWorp = random.nextInt(5) + 1;
	}//einde construcor */

	/**
	 * Methode voor het rollen van de dobbelsteen
	 * (Opm. Tasha ==> methode is static om ik deze anders niet kan oproepen in een andere klasse (zie methode: setPositie in klasse 'speler')
	 *
	 * Methode moet verder aangepast worden, ik krijg geen int waarde terug als ik deze test...
	 */

	public static int rollDice() {
		Random random = new Random();
		return random.nextInt(5) + 1;
	}

	/**
	 * Methode om het gerolde nummer te krijgen
	 * Opm. Tasha ==> ik heb alles in de methode 'rollDice' gestoken, aparte getter is volgens mij niet nodig omdat je direct de waarde wilt krijgen als je de dobbelsteen rolt
	 */

	/* public int getWaardeWorp() {
		return waardeWorp;
	}//einde Methode */

}
