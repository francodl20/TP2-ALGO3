package edu.fiuba.algo3.modelo.board.obstacles;
import edu.fiuba.algo3.modelo.Gladiator;

public class EmptyObstacle implements IObstacle{
    
    public void harm(Gladiator player) { 
       //Empty behaviour needed 
    }
    
    public String getType(){
        return "Empty";
    }

}