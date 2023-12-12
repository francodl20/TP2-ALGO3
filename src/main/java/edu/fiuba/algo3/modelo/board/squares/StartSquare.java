package edu.fiuba.algo3.modelo.board.squares;


import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.board.prizes.IPrize;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.attributes.Coordinate;


public class StartSquare implements ISquare{
    Coordinate coordinates;
    Integer position;
    IPrize prize;
    IObstacle obstacle;

    public StartSquare(Coordinate coordinates, Integer position, IPrize prize, IObstacle obstacle) {
        this.coordinates = coordinates;
        this.position = position;
        this.prize = prize;
        this.obstacle = obstacle;
    }

    public void play(Gladiator player){
        prize.boost(player);
        obstacle.harm(player);
    }
    
    public boolean with(Integer position){
        return (this.position == position);
    }

    public Coordinate getSquareCoordinate(){
        return this.coordinates;
    }

    public String getPrizeType(){
        return this.prize.getType();
    }
     
    public String getObstacleType(){
        return this.obstacle.getType();
    }
}
