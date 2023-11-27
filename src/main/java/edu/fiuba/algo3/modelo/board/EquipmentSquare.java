package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;

public class EquipmentSquare implements ISquare {
    Position position;

    public EquipmentSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(IPlayer player) {
        player.enhanceArmour();
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}