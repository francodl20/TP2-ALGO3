package edu.fiuba.algo3.modelo.board;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SquareParcer {


    public LinkedList<Square> identifySquare(String filePath){
       LinkedList<Square> squares = new LinkedList();

         JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray squareArray = (JSONArray) jsonObject.get("Squares");

            for (Object squareObj : squareArray) {
                JSONObject squareJson = (JSONObject) squareObj;
                String type = (String) squareJson.get("Type");
                
                /*
                //aqui iria algo como el patron factory porque no se puede instancear square
                //no sé que estoy haciendo, ignorar. saludos 
                //Square square = new Square();
                //parser.add(square);
                */
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}