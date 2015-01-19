package Java.com.dethsanius.Game.Layering.Screen;

import Engin.Screen;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.Layering.Entitys.layerEntity;
import Java.com.dethsanius.Game.Lib.Reference;

import java.awt.*;

/**
 * Created by Haxer on 10.02.14.
 */
public class gameScreen extends Screen {
    private boolean ableToPushUp;
    private layerEntity LE;
    private int milli = 0;

    public gameScreen(ScreenFactory screenFactory)
    {
        super(screenFactory);

    }

    @Override
    public void onCreate()
    {
        LE = new layerEntity(0, (int) screenFactory.getGame().getWindowHeight() - 52, 50, 50);
    }

    @Override
    public void onUpdate()
    {
        if (ableToPushUp)
        {
            LE.stopMovement();
            ableToPushUp = false;
        }
        if (milli == 60)
        {
            LE.update();
            milli = 0;
            ableToPushUp = true;
        }
        milli++;
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(0, 0, (int) screenFactory.getGame().getWindowWidth(), (int) screenFactory.getGame().getWindowHeight());
        LE.draw(g2d);
        if (LE.kill || LE.winn)
        {
            screenFactory.getGame().setWindowSize(Reference.winX, Reference.winY);
            screenFactory.showScreen(new endScreen(screenFactory, LE.winn));
        }
    }
}
