package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.TurnManager;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.BoardMock;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class CasosDeUso {
    private final Integer ENERGY_RECOVERED_AFTER_MEAL = 10;
    private final Integer ZERO_ENERGY = 0;
    private final Integer INITIAL_ENERGY = 20;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_SWORD_AND_SHIELD_FROM_ZERO_ENERGY = -2;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY = -15;
    private final Integer ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY = 0;

    private final Integer SEMISENIOR_BONUS = 5;
    private final Integer SENIOR_BONUS = 10;
    private final Integer SEMISENIORITY_THRESHOLD = 8;

    private final Integer MAX_ROUNDS = 30;
    //Caso de uso 01
    @Test   
    //todo: preguntar si hay que usar tablero o no hace falta
    public void gladiatorBeginsWithInitialEnergyAndEquipment() {
        //Arrange

        // Board boardMock = new BoardMock(test);
        Gladiator gladiator1 = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        Gladiator gladiator2 = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        // GladiatorMania game = new GladiatorMania(boardMock, gladiators);    
    
        //Act
        //game.play();
        
        //Assert
        //Check de initial energy
        assertEquals(gladiator1.getEnergy(), INITIAL_ENERGY); 
        //todo: gladiator1.getEnergy() o game.getGladiator(1).getEnergy()?
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
        Gladiator gladiator = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        //  Position initialPosition = new Position();
        Integer squaresToMove = 5;
        Position finalPosition = new Position(2*squaresToMove);
        //Act
        gladiator.playTurn(squaresToMove);
        gladiator.playTurn(squaresToMove);

        //Assert
        assertEquals(finalPosition, gladiator.getCurrentPosition()); 
    }

    //Caso de uso 03
    @Test
    public void gladiatorWithoutEnergyCannotPlayTurn() {
        //Arrange
        Position expectedPosition = new Position(0);
        Gladiator gladiator = new Gladiator(new Novice(), (0), expectedPosition, new Helpless());
        Integer squaresToMove = 1;

        //Act
        //boolean playedTurn = 
        gladiator.playTurn(squaresToMove);

         //Assert
        // assertFalse(playedTurn); 
        assertEquals(expectedPosition, gladiator.getCurrentPosition());
    }

    //Caso de uso 04
    @Test
    public void eatingIncreasesEnergyInTenUnits() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), (0), new Position(), new Helpless());
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
        Gladiator gladiator = new Gladiator(new Novice(), (0), new Position(), new Helpless());
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
        Gladiator gladiator = new Gladiator(new Novice(), (0), new Position(), new Helpless());
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
        Gladiator gladiator = new Gladiator(new Novice(), (0), new Position(), new Helmet());
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
        Gladiator gladiator = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        Integer finalEnergy = ZERO_ENERGY;
        Integer expectedEnergy = (INITIAL_ENERGY + SEMISENIOR_BONUS);

        //Act
        for (Integer i = 0; i<=SEMISENIORITY_THRESHOLD; i++) {
            gladiator.playTurn(1);
        }
        //Assert
        assertEquals(gladiator.getEnergy(), expectedEnergy);
    }

    //Caso de uso 09
    @Test
    public void arrivingToTheGoalWithoutTheKeyMovesBackToTheMiddleOfTheBoard() { //todo:
        //Arrange
        Gladiator gladiator1 = new Gladiator(new SemiSenior(), INITIAL_ENERGY, new Position(24), new SwordAndShield());
        Gladiator gladiator2 = new Gladiator(new Senior(), INITIAL_ENERGY, new Position(24), new Key());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        TurnManager game = new TurnManager(gladiators, new BoardMock());
        Position targetPosition = new Position(24/2);
        Integer diceRoll = 1;
        //Act
        game.play(diceRoll);
        //Assert
        assertEquals(game.getCurrentPlayer().getCurrentPosition(), targetPosition);
        //Act
        game.play(diceRoll);
        //Assert
        assertEquals(game.getCurrentPlayer().getCurrentPosition(), new Position(25));
    }

    //Caso de uso 10
    @Test
    public void gladiatorDoesNotReceiveDamageFromTheBeastWhenWearingTheKey() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), (0), new Position(), new Key());
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
        Gladiator gladiator = new Gladiator(new Novice(), ZERO_ENERGY, new Position(), new Key());
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
        Gladiator gladiator1 = new Gladiator(new SemiSenior(), INITIAL_ENERGY, new Position(24), new SwordAndShield());
        Gladiator gladiator2 = new Gladiator(new Senior(), INITIAL_ENERGY, new Position(24), new Key());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        TurnManager game = new TurnManager(gladiators, new BoardMock());
        Integer diceRoll = 0;
        boolean theGameEnded = false;
        //Act
        for (int i = 0; i <= MAX_ROUNDS*2; i++) {
            theGameEnded = game.play(diceRoll);
        }
        
        //Assert
        assertTrue(theGameEnded);
    }

    
}

