package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Character {
    private String enemyName;
    private int experience;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private EnemyTypes enemyTypes;

    public Enemy(EnemyTypes enemy) {
        super(enemy.getHealthPoints(), enemy.getStrength(), enemy.getIntelligence(),
                enemy.getPhysicalResistance(), enemy.getMagicalResistance(), enemy.getEvasionChance(),
                enemy.getCriticalChance());

        this.enemyName = enemy.name();
        this.experience = enemy.getExperience();
        this.enemyTypes = enemy;
        System.out.println("A new enemy appears: " + enemyName);

    }

    @Override
    public ReturningAttackValues attack() {

        if(Randomizer.getPercentage() < super.getCriticalChance()){
            return criticalHit();
        }
        double random = ThreadLocalRandom.current().nextDouble(0.7, 1.3);
        ReturningAttackValues attackDamage;
        attackDamage = new ReturningAttackValues((int)(super.getStrength() * random), DamageTypes.PHYSICAL);
        System.out.println(getEnemyName() + " did a damage: " + attackDamage.getDamage());
        return attackDamage;
    }


    public ReturningAttackValues criticalHit() {
        double random = ThreadLocalRandom.current().nextDouble(1.3, 1.7);
            ReturningAttackValues attackDamage;
            attackDamage = new ReturningAttackValues((int) (super.getStrength() * random), DamageTypes.PHYSICAL);
            System.out.println(ANSI_RED + getEnemyName() + " did a Critical hit! Damage: " + attackDamage.getDamage() + ANSI_RESET);
            return attackDamage;

    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getExperience() {
        return experience;
    }

    public EnemyTypes getEnemyTypes(){
        return enemyTypes;
    }
}
