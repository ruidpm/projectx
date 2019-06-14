package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;

public enum PlayerSkills {
    DOUBLEATTACK (35 ,DamageTypes.PHYSICAL, 20),
    YELL (40, DamageTypes.PHYSICAL, 30),
    SPEARSTEB (35, DamageTypes.PHYSICAL, 30),
    DARKSOUL (45, DamageTypes.MAGICAL, 40),
    INNERDEAMON (50, DamageTypes.MAGICAL, 40),
    DRAGONRAGE (40, DamageTypes.PHYSICAL, 30),
    HYPNOSE (30, DamageTypes.MAGICAL, 25),
    UNHOLYHEAL (45, DamageTypes.MAGICAL, 35),
    SPINNINGRAGE (45, DamageTypes.PHYSICAL, 40),
    SIDESMASH (40, DamageTypes.PHYSICAL, 30),
    PSYCHODRAIN (45, DamageTypes.MAGICAL, 40),
    ACIDNEBULA (35, DamageTypes.PHYSICAL, 30),
    TRAPSOUL (30, DamageTypes.MAGICAL, 20),
    INFINITELOOP (45, DamageTypes.MAGICAL, 35),
    CRUMBLEFIST (45, DamageTypes.PHYSICAL, 35);


    int skillDamage;
    DamageTypes damageTypes;
    int manaNeeded;

    PlayerSkills(int spellDamage, DamageTypes damage_types, int manaNeeded) {
        this.skillDamage = spellDamage;
        this.damageTypes = damage_types;
        this.manaNeeded = manaNeeded;
    }


}
