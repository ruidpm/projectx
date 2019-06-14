package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

import java.util.concurrent.ThreadLocalRandom;

public class Hunter extends Enemy {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Hunter(){
        super(EnemyTypes.HUNTER);
    }



    public ReturningAttackValues sniperArrow(){
        ReturningAttackValues attackDamage;
        double random = ThreadLocalRandom.current().nextDouble(0.8, 1.6);
        attackDamage = new ReturningAttackValues((int )(super.getStrength() * random), DamageTypes.PHYSICAL);
        System.out.println(ANSI_BLUE + getEnemyName() + " Shoot a Sniper Arrow and did " + attackDamage.getDamage() + " Physical Damage."  + ANSI_RESET);
        return attackDamage;
    }

    @Override
    public ReturningAttackValues attack() {

        if (Randomizer.getPercentage() < 30){
            return sniperArrow();
        }

        return super.attack();
    }
}
