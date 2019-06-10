package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum ItemTypes {
    HEALTHPOTION(60),
    MANAPOTION(30);

    private int value;

    ItemTypes(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
