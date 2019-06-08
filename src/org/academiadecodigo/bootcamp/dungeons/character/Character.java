package org.academiadecodigo.bootcamp.dungeons.character;

public abstract class Character {
//#sopraxprimentarseistodogithubfuncionaicomo-tamujuntos;)
    private int healthPoints;
    private int strength;
    private int intelligence;
    private int physicalResistance;
    private int magicalResistance;
    private int evasionChance;
    private int criticalChance;
    private boolean dead;

    public void calculateDamage(int damage, DAMAGE_TYPES damageType){};
    public void attack(){};

    //todo next step.
}
