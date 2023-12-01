package edu.fiuba.algo3.modelo.board.factory;

import java.util.*;

import edu.fiuba.algo3.modelo.board.prizes.IPrize;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;
import edu.fiuba.algo3.modelo.board.prizes.Equipment;
import edu.fiuba.algo3.modelo.board.prizes.Food;



public class PrizeFactory {
    public static IPrize createPrize(Object prize){
        String instanceType = (String)prize;

        Map<String, IPrize> prizeTypes = new HashMap<>();

        prizeTypes.put("", new EmptyPrize());
        prizeTypes.put("Equipment", new Equipment());
        prizeTypes.put("Food", new Food());
        
        return (prizeTypes.get(instanceType));
    }
}
