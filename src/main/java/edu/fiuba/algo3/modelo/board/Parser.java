package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.factory.SquareFactory;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.exceptions.InvalidJSONFormatException;

//Ext libraries
import java.util.*;

//For JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Parser {
    private static final String PATH = "path";
    private static final String MAP = "map";
    private static final String SQUARES = "squares";
    private static final String TYPE = "type";
    private static final String OBSTACLE = "obstacle";
    private static final String PRIZE = "prize";
    private static final String X = "x";
    private static final String Y = "y";

    public static LinkedList<ISquare> buildFromJson(String jsonFilePath) throws Exception {
        LinkedList<ISquare> map = new LinkedList<>();

        //JSON variables
        Object jsonObj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONObject jsonFile = (JSONObject) jsonObj;

        JSONObject pathObject = (JSONObject) jsonFile.get(PATH);
        if (pathObject == null) {
            throw new InvalidJSONFormatException(jsonFilePath + ": 'path' wasn't found");
        }

        JSONArray squares = (JSONArray) pathObject.get(SQUARES);
        if (squares == null) {
            throw new InvalidJSONFormatException(jsonFilePath + ": 'squares' wasn't found");
        }
        //
        
        //JSON navigation

        Iterator<Map.Entry> squareAtributeIterator;
        Iterator squareIterator = squares.iterator();
        Integer squareNumber = 0;
        //

        Object type = null;
        Object obstacle = null;
        Object prize = null;
        Object x = null;
        Object y = null;
        
        while (squareIterator.hasNext()) { 
            squareAtributeIterator = ((Map) squareIterator.next()).entrySet().iterator(); 
            type = null;
            obstacle = null;
            prize = null;
            x = null;
            y = null;
            squareNumber++;
            while (squareAtributeIterator.hasNext()) { 
                Map.Entry pair = squareAtributeIterator.next();

                if (pair.getKey().equals(TYPE)) {
                    type = pair.getValue();
                }
                else if (pair.getKey().equals(OBSTACLE)){
                    obstacle = pair.getValue();
                } else if (pair.getKey().equals(PRIZE)){
                    prize = pair.getValue();
                } else if (pair.getKey().equals(X)){
                    x = pair.getValue();
                } else if (pair.getKey().equals(Y)){
                    y = pair.getValue();
                }
            }
            
            //Format validation
            if (type == null || obstacle == null || prize == null ||
                x == null || y == null) {
                throw new InvalidJSONFormatException(jsonFilePath + ": Missing parameters in squares");
            }
            if (squareNumber == 1 && !type.equals("Start")) {
                throw new InvalidJSONFormatException(jsonFilePath + ": Missing 'Start' square");
            }

            //complicated casting due to parsing object
            // -1 to match 
            Integer xValue = ((Long)x).intValue();
            Integer yValue = ((Long)y).intValue();
            ISquare nextSquare = SquareFactory.createSquare(new Coordinate(xValue, yValue), squareNumber, type, obstacle, prize);

            map.add(nextSquare);
        }

        //The map has to end ond a Finish square
        if (!type.equals("Finish")) {
            throw new InvalidJSONFormatException(jsonFilePath + ": Missing 'Finish' square");
        }

        return map;
    }

    public static Coordinate mapSize(String jsonFilePath) throws Exception {
        Object jsonObj = new JSONParser().parse(new FileReader(jsonFilePath));
        JSONObject jsonFile = (JSONObject) jsonObj;

        JSONObject mapObject = (JSONObject) jsonFile.get(MAP);
        if (mapObject == null) {
            throw new InvalidJSONFormatException(jsonFilePath + ": 'map' wasn't found");
        }

        Object width = mapObject.get("width");
        Object length = mapObject.get("length");

        Coordinate coord = new Coordinate(((Long) length).intValue(), ((Long) width).intValue());

        return coord;
    }
}
