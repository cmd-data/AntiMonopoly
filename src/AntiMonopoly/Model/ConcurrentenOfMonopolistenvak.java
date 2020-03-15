package AntiMonopoly.Model;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class ConcurrentenOfMonopolistenvak extends Tegel {

	Dice dice = new Dice();

	public ConcurrentenOfMonopolistenvak(String naam, int positie) {
		super(naam, positie);
	}

	private static Opdrachten opdrachten = new Opdrachten();

	/**
	 * Leest de opdracht voor
	 * Voert de opdracht uit
	 * En steekt de kaart onderaan het deck terug
	 * @param speler
	 */

	public static String zieKaart (Speler speler){											// activeren met 'trek kaart'

		if (speler.getIsConcurrent()){
			return Opdrachten.concurrenten.getValue(Opdrachten.shuffledCon.firstKey());
		} else {
			return Opdrachten.monopolisten.getValue(Opdrachten.shuffledMon.firstKey());
		}
	}

	public static void voerUit(Speler speler){												// activeren met knop 'OK' op de kaart

		if (speler.getIsConcurrent()){

			doeOpdrachtConcurrent(Opdrachten.shuffledCon.firstKey(),speler);
			steekTerugCon();
		} else {

			doeOpdrachtMonopolist(Opdrachten.shuffledMon.firstKey(),speler);
			steekTerugMon();
		}
	}

	public static void steekTerugMon() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.shuffledMon.keySet());
		LinkedMap<Integer,String> rotatedMon = new LinkedMap<>();
		Collections.rotate(keys, -1);											/** .rotate methode en -1 zorgt ervoor dat eerste de laatste key wordt en alles opschuift */
		for (Integer i : keys){
			String value = Opdrachten.monopolisten.getValue(i);
			rotatedMon.put(i,value);													/** plaats de waarde voor index i uit originele lijst in nieuwe map */
		}
		Opdrachten.setShuffledMon(rotatedMon);
	}

	public static void steekTerugCon() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.shuffledCon.keySet());
		LinkedMap<Integer,String> rotatedCon = new LinkedMap<>();
		Collections.rotate(keys, -1);
		for (Integer i : keys){
			String value = Opdrachten.concurrenten.getValue(i);
			rotatedCon.put(i,value);
		}
		Opdrachten.setShuffledCon(rotatedCon);
	}

	/**
	 * Alle move methoden nog linken met pion op spelbord (zowel voor monopolist als concurrent)
	 * @param opdracht
	 * @param speler
	 * @return
	 */

	public static Tegel doeOpdrachtMonopolist(int opdracht,Speler speler) {
		switch (opdracht) {
			case 0:
				return Spel.move(speler, Spelbord.getTegels().get(25));
			case 1:
				if (IntStream.of(Dice.rollDice()).sum() >= 8) {             // maakt som van gerolde dobbelstenen die in array zitten
					speler.setGeld(75000);
				}
				break;
			case 2:																// -25000 ??
			case 21:
			case 24:
				speler.setGeld(50000);
				break;
			case 3:
				return Spel.move(speler, Spelbord.getTegels().get(12));
			case 4:
			case 5:
				return Spel.move(speler, Spelbord.getTegels().get(0));
			case 6:
			case 14:
				speler.setGeld(-50000);
				break;
			case 7:
			case 16:
				break;
			case 8:
				speler.setGeld(-75000);											// doet niets ??
				break;
			case 9:
			case 15:
				speler.setGeld(-25000);											// + 50000 ??
				break;
			case 10:
				return Spel.move(speler, Spelbord.getTegels().get(39));
			case 11:
			case 12:
				speler.setGeld(25000);
				break;
			case 13:
			case 19: GaNaarGevangenis.gaNaarGevangenis(speler); break;
			case 17:
				int count = 0;
				for (Speler spelers : Spel.getSpelers()) {
					if (spelers.getIsConcurrent()) {
						count++;
						spelers.setGeld(-10000);
					}
				}
				speler.setGeld(count * 10000);
				break;
			case 18:
				for (Speler spelers : Spel.getSpelers()) {
					if (!spelers.getIsConcurrent()) {
						spelers.setGeld(25000);
					}
				}
				break;
			case 20:
				speler.setGeld(75000);									// doet niets (geen geld erbij of weg)??
				break;
			case 22:
				int counter = 0;
				for (Speler spelers : Spel.getSpelers()) {
					if (spelers.getIsConcurrent()) {
						counter++;
						spelers.setGeld(-25000);
					}
				}
				speler.setGeld(counter * 25000);
				break;
			case 23:
				return Spel.move(speler, Spelbord.getTegels().get(31)); // -25000 na deze methode??
		}
		return null;
	}

	public static Tegel doeOpdrachtConcurrent(int opdracht, Speler speler){
		switch(opdracht){
			case 0:
			case 23:
				speler.setGeld(75000); break;
			case 1:
			case 13: GaNaarGevangenis.gaNaarGevangenis(speler); break;
			case 2:
			case 14:
				speler.setGeld(-75000); break;
			case 3:
				int counter = 0;
				for (Speler spelers : Spel.getSpelers()){
					if (spelers.getIsConcurrent()){
						counter++;
						spelers.setGeld(10000);
					}
				}
				speler.setGeld(counter*-10000);
				break;
			case 4:
			case 9: break;
			case 5:
			case 7:
			case 11:
				speler.setGeld(50000); break;
			case 6:
			case 24:
				speler.setGeld(25000); break;
			case 8: if(IntStream.of(Dice.rollDice()).sum()>=9){speler.setGeld(75000);}break;
			case 10:
			case 21:
				speler.setGeld(-50000); break;
			case 12:
				int count = 0;
				for (Speler spelers : Spel.getSpelers()){
					if (!spelers.getIsConcurrent()){
						count++;
						spelers.setGeld(-25000);
					}
				}
				speler.setGeld(count*25000);
				break;
			case 15: speler.setGeld(-25000); break;
			case 16:
				return Spel.move(speler,Spelbord.getTegels().get(25));
			case 17:
			case 18:
				return Spel.move(speler,Spelbord.getTegels().get(0));
			case 19:
				return Spel.move(speler,Spelbord.getTegels().get(37));
			case 20:
				return Spel.move(speler,Spelbord.getTegels().get(28));
			case 22:
				return Spel.move(speler,Spelbord.getTegels().get(6));
		}
		return null;
	}
}