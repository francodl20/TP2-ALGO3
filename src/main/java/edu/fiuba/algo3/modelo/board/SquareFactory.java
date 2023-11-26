package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.attributes.Position;

public class SquareFactory {
    public static Square createSquare(Position position, Object type, Object obstacle, Object price){
        String instanceType = (String)type;

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
