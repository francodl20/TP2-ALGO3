package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.squares.SquareFactory;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.IPlayer;

//Ext libraries
import java.util.*;
import org.apache.commons.lang3.tuple.Pair;

//For JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class Board {
    HashMap<ISquare, Pair<Integer, Integer>> map;
    Position pompeiiPosition;
    
    public Board(String jsonFilePath){
        map = new HashMap<>();
        
        try {
            this.buildFromJson(jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void buildFromJson(String jsonFilePath) throws Exception {
   
   /*
    JSONObject caminoObject = (JSONObject) jsonFile.get("camino");
    JSONArray squares = (JSONArray) caminoObject.get("celdas");
   */
    Object jsonObj = new JSONParser().parse(new FileReader(jsonFilePath));
    JSONObject jsonFile = (JSONObject) jsonObj;  
    //JSONArray squares = (JSONArray) jsonFile.get("camino").getJSONArray("celdas"); 
    JSONObject caminoObject = (JSONObject) jsonFile.get("camino");
    JSONArray squares = (JSONArray) caminoObject.get("celdas");
    
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
        ISquare cuadradito = SquareFactory.createSquare(new Position(squareNumber), type, obstacle, prize);
        Pair<Integer, Integer> parcito = null;
        Integer int_x = 0;
        Integer int_y = 0;
        int_x = ((Long)x).intValue();
        int_y = ((Long)y).intValue(); 
        parcito = Pair.of(int_x, int_y);
        map.put(cuadradito, parcito);
    } 
    pompeiiPosition = new Position(squareNumber);
}

    public void playAtCurrentPositionWith(IPlayer currentPlayer) {
        for (ISquare square : map.keySet()) {
            if(currentPlayer.in(square)){
                //gamestate.squarecoord(x,y);
                square.play(currentPlayer);
            }
        }
    }

    public ISquare getPompeii() {
        //Will never return null
        ISquare pompeii = null;
        for (ISquare square : map.keySet()) {
            if (square.with(pompeiiPosition)){
                pompeii = square;
            }
        }
        return pompeii;
    }
}