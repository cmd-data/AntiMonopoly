package AntiMonopoly.Model;

/*public class GasEnElektriciteitsbedrijf extends Tegel {

	private List<GasEnElektriciteitsbedrijf> gasEnElektriciteitsbedrijf = new ArrayList<>();

	private final int waarde = 150000;		//kostprijs tegel
	private String eigenaar;				//eigenaar tegel
	private String naam;					//naam tegel

	public GasEnElektriciteitsbedrijf(String naam, String eigenaar) {
		this.naam = naam;
		this.eigenaar = eigenaar;
	}

	public void voegToe(){
		gasEnElektriciteitsbedrijf.add(new GasEnElektriciteitsbedrijf("Elektriciteitsbedrijf",null));
		gasEnElektriciteitsbedrijf.add(new GasEnElektriciteitsbedrijf("Gasbedrijf",null));

	}

	public String getEigenaar() {
		return eigenaar;
	}

	public String getNaam() {
		return naam;
	}

	public void setEigenaar(String eigenaar) {
		this.eigenaar = eigenaar;
	}

	Speler speler = new Speler();
	Dice dice = new Dice();
	private void betaalHuur(GasEnElektriciteitsbedrijf gasEnElektriciteitsbedrijf) {
		String eigenaar = gasEnElektriciteitsbedrijf.getEigenaar();
		int aantal = 1;
		if(speler.getIsConcurrent()==true){
			dice.rollDice();
			int waardeWorp = dice.getWaardeWorp();
			speler.setGeld(-waardeWorp*4);
		} else {
			for (int i = 0; i < this.gasEnElektriciteitsbedrijf.size(); i++) {
				if (eigenaar.equals(gasEnElektriciteitsbedrijf.get(i).getEigenaar())&&!gasEnElektriciteitsbedrijf.equals(gasEnElektriciteitsbedrijf.get(i))){
					aantal++;		/** weet niet goed waarom de get niet werkt *//*
				}
				dice.rollDice();
				int waardeWorp = dice.getWaardeWorp();

				if (aantal == 1) {
					speler.setGeld(-waardeWorp * 4);
				}

				if (aantal == 2) {
					speler.setGeld(-waardeWorp * 10);
				}

			}

		}
	}
}*/





