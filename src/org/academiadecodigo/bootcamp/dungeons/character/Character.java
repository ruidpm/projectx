package org.academiadecodigo.bootcamp.dungeons.character;

public abstract class Character {

    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;
    private boolean dead;
    private ReturningAttackValues returningAttackValues;

    public Character(int healthPoints, int strength, int intelligence, int physicalResistance, int magicalResistance, int evasionChance, int criticalChance, ReturningAttackValues returningAttackValues){
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.intelligence = intelligence;
        this.physicalResistance = physicalResistance;
        this.magicalResistance = magicalResistance;
        this.evasionChance = evasionChance;
        this.criticalChance = criticalChance;
        this.dead = false;
    }

    public void calculateDamage(int damage, DAMAGE_TYPES damageType){



    }

    public void attack(){}



//todo next step.
}
