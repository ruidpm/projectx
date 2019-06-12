package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;
import org.academiadecodigo.bootcamp.dungeons.character.ReturningAttackValues;

public class Enemy extends Character {
    private String enemyName;
    private int experience;


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
            ReturningAttackValues attackDamage;
            attackDamage = new ReturningAttackValues((int )(super.getStrength() * 1.5), DamageTypes.PHYSICAL);
            System.out.println(getEnemyName() + " did a Critical hit!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! damage: " + attackDamage.getDamage());
            return attackDamage;
        }

        ReturningAttackValues attackDamage;
        attackDamage = new ReturningAttackValues(super.getStrength(), DamageTypes.PHYSICAL);
        System.out.println(getEnemyName() + " did a damage: " + attackDamage.getDamage());
        return attackDamage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getExperience() {
        return experience;
    }
}
