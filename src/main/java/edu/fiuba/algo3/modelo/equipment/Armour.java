package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.Log;

public class Armour implements IEquipment {

    public IEquipment enhance() {
        Log.getInstance().info(
            "Oh si si, este guerrero va a mejorar su armadura!");
        Log.getInstance().info(
            "Ahora es todo un espadachín, con Espada y Escudo!\n");
        return new SwordAndShield();
    }

    public Integer protectFromtWildBeast() {
        return -10;    
    }

    public boolean canEnterPompeii() {
        return false;
    }

    public String getEquipmentType() {
        return "Armadura";
    }
}   