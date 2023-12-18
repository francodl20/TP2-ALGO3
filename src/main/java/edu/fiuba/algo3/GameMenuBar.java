package edu.fiuba.algo3;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;


public class GameMenuBar{
    public GameMenuBar(){

    }
    public static MenuBar createMenuBar() {
       Menu gameMenu = new Menu("Opciones del Juego");;
        MenuItem exitItem = new MenuItem("Salir");
        MenuItem maximizeStageItem = new MenuItem("Maxizar");
        
        Menu musicMenu = new Menu("Musica");;
        MenuItem pauseMusictItem = new MenuItem("Pausar música");
        MenuItem resumeMusictItem = new MenuItem("Reanudar música");
        
        Menu changeMusictMenu = new Menu("Cambiar canción");
        MenuItem mulanMusictItem = new MenuItem("Hombres de Acción");
        MenuItem mainMusictItem = new MenuItem("Tema Principal");
        MenuItem marioGalaxyMusictItem = new MenuItem("Galáctico");
        changeMusictMenu.getItems().addAll(mulanMusictItem, mainMusictItem, marioGalaxyMusictItem);
        
        exitItem.setOnAction(e -> System.exit(0));
        
        pauseMusictItem.setOnAction(e -> System.out.println("prueba")); 
        resumeMusictItem.setOnAction(e -> System.out.println("prueba"));
        
        Menu helpMenu = new Menu("Ayuda");
        MenuItem instructionsItem = new MenuItem("Instrucciones");
        
        Menu aboutGameMenu = new Menu("Sobre el juego");
        MenuItem readAboutItem = new MenuItem("Leer concepto");
        
        gameMenu.getItems().addAll(maximizeStageItem,exitItem);
        musicMenu.getItems().addAll(pauseMusictItem, resumeMusictItem, changeMusictMenu);
        helpMenu.getItems().addAll(instructionsItem);
        aboutGameMenu.getItems().addAll(readAboutItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(gameMenu, musicMenu, helpMenu, aboutGameMenu);

        return menuBar;
    }

     public static VBox createLayoutWithMenuBar() {
        // Crear menús y elementos del menú
        Menu gameMenu = new Menu("Opciones del Juego");;
        MenuItem exitItem = new MenuItem("Salir");
        MenuItem maximizeStageItem = new MenuItem("Maximizar");
        
        Menu musicMenu = new Menu("Musica");;
        MenuItem pauseMusictItem = new MenuItem("Pausar música");
        MenuItem resumeMusictItem = new MenuItem("Reanudar música");
        
        Menu changeMusictMenu = new Menu("Cambiar canción");
        MenuItem mulanMusictItem = new MenuItem("Hombres de Acción");
        MenuItem mainMusictItem = new MenuItem("Tema Principal");
        MenuItem marioGalaxyMusictItem = new MenuItem("Galáctico");
        changeMusictMenu.getItems().addAll(mulanMusictItem, mainMusictItem, marioGalaxyMusictItem);
        
        exitItem.setOnAction(e -> System.exit(0));
        
        pauseMusictItem.setOnAction(e -> System.out.println("prueba")); 
        resumeMusictItem.setOnAction(e -> System.out.println("prueba"));
        
        Menu helpMenu = new Menu("Ayuda");
        MenuItem instructionsItem = new MenuItem("Instrucciones");
        
        Menu aboutGameMenu = new Menu("Sobre el juego");
        MenuItem readAboutItem = new MenuItem("Leer concepto");
        
        gameMenu.getItems().addAll(maximizeStageItem,exitItem);
        musicMenu.getItems().addAll(pauseMusictItem, resumeMusictItem, changeMusictMenu);
        helpMenu.getItems().addAll(instructionsItem);
        aboutGameMenu.getItems().addAll(readAboutItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(gameMenu, musicMenu, helpMenu, aboutGameMenu);

       
        VBox layout = new VBox();
        layout.getChildren().add(menuBar);

        return layout;
    }
    
}