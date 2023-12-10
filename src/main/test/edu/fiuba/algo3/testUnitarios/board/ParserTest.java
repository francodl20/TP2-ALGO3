package edu.fiuba.algo3.testUnitarios.board;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Dependencies
import edu.fiuba.algo3.modelo.exceptions.InvalidJSONFormatException;

//Tested
import edu.fiuba.algo3.modelo.board.Parser;


public class ParserTest {
    
    @Test
    public void succesfulParse(){
        String jsonPath = "src/main/resources/JSonFiles/boardMock.json";
        assertDoesNotThrow(() -> Parser.buildFromJson(jsonPath));
    }


    @Test
    public void failedParse(){
        String jsonPath = "src/main/resources/JSonFiles/boardExceptionTest.json";
        assertThrows(InvalidJSONFormatException.class, () -> Parser.buildFromJson(jsonPath));
    }
}
