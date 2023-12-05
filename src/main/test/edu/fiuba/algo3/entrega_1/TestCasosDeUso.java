package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.factory.SquareFactory;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.attributes.gameState.*;
import edu.fiuba.algo3.modelo.attributes.seniority.*;


import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestCasosDeUso {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 15;
    private final Integer ZERO_ENERGY = 0;
    private final Integer INITIAL_ENERGY = 20;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_SWORD_AND_SHIELD_FROM_ZERO_ENERGY = -2;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY = -15;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY = 0;

    private final Integer SEMISENIOR_BONUS = 5;
    private final Integer SEMISENIOR_THRESHOLD = 8;
   // private final Integer SENIOR_BONUS = 10;
    

    private final Integer MAX_ROUNDS = 30;
    //Caso de uso 01
    @Test   
    public void gladiatorBeginsWithInitialEnergyAndEquipment() {
        //Arrange
            //Gladiators
        String gladiator1Name = "Mockito";
        String gladiator2Name = "HomeMadeMock";
        Integer gladiator1Position = 0;
        Integer gladiator2Position = 0;
        IDice dice = new DiceMock(1);
        Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new Helpless(), dice);
        Gladiator gladiator2 = new Gladiator(gladiator2Name, new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless(), dice);
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);  
            //Game
        
        String json = "src/main/resources/JSonFiles/boardMock.json";
        TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());
        

        //Dice diceMock = mock(Dice.class);
    
        //Act
        game.playTurn();
        
        //Assert
        //BORRAR LOS GET ESTA EN PROCESO
        //Initial energy is correct
        assertEquals(gladiator1.getEnergy(), INITIAL_ENERGY); 
        assertEquals(gladiator2.getEnergy(), INITIAL_ENERGY);

        //Energy after fighting the beast corresponds with the equipment
        gladiator1.fightAgainstWildBeast();
        assertEquals(gladiator1.getEnergy(), ZERO_ENERGY);

    }

    //Caso de Uso 02
    @Test   
    //todo: preguntar si hay que usar tablero o no hace falta
    public void gladiatorIsAbleToMove() {
        //Arrange
            //Gladiators
        String gladiator1Name = "Mockito";
        String gladiator2Name = "HomeMadeMock";
        Integer gladiator1Position = 0;
        Integer gladiator2Position = 0;
        Integer squaresToMove = 5;
        IDice dice = new DiceMock(squaresToMove);
        Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new Helpless(), dice);
        Gladiator gladiator2 = new Gladiator(gladiator2Name, new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless(), dice);
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

            //Game 
        String json = "src/main/resources/JSonFiles/boardMock.json";
        TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());

        Integer finalPosition = 2*squaresToMove;

        //Act
        game.playTurn(); //gladiator1
        game.playTurn(); //gladiator2
        game.playTurn(); //gladiator1
        game.playTurn(); //gladiator2

        //Assert
        assertEquals(finalPosition, gladiator1.getCurrentPosition());
    }

    //Caso de uso 03
    @Test
    public void gladiatorWithoutEnergyCannotPlayTurn() {
        //Arrange
        String gladiatorName = "Pedro";
        Integer expectedPosition = 0;
        Integer squaresToMove = 1;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, expectedPosition, new Helpless(), dice);

        //Act 
        gladiator.playTurn();

        //Assert
        assertEquals(expectedPosition, gladiator.getCurrentPosition());
    }

    //Caso de uso 04
    @Test
    public void eatingIncreasesEnergyInTenUnits() {
        //Arrange
        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Helpless(), dice);
        Integer expectedEnergy = ENERGY_RECOVERED_AFTER_MEAL;

        //Act
        gladiator.eat();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

     //Caso de uso 05
    @Test
    public void improvingEquipmentForTheFirstTimeGivesAHelmet() {
        //Arrange
        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Helpless(), dice);
        Integer expectedEnergy = (ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY);
        
        //Act
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();
        
        //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

       //Caso de uso 06
    @Test
    public void improvingEquipmentForTheThirdTimeGivesASwordAndShield() {
        //Arrange
         String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Helpless(), dice);
        Integer expectedEnergy = (ENERGY_AFTER_FIGHTING_WITH_SWORD_AND_SHIELD_FROM_ZERO_ENERGY);

        //Act
        gladiator.enhanceArmour();
        gladiator.enhanceArmour();
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

      //Caso de uso 07
      @Test
    public void fightingWithAWildBeastWearingAHelmet() {
        //Arrange
        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Helmet(), dice);
        Integer expectedEnergy = (ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

    //Caso de uso 08
    @Test
    public void afterEightTurnsNoviceBecomesSeniorAndHisEnergyIncreasesInTheNextMove(){
        //Arrange
        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 1;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), INITIAL_ENERGY, gladiatorPosition, new Helpless(), dice);
        
        Integer expectedEnergy = (INITIAL_ENERGY + SEMISENIOR_BONUS);

        //Act
        for (Integer i = 0; i <= SEMISENIOR_THRESHOLD; i++) {
            gladiator.playTurn();
        }
        //Assert
        assertEquals(gladiator.getEnergy(), expectedEnergy);
    }

    //Caso de uso 09
    @Test
    public void arrivingToTheGoalWithoutTheKeyMovesBackToTheMiddleOfTheBoard() { //todo:
        //Arrange
        String gladiator1Name = "Jose";
        String gladiator2Name = "Pedro";
        Integer gladiator1Position = 24;
        Integer gladiator2Position = 24;
        Integer squaresToMove = 1;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new SwordAndShield(), dice);
        Gladiator gladiator2 = new Gladiator(gladiator2Name, new Novice(), INITIAL_ENERGY, gladiator2Position, new Key(), dice);

        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

            //Game
        String json = "src/main/resources/JSonFiles/boardMock.json";
        TurnManager game = new TurnManager(gladiators, new Board(json), new OngoingGame());
            //Objective
        Integer targetPosition = 24/2;
        Object type = "Path";
        Object prize = "";
        Object obstacle = "";
        ISquare targetSquare = SquareFactory.createSquare(new Coordinate(3, 10), targetPosition, type, obstacle, prize);
        Integer targetPosition2 = 25;
        Object type2 = "Finish";
        Object prize2 = "";
        Object obstacle2 = "";
        ISquare targetSquare2 = SquareFactory.createSquare(new Coordinate(10, 4), targetPosition2, type2, obstacle2, prize2);

        
        //Act
        game.playTurn();
        game.playTurn();

        //Assert
        assertTrue(gladiator1.in(targetSquare));
        
        //Assert
        assertTrue(gladiator2.in(targetSquare2));
    }

    //Caso de uso 10
    @Test
    public void gladiatorDoesNotReceiveDamageFromTheBeastWhenWearingTheKey() {
        //Arrange

        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Key(), dice);
    
        Integer expectedEnergy = (ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }


    //Caso de uso 11
    @Test
    public void receivingAPrizeWithTheKeyDoesNotChangeTheEquipment(){
        //Arrange
        String gladiatorName = "Jose";
        Integer gladiatorPosition = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), ZERO_ENERGY, gladiatorPosition, new Key(), dice);
        
        Integer expectedEnergy = (ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY);

        //Act
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

    //Caso de uso 12
    @Test
    public void afterThirtyTurnsTheGameEnds(){//todo:
        
        //Arrange

            //Gladiators
        String gladiator1Name = "Mockito";
        String gladiator2Name = "HomeMadeMock";
        Integer gladiator1Position = 0;
        Integer gladiator2Position = 0;
        Integer squaresToMove = 0;
        DiceMock dice = new DiceMock(squaresToMove);
        Gladiator gladiator1 = new Gladiator(gladiator1Name, new Novice(), INITIAL_ENERGY, gladiator1Position, new Helpless(), dice);
        Gladiator gladiator2 = new Gladiator(gladiator2Name, new Novice(), INITIAL_ENERGY, gladiator2Position, new Helpless(), dice);
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

            //Game
        String json = "src/main/resources/JSonFiles/boardMock.json";
        IGameState gameState = new OngoingGame();
        TurnManager game = new TurnManager(gladiators, new Board(json), gameState);

        //Act
        for (int i = 0; i <= MAX_ROUNDS*2; i++) {
            assertFalse(gameState.gameHasEnded());
            gameState = game.playTurn();
        }
        
        //Assert
        assertTrue(gameState.gameHasEnded());
    }

    
}

