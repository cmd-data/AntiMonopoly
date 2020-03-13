package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Stad {

	private static List<Straat> straat = new ArrayList<>();

	public static List<Straat> getStraat() {
		for (Tegel tegel : Spelbord.getTegels()) {
			if(tegel instanceof Straat){
				straat.add((Straat)tegel); // OutOfMemoryError??
			}
		}
		return straat;
	}
}