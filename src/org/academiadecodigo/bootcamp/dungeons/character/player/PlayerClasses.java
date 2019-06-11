package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.player.items.WeaponTypes;

public enum PlayerClasses {
    WIZARD ("Izadarian",250,5,20,1,10,
            5,10, 50, WeaponTypes.STAFF, PlayerSkills.UNHOLYHEAL),
    WARRIOR("Edoqor",300,15,5,10,1,
            5,5, 20, WeaponTypes.IRONAXE, PlayerSkills.SPINNINGRAGE),
    NINJA("Ogorim",250,10,15,5,5,
            15,15, 30, WeaponTypes.SHURIKEN, PlayerSkills.SPEARSTEB);

    private String name;
    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;
    private int manaPoints;
    private WeaponTypes weapon;
    private PlayerSkills playerSkills;

    PlayerClasses(String name, int healthPoints, int strength, int intelligence, int physicalResistance, int magicalResistance,
                  int evasionChance, int criticalChance, int manaPoints, WeaponTypes weapon, PlayerSkills playerSkills) {
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
        this.playerSkills=playerSkills;
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

    public WeaponTypes getWeapon() {
        return weapon;
    }
}
