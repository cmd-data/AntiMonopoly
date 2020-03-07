package AntiMonopoly.Model;

public class AntiMonopolyStichting extends Tegel {
	Dice dice = new Dice();

	public AntiMonopolyStichting(String naam, int positie) {
		super(naam, positie);
	}

	public void betaalBank(Speler speler) {
		speler.setGeld(-160000);
	}

	public void getGeld(Speler speler) {
		int rol = dice.rollDice();
		switch(rol){
			case 1: speler.setGeld(25000); break;
			case 2: speler.setGeld(50000);
		}
	}

}