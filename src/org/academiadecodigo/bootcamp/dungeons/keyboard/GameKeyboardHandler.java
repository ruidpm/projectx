package org.academiadecodigo.bootcamp.dungeons.keyboard;

import org.academiadecodigo.bootcamp.dungeons.Game;
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

            case KeyboardEvent.KEY_DOWN:

                game.start();

                break;

            case KeyboardEvent.KEY_UP:
                break;

            case KeyboardEvent.KEY_LEFT:
                break;

            case  KeyboardEvent.KEY_RIGHT:
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }



    private void setKeyAndEvent(int key, KeyboardEventType type, Keyboard keyboard){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    private void addKeysAndEvents(){
        setKeyAndEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED, keyboard);

        setKeyAndEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED, keyboard);

        setKeyAndEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED, keyboard);

        setKeyAndEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED, keyboard);

    }

}
