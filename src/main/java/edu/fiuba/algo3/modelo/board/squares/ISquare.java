package edu.fiuba.algo3.modelo.board.squares;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Coordinate;


public interface ISquare {

    //Acts according to the square content
    public void play(Gladiator player);
    
    //Returns true if the position matches, false if not
    public boolean with(Integer position);
    
    //Returns true if the position matches, false if not
    public Coordinate getSquareCoordinate();

    public String getPrizeType();
     
    public String getObstacleType();

}