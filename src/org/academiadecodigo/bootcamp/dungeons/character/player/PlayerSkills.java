package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;

public enum PlayerSkills {
    DOUBLE_ATTACK (35 ,DamageTypes.PHYSICAL, 20),
    YELL (40, DamageTypes.PHYSICAL, 30),
    SPEAR_STAB (35, DamageTypes.PHYSICAL, 30),
    DARKSOUL (45, DamageTypes.MAGICAL, 40),
    INNER_DEAMON (50, DamageTypes.MAGICAL, 40),
    DRAGON_RAGE (40, DamageTypes.PHYSICAL, 30),
    HYPNOSIS (30, DamageTypes.MAGICAL, 25),
    UNHOLY_SPEAR (65, DamageTypes.MAGICAL, 45),
    SPINNING_RAGE (45, DamageTypes.PHYSICAL, 40),
    SIDE_SMASH (40, DamageTypes.PHYSICAL, 30),
    PSYCHO_DRAIN (45, DamageTypes.MAGICAL, 40),
    ACID_NEBULA (35, DamageTypes.PHYSICAL, 30),
    TRAP_SOUL (30, DamageTypes.MAGICAL, 20),
    INFINITE_LOOP (45, DamageTypes.MAGICAL, 35),
    CRUMBLE_FIST (45, DamageTypes.PHYSICAL, 35);


    int skillDamage;
    DamageTypes damageTypes;
    int manaNeeded;

    PlayerSkills(int spellDamage, DamageTypes damage_types, int manaNeeded) {
        this.skillDamage = spellDamage;
        this.damageTypes = damage_types;
        this.manaNeeded = manaNeeded;
    }


}
