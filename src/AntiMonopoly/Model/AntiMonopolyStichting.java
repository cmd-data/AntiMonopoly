package AntiMonopoly.Model;

public class AntiMonopolyStichting extends Tegel {

	public AntiMonopolyStichting(String naam, int positie) {
		super(naam, positie);
	}

	static int rol;

	public static void voerUit(Speler speler) {
		if (speler.getIsConcurrent()) {
			int rol = Dice.rollDie();
			switch (rol) {
				case 1:
					speler.setGeld(25000);
					AntiMonopolyStichting.rol = 25000;
					break;
				case 2:
					speler.setGeld(50000);
					AntiMonopolyStichting.rol = 50000;
			}
		} else {
			speler.setGeld(-160000);
		}
		Spel.updateGeld(speler);
	}

	public static int getRol() {
		return rol;
	}
}
