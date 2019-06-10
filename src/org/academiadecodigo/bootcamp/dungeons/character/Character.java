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
    public void calculateDamageTaken(ReturningAttackValues damage){

        switch (damage.getDamageType()) {

            case MAGICAL:
                healthPoints -= damage.getDamage() - magicalResistance;
            break;

            case PHYSICAL:
                healthPoints -= damage.getDamage() - physicalResistance;
            break;

            // Include default?
        }

                                                  // raw version of a multiplier;;
        if (healthPoints <= 0) {
            dead = true;
        }
        System.out.println("Current " + this.getClass().getName() + " HP: " + healthPoints + "\n");

    }


    // Returns an object with damage and damageType
    // Values and variable names to test
    public ReturningAttackValues attack(){

        int charDamage = 10;
        DamageTypes charDamageType = DamageTypes.MAGICAL;

        System.out.println("Attack damage: " + charDamage + "\nAttack type: " + charDamageType + "\n");

        return new ReturningAttackValues (charDamage, charDamageType);

    }


    public int getStrength() {
        return strength;
    }

    public void heal(int healthToAdd){
        healthPoints = healthPoints + healthToAdd;

    }
}
