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

	private static List<Straat> straat = new ArrayList<>();

	/*public Stad(){
		straat.add(new Straat("Rue Grande, Dinant", 60, 6, 30, 50, null,null,0, this.paars));
		straat.add(new Straat("Diestsestraat, Leuven", 60, 6, 30, 50, null,null,0, this.paars));

		straat.add(new Straat("Steenstraat, Brugge", 100, 10, 50, 50, null,null,0, this.lBlauw));
		straat.add(new Straat("Place Du Monument, Spa", 100, 10, 50, 50, null,null,0, this.lBlauw));
		straat.add(new Straat("Kapellestraat, Oostende", 120, 12, 60, 50, null,null,0, this.lBlauw));

		straat.add(new Straat("Rue De Diekirch, Arlon", 140, 14, 70, 100 , null,null,0, this.roos));
		straat.add(new Straat("Bruul, Mechelen", 140, 14, 70, 100 , null,null,0, this.roos));
		straat.add(new Straat("Place Verte, Verviers", 160, 16, 80, 100 , null,null,0, this.roos));

		straat.add(new Straat("Lippenslaan, Knokke", 180, 18, 90, 100 , null,null,0, this.oranje));
		straat.add(new Straat("Rue Royale, Tournai", 180, 18, 90, 100 , null,null,0, this.oranje));
		straat.add(new Straat("Groenplaats, Antwerpen", 200, 20, 100, 100 , null,null,0, this.oranje));

		straat.add(new Straat("Rue Saint Léonard, Liège", 220, 22, 110, 150 , null,null,0, this.rood));
		straat.add(new Straat("Lange Steenstraat, Kortrijk", 220, 22, 110, 150 , null,null,0, this.rood));
		straat.add(new Straat("Grande Place, Mons", 240, 24, 120, 150 , null,null,0, this.rood));

		straat.add(new Straat("Grote Markt, Hasselt", 260, 26, 130, 150 , null,null,0, this.geel));
		straat.add(new Straat("Place De l'Ange, Namur", 260, 26, 130, 150 , null,null,0, this.geel));
		straat.add(new Straat("Hoogstraat, Brussel", 280, 28, 140, 150 , null,null,0, this.geel));

		straat.add(new Straat("Veldstraat, Gent", 300, 30, 150, 200 , null,null,0, this.groen));
		straat.add(new Straat("Boulevard Tirou, Charleroi", 300, 30, 150, 200 , null,null,0, this.groen));
		straat.add(new Straat("Boulevard d' Avroy, Liège", 320, 32, 160, 200 , null,null,0, this.groen));

		straat.add(new Straat("Meir, Antwerpen", 350, 35, 175, 200 , null,null,0, this.dBlauw));
		straat.add(new Straat("Nieuwstraat, Brussel", 400, 40, 200, 200 , null,null,0, this.dBlauw));
	}*/

	/**
	 * methode is statisch zodat we deze methode kunnen oproepen zonder een instantie stad te moeten maken
	 * Hoe kan ik deze methode aanpassen zodat ze werkt met de gemaakte tegels?
	 *
	 * @param stad
	 * @return
	 */
	 /** eerst naar de eerste stad in de lijst gaan die overeenkomt met parameter
	  *  kijken of de eigenaar van straat 1 = straat 2
	  *  bij de volgende iteratie wordt dan gekeken naar straat 2 en 3
	  **/

	/*public static boolean isMonopolyStad(String stad) {
		for (int i = 0; i < straat.size(); i++) {
			try {
				if (straat.get(i).getStad().equals(stad)) {
					if (straat.get(i).getEigenaar().equals(straat.get(i + 1).getEigenaar())) {
						return true;
					}
					if (straat.get(i).getEigenaar().equals(straat.get(i + 2).getEigenaar())) {
						return true;
					}
				}
			} catch (NullPointerException npe){}
		}
		return false;
	}*/

	public static List<Straat> getStraat() { return straat; }
}