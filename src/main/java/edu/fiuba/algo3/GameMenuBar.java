package edu.fiuba.algo3;


import edu.fiuba.algo3.UI.AboutGameView;
import edu.fiuba.algo3.UI.InstructionsView;
import edu.fiuba.algo3.controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class GameMenuBar{
    public GameMenuBar(){
        
    }
    public static MenuBar createMenuBar(Stage stage) {
        
        Menu gameMenu = new Menu("Opciones del Juego");;
        MenuItem exitItem = new MenuItem("Salir");
        MenuItem maximizeStageItem = new MenuItem("Maxizar");
        
        Menu musicMenu = new Menu("Musica");
        MenuItem pauseMusictItem = new MenuItem("Pausar música");
        MenuItem resumeMusictItem = new MenuItem("Reanudar música");
        
        Menu changeMusictMenu = new Menu("Cambiar canción");
        MenuItem mulanMusictItem = new MenuItem("Hombres de Acción");
        MenuItem mainMusictItem = new MenuItem("Tema Principal");
        MenuItem marioGalaxyMusictItem = new MenuItem("Galáctico");
        
        changeMusictMenu.getItems().addAll(mulanMusictItem, mainMusictItem, marioGalaxyMusictItem);
        
        Menu helpMenu = new Menu("Ayuda");
        MenuItem instructionsItem = new MenuItem("Instrucciones");
        
        Menu aboutGameMenu = new Menu("Sobre el juego");
        MenuItem readAboutItem = new MenuItem("Leer concepto");

        exitItem.setOnAction(e -> System.exit(0));
        maximizeStageItem.setOnAction(e -> stage.setMaximized(true));
        pauseMusictItem.setOnAction(e -> System.out.println("prueba")); 
        resumeMusictItem.setOnAction(e -> System.out.println("prueba"));
        
        instructionsItem.setOnAction(e -> {
            InstructionsView instructions = new InstructionsView();
            instructions.start();

        });

        readAboutItem.setOnAction(e -> {
            AboutGameView about = new AboutGameView();
            about.start();

        });

        
        gameMenu.getItems().addAll(maximizeStageItem,exitItem);
        musicMenu.getItems().addAll(pauseMusictItem, resumeMusictItem, changeMusictMenu);
        helpMenu.getItems().addAll(instructionsItem);
        aboutGameMenu.getItems().addAll(readAboutItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(gameMenu, musicMenu, helpMenu, aboutGameMenu);

        return menuBar;
    }  

    
}