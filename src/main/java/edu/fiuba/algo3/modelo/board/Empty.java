package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.board.prizes.IPrize;

public class Empty implements IPrize, IObstacle  {
    
    public void harm(IPlayer player) { }

    public void boostGladiator(IPlayer player) { }

}