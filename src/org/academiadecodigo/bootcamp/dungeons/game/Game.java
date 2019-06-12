package org.academiadecodigo.bootcamp.dungeons.game;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.game.GameKeyboardHandler;

public class Game {

    private Player player;
    private Enemy enemy;

    boolean characterChosen;
    boolean gameStarted;
    boolean enemyDead;


    public Game(){

        init();
    }


    private void init(){

        enemyDead = true;
        new GameKeyboardHandler(this);

        System.out.println("1 for Warrior");
        System.out.println("2 for Ninja");
        System.out.println("3 for Wizard");
        System.out.println("SPACEBAR to start");

    }


    void createPlayer(PlayerClasses playerClass){

        player = new Player(playerClass);
        characterChosen = true;

    }




    void enemyTurn(){

        System.out.println("Enemy attacking");

        player.calculateDamageTaken(enemy.attack());

        if (player.getHealthPoints() <= 0){
            gameOver();
        }


        System.out.println("Press A to attack");
    }




    void playerAttack(){

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


    void playerRest(){

        enemyDead = false;

        if (!player.rest()){

            System.out.println("You are ambushed while resting");
            enemy = EnemyFactory.createEliteEnemy();
            enemyTurn();
            return;
        }

        System.out.println("You rest successfully");
        enemy = EnemyFactory.createEnemy();

    }





    void start() {

        enemyDead = false;

        gameStarted = true;

        enemy = EnemyFactory.createEnemy();
    }


    void createEnemy(){
        enemy = EnemyFactory.createEnemy();
        enemyDead = false;
    }



    private void generateLoot(int experience){
        player.gainExperience(experience);
    }

    private void gameOver(){
        System.exit(0);
    }

}
