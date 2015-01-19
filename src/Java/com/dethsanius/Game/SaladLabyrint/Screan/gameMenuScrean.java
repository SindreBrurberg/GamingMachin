package Java.com.dethsanius.Game.SaladLabyrint.Screan;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.Lib.Reference;
import Java.com.dethsanius.Game.Main.mainScrean;

import java.awt.*;

/**
 * Created by Dethsanius on 27.07.2014, project is Games 2D package are Java.com.dethsanius.Game.SaladLabyrint.
 */
public class gameMenuScrean extends Screen {
    Rectangle buttens[];
    Butten editor, game, mainMenu;

    public gameMenuScrean(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    @Override
    public void onCreate()
    {
        Butten.generateButtons(50, 25, 0, 0, (int) getScreenFactory().getGame().getWindowWidth(), (int) getScreenFactory().getGame().getWindowHeight(), 3);
        buttens = Butten.buttens;
        editor = new Butten(buttens[0], "Editor", screenFactory) {
            @Override
            public void isPushed()
            {
                getScreenFactory().showScreen(new editorScrean(getScreenFactory()));
            }
        };
        game = new Butten(buttens[1], "Game", screenFactory) {
            @Override
            public void isPushed()
            {
                getScreenFactory().showScreen(new gameScrean(getScreenFactory()));
            }
        };
        mainMenu = new Butten(buttens[2], "Main Menu", screenFactory) {
            @Override
            public void isPushed()
            {
                Screen.getScreenFactory().getGame().setWindowSize(Reference.winX, Reference.winY);
                getScreenFactory().showScreen(new mainScrean(getScreenFactory()));
            }
        };
    }

    @Override
    public void onUpdate()
    {
        editor.update();
        game.update();
        mainMenu.update();
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        editor.draw(g2d);
        game.draw(g2d);
        mainMenu.draw(g2d);
    }
}
