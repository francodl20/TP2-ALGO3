package edu.fiuba.algo3;

import java.io.IOException;

import javafx.fxml.FXML;

public class PlayerNamesController {
    
    private static Integer numberOfPlayers;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public static void setAmount(Integer amount){
        numberOfPlayers = amount;
    }
}
