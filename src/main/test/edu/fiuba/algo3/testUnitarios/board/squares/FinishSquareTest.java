package edu.fiuba.algo3.testUnitarios.board.squares;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.board.obstacles.EmptyObstacle;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Key;

//Tested
import edu.fiuba.algo3.modelo.board.squares.FinishSquare;


public class FinishSquareTest {
    
    @Test
    public void gladiatorReachesPompeii() {
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 20;
        Integer energy = 10;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Key());

        Coordinate coord = new Coordinate(1, 1);
        EmptyPrize emptyP = new EmptyPrize();
        EmptyObstacle epmtyO = new EmptyObstacle();
        FinishSquare pompeii = new FinishSquare(coord, 20, emptyP, epmtyO);

        //Act
        pompeii.play(gladiator);

        //Assert
        assertEquals(gladiatorPosition, gladiator.getPosition());
    }
}
