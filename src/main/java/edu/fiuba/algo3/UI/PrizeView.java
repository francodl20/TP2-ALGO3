package edu.fiuba.algo3.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class PrizeView {

    public void showPrizeInfo(String prizeType) {

        if (!prizeType.equals("Empty")) {

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Premio");

            Image backgroundImage = prizeImageFactory(prizeType);

            
            ImageView backgroundImageView = new ImageView(backgroundImage);
            backgroundImageView.setFitWidth(400);
            backgroundImageView.setFitHeight(400);

            StackPane stackPane = new StackPane();
            Label titleLabel = prizeLabelFactory(prizeType);
         
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

           
            Scene scene = new Scene(stackPane, 400, 400);
            popupStage.setScene(scene);
            popupStage.show();
        }
    }

    private Image prizeImageFactory(String prizeType) {
        Map<String, Image> prizeTypes = new HashMap<>();

        Image food = new Image("file:src/main/resources/images/prizeFood.png");
        Image equipment = new Image("file:src/main/resources/images/EquipmentPrize.png");


        prizeTypes.put("Food", food);
        prizeTypes.put("Equipment", equipment);

        return prizeTypes.get(prizeType);
    }
    private Label prizeLabelFactory(String prizeType) {
        Map<String, Label> prizeTypes = new HashMap<>();

        Label foodLbl = new Label("           Oh si si!\n el Gladiador se está comiendo \n         un rico Sushi ");
        Label equipmentLbl = new Label("         Oh si si!\n el Gladiador ha mejorado \n      su equipamiento");


        prizeTypes.put("Food", foodLbl);
        prizeTypes.put("Equipment", equipmentLbl);

        return prizeTypes.get(prizeType);
    }
}
