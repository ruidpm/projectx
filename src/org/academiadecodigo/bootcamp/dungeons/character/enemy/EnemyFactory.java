package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.Randomizer;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.*;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.*;


public class EnemyFactory {

    public static Enemy createEnemy() {
        Enemy enemy;
        
        if (Randomizer.getPercentage() >= 98) {
            enemy = new Hunter();
            return enemy;
        }

        if (Randomizer.getPercentage() >= 95) {
            enemy = new Minotaur();
            return enemy;
        }
        if (Randomizer.getPercentage() >= 75) {
            enemy = new Skeleton();
            return enemy;
        }
        if (Randomizer.getPercentage() >= 60) {
            enemy = new Orc();
            return enemy;
        }
        if (Randomizer.getPercentage() >= 40) {
            enemy = new Goblin();
            return enemy;
        }
        if (Randomizer.getPercentage() >= 20) {
            enemy = new Troll();
            return enemy;
        }

        return enemy = new Rat();
    }



    public static Enemy createEliteEnemy() {
        Enemy enemy;

        if (Randomizer.getPercentage() >= 85) {
            enemy = new EliteHunter();
            return enemy;
        }

        if (Randomizer.getPercentage() >= 65) {
            enemy = new EliteMinotaur();
            return enemy;
        }

        return enemy = new EliteSkeleton();
    }

    public static Enemy createBoss() {
        Enemy enemy;

        if (Randomizer.getPercentage() >= 66) {
            enemy = new MarianaMon();
            return enemy;
        }

        if (Randomizer.getPercentage() >= 33) {
            enemy = new Faustinomon();
            return enemy;
        }

        return enemy = new SeringasMon();
    }
}
