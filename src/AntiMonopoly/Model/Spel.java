package AntiMonopoly.Model;

import AntiMonopoly.View.DrieSpelers.DrieSpelersView;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.StartScreen.StartView;
import AntiMonopoly.View.TweeSpelers.TweeSpelersView;
import AntiMonopoly.View.VierSpelers.VierSpelersView;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Spel {

	private LocalDateTime startTijd, eindTijd;
	private static List<Speler> spelers = new ArrayList<>();
	private Spelbord spelbord = new Spelbord();
	private Spelregels spelregels = new Spelregels();
	private static MultiValuedMap<Tegel,Speler> posities = new ArrayListValuedHashMap<>();

	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		maakSpelers();
		//posities.putAll(Spelbord.getTegels().get(0),spelers);     // elke speler op start positie plaatsen (mag geen passeer start generereren)
	}

	public Spel(){}  // Constructor voor eenvoudig te kunnen testen in main

	/**
	 * Vereisten aantal concurrenten en monopolisten nog toevoegen
	 */

	public static void maakSpelers () {
		boolean speler1 = false, speler2 = false, speler3 = false, speler4 = false;

		String aantalSpelers = StartView.getAs2().getSelectionModel().getSelectedItem();
		switch (aantalSpelers){

			case "2":
				if ("Concurrent".equals(TweeSpelersView.getTs6().getSelectionModel().getSelectedItem())){
					speler1 = true;
				}
				if ("Concurrent".equals(TweeSpelersView.getTs7().getSelectionModel().getSelectedItem())){
					speler2 = true;
				}
				spelers.add(new Speler(TweeSpelersView.getTs4().getText(), speler1 , MainMetPionView.getRectangle1()));
				spelers.add(new Speler(TweeSpelersView.getTs5().getText(), speler2, MainMetPionView.getRectangle2()));
			case "3":
				if ("Concurrent".equals(DrieSpelersView.getDs8().getSelectionModel().getSelectedItem())){
					speler1 = true;
				}
				if ("Concurrent".equals(DrieSpelersView.getDs9().getSelectionModel().getSelectedItem())){
					speler2 = true;
				}
				if ("Concurrent".equals(DrieSpelersView.getDs10().getSelectionModel().getSelectedItem())){
					speler3 = true;
				}
				spelers.add(new Speler(DrieSpelersView.getDs5().getText(), speler1 , MainMetPionView.getRectangle1()));
				spelers.add(new Speler(DrieSpelersView.getDs6().getText(), speler2, MainMetPionView.getRectangle2()));
				spelers.add(new Speler(DrieSpelersView.getDs7().getText(), speler3, MainMetPionView.getRectangle3()));
			case "4":
				if ("Concurrent".equals(VierSpelersView.getVs10().getSelectionModel().getSelectedItem())){
					speler1 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs11().getSelectionModel().getSelectedItem())){
					speler2 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs12().getSelectionModel().getSelectedItem())){
					speler3 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs13().getSelectionModel().getSelectedItem())){
					speler4 = true;
				}
				spelers.add(new Speler(VierSpelersView.getVs6().getText(), speler1 , MainMetPionView.getRectangle1()));
				spelers.add(new Speler(VierSpelersView.getVs7().getText(), speler2, MainMetPionView.getRectangle2()));
				spelers.add(new Speler(VierSpelersView.getVs8().getText(), speler3, MainMetPionView.getRectangle3()));
				spelers.add(new Speler(VierSpelersView.getVs9().getText(), speler4, MainMetPionView.getRectangle4()));
		}



		Collections.shuffle(spelers);                    // spelers worden direct na creatie geshuffeld

		/*Scanner kb = new Scanner(System.in);
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
		kb.close();*/
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
	 * Geeft Tegel terug als waarde om dan in isKoopbaar(); heeftEigenaar() en heeftHypotheek() te gebruiken
	 * @param speler
	 * @return
	 */

	public static Tegel move(Speler speler, int worp){
		int positie = 0;

		for (Map.Entry<Tegel, Speler> entry : posities.entries()) {
			if (speler.equals(entry.getValue())) {
				if (entry.getKey().getPositie() + worp > 39){
					positie = worp - (39-entry.getKey().getPositie()) -1;
				} else {
					positie = entry.getKey().getPositie() + worp;
				}
			}
		}

		checkPasseerStart(speler,Spelbord.getTegels().get(positie));
		posities.values().remove(speler);
    	posities.put(Spelbord.getTegels().get(positie),speler);
    	return Spelbord.getTegels().get(positie);
	}

	public static Tegel move(Speler speler, Tegel tegel){
		posities.values().remove(speler);
		posities.put(tegel,speler);
		return tegel;
	}

	/**
	 * Static voor gebruik in statische methode move()
	 * @param speler
	 * @param tegel
	 */

	public static void checkPasseerStart(Speler speler, Tegel tegel) {
		for (Map.Entry<Tegel, Speler> entry : posities.entries()) {
			if (speler.equals(entry.getValue())) {
				if(tegel.getPositie() < entry.getKey().getPositie() && 30 != tegel.getPositie()) {
					speler.setGeld(200000);
				}
			}
		}
	}

	public static Boolean checkGevangenis(Speler speler){
		return Gevangenis.getGevangenen().contains(speler);
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

	//public static MultiValuedMap<Tegel, Speler> getPosities() { return posities; }
}
