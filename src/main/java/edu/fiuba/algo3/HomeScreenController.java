package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;

public class HomeScreenController implements Initializable{
    
    @FXML
    private void switchToUserInfo() throws IOException{
        App.setRoot("PlayerAmount");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MenuBarController.setUp(volumeSlider);

        GameInfo.getSoundController().setSong("0-gameIntro");
    }

    //MenuBar
    @FXML
    Slider volumeSlider;
    @FXML
    MenuItem playPause;

    @FXML
    private void closeGame() {
        MenuBarController.closeGame();
    }

    @FXML
    private void fullScreen() {
        MenuBarController.fullScreen();
    }

    @FXML
    private void pauseMusic() {
        MenuBarController.pauseMusic();
        playPause.setText("Reproducir música");
        playPause.setOnAction(event -> {playMusic();}); 
    }

    @FXML
    private void playMusic() {
        MenuBarController.playMusic();
        playPause.setText("Pausar música");
        playPause.setOnAction(event -> {pauseMusic();});
    }

    @FXML
    private void help() throws IOException {
        MenuBarController.help();
    }   
    
    @FXML
    private void about() {
       MenuBarController.about(); 
    }
}
