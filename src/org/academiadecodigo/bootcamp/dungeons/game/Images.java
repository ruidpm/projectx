package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Images {

    private static final int PADDING = 10;
    private Picture background;
    private Picture choosePlayer;


    public void backgound (){
        Picture background = new Picture(PADDING, PADDING);
        background.load("");
        this.background = background;
    }

    public void choosePlayer(){

        background.delete();
        Picture choosePlayer = new Picture(100,100);
        choosePlayer.load("");
        this.choosePlayer = choosePlayer;
    }

    public void player(PlayerClasses playerClasses){

        switch (playerClasses){

            case NINJA:
                Picture ninja = new Picture(135,360 );
                ninja.load("");
                return;

            case WIZARD:
                Picture wizard = new Picture(135,360 );
                wizard.load("");
                return;

            case WARRIOR:
                Picture warrior = new Picture(135,360 );
                warrior.load("");
                return;
        }

    }

    public void enemy(EnemyTypes enemyTypes){

        switch (enemyTypes){

            case RAT:
                Picture rat = new Picture(435,135 );
                rat.load("");
                return;

            case TROLL:
                Picture troll = new Picture(435,135 );
                troll.load("");
                return;

            case GOBLIN:
                Picture goblin = new Picture(435,135 );
                goblin.load("");
                return;

            case ORC:
                Picture orc = new Picture(435,135 );
                orc.load("");
                return;

            case SKELETON:
                Picture skeleton = new Picture(435,135 );
                skeleton.load("");
                return;

            case MINOTAUR:
                Picture minotaur = new Picture(435,135 );
                minotaur.load("");
                return;

            case HUNTER:
                Picture hunter = new Picture(435,135 );
                hunter.load("");
                return;

            case ELITE_HUNTER:
                Picture eliteHunter = new Picture(435,135 );
                eliteHunter.load("");
                return;

            case ELITE_MINOTAUR:
                Picture eliteMinotaur = new Picture(435,135 );
                eliteMinotaur.load("");
                return;

            case ELITE_SKELETON:
                Picture eliteSkeleton = new Picture(435,135 );
                eliteSkeleton.load("");
                return;

        }

    }

    public void battleMenu(){
        Picture battleMenu = new Picture(PADDING, PADDING);
        battleMenu.load("");
    }

    public void afterBattle(){
        Picture afterBattle = new Picture(PADDING, PADDING);
        afterBattle.load("");
    }



}
