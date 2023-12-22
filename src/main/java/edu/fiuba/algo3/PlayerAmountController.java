package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.exceptions.InvalidAmountException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class PlayerAmountController implements Initializable{
    
    @FXML
    private TextField numberOfPlayers;
    @FXML
    private Button continueButton;
    @FXML
    private Label validationLabel;

    @FXML
    private void validateNumber() {
        try {
            Integer amount = Integer.parseInt(numberOfPlayers.getText());
            if (amount < 2 || amount > 6) {
                throw new InvalidAmountException();
            } else {
                continueButton.setDisable(false);
                validationLabel.setText("");
            }
        } catch (Exception e) {
            continueButton.setDisable(true);
            validationLabel.setText("Numero ingresado incorrecto!");
        }
    }

    @FXML
    public void switchPlayerNames() throws IOException {
        Integer amount = Integer.parseInt(numberOfPlayers.getText());

        GameInfo.setPlayerAmount(amount);

        App.setRoot("PlayerNames");
    }

    //MenuBar
    @FXML
    Slider volumeSlider;
    @FXML
    MenuItem playPause;


    @FXML
    private void returnToMenu() throws IOException{
        MenuBarController.returnToMenu();
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MenuBarController.setUp(volumeSlider);
    }

}
