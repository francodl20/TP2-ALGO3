package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Message;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.GladiatorMania;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class MessageTest {
    @Test
    public void CasoDeUso1() { // <----- el nombre no deberias dejarlo en ingles???
        //Arrange
        Board boardMock = new BoardMock(test);
        Gladiator gladiator1 = new Gladiator;
        Gladiator gladiator2 = new Gladiator;
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        GladiatorMania game = new GladiatorMania(board, gladiators);    

        //Act
        game.play();
        

        //Assert

        Energy initialEnergy = new Energy(20); //to do hacer método compare para dos objetos Energy
        assertEquals(gladiator1.getEnergy(), initialEnergy); //gladiator1.getEnergy() o game.getGladiator(1).getEnergy()
        

    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
}
