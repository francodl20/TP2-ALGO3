package edu.fiuba.algo3.modelo.board.prizes;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.Log;
public class Food implements IPrize {

    public Food() { }

    public void boost(Gladiator player) {
        player.eat();
        Log.getInstance().info("Oh si si! "+player.getName()+" se está comiendo un rico Sushi \uD80C\uDD9C!");
        Log.getInstance().info(("su energía ahora es de: "+player.getEnergy()));
    }
}