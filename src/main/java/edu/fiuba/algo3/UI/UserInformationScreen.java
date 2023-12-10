package edu.fiuba.algo3.UI;

import javafx.scene.Node; 
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;

public class UserInformationScreen extends Application {

    @Override
    public void start(Stage stage) {
         
        Image backgroundImage = new Image("file:src/main/resources/images/usersInformationScreen.jpg"); 
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundObject = new Background(background);

        GridPane mainGrid = new GridPane();
        mainGrid.setBackground(backgroundObject);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(20, 20, 20, 20));

        GridPane specificGrid = new GridPane();
        specificGrid.setAlignment(Pos.CENTER);
        specificGrid.setHgap(10);
        specificGrid.setVgap(10);
        specificGrid.setPadding(new Insets(20, 20, 20, 20));

        String backgroundColorHex = "#000000"; 
        Color backgroundColor = Color.web(backgroundColorHex, 0.7);
        specificGrid.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY))); 
        Scene scene = new Scene(mainGrid, 600, 600);

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);

        stage.setTitle("Registro de jugadores");
        
        Label labelNumberOfPlayers = new Label("Ingrese el numero de jugadores \n        (entre 2 y 6)");
        labelNumberOfPlayers.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12px;");
        labelNumberOfPlayers.setTextFill(Color.web("#C80B0B"));;
        labelNumberOfPlayers.setFont(customFont);

        TextField txtNumberOfPlayers = new TextField();
        txtNumberOfPlayers.setPrefWidth(30);

        Button buttonSendNumberOfPlayers = new Button("Enviar");
        buttonSendNumberOfPlayers.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige; -fx-font-size: 10px;");
        buttonSendNumberOfPlayers.setPrefSize(90, 25);
        buttonSendNumberOfPlayers.setFont(customFont);
        
        specificGrid.add(labelNumberOfPlayers, 0, 0);
        specificGrid.add(txtNumberOfPlayers, 1, 0);
        specificGrid.add(buttonSendNumberOfPlayers, 2, 0);

        mainGrid.add(specificGrid, 0, 2);
        
        buttonSendNumberOfPlayers.setOnAction(event -> {
            String numberOfPlayersStr = txtNumberOfPlayers.getText();
            if (isValidNumber(numberOfPlayersStr, 2, 6)) {
                int numberOfPlayers = Integer.parseInt(numberOfPlayersStr);
                requestPlayerNames(stage, numberOfPlayers);
            } else {
                showAlert("Error", "Ingrese un numero valido de jugadoress (entre 2 y 6).");
            }
        });
    
        stage.setScene(scene);
        stage.show();
        
        stage.setResizable(false);
        stage.setMaximized(false);
    }
    
    private void requestPlayerNames(Stage stage, int numberOfPlayers) {

        Image backgroundImage = new Image("file:src/main/resources/images/usersInformationScreen.jpg"); 
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundObject = new Background(background);

        GridPane grid = new GridPane();
        grid.setPrefSize(600, 600);
        grid.setBackground(backgroundObject);grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        GridPane specificGrid = new GridPane();
        specificGrid.setAlignment(Pos.CENTER);
        specificGrid.setHgap(10);
        specificGrid.setVgap(10);
        specificGrid.setPadding(new Insets(20, 20, 20, 20));

        String backgroundColorHex = "#000000"; 
        Color backgroundColor = Color.web(backgroundColorHex, 0.7);
        specificGrid.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY))); 
       
        Scene scene = new Scene(grid, 600, 600);

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);

        for (int i = 0; i < numberOfPlayers; i++) {
            Label label = new Label("Ingrese el nombre del jugador #" + (i + 1) + ":");
            label.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 10px;");
            label.setTextFill(Color.web("#C80B0B"));;
            label.setFont(customFont);
            label.setPrefWidth(400);
            TextField textField = new TextField();
            textField.setPrefWidth(150);
            specificGrid.add(label, 0, i);
            specificGrid.add(textField, 7, i);
        }

        grid.add(specificGrid, 0, 2);
       
        Button buttonSubmitNames = new Button("Enviar");
        buttonSubmitNames.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige; -fx-font-size: 20px;");
        buttonSubmitNames.setPrefSize(150, 40);
        buttonSubmitNames.setFont(customFont);
        grid.setHalignment(buttonSubmitNames, HPos.CENTER);
        grid.add(buttonSubmitNames, 0, 17);

        buttonSubmitNames.setOnAction(event -> {   
            if (namesAreValid(specificGrid)) {
               
                showAlert("Exito", "Los nombres se han ingresado satisfactoriamente.");
                
                MapView mapView = new MapView(10, 18);
                mapView.loadCoordinates();

                Scene mapScene = new Scene(mapView, 400, 700); 
                stage.setScene(mapScene);
                
            } else {
                showAlert("Error", "Todos los nombres deben estar conformados por lo menos de un caracter.");
            }
        });

        stage.setScene(scene);
    }
   
    private boolean isValidNumber(String text, int min, int max) {
        try {
            int number = Integer.parseInt(text);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean namesAreValid(GridPane specificGrid){
        boolean namesValid = true;

            for (Node node : specificGrid.getChildren()) {
                if (node instanceof TextField) {
                    TextField textField = (TextField) node;
                    if (textField.getText().trim().isEmpty()) {
                        namesValid = false;
                        break;
                    }
                }
            }
        return namesValid;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}