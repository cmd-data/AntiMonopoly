package AntiMonopoly.Model;

import AntiMonopoly.View.DrieSpelers.DrieSpelersView;
import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainView;
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
	static int positie;

	public Spel(LocalDateTime startTijd) {
		this.startTijd = startTijd;
		posities.putAll(Spelbord.getTegels().get(0),spelers);                    // elke speler op start positie plaatsen (mag geen passeer start genereren)
	}

	public static void updateAanZet(){

		switch (Dice.getCount()){
			case 1:
				MainView.getSpeler1().setStyle(MainView.getAanZetlayout());
				MainView.getSpeler2().setStyle("-fx-border-color: black");
				MainView.getSpeler3().setStyle("-fx-border-color: black");
				MainView.getSpeler4().setStyle("-fx-border-color: black");
				break;
			case 2:
				MainView.getSpeler1().setStyle("-fx-border-color: black");
				MainView.getSpeler2().setStyle(MainView.getAanZetlayout());
				MainView.getSpeler3().setStyle("-fx-border-color: black");
				MainView.getSpeler4().setStyle("-fx-border-color: black");
				break;
			case 3:
				MainView.getSpeler1().setStyle("-fx-border-color: black");
				MainView.getSpeler2().setStyle("-fx-border-color: black");
				MainView.getSpeler3().setStyle(MainView.getAanZetlayout());
				MainView.getSpeler4().setStyle("-fx-border-color: black");
				break;
			case 4:
				MainView.getSpeler1().setStyle("-fx-border-color: black");
				MainView.getSpeler2().setStyle("-fx-border-color: black");
				MainView.getSpeler3().setStyle("-fx-border-color: black");
				MainView.getSpeler4().setStyle(MainView.getAanZetlayout());
		}
	}

	public static void updateGeld(){
		MainView.getS12().setText("€ " + spelers.get(0).getGeld());
		MainView.getS22().setText("€ " + spelers.get(1).getGeld());
		if (spelers.size()==3) {
			MainView.getS32().setText("€ " + spelers.get(2).getGeld());
		}
		if (spelers.size()==4) {
			MainView.getS32().setText("€ " + spelers.get(2).getGeld());
			MainView.getS42().setText("€ " + spelers.get(3).getGeld());
		}
	}

	/**
	 * Vereisten aantal concurrenten en monopolisten nog toevoegen
	 */

	public static void maakSpelers () {
		boolean speler1 = false, speler2 = false, speler3 = false, speler4 = false;

		String aantalSpelers = StartView.getAs2().getSelectionModel().getSelectedItem();
		switch (aantalSpelers) {

			case "2":
				if ("Concurrent".equals(TweeSpelersView.getTs6().getSelectionModel().getSelectedItem())) {
					speler1 = true;
				}
				if ("Concurrent".equals(TweeSpelersView.getTs7().getSelectionModel().getSelectedItem())) {
					speler2 = true;
				}
				spelers.add(new Speler(TweeSpelersView.getTs4().getText(), speler1, MainMetPionView.getRectangle2(), "grey square"));
				spelers.add(new Speler(TweeSpelersView.getTs5().getText(), speler2, MainMetPionView.getRectangle1(), "pink square"));
				break;
			case "3":
				if ("Concurrent".equals(DrieSpelersView.getDs8().getSelectionModel().getSelectedItem())) {
					speler1 = true;
				}
				if ("Concurrent".equals(DrieSpelersView.getDs9().getSelectionModel().getSelectedItem())) {
					speler2 = true;
				}
				if ("Concurrent".equals(DrieSpelersView.getDs10().getSelectionModel().getSelectedItem())) {
					speler3 = true;
				}
				spelers.add(new Speler(DrieSpelersView.getDs5().getText(), speler1, MainMetPionView.getRectangle2(), "grey square"));
				spelers.add(new Speler(DrieSpelersView.getDs6().getText(), speler2, MainMetPionView.getRectangle1(), "pink square"));
				spelers.add(new Speler(DrieSpelersView.getDs7().getText(), speler3, MainMetPionView.getRectangle4(), "red square"));
				break;
			case "4":
				if ("Concurrent".equals(VierSpelersView.getVs10().getSelectionModel().getSelectedItem())) {
					speler1 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs11().getSelectionModel().getSelectedItem())) {
					speler2 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs12().getSelectionModel().getSelectedItem())) {
					speler3 = true;
				}
				if ("Concurrent".equals(VierSpelersView.getVs13().getSelectionModel().getSelectedItem())) {
					speler4 = true;
				}
				spelers.add(new Speler(VierSpelersView.getVs6().getText(), speler1, MainMetPionView.getRectangle2(), "grey square"));
				spelers.add(new Speler(VierSpelersView.getVs7().getText(), speler2, MainMetPionView.getRectangle1(), "pink square"));
				spelers.add(new Speler(VierSpelersView.getVs8().getText(), speler3, MainMetPionView.getRectangle4(), "red square"));
				spelers.add(new Speler(VierSpelersView.getVs9().getText(), speler4, MainMetPionView.getRectangle3(), "white square"));
				break;
		}

		Collections.shuffle(spelers);                    // spelers worden direct na creatie geshuffeld
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

		try {
			for (Map.Entry<Tegel, Speler> entry : posities.entries()) {
				if (entry.getValue().equals(speler)) {
					if (entry.getKey().getPositie() + worp > 39) {
						positie = worp - (39 - entry.getKey().getPositie()) - 1;
					} else {
						positie = entry.getKey().getPositie() + worp;
					}
				}
			}
		} catch (NullPointerException ignored) {}

		checkPasseerStart(speler,Spelbord.getTegels().get(positie));
		posities.values().remove(speler);
    	posities.put(Spelbord.getTegels().get(positie),speler);
    	return Spelbord.getTegels().get(positie);
	}

	public static Tegel move(Speler speler, Tegel tegel){
		checkPasseerStart(speler,tegel);
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

		try {
			for (Map.Entry<Tegel, Speler> entry : posities.entries()) {
				if (entry.getValue().equals(speler)) {
					if (tegel.getPositie() < entry.getKey().getPositie() && 30 != tegel.getPositie()) {
						speler.setGeld(200000);
						updateGeld();
					}
				}
			}
		} catch (NullPointerException ignored) {}
	}

	public static Boolean checkGevangenis(Speler speler){
		return Gevangenis.getGevangenen().contains(speler);
	}

	public static boolean eindeSpel(){
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
