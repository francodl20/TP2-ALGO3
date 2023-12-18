package edu.fiuba.algo3.UI;

import java.util.LinkedList;

import edu.fiuba.algo3.GameMenuBar;
import edu.fiuba.algo3.controller.Controller;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class GameView extends StackPane{

    Controller controller;
    MapView mapView;
    Scene scene;
    public GameView(Controller controller,LinkedList<ISquare> squares, Coordinate mapSize){
        this.controller = controller;
        this.mapView = new MapView(squares, mapSize, controller);
    }

    public Scene getGameView(){
        Color backgroundColor = Color.BLACK; 
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
        Background background = new Background(backgroundFill);
      this.setBackground(background);
      String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
      
        MenuBar menuBar = GameMenuBar.createMenuBar();
        // this.add(menuBar, );
        // this.getChildren().add(menuBar);
       
        Button diceButton = new Button("Tirar dado");
        diceButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        diceButton.setPrefSize(120, 40);
        diceButton.setFont(customFont);

        
        Button goBackButton = new Button("Volver");
        goBackButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: blue;");
        goBackButton.setPrefSize(120, 40);
        goBackButton.setFont(customFont);
        
  
        diceButton.setOnAction(event->{
            controller.movePlayer();
        });
        
        goBackButton.setOnAction(event->{
            UserInformationScreen userInformationScreen = new UserInformationScreen(controller);
            userInformationScreen.requestAmountOfPlayers(controller.getStage());
        });

        StackPane.setMargin(menuBar, new Insets(0, 0, 5, 0));  // Márgenes: arriba, derecha, abajo, izquierda
        StackPane.setMargin(diceButton, new Insets(0, 10, 5, 0));  // Márgenes: arriba, derecha, abajo, izquierda
        StackPane.setMargin(goBackButton, new Insets(0, 10, 0, 10));

        mapView.drawMap(0);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(menuBar);
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().add(mapView);
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().add(goBackButton);
        this.setAlignment(Pos.BOTTOM_LEFT);
        this.getChildren().add(diceButton);
        Scene scene = new Scene(this);
        return scene;
    }


    

}