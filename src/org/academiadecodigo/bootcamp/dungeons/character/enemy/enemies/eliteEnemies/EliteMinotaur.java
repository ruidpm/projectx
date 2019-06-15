package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

import java.util.concurrent.ThreadLocalRandom;

public class EliteMinotaur extends Enemy {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public EliteMinotaur(){
        super(EnemyTypes.ELITE_MINOTAUR);
    }

    public ReturningAttackValues minoHornII(){
        ReturningAttackValues attackDamage;

        double random = ThreadLocalRandom.current().nextDouble(1.1, 1.4);

        attackDamage = new ReturningAttackValues((int )(super.getStrength() * random), DamageTypes.PHYSICAL);

        System.out.println(ANSI_BLUE + getEnemyName() + " Minotaur Pierce you. " + attackDamage.getDamage() + " Physical Damage."  + ANSI_RESET);

        return attackDamage;
    }



    @Override
    public ReturningAttackValues attack() {

        if (Randomizer.getPercentage() < 30){
            return minoHornII();
        }

        return super.attack();
    }
}
