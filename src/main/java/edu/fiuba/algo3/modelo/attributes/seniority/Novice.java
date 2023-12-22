package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.Log;
import edu.fiuba.algo3.OutputController;

public class Novice implements ISeniority {
    private final Integer SEMISENIORITY_THRESHOLD = 8;
    private final Integer NOVICE_THRESHOLD = 0;
    private final Integer NOVICE_BONUS = 0;
    private Integer turns;

    public Novice() {
        turns = NOVICE_THRESHOLD;
    }

    @Override
    public ISeniority addTurn() {
        turns++;
        
        if (turns.equals(SEMISENIORITY_THRESHOLD)) {

            OutputController.semiSeniorMessage();
            OutputController.updateSeniority("Semi Senior");
            return new SemiSenior();
        } else {

            OutputController.updateSeniority("Novato");
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return energy + NOVICE_BONUS;
    }
}