package edu.fiuba.algo3.testUnitarios.equipment;

import edu.fiuba.algo3.modelo.D6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    @Test
    public void diceReturnANumberBetween1And6() {
        D6 dice = new D6();
        int result = dice.roll();
        
        assertTrue((result >= 1) && (result <= 6));
    }
    
    @Test
    public void multipleDiceRollsReturnNumbersBetween1And6() {
        D6 dice = new D6();
        for (int i = 0; i < 100; i++) {
            int diceRoll = dice.roll();
            assertTrue(diceRoll >= 1 && diceRoll <= 6);
        }
    }
}