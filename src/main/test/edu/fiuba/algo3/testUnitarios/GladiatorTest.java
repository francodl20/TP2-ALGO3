package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.board.squares.PathSquare;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Key;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Tested
import edu.fiuba.algo3.modelo.Gladiator;

public class GladiatorTest {
    
    @Test
    public void playsTurn(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        D6 dice = mock(D6.class);
        when(dice.roll()).thenReturn(1);

        //Act
        gladiator.playTurn(dice);

        //Assert
        assertTrue(gladiator.turnPlayed());
    }

    @Test
    public void gladiatorEating(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Integer expectedEnergy = 35;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        //Act
        gladiator.eat();
        Integer newEnergy = gladiator.getEnergy();

        //Assert
        assertEquals(expectedEnergy, newEnergy);
    }

    @Test
    public void gladiatorArmouring(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Integer expectedEnergy = 5;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        //Act
        gladiator.enhanceArmour();
        gladiator.fightAgainstWildBeast();
        Integer newEnergy = gladiator.getEnergy();

        //Assert
        assertEquals(expectedEnergy, newEnergy);
    }

    @Test
    public void gladiatorPartying(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Integer expectedEnergy = 10;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        //Act
        gladiator.enjoyBacchanalia(10);
        Integer newEnergy = gladiator.getEnergy();

        //Assert
        assertEquals(expectedEnergy, newEnergy);
    }

    @Test
    public void gladiatorInjured(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        D6 dice = mock(D6.class);
        when(dice.roll()).thenReturn(1);

        //Act
        gladiator.getInjured();
        gladiator.playTurn(dice);

        //Assert
        assertFalse(gladiator.turnPlayed());
    }

    @Test
    public void gladiatorBattled(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Integer expectedEnergy = 0;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        //Act
        gladiator.fightAgainstWildBeast();

        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }

    @Test
    public void gladiatorArrived(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 10;
        Integer energy = 20;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Key());

        //Act
        gladiator.arriveToPompeii();

        //Assert
        assertEquals(position, gladiator.getPosition());
    }

    @Test
    public void gladiatorAtSquare(){

        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        PathSquare square = new PathSquare(new Coordinate(1, 1), position, null, null);

        //Act
        Boolean result = gladiator.in(square);

        //Assert
        assertTrue(result);
    }
}
