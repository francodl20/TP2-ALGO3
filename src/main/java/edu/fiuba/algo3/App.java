package edu.fiuba.algo3;

import edu.fiuba.algo3.UI.AboutGameView;
import edu.fiuba.algo3.UI.InstructionsView;
import edu.fiuba.algo3.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
       // AboutGameView ej = new AboutGameView();
        //ej.start();
        Controller controller = new Controller(primaryStage);
        controller.startUI();
    }

    public static void main(String[] args) {
        launch(args);
    }
}