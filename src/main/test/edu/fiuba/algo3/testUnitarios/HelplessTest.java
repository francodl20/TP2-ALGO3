package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Helpless;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelplessTest {
    public static final int ENERGY_LOST_BEING_HELPLESS = -20;
    public static final int ENERGY_LOST_WITH_HELMET = -15;

    @Test
    public void Case01ByImprovingAHelplessGladiatorYouObtainAHelmet() {
        //Arrange
        Helpless helpless = new Helpless();
        Integer expectedEnergy = (ENERGY_LOST_WITH_HELMET);

        //Act
        Equipment aux = helpless.enhance();

        //Assert
        assertEquals(aux.protectFromtWildBeast(), expectedEnergy);
    }

    @Test
    public void Case02TheLostEnergyBeingHelplessIsCorrect() {
        
        //Arrange
        Helpless helpless = new Helpless();
        Integer expectedEnergy = (ENERGY_LOST_BEING_HELPLESS);
        //Assert
        assertEquals(helpless.protectFromtWildBeast(),expectedEnergy);
    }

}