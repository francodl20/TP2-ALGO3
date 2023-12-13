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
  

    public void showObstacleInfo(String obstacleType){
       
        if (!obstacleType.equals("Empty")) {
            
            Stage popupStage = new Stage();
            popupStage.setTitle("Obstaculo");
    
            Image backgroundImage = obstacleImageFactory(obstacleType);

            
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(400);
            backgroundImageView.setFitHeight(400);

            StackPane stackPane = new StackPane();
            Label titleLabel = obstacleLabelFactory(obstacleType);
         
            String fontPath = "/fonts/PressStart2P-Regular.ttf";
            Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 11);

            Button continueButton = new Button("Continuar");
            continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");

            continueButton.setPrefSize(150, 40);
            continueButton.setFont(customFont);

            StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
            StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
            StackPane.setAlignment(titleLabel, Pos.TOP_CENTER);
            //setAligmentForLbl(titleLabel, stackPane, obstacleType);
            
            stackPane.getChildren().addAll(backgroundImageView);
            stackPane.getChildren().addAll(titleLabel, continueButton);

            continueButton.setOnAction(event -> {
                popupStage.close();
            });


           
            Scene scene = new Scene(stackPane, 400, 400);
            popupStage.setScene(scene);
            popupStage.show();
        }

    }


    private Image obstacleImageFactory(String obstacleType){
        
        Map <String, Image> obstacleTypes = new HashMap<>();

        Image injury = new Image("file:src/main/resources/images/injuryImage.png");
        Image beast = new Image("file:src/main/resources/images/beastImage.png"); 
        Image bacchanalia = new Image("file:src/main/resources/images/bacchanaliaImage.png");
        
        obstacleTypes.put("Injury", injury);
        obstacleTypes.put("Beast", beast);
        obstacleTypes.put("Bacchanalia", bacchanalia);
        
        return obstacleTypes.get(obstacleType);
    }

    private Label obstacleLabelFactory(String obstacleType) {
        Map<String, Label> obstacleTypes = new HashMap<>();
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 11);
        Font customBacchanaliaFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 14);

        Label beast = new Label("Que es esto? Es un pájaro?\n      Es un avión? No... \n ¡Es una bestia que quiere\n    matar al gladiador!");
        beast.setFont(customFont);
        beast.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 6px;");
        beast.setAlignment(Pos.CENTER);

        Label injury = new Label("¿Por qué los malhumorados no juegan\n            al escondite? \n    Porque siempre los encuentran\n           de mal humor.\n\n     El gladiador se tropezó\n     con una piedra del camino...\n así que pierde el próximo turno :("); 
        injury.setFont(customFont);
        injury.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 6px;");
        injury.setAlignment(Pos.CENTER);

        Label bacchanalia = new Label("  El gladiador parece\n   que está borracho, \n  se tomó unos cuantos\n         tintos.");
        bacchanalia.setFont(customBacchanaliaFont);
        bacchanalia.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.9); -fx-padding: 6px;");
        bacchanalia.setAlignment(Pos.CENTER);
        
        obstacleTypes.put("Injury", injury);
        obstacleTypes.put("Beast", beast);
        obstacleTypes.put("Bacchanalia", bacchanalia);
        

        return obstacleTypes.get(obstacleType);
    }
}
    
