package Java.com.dethsanius.Game.Layering.Screen;

import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;

import java.awt.*;

/**
 * Created by Dethsanius on 14.04.2014, project is Games 2D package are Java.com.dethsanius.Java.com.dethsanius.Game.Layering.Screen.
 */
public class endScreen extends Screen {
    private StringTxt STWinn, STLose;
    private boolean winn;

    public endScreen(ScreenFactory screenFactory, boolean winn)
    {
        super(screenFactory);
        this.winn = winn;
    }

    @Override
    public void onCreate()
    {
        STWinn = new StringTxt(0, 0, screenFactory.getGame().getWindowWidth(), screenFactory.getGame().getWindowHeight(), " You Won :) ") {
            @Override
            public void onUpdate()
            {

            }
        };
        STLose = new StringTxt(0, 0, screenFactory.getGame().getWindowWidth(), screenFactory.getGame().getWindowHeight(), " You Lost :( ") {
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
        if (winn)
        {
            STWinn.draw(g2d);
        } else
        {
            STLose.draw(g2d);
        }
    }
}
