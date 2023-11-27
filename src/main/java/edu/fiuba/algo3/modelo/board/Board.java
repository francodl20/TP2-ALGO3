package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.EquipmentSquare;
import edu.fiuba.algo3.modelo.IPlayer;

//Ext libraries
import java.util.*;

import org.apache.commons.lang3.tuple.Pair;
import java.io.IOException;

//For JSON
import java.io.FileReader;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
//

public class Board {
    HashMap<ISquare, Pair<Integer, Integer>> map;
    
    public Board(String jsonFilePath){
        map = new HashMap<>();
        try {
            this.buildFromJson(jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Board() {}
/* todo borrar esto
Unhandled exception type IOExceptionJava(16777384)
Unhandled exception type ParseExceptionJava(16777384)
*/
    public void buildFromJson(String jsonFilePath) throws Exception {

        Object jsonObj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONObject jsonFile = (JSONObject) jsonObj; 
        JSONArray squares = (JSONArray) jsonFile.get("Squares"); 
          
        Iterator<Map.Entry> squareAtributeIterator;
        Iterator squareIterator = squares.iterator();
        Integer squareNumber = 0;

        while (squareIterator.hasNext()) { 
            squareAtributeIterator = ((Map) squareIterator.next()).entrySet().iterator(); 
            Object type = null;
            Object obstacle = null;
            Object prize = null;
            Object x = null;
            Object y = null;
            squareNumber++;
            while (squareAtributeIterator.hasNext()) { 
                Map.Entry pair = squareAtributeIterator.next();
                if (pair.getKey().equals("tipo")) {
                    type = pair.getValue();
                }
                else if (pair.getKey().equals("obstaculo")){
                    obstacle = pair.getValue();
                } else if (pair.getKey().equals("premio")){
                    prize = pair.getValue();
                } else if (pair.getKey().equals("x")){
                    x = pair.getValue();
                } else if (pair.getKey().equals("y")){
                    y = pair.getValue();
                }
            }
            //todo: if type or position are null, throw an exception InvalidJSONException
            //todo: que haya una salida, una llegada
            //todo: que haya continuidad entre los valores de x e y.
            map.put(SquareFactory.createSquare(new Position(squareNumber), type, obstacle, prize), 
                    Pair.of((Integer)x,(Integer)y));
        } 
    }

    public void playAtCurrentPositionWith(IPlayer currentPlayer) {
        for (ISquare square : map.keySet()) {
            if(currentPlayer.in(square)){
                //gamestate.squarecoord(x,y);
                square.play(currentPlayer);
            }
        }
    }


    public boolean pompeyaWasReached(IPlayer currentPlayer) {
        Position currentPosition = currentPlayer.getCurrentPosition();
        return (Objects.equals(currentPosition, new Position(25)));
    }

    public ISquare getToPompeii() {
        return new PompeyaSquare(new Position(25)); // todo determinar bien cuál es el square de llegada
    }
}