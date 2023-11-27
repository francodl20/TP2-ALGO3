package edu.fiuba.algo3.modelo.board.squares;

import edu.fiuba.algo3.modelo.IPlayer;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.obstacles.IObstacle;
import edu.fiuba.algo3.modelo.board.prizes.IPrize;

public class StartSquare implements ISquare{
    Position position;
    IPrize prize;
    IObstacle obstacle;

    public StartSquare(Position position, IPrize prize, IObstacle obstacle) {
        this.position = position;
        this.prize = prize;
        this.obstacle = obstacle;
    }

    public void play(IPlayer player){
        //
    }
    public boolean with(Position position){
        return (this.position == position);
    }
}
