package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum ItemTypes {
    HEALTHPOTION(150),
    MANAPOTION(70);

    private int value;

    ItemTypes(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
