package edu.fiuba.algo3;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class MenuBarController {
    static Stage stage;

    public static void setUp(Menu soundMenu) {
        soundMenu.getItems().add(GameInfo.getSoundController().createSongMenu());
    }

    public static void setUp(Slider volumeSlider) {
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                GameInfo.getSoundController().setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    public static void returnToMenu() throws IOException{
        App.setRoot("HomeScreen");
    }

    public static void closeGame() {
        App.closeApp();
    }

    public static void fullScreen() {
        App.fullScreen();
    }

    public static void pauseMusic() {
        GameInfo.getSoundController().pause();
    }

    public static void playMusic() {
        GameInfo.getSoundController().play();
    }

    public static void help() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("HelpScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }

    public static void closePopUp() {
        stage.close();
    }
    
    public static void about() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AboutScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();   
    }
}
