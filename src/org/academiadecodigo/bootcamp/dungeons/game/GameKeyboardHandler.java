package org.academiadecodigo.bootcamp.dungeons.game;

import org.academiadecodigo.bootcamp.dungeons.character.player.PlayerClasses;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Game game;



    public GameKeyboardHandler(Game game){

        this.game = game;

        keyboard = new Keyboard(this);

        addKeysAndEvents();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:

                if (game.characterChosen && !game.gameStarted) {

                    game.start();
                }

                break;

            case KeyboardEvent.KEY_1:

                if (!game.characterChosen){
                    game.createPlayer(PlayerClasses.WARRIOR);
                }

                break;

            case KeyboardEvent.KEY_2:

                if (!game.characterChosen){
                    game.createPlayer(PlayerClasses.NINJA);
                }

                break;

            case  KeyboardEvent.KEY_3:

                if (!game.characterChosen){
                    game.createPlayer(PlayerClasses.WIZARD);
                }
                break;


            case  KeyboardEvent.KEY_A:

                if (!game.enemyDead){

                    game.playerAttack();
                }

                break;

             case  KeyboardEvent.KEY_0:

                if (game.enemyDead && game.gameStarted){
                    game.createEnemy();
                }

                break;

            case  KeyboardEvent.KEY_F:

                if (!game.enemyDead){
                    game.playerFlee();
                }

                break;

            case  KeyboardEvent.KEY_H:

                if (!game.enemyDead){
                    game.playerUseHealthPotion();
                }

                break;

            case  KeyboardEvent.KEY_M:

                if (!game.enemyDead){
                    game.playerUseManaPotion();
                }

                break;

            case  KeyboardEvent.KEY_R:

                if (game.enemyDead && game.gameStarted){
                    game.playerRest();
                }

                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }



    private void setKeyAndEvent(int key, KeyboardEventType type){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    private void addKeysAndEvents(){
        setKeyAndEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_1, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_2, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_3, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_0, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_R, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_F, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_M, KeyboardEventType.KEY_PRESSED);

        setKeyAndEvent(KeyboardEvent.KEY_H, KeyboardEventType.KEY_PRESSED);

    }

}
