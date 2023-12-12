package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.controller.Controller;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FinishScreen extends Group {

    String endMessage;
/*

    public FinishScreen(String endMessage) {
        this.endMessage = endMessage;
    }

    public void start(Controller controller) {
         
        Image image = new Image(getClass().getResourceAsStream("/images/OutroImage.png"));

        ImageView imageView = new ImageView(image);
  
        imageView.setFitWidth(650); 
        imageView.setFitHeight(650); 
  
        StackPane stackPane = new StackPane(imageView);
  
        Label titleLabel = new Label("BIENVENIDOS" + "\n" + "     A  " + "\n" +  " ALGO-ROMA");
        
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
        titleLabel.setFont(customFont);
        titleLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 10px;");
        titleLabel.setAlignment(Pos.CENTER);


        Button continueButton = new Button("Continuar");
        continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");

        continueButton.setPrefSize(180, 40);
        continueButton.setFont(customFont);

        StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
        StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
 
        
        stackPane.getChildren().addAll(titleLabel, continueButton);

        continueButton.setOnAction(event -> {
            UserInformationScreen userInformationScreen = new UserInformationScreen(controller);
            userInformationScreen.start(stage);
        });
        stage.setResizable(false);
        stage.setMaximized(false);

        Scene scene = new Scene(stackPane, 650, 650);
  
          stage.setTitle("Gracias por jugar MF");
          stage.setScene(scene);
          stage.show();
        
    }
  */      
}
