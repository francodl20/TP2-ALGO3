package edu.fiuba.algo3.testUnitarios.board;

//Test
import org.junit.jupiter.api.Test;

//Tested
import edu.fiuba.algo3.modelo.board.Parser;
import edu.fiuba.algo3.modelo.exceptions.InvalidJSONFormatException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    
    @Test
    public void provisionalTest(){
        String json = "src/main/resources/JSonFiles/boardExceptionTest.json";
        assertThrows(InvalidJSONFormatException.class, () -> Parser.buildFromJson(json));
    }
}
