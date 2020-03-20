package AntiMonopoly.Model;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Speler {


	private String naam;
	private int geld = 1500000;
	private boolean isConcurrent;
	private boolean failliet;
	private String pion;
	private Rectangle rectangle;

	public Speler(String naam, boolean isConcurrent, Rectangle rectangle, String pion) {
		this.naam = naam;
		this.isConcurrent = isConcurrent;
		this.pion = pion;
		this.rectangle = rectangle;
	}

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
	 * hoeveel eigendommen heeft de speler?
	 * @param speler
	 * @return
	 */

	public int checkBezittingen (Speler speler) {
		List<Speler> eigenaars = new ArrayList<>();
		for (int i = 0; i < Stad.getStraat().size(); i++) {
			eigenaars.add(Stad.getStraat().get(i).getEigenaar());
		}
		for (int j = 0; j < Transport.getTransport().size(); j++) {
			eigenaars.add(Transport.getTransport().get(j).getEigenaar());
		}
		for (int k = 0; k < GasEnElektriciteitsbedrijf.getBedrijven().size(); k++){
			eigenaars.add(GasEnElektriciteitsbedrijf.getBedrijven().get(k).getEigenaar());
		}
		return Collections.frequency(eigenaars, speler);
	}

	/**
	 * NullPointerException lijn 70
	 */

	public int waardeBezittingen (Speler speler) {
		int waarde = 0;
		try {
			for (int i = 0; i < Stad.getStraat().size(); i++) {  // OutOfMemoryError??
				if (speler.equals(Stad.getStraat().get(i).getEigenaar()) && !Hypotheek.getHypotheekLijst().contains(Stad.getStraat().get(i))) {
					waarde += Stad.getStraat().get(i).getPrijs();
					if (Stad.getStraat().get(i).getGebouw().getClass().equals(Gebouwen.Huis.class)) {
						waarde += Stad.getStraat().get(i).getPrijsHuis() * Stad.getStraat().get(i).getAantalGebouwen();
					}
					if (Stad.getStraat().get(i).getGebouw().getClass().equals(Gebouwen.Hotel.class)) {
						if (speler.isConcurrent) {
							waarde += Stad.getStraat().get(i).getPrijsHuis() * 5;
						}
						if (!speler.isConcurrent) {
							waarde += Stad.getStraat().get(i).getPrijsHuis() * 4;
						}
					}
				}
			}
		} catch (NullPointerException ignored){}

		for (int j = 0; j < Transport.getTransport().size(); j++) {
			if(speler.equals(Transport.getTransport().get(j).getEigenaar())){
				waarde += Transport.getWaarde();
			}
		}

		for (int k = 0; k < GasEnElektriciteitsbedrijf.getBedrijven().size(); k++) {
			if(speler.equals(GasEnElektriciteitsbedrijf.getBedrijven().get(k).getEigenaar()));
			waarde += GasEnElektriciteitsbedrijf.getWaarde();
		}
		return waarde;
	}

	/**
	 * wat zijn de eigendommen van de speler?
	 * @param speler
	 * @return
	 */

	public static List<String> eigendommen (Speler speler){
		List<String> spelerEigendommen = new ArrayList<>();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (Objects.equals(Tegel.eigenaar(tegel), speler.getNaam())){
				spelerEigendommen.add(tegel.getNaam());
			}
		}
		return spelerEigendommen;
	}

	/**
	 * welke eigendommen van de speler zijn er bebouwd?
	 * @param speler
	 * @return
	 */

	public static List<String> bebouwdeEigendommen (Speler speler) {
		List<String> spelerEigendommen = new ArrayList<>();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof Straat) {
				if (Objects.equals(Tegel.eigenaar(tegel), speler.getNaam()) && Straat.isBebouwd((Straat) tegel)) {
					spelerEigendommen.add(tegel.getNaam());
				}
			}
		}
		return spelerEigendommen;

	}

	public String getNaam() { return naam; }

	public int getGeld() { return geld; }

	public void setGeld(int veranderGeld) { geld += veranderGeld; }

	public boolean getIsConcurrent() { return isConcurrent; }

	public String getPion() { return pion; }

	public Rectangle getRectangle() { return rectangle; }
}
