package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music classicalMusic;
    private Music rockMusic;

    @Autowired
        public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic, @Qualifier("rockMusic") Music rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic(TypeOfMusic typeOfMusic) {
        switch (typeOfMusic) {
            case CLASSICAL:
                return "playing " + classicalMusic.getSong();
            case ROCK:
                return "playing " + rockMusic.getSong();
            default:
                return null;
        }
    }
}
