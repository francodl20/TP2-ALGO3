package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.GameInfo;

public class EmptyPrize implements IPrize{

    public void boost(Gladiator player) { 
        GameInfo.setPrizeInfo("");
    }
}