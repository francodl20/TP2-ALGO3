package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.factory.SquareFactory;
import edu.fiuba.algo3.modelo.board.squares.ISquare;

//Ext libraries
import java.util.*;

//For JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Parser {
    

    public static LinkedList<ISquare> buildFromJson(String jsonFilePath) throws Exception {
        LinkedList<ISquare> map = new LinkedList<>();

        //JSON variables
        Object jsonObj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONObject jsonFile = (JSONObject) jsonObj;  

        JSONObject caminoObject = (JSONObject) jsonFile.get("path");
        JSONArray squares = (JSONArray) caminoObject.get("squares");
        //

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
                if (pair.getKey().equals("type")) {
                    type = pair.getValue();
                }
                else if (pair.getKey().equals("obstacle")){
                    obstacle = pair.getValue();
                } else if (pair.getKey().equals("prize")){
                    prize = pair.getValue();
                } else if (pair.getKey().equals("x")){
                    x = pair.getValue();
                } else if (pair.getKey().equals("y")){
                    y = pair.getValue();
                }
            }
            //todo: if type or position are null, throw an exception InvalidJSONException
            //todo: validate the existance of start and finish|
            //todo: validate continuity through the coordinates
            //

            //complicated casting due to parsing object
            Integer xValue = ((Long)x).intValue();
            Integer yValue = ((Long)y).intValue();
            ISquare nextSquare = SquareFactory.createSquare(new Coordinate(xValue, yValue), squareNumber, type, obstacle, prize);

            map.add(nextSquare);
        } 

        return map;
    }
}
