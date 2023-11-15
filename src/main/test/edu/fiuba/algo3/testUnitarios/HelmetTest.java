package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Helmet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelmetTest {

    public static final int ENERGY_LOST_WITH_HELMET = -15;
    public static final int ENERGY_LOST_WITH_ARMOUR = -10;

    @Test
    public void Case01ByImprovingAHelmetYouObtainAnArmor() {

        
        //Arrange
        Helmet helmet = new Helmet();

        //Act
        Equipment aux = helmet.enhance();

        //Assert
        assertTrue(aux.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_ARMOUR);
    }

    @Test
    public void Case02TheLostEnergyWearingAHelmetIsCorrect() {
        
        //Arrange
        Helmet helmet = new Helmet();

        //Assert
        assertTrue(helmet.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_HELMET);
    }
}