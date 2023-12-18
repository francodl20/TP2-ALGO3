package edu.fiuba.algo3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import edu.fiuba.algo3.modelo.GameController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PlayerNamesController implements IController {

    Integer numberOfPlayers;

    @FXML
    private Label labelOne;
    @FXML
    private TextField nameOne;
    @FXML
    private HBox hbox1;
    @FXML
    private Label labelTwo;
    @FXML
    private TextField nameTwo;
    @FXML
    private HBox hbox2;
    @FXML
    private Label labelThree;
    @FXML
    private TextField nameThree;
    @FXML
    private HBox hbox3;
    @FXML
    private Label labelFour;
    @FXML
    private TextField nameFour;
    @FXML
    private HBox hbox4;
    @FXML
    private Label labelFive;
    @FXML
    private TextField nameFive;
    @FXML
    private HBox hbox5;
    @FXML
    private Label labelSix;
    @FXML
    private TextField nameSix;
    @FXML
    private HBox hbox6;

    @FXML
    private void switchToMap() throws IOException {
        List<String> nameList = listOfPlayerNames(numberOfPlayers);
        GameController game = new GameController(nameList, numberOfPlayers);

        MapViewController mapView = 
        (MapViewController) App.setRootAndGetController("MapView");

        mapView.setGame(game);
    }

    @FXML
    private void switchToPlayerAmount() throws IOException {
        App.setRoot("PlayerAmount");
    }

    public void setAmount(Integer amount) {
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

        if (1<= num ) {
            nameList.add(nameOne.getText());
        }
        if (2<= num ) {
            nameList.add(nameTwo.getText());
        }
        if (3<= num ) {
            nameList.add(nameThree.getText());
        }
        if (4<= num ) {
            nameList.add(nameFour.getText());
        }
        if (5<= num ) {
            nameList.add(nameFive.getText());
        }
        if (6<= num ) {
            nameList.add(nameSix.getText());
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

    


}
