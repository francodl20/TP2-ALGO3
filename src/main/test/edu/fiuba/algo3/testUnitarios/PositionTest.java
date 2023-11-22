package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.attributes.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {

    @Test
    public void newlyCreatedPositionStartsAtPosition0() {
        // Arrange
        Position newPosition = new Position();
        // Act
        // Assert
        assertEquals(0, newPosition.getCurrentPosition());
    }

    @Test
    public void positionUpdatesLikeExpected() {
        // Arrange
        Position newPosition = new Position();

        // Act
        newPosition.update(6);

        // Assert
        assertEquals(6, newPosition.getCurrentPosition());
    }

    @Test
    public void comparingPositionsWorksAsExpected() {
        // Arrange 
        Position firstPosition = new Position();
        Position secondPosition = new Position();

        // Act
        // Assert
        assertTrue(firstPosition.equals(secondPosition));
    }
}