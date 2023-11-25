package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public class BacchanaliaSquare implements Square {
    Position position;

    public BacchanaliaSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(Player player) {
        player.enjoyBacchanalia(4); //la cantidad de bebidas no varía, por qué un parámetro?
        return;
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}