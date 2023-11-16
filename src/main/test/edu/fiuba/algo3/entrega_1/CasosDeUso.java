package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;


public class CasosDeUso {
    
    public static final Integer ENERGY_RECOVERED_AFTER_MEAL = 10;
    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;
    public static final int ENERGY_LOST_WITH_HELMET = -15;
    public static final int ENERGY_LOST_WITH_KEY = 0;


    @Test   //Convertir en caso de uso real cuando hayaa tablero
    public void CasoDeUso1() {
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

    @Test   //Convertir en caso de uso real cuando haya tablero
    public void CasoDeUso02() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
      //  Position initialPosition = new Position();
        Position finalPosition = new Position();
        int squaresToMove = 5;
        
        finalPosition.update(squaresToMove);

        //Act
        gladiator.playTurn(squaresToMove);

        //Assert
        assertEquals(finalPosition, gladiator.getCurrentPosition()); 

 
    }

    //Caso de uso 3
    @Test
    public void gladiatorWithoutEnergyCantPlayTurn() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(0), new Helpless());
        int squaresToMove = 1;

        //Act
        boolean playedTurn = gladiator.playTurn(squaresToMove);

         //Assert
        assertFalse(playedTurn); 
    }

    //Caso de uso 4
    @Test
    public void afterEatingAGladiatorRecievesTenPiecesOfEnergy() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_RECOVERED_AFTER_MEAL);

        //Act
        gladiator.eat();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

     //Caso de uso 5
    @Test
    public void AfterImprovingEquipmentForTheFirstTimeGladiatorGetsAHelmet() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_HELMET);

        //Act
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

       //Caso de uso 6
    @Test
    public void AfterImprovingEquipmentForTheThirdTimeGladiatorGetsSwordAndShield() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helpless());
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_SWORD_AND_SHIELD);

        //Act
        gladiator.enhanceArmour();
        gladiator.enhanceArmour();
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

      //Caso de uso 7
      @Test
    public void AfterFightingWithAWildBeastWearingAHelmetTheLostEnergyIsCorrect() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Helmet());
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_HELMET);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

    //Caso de uso 8
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
        //Assert
        assertEquals(finalEnergy, expectedEnergy);
    }

    //Caso de uso 9
    @Test
    public void CreoQueDependeDelMapa() { //No sabe no contesta
        
        //Arrange
       
        //Act
         
        //Assert
        
    }

    //Caso de uso 10
    @Test
    public void GladiatorDoesNotReceiveDamageFromTheBeastWhileWearingAllTheEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Key());
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_KEY);

        //Act
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }


    //Caso de uso 11
    @Test
    public void WhenGladiatorHasTheKeyAndRecievesAPrizeHisProtectionFeaturesStayTheSame(){
        //Arrange
        Gladiator gladiator = new Gladiator(new Novice(), new Energy(0), new Position(), new Key());
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_KEY);

        //Act
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();

         //Assert
        assertEquals(gladiator.getEnergy(),expectedEnergy); 
    }

    //Caso de uso 12
    @Test
    public void WhenThirtyTurnsPassAndNoGladiatorCrossesTheFinishLineTheGameEnds(){//No sabe no contesta pt2
        
        //Arrange
       
        //Act
         
        //Assert
    }

    
}

