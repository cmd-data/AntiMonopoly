package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gevangenis extends Tegel {

	private static final int boete = 50000;
	private static List<Speler> gevangenen = new ArrayList<>();

	public Gevangenis(String naam, int positie) {
		super(naam, positie);
	}

	public static void opBezoek (Speler speler) {
		System.out.println("Sightseeing Tour");
	}

	public static void verlaatGevangenis(Speler speler) {
		System.out.println("Boete betalen of dubbel gooien? ('true' of 'false'): ");
		Scanner kb = new Scanner(System.in);
		String reply = kb.next();

		while(!"true".equals(reply)&&!"false".equals(reply)){
			System.out.println("Verkeerde input ('true' of 'false'): ");
			reply = kb.next();
		}

		if(Boolean.parseBoolean(reply)){
			speler.setGeld(-boete);
			gevangenen.remove(speler);
		}
		if(!Boolean.parseBoolean(reply)) {
			int rol = Dice.rollDice();
			if (Dice.isIsDubbel()) {
				Spel.move(speler, rol);
				gevangenen.remove(speler);
			}
		}
	}

	public static List<Speler> getGevangenen() { return gevangenen; }
}