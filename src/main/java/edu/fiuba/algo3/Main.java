package edu.fiuba.algo3;

import java.util.ArrayList;

//Temporary
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import edu.fiuba.algo3.modelo.attributes.gameState.OngoingGame;
import edu.fiuba.algo3.modelo.attributes.seniority.Novice;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.equipment.Helpless;

import java.util.Scanner;

public class Main {

    private static final Integer INITIAL_ENERGY = 20;

    public static Integer getNumberOfPlayers(Scanner scanner) {
        System.out.println("Enter number of players: ");
        Integer numberOfPlayers = 0;
        try {
            numberOfPlayers = Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfPlayers;
    }

    public static String getPlayerName(Scanner scanner, int i) {
        System.out.println(String.format("Enter name of player %d: ", i + 1));
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        App.main(args);

        ArrayList<Gladiator> gladiators = new ArrayList<>(); 
        
        Scanner scanner = new Scanner(System.in);
        Integer numberOfPlayers = getNumberOfPlayers(scanner);
        
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = getPlayerName(scanner, i);
            Gladiator currentGladiator = new Gladiator(name, new Novice(), INITIAL_ENERGY, 1, new Helpless(), new D6());
            gladiators.add(currentGladiator);
        }

        String json = "src/main/resources/JSONFiles/board.json";
        Board board = null;
        try {
            board = new Board(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameController game = new GameController(gladiators, board, new OngoingGame());
        IGameState gameState = new OngoingGame();

        while (!gameState.hasEnded()){
            System.out.println("\nPress enter to roll the dice");
            scanner.nextLine();
            gameState = game.playTurn(new D6());
        }
        
    }
}
