package AntiMonopoly.Model;

import java.util.Collection;

public class Hypotheek {

	private static Collection<Straat> hypotheekLijst = null;

	public Hypotheek (){ }

	public void stopHuur(Straat straat) {
		if(hypotheekLijst.contains(straat)){
			/**
			 * Stop methode betaalHuur als iemand op de straat terecht komt*/
		}
	}

	public static Collection<Straat> getHypotheekLijst() { return hypotheekLijst; }

	public void neemHypotheek(Straat straat) {
		hypotheekLijst.add(straat);
	}

	public void uitHypotheek(Straat straat){
		hypotheekLijst.remove(straat);
	}

}