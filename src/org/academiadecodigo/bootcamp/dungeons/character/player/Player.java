package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ItemTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;
import org.academiadecodigo.bootcamp.dungeons.game.Game;
import org.academiadecodigo.bootcamp.dungeons.game.Images;
import org.academiadecodigo.bootcamp.dungeons.game.sounds.GameSounds;

import java.util.LinkedList;

public class Player extends Character {

    private static final int CHANCE_TO_FLEE = 40;

    private int manaPoints;
    private int maxManaPoints;
    private int maxHealthPoints;
    private String name;
    private int experience;
    private WeaponTypes weapon;
    private int manaPotion;
    private int healthPotion;
    private int numberOfTimesRested;
    private PlayerSkills[] skills ;
    private LinkedList<PlayerSkills> playerPossibleSpellsList;
    private int playerLevel;
    private PlayerClasses playerClass;

    public Player(PlayerClasses player_classes) {
        super(player_classes.getHealthPoints(), player_classes.getStrength(), player_classes.getIntelligence(),
                player_classes.getPhysicalResistance(), player_classes.getMagicalResistance(),
                player_classes.getEvasionChance(), player_classes.getCriticalChance());

        this.name=player_classes.getName();
        this.manaPoints=player_classes.getManaPoints();
        this.weapon=player_classes.getWeapon();
        this.maxHealthPoints = player_classes.getHealthPoints();
        this.maxManaPoints = player_classes.getManaPoints();
        this.manaPotion = 1;
        this.healthPotion = 1;
        this.experience = 0;
        this.skills=new PlayerSkills[4];
        this.playerLevel = 1;
        this.playerClass = player_classes;

        this.skills[0]=player_classes.getPlayerSkills();

        playerPossibleSpellsList = new LinkedList<PlayerSkills>();

        createPlayerPossibleSkillsList();

    }


    public PlayerClasses getPlayerClass() {
        return playerClass;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }


    public void addManaPotion(){
        manaPotion++;
    }

    public void addHealthPotion(){
        healthPotion++;
    }

    public LinkedList<PlayerSkills> getPlayerPossibleSpellsList(){
        return playerPossibleSpellsList;
    }

    public boolean flee(){
        int prob = Randomizer.getPercentage();

        if (prob < CHANCE_TO_FLEE){
            return true;
        }
        return false;
    }


    public void chooseSkill(int skillIndex, int discardIndex){

        PlayerSkills skillToRemove = playerPossibleSpellsList.get(discardIndex);

        skills[playerLevel - 1] = playerPossibleSpellsList.get(skillIndex);
        playerPossibleSpellsList.remove(skillIndex);
        playerPossibleSpellsList.remove(skillToRemove);
    }

    private void createPlayerPossibleSkillsList(){

        for (PlayerSkills skill : PlayerSkills.values()) {
            playerPossibleSpellsList.add(skill);
        }
    }


    public ReturningAttackValues castSpell(int skillIndex, Images images){

        if (skills[skillIndex] == null){
            images.textStory("No skill in that index");
            return null;
        }
        if (skills[skillIndex].manaNeeded > manaPoints){
            images.textStory("Insufficient Mana");
            return null;
        }

        ReturningAttackValues returningAttackValues =
                new ReturningAttackValues(skills[skillIndex].skillDamage, skills[skillIndex].damageTypes);

        manaPoints = manaPoints - skills[skillIndex].manaNeeded;

        images.textStory("You use " + skills[skillIndex].getName(), "for " +
                returningAttackValues.getDamage() + " damage");
        return returningAttackValues;
    }


    public boolean useHealthPotion(){
        if (healthPotion > 0){

            if (maxHealthPoints -getHealthPoints() < ItemTypes.HEALTHPOTION.getValue()){
                heal(maxHealthPoints -getHealthPoints());
                healthPotion--;
                return true;
            }

            heal(ItemTypes.HEALTHPOTION.getValue());
            healthPotion--;
            return true;
        }
        return false;
    }


    public boolean useManaPotion(){
        if (manaPotion > 0){

            if (maxManaPoints < ItemTypes.MANAPOTION.getValue()){
                manaPoints = maxManaPoints - ItemTypes.MANAPOTION.getValue();
                manaPotion--;
                return true;
            }

            manaPoints = ItemTypes.MANAPOTION.getValue();
            manaPotion--;
            return true;
        }

        return false;
    }


    @Override
    public ReturningAttackValues attack(){

        if (Randomizer.getPercentage() <= getCriticalChance()){
            int damage = (int) (getStrength() * 1.5 + weapon.getDamage());
            System.out.println("CRITICAL ATTACK");


            return new ReturningAttackValues(damage, DamageTypes.PHYSICAL);
        }

        int damage = getStrength() + weapon.getDamage();

        System.out.println(damage + " damage");

        return new ReturningAttackValues(damage, DamageTypes.PHYSICAL);
    }


    public boolean rest(){
        int prob = Randomizer.getPercentage();
        int healPointsGained = maxHealthPoints - healthPoints;
        int manaPointsGained = maxManaPoints - manaPoints;

        if( (maxHealthPoints/2) > (maxHealthPoints - healthPoints)){
            healPointsGained = (maxHealthPoints - healthPoints);

        }

        if( (maxManaPoints/2) > (maxManaPoints - manaPoints)){
            manaPointsGained = (maxManaPoints - manaPoints);

        }

        if (prob < 90 && numberOfTimesRested < 1){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            manaPoints = manaPoints + manaPointsGained;
            return true;
        }

        if (prob < 80 && numberOfTimesRested < 2){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            manaPoints = manaPoints + manaPointsGained;
            return true;
        }

        if (prob < 70 && numberOfTimesRested < 3){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            manaPoints = manaPoints + manaPointsGained;
            return true;
        }

        if (prob < 55 && numberOfTimesRested < 4){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            manaPoints = manaPoints + manaPointsGained;
            return true;
        }

        if (prob < 30 && numberOfTimesRested >= 4){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            manaPoints = manaPoints + manaPointsGained;
            return true;
        }

        healthPoints = healthPoints + healPointsGained;
        manaPoints = manaPoints + manaPointsGained;
        return false;

    }

    public void gainExperience(int experience){
        this.experience += experience;

        if (this.experience >= 100 * playerLevel){
            this.experience = this.experience - 100 * playerLevel;
            levelUp();

            System.out.println("LevelUp! You are now on Level " + playerLevel);
        }
    }

    private void levelUp(){
        GameSounds.levelUp.play(true);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        strength = (int) (strength * 1.3);
        intelligence = (int) (intelligence * 1.3);
        physicalResistance = (int) (physicalResistance * 1.3);
        magicalResistance = (int) (magicalResistance * 1.3);
        evasionChance = (int) (evasionChance * 1.3);
        criticalChance = (int) (criticalChance * 1.3);
        maxManaPoints = (int) (maxManaPoints * 1.3);
        maxHealthPoints = (int) (maxHealthPoints * 1.3);
        playerLevel++;
    }

    public WeaponTypes getWeapon() {
        return weapon;
    }

    public void setWeapon(int index) {
        this.weapon = WeaponTypes.values()[index];
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getName() {
        return name;
    }
}
