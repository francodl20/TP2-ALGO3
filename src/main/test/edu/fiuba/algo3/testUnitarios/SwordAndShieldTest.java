package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.IEquipment;
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordAndShieldTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;
    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;

    @Test
    public void Case01ByImprovingSwordAndShieldYouObtainAKey() {
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();
        Integer expectedEnergy = (ENERGY_LOST_WITH_KEY);

        //Act
        IEquipment aux = swordAndShield.enhance();

        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyUsingSwordAndShieldIsCorrect() {
        
        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();
        Integer expectedEnergy = (ENERGY_LOST_WITH_SWORD_AND_SHIELD);

        //Assert
        assertEquals(swordAndShield.protectFromtWildBeast(), expectedEnergy);
    }
}