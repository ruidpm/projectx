package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ItemTypes;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;

public class Player extends Character {

    private int manaPoints;
    private int maxManaPoints;
    private int maxHealth;
    private String name;
    private int experience;
    private WeaponTypes weapon;
    private int manaPotion;
    private int healthPotion;
    private int numberOfTimesRested;
    private PlayerSkills[] skills;

    public Player(PlayerClasses player_classes) {
        super(player_classes.getHealthPoints(), player_classes.getStrength(), player_classes.getIntelligence(),
                player_classes.getPhysicalResistance(), player_classes.getMagicalResistance(),
                player_classes.getEvasionChance(), player_classes.getCriticalChance());

        this.name=player_classes.getName();
        this.manaPoints=player_classes.getManaPoints();
        this.weapon=player_classes.getWeapon();
        this.maxHealth = player_classes.getHealthPoints();
        this.manaPotion = 1;
        this.healthPotion = 1;
        this.experience = 0;
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


    public void castSpell(){}


    public void useHealthPotion(){
        if (healthPotion > 0){

            if (maxHealth-getHealthPoints() < ItemTypes.HEALTHPOTION.getValue()){
                heal(maxHealth-getHealthPoints());
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

        return new ReturningAttackValues(damage, DamageTypes.PHYSICAL);
    }


    public boolean rest(){
        int prob = Randomizer.getPercentage();

        if (prob < 90 && numberOfTimesRested < 1){
            numberOfTimesRested++;
            return true;
        }

        if (prob < 80 && numberOfTimesRested < 2){
            numberOfTimesRested++;
            return true;
        }

        if (prob < 70 && numberOfTimesRested < 3){
            numberOfTimesRested++;
            return true;
        }

        if (prob < 55 && numberOfTimesRested < 4){
            numberOfTimesRested++;
            return true;
        }

        if (prob < 30 && numberOfTimesRested >= 4){
            numberOfTimesRested++;
            return true;
        }
        return false;

    }

    public void gainExperience(int experience){
        this.experience += experience;
    }

    public String getName() {
        return name;
    }


    // TODO: 09-06-2019 create an enum for player classes
    // TODO: 09-06-2019 create getHealthPoints or getIsDead 
}
