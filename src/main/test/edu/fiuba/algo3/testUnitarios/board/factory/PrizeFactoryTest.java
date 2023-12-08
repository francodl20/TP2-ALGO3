package edu.fiuba.algo3.testUnitarios.board.factory;

//Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Tested
import edu.fiuba.algo3.modelo.board.factory.PrizeFactory;
import edu.fiuba.algo3.modelo.board.prizes.IPrize;
import edu.fiuba.algo3.modelo.board.prizes.Food;
import edu.fiuba.algo3.modelo.board.prizes.Equipment;
import edu.fiuba.algo3.modelo.board.prizes.EmptyPrize;


public class PrizeFactoryTest {

    @Test
    public void PrizeFactoryCreatesEquipment(){

        //Arrange
        Object PrizeType = "Equipment";

        IPrize square = PrizeFactory.createPrize(PrizeType);

        //Act
        Boolean result = square instanceof Equipment;

        //Assert
        assertTrue(result);
    }  

    @Test
    public void PrizeFactoryCreatesFood(){

        //Arrange
        Object PrizeType = "Food";

        IPrize square = PrizeFactory.createPrize(PrizeType);

        //Act
        Boolean result = square instanceof Food;

        //Assert
        assertTrue(result);
    }  

    @Test
    public void prizeFactoryCreatesEmptyPrize(){

        //Arrange
        Object prizeType = "";

        IPrize square = PrizeFactory.createPrize(prizeType);

        //Act
        Boolean result = square instanceof EmptyPrize;

        //Assert
        assertTrue(result);
    }  
}
