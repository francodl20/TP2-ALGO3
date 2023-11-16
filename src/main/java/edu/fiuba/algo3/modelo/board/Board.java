package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.attributes.Position;

public class Board {
    HashMap<Position,Square> casilleros;

    public Board() {
        casilleros = new HashMap<>();
    }
}