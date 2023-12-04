package edu.fiuba.algo3.testUnitarios.equipment;

import edu.fiuba.algo3.modelo.equipment.IEquipment;
import edu.fiuba.algo3.modelo.equipment.Key;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;


    @Test
    public void Case01ByImprovingKeyYouObtainAKey() {
         //Arrange
        Key key = new Key();
        Integer expectedEnergy = (ENERGY_LOST_WITH_KEY);

        //Assert
        IEquipment aux = key.enhance();

        //Act
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyUsingKeyIsCorrect() {
        
        //Arrange
        Key key = new Key();
        Integer expectedEnergy = (ENERGY_LOST_WITH_KEY);

        //Assert
        assertEquals(key.protectFromtWildBeast(), expectedEnergy);
    }
}