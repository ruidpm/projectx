package org.academiadecodigo.bootcamp.dungeons;

import org.academiadecodigo.bootcamp.dungeons.game.Game;
import org.academiadecodigo.bootcamp.dungeons.game.GameKeyboardHandler;
import org.academiadecodigo.bootcamp.dungeons.game.sounds.GameSounds;

public class Main {


    public static void main(String[] args) {

        Game game = new Game();
        new GameKeyboardHandler(game);
        
    }


}
