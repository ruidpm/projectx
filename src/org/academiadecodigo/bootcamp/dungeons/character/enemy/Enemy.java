package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;

public class Enemy extends Character {
    private String enemyName;
    private int experience;
    private EnemySkills[] enemySkills; //todo enemy skills


    public Enemy(EnemyTypes enemy) {
        super(enemy.getHealthPoints(), enemy.getStrength(), enemy.getIntelligence(),
                enemy.getPhysicalResistance(), enemy.getMagicalResistance(), enemy.getEvasionChance(),
                enemy.getCriticalChance());

        this.enemyName = enemy.name();
        this.experience = enemy.getExperience();
        System.out.println("A new enemy appears: " + enemyName);
    }

    @Override
    public ReturningAttackValues attack() {
        if (Randomizer.getPercentage() < super.getCriticalChance()){
            System.out.println("Critical hit!!!");
            ReturningAttackValues attackDamage;
            attackDamage = new ReturningAttackValues((int )(super.getStrength() * 1.5), DamageTypes.PHYSICAL);
            return attackDamage;

        }

        ReturningAttackValues attackDamage;
        attackDamage = new ReturningAttackValues(super.getStrength(), DamageTypes.PHYSICAL);
        return attackDamage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getExperience() {
        return experience;
    }
}
