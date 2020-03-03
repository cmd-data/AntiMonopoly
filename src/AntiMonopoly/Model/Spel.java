package AntiMonopoly.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spel {

	private LocalDateTime startTijd = null;
	private LocalDateTime eindTijd;
	private Speler startSpeler;
	private static List<Speler> spelers = new ArrayList<>();
	List<Integer> rolWaarde = new ArrayList<>();


	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		maakSpelers();
	}

	public LocalDateTime getStartTijd() { return this.startTijd; }

	public LocalDateTime getEindTijd() { return this.eindTijd; }

	public void setEindTijd(LocalDateTime eindTijd) { this.eindTijd = eindTijd; }
	
	public String getSpelregels(Spelregels spelregels) {
        return spelregels.getSpelregels();
	}

	public void maakSpelers () {
		Scanner kb = new Scanner(System.in);

		for (int i = 1; i < 5; i++) {
			System.out.printf("Naam speler %d: ", i);
			String naam = kb.next();
			System.out.println("Concurrent? ('true' of 'false'): ");
			boolean soort = kb.nextBoolean();
			spelers.add(new Speler(naam,soort));

			if (2 <= i && i != 4) {
				System.out.println("Nog een speler? ('true' of 'false'): ");
				if (!kb.nextBoolean()) {
					return;
				}
			}
		}
	}


	/**
	 * vereenvoudiging van getStartSpeler:
	 * setRoll methode nog uitwerken + comparator (setRoll methode is eenvoudig maar niet ideaal want je creëert een variabele 'roll' bij spelers
	 * en eigenlijk hebben we die variabele alleen bij het begin van het spel nodig)
	 * @return
	 */
    public List<Speler> getSortedSpelers() {

		for (int i = 0; i < spelers.size(); i++) {
			spelers.get(i).setRoll(Dice.rollDice());
		}

		// check player roll
		return spelers.sort((Speler speler1, Speler speler2) -> {
			return speler1.getRoll() < speler2.getRoll();
		});
	}

	/**
	 * statische methode zodat ik deze in FaillietWinnaar en andere klassen kan oproepen
	 * @return
	 */
    public static List<Speler> getSpelers(){
		return spelers;
	}
}
