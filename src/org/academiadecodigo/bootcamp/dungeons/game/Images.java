package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ItemTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
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
    private Picture press1;
    private Picture press2;
    private Picture press3;
    private Picture selectPlayer;
    private Picture lootGenerated;
    private Picture initialImage;
    private Picture gameOver;
    private Picture credits;
    private Picture group;
    private Picture changeWeaponMenu;
    private Picture chooseSkillMenu;
    private Picture storyMenu;
    private String story;
    private String story1;
    private String story2;
    private String story3;
    private Text textstory;
    private Text textstory1;
    private Text textstory2;
    private Text textstory3;
    private Picture health;
    private Picture mana;
    private Picture enemyHealth;
    private String healthText;
    private String maxHealthText;
    private String manaText;
    private String maxManaText;
    private Text textHealth;
    private Text textMaxHealth;
    private Text textMana;
    private Text textMaxMana;
    private String enemyHealthText;
    private Text textEnemyHealth;


    public void initialImage(){

        Picture background = new Picture(PADDING, PADDING, "pics/Background.png");
        background.draw();
        this.background = background;

        Picture initialImage = new Picture(90,90, "pics/initialImage.png");
        initialImage.draw();
        this.initialImage = initialImage;
    }

    public void deleteInitialImage(){
        initialImage.delete();
        background.delete();
    }


    public void backgound (){
        Picture background = new Picture(PADDING, PADDING, "pics/Background.png");
        background.draw();
        this.background = background;
    }

    public void deleteBackgroud(){
        background.delete();
    }

    public void choosePlayer(){

        Picture choosePlayer1 = new Picture(45,280, "pics/warrior.png");
        choosePlayer1.draw();
        this.player1 = choosePlayer1;

        Picture choosePlayer2 = new Picture(425,280, "pics/wizard.png");
        choosePlayer2.draw();
        this.player2 = choosePlayer2;

        Picture choosePlayer3 = new Picture(235,280, "pics/ninja.png");
        choosePlayer3.draw();
        this.player3 = choosePlayer3;

        Picture press1 = new Picture(80, 180, "pics/press1.png");
        press1.draw();
        this.press1 = press1;

        Picture press2 = new Picture(270,180, "pics/press2.png");
        press2.draw();
        this.press2 = press2;

        Picture press3 = new Picture(460, 180, "pics/press3.png");
        press3.draw();
        this.press3 = press3;

        Picture selectPlayer = new Picture(90,70, "pics/selectPlayer.png");
        selectPlayer.draw();
        this.selectPlayer = selectPlayer;
    }

    public void deleteChoosePlayer(){
        player1.delete();
        player2.delete();
        player3.delete();
        press1.delete();
        press2.delete();
        press3.delete();
        selectPlayer.delete();
    }

    public void player(PlayerClasses playerClasses){

        switch (playerClasses){

            case NINJA:
                Picture ninja = new Picture(70,300 , "pics/ninja.png");
                ninja.draw();
                this.player = ninja;
                return;

            case WIZARD:
                Picture wizard = new Picture(70,300, "pics/wizard.png" );
                wizard.draw();
                this.player = wizard;
                return;

            case WARRIOR:
                Picture warrior = new Picture(70,300, "pics/warrior.png" );
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
                Picture rat = new Picture(380,50 ,"pics/rat.png");
                rat.draw();
                this.enemy = rat;
                return;

            case TROLL:
                Picture troll = new Picture(380,50, "pics/troll.png" );
                troll.draw();
                this.enemy = troll;
                return;

            case GOBLIN:
                Picture goblin = new Picture(380,50, "pics/goblin.png");
                goblin.draw();
                this.enemy = goblin;
                return;

            case ORC:
                Picture orc = new Picture(380,50, "pics/orc.png");
                orc.draw();
                this.enemy = orc;
                return;

            case SKELETON:
                Picture skeleton = new Picture(380,50, "pics/skeleton.png");
                skeleton.draw();
                this.enemy = skeleton;
                return;

            case MINOTAUR:
                Picture minotaur = new Picture(380,50, "pics/minotaur.png" );
                minotaur.draw();
                this.enemy = minotaur;
                return;

            case HUNTER:
                Picture hunter = new Picture(380,50, "pics/hunter.png" );
                hunter.draw();
                this.enemy = hunter;
                return;

            case ELITE_HUNTER:
                Picture eliteHunter = new Picture(380,50, "pics/eliteHunter.png" );
                eliteHunter.draw();
                this.enemy = eliteHunter;
                return;

            case ELITE_MINOTAUR:
                Picture eliteMinotaur = new Picture(380,50, "pics/eliteMinotaur.png" );
                eliteMinotaur.draw();
                this.enemy = eliteMinotaur;
                return;

            case ELITE_SKELETON:
                Picture eliteSkeleton = new Picture(380,50, "pics/eliteSkeleton.png" );
                eliteSkeleton.draw();
                this.enemy = eliteSkeleton;
                return;

            case FAUSTINOMON:
                Picture faustino = new Picture(380, 50, "pics/Faustino.png");
                faustino.draw();
                this.enemy = faustino;
                return;

            case SERINGASMON:
                Picture seringas = new Picture(380,50, "pics/Seringas.png");
                seringas.draw();
                this.enemy = seringas;
                return;

            case MARIANAMON:
                Picture mariana = new Picture(380,50, "pics/Mariana.png");
                mariana.draw();
                this.enemy = mariana;
                return;
        }
    }

    public void deleteEnemy(){
        enemy.delete();
    }

    public void battleMenu(){
        Picture battleMenu = new Picture(260, 300, "pics/battleMenu.png");
        battleMenu.draw();
        this.battleMenu = battleMenu;
    }

    public void deleteBattleMenu(){
        battleMenu.delete();
    }

    public void afterBattleMenu(){
        Picture afterBattleMenu = new Picture(260, 350, "pics/restMenu.png");
        afterBattleMenu.draw();
        this.afterBattleMenu = afterBattleMenu;
    }

    public void deleteAfterBattleMenu(){
        afterBattleMenu.delete();
    }

    public void lootGenerated(ItemTypes itemTypes){
        switch (itemTypes){

            case MANAPOTION:
                Picture lootGenerated = new Picture(380,50, "pics/manaPotion.png" );
                lootGenerated.draw();
                this.lootGenerated = lootGenerated;
                return;

            case HEALTHPOTION:
                Picture lootGenerated2 = new Picture(380,50, "pics/healthPotion.png" );
                lootGenerated2.draw();
                this.lootGenerated = lootGenerated2;
                return;
        }
    }

    public void lootGenerated(WeaponTypes weaponTypes){
        switch (weaponTypes){

            case STAFF:
                Picture lootGenerated3 = new Picture(380,50, "pics/staff.png" );
                lootGenerated3.draw();
                this.lootGenerated = lootGenerated3;
                return;

            case IRONAXE:
                Picture lootGenerated4 = new Picture(380,50, "pics/axe.png" );
                lootGenerated4.draw();
                this.lootGenerated = lootGenerated4;
                return;

            case SHURIKEN:
                Picture lootGenerated5 = new Picture(380,50, "pics/shuriken.png" );
                lootGenerated5.draw();
                this.lootGenerated = lootGenerated5;
                return;

            case SHOE:
                Picture lootGenerated6 = new Picture(380,50, "pics/shoe.png" );
                lootGenerated6.draw();
                this.lootGenerated = lootGenerated6;
                return;

            case CROSSBOW:
                Picture lootGenerated7 = new Picture(380,50, "pics/cannon.png" );
                lootGenerated7.draw();
                this.lootGenerated = lootGenerated7;
                return;

            case FIRESWORD:
                Picture lootGenerated8 = new Picture(380,50, "pics/fireSword.png" );
                lootGenerated8.draw();
                this.lootGenerated = lootGenerated8;
                return;

            case METALSWORD:
                Picture lootGenerated9 = new Picture(380,50, "pics/sword.png" );
                lootGenerated9.draw();
                this.lootGenerated = lootGenerated9;
                return;
        }
    }

    public void deleteGeneratedLoot(){
        lootGenerated.delete();
    }

    public void gameOver(){
        Picture gameOver = new Picture(120,160,"pics/gameOver.png");
        gameOver.draw();
        this.gameOver = gameOver;
    }

    public void deleteGameOver(){
        gameOver.delete();
    }

    public void credits(){
        Picture credits = new Picture(200, 100, "pics/credits.png");
        credits.draw();
        this.credits = credits;

        Picture group = new Picture(140, 180, "pics/grupo.jpg");
        group.draw();
        this.group = group;
    }

    public void deleteCredits(){
        credits.delete();
        group.delete();
    }

    public void changeWeaponMenu(){
        Picture changeWeaponMenu = new Picture(440,360, "pics/changeWeapon.png");
        changeWeaponMenu.draw();
        this.changeWeaponMenu = changeWeaponMenu;
    }

    public void deleteChangeWeaponMenu(){
        changeWeaponMenu.delete();
    }

    public void chooseSkillMenu(){
        Picture chooseSkillMenu = new Picture(260,330, "pics/chooseSkill.png");
        chooseSkillMenu.draw();
        this.chooseSkillMenu = chooseSkillMenu;
    }

    public void deleteChooseSkillMenu(){
        chooseSkillMenu.delete();
    }

    public void storyMenu (){
        Picture storyMenu = new Picture(45,50, "pics/storyMenu6.png");
        storyMenu.draw();
        this.storyMenu = storyMenu;

        Text textStory = new Text(55,60," ");
        textStory.draw();
        this.textstory = textStory;
        Text textStory1 = new Text(55, 80, " ");
        textStory.draw();
        this.textstory1 = textStory1;
        Text textStory2 = new Text(55, 100, " ");
        textStory.draw();
        this.textstory2 = textStory2;
        Text textStory3 = new Text(55, 120, " ");
        textStory.draw();
        this.textstory3 = textStory3;

    }

    public void deleteStoryMenu(){
        storyMenu.delete();

    }

    public  void textStory(String story){
        textstory.delete();
        textstory1.delete();
        textstory2.delete();
        textstory3.delete();
        this.story = story;
        Text textStory = new Text(55,60,story);
        textStory.draw();
        this.textstory = textStory;
    }

    public void textStory(String story, String story1, String story2, String story3) {
        textstory.delete();
        textstory1.delete();
        textstory2.delete();
        textstory3.delete();
        this.story = story;
        this.story1 = story1;
        this.story2 = story2;
        this.story3 = story3;
        Text textStory = new Text(55, 60, story);
        textStory.draw();
        Text textStory1 = new Text(55, 80, story1);
        textStory1.draw();
        Text textStory2 = new Text(55, 100, story2);
        textStory2.draw();
        Text textStory3 = new Text(55, 120, story3);
        textStory3.draw();
        this.textstory = textStory;
        this.textstory1 = textStory1;
        this.textstory2 = textStory2;
        this.textstory3 = textStory3;
    }

    public  void textStory(String story, String story1) {
        textstory.delete();
        textstory1.delete();
        textstory2.delete();
        textstory3.delete();
        this.story = story;
        this.story1 = story1;
        Text textStory = new Text(55, 60, story);
        textStory.draw();
        Text textStory1 = new Text(55, 80, story1);
        textStory1.draw();
        this.textstory = textStory;
        this.textstory1 = textStory1;

    }

    public  void textEnemyStory(String story2, String story3) {

        textstory2.delete();
        textstory3.delete();
        this.story2 = story2;
        this.story3 = story3;
        Text textStory2 = new Text(55, 100, story2);
        textStory2.draw();
        Text textStory3 = new Text(55, 120, story3);
        textStory3.draw();
        this.textstory2 = textStory2;
        this.textstory3 = textStory3;
    }



    public void healthMana(){
        Picture mana = new Picture(85,280,"pics/mana.gif");
        mana.draw();
        this.mana = mana;

        Text textHealth = new Text(110, 262," ");
        textHealth.setColor(Color.WHITE);
        textHealth.draw();
        this.textHealth = textHealth;

        Text textMaxHealth = new Text(145, 262," ");
        textMaxHealth.setColor(Color.WHITE);
        textMaxHealth.draw();
        this.textMaxHealth = textMaxHealth;

        Picture health = new Picture(85, 260, "pics/health.gif");
        health.draw();
        this.health = health;

        Text textMana = new Text(110, 282," ");
        textMana.setColor(Color.WHITE);
        textMana.draw();
        this.textMana = textMana;

        Text textMaxMana = new Text(145, 282," ");
        textMaxMana.setColor(Color.WHITE);
        textMaxMana.draw();
        this.textMaxMana = textMaxMana;
    }

    public void healthManaText(int healthText, int maxHealthText, int manaText, int maxManaText){
        textHealth.delete();
        this.healthText = String.valueOf(healthText);
        Text textHealth = new Text(110, 262,this.healthText + " / ");
        textHealth.setColor(Color.WHITE);
        textHealth.draw();
        this.textHealth = textHealth;

        textMaxHealth.delete();
        this.maxHealthText = String.valueOf(maxHealthText);
        Text textMaxHealth = new Text(145, 262,this.maxHealthText);
        textMaxHealth.setColor(Color.WHITE);
        textMaxHealth.draw();
        this.textMaxHealth = textMaxHealth;

        textMana.delete();
        this.manaText = String.valueOf(manaText);
        Text textMana = new Text(110, 282,this.manaText+ " / ");
        textMana.setColor(Color.WHITE);
        textMana.draw();
        this.textMana = textMana;

        textMaxMana.delete();
        this.maxManaText = String.valueOf(maxManaText);
        Text textMaxMana = new Text(145, 282,this.maxManaText);
        textMaxMana.setColor(Color.WHITE);
        textMaxMana.draw();
        this.textMaxMana = textMaxMana;

    }

    public void deleteHealthMana(){
        mana.delete();
        health.delete();
    }

    public void deleteHealthManaText(){
        textHealth.delete();
        textMaxHealth.delete();
        textMana.delete();
        textMaxMana.delete();
    }

    public void enemyHealth(){
        Picture enemyHealth = new Picture(410, 240, "pics/health.gif");
        enemyHealth.draw();
        this.enemyHealth = enemyHealth;

        Text textEnemyHealth = new Text(435, 242," ");
        textEnemyHealth.setColor(Color.WHITE);
        textEnemyHealth.draw();
        this.textEnemyHealth = textEnemyHealth;
    }
    public void deleteEnemyHealth(){
        enemyHealth.delete();
    }

    public void enemyHealtText(int enemyHealthText){
        textEnemyHealth.delete();
        this.enemyHealthText = String.valueOf(enemyHealthText);
        Text textEnemyHealth = new Text(435, 242,this.enemyHealthText);
        textEnemyHealth.setColor(Color.WHITE);
        textEnemyHealth.draw();
        this.textEnemyHealth = textEnemyHealth;
    }
    public void deleteEnemyHealtText(){
        textEnemyHealth.delete();
    }




    
}
