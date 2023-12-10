package edu.fiuba.algo3.testUnitarios.playerState;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.attributes.playerState.Healthy;

public class HealthyTest {
    
    @Test
    public void updateToInjured(){
        
        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        Healthy state = new Healthy(gladiator);

        //Act
        IPlayerState newState = state.update();
        Boolean result = newState.turnPlayed();

        //Assert
        assertFalse(result);
    }
}
