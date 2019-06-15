package org.academiadecodigo.bootcamp.dungeons;

import org.academiadecodigo.bootcamp.dungeons.game.Game;
import org.academiadecodigo.bootcamp.dungeons.game.GameKeyboardHandler;
import org.academiadecodigo.bootcamp.dungeons.game.Images;

public class Main {


    public static void main(String[] args) {

        Images images = new Images();
        Game game = new Game(images);
        new GameKeyboardHandler(game);
    }


}
