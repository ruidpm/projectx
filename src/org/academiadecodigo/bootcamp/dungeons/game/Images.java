package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Images {

    private static final int PADDING = 10;
    private Picture background;
    private Picture player;
    private Picture player1;
    private Picture player2;
    private Picture player3;
    private Picture enemy;
    private Picture battleMenu;
    private Picture afterBattleMenu;


    public void backgound (){
        Picture background = new Picture(PADDING, PADDING, "background");
        background.load("pics/Background.png");
        background.draw();
        this.background = background;
    }

    public void deleteBackgroud(){
        background.delete();
    }

    public void choosePlayer(){

        Picture choosePlayer1 = new Picture(45,280, "player1");
        choosePlayer1.load("pics/warrior.png");
        choosePlayer1.draw();
        this.player1 = choosePlayer1;

        Picture choosePlayer2 = new Picture(235,280, "player2");
        choosePlayer2.load("pics/wizard.png");
        choosePlayer2.draw();
        this.player2 = choosePlayer2;

        Picture choosePlayer3 = new Picture(425,280, "player2");
        choosePlayer3.load("pics/ninja.png");
        choosePlayer3.draw();
        this.player3 = choosePlayer3;
    }

    public void deleteChoosePlayer(){
        player1.delete();
        player2.delete();
        player3.delete();
    }

    public void player(PlayerClasses playerClasses){

        switch (playerClasses){

            case NINJA:
                Picture ninja = new Picture(70,300 , "ninja");
                ninja.load("pics/ninja.png");
                ninja.draw();
                this.player = ninja;
                return;

            case WIZARD:
                Picture wizard = new Picture(135,360, "wizard" );
                wizard.load("pics/wizard.png");
                wizard.draw();
                this.player = wizard;
                return;

            case WARRIOR:
                Picture warrior = new Picture(135,360, "warrior" );
                warrior.load("pics/warrior.png");
                warrior.draw();
                this.player = warrior;
                return;
        }

    }

    public void deletePlayer (){
        player.delete();
    }

    public void enemy(EnemyTypes enemyTypes){

        switch (enemyTypes){

            case RAT:
                Picture rat = new Picture(380,50 ,"Rat");
                rat.load("pics/rat.png");
                rat.draw();
                this.enemy = rat;
                return;

            case TROLL:
                Picture troll = new Picture(380,50, "troll" );
                troll.load("pics/troll.png");
                troll.draw();
                this.enemy = troll;
                return;

            case GOBLIN:
                Picture goblin = new Picture(380,50, "goblin");
                goblin.load("pics/goblin.png");
                goblin.draw();
                this.enemy = goblin;
                return;

            case ORC:
                Picture orc = new Picture(380,50, "orc");
                orc.load("pics/orc.png");
                orc.draw();
                this.enemy = orc;
                return;

            case SKELETON:
                Picture skeleton = new Picture(380,50, "skeleton");
                skeleton.load("pics/skeleton.png");
                skeleton.draw();
                this.enemy = skeleton;
                return;

            case MINOTAUR:
                Picture minotaur = new Picture(380,50, "minotaur" );
                minotaur.load("pics/minotaur.png");
                minotaur.draw();
                this.enemy = minotaur;
                return;

            case HUNTER:
                Picture hunter = new Picture(380,50, "hunter" );
                hunter.load("pics/hunter.png");
                hunter.draw();
                this.enemy = hunter;
                return;

            case ELITE_HUNTER:
                Picture eliteHunter = new Picture(380,50, "elite hunter" );
                eliteHunter.load("pics/eliteHunter.png");
                eliteHunter.draw();
                this.enemy = eliteHunter;
                return;

            case ELITE_MINOTAUR:
                Picture eliteMinotaur = new Picture(380,50, "elite minotaur" );
                eliteMinotaur.load("pics/eliteMinotaur.png");
                eliteMinotaur.draw();
                this.enemy = eliteMinotaur;
                return;

            case ELITE_SKELETON:
                Picture eliteSkeleton = new Picture(380,50, "elite skeleton" );
                eliteSkeleton.load("pics/eliteSkeleton.png");
                eliteSkeleton.draw();
                this.enemy = eliteSkeleton;
                return;
        }
    }

    public void deleteEnemy(){
        enemy.delete();
    }

    public void battleMenu(){
        Picture battleMenu = new Picture(260, 300, "battle menu");
        battleMenu.load("pics/battleMenu.png");
        battleMenu.draw();
        this.battleMenu = battleMenu;
    }

    public void deleteBattleMenu(){
        battleMenu.delete();
    }

    public void afterBattleMenu(){
        Picture afterBattleMenu = new Picture(PADDING, PADDING);
        afterBattleMenu.load("");
        afterBattleMenu.draw();
        this.afterBattleMenu = afterBattleMenu;
    }

    public void deleteAfterBattleMenu(){
        afterBattleMenu.delete();
    }



    
}
