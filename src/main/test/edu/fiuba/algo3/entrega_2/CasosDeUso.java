package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.board.Board;
import org.junit.jupiter.api.Test;

public class CasosDeUso {
    @Test
    public void mapJsonFormatIsCorrect() {
        String jsonFilePath = "ruta mapa.json";
        Board board = new Board(jsonFilePath);

        String generatedJson =

        try {
            JSONAssert.assertEquals(jsonFilePath, generatedJson, false);
        } catch (Exception e) {
            e.printStackTrace();
            fail("El formato del JSON no es válido.");
        }
    }
}
