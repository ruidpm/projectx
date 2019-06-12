package org.academiadecodigo.bootcamp.dungeons.character.enemy;

public class EnemyTeste {
    public static void main(String[] args) {
        Enemy enemy = EnemyFactory.createEliteEnemy();

        System.out.println(enemy.getStrength());
    }
}
