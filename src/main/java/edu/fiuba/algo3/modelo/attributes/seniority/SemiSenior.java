package edu.fiuba.algo3.modelo.attributes.seniority;
import edu.fiuba.algo3.Log;

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
            Log.getInstance().info(
                "Wow... El gladiador actual acaba de recibir el rango de Senior");
            return new Senior();
            
        } else {
            return this;
        }
    }

    @Override
    public Integer energyPlus(Integer energy){
        return (energy + SEMISENIORITY_BONUS);
    }
}