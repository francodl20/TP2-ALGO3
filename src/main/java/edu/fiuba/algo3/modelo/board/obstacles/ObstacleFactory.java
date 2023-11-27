package edu.fiuba.algo3.modelo.board.obstacles;

import edu.fiuba.algo3.modelo.board.Empty;

public class ObstacleFactory {

    public static IObstacle createObstacle(Object obstacleType) {
        String instanceType = (String)obstacleType;

        if (instanceType == "Lesion") {
            return new Injury();
        } else if (instanceType == "Fiera") {
            return new Beast();
        } else if (instanceType == "Bacanal") {
            return new Bacchanalia();
        } else {
            return new Empty();
        }
    }

}