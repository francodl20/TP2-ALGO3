package edu.fiuba.algo3.UI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class PrizeView {

    public void showPrizeInfo(String prizeType) {

        if (!prizeType.equals("Empty")) {

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Premio");
            
            ImageView backgroundImageView = prizeImageFactory(prizeType);
            backgroundImageView.setFitWidth(400);
            backgroundImageView.setFitHeight(400);

            Label titleLabel = prizeLabelFactory(prizeType);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(backgroundImageView);
            
            String fontPath = "/fonts/PressStart2P-Regular.ttf";
            Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);
            
            
            Button continueButton = new Button("Continuar");
            continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
            
            continueButton.setPrefSize(150, 40);
            continueButton.setFont(customFont);
            
            StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
            StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
            StackPane.setAlignment(titleLabel, Pos.TOP_CENTER);
            
            
            continueButton.setOnAction(event -> {
                popupStage.close();
            });
            
            
            stackPane.getChildren().addAll(titleLabel, continueButton);
           
            Scene scene = new Scene(stackPane, 400, 400);
            popupStage.setScene(scene);
            popupStage.show();

            waitFor(popupStage, 6);
        }
    }

    private void waitFor(Stage stage, Integer seconds) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), ae -> stage.close()));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private ImageView prizeImageFactory(String prizeType) {
        Map<String, ImageView> prizeTypes = new HashMap<>();

        ImageView food = new ImageView("file:src/main/resources/images/foodImage.png");
        ImageView equipment = new ImageView("file:src/main/resources/images/equipmentImage.png");


        prizeTypes.put("Food", food);
        prizeTypes.put("Equipment", equipment);

        return prizeTypes.get(prizeType);
    }

    private Label prizeLabelFactory(String prizeType) {
        Map<String, Label> prizeTypes = new HashMap<>(); 
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFoodFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 12);
        Font customEquipmentFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 13);

        Label foodLbl = new Label("           Oh si si!\n el Gladiador se está comiendo \n         un rico Sushi ");
        foodLbl.setFont(customFoodFont);
        foodLbl.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 6px;");
        foodLbl.setAlignment(Pos.CENTER);
       
        Label equipmentLbl = new Label("         Oh si si!\n el Gladiador ha mejorado \n      su equipamiento");
        equipmentLbl.setFont(customEquipmentFont);
        equipmentLbl.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 6px;");
        equipmentLbl.setAlignment(Pos.CENTER);

        prizeTypes.put("Food", foodLbl);
        prizeTypes.put("Equipment", equipmentLbl);

        return prizeTypes.get(prizeType);
    }
}
