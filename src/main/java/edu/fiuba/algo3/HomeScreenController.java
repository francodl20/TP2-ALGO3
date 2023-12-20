package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeScreenController implements Initializable{
    
    @FXML
    private void switchToUserInfo() throws IOException{
        App.setRoot("PlayerAmount");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameInfo.getSoundController().setSong("gameIntro");
    }
}
