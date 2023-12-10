package edu.fiuba.algo3.testUnitarios.gameState;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.attributes.gameState.FinishedGameWithWinner;

public class FinishedGameWithWinnerTest {
    
    @Test
    public void getWinnerReturnsProperMessage(){

        //Arrange
        String gladiatorName = "Bro";
        Integer beastSquare = 3;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, beastSquare, new Helpless());
        
        FinishedGameWithWinner gameState = new FinishedGameWithWinner(gladiator);
        String expectedMessage = "Bro has won the game.";

        //Act
        String result = gameState.getWinner();

        //Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void gameHasEnded(){

        //Arrange
        String gladiatorName = "Bro";
        Integer beastSquare = 3;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, beastSquare, new Helpless());
        
        FinishedGameWithWinner gameState = new FinishedGameWithWinner(gladiator);

        //Act
        Boolean result = gameState.hasEnded();

        //Assert
        assertTrue(result);
    }

    @Test
    public void finishedGameCantBeUpdated(){
        //Arrange
        String gladiatorName = "Bro";
        Integer beastSquare = 3;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, beastSquare, new Helpless());
        
        FinishedGameWithWinner gameState = new FinishedGameWithWinner(gladiator);
        String expectedMessage = "Bro has won the game.";

        //Act
        IGameState newGameState = gameState.update(gladiator, null, 20);

        String result = newGameState.getWinner();
        Boolean result2 = newGameState.hasEnded();

        //Assert
        assertEquals(expectedMessage, result);
        assertTrue(result2);
    }
}
