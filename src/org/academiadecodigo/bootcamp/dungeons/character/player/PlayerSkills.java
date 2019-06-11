package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;

public enum PlayerSkills {
    DOUBLEATTACK (25 ,DamageTypes.PHYSICAL),
    YELL (20, DamageTypes.PHYSICAL),
    SPEARSTEB (25, DamageTypes.PHYSICAL),
    DARKSOUL (35, DamageTypes.MAGICAL),
    INNERDEAMON (40, DamageTypes.MAGICAL),
    DRAGONRAGE (30, DamageTypes.PHYSICAL),
    HYPNOSE (15, DamageTypes.MAGICAL),
    UNHOLYHEAL (35, DamageTypes.MAGICAL),
    SPINNINGRAGE (35, DamageTypes.PHYSICAL),
    SIDESMASH (30, DamageTypes.PHYSICAL),
    PSYCHODRAIN (35, DamageTypes.MAGICAL),
    ACIDNEBULA (25, DamageTypes.PHYSICAL),
    TRAPSOUL (20, DamageTypes.MAGICAL),
    INFINITELOOP (35, DamageTypes.MAGICAL),
    CRUMBLEFIST (35, DamageTypes.PHYSICAL);

    
    int skillDamage;
    DamageTypes damageTypes;

    PlayerSkills(int spellDamage, DamageTypes damage_types) {
        this.skillDamage = spellDamage;
        this.damageTypes = damage_types;
    }


}
