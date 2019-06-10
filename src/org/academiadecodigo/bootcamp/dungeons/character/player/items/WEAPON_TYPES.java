package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum WEAPON_TYPES {
    IRONAXE (25),
    METALSWORD(15),
    FIRESWORD(40),
    SLIPPER(1),
    CANNON(50),
    STAFF (30),
    SHURIKEN (10);

    private int damage;

    WEAPON_TYPES(int damage) {
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }
}
