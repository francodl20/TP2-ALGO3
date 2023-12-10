package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Tested
import edu.fiuba.algo3.modelo.D10;

public class D10Test {
    @Test
    public void diceReturnANumberBetween1And10() {
        D10 dice = new D10();
        int number = dice.roll();

        Boolean result = (number >= 1) && (number <= 10);
        
        assertTrue(result);
    }
    
    @Test
    public void multipleDiceRollsReturnNumbersBetween1And10() {
        D10 dice = new D10();
        for (int i = 0; i < 100; i++) {
            int number = dice.roll();
            assertTrue(number >= 1 && number <= 10);
        }
    }
}
