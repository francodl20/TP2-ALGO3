package edu.fiuba.algo3.testUnitarios;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


//Dependencies
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import java.util.LinkedList;

//Tested
import edu.fiuba.algo3.modelo.TurnManager;

public class TurnManagerTest {
    
    @Test
    public void returnsCurrentLGladiator(){

        //Arrange
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        TurnManager manager = new TurnManager(gladiators);

        //Act
        Gladiator currentGladiator = manager.getCurrentGladiator();

        //Assert
        assertEquals(gladiator1Name, currentGladiator.getPlayerName());
    }

    @Test
    public void returnsTurnCount(){

        //Arrange
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        TurnManager manager = new TurnManager(gladiators);

        //Act/Assert
        for (int i = 0; i < 20; i++) {
            manager.getNextGladiator();
            manager.getNextGladiator();
            assertEquals(i + 1, manager.getTurnCount());
        }
    }

    @Test
    public void picksRandomPlayer(){

        //Arrange
        String gladiator1Name = "Bro";
        String gladiator2Name = "Brah";
        Integer position = 1;
        Integer energy = 20;

        Gladiator gladiator1 = new Gladiator(
            gladiator1Name, new Novice(), energy, position, new Helpless());
        Gladiator gladiator2 = new Gladiator(
            gladiator2Name, new Novice(), energy, position, new Helpless());

        LinkedList<Gladiator> gladiators = new LinkedList<>();
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);

        Integer diceRoll = 2;

        TurnManager manager = new TurnManager(gladiators);

        //Act
        manager.pickRandomPlayer(diceRoll);
        Gladiator currentGladiator = manager.getCurrentGladiator();

        //Assert
        assertEquals(gladiator2Name, currentGladiator.getPlayerName());
    }
}
