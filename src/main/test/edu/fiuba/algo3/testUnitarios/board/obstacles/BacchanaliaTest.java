package edu.fiuba.algo3.testUnitarios.board.obstacles;

//Test
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BacchanaliaTest {
    
    @Test
    public void gladiatorLosesEnergy(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 4;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        
        //Act
        gladiator.enjoyBacchanalia(energy);

        Boolean reducesEnergy = gladiator.getEnergy() < 4;
        Boolean multiplyerIsCorrect = (gladiator.getEnergy()%4) == 0;
        Boolean result = reducesEnergy && multiplyerIsCorrect;
        
        //Assert
        assertTrue(result);
    }
}
