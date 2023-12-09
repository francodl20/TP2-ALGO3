package edu.fiuba.algo3.modelo.attributes;

import java.util.Objects;

public class Coordinate{
    Integer x;
    Integer y;

    public Coordinate(Integer xValue, Integer yValue){
        this.x = xValue;
        this.y = yValue;
    }
    public void setXValue(Integer xValue) {
        this.x = xValue;
    }
    public void setYValue(Integer yValue) {
        this.y = yValue;

    }
    public Integer getXValue() {
        return this.x;

    }
    public Integer getYValue() {
        return this.y;
    }
   @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Coordinate coordinate = (Coordinate) obj;
    return Objects.equals(x, coordinate.x) && Objects.equals(y, coordinate.y);
}

  
}
