package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.player.items.WEAPON_TYPES;

public enum PLAYER_CLASSES {
    WIZARD ("Izadarian",100,5,20,1,10,
            5,10, 50, WEAPON_TYPES.STAFF),
    WARRIOR("Edoqor",100,15,5,10,1,
            5,5, 20,WEAPON_TYPES.AXE),
    NINJA("Ogorim",100,10,15,5,5,
            15,15, 30, WEAPON_TYPES.SHURIKEN);

    private String name;
    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;
    private int manaPoints;
    private WEAPON_TYPES weapon;

    PLAYER_CLASSES(String name, int healthPoints, int strength, int intelligence, int physicalResistance, int magicalResistance,
                   int evasionChance, int criticalChance, int manaPoints, WEAPON_TYPES weapon) {
        this.name=name;
        this.healthPoints=healthPoints;
        this.strength=strength;
        this.intelligence=intelligence;
        this.physicalResistance=physicalResistance;
        this.magicalResistance=magicalResistance;
        this.evasionChance=evasionChance;
        this.criticalChance=criticalChance;
        this.manaPoints=manaPoints;
        this.weapon=weapon;
    }

    public String getName() {
        return name;
    }

    public int getEvasionChance() {
        return evasionChance;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getMagicalResistance() {
        return magicalResistance;
    }

    public int getPhysicalResistance() {
        return physicalResistance;
    }

    public int getStrength() {
        return strength;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public WEAPON_TYPES getWeapon() {
        return weapon;
    }
}
