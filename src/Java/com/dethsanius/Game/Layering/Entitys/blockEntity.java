package Java.com.dethsanius.Game.Layering.Entitys;

import Engin.Entity.AbstractEntity;

import java.awt.*;

/**
 * Created by Dethsanius on 12.02.14, project is ${PROJECT_NAME} package are ${PACKAGE_NAME}.
 */
public abstract class blockEntity extends AbstractEntity {
    protected int Width = 32, Height = 32;

    public blockEntity(double x, double y, int width, int height)
    {
        super(x, y);
        this.Width = width;
        this.Height = height;
    }

    public double getWidth()
    {
        return Width;
    }

    public double getHeight()
    {
        return Height;
    }

    public Rectangle getBlock()
    {
        return new Rectangle((int) getX(), (int) getY(), Width, Height);
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(Color.cyan);
        g2d.fill(getBlock());
        g2d.setPaint(Color.white);
        g2d.draw(getBlock());
    }
}
