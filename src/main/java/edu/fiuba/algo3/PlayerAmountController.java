package edu.fiuba.algo3;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PlayerAmountController {
    
    @FXML
    private TextField numberOfPlayers;

    @FXML
    private Button continueButton;

    public void switchPlayerNames() throws IOException {
        Integer amount = Integer.parseInt(numberOfPlayers.getText());

        GameInfo.setPlayerAmount(amount);

        App.setRoot("PlayerNames");
    }

}
