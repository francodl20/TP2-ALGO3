package edu.fiuba.algo3.modelo.attributes;

public class Position implements Comparable<Position>{
    Integer currentPosition;

    public Position() {
        currentPosition = 0;
    }
    public Position(Integer aPosition) {
        currentPosition = aPosition;
    }
    public Integer getCurrentPosition() {
        return currentPosition;
    }
    public void update(Integer newPosition) {
        currentPosition = newPosition;
    }
    public Position add(Position anotherPosition) {
        return new Position(this.currentPosition + anotherPosition.getCurrentPosition());
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
