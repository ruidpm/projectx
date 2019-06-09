package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum WEAPON_TYPES {
    AXE (25),
    METALSWORD(15),
    FIRESWORD(40),
    SLIPPER(1),
    CANNON(50);

    private int armour;

    WEAPON_TYPES(int armour) {
        this.armour=armour;
    }

    public int getArmour() {
        return armour;
    }
}
