package edu.fiuba.algo3.testUnitarios.board.factory;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.board.factory.ObstacleFactory;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.board.obstacles.Injury;
import edu.fiuba.algo3.modelo.board.obstacles.Beast;
import edu.fiuba.algo3.modelo.board.obstacles.Bacchanalia;
import edu.fiuba.algo3.modelo.board.obstacles.EmptyObstacle;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObstacleFactoryTest {

    @Test
    public void obstacleFactoryCreatesInjury(){

        //Arrange
        Object obstacleType = "Injury";

        IObstacle square = ObstacleFactory.createObstacle(obstacleType);

        //Act
        Boolean result = square instanceof Injury;

        //Assert
        assertTrue(result);
    }  

    @Test
    public void obstacleFactoryCreatesBeast(){

        //Arrange
        Object obstacleType = "Beast";

        IObstacle square = ObstacleFactory.createObstacle(obstacleType);

        //Act
        Boolean result = square instanceof Beast;

        //Assert
        assertTrue(result);
    }  

    @Test
    public void obstacleFactoryCreatesBacchanalia(){
        
        //Arrange
        Object obstacleType = "Bacchanalia";
        
        IObstacle square = ObstacleFactory.createObstacle(obstacleType);
        
        //Act
        Boolean result = square instanceof Bacchanalia;

        //Assert
        assertTrue(result);
    }

    @Test
    public void obstacleFactoryCreatesEmptyObstacle(){
    
        //Arrange
        Object obstacleType = "";
    
        IObstacle square = ObstacleFactory.createObstacle(obstacleType);
    
        //Act
        Boolean result = square instanceof EmptyObstacle;
    
        //Assert
        assertTrue(result);
    }  
}
