package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.GameInfo;

public class EmptyObstacle implements IObstacle{
    
    public void harm(Gladiator player) { 
       GameInfo.setObstacleInfo("");
    }
}