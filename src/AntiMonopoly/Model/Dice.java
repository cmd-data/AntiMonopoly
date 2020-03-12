package AntiMonopoly.Model;

import java.util.Arrays;
import java.util.Random;

public class Dice {

	private static int worp1;
	private static int[] worp2;
	private static boolean isDubbel; 	        // true of false bijhouden als speler dubbel gegooid heeft

	public Dice() {}

	/**
	 * Methode voor het rollen van de dobbelsteen
	 * (Opm. Tasha ==> methode is static om ik deze anders niet kan oproepen in een andere klasse (zie methode: setPositie in klasse 'speler')
	 * <p>
	 * Methode moet verder aangepast worden, ik krijg geen int waarde terug als ik deze test...
	 */

	public static int rollDie() {
		Random random = new Random();
		worp1 = (random.nextInt(6)+1);
		return worp1;
	}

	/**
	 * methode voor met 2 dobbelstenen te rollen
	 */
	public static int rollDice() {
		worp2 = new int[]{rollDie(), rollDie()};
		if(worp2[0]==worp2[1]){
			Dice.isDubbel=true;
		}
		return Arrays.stream(worp2).sum();
	}

	public static int getWorp1() {
		return worp1;
	}

	public static int[] getWorp2() {
		return worp2;
	}

	public static boolean isIsDubbel() { return isDubbel; }
}
