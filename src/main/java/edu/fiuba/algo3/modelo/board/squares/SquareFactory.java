package edu.fiuba.algo3.modelo.board.squares;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.prizes.PrizeFactory;
import edu.fiuba.algo3.modelo.board.obstacles.ObstacleFactory;


public class SquareFactory {
    public static ISquare createSquare(Position position, Object type, Object obstacle, Object prize){
        String instanceType = (String)type;

        if (instanceType == "Salida"){
            return new StartSquare(position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        } else if (instanceType == "Llegada"){
            return new FinishSquare(position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        } else {
            return new PathSquare(position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        }
    }
}
