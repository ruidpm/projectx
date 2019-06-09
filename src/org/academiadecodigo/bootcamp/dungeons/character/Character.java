package org.academiadecodigo.bootcamp.dungeons.character;

public abstract class Character {

    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;
    private boolean dead; // If usefull for the game

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

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getEvasionChance() {
        return evasionChance;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public boolean isDead() {
        return dead;
    }

    public void calculateDamage(int damage, DAMAGE_TYPES damageType){

        switch (damageType) {
            case MAGICAL:
                damage -= magicalResistance;
                intelligence -= damage;
            break;
                // Magical types impact intelligence; Physical impact strength;
                // Magical resistance decrements damage made with Magical type;
                // Physical resistance decrements damage made with Physical type;
                // No logic in the choice of values yet;
            case PHYSICAL:
                damage -= physicalResistance;
                strength -= damage;
            break;
        }
        healthPoints = intelligence + strength*2; // physical strength values 2/3 total health points;
        if (healthPoints <= 0) {
            dead = true;
        }
    }

    public void attack(){

    }



//todo next step.
}
