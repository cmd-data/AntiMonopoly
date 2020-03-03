package AntiMonopoly.Model;

public class FaillietWinnaar {
        public boolean isWinnaar(Speler speler){
            int count = 0;
            for (int i = 0; i < Spel.getSpelers().size(); i++) {
                if(Speler.isFailliet(Spel.getSpelers().get(i))){
                    count++;
                }
            }
            /**
             * als count gelijk is aan alle spelers min 1 speler en die speler is niet failliet dan is hij de winnaar
             */
            if(count==Spel.getSpelers().size()-1&&!Speler.isFailliet(speler)){
                return true;
            } else { return false; }
        }
}
