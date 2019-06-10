package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.Enemy;

public class EnemyFactory {

    public static Enemy createEnemy(){

        return new Enemy(10,10,10,10,10,10,10);
    }

    public static Enemy createEliteEnemy(){
        return null;
    }
}
