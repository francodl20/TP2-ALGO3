package edu.fiuba.algo3.testUnitarios.board.squares;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.obstacles.EmptyObstacle;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;
import edu.fiuba.algo3.modelo.board.obstacles.Beast;
import edu.fiuba.algo3.modelo.board.prizes.Food;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.squares.PathSquare;

public class PathSquareTest {
    
    @Test
    public void gladiatorGetsHitAndHealed() {
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 10;
        Integer energy = 5;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Coordinate coord = new Coordinate(1, 1);
        Food food = new Food();
        Beast beast = new Beast();
        PathSquare pompeii = new PathSquare(coord, 10, food, beast);

        Integer expectedEnergy = 5 + 15 - 20;

        //Act
        pompeii.play(gladiator);

        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }

    @Test
    public void squareHasThePosition() {
        //Arrange
        Coordinate coord = new Coordinate(1, 1);
        Integer position = 20;
        EmptyPrize emptyP = new EmptyPrize();
        EmptyObstacle epmtyO = new EmptyObstacle();
        PathSquare pompeii = new PathSquare(coord, position, emptyP, epmtyO);

        //Act
        Boolean result = pompeii.with(position);

        //Assert
        assertTrue(result);
    }

    @Test
    public void returnsTheGivenPosition() {
        //Arrange
        Coordinate coord = new Coordinate(1, 1);
        EmptyPrize emptyP = new EmptyPrize();
        EmptyObstacle epmtyO = new EmptyObstacle();
        PathSquare pompeii = new PathSquare(coord, 20, emptyP, epmtyO);

        //Act
        Coordinate result = pompeii.getSquareCoordinate();

        //Assert
        assertEquals(coord, result);
    }
}
