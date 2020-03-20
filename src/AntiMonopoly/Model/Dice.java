package AntiMonopoly.Model;

import java.util.Arrays;
import java.util.Random;

public class Dice {

	private static int worp1 = 1;
	private static int[] worp2 = {1,1};
	private static boolean isDubbel;
	private static int count = 0;

	public Dice() {}

	/**
	 * rol met 1 dobbelsteen
	 * @return
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
		if(!isIsDubbel()){
			count++;
			counterCheck();
		}
		Dice.isDubbel = false;
		worp2 = new int[]{rollDie(), rollDie()};
		if(worp2[0]==worp2[1]){
			Dice.isDubbel = true;
		}
		return Arrays.stream(worp2).sum();
	}

	/**
	 * counter om bij te houden welke speler er aanzet is (mag uiteraard niet groter zijn dan het aantal spelers)
	 */
	public static void counterCheck(){
		if(count > Spel.getSpelers().size()){
			count = 1;
		}
	}

	public static int getWorp1() {
		return worp1;
	}

	public static int[] getWorp2() {
		return worp2;
	}

	public static int getCount() { return count; }

	public static void setCount(int count) { Dice.count += count; }

	public static boolean isIsDubbel() { return isDubbel; }

}
