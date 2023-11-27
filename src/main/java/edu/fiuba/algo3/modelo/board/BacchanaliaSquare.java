package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public class BacchanaliaSquare implements ISquare {
    Position position;
        
    public BacchanaliaSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(IPlayer player) {
        player.enjoyBacchanalia(4);
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}