package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Helpless;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelplessTest {
    public static final int ENERGY_LOST_BEING_HELPLESS = -20;
    public static final int ENERGY_LOST_WITH_HELMET = -15;

    @Test
    public void Case01ByImprovingAHelplessGladiatorYouObtainAHelmet() {
        //Arrange
        Helpless helpless = new Helpless();

        //Act
        Equipment aux = helpless.enhance();

        //Assert
        assertTrue(aux.protectFromtWildBeast().getEnergy() == ENERGY_LOST_WITH_HELMET);
    }

    @Test
    public void Case02TheLostEnergyBeingHelplessIsCorrect() {
        
        //Arrange
        Helpless helpless = new Helpless();

        //Assert
        assertTrue(helpless.protectFromtWildBeast().getEnergy() == ENERGY_LOST_BEING_HELPLESS);
    }

}