package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public class FoodSquare implements Square {
    Position position;

    public FoodSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(Player player) {
        player.eat();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}