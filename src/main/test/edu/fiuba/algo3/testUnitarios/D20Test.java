package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Tested
import edu.fiuba.algo3.modelo.D20;

public class D20Test {
    @Test
    public void diceReturnANumberBetween1And20() {
        D20 dice = new D20();
        int number = dice.roll();

        Boolean result = (number >= 1) && (number <= 20);
        
        assertTrue(result);
    }
    
    @Test
    public void multipleDiceRollsReturnNumbersBetween1And20() {
        D20 dice = new D20();
        for (int i = 0; i < 100; i++) {
            int number = dice.roll();
            assertTrue(number >= 1 && number <= 20);
        }
    }
}
