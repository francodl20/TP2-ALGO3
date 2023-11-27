package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public interface ISquare {
    public void play(IPlayer player);
    public boolean with(Position position);
}