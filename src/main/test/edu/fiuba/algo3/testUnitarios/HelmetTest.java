package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.attributes.Energy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelmetTest {

    public static final int ENERGY_LOST_WITH_HELMET = -15;
    public static final int ENERGY_LOST_WITH_ARMOUR = -10;

    @Test
    public void Case01ByImprovingAHelmetYouObtainAnArmor() {

        
        //Arrange
        Helmet helmet = new Helmet();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_ARMOUR);

        //Act
        Equipment aux = helmet.enhance();

        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy); 
    }

    @Test
    public void Case02TheLostEnergyWearingAHelmetIsCorrect() {
        
        //Arrange
        Helmet helmet = new Helmet();
        Energy expectedEnergy = new Energy(ENERGY_LOST_WITH_HELMET);

        //Assert
        assertEquals(helmet.protectFromtWildBeast(), expectedEnergy);
    }
}