package edu.fiuba.algo3;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.exceptions.InvalidNameException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PlayerNamesController implements Initializable {

    Integer numberOfPlayers;

    @FXML
    private Label labelOne, labelTwo, labelThree,labelFour, labelFive, labelSix;
    @FXML
    private TextField nameOne, nameTwo, nameThree, nameFour, nameFive, nameSix;
    @FXML
    private HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6;
    @FXML
    Label validationLabel;

    private void validateName(String name) throws Exception{
        Boolean lenghtValidation = name.length() < 4;
        Boolean numberValidation = true;

        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            numberValidation = false;
        }


        if (lenghtValidation || numberValidation) {
            throw new InvalidNameException();
        } else {
            validationLabel.setText("");
        }
        
    }

    @FXML
    private void switchToMap() throws IOException {
        List<String> nameList = listOfPlayerNames(numberOfPlayers);

        if (nameList != null) {
            GameController game = new GameController(nameList, numberOfPlayers);
            GameInfo.setGame(game);
            App.setRoot("MapView");
        }
    }

    @FXML
    private void switchToPlayerAmount() throws IOException {
        App.setRoot("PlayerAmount");
    }

    private void setAmount(Integer amount) {
        numberOfPlayers = amount;

        makeBackgroundVisible(amount);

        if (1 <= amount) {
            makePlayerOneAccesible();
        }
        if (2 <= amount) {
            makePlayerTwoAccesible();
        }
        if (3 <= amount) {
            makePlayerThreeAccesible();
        }
        if (4 <= amount) {
            makePlayerFourAccesible();
        }
        if (5 <= amount) {
            makePlayerFiveAccesible();
        }
        if (6 <= amount) {
            makePlayerSixAccesible();
        }
    }

    private LinkedList<String> listOfPlayerNames(Integer num) {
        LinkedList<String> nameList = new LinkedList<>();
        String name;

        try {

            if (1<= num ) {
                name = nameOne.getText();
                validateName(name);
                nameList.add(name);
            }
            if (2<= num ) {
                name = nameTwo.getText();
                validateName(name);
                nameList.add(name);
            }
            if (3<= num ) {
                name = nameThree.getText();
                validateName(name);
                nameList.add(name);
            }
            if (4<= num ) {
                name = nameFour.getText();
                validateName(name);
                nameList.add(name);
            }
            if (5<= num ) {
                name = nameFive.getText();
                validateName(name);
                nameList.add(name);
            }
            if (6<= num ) {
                name = nameSix.getText();
                validateName(name);
                nameList.add(name);
            }

        } catch (Exception e) {
            validationLabel.setText("Los nombres ingresados deben\ntener al menor 4 letras");
            nameList = null;
        }

        return nameList;
    }

    private void makeBackgroundVisible(Integer number) {
        switch (number) {
            case 1:
                hbox1.setVisible(true);
                break;
            case 2:
                hbox2.setVisible(true);
                break;
            case 3:
                hbox3.setVisible(true);
                break;
            case 4:
                hbox4.setVisible(true);
                break;
            case 5:
                hbox5.setVisible(true);
                break;
            case 6:
                hbox6.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void makePlayerOneAccesible() {
        labelOne.setVisible(true);
        nameOne.setVisible(true);
        nameOne.setEditable(true);
    }

    private void makePlayerTwoAccesible() {
        labelTwo.setVisible(true);
        nameTwo.setVisible(true);
        nameTwo.setEditable(true);
    }

    private void makePlayerThreeAccesible() {
        labelThree.setVisible(true);
        nameThree.setVisible(true);
        nameThree.setEditable(true);
    }

    private void makePlayerFourAccesible() {
        labelFour.setVisible(true);
        nameFour.setVisible(true);
        nameFour.setEditable(true);
    }

    private void makePlayerFiveAccesible() {
        labelFive.setVisible(true);
        nameFive.setVisible(true);
        nameFive.setEditable(true);
    }

    private void makePlayerSixAccesible() {
        labelSix.setVisible(true);
        nameSix.setVisible(true);
        nameSix.setEditable(true);
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
    private void about() throws IOException {
       MenuBarController.about(); 
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAmount(GameInfo.getPlayerAmount());
        
        MenuBarController.setUp(volumeSlider);
    }
}
