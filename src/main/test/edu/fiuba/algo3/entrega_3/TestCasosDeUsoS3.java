package edu.fiuba.algo3.entrega_3;

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



public class TestCasosDeUsoS3 {
  private final Integer INITIAL_ENERGY = 20;


    @Test   
    //Caso de uso 19
    public void playerOneWinsTheGame(){
      //Arrange
      String gladiator1Name = "Moquito";
      String gladiator2Name = "Mockito";
      Integer gladiator1Position = 1;
      Integer gladiator2Position = 1;
      Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new Helpless());
      Gladiator gladiator2 = new Gladiator(gladiator2Name,new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless());
      ArrayList<Gladiator> gladiators = new ArrayList<>(); 
      gladiators.add(gladiator1);
      gladiators.add(gladiator2); 

      //Game
      String json = "src/main/resources/JSonFiles/boardTest.json";
      TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());
      IDice diceOne = new DiceMock(1);
      IDice diceTwo = new DiceMock(2);

      IGameState gameState = null;
      
      
      //Act
      game.playTurn(diceOne);

      for (int i = 0; i <= 11; i++) {
          gameState = game.playTurn(diceTwo);
      }
      
      //Assert
      assertEquals("Moquito has won the game.", gameState.getWinner());
    }

    @Test   
    //Caso de uso 20
    public void playerLosesTheGame(){
      //Arrange
      String gladiator1Name = "Moquito";
      String gladiator2Name = "Mockito";
      Integer gladiator1Position = 1;
      Integer gladiator2Position = 1;
      Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new Helpless());
      Gladiator gladiator2 = new Gladiator(gladiator2Name,new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless());
      ArrayList<Gladiator> gladiators = new ArrayList<>(); 
      gladiators.add(gladiator1);
      gladiators.add(gladiator2); 

      //Game
      String json = "src/main/resources/JSonFiles/boardTest.json";
      TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());
      IDice diceOne = new DiceMock(0);

      IGameState gameState = null;
      
      
      //Act

      for (int i = 0; i <= 30; i++) {
          gameState = game.playTurn(diceOne);
          gameState = game.playTurn(diceOne);
      
      }
      
      //Assert
      assertEquals("Game Tied.", gameState.getWinner());
    }
}