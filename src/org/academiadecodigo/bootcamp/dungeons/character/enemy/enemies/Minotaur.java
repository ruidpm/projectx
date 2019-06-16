package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

import java.util.concurrent.ThreadLocalRandom;

public class Minotaur extends Enemy {

    public Minotaur() {
        super(EnemyTypes.MINOTAUR);
    }
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    public ReturningAttackValues minoHorn(){
        ReturningAttackValues attackDamage;

        double random = ThreadLocalRandom.current().nextDouble(1.1, 1.4);

        attackDamage = new ReturningAttackValues((int )(super.getStrength() * random), DamageTypes.PHYSICAL);

        System.out.println(ANSI_BLUE + getEnemyName() + " Pierce you. " + attackDamage.getDamage() + " Physical Damage."  + ANSI_RESET);

        return attackDamage;
    }



    @Override
    public ReturningAttackValues attack() {

        if (Randomizer.getPercentage() < 30){
            return minoHorn();
        }

        return super.attack();
    }
}
