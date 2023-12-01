package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.Log;

public class Novice implements ISeniority {
    Integer turns;
    Integer SEMISENIORITY_THRESHOLD = 8;
    Integer NOVICE_THRESHOLD = 0;
    Integer NOVICE_BONUS = 0;

    public Novice() {
        turns = NOVICE_THRESHOLD;
    }

    @Override
    public ISeniority addTurn() {
        turns++;
        if (turns.equals(SEMISENIORITY_THRESHOLD)) {
            Log.getInstance().info("Al fin... El gladiador actual acaba de recibir el rango de SemiSenior");
            return new SemiSenior();
        } else {
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return energy + NOVICE_BONUS;
    }
}