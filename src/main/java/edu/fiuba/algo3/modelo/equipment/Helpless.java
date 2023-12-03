package edu.fiuba.algo3.modelo.equipment;
import edu.fiuba.algo3.Log;

public class Helpless implements IEquipment {

    public IEquipment enhance(){
        Log.getInstance().info("Oh si si, este guerrero va a mejorar su armadura!");
        Log.getInstance().info("Ahora está listo para circular por las rutas a caballo, ");
        Log.getInstance().info("¡porque tiene un hermoso y nuevo casco!");
        return new Helmet();
    }

    public Integer protectFromtWildBeast() {
        return (-20);
    }

    public boolean arriveToPompeya() {
        return false;
    }
}