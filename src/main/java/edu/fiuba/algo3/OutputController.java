package edu.fiuba.algo3;

public class OutputController {
    
    //Movement
    public static void playerPicked(String name) {
        String message = "La partida comenzará con el jugador: " + name;
        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
        GameInfo.setName(name);
    }

    public static void playerPlayed(String name, Integer diceRoll, Integer energy) {
        String message = name + " obtuvo un: " + diceRoll;

        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
        GameInfo.setEnergy(energy);
        GameInfo.setName(name);
    }

    public static void playerNotPlayed(String name, Integer energy) {
        String message = name+ " se quedó descansando... sigue en la misma casilla";

        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
        GameInfo.setEnergy(energy);
        GameInfo.setName(name);
    }

    public static void playerOutOfEnergy(String name, Integer energy) {
        String message = name + " tiene noni... su nivel de energía es de: " + 
            energy + ", por ahora sigue en la misma casilla";

        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
        GameInfo.setEnergy(energy);
        GameInfo.setName(name);
    }

    public static void reachedPompeii(String name) {
        String message = name + " llegó a Pompeya!";

        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
    }

    public static void notReachedPompeii() {
        String message = "Pero no tenía la llave, retrocedió la mitad del camino.";

        Log.getInstance().info(message);
        GameInfo.setMoveInfo(message);
    }

    public static void actualPosition(Integer position) {
        GameInfo.setPosition(position);
    }

    //Events
    public static void foughtWithABeast(Integer energy) {
        String message = 
        "Que es esto? Es un pájaro? Es un avión? No...\n" + 
        "¡Es una bestia que lo quiere matar!\n" + 
        "Despues de un duro combate, su nivel de energía es: " + energy;

        Log.getInstance().info(message);
        GameInfo.setObstacleInfo(message);
        GameInfo.setEnergy(energy);
    }

    public static void gotInjured() {
        String message = 
        "Se tropezó con una piedra del camino... así que pierde el próximo turno :(";

        Log.getInstance().info(message);
        GameInfo.setObstacleInfo(message);
    }

    public static void partied(Integer energyLost, Integer energy) {
        String message = 
        "Parece que está borracho, se tomó " + energyLost/4 +  " tintos.\n" + 
        "Su nivel de energía es " + energy;    

        Log.getInstance().info(message);
        GameInfo.setObstacleInfo(message);
        GameInfo.setEnergy(energy);
    }

    public static void enhancedNothing() {
        String message = 
        "Oh si si, este guerrero consiguió algo de protección!\n" + 
        "Ahora está listo para circular por las rutas a caballo, \n" + 
        "¡porque tiene un hermoso y nuevo casco!\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEquipment("Casco");
    }

    public static void enhancedHelmet() {
        String message = 
        "Oh si si, este guerrero va a mejorar su casco!\n" + 
        "Basta de usar casco, ahora aumenta su protección con una armadura!\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEquipment("Armadura");
    }

    public static void enhancedArmour() {
        String message = 
        "Oh si si, este guerrero va a mejorar su armadura!\n" + 
        "Ahora es todo un espadachín, con Espada y Escudo!\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEquipment("Espada y escudo");
    }

    public static void enhancedSwordAndShield() {
        String message = 
        "Oh si si, este guerrero va a mejorar su espada y escudo!\n" + 
        "Esta llave es mágica y viene con protección incluída!\n" + 
        "No hay mejor protección que esta llave!\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEquipment("Key");
    }

    public static void enhancedKey() {
        String message = 
        "Oh si si, este guerrero va a mejorar su armadura!\n" + 
        "Ah... solo es otra llave. No le sirve de nada.\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEquipment("Key");
    }

    public static void ateFood(String name, Integer energy) {
        String message = 
        "Oh si si! " + name + " se está comiendo un rico Sushi \uD80C\uDD9C!\n" + 
        "Su nivel de energía ahora es de: " + energy + "\n";

        Log.getInstance().info(message);
        GameInfo.setPrizeInfo(message);
        GameInfo.setEnergy(energy);
    }

    //State
    public static void semiSeniorMessage() {
        String message = "Al fin... El gladiador actual acaba de recibir el rango de SemiSenior";
        Log.getInstance().info(message);
    }

    public static void seniorMessage() {
        String message = "Wow... El gladiador actual acaba de recibir el rango de Senior";
        Log.getInstance().info(message);
    }

    public static void updateSeniority(String seniority) {
        GameInfo.setSeniority(seniority);
    }

}
