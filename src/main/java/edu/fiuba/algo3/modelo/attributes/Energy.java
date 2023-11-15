package edu.fiuba.algo3.modelo.attributes;

public class Energy {
    Integer energy;

    public Energy(Integer initialEnergy) {
        this.energy = initialEnergy;
    }
    public Integer getEnergy() {
        return energy;
    }
    public Energy add(Energy anotherEnergy) {
        return new Energy(this.energy + anotherEnergy.getEnergy());
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