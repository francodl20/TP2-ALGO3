package edu.fiuba.algo3.modelo.attributes;

public class Energy {
    public static final Integer NO_ENERGY = 0;
    Integer energy;
    // boolean injured;
    
    
    public Energy() {
        this.energy = 0;
        // this.injured = false;
    }

    public Energy(Integer initialEnergy) {
        this.energy = initialEnergy;
        // this.injured = false;
    }
    public Integer getEnergy() {
        return energy;
    }
    public Energy add(Energy anotherEnergy) {
        return new Energy(this.energy + anotherEnergy.getEnergy());
    }
    public boolean thereIsEnoughEnergyToPlay() {
        return (this.energy > NO_ENERGY /*&& !injured*/);
    } 
    public void getInjured() {
        // this.injured = true;
    }
    public void getRecovered() {
        // this.injured = false;
    }
    @Override
    public boolean equals(Object anEnergy) {
        if (anEnergy == this) {
            return true;
        }
        if (!(anEnergy instanceof Energy)) {
            return false;
        }
        return Integer.compare( energy, ((Energy) anEnergy).getEnergy())==0;
    }
}