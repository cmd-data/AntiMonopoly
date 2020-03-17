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
		super(naam,positie);
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	public static int getWaarde() { return waarde; }

	public void koopTransportbedrijf(Speler speler, Transport bedrijf){

		if (speler.getGeld() < waarde) {
			System.out.println("Niet genoeg geld");
		} else {
			bedrijf.setEigenaar(speler);
			speler.setGeld(-waarde);
		}
	}

	public static int getHuur(Transport transportBedrijf){
		int aantal = 0;
		Speler eigenaar = transportBedrijf.getEigenaar();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof Transport){
				transport.add((Transport)tegel);
			}
		}

		if(eigenaar.getIsConcurrent()){
			return (int) (waarde * 0.1);
		} else {
			for (int i = 0; i < transport.size(); i++) {
				if (eigenaar.equals(transport.get(i).getEigenaar())){
					aantal++;												  // checken hoeveel transportbedrijven een monopolist heeft
				}
			}
			return (int) (waarde * 0.2) * aantal;
		}
	}

	public static List<Transport> getTransport() { return transport; }

	public Speler getEigenaar() { return eigenaar; }

	public void setEigenaar(Speler eigenaar) { this.eigenaar = eigenaar; }

	public String getNaam() { return naam; }

	public void setNaam(String naam) { this.naam = naam; }
}