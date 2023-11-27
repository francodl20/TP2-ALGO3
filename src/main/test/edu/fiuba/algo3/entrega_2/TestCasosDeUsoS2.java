package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.board.Board;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestCasosDeUsoS2 {

    //Caso de uso 13
    @Test   
    public void CanNotReadAJsonWithWrongFormat()throws Exception{
    
    String path2="src/main/java/edu/fiuba/algo3/modelo/board/uselessJson.json";
    Board board = new Board();
    
    assertThrows(Exception.class, () -> board.buildFromJson(path2));
}
    //Caso de uso 14  ------ solo hay un Json :/ 
   
    //Caso de uso 15  ------- No hay Json de enemigos. No sabe, no responde
    @Test   
    public void Camat(){

    }

}