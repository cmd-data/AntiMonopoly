package AntiMonopoly.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaillietWinnaar {

    /**
     * is deze speler de winnaar?
     * @param
     * @return
     */

        /*public static boolean isWinnaar(Speler speler){
            int count = 0;
            for (int i = 0; i < Spel.getSpelers().size(); i++) {
                if(speler.isFailliet(Spel.getSpelers().get(i))){
                    count++;
                }
            }
            /**
             * als count gelijk is aan alle spelers min 1 speler en die speler is niet failliet dan is hij de winnaar
             *

            return count == Spel.getSpelers().size() - 1 && !speler.isFailliet(speler);
        }*/

    public static Speler isWinnaar (){

        Speler winnaar = null;

        List<Integer> scores = new ArrayList<>();
        for (Speler speler : Spel.getSpelers()) {
            scores.add(speler.getGeld());
        }
        Collections.sort(scores,Collections.reverseOrder());

        for (Speler speler : Spel.getSpelers()) {
            if (speler.getGeld()==scores.get(0)){
                winnaar = speler;
            }
        }
        return winnaar;
    }

    /**
     * ga door spelerlijst en kijk of er een winnaar tussen zit
     * @return
     */

    /*public static Speler winnaar () {
            Speler winnaar = null;
            for (Speler speler : Spel.getSpelers()) {
                if(isWinnaar(winnaar)){
                    winnaar = speler;
                }
            }
            return winnaar;
        }*/
}
