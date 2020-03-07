package AntiMonopoly.Model;

import java.util.Random;

public class Dice {

	private int worp1;
	private int[] worp2;

	public Dice() {}

	/**
	 * Methode voor het rollen van de dobbelsteen
	 * (Opm. Tasha ==> methode is static om ik deze anders niet kan oproepen in een andere klasse (zie methode: setPositie in klasse 'speler')
	 * <p>
	 * Methode moet verder aangepast worden, ik krijg geen int waarde terug als ik deze test...
	 */

	public int rollDice() {
		Random random = new Random();
		worp1 = (random.nextInt(6)+1);
		return worp1;
	}

	/**
	 * methode voor met 2 dobbelstenen te rollen
	 */
	public int[] rollDices() {
		worp2 = new int[]{rollDice(), rollDice()};
		return worp2;
	}
}
