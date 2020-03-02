package AntiMonopoly.Model;

public class Spelbord {

	private int pionBlauw;
	private int pionGroen;
	public int[] locaties = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};

	public void plaatsZet() { }
	public void plaatsPion() { }
	public void plaatsGebouw() { }

	Speler speler = new Speler();
	Stad stad = new Stad();
	Transport transport = new Transport();

	public String locatieBepalen(int i){
		switch (i){
			case 0:
				speler.setGeld(100000);
				return "Je passeert Start, ontvang €100.000";
			case 1:
				Stad.getStraten().get(0);
				return "Je komt aan op Rue Grande in Dinant";
			case 2:
			case 7:
			case 17:
			case 22:
			case 33:
			case 36:
				new ConcurrentenOfMonopolistenvak().neemOpdrachtCon();
				new ConcurrentenOfMonopolistenvak().neemOpdrachtMon();
				return "Neem een Concurrent of Monopolist kaart";
			case 3:
				Stad.getStraten().get(1);
				return "Je komt aan op de Diestsestraat in Leuven";
			case 4:
				speler.setGeld(-200000);
				return "betaal inkomstenbelasting: €200.000";
			case 5:
				return "Je komt aan op het Noordstation";
			case 6:
				Stad.getStraten().get(2);
				return "Je komt aan op de Steenstraat in Brugge";
			case 8:
				Stad.getStraten().get(3);
				return "Je komt aan op Place du Monument in Spa";
			case 9:
				Stad.getStraten().get(4);
				return "Je komt aan op de Kapellestraat in Oostende";
			case 10:
				return "Op bezoek in de gevangenis";
			case 11:
				Stad.getStraten().get(5);
				return "Je komt aan op Rue de Diekirch in Arlon";
			case 12:
				return "Betaal jouw elektriciteitsfactuur, rol de dobbelsteen.";
			case 13:
				Stad.getStraten().get(6);
				return "Je komt aan op Bruul in Mechelen";
			case 14:
				Stad.getStraten().get(7);
				return "Je komt aan op Place Verte in Verviers";
			case 15:
				return "Je komt aan in het Centraalstation";
			case 16:
				Stad.getStraten().get(8);
				return "Je komt aan op de Lippenslaan in Knokke";
			case 18:
				Stad.getStraten().get(9);
				return "Je komt aan op Rue Royale in Tournai";
			case 19:
				Stad.getStraten().get(10);
				return "Je komt aan op de Groenplaats in Antwerpen";
			case 20:
				AntiMonopolyStichting ams = new AntiMonopolyStichting();
				ams.betaalBank();
				ams.getGeld();
				return "Anti-Monopoly Stichting";
			case 21:
				Stad.getStraten().get(11);
				return "Je komt aan op Rue Saint Leonard in Liège";
			case 23:
				Stad.getStraten().get(12);
				return "Je komt aan op de Lange Steenstraat in Kortrijk";
			case 24:
				Stad.getStraten().get(13);
				return "Je komt aan op de Grande Place in Mons";
			case 25:
				return "Je komt aan op Buurtspoorwegen";
			case 26:
				Stad.getStraten().get(14);
				return "Je komt aan op de Grote Markt in Hasselt";
			case 27:
				Stad.getStraten().get(15);
				return "Je komt aan op Place de l'Ange in Namur";
			case 28:
				return "Betaal jouw gasfactuur, rol de dobbelsteen.";
			case 29:
				Stad.getStraten().get(16);
				return "Je komt aan op de Hoogstraat in Brussel";
			case 30:
				return "Ga direct naar de gevangenis, passeer niet langs start.";
				//return "Ga naar de prijzenoorlog, passeer niet langs start";
			case 31:
				Stad.getStraten().get(17);
				return "Je komt aan op de Veldstraat in Gent";
			case 32:
				Stad.getStraten().get(18);
				return "Je komt aan op Boulevard Tirou in Charleroi";
			case 34:
				Stad.getStraten().get(19);
				return "Je komt aan op Boulevard d'Avroy in Liège";
			case 35:
				return "Je komt aan op het Zuidstation";
			case 37:
				Stad.getStraten().get(20);
				return "Je komt aan op de Meir in Antwerpen";
			case 38:
				return "Betaal eigendomsbelasting: €75.000";
			case 39:
				return "Je komt aan in de Nieuwstraat in Brussel";
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Stad.isMonopolyStad("Rood"));					/** Testcode voor isMonopolyStad */
	}
}