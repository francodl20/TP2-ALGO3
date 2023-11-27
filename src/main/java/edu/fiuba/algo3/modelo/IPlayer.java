package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.board.squares.ISquare;

public interface IPlayer {
    public Position getCurrentPosition();

    public void eat();

    public void enhanceArmour();

    public void enjoyBacchanalia(Integer howManyDrinks);

    public void getInjured();

    public void fightAgainstWildBeast();

    public void arriveToPompeya();

    public boolean in(ISquare square);
}