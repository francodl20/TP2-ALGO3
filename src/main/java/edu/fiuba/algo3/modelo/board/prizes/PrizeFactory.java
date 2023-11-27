package edu.fiuba.algo3.modelo.board.prizes;

import edu.fiuba.algo3.modelo.board.Empty;
import java.util.*;



public class PrizeFactory {
    public static IPrize createPrize(Object prize){
        String instanceType = (String)prize;

        Map<String, IPrize> prizeTypes = new HashMap<>();

        prizeTypes.put("", new Empty());
        prizeTypes.put("Equipamiento", new Equipment());
        prizeTypes.put("Comida", new Food());
        
        return (prizeTypes.get(instanceType));
    }
}
