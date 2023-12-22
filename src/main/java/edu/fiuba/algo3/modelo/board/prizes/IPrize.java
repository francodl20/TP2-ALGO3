package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;

public interface IPrize {
    public void boost(Gladiator player);
    public String getType();
}


