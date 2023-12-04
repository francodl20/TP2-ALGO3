package edu.fiuba.algo3.testUnitarios.equipment;

import edu.fiuba.algo3.modelo.equipment.IEquipment;
import edu.fiuba.algo3.modelo.equipment.Armour;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArmourTest {

    public static final int ENERGY_LOST_WITH_SWORD_AND_SHIELD = -2;
    public static final int ENERGY_LOST_WITH_ARMOUR = -10;

    @Test
    public void Case01ByEnhancingArmourYouObtainASwordAndAShield() {
        //Arrange
        Armour armour = new Armour();
        Integer expectedEnergy = (ENERGY_LOST_WITH_SWORD_AND_SHIELD);
        //Act
        IEquipment aux = armour.enhance();
        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyWearingAArmourIsCorrect() {
    
        //Arrange
        Armour armour = new Armour();
        Integer expectedEnergy = (ENERGY_LOST_WITH_ARMOUR);

        //Assert
        assertEquals(armour.protectFromtWildBeast(), expectedEnergy);
    }
}