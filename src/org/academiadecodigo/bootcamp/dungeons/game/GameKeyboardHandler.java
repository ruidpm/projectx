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



    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:

                if (!game.characterChosen && !game.gameStarted) {

                    game.init();
                }

                break;

            case KeyboardEvent.KEY_1:

                if (!game.characterChosen && game.gameStarted){
                    game.createPlayer(PlayerClasses.WARRIOR);
                    game.images.deleteChoosePlayer();
                    game.start();
                }

                break;

            case KeyboardEvent.KEY_2:

                if (!game.characterChosen && game.gameStarted){
                    game.createPlayer(PlayerClasses.NINJA);
                    game.images.deleteChoosePlayer();
                    game.start();
                }

                break;

            case  KeyboardEvent.KEY_3:

                if (!game.characterChosen && game.gameStarted){
                    game.createPlayer(PlayerClasses.WIZARD);
                    game.images.deleteChoosePlayer();
                    game.start();
                }
                break;


            case  KeyboardEvent.KEY_A:

                if (!game.outOfCombat && game.characterChosen){

                    game.playerAttack();
                }

                break;

            case  KeyboardEvent.KEY_N:

                if (game.outOfCombat && game.gameStarted && !game.choosingSkill && game.characterChosen){
                    game.createEnemy();
                }

                break;

            case  KeyboardEvent.KEY_F:

                if (!game.outOfCombat && game.characterChosen){
                    game.playerFlee();
                }

                break;

            case  KeyboardEvent.KEY_H:

                if (!game.outOfCombat && game.characterChosen){
                    game.playerUseHealthPotion();
                }

                break;

            case  KeyboardEvent.KEY_M:

                if (!game.outOfCombat && game.characterChosen){
                    game.playerUseManaPotion();
                }

                break;

            case  KeyboardEvent.KEY_R:

                if (game.outOfCombat && game.gameStarted && !game.choosingSkill && game.characterChosen){
                    game.playerRest();
                }

                break;

            case  KeyboardEvent.KEY_Z:

                if (!game.outOfCombat && game.gameStarted){
                    game.playerUseSkill(0);
                }

                break;

            case  KeyboardEvent.KEY_X:

                if (!game.outOfCombat && game.gameStarted){
                    game.playerUseSkill(1);
                }

                break;

            case  KeyboardEvent.KEY_C:

                if (!game.outOfCombat && game.gameStarted){
                    game.playerUseSkill(2);
                }

                break;

            case  KeyboardEvent.KEY_V:

                if (!game.outOfCombat && game.gameStarted){
                    game.playerUseSkill(3);
                }

                break;

            case  KeyboardEvent.KEY_K:

                if (game.choosingSkill){
                    game.playerChooseSkill(1);
                }

                break;

            case  KeyboardEvent.KEY_L:

                if (game.choosingSkill){
                    game.playerChooseSkill(2);
                }

                break;

            case  KeyboardEvent.KEY_Y:

                if (game.choosingWeapon){
                    game.playerSwitchWeapon();
                }

                break;

            case  KeyboardEvent.KEY_Q:

                if (!game.gameStarted){
                    System.exit(1);
                }

                break;

            case  KeyboardEvent.KEY_W:

                if (!game.characterChosen && !game.gameStarted) {

                    game.init();
                }

                break;
        }
    }



    private void setKeyAndEvent(int key, KeyboardEventType type){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    private void addKeysAndEvents(){
        setKeyAndEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_1, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_2, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_3, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_N, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_R, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_F, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_M, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_H, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_Z, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_X, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_C, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_V, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_K, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_L, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_Y, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_RELEASED);

        setKeyAndEvent(KeyboardEvent.KEY_W, KeyboardEventType.KEY_RELEASED);

    }

}
