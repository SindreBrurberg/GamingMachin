package Java.com.dethsanius.Game.Main;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.Layering.Screen.gameScreen;
import Java.com.dethsanius.Game.Lib.Reference;
import Java.com.dethsanius.Game.PongV3.Screen.ressScreen;
import Java.com.dethsanius.Game.SaladLabyrint.Screan.gameMenuScrean;
import Java.com.dethsanius.Game.WIR.optionScreen;

import java.awt.*;

/**
 * Created by Haxer on 09.02.14.
 */
public class mainScrean extends Screen {
    private Butten butten1, butten2, butten3, butten4, butten;
    private int buttensTot = 4;
    private Rectangle[] buttens = new Rectangle[buttensTot];
    private boolean creaded = false;

    public mainScrean(final ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    @Override
    public void onCreate()
    {
        Butten.generateButtons(25, 15, 0, 0, Reference.winX, Reference.winY, buttensTot);
        this.buttens = Butten.buttens;
        butten1 = new Butten(buttens[0], "Block Game", screenFactory, false) {

            @Override
            public void isPushed()
            {
                System.out.println("Butten 1");
                Screen.getScreenFactory().getGame().setWindowSize(Reference.layeringWinX, Reference.layeringWinY);
                getScreenFactory().showScreen(new gameScreen(getScreenFactory()));
            }
        };
        butten2 = new Butten(buttens[1], Reference.TitleGameOfLife, screenFactory, false) {
            @Override
            public void isPushed()
            {
                System.out.println("Butten 2");
                Screen.getScreenFactory().getGame().setWindowSize(Reference.gameOfLifeWinX, Reference.gameOfLifeWinY);
                getScreenFactory().showScreen(new optionScreen(getScreenFactory()));
            }

        };
        butten3 = new Butten(buttens[2], Reference.TitlePongV2, screenFactory, false) {
            @Override
            public void isPushed()
            {
                System.out.println("Butten 3");
                getScreenFactory().getGame().setWindowSize(Reference.pongV2WinX, Reference.pongV2WinY);
                getScreenFactory().showScreen(new gameMenuScrean(getScreenFactory()));
            }
        };
        butten4 = new Butten(buttens[3], Reference.TitlePongV3, screenFactory, false) {
            @Override
            public void isPushed()
            {
                System.out.println("Butten 4");
                Screen.getScreenFactory().getGame().setWindowSize(Reference.winX, Reference.winY);
                getScreenFactory().getGame().setTitle(Reference.TitlePongV3);
                getScreenFactory().showScreen(new ressScreen(getScreenFactory()));
            }
        };
        creaded = true;
    }

    @Override
    public void onUpdate()
    {
        if (creaded)
        {
            butten1.update();
            butten2.update();
            butten3.update();
            butten4.update();
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(screenFactory.getGame().bacgroundColor());
        g2d.fillRect(0, 0, (int) screenFactory.getGame().getWindowWidth(), (int) screenFactory.getGame().getWindowHeight());
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        butten4.draw(g2d);
    }
}
