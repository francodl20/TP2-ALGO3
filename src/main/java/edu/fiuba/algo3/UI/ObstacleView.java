package edu.fiuba.algo3.UI;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ObstacleView {
  

    public void showObstalceInfo(String obstacleType){
       
        if (obstacleType != "Empty") {
            
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Obstaculo");
    
        
            popupStage.initStyle(javafx.stage.StageStyle.TRANSPARENT);
    
            Image backgroundImage = new Image("file:src/main/resources/images/popUpBackground.png"); 
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(300); 
            backgroundImageView.setFitHeight(400);
            
            Label label = new Label("Contenido del obstaculo shalalala ");
    
            ImageView obstacleImage = obstacleImageFactory(obstacleType);
    
            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(backgroundImageView, label, obstacleImage);
            stackPane.setAlignment(Pos.CENTER);
    
            String fontPath = "/fonts/PressStart2P-Regular.ttf";
            Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
            label.setFont(customFont);
            label.setStyle("-fx-text-fill: #C80B0B; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 10px;");
            label.setAlignment(Pos.CENTER);
    
            Scene scene = new Scene(stackPane, 600, 600);
            popupStage.setScene(scene);
            popupStage.show();
        }

    }
    
    private ImageView obstacleImageFactory(String obstacleType){
        
        Map <String, ImageView> obstacleTypes = new HashMap<>();

        ImageView injury = new ImageView("file:src/main/resources/images/gladiator.png");
        injury.setFitWidth(50);
        injury.setFitHeight(50);

        ImageView beast = new ImageView("file:src/main/resources/images/gladiator2.png");
        beast.setFitWidth(50);
        beast.setFitHeight(50);
        
        ImageView bacchanalia = new ImageView("file:src/main/resources/images/gladiator2.png");
        bacchanalia.setFitWidth(50);
        bacchanalia.setFitHeight(50);

        obstacleTypes.put("Injury", injury);
        obstacleTypes.put("Beast", beast);
        obstacleTypes.put("Beast", bacchanalia);
        
        return obstacleTypes.get(obstacleType);
    }
}
    
