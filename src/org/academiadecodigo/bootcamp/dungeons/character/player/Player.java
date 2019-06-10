package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.ITEM_TYPES;
import org.academiadecodigo.bootcamp.dungeons.character.player.items.WEAPON_TYPES;

public class Player extends Character {

    private int manaPoints;
    private PLAYER_CLASSES playerClass;
    private String name;
    private int experience;
    private WEAPON_TYPES weapon;
    private ITEM_TYPES[] backPack;
    private int numberOfTimesRested;
    private PLAYER_SKILLS[] skills;

    public Player(PLAYER_CLASSES player_classes) {
        super(player_classes.getHealthPoints(), player_classes.getStrength(), player_classes.getIntelligence(),
                player_classes.getPhysicalResistance(), player_classes.getMagicalResistance(),
                player_classes.getEvasionChance(), player_classes.getCriticalChance());

        this.name=player_classes.getName();
        this.manaPoints=player_classes.getManaPoints();
        this.playerClass=player_classes;
        this.backPack=new ITEM_TYPES[5]; // fazer o mesmo que em baixo????
        this.skills= new PLAYER_SKILLS[]{PLAYER_SKILLS.values()[Randomizer.randomizeBetween(0,PLAYER_SKILLS.values().length-1)],
                PLAYER_SKILLS.values()[Randomizer.randomizeBetween(0,PLAYER_SKILLS.values().length-1)],
                PLAYER_SKILLS.values()[Randomizer.randomizeBetween(0,PLAYER_SKILLS.values().length-1)]};
        //tentativa de ao ser criado o player, ele ter um array random de skills...mas podem ser repetidos??????
        this.weapon=player_classes.getWeapon();
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
