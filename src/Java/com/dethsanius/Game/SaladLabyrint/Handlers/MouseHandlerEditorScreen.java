package Java.com.dethsanius.Game.SaladLabyrint.Handlers;

import Engin.Listener.MousepadListener;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.SaladLabyrint.Screan.editorScrean;

import java.awt.*;

/**
 * Created by Dethsanius on 12.01.2015.
 */
public class MouseHandlerEditorScreen extends MousepadListener {

    public static Rectangle path = new Rectangle(0,48,0,0);
    public static boolean horisontal = true;

    ScreenFactory screenFactory;

    public MouseHandlerEditorScreen(ScreenFactory initScreenFactory) {
        super();
        screenFactory = initScreenFactory;
    }

    @Override
    public void Moved() {

    }

    @Override
    public void Exited() {

    }

    @Override
    public void Entered() {

    }

    @Override
    public void Clicked() {
        for (int i = 0; i < editorScrean.maxRectanglesDrawn; i++) {
            if (getMouse(screenFactory).getBounds().intersects(editorScrean.routes[i])){
                editorScrean.routeStatus[i] = editorScrean.routeStat;
            }
        }
    }

    @Override
    public void Pressed() {

    }

    @Override
    public void Released() {

    }

    @Override
    public void Dragged() {

    }
}
