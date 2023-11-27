package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public class FoodSquare implements ISquare {
    Position position;

    public FoodSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(IPlayer player) {
        player.eat();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}