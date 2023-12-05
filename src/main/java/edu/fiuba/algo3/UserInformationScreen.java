package edu.fiuba.algo3;

import javafx.scene.Node; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserInformationScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro de jugadores");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Label lblNumberOfPlayers = new Label("Ingrese el numero de jugadores (entre 2 y 6):");
        TextField txtNumberOfPlayers = new TextField();
        Button btnNumberOfPlayers = new Button("Enviar");

        grid.add(lblNumberOfPlayers, 0, 0);
        grid.add(txtNumberOfPlayers, 1, 0);
        grid.add(btnNumberOfPlayers, 2, 0);

        btnNumberOfPlayers.setOnAction(event -> {
            String numberOfPlayersStr = txtNumberOfPlayers.getText();
            if (isValidNumber(numberOfPlayersStr, 2, 6)) {
                int numberOfPlayers = Integer.parseInt(numberOfPlayersStr);
                requestPlayerNames(primaryStage, numberOfPlayers);
            } else {
                showAlert("Error", "Ingrese un numero valido de jugadoress (entre 2 y 6).");
            }
        });

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void requestPlayerNames(Stage primaryStage, int numberOfPlayers) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        for (int i = 0; i < numberOfPlayers; i++) {
            Label label = new Label("Jugador " + (i + 1) + " Nombre:");
            TextField textField = new TextField();
            grid.add(label, 0, i);
            grid.add(textField, 1, i);
        }

        Button btnSubmitNames = new Button("Enviar");
        grid.add(btnSubmitNames, 0, numberOfPlayers);

        btnSubmitNames.setOnAction(event -> {
            boolean namesValid = true;
            for (Node node : grid.getChildren()) {
                if (node instanceof TextField) {
                    TextField textField = (TextField) node;
                    if (textField.getText().trim().isEmpty()) {
                        namesValid = false;
                        break;
                    }
                }
            }

            if (namesValid) {
                showAlert("Exito", "Los nombres se han ingresado satisfactoriamente.");
            } else {
                showAlert("Error", "Todos los nombres deben estar conformados por lo menos de un caracter.");
            }
        });

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
    }

    private boolean isValidNumber(String text, int min, int max) {
        try {
            int number = Integer.parseInt(text);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
