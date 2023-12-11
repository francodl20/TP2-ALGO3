package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.UI.HomeScreen;
import edu.fiuba.algo3.UI.MapView;
import edu.fiuba.algo3.modelo.GameController;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller {

    MapView mapView;
    HomeScreen homeScreen;
    GameController game;
    Stage primaryStage;
    
    public Controller(Stage primaryStage){

        this.primaryStage = primaryStage;
        homeScreen = new HomeScreen(primaryStage);
        
    }

    public void sartUI(){
        homeScreen.start(this);
    }

    public void startGame(List<String> playerNames, int numberOfPlayers) {
        game = new GameController(playerNames, numberOfPlayers);
    }

    public void showMap(){
        mapView = new MapView(10, 18);
        mapView.loadCoordinates();

        Scene mapScene = new Scene(mapView);
        primaryStage.setScene(mapScene);
    }

    public void recieveNumberOfPLayers(int number){}
}