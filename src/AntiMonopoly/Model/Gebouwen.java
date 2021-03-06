package AntiMonopoly.Model;

public class Gebouwen {

	public static class Hotel extends Gebouwen {

		public Hotel() { super(); }

		public static void verkoopHotel(Straat straat, Speler speler){
			if (straat.getAantalGebouwen()!=0) {
				straat.setAantalGebouwen(0);
				if (speler.getIsConcurrent()) {
					speler.setGeld(5 * straat.getPrijsHuis());
				} else {
					speler.setGeld(4 * straat.getPrijsHuis());
				}
				Spel.updateGeld();
			}
		}
	}

	public static class Huis extends Gebouwen {
		public Huis() { super(); }

		public static void verkoopHuis(Straat straat, int aantal, Speler speler){
			if (straat.getAantalGebouwen()!=0) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() - aantal);
				speler.setGeld(aantal * straat.getPrijsHuis());
				Spel.updateGeld();
			}
		}
	}

	public Gebouwen(){}

	public static void koopHuis(Straat straat, Huis huis, int aantal, Speler speler) {

		if (speler.getIsConcurrent()) {

			if (speler.getGeld() >= straat.getPrijsHuis()*aantal) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
				straat.setGebouw(huis);
				speler.setGeld(-straat.getPrijsHuis() * aantal);
			} /*else {
				System.out.println("Niet genoeg geld");                                         // veranderen naar pop-up
			}*/
		} else {

			if (speler.getGeld() >= straat.getPrijsHuis()*aantal) {
				straat.setAantalGebouwen(straat.getAantalGebouwen() + aantal);
				if (aantal == 4){
					straat.setGebouw(new Hotel());
					straat.setAantalGebouwen(1);
				} else {
					straat.setGebouw(huis);
				}
				speler.setGeld(-straat.getPrijsHuis() * aantal);
			} /*else {
				System.out.println("Niet genoeg geld");											// veranderen naar pop-up
			}*/
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
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 1: if (speler.getGeld() >= straat.getPrijsHuis()*4) {
					speler.setGeld(-straat.getPrijsHuis()*4);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 2: if (speler.getGeld() >= straat.getPrijsHuis()*3) {
					speler.setGeld(-straat.getPrijsHuis()*3);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 3: if (speler.getGeld() >= straat.getPrijsHuis()*2) {
					speler.setGeld(-straat.getPrijsHuis()*2);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 4: if (speler.getGeld() >= straat.getPrijsHuis()) {
					speler.setGeld(-straat.getPrijsHuis());
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/
			}
		} else {
			switch (aantalHuizen){
				case 0: if (speler.getGeld() >= straat.getPrijsHuis()*4) {
					speler.setGeld(-straat.getPrijsHuis()*4);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 1: if (speler.getGeld() >= straat.getPrijsHuis()*3) {
					speler.setGeld(-straat.getPrijsHuis()*3);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 2: if (speler.getGeld() >= straat.getPrijsHuis()*2) {
					speler.setGeld(-straat.getPrijsHuis()*2);
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/ break;
				case 3: if (speler.getGeld() >= straat.getPrijsHuis()) {
					speler.setGeld(-straat.getPrijsHuis());
					straat.setGebouw(hotel);
					straat.setAantalGebouwen(1);
				} /*else {
					System.out.println("Niet genoeg geld");
				}*/
			}
		}
		Spel.updateGeld();
	}
}