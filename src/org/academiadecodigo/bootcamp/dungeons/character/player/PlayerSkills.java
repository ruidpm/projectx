package org.academiadecodigo.bootcamp.dungeons.character.player;

import org.academiadecodigo.bootcamp.dungeons.character.DamageTypes;

public enum PlayerSkills {
    DOUBLE_ATTACK (35 ,DamageTypes.PHYSICAL, 20, "Double Attack"),
    YELL (40, DamageTypes.PHYSICAL, 30, "Yell"),
    SPEAR_STAB (35, DamageTypes.PHYSICAL, 30, "Spear Stab"),
    DARKSOUL (45, DamageTypes.MAGICAL, 40, "Dark Soul"),
    INNER_DEAMON (50, DamageTypes.MAGICAL, 40, "Inner Deamon"),
    DRAGON_RAGE (40, DamageTypes.PHYSICAL, 30, "Dragon Rage"),
    HYPNOSIS (30, DamageTypes.MAGICAL, 25, "Hypnosis"),
    UNHOLY_SPEAR (80, DamageTypes.MAGICAL, 45, "Unholy Spear"),
    SPINNING_RAGE (45, DamageTypes.PHYSICAL, 40, "Spinning Rage"),
    SIDE_SMASH (40, DamageTypes.PHYSICAL, 30, "Side Smash"),
    PSYCHO_DRAIN (45, DamageTypes.MAGICAL, 40, "Psycho Drain"),
    ACID_NEBULA (35, DamageTypes.PHYSICAL, 30, "Acid Nebula"),
    TRAP_SOUL (30, DamageTypes.MAGICAL, 20, "Trap Soul"),
    INFINITE_LOOP (45, DamageTypes.MAGICAL, 35, "Infinite Loop"),
    CRUMBLE_FIST (45, DamageTypes.PHYSICAL, 35, "Crumble Fist"),
    UNHANDLED_EXCEPTION (100, DamageTypes.PHYSICAL, 60, "Exception"),
    SPLASH (1, DamageTypes.PHYSICAL, 1, "Splash");


    int skillDamage;
    DamageTypes damageTypes;
    int manaNeeded;
    String name;

    PlayerSkills(int spellDamage, DamageTypes damage_types, int manaNeeded, String name) {
        this.skillDamage = spellDamage;
        this.damageTypes = damage_types;
        this.manaNeeded = manaNeeded;
        this.name = name;
    }

    @Override
    public String toString(){

        return name + ": " + skillDamage + " " + damageTypes + ", " + manaNeeded + " mana cost";
    }

    public String getName() {
        return name;
    }
}
