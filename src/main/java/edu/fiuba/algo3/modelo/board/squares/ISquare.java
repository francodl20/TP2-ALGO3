package edu.fiuba.algo3.modelo.board.squares;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public interface ISquare {

    //Acts according to the square content
    public void play(IPlayer player);
    
    //Returns true if the position matches, false if not
    public boolean with(Position position);
}