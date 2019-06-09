package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ITEM_TYPES;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WEAPON_TYPES;

public class Player extends Character {

    private int manaPoints;
    private String playerClass;
    private String name;
    private int experience;
    private WEAPON_TYPES weapon;
    private ITEM_TYPES[] backPack;
    private int numberOfTimesRested;

    public Player(PLAYER_CLASSES player_classes) {
        super(player_classes.getHealthPoints(), player_classes.getStrength(), player_classes.getIntelligence(),
                player_classes.getPhysicalResistance(), player_classes.getMagicalResistance(),
                player_classes.getEvasionChance(), player_classes.getCriticalChance());
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


    public void useHealthPotion(){ }


    public void useManaPotion(){
        manaPoints = manaPoints + ITEM_TYPES.MANAPOTION.getValue();
    }


    @Override
    public ReturningAttackValues attack(){

        return new ReturningAttackValues();
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
    // TODO: 09-06-2019 create an enum for player classes 
    // TODO: 09-06-2019 create getHealthPoints or getIsDead 
}
