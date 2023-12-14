package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.UI.HomeScreen;
import edu.fiuba.algo3.UI.CreditsScreen;
import edu.fiuba.algo3.UI.FinishScreen;
import edu.fiuba.algo3.UI.MapView;
import edu.fiuba.algo3.UI.PrizeView;
import edu.fiuba.algo3.UI.ObstacleView;
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {

    MapView mapView;
    HomeScreen homeScreen;
    PrizeView prizeView;
    ObstacleView obstacleView;
    GameController game;
    Gladiator currentPlayer;
    Stage primaryStage;
    List<String> playerNames;
    int numberOfPlayers;
    Integer lastDiceRoll;
    IGameState gameState;

    public Controller(Stage primaryStage){

        this.primaryStage = primaryStage;
        homeScreen = new HomeScreen(primaryStage);
        
    }

    public void startUI(){
        homeScreen.start(this);
    }
    
    public void getNumbreOfPlayers(){
        homeScreen.start(this);
    }

    public void startGame(List<String> playerNames, int numberOfPlayers) {
        this.playerNames = playerNames;
        this.numberOfPlayers = numberOfPlayers;
        this.game = new GameController(playerNames, numberOfPlayers);     
          
    }

    public List<Gladiator> getPlayers(){
        return game.getPlayers();
    }
    
    public void showMap(){
        this.mapView = new MapView(18, 10, this);

        Color backgroundColor = Color.BLACK; 
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
        Background background = new Background(backgroundFill);
        StackPane root = new StackPane();
        root.setBackground(background);
        root.getChildren().add(mapView);
        Scene mapScene = new Scene(root);

        primaryStage.setScene(mapScene);
        primaryStage.show();
    }

    public void movePlayer(){
        this.currentPlayer = game.getCurrentPlayer();

        D6 dice = new D6();
        gameState = game.playTurn(dice);

        mapView.drawMap(currentPlayer.getPosition());

        if (gameState.hasEnded()){
           showFinishScreen(gameState.getWinner());
        }
    }
    
    public void showCredits(){
        CreditsScreen creditScreen = new CreditsScreen();
        creditScreen.start(this);
    }
 

    public String playerToDraw(){
        return game.getCurrentPlayer().getName();
    }

    public Integer playerPosition(){
        return game.getCurrentPlayer().getPosition();
    }

    public void showSquareInfo(String obstacleType, String prizeType ){
       this.prizeView = new PrizeView();
       prizeView.showPrizeInfo(prizeType);
       
       this.obstacleView = new ObstacleView();
       obstacleView.showObstacleInfo(obstacleType);
    }
    public void showFinishScreen(String endMessage){
       FinishScreen finishScreen = new FinishScreen(endMessage);
       finishScreen.start(this);
    }
    
}