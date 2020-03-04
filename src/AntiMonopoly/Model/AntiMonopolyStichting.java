package AntiMonopoly.Model;

public class AntiMonopolyStichting extends Tegel {

	public AntiMonopolyStichting(String naam, int positie) {
		super(naam, positie);
	}

	public void betaalBank() {
		Speler.setGeld(-160000);
	}

	public void getGeld() {
				if (Dice.rollDice() == 1){
					Speler.setGeld(25000);
				}
				if (Dice.rollDice() == 2){
					Speler.setGeld(50000);
				}
	}

}