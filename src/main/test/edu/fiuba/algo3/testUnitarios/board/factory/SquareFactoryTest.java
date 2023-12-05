package edu.fiuba.algo3.testUnitarios.board.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.board.factory.SquareFactory;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.board.squares.StartSquare;
import edu.fiuba.algo3.modelo.board.squares.PathSquare;
import edu.fiuba.algo3.modelo.board.squares.FinishSquare;
import edu.fiuba.algo3.modelo.attributes.Coordinate;

public class SquareFactoryTest {
    
    @Test
    public void squareFactoryCreatesStart(){
        //Arrange
        Coordinate coord = new Coordinate(1, 1);
        Integer position = 1;
        Object squareType = "Start";
        Object obstacle = "";
        Object prize = "";

        ISquare square = SquareFactory.createSquare(coord, position, squareType, obstacle, prize);

        //Act
        Boolean result = square instanceof StartSquare;

        //Assert
        assertTrue(result);
    }

    @Test
    public void squareFactoryCreatesPath(){
        //Arrange
        Coordinate coord = new Coordinate(1, 1);
        Integer position = 1;
        Object squareType = "Path";
        Object obstacle = "";
        Object prize = "";

        ISquare square = SquareFactory.createSquare(coord, position, squareType, obstacle, prize);

        //Act
        Boolean result = square instanceof PathSquare;

        //Assert
        assertTrue(result);
    }
    @Test
    public void squareFactoryCreatesFinish(){
        //Arrange
        Coordinate coord = new Coordinate(1, 1);
        Integer position = 1;
        Object squareType = "Finish";
        Object obstacle = "";
        Object prize = "";

        ISquare square = SquareFactory.createSquare(coord, position, squareType, obstacle, prize);

        //Act
        Boolean result = square instanceof FinishSquare;

        //Assert
        assertTrue(result);
    }
}
