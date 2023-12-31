package edu.fiuba.algo3.UI;

import java.util.List;
import java.util.Set;

import javafx.scene.Node; 
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

import java.util.HashSet;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.collections.ObservableList;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import edu.fiuba.algo3.GameMenuBar;
import edu.fiuba.algo3.controller.Controller;
import javafx.scene.layout.BackgroundPosition;

public class UserInformationScreen extends GridPane {


    private final Controller controller;

    public UserInformationScreen(Controller controller) {
        this.controller = controller;
    }

    public void requestAmountOfPlayers(Stage stage) {
         
        Image backgroundImage = new Image("file:src/main/resources/images/UserInformationScreen.png"); 
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundObject = new Background(background);

        GridPane mainGrid = new GridPane();
        mainGrid.setBackground(backgroundObject);
        mainGrid.setVgap(10);
      
        GridPane specificGrid = new GridPane();
        specificGrid.setAlignment(Pos.CENTER);
        specificGrid.setHgap(10);
        specificGrid.setVgap(10);
        specificGrid.setPadding(new Insets(20, 43, 20, 43));

        String backgroundColorHex = "#000000"; 
        Color backgroundColor = Color.web(backgroundColorHex, 0.7);
        specificGrid.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY))); 
       
        Scene scene = new Scene(mainGrid, 600, 600);

        String fontPath = "/fonts/PressStart2P-Regular.ttf";
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fontPath), 10);

        stage.setTitle("Registro de jugadores");
        
        Label labelNumberOfPlayers = new Label("Ingrese el numero de jugadores \n        (entre 2 y 6)");
        labelNumberOfPlayers.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 12px;");
        labelNumberOfPlayers.setTextFill(Color.web("#FFFFFF"));
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
        
        MenuBar menuBar = GameMenuBar.createMenuBar(stage, controller);
        mainGrid.setAlignment(Pos.TOP_CENTER);

        
        setColumnSpan(menuBar, Integer.MAX_VALUE);

        mainGrid.add(menuBar, 0,0);
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
    }
    
    private void requestPlayerNames(Stage stage, int numberOfPlayers) {

        Image backgroundImage = new Image("file:src/main/resources/images/UserInformationScreen.png"); 
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundObject = new Background(background);

        StackPane grid = new StackPane();
        grid.setPrefSize(600, 600);
        grid.setBackground(backgroundObject);

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
            label.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 11px;");
            label.setTextFill(Color.web("#FFFFFF"));
            label.setFont(customFont);
            label.setPrefWidth(400);
            TextField textField = new TextField();
            textField.setPrefWidth(150);
            specificGrid.add(label, 0, i);
            specificGrid.add(textField, 7, i);
        }
        specificGrid.setMaxHeight(100);
        grid.setAlignment(specificGrid, Pos.TOP_CENTER);
        specificGrid.setTranslateY(50);
        grid.getChildren().add(specificGrid);//add(specificGrid, 0, 5);
       
        Button buttonSubmitNames = new Button("Enviar");
        buttonSubmitNames.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige; -fx-font-size: 20px;");
        buttonSubmitNames.setPrefSize(150, 40);
        buttonSubmitNames.setFont(customFont);
        grid.setAlignment(buttonSubmitNames, Pos.BOTTOM_RIGHT);
        buttonSubmitNames.setTranslateY(-50);
        buttonSubmitNames.setTranslateX(-20);
        grid.getChildren().add(buttonSubmitNames);//, 0, 25);
       
        Button buttonGoBack = new Button("Volver");
        buttonGoBack.setStyle("-fx-font-family: 'Press Start 2P'; -fx-background-color: beige; -fx-font-size: 20px;");
        buttonGoBack.setPrefSize(150, 40);
        buttonGoBack.setFont(customFont);
        grid.setAlignment(buttonGoBack, Pos.BOTTOM_LEFT);
        buttonGoBack.setTranslateY(-50);
        buttonGoBack.setTranslateX(20);
        grid.getChildren().add(buttonGoBack);//, 0, 25);

        MenuBar menuBar = GameMenuBar.createMenuBar(stage, controller);
        grid.setAlignment(menuBar, Pos.TOP_CENTER);
        grid.getChildren().add(menuBar);//, 0,0);
 

        buttonSubmitNames.setOnAction(event -> {   
            if (namesAreValid(specificGrid)) {
            
                List<String> playerNames = getPlayerNames(specificGrid, numberOfPlayers);
                
                controller.setGame(playerNames, numberOfPlayers);
                DiceView diceView = new DiceView(controller);
                diceView.requestPreferedDice(stage);
                
            } else {
                showAlert("Error", "Todos los nombres deben estar conformados por lo menos de cuatro caracteres y los mismos no deben repetirse.");
            }
        });
        
        buttonGoBack.setOnAction(event -> {   
           requestAmountOfPlayers(stage);
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

    /*
     
    
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
    */

    private boolean namesAreValid(GridPane specificGrid) {
    boolean namesValid = true;
    Set<String> uniqueNames = new HashSet<>();

    for (Node node : specificGrid.getChildren()) {
        if (node instanceof TextField) {
            TextField textField = (TextField) node;
            String name = textField.getText().trim();

            if (name.length() < 4) {
                namesValid = false;
                break;
            }

            if (!uniqueNames.add(name)) {
                namesValid = false;
                break;
            }

            if (name.equalsIgnoreCase("Game")) {
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

    private List<String> getPlayerNames(GridPane specificGrid, int numberOfPlayers) {
    List<String> playerNames = new LinkedList<String>();

    for (int i = 0; i < numberOfPlayers; i++) {
        Node node = getNodeByRowColumnIndex(i, 7, specificGrid);
        if (node instanceof TextField) {
            TextField textField = (TextField) node;
            playerNames.add(textField.getText());
        }
    }

    return playerNames;
}

private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
    Node result = null;
    ObservableList<Node> children = gridPane.getChildren();

    for (Node node : children) {
        if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
            result = node;
            break;
        }
    }

    return result;
}


}
