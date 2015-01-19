package Java.com.dethsanius.Game.SaladLabyrint.Handlers;

import Engin.Listener.KeyboardListener;
import Java.com.dethsanius.Game.SaladLabyrint.Entity.Eater;
import Java.com.dethsanius.Game.SaladLabyrint.Screan.gameScrean;

import java.awt.event.KeyEvent;

/**
 * Created by sindre on 18.01.2015.
 */
public class KeyboardHandlerGameScreen extends KeyboardListener{

    @Override
    public void Typed(KeyEvent e) {
    }

    @Override
    public void Pressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameScrean.eater.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                gameScrean.eater.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                gameScrean.eater.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                gameScrean.eater.moveRight();
                break;
        }

    }

    @Override
    public void Released(KeyEvent e) {

    }
}
