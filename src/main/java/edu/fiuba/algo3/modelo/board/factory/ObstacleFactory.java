package edu.fiuba.algo3.modelo.board.factory;

import edu.fiuba.algo3.modelo.board.obstacles.EmptyObstacle;
import edu.fiuba.algo3.modelo.board.obstacles.Bacchanalia;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.board.obstacles.Injury;
import edu.fiuba.algo3.modelo.board.obstacles.Beast;

public class ObstacleFactory {

    public static IObstacle createObstacle(Object obstacleType) {
        String instanceType = (String)obstacleType;

        if (instanceType.equals("Injury")) {
            return new Injury();
        } else if (instanceType.equals("Beast")) {
            return new Beast();
        } else if (instanceType.equals("Bacchanalia")) {
            return new Bacchanalia();
        } else {
            return new EmptyObstacle();
        }
    }

}