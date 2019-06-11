package org.academiadecodigo.bootcamp.dungeons.character;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;

public abstract class Character {


    protected int healthPoints;
    protected int strength;
    protected int intelligence;
    protected int physicalResistance;
    protected int magicalResistance;
    protected int evasionChance;
    protected int criticalChance;


    public Character(int healthPoints, int strength, int intelligence, int physicalResistance, int magicalResistance, int evasionChance, int criticalChance){

        this.healthPoints = healthPoints;
        this.strength = strength;
        this.intelligence = intelligence;
        this.physicalResistance = physicalResistance;
        this.magicalResistance = magicalResistance;
        this.evasionChance = evasionChance;
        this.criticalChance = criticalChance;
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


    // Magical types impact intelligence; Physical impact strength;
    // Magical resistance decrements damage made with Magical type;
    // Physical resistance decrements damage made with Physical type;
    // No logic in the choice of values yet;
    public void calculateDamageTaken(ReturningAttackValues damage){

        if (Randomizer.getPercentage() <= evasionChance){
            System.out.println("Attack evaded");
            return;
        }

        switch (damage.getDamageType()) {

            case MAGICAL:
                healthPoints -= damage.getDamage() - magicalResistance;
            break;

            case PHYSICAL:
                healthPoints -= damage.getDamage() - physicalResistance;
            break;

            // Include default?
        }

        System.out.println("Current " + this.getClass().getSimpleName() + " HP: " + healthPoints + "\n");

    }


    // Returns an object with damage and damageType
    // Values and variable names to test
    public ReturningAttackValues attack(){
        return null;
    }


    public int getStrength() {
        return strength;
    }

    public void heal(int healthToAdd){
        healthPoints = healthPoints + healthToAdd;

    }

}
