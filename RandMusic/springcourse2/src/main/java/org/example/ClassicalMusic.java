package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {
    List<String> classicalMusicList = List.of("Hungarian Rhapsodes", "ClassicalSong2", "ClassicalSong3" );
    Random rand = new Random();

    @Override
    public String getSong(){
        return classicalMusicList.get(rand.nextInt(classicalMusicList.size()));
    }

}
