package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.List;

public class Spelbord {

	private int pionBlauw;
	private int pionGroen;
	private static List<Tegel> tegels = new ArrayList<>();

	public void plaatsPion() { }   // Plaats pion (gelinkt aan een speler) op het spelbord
	public void plaatsGebouw() { } // Plaats een gebouw op de juiste plaats (plaats op de tegel is verschillend voor concurrenten en monopolisten)

	/**
	 * Hoe gebruik ik nu een methode uit de subklassen? Ik kan met 'tegel0.' alleen methoden aanroepen uit Tegel
	 */
	public Spelbord () {
		tegels.add(new Start("Start", 0));
		tegels.add(new Straat("Rue Grande, Dinant", 60, 6, 30, 50, null, null, 0, "paars", 1));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 2));
		tegels.add(new Straat("Diestsestraat, Leuven", 60, 6, 30, 50, null, null, 0, "paars", 3));
		tegels.add(new Inkomstenbelasting("Inkomstenbelasting", 4));
		tegels.add(new Transport("Noord Station", null, 5));
		tegels.add(new Straat("Steenstraat, Brugge", 100, 10, 50, 50, null, null, 0, "lBlauw", 6));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 7));
		tegels.add(new Straat("Place Du Monument, Spa", 100, 10, 50, 50, null, null, 0, "lBlauw", 8));
		tegels.add(new Straat("Kapellestraat, Oostende", 120, 12, 60, 50, null, null, 0, "lBlauw", 9));
		tegels.add(new Gevangenis("Gevangenis / Prijzenoorlog / Sigtseeing tour", 10));
		tegels.add(new Straat("Rue De Diekirch, Arlon", 140, 14, 70, 100, null, null, 0, "roos", 11));
		tegels.add(new GasEnElektriciteitsbedrijf("Elektriciteitscentrale", null, 12));
		tegels.add(new Straat("Bruul, Mechelen", 140, 14, 70, 100, null, null, 0, "roos", 13));
		tegels.add(new Straat("Place Verte, Verviers", 160, 16, 80, 100, null, null, 0, "roos", 14));
		tegels.add(new Transport("Centraal Station", null, 15));
		tegels.add(new Straat("Lippenslaan, Knokke", 180, 18, 90, 100, null, null, 0, "oranje", 16));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 17));
		tegels.add(new Straat("Rue Royale, Tournai", 180, 18, 90, 100, null, null, 0, "oranje", 18));
		tegels.add(new Straat("Groenplaats, Antwerpen", 200, 20, 100, 100, null, null, 0, "oranje", 19));
		tegels.add(new AntiMonopolyStichting("Anti-Monopolystichting", 20));
		tegels.add(new Straat("Rue Saint Léonard, Liège", 220, 22, 110, 150, null, null, 0, "rood", 21));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 22));
		tegels.add(new Straat("Lange Steenstraat, Kortrijk", 220, 22, 110, 150, null, null, 0, "rood", 23));
		tegels.add(new Straat("Grande Place, Mons", 240, 24, 120, 150, null, null, 0, "rood", 24));
		tegels.add(new Transport("Buurtspoorwegen", null, 25));
		tegels.add(new Straat("Grote Markt, Hasselt", 260, 26, 130, 150, null, null, 0, "geel", 26));
		tegels.add(new Straat("Place De l'Ange, Namur", 260, 26, 130, 150, null, null, 0, "geel", 27));
		tegels.add(new GasEnElektriciteitsbedrijf("Gasbedrijf", null, 28));
		tegels.add(new Straat("Hoogstraat, Brussel", 280, 28, 140, 150, null, null, 0, "geel", 29));
		tegels.add(new GaNaarGevangenis("Ga naar de gevangenis!", 30));
		tegels.add(new Straat("Veldstraat, Gent", 300, 30, 150, 200, null, null, 0, "groen", 31));
		tegels.add(new Straat("Boulevard Tirou, Charleroi", 300, 30, 150, 200, null, null, 0, "groen", 32));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 33));
		tegels.add(new Straat("Boulevard Tirou, Charleroi", 300, 30, 150, 200, null, null, 0, "groen", 34));
		tegels.add(new Transport("Zuid Station", null, 35));
		tegels.add(new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 36));
		tegels.add(new Straat("Meir, Antwerpen", 350, 35, 175, 200, null, null, 0, "dBlauw", 37));
		tegels.add(new Eigendomsbelasting("Eigendomsbelasting", 38));
		tegels.add(new Straat("Nieuwstraat, Brussel", 400, 40, 200, 200, null, null, 0, "dBlauw", 39));
	}

	/**
	 * Statisch omdat ik vanuit ConcurrentenOfMonopolistenvak en GaNaarGevangenis een tegel.addSpeler moet kunnen gebruiken
	 * @return
	 */
	public static List<Tegel> getTegels() {
		return tegels;
	}

	/*Tegel tegel0 = new Start("Start", 0);
	Tegel tegel1 = new Straat("Rue Grande, Dinant", 60, 6, 30, 50, null,null,0, "paars",1);
	Tegel tegel2 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 2);
	Tegel tegel3 = new Straat("Diestsestraat, Leuven", 60, 6, 30, 50, null,null,0, "paars",3);
	Tegel tegel4 = new Inkomstenbelasting("Inkomstenbelasting",4);
	Tegel tegel5 = new Transport("Noord Station", null,5);
	Tegel tegel6 = new Straat("Steenstraat, Brugge", 100, 10, 50, 50, null,null,0, "lBlauw",6);
	Tegel tegel7 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 7);
	Tegel tegel8 = new Straat("Place Du Monument, Spa", 100, 10, 50, 50, null,null,0, "lBlauw",8);
	Tegel tegel9 = new Straat("Kapellestraat, Oostende", 120, 12, 60, 50, null,null,0, "lBlauw",9);
	Tegel tegel10 = new Gevangenis("Gevangenis / Prijzenoorlog / Sigtseeing tour", 10);
	Tegel tegel11 = new Straat("Rue De Diekirch, Arlon", 140, 14, 70, 100 , null,null,0, "roos",11);
	Tegel tegel12 = new GasEnElektriciteitsbedrijf("Elektriciteitscentrale",null,12);
	Tegel tegel13 = new Straat("Bruul, Mechelen", 140, 14, 70, 100 , null,null,0, "roos",13);
	Tegel tegel14 = new Straat("Place Verte, Verviers", 160, 16, 80, 100 , null,null,0, "roos",14);
	Tegel tegel15 = new Transport("Centraal Station", null,15);
	Tegel tegel16 = new Straat("Lippenslaan, Knokke", 180, 18, 90, 100 , null,null,0, "oranje",16);
	Tegel tegel17 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 17);
	Tegel tegel18 = new Straat("Rue Royale, Tournai", 180, 18, 90, 100 , null,null,0, "oranje",18);
	Tegel tegel19 = new Straat("Groenplaats, Antwerpen", 200, 20, 100, 100 , null,null,0, "oranje",19);
	Tegel tegel20 = new AntiMonopolyStichting("Anti-Monopolystichting",20);
	Tegel tegel21 = new Straat("Rue Saint Léonard, Liège", 220, 22, 110, 150 , null,null,0, "rood",21);
	Tegel tegel22 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 22);
	Tegel tegel23 = new Straat("Lange Steenstraat, Kortrijk", 220, 22, 110, 150 , null,null,0, "rood",23);
	Tegel tegel24 = new Straat("Grande Place, Mons", 240, 24, 120, 150 , null,null,0, "rood",24);
	Tegel tegel25 = new Transport("Buurtspoorwegen", null,25);
	Tegel tegel26 = new Straat("Grote Markt, Hasselt", 260, 26, 130, 150 , null,null,0, "geel",26);
	Tegel tegel27 = new Straat("Place De l'Ange, Namur", 260, 26, 130, 150 , null,null,0, "geel",27);
	Tegel tegel28 = new GasEnElektriciteitsbedrijf("Gasbedrijf", null,28);
	Tegel tegel29 = new Straat("Hoogstraat, Brussel", 280, 28, 140, 150 , null,null,0, "geel",29);
	Tegel tegel30 = new GaNaarGevangenis("Ga naar de gevangenis!",30);
	Tegel tegel31 = new Straat("Veldstraat, Gent", 300, 30, 150, 200 , null,null,0, "groen",31);
	Tegel tegel32 = new Straat("Boulevard Tirou, Charleroi", 300, 30, 150, 200 , null,null,0, "groen",32);
	Tegel tegel33 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 33);
	Tegel tegel34 = new Straat("Boulevard Tirou, Charleroi", 300, 30, 150, 200 , null,null,0, "groen",34);
	Tegel tegel35 = new Transport("Zuid Station", null,35);
	Tegel tegel36 = new ConcurrentenOfMonopolistenvak("Concurrent of Monopolisten vak", 36);
	Tegel tegel37 = new Straat("Meir, Antwerpen", 350, 35, 175, 200 , null,null,0, "dBlauw",37);
	Tegel tegel38 = new Eigendomsbelasting("Eigendomsbelasting",38);
	Tegel tegel39 = new Straat("Nieuwstraat, Brussel", 400, 40, 200, 200 , null,null,0, "dBlauw",39);*/
}