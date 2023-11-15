package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    @Test
    public void diceReturnANumberBetween1And6() {
        int diceRoll = Dice.rollDice();

        assertTrue(diceRoll >= 1 && diceRoll <= 6);
    }

    @Test
    public void multipleDiceRollsReturnNumbersBetween1And6() {
        for (int i = 0; i < 100; i++) {
            int diceRoll = Dice.rollDice();
            assertTrue(diceRoll >= 1 && diceRoll <= 6);
        }
    }
}