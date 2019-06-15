package org.academiadecodigo.bootcamp.dungeons.game;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.game.sounds.Sound;

public class Game {

    private Player player;
    private Enemy enemy;

    boolean characterChosen;
    boolean gameStarted;
    boolean outOfCombat;


    public Game(){

        init();
    }


    private void init(){



        outOfCombat = true;

        System.out.println("1 for Warrior");
        System.out.println("2 for Ninja");
        System.out.println("3 for Wizard");
        System.out.println("SPACEBAR to start");
    }


    void createPlayer(PlayerClasses playerClass){

        player = new Player(playerClass);
        characterChosen = true;
    }




    private void enemyTurn(){

        System.out.println("Enemy attacking");

        player.calculateDamageTaken(enemy.attack());

        if (player.getHealthPoints() <= 0){
            gameOver();
        }

        System.out.println("Press A to attack, M for Mana Potion, H for Health Potion, F to flee");
    }


    void playerAttack(){

        enemy.calculateDamageTaken(player.attack());

        if (enemy.getHealthPoints() <= 0){

            generateLoot(enemy.getExperience());
            System.out.println("Enemy dead\nGained " + enemy.getExperience() + " experience");

            System.out.println("Press N for new enemy or R to rest");

            outOfCombat = true;
            return;
        }

        enemyTurn();
    }


    void playerRest(){

        outOfCombat = false;

        if (!player.rest()){

            System.out.println("You are ambushed while resting");
            enemy = EnemyFactory.createEliteEnemy();
            enemyTurn();
            return;
        }

        System.out.println("You rest successfully");
        enemy = EnemyFactory.createEnemy();
    }


    void playerUseHealthPotion(){

        if (player.useHealthPotion()){
            System.out.println("Used Health Potion");
            enemyTurn();
        }
    }


    void playerUseManaPotion(){

        if (player.useManaPotion()){
            System.out.println("Used Mana Potion");
            enemyTurn();
        }
    }

    void playerFlee(){

        System.out.println("You attempt to flee");
        if (player.flee()){
            outOfCombat = true;
            System.out.println("Rest or keep going?");
            return;
        }

        enemyTurn();
    }


    void playerUseSkill(int skillNumber) {

        ReturningAttackValues damage = player.castSpell(skillNumber);

        if (damage != null){

            enemy.calculateDamageTaken(damage);
            enemyTurn();
        }
    }



    void start() {

        outOfCombat = false;

        gameStarted = true;

        enemy = EnemyFactory.createEnemy();
    }


    void createEnemy(){
        enemy = EnemyFactory.createEnemy();
        outOfCombat = false;
    }

    private void generateLoot(int experience){
        player.gainExperience(experience);
    }

    private void gameOver(){
        System.exit(0);
    }

}
