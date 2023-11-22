package edu.fiuba.algo3.modelo.board;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.Player;

//For JSON

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import edu.fiuba.algo3.org.json.simple.JSONArray; 
import edu.fiuba.algo3.org.json.simple.JSONObject; 
import edu.fiuba.algo3.org.json.simple.parser.*;

public class Board {
    LinkedList<Square> squareMap;

    public Board() {
        squareMap = new LinkedList();
        //rellenar lista
    }

    public void buildFromJson() {
          
        // iterating address Map 
        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        // getting phoneNumbers 
        JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 
          
        // iterating phoneNumbers 
        Iterator itr2 = ja.iterator(); 
          
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
    }

    public void playAtCurrentPositionWith(Player currentPlayer) {
        for (int i = 0; i < squareMap.size(); i++) {
            
            if(currentPlayer.in(square)):
                square.play()
        }
            
        //Square currentSquare = squareMap.get(currentPlayer.getCurrentPosition());
        currentSquare.play(currentPlayer);
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