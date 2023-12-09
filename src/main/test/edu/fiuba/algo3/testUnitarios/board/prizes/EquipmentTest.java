package edu.fiuba.algo3.testUnitarios.board.prizes;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.prizes.Equipment;

public class EquipmentTest {
    
    @Test
    public void gladiatorChangesEquipment(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 15;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Equipment helmet = new Equipment();
        Integer expectedEnergy = 0;
        
        //Act
        helmet.boost(gladiator);
        gladiator.fightAgainstWildBeast();
        
        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }
}
