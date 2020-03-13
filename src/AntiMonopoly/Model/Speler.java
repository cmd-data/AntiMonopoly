package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Speler {


	private String naam;
	private int geld = 1500000;
	private boolean isConcurrent;
	private boolean aanZet;
	private boolean failliet;
	private String pion;

	public Speler(String naam, boolean isConcurrent, String pion) {
		this.naam = naam;
		this.isConcurrent = isConcurrent;
		this.pion = pion;
	}

	public Speler() {	}

	public boolean isAanZet() {
		return aanZet;
	}//einde Methode

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

	public String getPion() { return pion; }
}
