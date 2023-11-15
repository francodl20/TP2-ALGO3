package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Key;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;
    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;

    @Test
    public void Case01ByImprovingSwordAndShieldYouObtainAKey() {
         //Arrange
        Key key = new Key();

        //Assert
        Equipment aux = key.enhance();

        //Act
        assertTrue(aux.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_KEY);
    }

    @Test
    public void Case02TheLostEnergyUsingSwordAndShieldIsCorrect() {
        
        //Arrange
        Key key = new Key();

        //Assert
        assertTrue(key.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_KEY);
    }
}