package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

import java.util.concurrent.ThreadLocalRandom;

public class Skeleton extends Enemy {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Skeleton() {
        super(EnemyTypes.SKELETON);
    }

    public ReturningAttackValues boneThrow(){
        ReturningAttackValues attackDamage;

        double random = ThreadLocalRandom.current().nextDouble(1.2, 1.7);

        attackDamage = new ReturningAttackValues((int )(super.getStrength() * random), DamageTypes.MAGICAL);

        System.out.println(ANSI_BLUE + getEnemyName() + " Skeleton throw a bone on you. " + attackDamage.getDamage() + " Magical Damage."  + ANSI_RESET);

        return attackDamage;
    }

    @Override
    public ReturningAttackValues attack() {

        if (Randomizer.getPercentage() < 30){
            return boneThrow();
        }

        return super.attack();
    }
}
