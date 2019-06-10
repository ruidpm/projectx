package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.Character;
import org.academiadecodigo.bootcamp.dungeons.character.DAMAGE_TYPES;
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
    }

    @Override
    public ReturningAttackValues attack() {
        ReturningAttackValues attackDamage;
        attackDamage = new ReturningAttackValues(super.getStrength(), DAMAGE_TYPES.PHYSICAL);
        return attackDamage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getExperience() {
        return experience;
    }
}
