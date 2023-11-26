package edu.fiuba.algo3.modelo.board;

//Local clases
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.EquipmentSquare;
import edu.fiuba.algo3.modelo.Player;

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
    HashMap<Square, Pair<Integer, Integer>> map;
    
    public Board(String jsonFilePath){
        map = new HashMap<>();
        try {
            this.buildFromJson(jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Board() {}

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
            map.put(SquareFactory.createSquare(new Position(squareNumber), type, obstacle, prize), 
                    Pair.of((Integer)x,(Integer)y));
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
        for (Square square : map.keySet()) {
            if(currentPlayer.in(square)){
                square.play(currentPlayer);
            }
        }
    }

    //public Integer 

    public boolean pompeyaWasReached(Player currentPlayer) {
        Position currentPosition = currentPlayer.getCurrentPosition();
        return (Objects.equals(currentPosition, new Position(25)));
    }

    public Square getToPompeii() {
        return new PompeyaSquare(new Position(25)); // todo determinar bien cuál es el square de llegada
    }
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