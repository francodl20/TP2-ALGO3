package edu.fiuba.algo3.testUnitarios.board;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.Board;

public class BoardTest {
    
    @Test
    public void boardFindsTheRightSquare(){

        //Arrange
        String path = "src/main/resources/JSonFiles/boardTest.json";
        String gladiatorName = "Bro";
        Integer beastSquare = 3;
        Integer energy = 20;
        Board board = null;

        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, beastSquare, new Helpless());
        try { board = new Board(path); } catch (Exception e) {}

        Integer expectedEnergy = 0;

        //Act
        board.playWith(gladiator);

        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }

    @Test
    public void pompeiiLocationIsCorrect(){
        //Arrange
        String path = "src/main/resources/JSonFiles/boardTest.json";
        String gladiatorName = "Bro";
        Integer justBeforFinish = 11;
        Integer energy = 20;
        Board board = null;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, justBeforFinish, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiatorName, new Novice(), energy, justBeforFinish + 1, new Helpless());
        try { board = new Board(path); } catch (Exception e) {}

        //Act
        Boolean resultFalse = board.pompeiiHas(gladiator);
        Boolean resultTrue = board.pompeiiHas(gladiator2);

        //Assert
        assertFalse(resultFalse);
        assertTrue(resultTrue);
    }
}
