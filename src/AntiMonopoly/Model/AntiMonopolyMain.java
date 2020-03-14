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
                    System.out.println("Naam: " + speler.getNaam());                      // test code
                    speler.setAanZet(true);
                    if (speler.isFailliet(speler)){
                        speler.setAanZet(false);
                    }
                    while (speler.isAanZet()) {
                        if (!Spel.checkGevangenis(speler)) {
                            int rol = Dice.rollDice();
                            Tegel tegel = Spel.move(speler, rol);

                            System.out.println("Rol: " + rol);                                 // test code
                            System.out.println("Geld: " + speler.getGeld());                   // test code

                            tegel.tegelMethode(tegel, speler);

                            System.out.println("Tegel: " + tegel.getNaam());                   // test code
                            System.out.println(tegel.getPositie());                          // test code
                            System.out.println("Geld na beurt: " + speler.getGeld());          // test code

                            if (!Dice.isIsDubbel()) {
                                speler.setAanZet(false);
                            }
                            if (speler.isFailliet(speler)) {
                                speler.setAanZet(false);
                            }
                        }
                    }
                } else {
                    System.out.println("Naam: " + speler.getNaam());                      // test code
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
