package edu.fiuba.algo3.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AboutGameView {

    public void start() {
       
        Stage abouStage = new Stage();
  
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: black;");
      
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
        /*
         * 
         */
         Label titleLabel = new Label("Sobre el juego");
         titleLabel.setFont(customFont);
         titleLabel.setStyle("-fx-text-fill: #C80B0B; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 10px;");
         stackPane.setAlignment(titleLabel, Pos.TOP_CENTER);
        
        Label instructionsLabel = new Label( "  AlgoRoma, es el Trabajo Práctico 2 de \n"+ 
                                             "Algoritmos 3, muestra un divertido juego\n"+
                                             "ambientado en el imperio romano.\n\n" + 
                                             "Tu misión es guiar a tu gladiador desde el\n " + 
                                             "Coliseo romano hasta Pompeya, mientras te\n" + 
                                             "enfrentas a desafíos y vas adquiriendo tu \n" + 
                                             "equipamiento para alcanzar la victoria.\n\n" + 
                                             "Este juego aplica el paradigma de objetos\n" + 
                                             "para el desarrollo del modelo, así como\n" + 
                                             "otros conceptos impartidos en clase.\n");
       
                                          instructionsLabel.setFont(customFont);
        instructionsLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-text-fill: #FFFFFF; -fx-padding: 10px; -fx-font-size: 20px;");
        instructionsLabel.setAlignment(Pos.CENTER);


        Button continueButton = new Button("Cerrar");
        continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        continueButton.setPrefSize(100, 40);
        continueButton.setFont(customFont);

        StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
        StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
        StackPane.setMargin(titleLabel, new javafx.geometry.Insets(15, 0, 0, 0));
       
     
        stackPane.getChildren().addAll( titleLabel, instructionsLabel, continueButton);

        continueButton.setOnAction(event -> {
           abouStage.close();
        });

          Scene scene = new Scene(stackPane, 900, 650);
          
        abouStage.setTitle("Sobre AlgoRoma");
        abouStage.setScene(scene);
        abouStage.show();   
    }
}