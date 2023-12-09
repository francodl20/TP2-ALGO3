package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.Log;

public class Helmet implements IEquipment {

    public IEquipment enhance(){
        Log.getInstance().info("Oh si si, este guerrero va a mejorar su armadura!");
        Log.getInstance().info("Basta de usar casco, ahora aumenta su protección con un escudo!");
        return new Armour();
    }

    public Integer protectFromtWildBeast() {
        return (-15);
    }

    public boolean canEnterPompeii() {
        return false;
    }
}