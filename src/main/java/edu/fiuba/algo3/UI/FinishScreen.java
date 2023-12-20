package edu.fiuba.algo3.UI;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FinishScreen extends StackPane {

    String endMessage;


    public FinishScreen(String endMessage) {
        this.endMessage = endMessage;
    }
    
    public void start(Controller controller) {
        Stage finishStage = new Stage();
        
        finishStage.setTitle("Resultado del juego");
            
        ImageView backgroundImageView = resultImageFactory(endMessage.equals("Game tied."));
        backgroundImageView.setFitWidth(600);
        backgroundImageView.setFitHeight(600);

        Label labelText = resultLabelFactory(endMessage.equals("Game tied."));
        
        Button continueButton = new Button("Continuar");
        continueButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        continueButton.setPrefSize(180, 40);
        
        Button startAgainButton = new Button("Volver a jugar");
        startAgainButton.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige;");
        startAgainButton.setPrefSize(220, 40);
        
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);
        continueButton.setFont(customFont);
        
        StackPane.setAlignment(continueButton, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 5, 10, 0));
        
        StackPane.setAlignment(startAgainButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(startAgainButton, new javafx.geometry.Insets(0, 0, 10, 5));
        
        continueButton.setOnAction(event -> {
            finishStage.close();
            controller.showCredits();
        });
        
        startAgainButton.setOnAction(event -> {
            finishStage.close();
            controller.startUI();
        });

        getChildren().addAll(backgroundImageView,labelText, continueButton, startAgainButton);

        Scene scene = new Scene(this, 600, 600);
        finishStage.setScene(scene);
        finishStage.show();
    }

     private ImageView resultImageFactory(boolean result) {
        Map<Boolean, ImageView> resultTypes = new HashMap<>();

        ImageView tiedGame = new ImageView("file:src/main/resources/images/tiedGameImage.png");
        ImageView winner = new ImageView("file:src/main/resources/images/winnerImage.png");


        resultTypes.put(true, tiedGame);
        resultTypes.put(false, winner);

        return resultTypes.get(result);
    }
    
     private Label resultLabelFactory(Boolean result) {
        Map<Boolean, Label> resultTypes = new HashMap<>();
        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customTiedGameFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 24);
        Font customWinnerFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 14);

        Label tiedGame = new Label(endMessage);
        tiedGame.setFont(customTiedGameFont);
        tiedGame.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 24px;");
        setAlignment(tiedGame, Pos.CENTER);
        tiedGame.setTranslateY(-180);
        
        
        Label winner = new Label(endMessage.split("\\s+")[0] + " ha ganado el juego!!");
        winner.setFont(customWinnerFont);
        winner.setStyle("-fx-text-fill: #000000; -fx-padding: 6px;");
       
        setAlignment(winner, Pos.CENTER);
        winner.setTranslateY(-180);
        
      
        resultTypes.put(true, tiedGame);
        resultTypes.put(false, winner);

        return resultTypes.get(result);
    }
}
