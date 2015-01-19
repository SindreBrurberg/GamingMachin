package Java.com.dethsanius.Game.PongV3.Entity;

import Engin.Entity.AbstractEntity;
import Engin.Screen;

import java.awt.*;

/**
 * Created by Dethsanius on 12.04.2014, project is Games 2D package are Java.com.dethsanius.Game.PongV3.
 */
public abstract class Paddel extends AbstractEntity implements IPaddle {
    private double width, height;

    public Paddel(double x, double y, double width, double height)
    {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
    {
        return width;
    }

    public Rectangle getPaddle()
    {
        return new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void update()
    {
        onUpdate();
        if (getY() <= 0)
        {
            setY(0);
        } else if (getY() + getHeight() >= Screen.getScreenFactory().getGame().getWindowHeight())
        {
            setY(Screen.getScreenFactory().getGame().getWindowHeight() - getHeight());
        }
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(Color.white);
        g2d.draw(getPaddle());
    }
}
