package edu.fiuba.algo3.testUnitarios.equipment;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.equipment.IEquipment;

//Tested
import edu.fiuba.algo3.modelo.equipment.SwordAndShield;

public class SwordAndShieldTest {
    
    public static final int EXPECTED_LOSS_WITH_SWORD_AND_SHIELD = -2;
    public static final int EXPECTED_LOSS_WITH_KEY = 0;

    @Test
    public void swordAndShieldProtectsProperly() {

        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();

        //Act
        Integer energyLost = swordAndShield.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_SWORD_AND_SHIELD);
    }

    @Test
    public void swordAndShieldEnhancesIntoKey() {

        //Arrange
        SwordAndShield swordAndShield = new SwordAndShield();

        //Act
        IEquipment key = swordAndShield.enhance();
        Integer energyLost = key.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_KEY);
    }
}