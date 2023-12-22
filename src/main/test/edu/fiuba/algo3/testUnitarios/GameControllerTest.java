package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import java.util.LinkedList;
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.attributes.gameState.OngoingGame;
import edu.fiuba.algo3.modelo.attributes.gameState.TiedGame;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


//Tested
import edu.fiuba.algo3.modelo.GameController;

public class GameControllerTest {
    
    @Test
    public void getCurrentPlayerWorksAsIntended(){

        //Arrange
        String path = "src/main/resources/JSonFiles/boardTest.json";
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;
        Board board = null;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());
        try { board = new Board(path); } catch (Exception e) {}

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        IGameState gameState = new OngoingGame();

        GameController controller = new GameController(gladiators, board, gameState);

        //Act
        Gladiator currentGladiator = controller.getCurrentPlayer();
        Boolean result = currentGladiator.getName().equals(gladiator1Name);

        //Assert
        assertTrue(result);
    }

    @Test
    public void playTurnMovesPlayer(){
        //Arrange
        String path = "src/main/resources/JSonFiles/boardTest.json";
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;
        Board board = null;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());
        try { board = new Board(path); } catch (Exception e) {}

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        IGameState gameState = new OngoingGame();

        D6 dice = mock(D6.class);
        when(dice.roll()).thenReturn(1);
        
        GameController controller = new GameController(gladiators, board, gameState);

        //Act
        controller.playTurn(dice);
        Boolean result = gladiator1.getPosition() == 2;

        //Assert
        assertTrue(result);
    }

    @Test
    public void playTurnStopsWhenGameIsFinished(){
        //Arrange
        String path = "src/main/resources/JSonFiles/boardTest.json";
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;
        Board board = null;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());
        try { board = new Board(path); } catch (Exception e) {}

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        IGameState gameState = new TiedGame();

        D6 dice = mock(D6.class);
        when(dice.roll()).thenReturn(1);
        
        GameController controller = new GameController(gladiators, board, gameState);

        //Act
        controller.playTurn(dice);  
        Boolean result = gladiator1.getPosition() == 1;
        
        //Assert
        assertTrue(result);
    }
}
