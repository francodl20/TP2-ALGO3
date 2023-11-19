package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.attributes.Energy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyTest {

    public static final int ENERGY_LOST_WITH_KEY = 0;


    @Test
    public void Case01ByImprovingKeyYouObtainAKey() {
         //Arrange
        Key key = new Key();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_KEY);

        //Assert
        Equipment aux = key.enhance();

        //Act
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyUsingKeyIsCorrect() {
        
        //Arrange
        Key key = new Key();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_KEY);

        //Assert
        assertEquals(key.protectFromtWildBeast(), expectedEnergy);
    }
}