package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum WeaponTypes {
    IRONAXE (25),
    METALSWORD(15),
    FIRESWORD(40),
    SHOE(1),
    CROSSBOW(50),
    STAFF (30),
    SHURIKEN (10);

    private int damage;

    WeaponTypes(int damage) {
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString(){
        return this.name() + ", " + this.damage + " damage";
    }
}
