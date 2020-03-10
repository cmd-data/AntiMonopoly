package AntiMonopoly.Model;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ConcurrentenOfMonopolistenvak extends Tegel {

	Dice dice = new Dice();

	public ConcurrentenOfMonopolistenvak(String naam, int positie) {
		super(naam, positie);
	}

	private Opdrachten opdracht = new Opdrachten();

	/**
	 * Leest de opdracht voor
	 * Voert de opdracht uit
	 * En steekt de kaart onderaan het deck terug
	 * @param speler
	 */

	public void opdrachtMon(Speler speler){
		System.out.println(opdracht.getShuffledMon().getValue(opdracht.getShuffledMon().firstKey()));
		doeOpdrachtMonopolist(opdracht.getShuffledMon().firstKey(),speler);
		steekTerugMon();
	}

	public void opdrachtCon(Speler speler){
		System.out.println(opdracht.getShuffledCon().getValue(opdracht.getShuffledCon().firstKey()));
		doeOpdrachtConcurrent(opdracht.getShuffledCon().firstKey(),speler);
		steekTerugCon();
	}

	public void steekTerugMon() {
		List<Integer> keys = new ArrayList(opdracht.getShuffledMon().keySet());
		LinkedMap<Integer,String> rotatedMon = new LinkedMap<>();
		Collections.rotate(keys, -1);											/** .rotate methode en -1 zorgt ervoor dat eerste de laatste key wordt en alles opschuift */
		for (Integer i : keys){
			String value = opdracht.getShuffledMon().getValue(i);
			rotatedMon.put(i,value);													/** plaats de waarde voor index i uit originele lijst in nieuwe map */
		}
		opdracht.setShuffledMon(rotatedMon);
	}

	public void steekTerugCon() {
		List<Integer> keys = new ArrayList(opdracht.getShuffledCon().keySet());
		LinkedMap<Integer,String> rotatedCon = new LinkedMap<>();
		Collections.rotate(keys, -1);
		for (Integer i : keys){
			String value = opdracht.getShuffledCon().getValue(i);
			rotatedCon.put(i,value);
		}
		opdracht.setShuffledCon(rotatedCon);
	}

	public void doeOpdrachtMonopolist(int opdracht,Speler speler) {
		switch(opdracht){
			case 0:
				speler.setPositie(25);
				Spelbord.getTegels().get(25).addSpeler(speler);                          // Constructor aanpassen zodat de juiste tegel wordt meegegeven
				break;
			case 1: if(IntStream.of(Dice.rollDice()).sum()>=8){speler.setGeld(75000);} break;  // maakt som van gerolde dobbelstenen die in array zitten
			case 2:
			case 21:
			case 24:
				speler.setGeld(50000); break;
			case 3:
				speler.setPositie(12);
				Spelbord.getTegels().get(12).addSpeler(speler);
				break;
			case 4:
			case 5:
				speler.setPositie(0);
				Spelbord.getTegels().get(0).addSpeler(speler);
				break;
			case 6:
			case 14:
				speler.setGeld(-50000); break;
			case 7:
			case 16: break;
			case 8: speler.setGeld(-75000); break;
			case 9:
			case 15: speler.setGeld(-25000); break;
			case 10:
				speler.setPositie(39);
				Spelbord.getTegels().get(39).addSpeler(speler);
				break;
			case 11:
			case 12:
				speler.setGeld(25000); break;
			case 13:
			case 19:
				speler.setPositie(10);
				Spelbord.getTegels().get(10).addSpeler(speler);
				break;
			case 17:
				int count = 0;
				for (Speler spelers : Spel.getSpelers()){
					if (spelers.getIsConcurrent()){
						count++;
						spelers.setGeld(-10000);
					}
				}
				speler.setGeld(count*10000);
				break;
			case 18:
				for (Speler spelers : Spel.getSpelers()){
					if (!spelers.getIsConcurrent()){
						spelers.setGeld(25000);
					}
				}
				break;
			case 20: speler.setGeld(75000); break;
			case 22:
				int counter = 0;
				for (Speler spelers : Spel.getSpelers()){
					if (spelers.getIsConcurrent()){
						counter++;
						spelers.setGeld(-25000);
					}
				}
				speler.setGeld(counter*25000);
				break;
			case 23:
				speler.setPositie(31);
				Spelbord.getTegels().get(31).addSpeler(speler);
		}
	}

	public void doeOpdrachtConcurrent(int opdracht, Speler speler){
		switch(opdracht){
			case 0:
			case 23:
				speler.setGeld(75000); break;
			case 1:
			case 13:
				speler.setPositie(10);
				Spelbord.getTegels().get(10).addSpeler(speler);
				break;
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
				speler.setPositie(25);
				Spelbord.getTegels().get(25).addSpeler(speler);
				break;
			case 17:
			case 18:
				speler.setPositie(0);
				Spelbord.getTegels().get(0).addSpeler(speler);
				break;
			case 19:
				speler.setPositie(37);
				Spelbord.getTegels().get(0).addSpeler(speler);
				break;
			case 20:
				speler.setPositie(28);
				Spelbord.getTegels().get(28).addSpeler(speler);
				break;
			case 22:
				speler.setPositie(6);
				Spelbord.getTegels().get(6).addSpeler(speler);
		}
	}
}