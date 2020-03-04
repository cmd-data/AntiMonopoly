package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Transport extends Tegel {

	private static List<Transport> transport = new ArrayList<>();

	private static final int waarde = 200000;
	private Speler eigenaar;
	private String naam;
	private int positie;
	private final int hypotheek = 100000;

	public Transport(String naam, Speler eigenaar, int positie){
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	/**
	 * instantie in andere klasse maken zodat de transport lijst aangevuld wordt.
	 */

	/*public Transport(){
		transport.add(new Transport("Noord Station", null));
		transport.add(new Transport("Centraal Station", null));
		transport.add(new Transport("Buurtspoorwegen", null));
		transport.add(new Transport("Zuid Station", null));
	}*/


	public static int getWaarde() { return waarde; }

	public void betaalHuur(String naamTransportbedrijf, Speler speler){
		int aantal = 0;
		Speler eigenaar = null;
		for (int j = 0; j < transport.size(); j++) {
			if(transport.get(j).getNaam().equals(naamTransportbedrijf)){
				eigenaar = transport.get(j).getEigenaar();
			}
		}
		if(eigenaar.getIsConcurrent()){
			int huur = (int) (waarde * 0.1);
			speler.setGeld(-huur);
			eigenaar.setGeld(huur);															/** Nog uitwerken zodat de juiste speler geld bijkrijgt of verliest */
		} else {
			for (int i = 0; i < transport.size(); i++) {
				if (eigenaar.equals(transport.get(i).getEigenaar())){
					aantal++;																			/** checken hoeveel transportbedrijven een monopolist heeft */
				}																						/** dit kan hopelijk nog vereenvoudigd worden */
			}
			int huur = (int) (waarde * 0.2);
			speler.setGeld(-huur*aantal);
			eigenaar.setGeld(huur*aantal);
		}
	}

	public static List<Transport> getTransport() { return transport; }

	public Speler getEigenaar() { return eigenaar; }

	public void setEigenaar(Speler eigenaar) { this.eigenaar = eigenaar; }

	public String getNaam() { return naam; }

	public void setNaam(String naam) { this.naam = naam; }
}