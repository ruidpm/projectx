package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;

public class EnemyFactory {

    public static Enemy createEnemy() {

<<<<<<< HEAD
        Enemy enemy = new Enemy(EnemyTypes.RAT);


        if (Randomizer.getPercentage() > 95) {
            enemy = new Enemy(EnemyTypes.HUNTER);
            return enemy;
        }

        if (Randomizer.getPercentage() > 90) {
            enemy = new Enemy(EnemyTypes.MINOTAUR);
            return enemy;
        }
        if (Randomizer.getPercentage() > 75) {
            enemy = new Enemy(EnemyTypes.SKELETON);
            return enemy;
        }
        if (Randomizer.getPercentage() > 60) {
            enemy = new Enemy(EnemyTypes.ORC);
            return enemy;
        }
        if (Randomizer.getPercentage() > 40) {
            enemy = new Enemy(EnemyTypes.GOBLIN);
            return enemy;
        }
        if (Randomizer.getPercentage() > 20) {
            enemy = new Enemy(EnemyTypes.TROLL);
            return enemy;
        }
      
        return enemy;
=======
        return null;
>>>>>>> d81081dd1f5c384584ab23832b6d8fbcc4037d06
    }

    public static Enemy createEliteEnemy() {
        return null;
    }
}
