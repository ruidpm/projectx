package org.academiadecodigo.bootcamp.dungeons.character;

public enum DAMAGE_TYPES {

    PHYSICAL (0,20),
    MAGICAL (20, 0);
    // The arguments were just to try different uses with this Enum, if we prefer.
    // No logic in the choice of the range of values yet;


    private int intDamage;
    private int strDamage;


    DAMAGE_TYPES(int intDamage, int strDamage){
        this.intDamage = intDamage;
        this.strDamage = strDamage;
    }

}
