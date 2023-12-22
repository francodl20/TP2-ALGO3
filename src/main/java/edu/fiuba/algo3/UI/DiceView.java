package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.GameMenuBar;
import edu.fiuba.algo3.controller.Controller;
import edu.fiuba.algo3.modelo.IDice;
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.D10;
import edu.fiuba.algo3.modelo.D20;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class DiceView extends StackPane {
    Controller controller;
    IDice diceRequired;

    public DiceView(Controller controller){
        this.controller = controller;
        this.diceRequired = null;
    }
    
    public void requestPreferedDice(Stage diceStage){
       

        ImageView diceImageView = new ImageView("file:src/main/resources/images/dices.png");
        diceImageView.setFitWidth(650); 
        diceImageView.setFitHeight(650); 

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 24);

        Label instruction = new Label("Seleccione el dado \n de su preferencia");
        instruction.setFont(customFont);
        instruction.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 24px;");
        setAlignment(instruction, Pos.CENTER);
        instruction.setTranslateY(-180);
        
        
        Button d6 = new Button("6 caras");
        d6.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        setAlignment(d6, Pos.BOTTOM_LEFT);
        d6.setPrefSize(180, 40);
        d6.setTranslateY(-100);
        
        
        Button d10 = new Button("10 caras");
        d10.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        setAlignment(d10, Pos.BOTTOM_CENTER);
        d10.setPrefSize(180, 40);
        d10.setTranslateY(-100);
        
        
        Button d20 = new Button("20 caras");
        d20.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        setAlignment(d20, Pos.BOTTOM_RIGHT);
        d20.setPrefSize(180, 40);
        d20.setTranslateY(-100);
        
        Button goBackButton = new Button("Volver");
        goBackButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        setAlignment(goBackButton, Pos.BOTTOM_CENTER);
        goBackButton.setPrefSize(180, 40);
     
        MenuBar bar = GameMenuBar.createMenuBar(diceStage, controller);
       setAlignment(bar, Pos.TOP_CENTER);
        getChildren().addAll(diceImageView, instruction, d6, d10, d20, goBackButton, bar);
        
        d6.setOnAction(event -> {
            diceStage.close();
            createDiceD6();
            controller.setDice(diceRequired);
            controller.showMap();
        });
        
        d10.setOnAction(event -> {
            diceStage.close();
            createDiceD10();
            controller.setDice(diceRequired);
            controller.showMap();
        });
        
        d20.setOnAction(event -> {
            diceStage.close();
            createDiceD20();
            controller.setDice(diceRequired);
            controller.showMap();
        });
        
        goBackButton.setOnAction(event -> {
            diceStage.close();
            UserInformationScreen screen = new UserInformationScreen(controller);
            screen.requestAmountOfPlayers(new Stage());
        });

        Scene diceScene = new Scene(this, 650,650);
        diceStage.setScene(diceScene);
        
        
    }

    private void createDiceD6(){
        diceRequired = new D6();
    }
    private void createDiceD10(){
        diceRequired = new D10();
    }
    private void createDiceD20(){
        diceRequired = new D20();
    }

    
    
}