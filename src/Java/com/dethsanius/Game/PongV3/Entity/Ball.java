package Java.com.dethsanius.Game.PongV3.Entity;

import Engin.Entity.AbstractEntity;
import Engin.Screen;

import java.awt.*;

/**
 * Created by Dethsanius on 12.04.2014, project is Games 2D package are Java.com.dethsanius.Game.PongV3.
 */
public abstract class Ball extends AbstractEntity {
    public double velX = Screen.getScreenFactory().getGame().getWindowWidth() / 350, velY = Screen.getScreenFactory().getGame().getWindowWidth() / 350;
    private double width, height;

    public Ball(double x, double y, double width, double height)
    {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public Rectangle getBall()
    {
        return new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(Color.cyan);
        g2d.fillOval(getBall().x, getBall().y, getBall().width, getBall().height);
    }
}
