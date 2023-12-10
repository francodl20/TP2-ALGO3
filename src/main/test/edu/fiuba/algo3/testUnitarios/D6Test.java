package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Tested
import edu.fiuba.algo3.modelo.D6;

public class D6Test {

    @Test
    public void diceReturnANumberBetween1And6() {
        D6 dice = new D6();
        int number = dice.roll();

        Boolean result = (number >= 1) && (number <= 6);
        
        assertTrue(result);
    }
    
    @Test
    public void multipleDiceRollsReturnNumbersBetween1And6() {
        D6 dice = new D6();
        for (int i = 0; i < 100; i++) {
            int number = dice.roll();
            assertTrue(number >= 1 && number <= 6);
        }
    }
}