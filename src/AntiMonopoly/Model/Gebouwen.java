package AntiMonopoly.Model;

public class Gebouwen {

	public static class Hotel extends Gebouwen {
		private int hotel = 0;
		public Hotel() { super(); }

		public static void verkoopHotel(Straat straat, int aantal, Speler speler){	 // eerst checken of dat de speler een concurrent is of niet, dan aantal huizen aanpassen
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

	public void koopHuis(Straat straat, Huis huis, int aantal, Speler speler) {

		if (speler.getIsConcurrent()) {
			while (straat.getAantalGebouwen() + aantal > straat.getMaxHuisCon()) {
				System.out.printf("Totaal aantal huizen mag niet meer zijn dan %d",straat.getMaxHuisCon());
			}
			straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
		} else {
			while (straat.getAantalGebouwen() + aantal > straat.getMaxHuisMon()) {
				System.out.printf("Totaal aantal huizen mag niet meer zijn dan %d",straat.getMaxHuisMon());
			}
			straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
		}
		straat.setGebouw(huis);
		speler.setGeld(-straat.getPrijsHuis() * aantal);
	}

	public void koopHotel(Straat straat, Hotel hotel, Speler speler){
		int aantalHuizen = straat.getAantalGebouwen();

		if(speler.getIsConcurrent()){
			switch(aantalHuizen){
				case 0: speler.setGeld(-straat.getPrijsHuis()*5); break;
				case 1: speler.setGeld(-straat.getPrijsHuis()*4); break;
				case 2: speler.setGeld(-straat.getPrijsHuis()*3); break;
				case 3: speler.setGeld(-straat.getPrijsHuis()*2); break;
				case 4: speler.setGeld(-straat.getPrijsHuis());
			}
		} else {
			switch (aantalHuizen){
				case 0: speler.setGeld(-straat.getPrijsHuis()*4); break;
				case 1: speler.setGeld(-straat.getPrijsHuis()*3); break;
				case 2: speler.setGeld(-straat.getPrijsHuis()*2); break;
				case 3: speler.setGeld(-straat.getPrijsHuis());
			}
		}
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