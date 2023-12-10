package edu.fiuba.algo3.testUnitarios.playerState;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.playerState.IPlayerState;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;

//Tested
import edu.fiuba.algo3.modelo.attributes.playerState.Injured;

public class InjuredTest {
    
    @Test
    public void updateToInjured(){
        
        //Arrange
        String gladiatorName = "Bro";
        Integer position = 1;
        Integer energy = 20;
        Gladiator gladiator = new Gladiator(
            gladiatorName, new Novice(), energy, position, new Helpless());

        Injured state = new Injured(gladiator);

        //Act
        IPlayerState newState = state.update();
        newState = newState.playTurn(energy);
        Boolean result = newState.turnPlayed();

        //Assert
        assertTrue(result);
    }
}
