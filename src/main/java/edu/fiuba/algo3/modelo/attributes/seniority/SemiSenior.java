package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.Log;
import edu.fiuba.algo3.OutputController;

public class SemiSenior implements ISeniority {
    private final Integer SEMISENIORITY_BONUS = 5;
    private final Integer SENIORITY_THRESHOLD = 12;
    private final Integer SEMISENIORITY_THRESHOLD = 8;
    private Integer turns;

    public SemiSenior(){
        turns = SEMISENIORITY_THRESHOLD;
    }

    @Override
    public ISeniority addTurn(){
        turns++;

        if (turns.equals(SENIORITY_THRESHOLD)) {

            OutputController.seniorMessage();
            OutputController.updateSeniority("Senior");
            return new Senior();
        } else {

            OutputController.updateSeniority("Semi Senior");
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return (energy + SEMISENIORITY_BONUS);
    }
}