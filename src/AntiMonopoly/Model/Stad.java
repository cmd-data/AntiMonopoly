package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Stad {

	private String paars = "Paars";
	private String lBlauw = "Licht Blauw";
	private String roos = "Roos";
	private String oranje = "Oranje";
	private String rood = "Rood";
	private String geel = "Geel";
	private String groen = "Groen";
	private String dBlauw = "Donker Blauw";

	private static List<Straten> straten = new ArrayList<>();

	public Stad(){
		straten.add(new Straten("Rue Grande, Dinant", 60, 6, 30, 50, null,null,0, this.paars));
		straten.add(new Straten("Diestsestraat, Leuven", 60, 6, 30, 50, null,null,0, this.paars));

		straten.add(new Straten("Steenstraat, Brugge", 100, 10, 50, 50, null,null,0, this.lBlauw));
		straten.add(new Straten("Place Du Monument, Spa", 100, 10, 50, 50, null,null,0, this.lBlauw));
		straten.add(new Straten("Kapellestraat, Oostende", 120, 12, 60, 50, null,null,0, this.lBlauw));

		straten.add(new Straten("Rue De Diekirch, Arlon", 140, 14, 70, 100 , null,null,0, this.roos));
		straten.add(new Straten("Bruul, Mechelen", 140, 14, 70, 100 , null,null,0, this.roos));
		straten.add(new Straten("Place Verte, Verviers", 160, 16, 80, 100 , null,null,0, this.roos));

		straten.add(new Straten("Lippenslaan, Knokke", 180, 18, 90, 100 , null,null,0, this.oranje));
		straten.add(new Straten("Rue Royale, Tournai", 180, 18, 90, 100 , null,null,0, this.oranje));
		straten.add(new Straten("Groenplaats, Antwerpen", 200, 20, 100, 100 , null,null,0, this.oranje));

		straten.add(new Straten("Rue Saint Léonard, Liège", 220, 22, 110, 150 , null,null,0, this.rood));
		straten.add(new Straten("Lange Steenstraat, Kortrijk", 220, 22, 110, 150 , null,null,0, this.rood));
		straten.add(new Straten("Grande Place, Mons", 240, 24, 120, 150 , null,null,0, this.rood));

		straten.add(new Straten("Grote Markt, Hasselt", 260, 26, 130, 150 , null,null,0, this.geel));
		straten.add(new Straten("Place De l'Ange, Namur", 260, 26, 130, 150 , null,null,0, this.geel));
		straten.add(new Straten("Hoogstraat, Brussel", 280, 28, 140, 150 , null,null,0, this.geel));

		straten.add(new Straten("Veldstraat, Gent", 300, 30, 150, 200 , null,null,0, this.groen));
		straten.add(new Straten("Boulevard Tirou, Charleroi", 300, 30, 150, 200 , null,null,0, this.groen));
		straten.add(new Straten("Boulevard d' Avroy, Liège", 320, 32, 160, 200 , null,null,0, this.groen));

		straten.add(new Straten("Meir, Antwerpen", 350, 35, 175, 200 , null,null,0, this.dBlauw));
		straten.add(new Straten("Nieuwstraat, Brussel", 400, 40, 200, 200 , null,null,0, this.dBlauw));
	}

	/**
	 * methode is statisch zodat we deze methode kunnen oproepen zonder een instantie stad te moeten maken
	 * @param stad
	 * @return
	 */

	public static boolean isMonopolyStad(String stad) {
		for (int i = 0; i < straten.size(); i++) {
			try {
				if (straten.get(i).getStad().equals(stad)) {                                                /** eerst naar de eerste stad in de lijst gaan die overeenkomt met parameter */
					if (straten.get(i).getEigenaar().equals(straten.get(i + 1).getEigenaar())) {            /** kijken of de eigenaar van straat 1 = straat 2 */
						return true;                                                                        /** bij de volgende iteratie wordt dan gekeken naar straat 2 en 3 */
					}
					if (straten.get(i).getEigenaar().equals(straten.get(i + 2).getEigenaar())) {            /** kijken of de eigenaar van straat 1 = straat 2 */
						return true;                                                                        /** bij de volgende iteratie wordt dan gekeken naar straat 2 en 3 */
					}
				}
			} catch (NullPointerException npe){}
		}
		return false;
	}

	public static List<Straten> getStraten() { return straten; }
}