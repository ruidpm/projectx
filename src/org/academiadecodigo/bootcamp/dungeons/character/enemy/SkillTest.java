package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.Goblin;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.Hunter;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.Minotaur;

public class SkillTest {

    public static void main(String[] args) {
        //¢Enemy goblin = new Goblin();
        Enemy hunter = new Hunter();
        //Enemy mino = new Minotaur();

        for (int i = 0; i < 10; i++) {
            ((Hunter) hunter).attack();
        }

    }
}
