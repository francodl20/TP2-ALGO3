package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        
        HomeScreen homeScreen = new HomeScreen(primaryStage);
        homeScreen.start();
    
        primaryStage.setTitle("Escape del Coliseo");
        primaryStage.show();
    
        /*
         
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.start(primaryStage);

        MapView mapView = new MapView(10,18);
        //mapView.cargarCoordenadas();

        Scene scene = new Scene(mapView, 300, 600); // Ajusta el tamaño según tus necesidades

        primaryStage.setTitle("Map View Example");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
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