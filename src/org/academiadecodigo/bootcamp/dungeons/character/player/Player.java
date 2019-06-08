package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.Character;
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


    public boolean flee(){
        return false;
    }


    public void castSpell(){}

    public void useHealthPotion(){}

    public void useManaPotion(){}

    @Override
    public void attack(){}

    public boolean rest(){
        return false;
    }

}
