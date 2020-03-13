package AntiMonopoly.Model;

public class AntiMonopolyStichting extends Tegel {

	public AntiMonopolyStichting(String naam, int positie) {
		super(naam, positie);
	}

	public static void voerUit(Speler speler){
		if(speler.getIsConcurrent()){
			int rol = Dice.rollDie();
			switch(rol){
				case 1: speler.setGeld(25000); break;
				case 2: speler.setGeld(50000);
			}
		} else {
			speler.setGeld(-160000);
		}
	}

}