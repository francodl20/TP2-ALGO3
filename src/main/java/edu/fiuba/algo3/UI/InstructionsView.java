package edu.fiuba.algo3.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InstructionsView {

    public void start() {
        Stage instructionsStage = new Stage();
  
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: black;");
      
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
        /*
         * 
         */
         Label titleLabel = new Label("INSTRUCCIONES");
         titleLabel.setFont(customFont);
         titleLabel.setStyle("-fx-text-fill: #C80B0B; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 10px;");
         stackPane.setAlignment(titleLabel, Pos.TOP_CENTER);
        
        Label instructionsLabel = new Label("*Comienzas en el Coliseo romano con 20 puntos\n" + 
                                          " de energía y sin equipamiento.\n\n" + 
                                          "*Selecciona el dado con el que jugarás la partida\n" + 
                                          " (6, 10 o 20 caras), toca lanzar dado y verás como\n" + 
                                          " tu personaje avanza por el mapa.\n\n" +
                                          "*La casillas del coliseo pueden contener premios \n" + 
                                          " (comida o equipamiento) u obstáculos\n\n" + 
                                          "   °La comida te da +15 puntos de energía.\n\n " + 
                                          "  °El equipamiento podrá protegerte del ataque de\n"+ 
                                          "   la fiera y si encuentras la llave serás capaz\n"+ 
                                          "   de salir del coliseo y reclamar tu premio.\n\n" +
                                          "   °Los obstáculos como Bacanal y la fiera te restan\n" + 
                                          "    energía y con la lesion pierdes un turno\n\n" + 
                                          "*Recibirás un plus según tu seniority cada turno y se\n" + 
                                          " verá reflejado en tu energía.\n\n" +
                                          "*Gana quien llegue primero a Pompeya o el juego termina\n" + 
                                          " después de 30 turnos.");
       
                                          instructionsLabel.setFont(customFont);
        instructionsLabel.setStyle("-fx-font-family: 'Press Start 2P'; -fx-text-fill: #FFFFFF; -fx-padding: 10px; -fx-font-size: 16px;");
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
           instructionsStage.close();
        });

          Scene scene = new Scene(stackPane, 900, 650);
          
        instructionsStage.setTitle("Instrucciones");
        instructionsStage.setScene(scene);
        instructionsStage.show();   
    }
}