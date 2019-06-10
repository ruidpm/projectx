package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;

public enum EnemySkills {
    CHARGE(20, DamageTypes.PHYSICAL),
    FIRE_BOMB(30, DamageTypes.MAGICAL),
    DOUBLE_ATTACK(40, DamageTypes.PHYSICAL),
    ICYCLE(50, DamageTypes.MAGICAL);

    int spellDamage;
    DamageTypes damage_types;


    EnemySkills(int spellDamage, DamageTypes damage_types) {
        this.spellDamage = spellDamage;
        this.damage_types = damage_types;
    }
}
