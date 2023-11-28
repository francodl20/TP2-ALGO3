package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.board.Board;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipment.Helpless;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.gameState.*;
import edu.fiuba.algo3.modelo.attributes.seniority.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestCasosDeUsoS2 {
  private final Integer INITIAL_ENERGY = 20;

    //Caso de uso 13
    @Test   
    public void CanNotReadAJsonWithWrongFormat()throws Exception{
    
    String path2="src/main/java/edu/fiuba/algo3/modelo/board/uselessJson.json";
    //Board board = new Board();
    assertThrows(Exception.class, () -> new Board(path2));
}
    //Caso de uso 14  ------ solo hay un Json :/ 
   
    //Caso de uso 15  ------- No hay Json de enemigos. No sabe, no responde
    @Test   
    //Caso de uso 16
    public void AdheresToDomainModel(){
        Gladiator gladiator1 = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        Gladiator gladiator2 = new Gladiator(new Novice(), INITIAL_ENERGY, new Position(), new Helpless());
        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        gladiators.add(gladiator1);
        gladiators.add(gladiator2);  
        ArrayList<String> nameOfPlayers = new ArrayList<>();
        nameOfPlayers.add("Moquito");
        nameOfPlayers.add("HomeMadeMoco");
          
          
        String json = "src/main/java/edu/fiuba/algo3/modelo/board/boardMock.json";

        TurnManager game = new TurnManager(gladiators, nameOfPlayers, new Board(json), new OngoingGame());
        IDice dice = new DiceMock(1);
    
        //Act
        game.playTurn(dice);

        //Assert




    }

}