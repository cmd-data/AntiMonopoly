package AntiMonopoly.Model;

import java.util.List;
import java.util.Scanner;

public class Tegel {

	private int positie;
	private String naam;
	private List<Speler> spelers;

	public Tegel(String naam, int positie) {
		this.naam = naam;
		this.positie = positie;
	}

	public void tegelMethode(Tegel tegel, Speler speler){
		int soortVak = tegel.positie;
		Scanner kb = new Scanner(System.in);

		if(isKoopbaar(tegel)){
			if (heeftEigenaar(tegel)){
				if (!heeftHypotheek(tegel)){
					betaalHuur(tegel,speler);
				}
			} else {
				System.out.printf("%s, straat kopen? ('true' of 'false'):\n ", tegel.naam);
				String input = kb.next();

				while(!"true".equals(input)&&!"false".equals(input)){
					System.out.println("Verkeerde input ('true' of 'false'): ");
					input = kb.next();
				}

				if (Boolean.parseBoolean(input)){
					if (tegel instanceof Straat){
						((Straat) tegel).koopStraat(speler,(Straat) tegel);
					}
					if (tegel instanceof Transport){
						((Transport) tegel).koopTransportbedrijf(speler,(Transport) tegel);
					}
					if (tegel instanceof GasEnElektriciteitsbedrijf){
						((GasEnElektriciteitsbedrijf) tegel).koopGasofElektriciteitsbedrijf(speler,(GasEnElektriciteitsbedrijf) tegel);
					}
				}
			}
		} else {
			switch (soortVak) {
				case 36:
				case 33:
				case 22:
				case 17:
				case 7:
				case 2: ConcurrentenOfMonopolistenvak.voerUit(speler); break;
				case 4: Inkomstenbelasting.betaalBelasting(speler); break;
				case 10: if (Gevangenis.getGevangenen().contains(speler)){
					Gevangenis.verlaatGevangenis(speler);
						} else {
					Gevangenis.opBezoek(speler);
						} break;
				case 20: AntiMonopolyStichting.voerUit(speler); break;
				case 30: GaNaarGevangenis.gaNaarGevangenis(speler); break;
				case 38: Eigendomsbelasting.betaalBelasting(speler);
			}
		}
	}

	public boolean isKoopbaar(Tegel tegel){
		if(tegel instanceof Straat){
			return true;
		}
		if(tegel instanceof Transport){
			return true;
		}
		return tegel instanceof GasEnElektriciteitsbedrijf;
	}

	public boolean heeftEigenaar(Tegel tegel){
		if(tegel instanceof Straat){
			return (((Straat) Spelbord.getTegels().get(tegel.positie)).getEigenaar() !=null);
		}
		if(tegel instanceof Transport){
			return (((Transport) Spelbord.getTegels().get(tegel.positie)).getEigenaar() !=null);
		}
		if(tegel instanceof GasEnElektriciteitsbedrijf){
			return ((GasEnElektriciteitsbedrijf) Spelbord.getTegels().get(tegel.positie)).getEigenaar() != null;
		}
		return true;
	}

	public boolean heeftHypotheek(Tegel tegel){
		return Hypotheek.getHypotheekLijst().contains(tegel);
	}

	public void betaalHuur(Tegel tegel, Speler speler){
		if (tegel instanceof Straat){
			if (!speler.equals(((Straat) tegel).getEigenaar())) {
				speler.setGeld(-Straat.getHuur((Straat) tegel));
				((Straat) tegel).getEigenaar().setGeld(Straat.getHuur((Straat) tegel));
			}
		}
		if (tegel instanceof Transport){
			if (!speler.equals(((Transport) tegel).getEigenaar())) {
				speler.setGeld(-Transport.getHuur((Transport) tegel));
				((Transport) tegel).getEigenaar().setGeld(Transport.getHuur((Transport) tegel));
			}
		}
		if (tegel instanceof GasEnElektriciteitsbedrijf){
			if (!speler.equals(((GasEnElektriciteitsbedrijf) tegel).getEigenaar())) {
				speler.setGeld(-GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
				((GasEnElektriciteitsbedrijf) tegel).getEigenaar().setGeld(GasEnElektriciteitsbedrijf.getHuur((GasEnElektriciteitsbedrijf) tegel));
			}
		}
	}


	public int getPositie() {
		return positie;
	}//einde Methode

	public String getNaam() {
		return naam;
	}//einde Methode

	public List<Speler> getSpelers() {
		return spelers;
	}

}

