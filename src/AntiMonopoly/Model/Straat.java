package AntiMonopoly.Model;

import java.util.*;

public class Straat extends Tegel {

	private String straten, stad;
	private int prijs, huur, hypotheek, prijsHuis, aantalGebouwen, positie;
	private Speler eigenaar;
	private final int MAXHOTEL = 1;
	private final int MAXHUISMON = 3;
	private final int MAXHUISCON = 4;
	private Gebouwen gebouw;

	/**
	 * Standaard constructor voor 'isKoopbaar' methode in Tegel
	 */

	public Straat(String straat, int prijs, int huur, int hypotheek, int prijsHuis, Speler eigenaar, Gebouwen gebouw, int aantalGebouwen, String stad, int positie) {
		super(straat,positie);
		this.straten = straat;
		this.prijs = prijs;
		this.huur = huur;
		this.hypotheek = hypotheek;
		this.prijsHuis = prijsHuis;
		this.eigenaar = eigenaar;
		this.gebouw = gebouw;
		this.aantalGebouwen = aantalGebouwen;
		this.stad = stad;
		this.positie = positie;
	}

	public static boolean isBebouwd(Straat straat){
		try {
			return straat.gebouw != null;
		} catch (NullPointerException ignored) {}
		return false;
	}

	public static boolean hasHotel(Straat straat){
		try {
			return Gebouwen.Hotel.class.equals(straat.gebouw.getClass());
		} catch (NullPointerException ignored){}
		return false;
	}

	public static boolean hasHouse(Straat straat){
		try {
			return Gebouwen.Huis.class.equals(straat.gebouw.getClass());
		} catch (NullPointerException ignored){}
		return false;
	}

	public static void koopStraat(Speler speler, Straat straat){

		if (speler.getGeld()<straat.prijs){
			System.out.println("Niet genoeg geld");
		} else {
			speler.setGeld(-straat.prijs);
			straat.setEigenaar(speler);
		}
	}

	public static int getHuur(Straat straat) {
		boolean concurrent = straat.eigenaar.getIsConcurrent();
		
		if (!isBebouwd(straat)) {
			if (concurrent){
				return straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)){
					return straat.huur * 2;
				} else {
					return straat.huur;
				}
			}
		}

		if (hasHouse(straat)) {
			if (concurrent) {
				return straat.prijsHuis / 10 * straat.aantalGebouwen + straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)){
					return (straat.prijsHuis / 5 * straat.aantalGebouwen + straat.huur)*2;
				} else {
					return straat.prijsHuis / 5 * straat.aantalGebouwen + straat.huur;
				}
			}
		}

		if (hasHotel(straat)) {
			if (concurrent) {
				return straat.prijsHuis / 10 * 5 + straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)) {
					return (straat.prijsHuis / 2 * 4 + straat.huur) *2;
				} else {
					return straat.prijsHuis / 2 * 4 + straat.huur;
				}
			}
		}
		return 0;
	}

	public static boolean isMonopolyStad(String stad) {
		List<Straat> straten = new ArrayList<>();
		Set<Speler> eigenaars = new HashSet<>();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof Straat && stad.equals(((Straat) tegel).stad)){
				straten.add((Straat)tegel);
			}
		}

		for (Straat straat : straten) {
			eigenaars.add(straat.eigenaar);
		}

		return straten.size() > eigenaars.size();
	}

	public String getStraat() { return straten; }

	public int getPrijs() { return this.prijs; }

	public int getHypotheek() { return this.hypotheek; }

	public int getPrijsHuis() { return prijsHuis; }

	public Speler getEigenaar() { return this.eigenaar; }

	public void setEigenaar(Speler eigenaar) { this.eigenaar = eigenaar; }

	public int getMaxHotel() { return MAXHOTEL; }

	public int getMaxHuisMon() { return MAXHUISMON; }

	public int getMaxHuisCon() { return MAXHUISCON; }

	public Gebouwen getGebouw()
	{
		return this.gebouw;
	}

	public void setGebouw(Gebouwen gebouw) { this.gebouw = gebouw; }

	public int getAantalGebouwen() { return aantalGebouwen; }

	public void setAantalGebouwen(int aantalGebouwen) {
		this.aantalGebouwen = aantalGebouwen;
	}

	public String getStad() { return this.stad; }



}