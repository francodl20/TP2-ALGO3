package edu.fiuba.algo3.testUnitarios.equipment;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.equipment.IEquipment;

//Tested
import edu.fiuba.algo3.modelo.equipment.Armour;


public class ArmourTest {

    public static final int EXPECTED_LOSS_WITH_ARMOUR = -10;
    public static final int EXPECTED_LOSS_WITH_SWORD_AND_SHIELD = -2;

    @Test
    public void armourProtectsProperly() {
    
        //Arrange
        Armour armour = new Armour();

        //Act
        Integer energyLost = armour.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_ARMOUR);
    }

    @Test
    public void armourEnhancesIntoSwordAndShield() {

        //Arrange
        Armour armour = new Armour();

        //Act
        IEquipment swordAndShield = armour.enhance();
        Integer energyLost = swordAndShield.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_SWORD_AND_SHIELD);
    }
}