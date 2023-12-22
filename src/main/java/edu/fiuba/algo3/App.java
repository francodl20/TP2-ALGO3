package edu.fiuba.algo3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GameInfo.setSoundController(new SoundController());

        scene = new Scene(loadFXML("HomeScreen"));
        
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void closeApp() {
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    static void fullScreen() {
        Stage stage = (Stage) scene.getWindow();
        stage.setFullScreen(true);
    }
    
    public static void main(String[] args) {
        launch();
    }
}
