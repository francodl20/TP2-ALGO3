package edu.fiuba.algo3.testUnitarios.board.obstacles;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dependencies
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.board.obstacles.Injury;


public class InjuryTest {

    @Test
    public void gladiatorGetsInjured(){
        //Arrange
        String gladiatorName = "Bro";
        Integer gladiatorPosition = 0;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(gladiatorName, new Novice(), energy, gladiatorPosition, new Helpless());

        Injury rock = new Injury();
        Integer expectedPosition = 0;
        
        //Act
        rock.harm(gladiator);
        gladiator.playTurn(new D6());
        
        //Assert
        assertEquals(expectedPosition, gladiator.getPosition());
    }
}
