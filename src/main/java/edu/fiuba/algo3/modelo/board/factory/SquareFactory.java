package edu.fiuba.algo3.modelo.board.factory;

import edu.fiuba.algo3.modelo.board.squares.FinishSquare;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.board.squares.PathSquare;
import edu.fiuba.algo3.modelo.board.squares.StartSquare;
import edu.fiuba.algo3.modelo.attributes.Coordinate;



public class SquareFactory {
    public static ISquare createSquare(Coordinate coordinates, Integer position, Object type, Object obstacle, Object prize){
        String instanceType = (String)type;

        if (instanceType.equals("Start")){
            return new StartSquare(coordinates, position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        } else if (instanceType.equals("Finish")){
            return new FinishSquare(coordinates, position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        } else {
            return new PathSquare(coordinates, position, PrizeFactory.createPrize(prize), 
                                            ObstacleFactory.createObstacle(obstacle));
        }
    }
}
