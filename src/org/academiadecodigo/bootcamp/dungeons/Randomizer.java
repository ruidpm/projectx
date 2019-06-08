package org.academiadecodigo.bootcamp.dungeons;

public class Randomizer {
    public static int randomizeBetween(int min, int max){
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static int getPercentage(){
        return (int) Math.floor(Math.random() * (100 - 0 + 1));
    }
}