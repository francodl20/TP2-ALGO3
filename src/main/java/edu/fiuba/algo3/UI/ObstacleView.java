package edu.fiuba.algo3.UI;

import java.util.HashMap;
import java.util.Map;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import javafx.stage.Stage;

public class ObstacleView {
  

    public void showObstalceInfo(String obstacleType){
       
        if (obstacleType != "Empty") {
            
            Stage popupStage = new Stage();
            popupStage.setTitle("Obstaculo");
    
            Image backgroundImage = obstacleImageFactory(obstacleType);

            
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(400);
            backgroundImageView.setFitHeight(400);

            StackPane stackPane = new StackPane();
            Label titleLabel = obstacleLabelFactory(obstacleType);
         
            String fontPath = "/fonts/PressStart2P-Regular.ttf";
            Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);
            titleLabel.setFont(customFont);
            titleLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 6px;");
            titleLabel.setAlignment(Pos.CENTER);


            Button continueButton = new Button("Continuar");
            continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");

            continueButton.setPrefSize(150, 40);
            continueButton.setFont(customFont);

            StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
            StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
            
            
            stackPane.getChildren().addAll(titleLabel, continueButton);

            continueButton.setOnAction(event -> {
                popupStage.close();
            });

            stackPane.getChildren().addAll(backgroundImageView);

           
            Scene scene = new Scene(stackPane, 600, 600);
            popupStage.setScene(scene);
            popupStage.show();
        }

    }
    
    private Image obstacleImageFactory(String obstacleType){
        
        Map <String, Image> obstacleTypes = new HashMap<>();

        Image injury = new Image("file:src/main/resources/images/gladiator.png");
        Image beast = new Image("file:src/main/resources/images/gladiator2.png"); 
        Image bacchanalia = new Image("file:src/main/resources/images/gladiator2.png");
        
        obstacleTypes.put("Injury", injury);
        obstacleTypes.put("Beast", beast);
        obstacleTypes.put("Bacchanalia", bacchanalia);
        
        return obstacleTypes.get(obstacleType);
    }

    private Label obstacleLabelFactory(String obstacleType) {
        Map<String, Label> obstacleTypes = new HashMap<>();

        Label beast = new Label("Que es esto? Es un pájaro? Es un avión? No... \n ¡Es una bestia que quiere matar al gladiador!");
        Label injury = new Label("¿Por qué los malhumorados no juegan al escondite? \nPorque siempre los encuentran de mal humor.\nEl gladiador se tropezó con una piedra del camino...\n así que pierde el próximo turno :("); 
        Label bacchanalia = new Label("El gladiador parece que está borracho, \nse tomó unos cuantos tintos.");
        
        
        obstacleTypes.put("Injury", injury);
        obstacleTypes.put("Beast", beast);
        obstacleTypes.put("Bacchanalia", bacchanalia);
        

        return obstacleTypes.get(obstacleType);
    }
}
    
