package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;
import edu.fiuba.algo3.modelo.attributes.Energy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordAndShieldTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;
    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;

    @Test
    public void Case01ByImprovingSwordAndShieldYouObtainAKey() {
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_KEY);

        //Act
        Equipment aux = swordAndShield.enhance();

        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyUsingSwordAndShieldIsCorrect() {
        
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_SWORD_AND_SHIELD);

        //Assert
        assertEquals(swordAndShield.protectFromtWildBeast(), expectedEnergy);
    }
}