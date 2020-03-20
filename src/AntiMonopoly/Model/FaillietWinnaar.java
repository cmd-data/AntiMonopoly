package AntiMonopoly.Model;

public class FaillietWinnaar {

    /**
     * is deze speler de winnaar?
     * @param speler
     * @return
     */

        public static boolean isWinnaar(Speler speler){
            int count = 0;
            for (int i = 0; i < Spel.getSpelers().size(); i++) {
                if(speler.isFailliet(Spel.getSpelers().get(i))){
                    count++;
                }
            }
            /**
             * als count gelijk is aan alle spelers min 1 speler en die speler is niet failliet dan is hij de winnaar
             */

            return count == Spel.getSpelers().size() - 1 && !speler.isFailliet(speler);
        }

    /**
     * ga door spelerlijst en kijk of er een winnaar tussen zit
     * @return
     */

    public static Speler winnaar () {
            Speler winnaar = null;
            for (Speler speler : Spel.getSpelers()) {
                if(isWinnaar(speler)){
                    winnaar = speler;
                }
            }
            return winnaar;
        }
}
