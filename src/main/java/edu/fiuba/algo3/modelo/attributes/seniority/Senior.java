package edu.fiuba.algo3.modelo.attributes.seniority;

import edu.fiuba.algo3.OutputController;

public class Senior implements ISeniority {
    private final Integer SENIORITY_BONUS = 10;
    private final Integer SENIORITY_THRESHOLD = 12;
    private Integer turns;

    public Senior() {
        turns = SENIORITY_THRESHOLD;
    }

    @Override
    public ISeniority addTurn() {
        turns++;
        OutputController.updateSeniority("Senior");
        return this;
    }

    @Override
    public Integer energyPlus(Integer energy) {
        
        return (energy + SENIORITY_BONUS);
    }
}