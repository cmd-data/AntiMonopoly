package AntiMonopoly.Model;


import java.time.LocalDateTime;

public class AntiMonopolyMain {
    public static void main(String[] args) {

        //test1

        // Nieuw spel + spelers worden aangemaakt
        Spel spel = new Spel(LocalDateTime.now());

        // Sorteer spelers volgens gerolde waarde + geeft lijst weer van gesorteerde spelers
        System.out.println("Volgorde van de spelers: ");
        spel.getSortedSpelers().forEach(System.out::println);

        while (!spel.eindeSpel()){
            for (Speler speler : Spel.getSpelers()) {
                if (!Spel.checkGevangenis(speler)) {
                    System.out.println(speler.getNaam());
                    speler.setAanZet(true);
                    while (speler.isAanZet()) {
                        int rol = Dice.rollDice();
                        Tegel tegel = Spel.move(speler, rol);
                        System.out.println(rol);                                // test code
                        tegel.tegelMethode(tegel, speler);
                        System.out.println(speler.getGeld());                   // test code
                        System.out.println(speler.waardeBezittingen(speler));   // test code // Hier geen OutOfMemory exception maar in methode zelf wel??
                        if (!Dice.isIsDubbel()) {
                            speler.setAanZet(false);
                        }
                    }
                } else {
                    Gevangenis.verlaatGevangenis(speler);
                }
            }
        }

        System.out.printf("Einde spel\nDe winnaar is: %s");

        /** Verloop van het spel:
         *
         * Nieuw spel
         *
         * Spelers worden aangemaakt
         *
         * Spelers rollen voor initiative met 1 dobbelsteen
         *
         * Wie is aan zet?
         *
         * In gevangenis?
         *
         * Speler rolt met 2 dobbelstenen
         *
         * Speler verandert van positie
         *
         * Check passeert start
         *
         * Op wat voor soort tegel is de speler beland?
         * Iets dat gekocht kan worden?
         * NEE ==> speciale tegel uitvoeren
         * JA ==> Is er een eigenaar?
         *      JA ==>
         *       Hypotheek?
         *          *      JA ==> doe niets
         *          *      NEE ==> huur betalen indien niet van speler
         *      NEE ==> Kopen?
         *
         * Check failliet/winnaar
         *
         * Spelopties (verkopen, hypotheek en bouwen)
         *
         * Is er dubbel gegooid?
         * Einde beurt of opnieuw dobbelen bij dubbel gooien
         *
         * Herhaal
         */



    }
}
