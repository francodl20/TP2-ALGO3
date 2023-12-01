package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.board.Board;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipment.Helpless;


import edu.fiuba.algo3.modelo.attributes.gameState.*;
import edu.fiuba.algo3.modelo.attributes.seniority.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestCasosDeUsoS2 {
  private final Integer INITIAL_ENERGY = 20;

    //Caso de uso 13
    @Test   
    public void CanNotReadAJsonWithWrongFormat()throws Exception{
    
    String json = "src/main/resources/JSonFiles/uselessJson.json";
    assertThrows(Exception.class, () -> new Board(json));
}

    @Test   
    //Caso de uso 16
    public void AdheresToDomainModel(){
      //Arrange
        //Gladiators
      String gladiator1Name = "Moquito";
      String gladiator2Name = "HomeMadeMoco";
      Integer gladiator1Position = 0;
      Integer gladiator2Position = 0;
      Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY,gladiator1Position, new Helpless());
      Gladiator gladiator2 = new Gladiator(gladiator2Name,new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless());
      ArrayList<Gladiator> gladiators = new ArrayList<>(); 
      gladiators.add(gladiator1);
      gladiators.add(gladiator2); 

      //Game
      String json = "src/main/resources/JSonFiles/boardTest.json";
      TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());
      IDice dice = new DiceMock(1);
      
      Integer expectedEnergy = 70;
      
      //Act
      for (int i = 0; i <= 7; i++) {
          game.playTurn(dice);
          game.playTurn(dice);
      }
      
      //Assert
      assertEquals(expectedEnergy, game.getCurrentPlayer().getEnergy());
    }

    //Caso de uso 18
    public void theLogWorks(){
      //  Loginator log;
        Boolean result;

      //  result = log.isWorking();

       // assertTrue(result);
    }
}