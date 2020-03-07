package AntiMonopoly.Model;

import com.sun.source.tree.Tree;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

public class Spel {

	private LocalDateTime startTijd = null;
	private LocalDateTime eindTijd;
	private Speler startSpeler;
	private static List<Speler> spelers = new ArrayList<>();
	List<Integer> rolWaarde = new ArrayList<>();
	Spelbord spelbord = new Spelbord();
	Dice dice = new Dice();

	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		maakSpelers();
	}

	public Spel(){}  // Constructor voor eenvoudig te kunnen testen in main

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
	 * Methode runt niet als ik 4 spelers heb: OutofMemory error (heap size al aangepast naar 3 gb en nog steeds niet...)
	 * @return
	 */
    public List<String> getSortedSpelers() {
    	MultiValuedMap<Double,Speler> playerRolls = new ArrayListValuedHashMap<>();               // MultiMap zodat er meerdere waarden voor 1 key kunnen zijn (meerdere spelers met zelfde rolwaarde)
		for (int speler = 0; speler < spelers.size(); speler++) {
			playerRolls.put((double)dice.rollDice(),spelers.get(speler));                         // Elke speler + rolwaarde toevoegen aan de map
		}

		double divider = 0.1;                                                                     // nodig als spelers hetzelfde rollen: eerste worp = 6; tweede worp = 2 wordt dan 6.2
		Collection<Double> keys = new ArrayList<>(playerRolls.keySet());                          // Arraylist met dobbelwaarden
		while (spelers.size() != playerRolls.keySet().size()) {								  // als het aantal spelers niet gelijk is aan het aantal verschillende keys (er zijn dus dubbele dobbelwaarden)
			for (Double key : keys) {															  // voor elke dobbelwaarde in de lijst van dobbelwaarden
				if(playerRolls.get(key).size()>1){												  // als het aantal spelers achter een bepaalde key (dobbelwaarde) meer dan 1 is
					List<Speler> players = new ArrayList<>(playerRolls.get(key));				  // list met alle spelers met dezelfde dobbelwaarde
					playerRolls.removeMapping(key,players);										  // verwijder spelers + dobbelwaarde uit originele lijst
					for (int player = 0; player < players.size(); player++) {					  // voor elke speler in de lijst van spelers (met zelfde key)
						playerRolls.put(														  // Voeg speler toe aan lijst met nieuwe dobbelwaarde
								(double) dice.rollDice() * divider + key,						  // deel nieuwe waarde door 10 (eerste herdobbel) en tel er originele waarde bij op
								players.get(player));
					}
				}
			}
			divider /= 10;
		}

		if (spelers.size()==playerRolls.keySet().size()){										  // Indien lijst allemaal verschillende dobbelwaarden bevat kan ze gesorteerd worden
			NavigableMap<Double,Collection<Speler>> sortedMap = new TreeMap<>(new Comparator<Double>() {
				@Override
				public int compare(Double o1, Double o2) {
					return o2.compareTo(o1);													  // CompareTo veranderen naar descending order (ipv ascending order)
				}
			});
			sortedMap.putAll(playerRolls.asMap());												  // alles van playerRolls in sortedMap steken (wordt dan automatisch gesorteerd)
			List<Collection<Speler>> sortedSpelers = new ArrayList<>(sortedMap.values());		  // Nieuwe list van collectie van spelers
			spelers.clear();                                                                      // Verwijder spelers uit lijst
			for (Collection<Speler> sortedSpeler : sortedSpelers) {								  // voeg elke speler uit de collectie toe aan speler lijst
				spelers.add(sortedSpeler.iterator().next());
			}
		}

		List<String> namen = new ArrayList<>();													  // maak een lijst met alleen de namen voor aan de spelers te tonen
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
    	spelbord.getTegels().get(speler.getPositie()).removeSpeler(speler);

    	if ((speler.getPositie()+rol)<=39){
    		speler.setPositie(speler.getPositie()+rol);
		} else {
    		speler.setPositie(rol-(39-speler.getPositie())-1);             	// indien som van positie + rol groter is dan 39 (einde van spelbord) dan zorgt dit ervoor dat positie
		}																	// na 39 terug naar 0 gaat en dan verder optelt

		spelbord.getTegels().get(speler.getPositie()).addSpeler(speler);
	}
}
