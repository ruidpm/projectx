package org.academiadecodigo.bootcamp.dungeons;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerSkills;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.keyboard.GameKeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.util.LinkedList;

public class Game {

    private Player player;
    private Enemy enemy;

    private boolean characterChosen;
    private boolean gameStarted;
    private boolean enemyDead;


    public Game(){

        init();
    }


    public void init(){

        enemyDead = true;
        new GameKeyboardHandler(this);

        System.out.println("1 for Warrior");
        System.out.println("2 for Ninja");
        System.out.println("3 for Wizard");
        System.out.println("SPACEBAR to start");

    }


    public void createPlayer(PlayerClasses playerClass){

        player = new Player(playerClass);
        characterChosen = true;

    }




    public void enemyTurn(){

        System.out.println("Enemy attacking");

        player.calculateDamageTaken(enemy.attack());

        if (player.getHealthPoints() <= 0){
            gameOver();
        }


        System.out.println("Press A to attack");
    }




    public void playerAttack(){

        enemy.calculateDamageTaken(player.attack());

        if (enemy.getHealthPoints() <= 0){

            generateLoot(enemy.getExperience());
            System.out.println("Enemy dead\nGained " + enemy.getExperience() + " experience");

            System.out.println("Press 0 to new enemy or R to rest");

            enemyDead = true;
            return;

        }

        enemyTurn();

    }


    public void playerRest(){

        enemyDead = false;

        if (!player.rest()){

            System.out.println("You are ambushed while resting");
            enemy = EnemyFactory.createEnemy();
            enemyTurn();
            return;
        }

        System.out.println("You rest successfully");
        enemy = EnemyFactory.createEnemy();

    }





    public void start() {

        enemyDead = false;

        gameStarted = true;

        enemy = EnemyFactory.createEnemy();
    }


    public void createEnemy(){
        enemy = EnemyFactory.createEnemy();
        enemyDead = false;
    }



    private void generateLoot(int experience){
        player.gainExperience(experience);
    }

    private void gameOver(){
        System.exit(0);
    }


    public boolean isCharacterChosen()
    {
        return characterChosen;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }


    public boolean isEnemyDead() {
        return enemyDead;
    }
}
