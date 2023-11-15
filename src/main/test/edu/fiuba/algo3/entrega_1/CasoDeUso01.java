package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Message;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

// import edu.fiuba.algo3.modelo.GladiatorMania;

public class CasoDeUso01 {
    @Test
    public void CasoDeUso1() {
        //Arrange
        // Board boardMock = new BoardMock(test);
        Gladiator gladiator1 = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
        Gladiator gladiator2 = new Gladiator(new Novice(), new Energy(20), new Position(), new Helpless());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);
        // GladiatorMania game = new GladiatorMania(boardMock, gladiators);    
        Energy initialEnergy = new Energy(20);
        Energy zeroEnergy = new Energy(0);
        //Act
        //game.play();
        
        //Assert
        assertEquals(gladiator1.getEnergy(), initialEnergy); 
        //todo: gladiator1.getEnergy() o game.getGladiator(1).getEnergy()?
        assertEquals(gladiator2.getEnergy(), initialEnergy);
        gladiator1.fightAgainstWildBeast();
        assertEquals(gladiator1.getEnergy(), zeroEnergy); 

        // assertEquals(gladiator1.getEquipment(), initialEquipment);
        // assertEquals(gladiator2.getEquipment(), initialEquipment);
    }
}
