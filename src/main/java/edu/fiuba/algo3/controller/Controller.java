package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.UI.HomeScreen;
import edu.fiuba.algo3.UI.MapProv;
import edu.fiuba.algo3.UI.CreditsScreen;
import edu.fiuba.algo3.UI.FinishScreen;
import edu.fiuba.algo3.UI.MapView;
import edu.fiuba.algo3.UI.PrizeView;
import edu.fiuba.algo3.UI.ObstacleView;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.IDice;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;

public class Controller {
    
    private GameController game;
    private IGameState gameState;
    private List<String> playerNames;
    private int numberOfPlayers;
    private Gladiator currentPlayer;
    private IDice dice; 
    private MusicController musicController;
    private MediaPlayer mediaPlayer;


    private Stage primaryStage;
    private HomeScreen homeScreen;
    private GridPane mapGrid;
    private MapProv mapProv;
    private PrizeView prizeView;
    private ObstacleView obstacleView;

    public Controller(Stage primaryStage){

        this.primaryStage = primaryStage;
        homeScreen = new HomeScreen(primaryStage);
        mapGrid = new GridPane();
        musicController = new MusicController();
        
    }

    public void startUI(){
        homeScreen.start(this);
        this.musicController.playInitialMusic();
    }
    
    public void getNumbreOfPlayers(){
        homeScreen.start(this);
    }

    public void setGame(List<String> playerNames, int numberOfPlayers) {
        this.playerNames = playerNames;
        this.numberOfPlayers = numberOfPlayers;
        this.game = new GameController(playerNames, numberOfPlayers);     
          
    }

    public List<Gladiator> getPlayers(){
        return game.getPlayers();
    }
    
    public void showMap(){
        musicController.playMainMusic();
        this.mapProv = new MapProv(game.getSquares(), game.getMapSize(), this);
 
        Color backgroundColor = Color.BLACK; 
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
        Background background = new Background(backgroundFill);

        StackPane root = new StackPane();
        root.setBackground(background);
        root.getChildren().add(mapProv);
        
        Scene mapScene = new Scene(root);
        
        primaryStage.setScene(mapScene);
        primaryStage.show();
    }

    public void setDice(IDice dice){
        this.dice = dice;
    }
    
    public void movePlayer(){
        this.currentPlayer = game.getCurrentPlayer();

        gameState = game.playTurn(dice);

        mapProv.drawGame(mapGrid,currentPlayer.getPosition(), this.currentPlayer);

        if (gameState.hasEnded()){
            primaryStage.close();
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
    
    public Stage getStage(){
        return this.primaryStage;
    }

    public MusicController getMusicController(){
        return this.musicController;
    }
}