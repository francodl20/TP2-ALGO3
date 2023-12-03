package edu.fiuba.algo3.modelo.board.squares;

import edu.fiuba.algo3.Log;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.board.prizes.IPrize;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.attributes.Coordinate;


public class FinishSquare implements ISquare{
    Coordinate coordinates;
    Integer position;
    IPrize prize;
    IObstacle obstacle;

    public FinishSquare(Coordinate coordinates, Integer position, IPrize prize, IObstacle obstacle) {
        this.coordinates = coordinates;
        this.position = position;
        this.prize = prize;
        this.obstacle = obstacle;
    }

    public void play(Gladiator player){
        Log.getInstance().info(player.getPlayerName()+" llegó a Pompeya!");
        player.arriveToPompeya();
       }
    
    public boolean with(Integer position){
        return (this.position == position);
    }
}
