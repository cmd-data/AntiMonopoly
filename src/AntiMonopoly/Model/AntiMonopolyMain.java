package AntiMonopoly.Model;


import java.time.LocalDateTime;
import java.util.*;

public class AntiMonopolyMain {
    public static void main(String[] args) {

        // Nieuw spel + spelers worden aangemaakt
        Spel spel = new Spel(LocalDateTime.now());

        // Sorteer spelers volgens gerolde waarde + geeft lijst weer van gesorteerd spelers
        spel.getSortedSpelers().forEach(System.out::println);

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
         * Is er dubbel gegooid?
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
         * Einde beurt of opnieuw dobbelen bij dubbel gooien
         *
         * Herhaal
         */



    }
}
