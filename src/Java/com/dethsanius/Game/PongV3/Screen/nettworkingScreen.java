package Java.com.dethsanius.Game.PongV3.Screen;

import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;

import java.awt.*;

/**
 * Created by Dethsanius on 13.04.2014, project is Games 2D package are Java.com.dethsanius.Game.PongV3.Screen.
 */
public class nettworkingScreen extends Screen {
    private StringTxt stringTxt, stringTxt2;

    public nettworkingScreen(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    @Override
    public void onCreate()
    {
        stringTxt = new StringTxt(0, 0, screenFactory.getGame().getWindowWidth(), screenFactory.getGame().getWindowHeight() / 2, "This is not implemented yet,") {
            @Override
            public void onUpdate()
            {

            }
        };
        stringTxt2 = new StringTxt(0, screenFactory.getGame().getWindowHeight() / 2, screenFactory.getGame().getWindowWidth(), screenFactory.getGame().getWindowHeight() / 2, "look back later :P") {
            @Override
            public void onUpdate()
            {

            }
        };
    }

    @Override
    public void onUpdate()
    {

    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(Color.black);
        g2d.fillRect(0, 0, (int) screenFactory.getGame().getWindowWidth(), (int) screenFactory.getGame().getWindowHeight());
        stringTxt.draw(g2d);
        stringTxt2.draw(g2d);
    }
}
