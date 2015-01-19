package Java.com.dethsanius.Game.Layering.Entitys;

import Engin.Entity.AbstractEntity;
import Engin.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Haxer on 12.02.14.
 */
public class layerEntity extends AbstractEntity {
    public boolean kill = false, winn = false;
    private int Width, Height;
    private boolean left = false, right = true;
    private int layer = 0, blocks = 3, layerNew = 0, maxLayers = 21;
    private Rectangle[] block = new Rectangle[maxLayers];
    private boolean max2Blocks = false;
    private boolean max1Blocks = false;
    private boolean secoundPrice = false;
    private boolean firstPrice = false;
    private blockEntity blockEntity1, blockEntity2, blockEntity3;

    public layerEntity(int x, int y, int width, int height)
    {
        super(x, y);
        this.Width = width;
        this.Height = height;
        onCreate();
    }

    private void onCreate()
    {
        blockEntity1 = new blockEntity(getX(), getY(), Width - 1, Height) {
            @Override
            public void update()
            {

            }
        };
        blockEntity2 = new blockEntity(blockEntity1.getX() + Width, getY(), Width - 1, Height) {
            @Override
            public void update()
            {

            }
        };
        blockEntity3 = new blockEntity(blockEntity2.getX() + Width, getY(), Width - 1, Height) {
            @Override
            public void update()
            {

            }
        };
    }

    private void layerLogic()
    {
        switch (layer)
        {
            case 3:
                max2Blocks = true;
                break;
            case 6:
                max1Blocks = true;
                break;
            case 11:
                secoundPrice = true;
                break;
            case 14:
                firstPrice = true;
                break;
        }
    }

    private void generateLayerBlocks(Graphics2D g2d)
    {
        if (blocks > 1)
        {
            g2d.setPaint(Color.cyan);
            g2d.fill(blockEntity2.getBlock());
            g2d.setPaint(Color.white);
            g2d.draw(blockEntity2.getBlock());
            if (blocks == 3)
            {
                g2d.setPaint(Color.cyan);
                g2d.fill(blockEntity3.getBlock());
                g2d.setPaint(Color.white);
                g2d.draw(blockEntity3.getBlock());
            }
        }
        g2d.setPaint(Color.cyan);
        g2d.fill(blockEntity1.getBlock());
        g2d.setPaint(Color.white);
        g2d.draw(blockEntity1.getBlock());
    }

    private void pushUp()
    {
        if (blocks > 1)
        {
            blockEntity2.setY(blockEntity2.getY() - Height);
            if (blocks == 3)
            {
                blockEntity3.setY(blockEntity3.getY() - Height);
            }
        }
        blockEntity1.setY(blockEntity1.getY() - Height);
    }

    public void stopMovement()
    {
        if (layer == layerNew)
        {
            if (Screen.getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_SPACE))
            {
                if (layer > 0)
                {
                    if (blockEntity1.getX() >= block[layer - 1].getX() && blockEntity1.getX() + blockEntity1.getWidth() * blocks + blocks <= block[layer - 1].getX() + block[layer - 1].getWidth())
                    {
                        layerNew++;
                        block[layer] = new Rectangle((int) blockEntity1.getX(), (int) blockEntity1.getY(), Width * blocks, Height);
                    } else
                    {
                        kill = true;
                    }
                } else
                {
                    layerNew++;
                    block[layer] = new Rectangle((int) blockEntity1.getX(), (int) blockEntity1.getY(), Width * blocks, Height);
                }
            }
        } else
        {
            layer++;
            pushUp();
        }
    }

    private void moveBlocks(int blocks)
    {
        if (right)
        {
            if (blocks > 1)
            {
                blockEntity2.setX(blockEntity2.getX() + Width);
                if (blocks == 3)
                {
                    blockEntity3.setX(blockEntity3.getX() + Width);
                }
            }
            blockEntity1.setX(blockEntity1.getX() + Width);
        } else if (left)
        {
            if (blocks > 1)
            {
                blockEntity2.setX(blockEntity2.getX() - Width);
                if (blocks == 3)
                {
                    blockEntity3.setX(blockEntity3.getX() - Width);
                }
            }
            blockEntity1.setX(blockEntity1.getX() - Width);
        }
        if (blockEntity1.getX() == Screen.getScreenFactory().getGame().getWindowWidth() - 50 * blocks)
        {
            right = false;
            left = true;
        } else if (blockEntity1.getX() == 0)
        {
            right = true;
            left = false;
        }
    }

    private void calculateBlocks()
    {
        if (max2Blocks && !max1Blocks)
        {
            blocks = 2;
        } else if (max1Blocks)
        {
            blocks = 1;
        } else
        {
            blocks = 3;
        }
    }

    @Override
    public void update()
    {
        //stopMovement();
        calculateBlocks();
        moveBlocks(blocks);
        layerLogic();
        if (layer == maxLayers)
        {
            winn = true;
        }
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        if (layer > 0)
        {
            for (int i = 0; i < layer; i++)
            {
                g2d.setPaint(Color.cyan);
                g2d.fill(block[i]);
            }
        }
        generateLayerBlocks(g2d);
    }
}