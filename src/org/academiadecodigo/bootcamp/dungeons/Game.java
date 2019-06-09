package org.academiadecodigo.bootcamp.dungeons;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PLAYER_SKILLS;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;

import java.util.LinkedList;

public class Game {

    private Player player;
    private LinkedList<PLAYER_SKILLS> playerPossibleSpellsList;


    public Game(){

        init();
    }


    public void init(){

        player = new Player ();

        createPlayerPossibleSkillsList();        //store all possible player skills in a list
    }


    public void start(){

        while (player.getHealthPoints >= 0){

            if ( battle(EnemyFactory.createEnemy())) { //battle returns true if player defeats the enemy
                                                       //or false if he flees
                generateLoot();                         //he only gets a chance for loot if he doesn't flee
            }

            if ("player chooses to rest"){

                if (!player.rest()){ //if rest is not successful generate elite battle
                    battle(EnemyFactory.createEliteEnemy()); //monster with random skills and higher stats
                }
            }
        }
    }


    private boolean battle(Enemy enemy){

        while (player.getHealthPoints > 0 || enemy.getHealthPoints > 0){

            player.takeAction();

            if (enemy.getHealthPoints() > 0) {
                enemy.attack();
            }
        }

        if (player.getHealthPoints <= 0){
            gameOver();
        }

        return true;
    }


    private void createPlayerPossibleSkillsList(){

        for (PLAYER_SKILLS skill : PLAYER_SKILLS.values()) {
            playerPossibleSpellsList.add(skill);
        }
    }


    private void generateLoot(){ }

    private void gameOver(){}
}
