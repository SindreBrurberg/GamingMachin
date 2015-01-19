package Java.com.dethsanius.Game.WIR;

import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;
import Engin.Time;
import Java.com.dethsanius.Game.Lib.Reference;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static Java.com.dethsanius.Game.WIR.lib.refferences.*;

/**
 * Created by Dethsanius on 13.06.2014, project is Games 2D package are Java.com.dethsanius.Game.WIR.
 */
public class gameScreen extends Screen {
    private Time time;
    private StringTxt timeString;
    private int total = 0;
    private BufferedImage Sky, glasFull, glasBroken, rightRalph, leftRalph, rightFelix, leftFelix;
    private int breaking1 = 0, breaking2 = 0;
    private int hammerTime1 = 0, hammerTime2 = 0;

    public gameScreen(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    public static void setFelixComp(boolean newFelixComp)
    {
        felixComp = newFelixComp;
    }

    public static void setRalphComp(boolean newRalphComp)
    {
        ralphComp = newRalphComp;
    }

    public Dimension getPreferredSize(BufferedImage img, int width, int height)
    {
        if (img == null)
        {
            return new Dimension(width, height);
        } else
        {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

    private void generateScreen()
    {
        loadImages();
        time = new Time(min, sec, milli);
        timeString = new StringTxt(screenFactory.getGame().getWindowWidth() / 2 - 55, 25, 150, 25, time.toMilitary()) {
            @Override
            public void onUpdate()
            {
                milli = milli + 3;
                if (milli >= 60)
                {
                    sec++;
                    milli = milli - 60;
                }
                if (sec == 60)
                {
                    min++;
                    sec = 0;
                }
                if (min == 1)
                {
                    for (int i = 0; i < 60; i++)
                    {
                        total = total + winState[i];
                    }
                    screenFactory.showScreen(new endScreen(screenFactory, total));
                }
                time.setTime(min, sec, milli);
                setTXT(time.toMilitary());
            }
        };
    }

    private void loadImages()
    {
        switch ((int) screenFactory.getGame().getWindowWidth())
        {
            case 1152:
                try
                {
                    Sky = ImageIO.read(new File(Reference.resorcess("WIR") + "Sky-1152-648.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1152 ress, background");
                }
                try
                {
                    glasFull = ImageIO.read(new File(Reference.resorcess("WIR") + "glassFull-1152-648.jpg"));
                    glasBroken = ImageIO.read(new File(Reference.resorcess("WIR") + "glassBroken-1152-648.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1152 ress, glass");
                }
                try
                {
                    rightRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-right-1152-648.png"));
                    leftRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-left-1152-648.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1152 ress, ralph");
                }
                try
                {
                    rightFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-right-1152-648.png"));
                    leftFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-left-1152-648.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1152 ress, felix");
                }
                winSice = 1;
                break;
            case 1280:
                try
                {
                    Sky = ImageIO.read(new File(Reference.resorcess("WIR") + "Sky-1280-720.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1280 ress, background");
                }
                try
                {
                    glasFull = ImageIO.read(new File(Reference.resorcess("WIR") + "glassFull-1280-720.jpg"));
                    glasBroken = ImageIO.read(new File(Reference.resorcess("WIR") + "glassBroken-1280-720.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1280 ress, glass");
                }
                try
                {
                    rightRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-right-1280-720.png"));
                    leftRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-left-1280-720.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1280 ress, ralph");
                }
                try
                {
                    rightFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-right-1280-720.png"));
                    leftFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-left-1280-720.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1280 ress, felix");
                }
                winSice = 2;
                break;
            case 1600:
                try
                {
                    Sky = ImageIO.read(new File(Reference.resorcess("WIR") + "Sky-1600-900.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1600 ress, background");
                }
                try
                {
                    glasFull = ImageIO.read(new File(Reference.resorcess("WIR") + "glassFull-1600-900.jpg"));
                    glasBroken = ImageIO.read(new File(Reference.resorcess("WIR") + "glassBroken-1600-900.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1600 ress, glass");
                }
                try
                {
                    rightRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-right-1600-900.png"));
                    leftRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-left-1600-900.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1600 ress, ralph");
                }
                try
                {
                    rightFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-right-1600-900.png"));
                    leftFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-left-1600-900.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 1600 ress, felix");
                }
                winSice = 3;
                break;
            default:
                try
                {
                    System.out.println(Reference.resorcess("WIR") + "Sky-800-600.jpg");
                    Sky = ImageIO.read(new File(Reference.resorcess("WIR") + "Sky-800-600.jpg"));

                } catch (IOException e)
                {
                    System.out.println("exeption in 800 ress, background");
                }
                try
                {
                    glasFull = ImageIO.read(new File(Reference.resorcess("WIR") + "glassFull-800-600.jpg"));
                    glasBroken = ImageIO.read(new File(Reference.resorcess("WIR") + "glassBroken-800-600.jpg"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 800 ress, glass");
                }
                try
                {
                    rightRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-right-800-600.png"));
                    leftRalph = ImageIO.read(new File(Reference.resorcess("WIR") + "ralph-left-800-600.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 800 ress, ralph");
                }
                try
                {
                    rightFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-right-800-600.png"));
                    leftFelix = ImageIO.read(new File(Reference.resorcess("WIR") + "fixit-left-800-600.png"));
                } catch (IOException e)
                {
                    System.out.println("exeption in 800 ress, felix");
                }
                winSice = 0;
                break;
        }
    }

    @Override
    public void onCreate()
    {
        screenFactory.getGame().setSleep(40);

        generateScreen();
    }

    private void breaking()
    {
        if (breaking1 <= 9)
        {
            if (breaking2 < 5)
            {
                rightBoolRalph = false;
                breaking2++;
            } else if (breaking2 < 10)
            {
                rightBoolRalph = true;
                breaking2++;
            } else breaking2 = 0;
            breaking1++;
        } else
        {
            breaking1 = 0;
            winState[possRalph]--;
            breaking = false;
        }
    }

    private void hammerTime()
    {
        if (hammerTime1 < 15)
        {
            if (hammerTime2 < 5)
            {
                rightBoolFelix = false;
                hammerTime2++;
            } else if (hammerTime2 < 10)
            {
                rightBoolFelix = true;
                hammerTime2++;
            } else hammerTime2 = 0;
            hammerTime1++;
        } else
        {
            hammerTime1 = 0;
            winState[possFelix]++;
            hammerTime = false;
        }
    }

    private void ralphMove()
    {
        if (!breaking)
        {
            if (horiRalph == 0)
            {
                //ralph move down, not hitting felix
                if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN) && possRalph <= 55)
                {
                    if (possRalph >= 42 && possFelix != possRalph + 4)
                    {
                        possRalph = possRalph + 4;
                    } else if (possRalph >= 12 && possFelix != possRalph + 5 && possRalph + 5 != 60)
                    {
                        possRalph = possRalph + 5;
                    } else if (possRalph >= 8 && possFelix != possRalph + 4)
                    {
                        possRalph = possRalph + 4;
                    } else if (possFelix != possRalph + 5 && possRalph + 5 != 60)
                    {
                        possRalph = possRalph + 5;
                    }
                    horiRalph++;
                }
                //ralph move up, not hitting felix
                else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP) && possRalph >= 4)
                {
                    if (possRalph >= 46 && possFelix != possRalph - 5)
                    {
                        possRalph = possRalph - 4;
                    } else if (possRalph >= 17 && possFelix != possRalph - 5)
                    {
                        possRalph = possRalph - 5;
                    } else if (possRalph >= 12 && possFelix != possRalph - 4)
                    {
                        possRalph = possRalph - 4;
                    } else if (possRalph >= 5 && possFelix != possRalph - 5)
                    {
                        possRalph = possRalph - 5;
                    }
                    horiRalph++;
                }
            } else if (horiRalph == 5)
                horiRalph = 0;
            else horiRalph++;
            if (vertRalph == 0)
            {
                //ralp moves left, not hitting felix
                if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_LEFT) && possRalph > 0 && Window[winSice][possRalph].y > Window[winSice][possRalph - 1].y - 10 && Window[winSice][possRalph].y < Window[winSice][possRalph - 1].y + 10 && possFelix != possRalph - 1)
                {
                    possRalph--;
                    vertRalph++;
                }
                //ralph move right, not hitting felix
                else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_RIGHT) && possRalph < 59 && Window[winSice][possRalph].y > Window[winSice][possRalph + 1].y - 10 && Window[winSice][possRalph].y < Window[winSice][possRalph + 1].y + 10 && possFelix != possRalph + 1)
                {
                    possRalph++;
                    vertRalph++;
                }
            } else if (vertRalph == 5)
                vertRalph = 0;
            else vertRalph++;
            if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ENTER) && winState[possRalph] > 1)
            {
                breaking = true;
            }
        } else
        {
            breaking();
        }
    }

    private void felixMove()
    {
        if (!hammerTime)
        {
            if (horiFelix == 0)
            {
                if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S) && possFelix <= 55)
                {
                    if (possFelix >= 42 && possRalph != possFelix + 4)
                    {
                        possFelix = possFelix + 4;
                    } else if (possFelix >= 12 && possRalph != possFelix + 5 && possFelix + 5 != 60)
                    {
                        possFelix = possFelix + 5;
                    } else if (possFelix >= 8 && possRalph != possFelix + 4)
                    {
                        possFelix = possFelix + 4;
                    } else if (possRalph != possFelix + 5 && possFelix + 5 != 60)
                    {
                        possFelix = possFelix + 5;
                    }
                    horiFelix++;
                } else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W) && possFelix >= 4)
                {
                    if (possFelix >= 46 && possRalph != possFelix - 4)
                    {
                        possFelix = possFelix - 4;
                    } else if (possFelix >= 17 && possRalph != possFelix - 5)
                    {
                        possFelix = possFelix - 5;
                    } else if (possFelix >= 12 && possRalph != possFelix - 4)
                    {
                        possFelix = possFelix - 4;
                    } else if (possFelix >= 5 && possRalph != possFelix - 5)
                    {
                        possFelix = possFelix - 5;
                    }
                    horiFelix++;
                }
            } else if (horiFelix == 5)
                horiFelix = 0;
            else horiFelix++;
            if (vertFelix == 0)
            {
                if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_A) && possFelix > 0 && Window[winSice][possFelix].y > Window[winSice][possFelix - 1].y - 10 && Window[winSice][possFelix].y < Window[winSice][possFelix - 1].y + 10 && possRalph != possFelix - 1)
                {
                    possFelix--;
                    vertFelix++;
                } else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_D) && possFelix < 59 && Window[winSice][possFelix].y > Window[winSice][possFelix + 1].y - 10 && Window[winSice][possFelix].y < Window[winSice][possFelix + 1].y + 10 && possRalph != possFelix + 1)
                {
                    possFelix++;
                    vertFelix++;
                }
            } else if (vertFelix == 5)
                vertFelix = 0;
            else vertFelix++;
            if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_SPACE) && winState[possFelix] < 3)
            {
                hammerTime = true;
            }
        } else
        {
            hammerTime();
        }
    }

    private void ralphComputer()
    {
        if (!breaking)
        {
            if (winState[possRalph] == 1)
            {
                if (new Random().nextInt(5) == 0)
                {
                    ralphRight = !ralphRight;
                }
                if (new Random().nextInt(10) == 0)
                {
                    ralphUp = !ralphUp;
                }
                if (horiRalph == 0)
                {
                    if (!ralphUp && possRalph <= 55)
                    {
                        if (possRalph >= 42 && possFelix != possRalph + 4)
                        {
                            possRalph = possRalph + 4;
                        } else if (possRalph >= 12 && possFelix != possRalph + 5 && possRalph + 5 != 60)
                        {
                            possRalph = possRalph + 5;
                        } else if (possRalph >= 8 && possFelix != possRalph + 4)
                        {
                            possRalph = possRalph + 4;
                        } else if (possFelix != possRalph + 5 && possRalph + 5 != 60)
                        {
                            possRalph = possRalph + 5;
                        }
                        horiRalph++;
                    } else if (ralphUp && possRalph >= 4)
                    {
                        if (possRalph >= 46 && possFelix != possRalph - 4)
                        {
                            possRalph = possRalph - 4;
                        } else if (possRalph >= 17 && possFelix != possRalph - 5)
                        {
                            possRalph = possRalph - 5;
                        } else if (possRalph >= 12 && possFelix != possRalph - 4)
                        {
                            possRalph = possRalph - 4;
                        } else if (possRalph >= 5 && possFelix != possRalph - 5)
                        {
                            possRalph = possRalph - 5;
                        }
                        horiRalph++;
                    }
                } else if (horiRalph == 5)
                    horiRalph = 0;
                else horiRalph++;
                if (vertRalph == 0)
                {
                    if (!ralphRight && possRalph > 0 && Window[winSice][possRalph].y > Window[winSice][possRalph - 1].y - 10 && Window[winSice][possRalph].y < Window[winSice][possRalph - 1].y + 10 && possFelix != possRalph - 1)
                    {
                        possRalph--;
                        vertRalph++;
                    } else if (ralphRight && possRalph < 59 && Window[winSice][possRalph].y > Window[winSice][possRalph + 1].y - 10 && Window[winSice][possRalph].y < Window[winSice][possRalph + 1].y + 10 && possFelix != possRalph + 1)
                    {
                        possRalph++;
                        vertRalph++;
                    }
                } else if (vertRalph == 5)
                    vertRalph = 0;
                else vertRalph++;
            } else breaking = true;
        } else breaking();
    }

    private void felixComputer()
    {
        if (!hammerTime)
        {
            if (winState[possFelix] == 3)
            {
                if (new Random().nextInt(5) == 0)
                {
                    felixRight = !felixRight;
                }
                if (new Random().nextInt(10) == 0)
                {
                    felixUp = !felixUp;
                }
                if (horiFelix == 0)
                {
                    if (!felixUp && possFelix <= 55)
                    {
                        if (possFelix >= 42 && possRalph != possFelix + 4)
                        {
                            possFelix = possFelix + 4;
                        } else if (possFelix >= 12 && possRalph != possFelix + 5 && possFelix + 5 != 60)
                        {
                            possFelix = possFelix + 5;
                        } else if (possFelix >= 8 && possRalph != possFelix + 4)
                        {
                            possFelix = possFelix + 4;
                        } else if (possRalph != possFelix + 5 && possFelix + 5 != 60)
                        {
                            possFelix = possFelix + 5;
                        }
                        horiFelix++;
                    } else if (felixUp && possFelix >= 4)
                    {
                        if (possFelix >= 46 && possRalph != possFelix - 4)
                        {
                            possFelix = possFelix - 4;
                        } else if (possFelix >= 17 && possRalph != possFelix - 5)
                        {
                            possFelix = possFelix - 5;
                        } else if (possFelix >= 12 && possRalph != possFelix - 4)
                        {
                            possFelix = possFelix - 4;
                        } else if (possFelix >= 5 && possRalph != possFelix - 5)
                        {
                            possFelix = possFelix - 5;
                        }
                        horiFelix++;
                    }
                } else if (horiFelix == 5)
                    horiFelix = 0;
                else horiFelix++;
                if (vertFelix == 0)
                {
                    if (!felixRight && possFelix > 0 && Window[winSice][possFelix].y > Window[winSice][possFelix - 1].y - 10 && Window[winSice][possFelix].y < Window[winSice][possFelix - 1].y + 10 && possRalph != possFelix - 1)
                    {
                        possFelix--;
                        vertFelix++;
                    } else if (felixRight && possFelix < 59 && Window[winSice][possFelix].y > Window[winSice][possFelix + 1].y - 10 && Window[winSice][possFelix].y < Window[winSice][possFelix + 1].y + 10 && possRalph != possFelix + 1)
                    {
                        possFelix++;
                        vertFelix++;
                    }
                } else if (vertFelix == 5)
                    vertFelix = 0;
                else vertFelix++;
            } else hammerTime = true;
        } else hammerTime();
    }

    private void countWindows()
    {
        brokenWindows = 0;
        halfWindows = 0;
        fullWindows = 0;
        for (int i = 0; i < 60; i++)
        {
            switch (winState[i])
            {
                case 1:
                    brokenWindows++;
                    break;
                case 2:
                    halfWindows++;
                    break;
                case 3:
                    fullWindows++;
                    break;
            }
        }
    }

    @Override
    public void onUpdate()
    {
        if (ralphComp)
            ralphComputer();
        else
            ralphMove();
        if (felixComp)
            felixComputer();
        else
            felixMove();
        if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_ESCAPE))
        {
            setPause(true);
            getScreenFactory().showScreen(new optionScreen(getScreenFactory()));
        }
        timeString.update();
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.drawImage(Sky, 0, 0, null);
        for (int i = 0; i < 60; i++)
        {
            switch (winState[i])
            {
                case 1:
                    g2d.setColor(Color.BLACK);
                    g2d.fill(Window[winSice][i]);
                    break;
                case 2:
                    g2d.drawImage(glasBroken, Window[winSice][i].x, Window[winSice][i].y, null);
                    break;
                case 3:
                    g2d.drawImage(glasFull, Window[winSice][i].x, Window[winSice][i].y, null);
                    break;
                default:
                    winState[i] = 3;
            }
        }
        if (rightBoolRalph)
        {
            g2d.drawImage(rightRalph, Window[winSice][possRalph].x, Window[winSice][possRalph].y, null);
        } else
        {
            g2d.drawImage(leftRalph, Window[winSice][possRalph].x, Window[winSice][possRalph].y, null);
        }
        if (rightBoolFelix)
        {
            g2d.drawImage(rightFelix, Window[winSice][possFelix].x, Window[winSice][possFelix].y, null);
        } else
        {
            g2d.drawImage(leftFelix, Window[winSice][possFelix].x, Window[winSice][possFelix].y, null);
        }
        if (timeString != null)
        {
            timeString.draw(g2d);
        }
    }
}
