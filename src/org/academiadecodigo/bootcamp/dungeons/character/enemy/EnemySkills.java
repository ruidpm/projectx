package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.DAMAGE_TYPES;

public enum EnemySkills {
    CHARGE(20, DAMAGE_TYPES.PHYSICAL),
    FIRE_BOMB(30, DAMAGE_TYPES.MAGICAL),
    DOUBLE_ATTACK(40, DAMAGE_TYPES.PHYSICAL),
    ICYCLE(50, DAMAGE_TYPES.MAGICAL);

    int spellDamage;
    DAMAGE_TYPES damage_types;


    EnemySkills(int spellDamage, DAMAGE_TYPES damage_types) {
        this.spellDamage = spellDamage;
        this.damage_types = damage_types;
    }
}
