package edu.fiuba.algo3.testUnitarios.board;

//Test
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.board.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Dependencies

//Tested

public class BoardTest {
    
    @Test
    public void test(){
        String path = "src/main/resources/JSonFiles/boardTest.json";
        try {
            Board board = new Board(path);
        } catch (Exception e) {}

        
    }
}
