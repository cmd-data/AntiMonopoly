package AntiMonopoly.Model;

import AntiMonopoly.View.MainScreen.MainView;

import java.util.ArrayList;
import java.util.List;

public class Spelbord {

	private static List<Tegel> tegels = new ArrayList<>();

	public Spelbord () {
		tegels.add(new Start("Start", 0));
		tegels.add(new Straat("Rue Grande, Dinant", 60000, 6000, 30000, 50000, null, null, 0, "paars", 1));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 2));
		tegels.add(new Straat("Diestsestraat, Leuven", 60000, 6000, 30000, 50000, null, null, 0, "paars", 3));
		tegels.add(new Inkomstenbelasting("Inkomstenbelasting", 4));
		tegels.add(new Transport("Noord Station", null, 5));
		tegels.add(new Straat("Steenstraat, Brugge", 100000, 10000, 50000, 50000, null, null, 0, "lBlauw", 6));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 7));
		tegels.add(new Straat("Place Du Monument, Spa", 100000, 10000, 50000, 50000, null, null, 0, "lBlauw", 8));
		tegels.add(new Straat("Kapellestraat, Oostende", 120000, 12000, 60000, 50000, null, null, 0, "lBlauw", 9));
		tegels.add(new Gevangenis("Gevangenis / Prijzenoorlog / Sigtseeing tour", 10));
		tegels.add(new Straat("Rue De Diekirch, Arlon", 140000, 14000, 70000, 100000, null, null, 0, "roos", 11));
		tegels.add(new GasEnElektriciteitsbedrijf("Elektriciteitscentrale", null, 12));
		tegels.add(new Straat("Bruul, Mechelen", 140000, 14000, 70000, 100000, null, null, 0, "roos", 13));
		tegels.add(new Straat("Place Verte, Verviers", 160000, 16000, 80000, 100000, null, null, 0, "roos", 14));
		tegels.add(new Transport("Centraal Station", null, 15));
		tegels.add(new Straat("Lippenslaan, Knokke", 180000, 18000, 90000, 100000, null, null, 0, "oranje", 16));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 17));
		tegels.add(new Straat("Rue Royale, Tournai", 180000, 18000, 90000, 100000, null, null, 0, "oranje", 18));
		tegels.add(new Straat("Groenplaats, Antwerpen", 200000, 20000, 100000, 100000, null, null, 0, "oranje", 19));
		tegels.add(new AntiMonopolyStichting("Anti-Monopolystichting", 20));
		tegels.add(new Straat("Rue Saint Léonard, Liège", 220000, 22000, 110000, 150000, null, null, 0, "rood", 21));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 22));
		tegels.add(new Straat("Lange Steenstraat, Kortrijk", 220000, 22000, 110000, 150000, null, null, 0, "rood", 23));
		tegels.add(new Straat("Grande Place, Mons", 240000, 24000, 120000, 150000, null, null, 0, "rood", 24));
		tegels.add(new Transport("Buurtspoorwegen", null, 25));
		tegels.add(new Straat("Grote Markt, Hasselt", 260000, 26000, 130000, 150000, null, null, 0, "geel", 26));
		tegels.add(new Straat("Place De l'Ange, Namur", 260000, 26000, 130000, 150000, null, null, 0, "geel", 27));
		tegels.add(new GasEnElektriciteitsbedrijf("Gasbedrijf", null, 28));
		tegels.add(new Straat("Hoogstraat, Brussel", 280000, 28000, 140000, 150000, null, null, 0, "geel", 29));
		tegels.add(new GaNaarGevangenis("Ga naar de gevangenis!", 30));
		tegels.add(new Straat("Veldstraat, Gent", 300000, 30000, 150000, 200000, null, null, 0, "groen", 31));
		tegels.add(new Straat("Boulevard Tirou, Charleroi", 300000, 30000, 150000, 200000, null, null, 0, "groen", 32));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 33));
		tegels.add(new Straat("Boulevard d'Avroy, Liège", 300000, 30000, 150000, 200000, null, null, 0, "groen", 34));
		tegels.add(new Transport("Zuid Station", null, 35));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 36));
		tegels.add(new Straat("Meir, Antwerpen", 350000, 35000, 175000, 200000, null, null, 0, "dBlauw", 37));
		tegels.add(new Eigendomsbelasting("Eigendomsbelasting", 38));
		tegels.add(new Straat("Nieuwstraat, Brussel", 400000, 40000, 200000, 200000, null, null, 0, "dBlauw", 39));
	}

	public static void showOwner(int locatie, Speler speler) {

		String layout1 = MainView.getSpeler1Eigendom();
		String layout2 = MainView.getSpeler2Eigendom();
		String layout3 = MainView.getSpeler3Eigendom();
		String layout4 = MainView.getSpeler4Eigendom();

		String layout = speler.getPion();

		switch (layout){
			case "pink square": layout = layout1; break;
			case "grey square": layout = layout2; break;
			case "white square": layout = layout3; break;
			case "red square": layout = layout4; break;
			default:
				throw new IllegalStateException("Unexpected value: " + Dice.getCount());
		}
		layoutEigendommenVeranderen(locatie, layout);
	}

	public static void removeOwner (int locatie, Speler speler) {
		String layout = "-fx-border-color: black; -fx-border-width: 1px; -fx-border-style: solid;";
		layoutEigendommenVeranderen(locatie, layout);
	}


	private static void layoutEigendommenVeranderen(int locatie, String layout) {
		switch (locatie) {
			case 1: MainView.getRueGrande().setStyle(layout); break;
			case 3: MainView.getDiestsesttraat().setStyle(layout); break;
			case 5: MainView.getNoordStation().setStyle(layout); break;
			case 6: MainView.getSteenstraat().setStyle(layout); break;
			case 8: MainView.getPlaceDuMonument().setStyle(layout); break;
			case 9: MainView.getKapellestraat().setStyle(layout); break;
			case 11: MainView.getRueDeDiekrich().setStyle(layout); break;
			case 12: MainView.getElektriciteitsbedrijf().setStyle(layout); break;
			case 13: MainView.getBruul().setStyle(layout); break;
			case 14: MainView.getPlaceVerte().setStyle(layout); break;
			case 15: MainView.getOostStation().setStyle(layout); break;
			case 16: MainView.getLippenslaan().setStyle(layout); break;
			case 18: MainView.getRueRoyal().setStyle(layout); break;
			case 19: MainView.getGroenplaats().setStyle(layout); break;
			case 21: MainView.getRueSaintLeonard().setStyle(layout); break;
			case 23: MainView.getLangeSteenstraat().setStyle(layout); break;
			case 24: MainView.getGrandePlace().setStyle(layout); break;
			case 25: MainView.getZuidStation().setStyle(layout); break;
			case 26: MainView.getGroteMarkt().setStyle(layout); break;
			case 27: MainView.getPlaceDeLAnge().setStyle(layout); break;
			case 28: MainView.getGasmaatschappij().setStyle(layout); break;
			case 29: MainView.getHoogstraat().setStyle(layout); break;
			case 31: MainView.getVeldstraat().setStyle(layout); break;
			case 32: MainView.getBoulevardTirou().setStyle(layout); break;
			case 34: MainView.getBoulevardDAvroy().setStyle(layout); break;
			case 35: MainView.getZuidStation().setStyle(layout); break;
			case 37: MainView.getMeir().setStyle(layout); break;
			case 39: MainView.getNieuwstraat().setStyle(layout);
		}
	}

	public static List<Tegel> getTegels() { return tegels; }
}