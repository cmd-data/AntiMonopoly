package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speler {


	private String naam;				//naam speler
	private static int geld = 1500000;			//hoeveelheid geld de speler bezit, aan het begin van het spel is dit steeds hetzelfde,
										// dus moet niet als parameter in de constructor worden toegevoegd
	private static boolean isConcurrent;		//Is de speler een concurent?
	/**
	 *i.p.v. concurent en monopolist toe te voegen als aparte klasse, meegeven aan de constructor als boolean
	 */
	private int positie = 0; 			//Is de positie van de speler
	/**
	 *Klasse Pion kan vervangen worden door de speler een positie te geven
	 */
	private boolean aanZet;				//kijken of de speler aan zet is
	private static boolean failliet;			//checken of de speler failliet is
	private int count = 0;
	private boolean isDubbel; 	// true of false bijhouden als speler dubbel gegooid heeft


	/**
	 *CONSTRUCTORS
	 */

	/**
	 *constructor die aangeeft wie concurent is en wie monopolist
	 * Slechts één constructor
	 * In de main methode dient er een counter te zitten die er op toeziet of er niet meer dan 4 spelers gecreëerd worden.
	 * Niet in de constructor (Opmerking Tasha ==> ik zou dit dus wel in de constructor steken?)
	 */
	public Speler(String naam, boolean isConcurrent) {
		this.naam = naam;
		Speler.isConcurrent = isConcurrent;
		this.count++;
	}//einde constructor

	/**
	 *default constructor
	 */
	public Speler() {	}
	//einde constructor

	/**
	 *METHODEN
	 */

	/**
	 *Methode om spelersnaam op te vragen
	 */
	public String getNaam() {
		return naam;
	}//einde Methode


	/**
	 *Methode om de hoeveelheid geld dat een speler bezit op te vragen
	 */
	public int getGeld() {
		return geld;
	}//einde Methode

	/**
	 *Methode om speler geld te laten betalen
	 */
	public static void setGeld(int veranderGeld) {
		geld += veranderGeld;
	}
	//einde Methode

	/**
	 *Methode om te bepalen of de speler een concurent is
	 * (Opmerking Tasha ==> methode is overbodig aangezien je de isConcurrent waarde meegeeft aan de constructor, doorheen het spel kan/mag dit niet veranderen)
	 */
	/* public void setConcurrent(boolean concurrent) {
		isConcurrent = concurrent;
	}//einde Methode */

	/**
	 *Methode om te checken of de speler een concurent is
	 */
	public static boolean getIsConcurrent() {
		return isConcurrent;
	}//einde Methode

	/**
	 * Methode in relatie gebracht met Dice. Extra argument speler toegevoegd zodat we de juiste positie aanpassen (moet nog getest worden om te zien of het zo werkt)
	 * @param speler
	 */
	public void setPositie(int positie, Speler speler) {
		speler.positie = positie;
	}
	public void setPositie(Speler speler) {
		speler.positie += Dice.rollDice();
	}
	//einde Methode

	/**
	 *Methode om te kijken of de speler aan zet is
	 */
	public boolean isAanZet() {
		return aanZet;
	}//einde Methode

	/**
	 *Methode om de speler al dan niet aan zet te laten
	 */
	public void setAanZet(boolean aanZet) {
		this.aanZet = aanZet;
	}//einde Methode

	/**
	 *Methode om te checken of de speler failliet is
	 */
	public static boolean isFailliet(Speler speler) {
		if(Speler.geld == 0 && checkBezittingen(speler) == 0) {
			failliet = true;
			return true;
		} else {
			failliet = false;
			return false;
		}
	}//einde Methode

	/**
	 *Methode om de speler €200 te geven wanneer hij startgeld krijgt
	 * Als de speler voorbij start komt, verlaagd zijn positie.
	 * Wanneer de speler op 'ga naar de gevangenis' komt, verlaagd zijn positie ook, dus deze postie(30), moet hiervan uitgesloten worden
	 */
	public void checkPasseerStart(int positie) {
		if(this.positie < positie && positie != 30) {
			geld += 200000;
		}
	}//einde Methode
	
	public static int checkBezittingen (Speler speler) {
		List<String> eigenaars = new ArrayList<>();
		for (int i = 0; i < Stad.getStraten().size(); i++) {
			eigenaars.add(Stad.getStraten().get(i).getEigenaar().getNaam());
			/**
			 * Alle eigenaars in een lijst gestoken om dan te kijken of de speler nog eigendommen heeft
			 */
		}
		for (int j = 0; j < Transport.getTransport().size(); j++) {
			eigenaars.add(Transport.getTransport().get(j).getNaam());
		}
		return Collections.frequency(eigenaars, speler.getNaam());

		/**
		Om de bezittingen te checken, zou er door de stratenlijst gegaan moeten worden en elke keer de eigenaar "speler" is, de waarde van de grond + de waarde van de huizen op de straat op tellen.
		 Dit kunnen we gebruiken om te checken of iemand failliet is en bij de inkomstenbelasting.

		 (Opm. Tasha ==> Ik ga die methoden opsplitsen want voor 'isFailliet' moeten we alleen weten of hij bezittingen heeft, de waarde van de grond of huizen doen er niet toe)
		 */
	}

	/**
	 * Methode om de totale waarde van de bezittingen op te tellen, inclusief het uitsluiten van straten op hypotheek
	 * Ook transportbedrijven worden op eigenaar gecontroleerd
	 * Dit kan hopelijk ook nog eenvoudiger...
	 * @param speler
	 * @return
	 */

	public int waardeBezittingen (Speler speler) {
		int waarde = 0;
		for (int i = 0; i < Stad.getStraten().size(); i++) {
			if(Stad.getStraten().get(i).getEigenaar().equals(speler)&&!Hypotheek.getHypotheekLijst().contains(Stad.getStraten().get(i))){
				waarde += Stad.getStraten().get(i).getPrijs();
				if(Stad.getStraten().get(i).getGebouw().getClass().equals(Gebouwen.Huis.class)){
					waarde += Stad.getStraten().get(i).getPrijsHuis()*Stad.getStraten().get(i).getAantalGebouwen();
				}
				if(Stad.getStraten().get(i).getGebouw().getClass().equals(Gebouwen.Hotel.class)){
					if(speler.isConcurrent){
						waarde += Stad.getStraten().get(i).getPrijsHuis()*5;
					}
					if(!speler.isConcurrent){
						waarde += Stad.getStraten().get(i).getPrijsHuis()*4;
					}
				}
			}
		}

		for (int j = 0; j < Transport.getTransport().size(); j++) {
			if(Transport.getTransport().get(j).getEigenaar().equals(speler)){
				waarde += Transport.getWaarde();
			}
		}
		return waarde;
	}




}
