package edu.fiuba.algo3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PlayerAmountController {
    
    private static TextField numberOfPlayers;

    @FXML
    private void switchPlayerNames() throws IOException {
        Integer amount = Integer.parseInt(numberOfPlayers.getText());
        PlayerNamesController.setAmount(amount);

        App.setRoot("PlayerNames");
    }


}
