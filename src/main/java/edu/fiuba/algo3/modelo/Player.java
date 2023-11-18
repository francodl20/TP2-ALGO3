package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.attributes.Position;

public interface Player {
    public Position getCurrentPosition();

    public void eat();

    public void enhanceArmour();

    public void enjoyBacchanalia(Integer howManyDrinks);

    public void getInjured();

    public void fightAgainstWildBeast();

    public void arriveToPompeya();
}