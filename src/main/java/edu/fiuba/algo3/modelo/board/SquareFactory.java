package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.attributes.Position;

public class SquareFactory {
    public static Square createSquare(Object type, Object position){
        String instanceType = (String)type;
        Integer positionNumber = (Integer)position;
        Position position = new Position(positionNumber);

        switch (instanceType) {
            case "Empty":
                return new EmptySquare(position);
                
            case "Equipment":
                return new EquipmentSquare(position);

            case "Food":
                return new FoodSquare(position);

            case "Beast":
                return new BeastSquare(position);

            case "Bachanalia":
                return new BacchanaliaSquare(position);

            case "Injury":
                return new InjurySquare(position);

            case "Pompeii":
                return new PompeyaSquare(position);

            default:
                //se rompio todo
                return new EmptySquare(position);
        }    
        
    }
}
