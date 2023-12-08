package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.Log;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.exceptions.InvalidJSONFormatException;
import edu.fiuba.algo3.modelo.attributes.gameState.*;
import edu.fiuba.algo3.modelo.attributes.seniority.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestCasosDeUsoS2 {
  private final Integer INITIAL_ENERGY = 20;

    //Caso de uso 13
    @Test   
    public void canNotReadAJsonWithWrongFormat()throws Exception{
    
    String json = "src/main/resources/JSonFiles/uselessJson.json";
    assertThrows(InvalidJSONFormatException.class, () -> new Board(json));
} 
      //                      ^error or exception?

    @Test   
    //Caso de uso 16
    public void verifyCorrectParsing(){
      //Arrange
      String gladiator1Name = "Moquito";
      String gladiator2Name = "HomeMadeMoco";
      Integer gladiator1Position = 0;
      Integer gladiator2Position = 0;
      Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY,gladiator1Position, new Helpless(), new D6());
      Gladiator gladiator2 = new Gladiator(gladiator2Name,new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless(), new D6());
      ArrayList<Gladiator> gladiators = new ArrayList<>(); 
      gladiators.add(gladiator1);
      gladiators.add(gladiator2); 

      //Game
      String json = "src/main/resources/JSonFiles/boardTest.json";
      Board board = null;
      try {
        board = new Board(json);
      } catch (Exception e) {
        e.printStackTrace();
      }
      GameController game = new GameController(gladiators, board, new OngoingGame());
      D6 dice = mock(D6.class);
      when(dice.roll()).thenReturn(1);

      Integer expectedEnergy = 20 - 15 - 10 + 5 + 5;
      
      //Act
      for (int i = 0; i <= 7; i++) {
          game.playTurn(dice);
          game.playTurn(dice);
      }
      
      //Assert
      assertEquals(expectedEnergy, game.getCurrentPlayer().getEnergy());
    }

    @Test
    //Caso de uso 18
    public void theLogWorks(){
      //Arrange
      ByteArrayOutputStream logOutput = new ByteArrayOutputStream();
      System.setOut(new PrintStream(logOutput));
      Log log = Log.getInstance();

      //Act
      log.info("This is a test message for use case 18");
      String output = logOutput.toString().trim();
      System.setOut(System.out);

      //Assert
      assertEquals("This is a test message for use case 18", output);
    }
}