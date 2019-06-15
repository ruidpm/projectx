package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ImagesTest {


    public static void main(String[] args) {

        Images images = new Images();

        images.backgound();
       // images.enemy(EnemyTypes.MINOTAUR);

       // images.battleMenu();
        images.player(PlayerClasses.WARRIOR);

        //images.choosePlayer();

    }
}
