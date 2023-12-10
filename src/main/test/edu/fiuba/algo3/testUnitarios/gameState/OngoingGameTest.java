package edu.fiuba.algo3.testUnitarios.gameState;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.board.Board;

//Tested
import edu.fiuba.algo3.modelo.attributes.gameState.OngoingGame;

public class OngoingGameTest {
    
    @Test
    public void getWinnerReturnsProperMessage(){

        //Arrange       
        OngoingGame gameState = new OngoingGame();
        String expectedMessage = "There's no winner yet.";

        //Act
        String result = gameState.getWinner();

        //Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void gameHasntEnded(){

        //Arrange
        OngoingGame gameState = new OngoingGame();

        //Act
        Boolean result = gameState.hasEnded();

        //Assert
        assertFalse(result);
    }

    @Test
    public void updateReturnsFinishedGame(){
        //Arrange
            //Gladiator
        String gladiatorName = "Bro";
        Integer pompeiiPosition = 12;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, pompeiiPosition, new Key());
            //Board
        String jsonPath = "src/main/resources/JSonFiles/boardTest.json";
        Board board = null;
        try { board = new Board(jsonPath); } catch (Exception e) {}
            //GameState
        OngoingGame gameState = new OngoingGame();

        //Act
        IGameState newGameState = gameState.update(gladiator, board, 1);
        Boolean result = (newGameState.hasEnded()) && 
                         (newGameState.getWinner().equals("Bro has won the game.")); 

        //Assert
        assertTrue(result);
    }

    @Test
    public void updateReturnsTiedGame(){
        //Arrange
            //Gladiator
        String gladiatorName = "Bro";
        Integer notPompeii = 10;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, notPompeii, new Helpless());
            //Board
        String jsonPath = "src/main/resources/JSonFiles/boardTest.json";
        Board board = null;
        try { board = new Board(jsonPath); } catch (Exception e) {}
            //GameState
        OngoingGame gameState = new OngoingGame();

        //Act
        IGameState newGameState = gameState.update(gladiator, board, 31);
        Boolean result = (newGameState.hasEnded()) && 
                         (newGameState.getWinner().equals("Game Tied.")); 


        //Assert
        assertTrue(result);
    }
}
