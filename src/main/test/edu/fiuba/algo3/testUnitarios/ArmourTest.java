package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Armour;
import edu.fiuba.algo3.modelo.attributes.Energy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArmourTest {

    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;
    public static final int ENERGY_LOST_WITH_ARMOUR = -10;

    @Test
    public void Case01ByEnhancingArmourYouObtainASwordAndAShield() {
        //Arrange
        Armour armour = new Armour();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_SWORD_AND_SHIELD);
        //Act
        Equipment aux = armour.enhance();
        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyWearingAArmourIsCorrect() {
    
        //Arrange
        Armour armour = new Armour();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_ARMOUR);

        //Assert
        assertEquals(armour.protectFromtWildBeast(), expectedEnergy);
    }
}