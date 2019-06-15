package org.academiadecodigo.bootcamp.dungeons.game;
import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;

public class Game {

    private Player player;
    private Enemy enemy;
    private int currentLevel;
    private int skillIndex1;
    private int skillIndex2;

    boolean characterChosen;
    boolean gameStarted;
    boolean outOfCombat;
    boolean choosingSkill;


    public Game(){

        init();
    }


    private void init(){

        outOfCombat = true;
        currentLevel = 1;

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
            outOfCombat = true;
            System.out.println("Enemy dead\nGained " + enemy.getExperience() + " experience");

            if (currentLevel < player.getPlayerLevel() && player.getPlayerLevel() <= 4){

                choosingSkill = true;
                currentLevel++;
                getTwoRandomSkills();
                return;

            }

            System.out.println("Press N for new enemy or R to rest");


            return;
        }

        enemyTurn();
    }


    public void playerChooseSkill(int choice){

        if (choice == 1){
            System.out.println("You choose " + player.getPlayerPossibleSpellsList().get(skillIndex1).toString());
            player.chooseSkill(skillIndex1, skillIndex2);
            choosingSkill = false;
            createEnemy();
            return;
        }

        System.out.println("You choose " + player.getPlayerPossibleSpellsList().get(skillIndex2).toString());
        player.chooseSkill(skillIndex2, skillIndex1);

        choosingSkill = false;
        createEnemy();
    }


    private void getTwoRandomSkills(){

        skillIndex1 = Randomizer.randomizeBetween(0, player.getPlayerPossibleSpellsList().size() -1);
        skillIndex2 = skillIndex1;

        while (skillIndex1 == skillIndex2){
            System.out.println("here");
            skillIndex2 = Randomizer.randomizeBetween(0, player.getPlayerPossibleSpellsList().size() -1);
        }

        System.out.println("You found two scrolls with ancient techniques but can only take one");
        System.out.println("Press K to take " + player.getPlayerPossibleSpellsList().get(skillIndex1).toString());
        System.out.println("Press L to take " + player.getPlayerPossibleSpellsList().get(skillIndex2).toString());
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

            // TODO: 15/06/2019 check if enemy dies

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
        System.out.println("You died on level " + player.getPlayerLevel());
        System.exit(0);
    }

}
