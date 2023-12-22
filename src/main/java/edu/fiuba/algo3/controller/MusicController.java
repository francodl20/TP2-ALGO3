package edu.fiuba.algo3.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MusicController {

    private MediaPlayer mediaPlayer;

    public MediaPlayer setHomeScreenMusic() {
        mediaPlayer = this.setMusic(0.2, "/music/gameIntro.mp3");
        this.repet(mediaPlayer);
        return mediaPlayer;
    }
    public MediaPlayer setTrumpetsMusic() {
        mediaPlayer = this.setMusic(0.2, "/music/Option3.mp3");
        this.repet(mediaPlayer);
        return mediaPlayer; 
    }

    public MediaPlayer setMainMusic() {
        mediaPlayer = this.setMusic(0.1, "/music/main.mp3");
        this.repet(mediaPlayer);
        return mediaPlayer;
    }
    
    public MediaPlayer setMulanMusic() {
        mediaPlayer = this.setMusic(0.1, "/music/hombresDeAccion.mp3");
        this.repet(mediaPlayer);

        return mediaPlayer;
    }

    public MediaPlayer setGalacticMusic() {
        mediaPlayer = this.setMusic(0.1, "/music/galactic.mp3");
        this.repet(mediaPlayer);
        return mediaPlayer;
    }

    public MediaPlayer setWinningMusic() {
        mediaPlayer = this.setMusic(0.1, "/music/winningSound.mp3");
        return mediaPlayer;
    }

    public MediaPlayer setLosingMusic() {
        mediaPlayer = this.setMusic(0.1, "/music/losingSound.mp3");
        return mediaPlayer;
    }
    
    public void playWinningMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setWinningMusic();
        mediaPlayer.play();
    }
    public void playLosingMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setLosingMusic();
        mediaPlayer.play();
    }
    public void playInitialMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setHomeScreenMusic();
        mediaPlayer.play();
    }
    public void playMainMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setMainMusic();
        mediaPlayer.play();
    }
    public void playGalacticMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setGalacticMusic();
        mediaPlayer.play();
    }

    public void playTrumpetsMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setTrumpetsMusic();
        mediaPlayer.play();
    }
    public void playMulanMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        setMulanMusic();
        mediaPlayer.play();
    }

    private MediaPlayer setMusic(double volumen, String ruta) {

        Media media = new Media(getClass().getResource(ruta).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(volumen));
        mediaPlayer.setAutoPlay(true);

        return mediaPlayer;
    }

    private void repet(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });
    }

    public void mute() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getVolume() == 0) {
                mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.1));
            } else {
                mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0));
            }
        }
    }

    public void pause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void resume() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }
}
