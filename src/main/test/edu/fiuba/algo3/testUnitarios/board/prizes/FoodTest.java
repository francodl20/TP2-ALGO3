package edu.fiuba.algo3.testUnitarios.board.prizes;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.prizes.Food;

public class FoodTest {
    
    @Test
    public void gladiatorGainsEnergy(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 0;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Food sushi = new Food();
        Integer expectedEnergy = 15;
        
        //Act
        sushi.boost(gladiator);
        
        //Assert
        assertEquals(expectedEnergy, gladiator.getEnergy());
    }
}
