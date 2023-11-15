package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Armour;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmourTest {

    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;
    public static final int ENERGY_LOST_WITH_ARMOUR = -10;

    @Test
    public void Case01ByImprovingAnArmourYouObtainASwordAndAShield() {
        //Arrange
        Armour armour = new Armour();
        //Act
        Equipment aux = armour.enhance();
        //Assert
        assertTrue(aux.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_SWORD_AND_SHIELD);
    }

    @Test
    public void Case02TheLostEnergyWearingAArmourIsCorrect() {
    
        //Arrange
        Armour armour = new Armour();

        //Assert
        assertTrue(armour.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_ARMOUR);
    }
}