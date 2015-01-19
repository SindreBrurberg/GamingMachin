package Java.com.dethsanius.Game.WIR;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;
import Java.com.dethsanius.Game.Lib.Reference;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Engin.Entity.Butten.setMaxRess;
import static Engin.Entity.Butten.setMinRess;
import static Java.com.dethsanius.Game.WIR.lib.refferences.*;

/**
 * Created by Dethsanius on 12.06.2014, project is Games 2D package are Java.com.dethsanius.Game.WIR.
 */
public class optionScreen extends Screen {
    private Butten ressButten1, ressButten2, ralfButten, fixButten, multiplayerButten, doneButten;
    private boolean regenScreen = false;
    private Rectangle[] ressButtens, dessisonButtens, images;
    private BufferedImage fullWindowPause, brokenWindowPause;
    private StringTxt pauseScreen, full, half, broken;
    public optionScreen(ScreenFactory screenFactory)
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

    private void generateScreen()
    {
        Butten.generateButtons(20, (Reference.getWidth(screenFactory) - 50) / 5 * 3, 0, 0, Reference.getWidth(screenFactory), (int) (Reference.getHeight(screenFactory) / 6.5), 2, 2);
        ressButtens = Butten.buttens;
        ressButten1 = new Butten(ressButtens[1], "Ress Up", screenFactory) {
            @Override
            public void isPushed()
            {
                RessUp(screenFactory);
                regenScreen = true;
            }
        };
        ressButten2 = new Butten(ressButtens[0], "Ress Down", screenFactory) {
            @Override
            public void isPushed()
            {
                RessDown(screenFactory);
                regenScreen = true;
            }
        };
        Butten.generateTxtRess(ressButtens, screenFactory);
        Butten.generateButtons(25, 25, 0, (int) ressButtens[0].getY() + (int) ressButtens[0].getHeight(), Reference.getWidth(screenFactory) - Reference.getWidth(screenFactory) / 6, Reference.getHeight(screenFactory), 5, 1);
        dessisonButtens = Butten.buttens;
        ralfButten = new Butten(dessisonButtens[0], "Play As Ralph!", screenFactory) {
            @Override
            public void isPushed()
            {
                gameScreen.setRalphComp(false);
                gameScreen.setFelixComp(true);
                coop = false;
            }
        };
        fixButten = new Butten(dessisonButtens[1], "Play As Fixer!", screenFactory) {
            @Override
            public void isPushed()
            {
                gameScreen.setRalphComp(true);
                gameScreen.setFelixComp(false);
                coop = false;
            }
        };
        multiplayerButten = new Butten(dessisonButtens[2], "Play CO-OP!", screenFactory) {
            @Override
            public void isPushed()
            {
                gameScreen.setRalphComp(false);
                gameScreen.setFelixComp(false);
                coop = true;
            }
        };
        doneButten = new Butten(dessisonButtens[3], "Start The Game!", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setPause(false);
            }
        };
        pauseScreen = new StringTxt(dessisonButtens[4].x, dessisonButtens[4].y, dessisonButtens[4].width, dessisonButtens[4].height, "Game Is Paused") {
            @Override
            public void onUpdate()
            {

            }
        };
        Butten.generateButtons(30, 100, dessisonButtens[0].x + dessisonButtens[0].width, ressButtens[1].y + ressButtens[1].height, Reference.getWidth(screenFactory) - dessisonButtens[0].x - dessisonButtens[0].width, Reference.getHeight(screenFactory) - ressButtens[1].y - ressButtens[1].height, 3);
        images = Butten.buttens;
        try
        {
            fullWindowPause = ImageIO.read(new File(Reference.resorcess("WIR") + "glassFull-800-600.jpg"));
            brokenWindowPause = ImageIO.read(new File(Reference.resorcess("WIR") + "glassBroken-800-600.jpg"));
            getPreferredSize(fullWindowPause, images[0].width, images[0].height);
            getPreferredSize(brokenWindowPause, images[1].width, images[1].height);
        } catch (IOException e)
        {
        }
        countWindows();
        full = new StringTxt(images[0].x, images[0].y + images[0].height - 20, images[0].width, 100, String.format("%02d", fullWindows)) {
            @Override
            public void onUpdate()
            {

            }
        };
        half = new StringTxt(images[1].x, images[1].y + images[1].height - 20, images[1].width, 100, String.format("%02d", halfWindows)) {
            @Override
            public void onUpdate()
            {

            }
        };
        broken = new StringTxt(images[2].x, images[2].y + images[2].height - 20, images[2].width, 100, String.format("%02d", brokenWindows)) {
            @Override
            public void onUpdate()
            {

            }
        };
    }

    @Override
    public void onCreate()
    {
        generateScreen();
        if (screenFactory.getGame().getWindow().getWidth() == 800 + 6 && screenFactory.getGame().getWindow().getHeight() == 600 + 27)
        {
            setMinRess(true);
        } else if (screenFactory.getGame().getWindow().getWidth() == 1600 + 6 && screenFactory.getGame().getWindow().getHeight() == 900 + 27)
        {
            setMaxRess(true);
        }
    }

    @Override
    public void onUpdate()
    {
        if (!pause)
        {
            getScreenFactory().showScreen(new gameScreen(getScreenFactory()));
        } else
        {
            if (regenScreen)
            {
                generateScreen();
                regenScreen = false;
            }
            if (Butten.getMaxRess())
                ressButten1.setDiactivated(true);
            else ressButten1.setDiactivated(false);
            if (Butten.getMinRess())
                ressButten2.setDiactivated(true);
            else ressButten2.setDiactivated(false);
            ressButten1.update();
            ressButten2.update();
            ralfButten.update();
            fixButten.update();
            multiplayerButten.update();
            doneButten.update();
            if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_B))
            {
                setRalphComp(true);
                setFelixComp(true);
                setPause(false);
            }
            if (felixComp || ralphComp || coop)
            {
                doneButten.setDiactivated(false);
            }
            if (felixComp && !ralphComp)
            {
                doneButten.setDiactivated(false);
                ralfButten.setKeepActivated(true);
                fixButten.setKeepActivated(false);
                multiplayerButten.setKeepActivated(false);
            } else if (ralphComp && !felixComp)
            {
                doneButten.setDiactivated(false);
                ralfButten.setKeepActivated(false);
                fixButten.setKeepActivated(true);
                multiplayerButten.setKeepActivated(false);
            } else if (coop && !ralphComp && !felixComp)
            {
                doneButten.setDiactivated(false);
                ralfButten.setKeepActivated(false);
                fixButten.setKeepActivated(false);
                multiplayerButten.setKeepActivated(true);
            }
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        try
        {
            Butten.DrawTxtRess(g2d);
            ressButten1.draw(g2d);
            ressButten2.draw(g2d);
            ralfButten.draw(g2d);
            fixButten.draw(g2d);
            multiplayerButten.draw(g2d);
            doneButten.draw(g2d);
            pauseScreen.draw(g2d);
            g2d.drawImage(fullWindowPause, images[0].x, images[0].y, images[0].width, images[0].height, null);
            g2d.drawImage(brokenWindowPause, images[1].x, images[1].y, images[1].width, images[1].height, null);
            g2d.setPaint(Color.black);
            g2d.fill(images[2]);
            full.draw(g2d);
            half.draw(g2d);
            broken.draw(g2d);
        } catch (Exception e)
        {
            System.out.println("Exeption in draw method");
        }

    }
}
