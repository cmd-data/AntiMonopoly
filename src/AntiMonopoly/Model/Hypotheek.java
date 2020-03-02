package AntiMonopoly.Model;

import java.util.Collection;

public class Hypotheek {

	private static Collection<Straten> hypotheekLijst = null;

	public Hypotheek (){ }

	public void stopHuur(Straten straat) {
		if(hypotheekLijst.contains(straat)){
			/**
			 * Stop methode betaalHuur als iemand op de straat terecht komt*/
		}
	}

	public static Collection<Straten> getHypotheekLijst() { return hypotheekLijst; }

	public void neemHypotheek(Straten straat) {
		hypotheekLijst.add(straat);
	}

	public void uitHypotheek(Straten straat){
		hypotheekLijst.remove(straat);
	}

}