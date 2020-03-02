package AntiMonopoly.Model;

public class Straten extends Stad {

	private String straat;
	private int prijs;
	private int huur;
	private int hypotheek;
	private int prijsHuis;
	private Speler eigenaar;
	private final int MAXHOTEL = 1;
	private final int MAXHUISMON = 3;
	private final int MAXHUISCON = 4;
	private Gebouwen gebouw;
	private int aantalGebouwen;
	private String stad;

	public Straten(){}
	public Straten(String straat, int prijs, int huur, int hypotheek, int prijsHuis, Speler eigenaar, Gebouwen gebouw, int aantalGebouwen, String stad) {
		this.straat = straat;
		this.prijs = prijs;
		this.huur = huur;
		this.hypotheek = hypotheek;
		this.prijsHuis = prijsHuis;
		this.eigenaar = eigenaar;
		this.gebouw = gebouw;
		this.aantalGebouwen = aantalGebouwen;
		this.stad = stad;
	}

	public String getStraat() { return straat; }

	public int getPrijs()
	{
		return this.prijs;
	}

	public int getHuur()
	{
		return this.huur;
	}

	public int getHypotheek()
	{
		return this.hypotheek;
	}

	public int getPrijsHuis() { return prijsHuis; }

	public Speler getEigenaar() { return this.eigenaar; }

	public void setEigenaar(Speler eigenaar)
	{
		this.eigenaar = eigenaar;
	}

	public int getMaxHotel() { return MAXHOTEL; }

	public int getMaxHuisMon() { return MAXHUISMON; }

	public int getMaxHuisCon() { return MAXHUISCON; }

	public Gebouwen getGebouw()
	{
		return this.gebouw;
	}

	public void setGebouw(Gebouwen gebouw) {

		/**
		 * hoe geef ik een hotel of huis is ? new Huis(); lukte niet
		 */

		this.gebouw = gebouw;
	}

	public int getAantalGebouwen() { return aantalGebouwen; }

	public void setAantalGebouwen(int aantalGebouwen) {
		this.aantalGebouwen = aantalGebouwen;
	}

	public String getStad() { return this.stad; }

}