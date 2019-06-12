package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.EliteHunter;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.EliteMinotaur;
import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.EliteSkeleton;

public class EnemyTeste {
    public static void main(String[] args) {
        int skel=0;
        int hunt=0;
        int mino=0;
        for (int i = 0; i < 10; i++) {


            Enemy enemy = EnemyFactory.createEliteEnemy();
            System.out.println("Enemy spawned: " + enemy.getClass().getSimpleName());


            if (enemy instanceof EliteHunter){
                hunt++;
            }
            if (enemy instanceof EliteMinotaur){
                mino++;
            }
            if (enemy instanceof EliteSkeleton){
                skel++;
            }
        }

        System.out.println();
        System.out.println("=======================");
        System.out.println("| Elite Skeletons : " + skel + " |");
        System.out.println("| Elite Minotaurs : " + mino + " |");
        System.out.println("| Elite Hunters   : " + hunt + " |");
        System.out.println("=======================");

    }
}
