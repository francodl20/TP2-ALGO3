package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwordAndShieldTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;
    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;

    @Test
    public void Case01ByImprovingSwordAndShieldYouObtainAKey() {
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();

        //Act
        Equipment aux = swordAndShield.enhance();

        //Assert
        assertTrue(aux.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_KEY);
    }

    @Test
    public void Case02TheLostEnergyUsingSwordAndShieldIsCorrect() {
        
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();

        //Assert
        assertTrue(swordAndShield.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_SWORD_AND_SHIELD);
    }
}