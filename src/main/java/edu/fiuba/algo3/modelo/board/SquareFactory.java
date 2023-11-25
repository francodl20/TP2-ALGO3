package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.attributes.Position;

public class SquareFactory {
    public static Square createSquare(Object type, Object position){
        String instanceType = (String)type;
        Integer positionNumber = (Integer)position;
        Position positionClass = new Position(positionNumber);

        switch (instanceType) {
            case "Empty":
                return new EmptySquare(positionClass);
                
            case "Equipment":
                return new EquipmentSquare(positionClass);

            case "Food":
                return new FoodSquare(positionClass);

            case "Beast":
                return new BeastSquare(positionClass);

            case "Bachanalia":
                return new BacchanaliaSquare(positionClass);

            case "Injury":
                return new InjurySquare(positionClass);

            case "Pompeii":
                return new PompeyaSquare(positionClass);

            default:
                //se rompio todo
                return new EmptySquare(positionClass);
        }    
        
    }
}
