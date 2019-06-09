package org.academiadecodigo.bootcamp.dungeons.character;


//this class is used to return damage dealt and damage type as an object so
//it can be passed to calculateDamage on enemies and player


public class ReturningAttackValues {

    private int damage;
    private DAMAGE_TYPES damageType;

    public ReturningAttackValues(int damage, DAMAGE_TYPES damageType){

        this.damage = damage;
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public DAMAGE_TYPES getDamageType() {
        return damageType;
    }
}
