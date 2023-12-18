package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.Log;

public class SwordAndShield implements IEquipment {

    public IEquipment enhance(){
        Log.getInstance().info(
            "Oh si si, este guerrero va a mejorar su armadura!");
        Log.getInstance().info(
            "Ahora tendrá una llave para abrir puertas y cerrojos...");
        Log.getInstance().info(
            "Esta llave es mágica y viene con protección incluída!");
        Log.getInstance().info(
            "No hay mejor protección que esta llave!");
        return new Key();
    }

    public Integer protectFromtWildBeast() {
        return (-2);
    }

    public boolean canEnterPompeii() {
        return false;
    }

    public String getEquipmentType() {
        return "Espada y Escudo";
    }
}