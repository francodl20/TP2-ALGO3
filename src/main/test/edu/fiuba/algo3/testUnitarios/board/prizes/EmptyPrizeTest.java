package edu.fiuba.algo3.testUnitarios.board.prizes;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;

public class EmptyPrizeTest {
    
    @Test
    public void gladiatorRemainsUntouched(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        EmptyPrize nothing = new EmptyPrize();
        
        //Act
        nothing.boost(gladiator);
        
        //Assert
        assertEquals(energy, gladiator.getEnergy());
    }
}
