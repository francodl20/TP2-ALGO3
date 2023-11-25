package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.EquipmentSquare;
import edu.fiuba.algo3.modelo.Player;

//For JSON

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class Board {
    LinkedList<Square> squareMap;

    public Board() {
        squareMap = new LinkedList();
        //rellenar lista
    }
//Unhandled exception type IOExceptionJava(16777384)
//Unhandled exception type ParseExceptionJava(16777384)
    public void buildFromJson() throws Exception {
        // parsing file "JSONExample.json" 
        Object jsonObj = new JSONParser().parse(new FileReader("boardExample.json")); 
          
        // typecasting obj to JSONObject 
        JSONObject jsonFile = (JSONObject) jsonObj; 
          
        // getting squares 
        JSONArray squares = (JSONArray) jsonFile.get("Squares"); 
          
        // iterating squares 
        Iterator<Map.Entry> squareAtributeIterator;
        Iterator squareIterator = squares.iterator();
        while (squareIterator.hasNext())  
        { 
            squareAtributeIterator = ((Map) squareIterator.next()).entrySet().iterator(); 
            Object type = null;
            Object position = null;
            while (squareAtributeIterator.hasNext()) { 
                Map.Entry pair = squareAtributeIterator.next();
                if (pair.getKey().equals("Type")) {
                    type = pair.getValue();
                }
                else if (pair.getKey().equals("position")){
                    position = pair.getValue();
                }
            }
            squareMap.add(SquareFactory.createSquare(type, position));
        } 
    }
/*
"phoneNumbers":[
            {
            "type":"home", "number":"212 555-1234"
            },
         {
            "type":"fax", "number":"212 555-1234"
         }
    ],
*/
    public void playAtCurrentPositionWith(Player currentPlayer) {
        for (Square square : squareMap) {
            
            if(currentPlayer.in(square)){
                square.play(currentPlayer);
            }
        }
    }

    public boolean pompeyaWasReached(Player currentPlayer) {
        Position currentPosition = currentPlayer.getCurrentPosition();
        return (currentPosition == new Position(25));
    }

    /*
    private Position getPompeya() {
        //:)
    }
    */

}

/*

// Definir la estructura de datos (sd)
class MiEstructuraDeDatos {
    String nombre;
    int edad;
    String ciudad;

    public MiEstructuraDeDatos(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Leer el contenido del archivo JSON como una cadena
            String contenidoJSON = new String(Files.readAllBytes(Paths.get("datos.json")));

            // Crear un objeto JSON a partir de la cadena
            JSONObject json = new JSONObject(contenidoJSON);

            // Obtener la información del JSON
            String nombre = json.getString("nombre");
            int edad = json.getInt("edad");
            String ciudad = json.getString("ciudad");

            // Crear una instancia de la estructura de datos con la información del JSON
            MiEstructuraDeDatos miSD = new MiEstructuraDeDatos(nombre, edad, ciudad);

            // Acceder a la información
            System.out.println("Nombre: " + miSD.nombre);
            System.out.println("Edad: " + miSD.edad);
            System.out.println("Ciudad: " + miSD.ciudad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 */