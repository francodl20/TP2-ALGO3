package edu.fiuba.algo3.testUnitarios.equipment;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.equipment.IEquipment;

//Tested
import edu.fiuba.algo3.modelo.equipment.Helmet;

public class HelmetTest {

    public static final int EXPECTED_LOSS_WITH_HELMET = -15;
    public static final int EXPECTED_LOSS_WITH_ARMOUR = -10;

    @Test
    public void helmetProtectsProperly() {
    
        //Arrange
        Helmet helmet = new Helmet();

        //Act
        Integer energyLost = helmet.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_HELMET);
    }

    @Test
    public void helmetEnhancesIntoArmour() {

        //Arrange
        Helmet helmet = new Helmet();

        //Act
        IEquipment armour = helmet.enhance();
        Integer energyLost = armour.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_ARMOUR);
    }
}