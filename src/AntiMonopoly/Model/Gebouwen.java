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

	public static void koopHuis(Straat straat, Huis huis, int aantal, Speler speler) {

		if (speler.getIsConcurrent()) {
			//while (straat.getAantalGebouwen() + aantal > straat.getMaxHuisCon()) {
			//	System.out.printf("Totaal aantal huizen mag niet meer zijn dan %d",straat.getMaxHuisCon());		// ==> veranderen door combobox
			//}
			if (speler.getGeld() >= straat.getPrijsHuis()*aantal) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
				straat.setGebouw(huis);
				speler.setGeld(-straat.getPrijsHuis() * aantal);
			} else {
				System.out.println("Niet genoeg geld");
			}
		} else {
			//while (straat.getAantalGebouwen() + aantal > straat.getMaxHuisMon()) {
			//	System.out.printf("Totaal aantal huizen mag niet meer zijn dan %d",straat.getMaxHuisMon());    // ==> veranderen door combobox
			//}
			if (speler.getGeld() >= straat.getPrijsHuis()*aantal) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
				straat.setGebouw(huis);
				speler.setGeld(-straat.getPrijsHuis() * aantal);
			} else {
				System.out.println("Niet genoeg geld");
			}
		}
		Spel.updateGeld();
	}

	public static void koopHotel(Straat straat, Hotel hotel, Speler speler){
		int aantalHuizen = straat.getAantalGebouwen();

		if(speler.getIsConcurrent()){
			switch(aantalHuizen){
				case 0: if (speler.getGeld() >= straat.getPrijsHuis()*5) {
					speler.setGeld(-straat.getPrijsHuis()*5);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 1: if (speler.getGeld() >= straat.getPrijsHuis()*4) {
					speler.setGeld(-straat.getPrijsHuis()*4);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 2: if (speler.getGeld() >= straat.getPrijsHuis()*3) {
					speler.setGeld(-straat.getPrijsHuis()*3);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 3: if (speler.getGeld() >= straat.getPrijsHuis()*2) {
					speler.setGeld(-straat.getPrijsHuis()*2);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 4: if (speler.getGeld() >= straat.getPrijsHuis()) {
					speler.setGeld(-straat.getPrijsHuis());
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				}
			}
		} else {
			switch (aantalHuizen){
				case 0: if (speler.getGeld() >= straat.getPrijsHuis()*4) {
					speler.setGeld(-straat.getPrijsHuis()*4);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 1: if (speler.getGeld() >= straat.getPrijsHuis()*3) {
					speler.setGeld(-straat.getPrijsHuis()*3);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 2: if (speler.getGeld() >= straat.getPrijsHuis()*2) {
					speler.setGeld(-straat.getPrijsHuis()*2);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				} break;
				case 3: if (speler.getGeld() >= straat.getPrijsHuis()) {
					speler.setGeld(-straat.getPrijsHuis());
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} else {
					System.out.println("Niet genoeg geld");
				}
			}
		}
		Spel.updateGeld();
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