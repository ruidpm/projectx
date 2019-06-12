package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ItemTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;

import java.util.LinkedList;

public class Player extends Character {

    private int manaPoints;
    private int maxManaPoints;
    private int maxHealthPoints;
    private String name;
    private int experience;
    private WeaponTypes weapon;
    private int manaPotion;
    private int healthPotion;
    private int numberOfTimesRested;
    private PlayerSkills[] skills;
    private LinkedList<PlayerSkills> playerPossibleSpellsList;

    public Player(PlayerClasses player_classes) {
        super(player_classes.getHealthPoints(), player_classes.getStrength(), player_classes.getIntelligence(),
                player_classes.getPhysicalResistance(), player_classes.getMagicalResistance(),
                player_classes.getEvasionChance(), player_classes.getCriticalChance());

        this.name=player_classes.getName();
        this.manaPoints=player_classes.getManaPoints();
        this.weapon=player_classes.getWeapon();
        this.maxHealthPoints = player_classes.getHealthPoints();
        this.manaPotion = 1;
        this.healthPotion = 1;
        this.experience = 0;

        playerPossibleSpellsList = new LinkedList<PlayerSkills>();

        createPlayerPossibleSkillsList();
    }

    public int getExperience() {
        return experience;
    }


    public boolean flee(){
        int prob = Randomizer.getPercentage();

        if (prob < 15){
            return true;
        }
        return false;
    }

    private void createPlayerPossibleSkillsList(){

        for (PlayerSkills skill : PlayerSkills.values()) {
            playerPossibleSpellsList.add(skill);
        }
    }

    public void castSpell(){}


    public void useHealthPotion(){
        if (healthPotion > 0){

            if (maxHealthPoints -getHealthPoints() < ItemTypes.HEALTHPOTION.getValue()){
                heal(maxHealthPoints -getHealthPoints());
                healthPotion--;
                return;
            }

            heal(ItemTypes.HEALTHPOTION.getValue());
            healthPotion--;
        }

    }


    public void useManaPotion(){
        if (manaPotion > 0){
            if (maxManaPoints < ItemTypes.MANAPOTION.getValue()){
                manaPoints = maxManaPoints - ItemTypes.MANAPOTION.getValue();
                manaPotion--;
                return;
            }

            manaPoints = ItemTypes.MANAPOTION.getValue();
            manaPotion--;

        }

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
        int healPointsGained;

        if( maxHealthPoints/2 < maxHealthPoints - healthPoints){
            healPointsGained = (int)(maxHealthPoints/2);

        } else {
            healPointsGained = maxHealthPoints-healthPoints;
        }


        if (prob < 90 && numberOfTimesRested < 1){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            return true;
        }

        if (prob < 80 && numberOfTimesRested < 2){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            return true;
        }

        if (prob < 70 && numberOfTimesRested < 3){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            return true;
        }

        if (prob < 55 && numberOfTimesRested < 4){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            return true;
        }

        if (prob < 30 && numberOfTimesRested >= 4){
            numberOfTimesRested++;
            healthPoints = healthPoints + healPointsGained;
            return true;
        }
        return false;

    }

    public void gainExperience(int experience){
        this.experience += experience;

        if (this.experience >= 100){
            this.experience = this.experience -100;
            levelUp();

            System.out.println("LevelUp");
        }
    }

    public String getName() {
        return name;
    }


    private void levelUp(){
        strength = (int) (strength * 1.5);
        intelligence = (int) (intelligence * 1.5);
        physicalResistance = (int) (physicalResistance * 1.5);
        magicalResistance = (int) (magicalResistance * 1.5);
        evasionChance = (int) (evasionChance * 1.5);
        criticalChance = (int) (criticalChance * 1.5);
        maxManaPoints = (int) (maxManaPoints * 1.5);
        maxHealthPoints = (int) (maxHealthPoints * 1.5);
    }


    // TODO: 09-06-2019 create an enum for player classes
    // TODO: 09-06-2019 create getHealthPoints or getIsDead 
}
