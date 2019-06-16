package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;

public class ImagesTest {


    public static void main(String[] args) {

        Images images = new Images();

        images.backgound();
        images.enemy(EnemyTypes.MINOTAUR);

      //  images.battleMenu();
        images.player(PlayerClasses.WARRIOR);

        //images.choosePlayer();
        //images.afterBattleMenu();
        //images.battleMenu();
       // images.initialImage();
        //images.gameOver();
       // images.credits();
//images.changeWeaponMenu();
       // images.chooseSkillMenu();
        images.storyMenu();
       // images.textStory("Onde upon a time....");
        images.textStory("eu","estou", "aqui", "agora");
        images.healthMana();
        images.healthManaText(80, 100, 50, 100);
     // images.enemyHealth();
      // images.enemyHealtText("50 / 100");

    }
}
