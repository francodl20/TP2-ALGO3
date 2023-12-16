package edu.fiuba.algo3.UI;

import edu.fiuba.algo3.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class CreditsScreen extends StackPane{
    
    public void start(Controller controller) {
        Stage creditStage = new Stage();
        
        creditStage.setTitle("Creditos");
            
        ImageView backgroundImageView = new ImageView("file:src/main/resources/images/OutroImage.png");
        backgroundImageView.setFitWidth(600);
        backgroundImageView.setFitHeight(600);

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customOutroFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 24);
        Font customCreditsFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 12);

        Label outroLbl = new Label("¡GRACIAS POR JUGAR!");
        outroLbl.setFont(customOutroFont);
        outroLbl.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 24px;");
        setAlignment(outroLbl, Pos.CENTER);
        outroLbl.setTranslateY(-180);
        
        Label creditsLbl = new Label("Modelado y Diseñado por:\n *Brando, Hernan\n *De Leon, Franco\n *Fanti, Gerónimo\n *Romero, Fabiola\n *Valle, Valentino");
        creditsLbl.setFont(customCreditsFont);
        creditsLbl.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 12px;");
        setAlignment(creditsLbl, Pos.BOTTOM_RIGHT);
       
        getChildren().addAll(backgroundImageView,outroLbl, creditsLbl);

        Scene scene = new Scene(this, 600, 600);
        creditStage.setScene(scene);
        creditStage.show();

        waitFor(creditStage, 10);
    }

    private void waitFor(Stage stage, Integer seconds) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), ae -> stage.close()));
        timeline.setCycleCount(1);
        timeline.play();
    }

}

