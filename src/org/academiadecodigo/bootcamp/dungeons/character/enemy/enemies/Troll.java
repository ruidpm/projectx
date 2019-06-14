package org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.EnemyTypes;

public class Troll extends Enemy {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Troll(){
        super(EnemyTypes.TROLL);
    }
}
