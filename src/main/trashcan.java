
/*
package edu.fiuba.algo3.modelo.attributes;

public class Energy {
    public static final Integer NO_ENERGY = 0;
    Integer energy;

    public Energy() {
        this.energy = 0;
    }

    public Energy(Integer initialEnergy) {
        this.energy = initialEnergy;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Energy add(Energy anotherEnergy) {
        return new Energy(this.energy + anotherEnergy.getEnergy());
    }
    
    public boolean thereIsEnoughEnergyToPlay() {
        return (this.energy > NO_ENERGY);
    } 

    public boolean isEmpty() {
        return (energy <= 0);
    }

    @Override
    public boolean equals(Object anEnergy) {
        if (anEnergy == this) {
            return true;
        }
        if (!(anEnergy instanceof Energy)) {
            return false;
        }
        return Integer.compare( energy, ((Energy) anEnergy).getEnergy())==0;
    }
}

ackage edu.fiuba.algo3.modelo.attributes;
import edu.fiuba.algo3.modelo.board.Board;

public class Position /*implements Comparable<Position>{
    Integer xCoord;
    Integer yCoord;
    Integer pathPosition;

    public Position() {
        xCoord = 0;
        yCoord = 0;
    }

    public Position(Integer xCoord, Integer yCoord) {
        this.update(xCoord, yCoord);
    }

    public Position(Integer newPosition) {
        this.update(newPosition);
    }

    public void update(Integer xCoord, Integer yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.pathPosition = Board.getPosition(xCoord, yCoord);
    }

    public void update(Integer newPosition) {
        this.pathPosition = newPosition;
        this.xCoord = Board.getPositionX(newPosition);
        this.yCoord = Board.getPositionY(newPosition);
    }

    public void add(Integer anotherPosition) {
        this.update(this.pathPosition + anotherPosition);
    }
    
    
    @Override
    public boolean equals(Object onePosition) {
        if (onePosition == this) {
            return true;
        }
        if (!(onePosition instanceof Position)) {
            return false;
        }
        return Integer.compare(currentPosition, ((Position) onePosition).getCurrentPosition())==0;
    }
    @Override
    public int compareTo(Position onePosition) {
        return this.currentPosition.compareTo(onePosition.getCurrentPosition());
    }
}

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
                
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}
 */