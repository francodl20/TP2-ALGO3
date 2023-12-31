package edu.fiuba.algo3.testUnitarios.board.obstacles;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.obstacles.Bacchanalia;

public class BacchanaliaTest {
    private final Integer ENERGY_DRAIN = 4;
    
    @Test
    public void gladiatorLosesEnergy(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 4;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Bacchanalia party = new Bacchanalia();
        
        //Act
        party.harm(gladiator);

        Boolean reducesEnergy = gladiator.getEnergy() < 4;
        Boolean multiplyerIsCorrect = (gladiator.getEnergy() % ENERGY_DRAIN) == 0;
        Boolean result = reducesEnergy && multiplyerIsCorrect;
        
        //Assert
        assertTrue(result);
    }
}
