package AntiMonopoly.Model;

import java.time.LocalDateTime;
import java.util.*;

public class Spel {

	private LocalDateTime startTijd, eindTijd;
	private static List<Speler> spelers = new ArrayList<>();
	private Spelbord spelbord = new Spelbord();
	private Spelregels spelregels = new Spelregels();

	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		maakSpelers();
	}

	public Spel(){}  // Constructor voor eenvoudig te kunnen testen in main

	public LocalDateTime getStartTijd() { return this.startTijd; }

	public LocalDateTime getEindTijd() { return this.eindTijd; }

	public void setEindTijd(LocalDateTime eindTijd) { this.eindTijd = eindTijd; }

	public void maakSpelers () {
		Scanner kb = new Scanner(System.in);

		for (int i = 1; i < 5; i++) {
			System.out.printf("Naam speler %d: ", i);
			String naam = kb.next();
			System.out.println("Concurrent? ('true' of 'false'): ");
			boolean soort = kb.nextBoolean();
			System.out.println("Kleur pion? (Keuze uit: blauw, rood, geel en groen): ");
			String kleur = kb.next();
			spelers.add(new Speler(naam,soort,kleur));				// nog melding geven als kleur al gekozen is

			if (2 <= i && i != 4) {
				System.out.println("Nog een speler? ('true' of 'false'): ");
				if (!kb.nextBoolean()) {
					return;
				}
			}
		}
		kb.close();
	}


	/**
	 * Volgorde spelers wordt veranderd en geeft lijst met namen nieuwe volgorde weer
	 * In View/Presenter ervoor zorgen dat nummer 1 de hoogste fictive dobbelwaarde te zien krijgt, nummer 2: een waarde minder, etc.
	 * @return
	 */
    public List<String> getSortedSpelers() {
    	Collections.shuffle(spelers);

		List<String> namen = new ArrayList<>();
		for (Speler speler : spelers) {
			namen.add(speler.getNaam());
		}
    	return namen;
	}

	/**
	 * statische methode zodat ik deze in FaillietWinnaar en andere klassen kan oproepen
	 * @return
	 */
    public static List<Speler> getSpelers(){
		return spelers;
	}

	/**
	 * Past posite van speler aan + speler gelinkt aan de tegel
	 * @param speler
	 * @param rol
	 */
	public void verplaatsSpeler(Speler speler, int rol){
    	Spelbord.getTegels().get(speler.getPositie()).removeSpeler(speler);

    	if ((speler.getPositie()+rol)<=39){
    		speler.setPositie(speler.getPositie()+rol);
		} else {
    		speler.setPositie(rol-(39-speler.getPositie())-1);             	// indien som van positie + rol groter is dan 39 (einde van spelbord) dan zorgt dit ervoor dat positie
		}																	// na 39 terug naar 0 gaat en dan verder optelt

		Spelbord.getTegels().get(speler.getPositie()).addSpeler(speler);
	}

	public boolean eindeSpel(){
		FaillietWinnaar winnaar = new FaillietWinnaar();
		List<Boolean> winnaars = new ArrayList<>();
		for (Speler speler : spelers) {
			winnaars.add(winnaar.isWinnaar(speler));
		}
		return winnaars.contains(true);
	}
}
