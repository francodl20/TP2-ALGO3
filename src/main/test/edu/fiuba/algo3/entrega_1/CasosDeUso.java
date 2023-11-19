package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CurrentPlayer;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.*;
import edu.fiuba.algo3.modelo.board.BoardMock;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class CasosDeUso {
    
    public static final Integer ENERGY_RECOVERED_AFTER_MEAL = 10;
    public static final Integer ENERGY_AFTER_FIGHTING_WITH_SWORD_AND_SHIELD_FROM_ZERO_ENERGY = -2;
    public static final Integer ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY = -15;
    public static final Integer ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY = 0;

    //Caso de uso 01
    @Test   
    //todo: preguntar si hay que usar tablero o no hace falta
    public void gladiatorBeginsWithInitialEnergyAndEquipment() {
        //Arrange

        // Board boardMock = new BoardMock(test);
        Gladiator gladiator1 = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
        Gladiator gladiator2 = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        // GladiatorMania game = new GladiatorMania(boardMock, gladiators);    
        Energy initialEnergy = new Energy(20);
        Energy zeroEnergy = new Energy(0);

        //Act
        //game.play();
        
        //Assert
        //Check de initial energy
        assertEquals(gladiator1.getEnergy(), initialEnergy); 
        //todo: gladiator1.getEnergy() o game.getGladiator(1).getEnergy()?
        assertEquals(gladiator2.getEnergy(), initialEnergy);

        //Energy after fighting the beast corresponds with the equipment
        gladiator1.fightAgainstWildBeast();
        assertEquals(gladiator1.getEnergy(), zeroEnergy); 

    }

    //Caso de Uso 02
    @Test   
    //todo: preguntar si hay que usar tablero o no hace falta
    public void gladiatorIsAbleToMove() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
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
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(0), new Helpless());
        Integer squaresToMove = 1;

        //Act
        boolean playedTurn = gladiator.playTurn(squaresToMove);

         //Assert
        assertFalse(playedTurn); 
    }

    //Caso de uso 04
    @Test
    public void eatingIncreasesEnergyInTenUnits() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_RECOVERED_AFTER_MEAL);

        //Act
        gladiator.eat();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

     //Caso de uso 05
    @Test
    public void improvingEquipmentForTheFirstTimeGivesAHelmet() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY);
        
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
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_AFTER_FIGHTING_WITH_SWORD_AND_SHIELD_FROM_ZERO_ENERGY);

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
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helmet());
        Energy expectedEnergy = new Energy(ENERGY_AFTER_FIGHTING_WITH_HELMET_FROM_ZERO_ENERGY);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

    //Caso de uso 08
    @Test
    public void afterEightTurnsNoviceBecomesSeniorAndHisEnergyIncreasesInTheNextMove(){
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(10), new Position(), new Helpless());
        Energy finalEnergy = new Energy(0);
        Energy extraEnergyFromSenior = new Energy(5);
        
        //Act
        gladiator.playTurn(1);          
        gladiator.playTurn(1);
        gladiator.playTurn(1);
        gladiator.playTurn(1);
        gladiator.playTurn(1);
        gladiator.playTurn(1);
        gladiator.playTurn(1);
        gladiator.playTurn(1);

        Energy expectedEnergy = new Energy(gladiator.getEnergy().getEnergy()); 
        expectedEnergy.add(extraEnergyFromSenior);
        gladiator.playTurn(1);
        finalEnergy = gladiator.getEnergy();   //si la energia se agrega cuando empieza el otro turno
                                              //hay que corregir lo q se pierde de energia en el ultimo turno
                                              //todo: no se pierde energía en ningún momento. Chequear esta pregunta.
        //Assert
        assertEquals(finalEnergy, expectedEnergy);
    }

    //Caso de uso 09
    @Test
    public void arrivingToTheGoalWithoutTheKeyMovesBackToTheMiddleOfTheBoard() { //todo:
        //Arrange
        Gladiator gladiator1 = new Gladiator(new SemiSenior(), new Energy(20), new Position(27), new SwordAndShield());
        Gladiator gladiator2 = new Gladiator(new Senior(), new Energy(20), new Position(28), new Key());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        CurrentPlayer game = new CurrentPlayer(gladiators, new BoardMock());    
        //Act
        game.play();
        //Assert
        assertEquals(game.getCurrentPlayer().getCurrentPosition(),new Position(27/2));
        //Act
        game.play();
        //Assert
        assertEquals(game.getCurrentPlayer().getCurrentPosition(),new Position(28));
    }

    //Caso de uso 10
    @Test
    public void gladiatorDoesNotReceiveDamageFromTheBeastWhenWearingTheKey() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Key());
        Energy expectedEnergy = new Energy(ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }


    //Caso de uso 11
    @Test
    public void receivingAPrizeWithTheKeyDoesNotChangeTheEquipment(){
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Key());
        Energy expectedEnergy = new Energy(ENERGY_AFTER_FIGHTING_WITH_KEY_FROM_ZERO_ENERGY);

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
       
        //Act
         
        //Assert
    }

    
}

