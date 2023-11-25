package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public class EquipmentSquare implements Square {
    Position position;

    public EquipmentSquare(Position aPosition) {
        position = aPosition;
    }

    public void play(Player player) {
        player.enhanceArmour();
        return;
    }

    public boolean with(Position position){
        return this.position.equals(position);
    }
}