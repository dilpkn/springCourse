package org.example;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music{
    List<String> rockMusicList = List.of("Wind cries Mary", "RockSong2", "RockSong3");
    Random rand = new Random();

    @Override
    public String getSong(){
        return rockMusicList.get(rand.nextInt(rockMusicList.size()));
    }
}
