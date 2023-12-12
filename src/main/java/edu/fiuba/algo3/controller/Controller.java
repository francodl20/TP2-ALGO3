package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.UI.HomeScreen;
import edu.fiuba.algo3.UI.MapView;
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;
import edu.fiuba.algo3.modelo.attributes.gameState.IGameState;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller {

    MapView mapView;
    HomeScreen homeScreen;
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
        this.mapView = new MapView(18, 10, this/*, this.game.getPlayers() , playerNames*/);
        // mapView.loadCoordinates();

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

/*
    public void playD6(){  hold 
        game.playTurn(D6);
    }
*/
    public void movePlayer(){
        this.currentPlayer = game.getCurrentPlayer();

        D6 dice = new D6();
        gameState = game.playTurn(dice);
        //lastDiceRoll = game.getLastDiceRoll();

        mapView.drawMap(currentPlayer.getPosition());


        
        if (gameState.hasEnded()){
           finishScreen(gameState.getWinner());
        }
    }
    
    public void finishScreen(String endMessage){
        Group root = new Group();
        Scene secene = new Scene(root, 600, 600, Color.BLACK);

        Text text = new Text();
        text.setText(endMessage);
        text.setFill(Color.WHITE);
        text.setFont(Font.font(40));
        // text.selectionFillProperty(Color.AQUA);
        text.setY(300);
        text.setX(150);
        
        root.getChildren().add(text);

        primaryStage.setScene(secene);
    }

    public String playerToDraw(){
        return game.getCurrentPlayer().getName();
    }

    public Integer playerPosition(){
        return game.getCurrentPlayer().getPosition();
    }
    
}