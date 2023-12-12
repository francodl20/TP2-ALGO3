package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.Gladiator;


public class Beast implements IObstacle {

    public Beast() { }

    public void harm(Gladiator player) {
        player.fightAgainstWildBeast();
    }

    public String getType(){
        return "Beast";
    }
}