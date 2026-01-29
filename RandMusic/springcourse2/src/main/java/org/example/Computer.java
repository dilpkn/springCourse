package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sound.midi.Track;

@Component
public class Computer {

    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    public String playMusicComp(TypeOfMusic typeOfMusic) {
        return "Computer " + id + " " + musicPlayer.playMusic(typeOfMusic);
    }
}
