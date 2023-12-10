package edu.fiuba.algo3.testUnitarios.equipment;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.equipment.IEquipment;

//Tested
import edu.fiuba.algo3.modelo.equipment.Key;

public class KeyTest {

    public static final int EXPECTED_LOSS_WITH_KEY = 0;


    @Test
    public void keyProtectsProperly() {

        //Arrange
        Key key = new Key();

        //Act
        Integer energyLost = key.protectFromtWildBeast();   

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_KEY);
    }

    @Test
    public void keyEnhancesIntoKey() {
        
        //Arrange
        Key key = new Key();

        //Act
        IEquipment key2 = key.enhance();
        Integer energyLost = key2.protectFromtWildBeast();   

        //Assert
        assertEquals(energyLost, EXPECTED_LOSS_WITH_KEY);
    }
}