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
    private GameKeyboardHandler gameKeyboardHandler;

    private boolean characterChosen;
    private boolean gameStarted;
    private boolean waitingBattleInput;


    public Game(){

        init();
    }


    public void init(){

        gameKeyboardHandler = new GameKeyboardHandler(this);

               //store all possible player skills in a list
    }


    public void createPlayer(PlayerClasses playerClass){

        player = new Player(playerClass);
        characterChosen = true;
    }

    public void start(){

        gameStarted = true;

        while (player.getHealthPoints() >= 0){

            System.out.println("Creating new enemy");
            System.out.println("Current experience: " + player.getExperience());

            battle(EnemyFactory.createEnemy()); //battle returns true if player defeats the enemy
                                                       //or false if he flees
                                       //he only gets a chance for loot if he doesn't flee


           // if ("player chooses to rest"){

             //   if (!player.rest()){ //if rest is not successful generate elite battle
              //      battle(EnemyFactory.createEliteEnemy()); //monster with random skills and higher stats
               // }
            //}
        }
    }


    private void battle(Enemy enemy){

        ReturningAttackValues damage;

        while (player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0){

            waitingBattleInput = true;
           /* while (waitingBattleInput){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

            System.out.println("Player " + player.getName() + " attacking");
            damage = player.attack();
            enemy.calculateDamageTaken(damage);


            if (enemy.getHealthPoints() > 0) { //enemy attack method returns a ReturningAttackValues object

                System.out.println("Enemy attacking");
                damage = enemy.attack();        //which contains damage dealt and damage type

                player.calculateDamageTaken(damage);
                            //after that we pass those values to player calculateDamageTaken()
            }

        }

        if (player.getHealthPoints() <= 0){
            System.out.println("You are dead");
            gameOver();
        }
// TODO: 10/06/2019 only generateLoot if player doesnt flee

        generateLoot(enemy.getExperience());
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

    public boolean isWaitingBattleInput() {
        return waitingBattleInput;
    }

    public void waitingBattleInputOff(){
        waitingBattleInput = false;
    }
}
