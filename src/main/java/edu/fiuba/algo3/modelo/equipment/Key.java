package edu.fiuba.algo3.modelo.equipment;

import edu.fiuba.algo3.Log;

public class Key implements IEquipment {

    public IEquipment enhance(){
        Log.getInstance().info(
            "Oh si si, este guerrero va a mejorar su armadura!");
        Log.getInstance().info(
            "Ah... solo es otra llave. No le sirve de nada.");
        
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (0); 
    }

    public boolean canEnterPompeii() {
        return true;
    }
}