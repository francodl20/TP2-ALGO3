package edu.fiuba.algo3.modelo.board;
import edu.fiuba.algo3.modelo.Player;
import edu.fiuba.algo3.modelo.attributes.Position;

public interface Square {
    public void play(Player player);
    public boolean with(Position position);
}

/*
public Square(String type, String position)
switch case type:
 case 'equipment':
    return new Equipment(position)
 */
