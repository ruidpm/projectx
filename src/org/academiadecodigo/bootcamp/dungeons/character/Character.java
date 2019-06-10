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


    public Character(int healthPoints, int strength, int intelligence, int physicalResistance, int magicalResistance, int evasionChance, int criticalChance){

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


    // Magical types impact intelligence; Physical impact strength;
    // Magical resistance decrements damage made with Magical type;
    // Physical resistance decrements damage made with Physical type;
    // No logic in the choice of values yet;
    public void calculateDamage(int damage, DAMAGE_TYPES damageType){

        switch (damageType) {

            case MAGICAL:
                damage -= magicalResistance;
                intelligence -= damage;
            break;

            case PHYSICAL:
                damage -= physicalResistance;
                strength -= damage;
            break;

            // Include default?
        }

        healthPoints = intelligence + strength*2; // physical strength values 2/3 total health points;
                                                  // raw version of a multiplier;;
        if (healthPoints <= 0) {
            dead = true;
        }

    }


    // Returns an object with damage and damageType
    // Values and variable names to test
    public ReturningAttackValues attack(){

        int charDamage = 10;
        DAMAGE_TYPES charDamageType = DAMAGE_TYPES.MAGICAL;

        return new ReturningAttackValues (charDamage, charDamageType);

    }
}
