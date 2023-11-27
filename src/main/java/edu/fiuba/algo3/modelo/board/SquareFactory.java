package edu.fiuba.algo3.modelo.board;

import edu.fiuba.algo3.modelo.attributes.Position;

public class SquareFactory {
    public static ISquare createSquare(Position position, Object type, Object obstacle, Object price){
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

        /*
        PROPUESTA ALTERNATIVA PARA SQUARE FACTORY

        squareTypes.put("Empty", new EmptySqure(position);
        squareTypes.put("Equipment", new EquipmentSquare(position);
        squareTypes.put("Food", new FoodSquare(position);
        squareTypes.put("Beast", new BeastSquare(position);
        squareTypes.put("Bachanalia", new BachanaliaSquare(position);
        squareTypes.put("Injury", new InjurySquare(position);
        squareTypes.put("Pompeii", new PompeyaSquare(position);

        return (squareTypes.get(instanceType));
         */
    }
}
