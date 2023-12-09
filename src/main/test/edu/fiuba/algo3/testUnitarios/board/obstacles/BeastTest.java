package edu.fiuba.algo3.testUnitarios.board.obstacles;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.obstacles.Beast;

public class BeastTest {
    
    @Test
    public void gladiatorLosesEnergy(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Beast dog = new Beast();
        Integer expectedEnergy = 0;
        
        //Act
        dog.harm(gladiator);
        
        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }
}

