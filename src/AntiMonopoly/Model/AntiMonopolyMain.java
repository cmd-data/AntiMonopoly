package AntiMonopoly.Model;


import java.time.LocalDateTime;

public class AntiMonopolyMain {
    public static void main(String[] args) {

        // Nieuw spel + spelers worden aangemaakt
        Spel spel = new Spel(LocalDateTime.now());

        // Sorteer spelers volgens gerolde waarde + geeft lijst weer van gesorteerde spelers
        spel.getSortedSpelers().forEach(System.out::println);

        // zolang er geen winnaar is blijft het spel in deze loop draaien
        /*while (!spel.eindeSpel()){
            for (Speler speler : Spel.getSpelers()) {
                speler.setAanZet(true);
                spel.verplaatsSpeler(speler,Dice.rollDice());
            }
            }*/

        /** Verloop van het spel:
         *
         * Nieuw spel
         *
         * Spelers worden aangemaakt + money
         *
         * Spelers rollen voor initiative met 1 dobbelsteen
         *
         * Wie is aan zet?
         *
         * Speler is Concurrent? ==> Toch beter in de methodes steken
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
         *      JA ==> huur betalen indien niet van speler
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
