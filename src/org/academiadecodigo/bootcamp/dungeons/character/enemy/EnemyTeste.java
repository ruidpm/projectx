package org.academiadecodigo.bootcamp.dungeons.character.enemy;

import org.academiadecodigo.bootcamp.dungeons.character.enemy.enemies.eliteEnemies.*;

public class EnemyTeste {
    public static void main(String[] args) {
        int faust=0;
        int serin=0;
        int mari=0;
        for (int i = 0; i < 10; i++) {


            Enemy enemy = EnemyFactory.createBoss();
            System.out.println("Enemy spawned: " + enemy.getClass().getSimpleName());


            if (enemy instanceof SeringasMon){
                serin++;
            }
            if (enemy instanceof MarianaMon){
                mari++;
            }
            if (enemy instanceof Faustinomon){
                faust++;
            }
        }

        System.out.println();
        System.out.println("=======================");
        System.out.println("| Elite Faustino :  " + faust + " |");
        System.out.println("| Elite Mariana :   " + mari + " |");
        System.out.println("| Elite Seringas:   " + serin + " |");
        System.out.println("=======================");

    }
}
