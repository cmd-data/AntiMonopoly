package AntiMonopoly.Model;

public class GaNaarGevangenis extends Tegel {


    public GaNaarGevangenis(String naam, int positie) {
        super(naam, positie);
    }

    public static void gaNaarGevangenis(Speler speler){
        Spel.move(speler,Spelbord.getTegels().get(10));
        Gevangenis.getGevangenen().add(speler);
    }


}
