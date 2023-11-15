package edu.fiuba.algo3.modelo.attributes;

public class Position {
    Integer currentPosition;

    public Position() {
        currentPosition = 0;
    }

    public void update(Integer newPosition) {
        currentPosition = newPosition;
    }
    
    public Integer getCurrentPosition() {
        return currentPosition;
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
}
