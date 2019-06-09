package org.academiadecodigo.bootcamp.dungeons.character.player.items;

public enum ITEM_TYPES {
    HEALTHPOTIONLARGE(60),
    HEALTHPOTIONSMALL(20),
    MANAPOTION(30);

    private int value;

    ITEM_TYPES(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
