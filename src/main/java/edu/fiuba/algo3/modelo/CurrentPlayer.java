package edu.fiuba.algo3.modelo;

import java.util.LinkedList;
import java.util.List;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.Energy;
import edu.fiuba.algo3.modelo.attributes.Position;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.equipment.Helpless;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Square;




public class CurrentPlayer {
    List<Gladiator> gladiators;


    public CurrentPlayer() {
        gladiators = new LinkedList<Gladiator>();
    }

    public CurrentPlayer(int amountOfPlayers) {
        gladiators = new LinkedList<Gladiator>();
        for (int i = 0; i < amountOfPlayers; i++) {
            gladiators.add(new Gladiator(new Novice(), 
                                        new Energy(), 
                                        new Position(), 
                                        new Helpless()));
        }
    }

    public void play() {
        
    }



}
