package AntiMonopoly.Model;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.time.LocalDateTime;
import java.util.*;

public class Spel {

	private LocalDateTime startTijd, eindTijd;
	private static List<Speler> spelers = new ArrayList<>();
	private Spelbord spelbord = new Spelbord();
	private Spelregels spelregels = new Spelregels();
	MultiValuedMap<Tegel,Speler> posities = new ArrayListValuedHashMap<>();

	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		maakSpelers();
		posities.putAll(Spelbord.getTegels().get(0),spelers);     // elke speler op start positie plaatsen (mag geen passeer start generereren)
	}

	public Spel(){}  // Constructor voor eenvoudig te kunnen testen in main

	public void maakSpelers () {
		Scanner kb = new Scanner(System.in);
		List<String> kleuren = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			System.out.printf("Naam speler %d: ", i);
			String naam = kb.next();
			System.out.println("Concurrent? ('true' of 'false'): ");
			String soort = kb.next();

			while(!"true".equals(soort)&&!"false".equals(soort)){
				System.out.println("Verkeerde input ('true' of 'false'): ");
				soort = kb.next();
			}

			System.out.println("Kleur pion? (Keuze uit: blauw, rood, geel of groen): ");
			String kleur = kb.next();

			while(!"blauw".equals(kleur)&&!"rood".equals(kleur)&&!"geel".equals(kleur)&&!"groen".equals(kleur)){
				System.out.println("Verkeerde input (blauw, rood, geel of groen): ");
				kleur = kb.next();
			}

			while (i>1&&kleuren.contains(kleur)) {
				System.out.println("Kleur is al gekozen, geef een andere kleur in: ");
				kleur = kb.next();
			}
			spelers.add(new Speler(naam, Boolean.parseBoolean(soort), kleur));
			kleuren.add(kleur);

			if (2 <= i && i != 4) {
				System.out.println("Nog een speler? ('true' of 'false'): ");
				String antwoord = kb.next();

				while(!"true".equals(antwoord)&&!"false".equals(antwoord)){
					System.out.println("Verkeerde input ('true' of 'false'): ");
					antwoord = kb.next();
				}

				if (!Boolean.parseBoolean(antwoord)) {
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

	public void move(Speler speler,Tegel tegel){
    	if (posities.containsValue(speler)){
    		checkPasseerStart(speler,tegel);
    		posities.values().remove(speler);
		}
    	posities.put(tegel,speler);
	}

	/**
	 * Check passeer start nog uitwerken zodat het met move() kan gebruikt worden
	 */

	public void checkPasseerStart(Speler speler, Tegel tegel) {
		for (Map.Entry<Tegel, Speler> entry : posities.entries()) {
			if (speler.equals(entry.getValue())) {
				if(tegel.getPositie() < entry.getKey().getPositie() && 30 != tegel.getPositie()) {
					speler.setGeld(200000);
				}
			}
		}
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

	/**
	 * statische methode zodat ik deze in FaillietWinnaar en andere klassen kan oproepen
	 * @return
	 */
	public static List<Speler> getSpelers(){
		return spelers;
	}

	public LocalDateTime getStartTijd() { return this.startTijd; }

	public LocalDateTime getEindTijd() { return this.eindTijd; }

	public void setEindTijd(LocalDateTime eindTijd) { this.eindTijd = eindTijd; }

	public Spelbord getSpelbord() { return spelbord; }

	public Spelregels getSpelregels() { return spelregels; }
}
