package edu.fiuba.algo3.testUnitarios.equipment;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.equipment.IEquipment;

//Tested
import edu.fiuba.algo3.modelo.equipment.Helpless;

public class HelplessTest {

    public static final int EXPECTED_LOSS_WITHOUT_EQUIPMENT = -20;
    public static final int EXPECTED_LOSS_WITH_HELMET = -15;

    @Test
    public void noEquipmentNoProtection() {

        //Arrange
        Helpless noEquipment = new Helpless();

        //Act
        Integer energyLost = noEquipment.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITHOUT_EQUIPMENT);
    }

    @Test
    public void noEquipmentEnhancesIntoHelmet() {

        //Arrange
        Helpless noEquipment = new Helpless();

        //Act
        IEquipment helmet = noEquipment.enhance();
        Integer energyLost = helmet.protectFromtWildBeast();

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_HELMET);
    }
}