package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speler {


	private String naam;				//naam speler
	private int geld = 1500000;			//hoeveelheid geld de speler bezit, aan het begin van het spel is dit steeds hetzelfde,
										// dus moet niet als parameter in de constructor worden toegevoegd
	private boolean isConcurrent;		//Is de speler een concurent?
	/**
	 *i.p.v. concurent en monopolist toe te voegen als aparte klasse, meegeven aan de constructor als boolean
	 */
	private int positie = 0; 			//Is de positie van de speler
	/**
	 *Klasse Pion kan vervangen worden door de speler een positie te geven
	 */
	private boolean aanZet;				//kijken of de speler aan zet is
	private boolean failliet;			//checken of de speler failliet is
	private int count = 0;
	private boolean isDubbel; 	        // true of false bijhouden als speler dubbel gegooid heeft
	private String pion;

	public Speler(String naam, boolean isConcurrent, String pion) {
		this.naam = naam;
		this.isConcurrent = isConcurrent;
		this.count++;
		this.pion = pion;
	}

	public Speler() {	}

	public String getNaam() {
		return naam;
	}//einde Methode

	public int getGeld() {
		return geld;
	}//einde Methode

	public void setGeld(int veranderGeld) {
		geld += veranderGeld;
	}

	public boolean getIsConcurrent() {
		return isConcurrent;
	}//einde Methode

	public void setPositie(int positie) {
		this.positie = positie;
	}

	public int getPositie() {
		return positie;
	}

	public boolean isAanZet() {
		return aanZet;
	}//einde Methode

	/**
	 *Methode om de speler al dan niet aan zet te laten
	 */
	public void setAanZet(boolean aanZet) {
		this.aanZet = aanZet;
	}//einde Methode

	public boolean isFailliet(Speler speler) {
		if(speler.geld == 0 && checkBezittingen(speler) == 0) {
			failliet = true;
			return true;
		} else {
			failliet = false;
			return false;
		}
	}

	/**
	 *Methode om de speler €200 te geven wanneer hij startgeld krijgt
	 * Als de speler voorbij start komt, verlaagd zijn positie.
	 * Wanneer de speler op 'ga naar de gevangenis' komt, verlaagd zijn positie ook, dus deze postie(30), moet hiervan uitgesloten worden
	 */
	public void checkPasseerStart(int positie) {
		if(this.positie < positie && positie != 30) {
			geld += 200000;
		}
	}

	public int checkBezittingen (Speler speler) {
		List<String> eigenaars = new ArrayList<>();
		for (int i = 0; i < Stad.getStraat().size(); i++) {
			eigenaars.add(Stad.getStraat().get(i).getEigenaar().getNaam());
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
		for (int i = 0; i < Stad.getStraat().size(); i++) {
			if(Stad.getStraat().get(i).getEigenaar().equals(speler)&&!Hypotheek.getHypotheekLijst().contains(Stad.getStraat().get(i))){
				waarde += Stad.getStraat().get(i).getPrijs();
				if(Stad.getStraat().get(i).getGebouw().getClass().equals(Gebouwen.Huis.class)){
					waarde += Stad.getStraat().get(i).getPrijsHuis()*Stad.getStraat().get(i).getAantalGebouwen();
				}
				if(Stad.getStraat().get(i).getGebouw().getClass().equals(Gebouwen.Hotel.class)){
					if(speler.isConcurrent){
						waarde += Stad.getStraat().get(i).getPrijsHuis()*5;
					}
					if(!speler.isConcurrent){
						waarde += Stad.getStraat().get(i).getPrijsHuis()*4;
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
