package edu.fiuba.algo3.modelo.board.obstacles;

import edu.fiuba.algo3.modelo.board.Empty;

public class ObstacleFactory {

    public static IObstacle createObstacle(Object obstacleType) {
        String instanceType = (String)obstacleType;

        if (instanceType.equals("Lesion")) {
            return new Injury();
        } else if (instanceType.equals("Fiera")) {
            return new Beast();
        } else if (instanceType.equals("Bacanal")) {
            return new Bacchanalia();
        } else {
            return new Empty();
        }
    }

}