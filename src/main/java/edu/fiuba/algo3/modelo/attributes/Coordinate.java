package edu.fiuba.algo3.modelo.attributes;

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
  
}
