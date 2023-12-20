package edu.fiuba.algo3;


import edu.fiuba.algo3.UI.AboutGameView;
import edu.fiuba.algo3.UI.InstructionsView;
import edu.fiuba.algo3.controller.Controller;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;



public class GameMenuBar{
    public GameMenuBar(){
        
    }
    public static MenuBar createMenuBar(Stage stage, Controller controller) {
        
        Menu gameMenu = new Menu("Opciones del Juego");;
        MenuItem exitItem = new MenuItem("Salir");
        MenuItem maximizeStageItem = new MenuItem("Maxizar");
        
        Menu musicMenu = new Menu("Musica");
        MenuItem pauseMusictItem = new MenuItem("Pausar música");
        MenuItem resumeMusictItem = new MenuItem("Reanudar música");
        
        Menu changeMusictMenu = new Menu("Cambiar canción");
        MenuItem mulanMusictItem = new MenuItem("Hombres de Acción");
        MenuItem trumpetMusictItem = new MenuItem("Trompetesco");
        MenuItem marioGalaxyMusictItem = new MenuItem("Galáctico");
        
        changeMusictMenu.getItems().addAll(mulanMusictItem, trumpetMusictItem, marioGalaxyMusictItem);
        
        Menu helpMenu = new Menu("Ayuda");
        MenuItem instructionsItem = new MenuItem("Instrucciones");
        
        Menu aboutGameMenu = new Menu("Sobre el juego");
        MenuItem readAboutItem = new MenuItem("Leer concepto");

        exitItem.setOnAction(e -> System.exit(0));
        maximizeStageItem.setOnAction(e -> stage.setMaximized(true));

        mulanMusictItem.setOnAction(e -> {
            controller.getMusicController().playMulanMusic();
        }); 
        trumpetMusictItem.setOnAction(e -> {
            controller.getMusicController().playTrumpetsMusic();
        }); 
        marioGalaxyMusictItem.setOnAction(e -> {
            controller.getMusicController().playGalacticMusic();;
        }); 
        pauseMusictItem.setOnAction(e -> {
            controller.getMusicController().pause();
        }); 

        resumeMusictItem.setOnAction(e -> {
             controller.getMusicController().resume();
        });
        
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