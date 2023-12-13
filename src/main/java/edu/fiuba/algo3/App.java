package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Controller controller = new Controller(primaryStage);
        //controller.startUI();
        //controller.play(;)
        controller.prueba();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


/**
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.control.Label;
 import javafx.scene.layout.StackPane;
 import javafx.stage.Stage;
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
 * JavaFX App
 public class App extends Application {
     
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
*/