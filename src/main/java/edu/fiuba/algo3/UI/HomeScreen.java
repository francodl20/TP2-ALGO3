package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.GameMenuBar;
import edu.fiuba.algo3.controller.Controller;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class HomeScreen {
    
    private final Stage stage;

    public HomeScreen(Stage stage) {
        this.stage = stage;
    }

    public void start(Controller controller) {
         
        Image image = new Image(getClass().getResourceAsStream("/images/homeScreen.png"));

        ImageView imageView = new ImageView(image);
  
        imageView.setFitWidth(650); 
        imageView.setFitHeight(650); 
  
        StackPane stackPane = new StackPane(imageView);
  
        Label titleLabel = new Label("BIENVENIDOS" + "\n" + "     A  " + "\n" +  " ALGO-ROMA");
         
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 40);
        titleLabel.setFont(customFont);
        titleLabel.setStyle("-fx-text-fill: #C80B0B; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 10px;");
        titleLabel.setAlignment(Pos.CENTER);


        Button continueButton = new Button("Continuar");
        continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        continueButton.setPrefSize(180, 40);
        continueButton.setFont(customFont);

        StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
        StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 10, 0));
        MenuBar menuBar = GameMenuBar.createMenuBar();
        StackPane.setAlignment(menuBar, Pos.TOP_CENTER);;
 
        
        stackPane.getChildren().addAll(titleLabel, continueButton, menuBar);

        continueButton.setOnAction(event -> {
            UserInformationScreen userInformationScreen = new UserInformationScreen(controller);
            userInformationScreen.requestAmountOfPlayers(stage);
        });

          Scene scene = new Scene(stackPane, 600, 600);
  
          stage.setTitle("Escape del Coliseo");
          stage.setScene(scene);
          stage.show();
        
        
    }
}
