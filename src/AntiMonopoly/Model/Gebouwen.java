package AntiMonopoly.Model;

public class Gebouwen {

	public static class Hotel extends Gebouwen {
		private int hotel = 0;
		public Hotel() { super(); }

		public static void verkoopHotel(Straat straat, int aantal, Speler speler){					// eerst checken of dat de speler een concurrent is of niet, dan aantal huizen aanpassen
			if(speler.getIsConcurrent()){
				straat.setAantalGebouwen(4);
			} else {straat.setAantalGebouwen(3);}
		}
	}

	public static class Huis extends Gebouwen {
		public Huis() { super(); }

		public static void verkoopHuis(Straat straat, int aantal){
			straat.setAantalGebouwen(straat.getAantalGebouwen()-aantal);
		}
	}

	public Gebouwen(){}


	/**	Aan deze constructor moet nog een exception komen: als de voorwaarden niet nageleeefd zijn
	 *  dan komt er een bericht op het scherm
	 */

	public Gebouwen(Straat straat, Huis huis, int aantal, Speler speler){
		straat.setGebouw(huis);
		if (speler.getIsConcurrent()) {
			if (straat.getAantalGebouwen()+aantal<straat.getMaxHuisCon()) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
			}
		} else {
			if (straat.getAantalGebouwen() + aantal < straat.getMaxHuisMon()) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
			}
		}

	}
	public Gebouwen(Straat straat, Hotel hotel){
		straat.setGebouw(hotel);
		straat.setAantalGebouwen(1);
	}

	public void verkoopGebouw(Straat straat, Gebouwen gebouw, int aantal,Speler speler) {
		if(gebouw.getClass().equals(Hotel.class)){
			Gebouwen.Hotel.verkoopHotel(straat,aantal,speler);
			straat.setGebouw(new Huis());
		}
		if(gebouw.getClass().equals(Huis.class)){
			Gebouwen.Huis.verkoopHuis(straat,aantal);                                    // Huis en hotel statisch gemaakt zodat de methode eenvoudig zo kan opgeroepen worden
		}

		if(straat.getGebouw()==null){
			return;																		 // + foutboodschap als er geen gebouwen meer opstaan: met return String of System.out.println ?
		}
	}

}