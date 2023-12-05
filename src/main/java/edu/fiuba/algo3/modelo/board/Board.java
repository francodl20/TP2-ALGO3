package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.exceptions.IncorrectJSONFormat;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.Gladiator;


//Ext libraries
import java.util.*;


public class Board {
   
    LinkedList<ISquare> map;
    Coordinate dimension;

    //TO DO: 
    public Board(String jsonFilePath) throws Exception {
        try {
            map = Parser.buildFromJson(jsonFilePath);
        } catch (Exception e) {
            throw new IncorrectJSONFormat("The JSON format is no supported");
        }
    }

    public void playAtCurrentPositionWith(Gladiator currentPlayer) {
        for (ISquare square : map) {
            if(currentPlayer.in(square)){
                square.play(currentPlayer);
            }
        }
    }

    
    public ISquare getPompeii() {
        return map.getLast();
    }
}