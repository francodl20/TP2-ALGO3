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

public class PrizeView{
    
    
    public void showPrizeInfo(String prizeType){
       
        if (prizeType != "Empty") {
            
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Premio");


            popupStage.initStyle(javafx.stage.StageStyle.TRANSPARENT);

            Image backgroundImage = new Image("file:src/main/resources/images/popUpBackground.png"); 
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(300); 
            backgroundImageView.setFitHeight(400);

            Label label = new Label("Contenido del premio shalalala ");

            ImageView prizeImage = prizeImageFactory(prizeType);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(backgroundImageView, label, prizeImage);
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
    
    private ImageView prizeImageFactory(String prizeType){
        
        Map <String, ImageView> prizeTypes = new HashMap<>();

        ImageView food = new ImageView("file:src/main/resources/images/gladiator.png");
        food.setFitWidth(50);
        food.setFitHeight(50);

        ImageView equipment = new ImageView("file:src/main/resources/images/gladiator2.png");
        equipment.setFitWidth(50);
        equipment.setFitHeight(50);

        prizeTypes.put("Food", food);
        prizeTypes.put("Equipment", equipment);
        
        return prizeTypes.get(prizeType);
    }
}