package org.academiadecodigo.bootcamp.dungeons.game;
import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyFactory;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.Player;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ItemTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;
import org.academiadecodigo.bootcamp.dungeons.game.sounds.GameSounds;

public class Game {

    private static final int MANA_POTION_DROP_CHANCE = 20;
    private static final int HEALTH_POTION_DROP_CHANCE = 20;
    private static final int WEAPON_DROP_CHANCE = 10;

    private Player player;
    private Enemy enemy;
    private int currentLevel;
    private int skillIndex1;
    private int skillIndex2;
    private int weaponIndex;
    Images images;

    boolean characterChosen;
    boolean gameStarted;
    boolean outOfCombat;
    boolean choosingSkill;
    boolean choosingWeapon;

    private boolean gotLoot;
    private boolean gotWeapon;

    private boolean bossAppeared;


    public Game(Images images){

        GameSounds.gameMusic.play(true);        // TODO: 15/06/2019 change to loop
        this.images = images;

        images.initialImage();
    }


    void init(){

        gameStarted = true;
        images.deleteInitialImage();
        outOfCombat = true;
        currentLevel = 1;
        images.backgound();
        images.choosePlayer();

        System.out.println("1 for Warrior");
        System.out.println("2 for Ninja");
        System.out.println("3 for Wizard");
        System.out.println("SPACEBAR to start");
    }


    void createPlayer(PlayerClasses playerClass){

        GameSounds.gameStart.play(true);

        player = new Player(playerClass);
        characterChosen = true;

        images.healthMana();
         images.healthManaText(player.getHealthPoints(),player.getMaxHealthPoints(),
                player.getManaPoints(), player.getMaxManaPoints());

    }




    private void enemyTurn(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GameSounds.enemyAttack.play(true);
        choosingWeapon = false;
        System.out.println("Enemy attacking");

        player.calculateDamageTaken(enemy.attack());

        if (player.getHealthPoints() <= 0){
            gameOver();
            return;
        }

        images.healthManaText(player.getHealthPoints(),player.getMaxHealthPoints(),
                player.getManaPoints(), player.getMaxManaPoints());
        System.out.println("Press A to attack, M for Mana Potion, H for Health Potion, F to flee");
    }


    void playerAttack(){

        GameSounds.playerWeaponAttack.play(true);

        enemy.calculateDamageTaken(player.attack());
        images.enemyHealtText(enemy.getHealthPoints());

        if (enemy.getHealthPoints() <= 0){

            generateLoot(enemy.getExperience());

            System.out.println("Press N for new enemy or R to rest");

            return;
        }

        enemyTurn();
    }


    void playerChooseSkill(int choice){

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
    }


    private void getTwoRandomSkills(){

        skillIndex1 = Randomizer.randomizeBetween(0, player.getPlayerPossibleSpellsList().size() -1);
        skillIndex2 = skillIndex1;

        while (skillIndex1 == skillIndex2){
            skillIndex2 = Randomizer.randomizeBetween(0, player.getPlayerPossibleSpellsList().size() -1);
        }

        images.chooseSkillMenu();
        System.out.println("You found two scrolls with ancient techniques but can only take one");
        System.out.println("Press K to take " + player.getPlayerPossibleSpellsList().get(skillIndex1).toString());
        System.out.println("Press L to take " + player.getPlayerPossibleSpellsList().get(skillIndex2).toString());
    }



    void playerRest(){
        outOfCombat = false;
        GameSounds.restSound.play(true);
        images.deleteAfterBattleMenu();
        images.deleteBattleMenu();

        if (gotLoot){
            images.deleteGeneratedLoot();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!player.rest()){

            GameSounds.ambushSound.play(true);
            System.out.println("You are ambushed while resting");
            enemy = EnemyFactory.createEliteEnemy();
            GameSounds.enemyAppears.play(true);     // TODO: 15/06/2019 change to unique sound
            images.enemy(enemy.getEnemyTypes());

            images.battleMenu();

            images.enemyHealth();

            enemyTurn();
            return;
        }

        System.out.println("You rest successfully");
        createEnemy();
        images.healthManaText(player.getHealthPoints(),player.getMaxHealthPoints(),
                player.getManaPoints(), player.getMaxManaPoints());
    }


    void playerUseHealthPotion(){

        if (player.useHealthPotion()){
            System.out.println("Used Health Potion");

            GameSounds.drinkPotion.play(true);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            images.healthManaText(player.getHealthPoints(),player.getMaxHealthPoints(),
                    player.getManaPoints(), player.getMaxManaPoints());
            enemyTurn();
        }

        GameSounds.wrongMenuChoice.play(true);
    }


    void playerUseManaPotion(){

        if (player.useManaPotion()){
            System.out.println("Used Mana Potion");

            GameSounds.drinkPotion.play(true);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            images.healthManaText(player.getHealthPoints(),player.getMaxHealthPoints(),
                    player.getManaPoints(), player.getMaxManaPoints());
            enemyTurn();
        }

        GameSounds.wrongMenuChoice.play(true);
    }

    void playerFlee(){

        System.out.println("You attempt to flee");
        if (player.flee()){
            outOfCombat = true;

            images.deleteEnemy();
            images.deleteBattleMenu();
            images.afterBattleMenu();
            System.out.println("Rest or keep going?");
            return;
        }

        enemyTurn();
    }


    void playerUseSkill(int skillNumber) {

        ReturningAttackValues damage = player.castSpell(skillNumber);

        if (damage != null){

            GameSounds.playerSkillAttack.play(true);

            enemy.calculateDamageTaken(damage);
            images.enemyHealtText(enemy.getHealthPoints());

            if (enemy.getHealthPoints() <= 0){

                generateLoot(enemy.getExperience());

                System.out.println("Press N for new enemy or R to rest");

                return;
            }

            enemyTurn();
            return;

        }

        GameSounds.wrongMenuChoice.play(true);
    }



    void start() {


        images.afterBattleMenu();

        createEnemy();
        images.player(player.getPlayerClass());
    }


    void createEnemy(){

        if (gotLoot){
            images.deleteGeneratedLoot();
        }

        if (gotWeapon){
            images.deleteChangeWeaponMenu();
        }

        enemy = EnemyFactory.createEnemy();

        if (player.getPlayerLevel() >= 5){
            bossAppeared = true;
            enemy = EnemyFactory.createBoss();
        }

        GameSounds.enemyAppears.play(true);

        images.deleteAfterBattleMenu();
        images.battleMenu();

        images.enemy(enemy.getEnemyTypes());
        outOfCombat = false;

        images.enemyHealth();
        images.enemyHealtText(enemy.getHealthPoints());
    }


    private void generateLoot(int experience){

        images.deleteEnemyHealth();
        images.deleteEnemyHealthText();

        gotLoot = false;
        gotWeapon = false;

        images.deleteBattleMenu();
        images.deleteEnemy();
        images.afterBattleMenu();

        GameSounds.victorySound.play(true);

        outOfCombat = true;


        if (bossAppeared){

            win();
            return;
        }

        player.gainExperience(experience);

        System.out.println("Enemy dead\nGained " + enemy.getExperience() + " experience");

        if (Randomizer.getPercentage() <= MANA_POTION_DROP_CHANCE){
            System.out.println("You got a Mana Potion");
            player.addManaPotion();
            gotLoot = true;
            images.lootGenerated(ItemTypes.MANAPOTION);
        }

        if (Randomizer.getPercentage() <= HEALTH_POTION_DROP_CHANCE && !gotLoot){
            System.out.println("You got a Health Potion");
            player.addHealthPotion();
            gotLoot = true;
            images.lootGenerated(ItemTypes.HEALTHPOTION);
        }

        if (Randomizer.getPercentage() <= WEAPON_DROP_CHANCE && !gotLoot){
            generateWeapon();
            images.lootGenerated(WeaponTypes.values()[weaponIndex]);
            images.changeWeaponMenu();
            gotLoot = true;
            gotWeapon = true;
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (currentLevel < player.getPlayerLevel() && player.getPlayerLevel() <= 4){

            choosingSkill = true;
            currentLevel++;
            getTwoRandomSkills();
        }
    }


    private void gameOver(){
        System.out.println("You died on level " + player.getPlayerLevel());

        GameSounds.enemyWins.play(true);

        images.deletePlayer();
        images.deleteBattleMenu();
        images.deleteEnemy();

        images.gameOver();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }


    private void generateWeapon(){

        choosingWeapon = true;
        weaponIndex = Randomizer.randomizeBetween(0, WeaponTypes.values().length -1);

        System.out.println("The enemy dropped a " + WeaponTypes.values()[weaponIndex].toString());
        System.out.println("Press Y to switch from " + player.getWeapon().toString());
    }

    void playerSwitchWeapon(){

        player.setWeapon(weaponIndex);
        choosingWeapon = false;
    }


    private void win(){

        images.deletePlayer();
        images.credits();
        gameStarted = false;
        characterChosen = false;
        outOfCombat = true;

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       // images.initialImage();
    }
}
