package edu.fiuba.algo3;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeScreenController {
    
    @FXML
    private void switchToUserInfo() throws IOException{
        App.setRoot("PlayerAmount");
    }
}