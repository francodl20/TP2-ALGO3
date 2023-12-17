package edu.fiuba.algo3;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PlayerAmountController implements IController {
    
    @FXML
    private TextField numberOfPlayers;

    @FXML
    private Button continueButton;

    public void switchPlayerNames() throws IOException {
        Integer amount = Integer.parseInt(numberOfPlayers.getText());

        PlayerNamesController playerNamesController = 
        (PlayerNamesController) App.setRootAndGetController("PlayerNames");

        playerNamesController.setAmount(amount);
    }

}
