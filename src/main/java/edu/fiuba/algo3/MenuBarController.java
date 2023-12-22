package edu.fiuba.algo3;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Menu;
import javafx.scene.control.Slider;

public class MenuBarController {
    
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

    public static void help() throws IOException{
        App.setRoot("");
    }   
    
    public static void about() {
        
    }
}
