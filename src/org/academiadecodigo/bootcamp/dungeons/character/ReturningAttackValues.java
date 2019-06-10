package org.academiadecodigo.bootcamp.dungeons.character;


//this class is used to return damage dealt and damage type as an object so
//it can be passed to calculateDamageTaken on enemies and player


public class ReturningAttackValues {

    private int damage;
    private DamageTypes damageType;

    public ReturningAttackValues(int damage, DamageTypes damageType){

        this.damage = damage;
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public DamageTypes getDamageType() {
        return damageType;
    }
}
