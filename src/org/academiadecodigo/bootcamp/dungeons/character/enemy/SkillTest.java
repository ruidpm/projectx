package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.*;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.*;

public class SkillTest {

    public static void main(String[] args) {
        Enemy goblin = new Goblin();
        Enemy hunter = new Hunter();
        Enemy mino = new Minotaur();
        Enemy orc = new Orc();
        Enemy skel = new Skeleton();
        Enemy troll = new Troll();
        Enemy eSkel = new EliteSkeleton();
        Enemy eHunter = new EliteHunter();
        Enemy eMino = new EliteMinotaur();

/*        for (int i = 0; i < 10; i++) {
            ((Hunter) hunter).attack();
        }*/

        for (int i = 0; i < 10; i++) {
            ((EliteSkeleton) eSkel).attack();
        }

/*        for (int i = 0; i < 10; i++) {
            ((Hunter) hunter).attack();
        }*/
    }
}
