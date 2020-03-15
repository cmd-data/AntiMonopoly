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

		System.out.println("Boete betalen of dubbel gooien? ('true' of 'false'): ");				// pop-up met 'true' en 'false' keuze
		Scanner kb = new Scanner(System.in);														// optie dubbel gooien mag blijven want counter moet ook hier omhoog gaan
		String reply = kb.next();

		while(!"true".equals(reply)&&!"false".equals(reply)){
			System.out.println("Verkeerde input ('true' of 'false'): ");
			reply = kb.next();
		}

		if(Boolean.parseBoolean(reply)){
			speler.setGeld(-boete);
			gevangenen.remove(speler);
			Dice.setCount(1);																		// counter omhoog als je boet betaald hebt
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