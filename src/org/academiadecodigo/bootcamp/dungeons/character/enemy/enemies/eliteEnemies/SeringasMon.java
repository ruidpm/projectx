package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

import java.util.concurrent.ThreadLocalRandom;

public class SeringasMon extends Enemy {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public SeringasMon(){
        super(EnemyTypes.SERINGASMON);
    }

    public ReturningAttackValues seringada(){
        ReturningAttackValues attackDamage;

        double random = ThreadLocalRandom.current().nextDouble(1.4, 1.7);

        attackDamage = new ReturningAttackValues((int )(super.getIntelligence() * random), DamageTypes.MAGICAL);

        System.out.println(ANSI_BLUE + getEnemyName() + " Seringamon did a Seringada on you. " + attackDamage.getDamage() + " Magical Damage."  + ANSI_RESET);

        return attackDamage;
    }



    @Override
    public ReturningAttackValues attack() {

        if (Randomizer.getPercentage() < 30){
            return seringada();
        }

        return super.attack();
    }
}
