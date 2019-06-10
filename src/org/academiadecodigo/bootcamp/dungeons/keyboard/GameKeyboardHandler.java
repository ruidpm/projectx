package org.academiadecodigo.bootcamp.dungeons.keyboard;

import org.academiadecodigo.bootcamp.dungeons.Game;
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

                if (game.isCharacterChosen() && !game.isGameStarted()) {

                    game.start();
                }

                break;

            case KeyboardEvent.KEY_1:

                if (!game.isCharacterChosen()){
                    game.createPlayer(PlayerClasses.WARRIOR);
                }

                break;

            case KeyboardEvent.KEY_2:

                if (!game.isCharacterChosen()){
                    game.createPlayer(PlayerClasses.NINJA);
                }

                break;

            case  KeyboardEvent.KEY_3:

                if (!game.isCharacterChosen()){
                    game.createPlayer(PlayerClasses.WIZARD);
                }
                break;


            case  KeyboardEvent.KEY_A:

                if (game.isWaitingBattleInput()){
                    System.out.println("i was here");
                    game.waitingBattleInputOff();
                }
                break;

             case  KeyboardEvent.KEY_0:

                 System.out.println("got here");
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
    }

}
