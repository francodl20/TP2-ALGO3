package edu.fiuba.algo3;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundController{


    private File directory;
    private File[] files;

    private ArrayList<File> songs;

    private MediaPlayer mediaPlayer;
    
    private double volume;


    public SoundController() {

        //get the songs
        songs = new ArrayList<File>();
        directory = new File("src/main/resources/sound");
        files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                songs.add(file);
            }
        }

        //set up the player
        volume = 0.1;
        setSong("0-gameIntro");

    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void setSong(String name) {
        String absolutePath = directory.getAbsoluteFile().toURI().toString();
        String fileType = ".mp3";
        String songPath = absolutePath + name + fileType;

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(new Media(songPath));
        mediaPlayer.setVolume(volume);
        play();
    }
    
    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public Menu createSongMenu() {
        Menu menu = new Menu("Canciones");

        for (File song : songs) {
            if (song == songs.get(0)) continue;

            String name = song.getName().replace(".mp3", "");

            MenuItem item = new MenuItem(name);
            item.setOnAction(event -> {
                setSong(name);
            });

            menu.getItems().add(item);
        }

        return menu;
    }
}
