package org.academiadecodigo.bootcamp.dungeons.character.player;

public enum PLAYER_CLASSES {
    WIZARD (100,5,20,1,10,5,10),
    WARRIOR(100,15,5,10,1,5,5),
    NINJA(100,10,15,5,5,15,15);


    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;

    PLAYER_CLASSES(int healthPoints, int strength, int intelligence, int physicalResistance,int magicalResistance,
                   int evasionChance, int criticalChance) {
        this.healthPoints=healthPoints;
        this.strength=strength;
        this.intelligence=intelligence;
        this.physicalResistance=physicalResistance;
        this.magicalResistance=magicalResistance;
        this.evasionChance=evasionChance;
        this.criticalChance=criticalChance;
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
}
