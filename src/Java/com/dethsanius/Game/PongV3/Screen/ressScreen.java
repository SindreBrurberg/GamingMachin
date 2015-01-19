package Java.com.dethsanius.Game.PongV3.Screen;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.Lib.Reference;
import Java.com.dethsanius.Game.PongV3.lib.propperties;

import java.awt.*;

/**
 * Created by Dethsanius on 04.04.2014, project is GamingMachin package are Java.com.dethsanius.Game.PongV3.
 */
public class ressScreen extends Screen {
    private Butten ressButten1, ressButten2, gamemodeButten1, gamemodeButten2, gamemodeButten3, difficulityP1Butten1, difficulityP1Butten2, difficulityP1Butten3, difficulityP2Butten1, difficulityP2Butten2, difficulityP2Butten3, difficulityCPButten1, difficulityCPButten2, difficulityCPButten3, doneButten1;
    private Rectangle[] ressButtens, gamemodeButtens, difficulityButtens, doneButten;
    private boolean regenButten = true, renderButtens = false;

    public ressScreen(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    private void generateButtens()
    {
        Butten.generateButtons(20, (Reference.getWidth(screenFactory) - 50) / 5 * 3, 0, 0, Reference.getWidth(screenFactory), (int) (Reference.getHeight(screenFactory) / 6.5), 2, 2);
        ressButtens = Butten.buttens;
        Butten.generateButtons(20, 20, 0, ressButtens[0].y + ressButtens[0].height, Reference.getWidth(screenFactory), (int) (Reference.getHeight(screenFactory) / 4.5), 3, 3, true);
        gamemodeButtens = Butten.buttens;
        Butten.generateButtons(20, 20, 0, gamemodeButtens[0].y + gamemodeButtens[0].height, Reference.getWidth(screenFactory), (int) (Reference.getHeight(screenFactory) / 6.5 * 3), 9, 0, true);
        difficulityButtens = Butten.buttens;
        Butten.generateButtons(20, 20, 0, difficulityButtens[8].y + difficulityButtens[8].height, Reference.getWidth(screenFactory), (int) (Reference.getHeight(screenFactory) / 4.8), 1, 0, true);
        doneButten = Butten.buttens;
        Butten.generateTxtRess(ressButtens, screenFactory);
        ressButten1 = new Butten(ressButtens[1], "Ress up", screenFactory) {
            @Override
            public void isPushed()
            {
                RessUp(screenFactory);
                regenButten = true;
            }
        };
        ressButten2 = new Butten(ressButtens[0], "Ress down", screenFactory) {
            @Override
            public void isPushed()
            {
                RessDown(screenFactory);
                regenButten = true;
            }
        };
        gamemodeButten1 = new Butten(gamemodeButtens[0], "MultiPlayer", screenFactory) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                gamemodeButten2.setKeepActivated(false);
                gamemodeButten3.setKeepActivated(false);
                difficulityP1Butten1.setDiactivated(false);
                difficulityP1Butten2.setDiactivated(false);
                difficulityP1Butten3.setDiactivated(false);
                difficulityP2Butten1.setDiactivated(true);
                difficulityP2Butten2.setDiactivated(true);
                difficulityP2Butten3.setDiactivated(true);
                difficulityCPButten1.setDiactivated(true);
                difficulityCPButten2.setDiactivated(true);
                difficulityCPButten3.setDiactivated(true);
                propperties.setGameMode(2);
                propperties.setP2Speed(0);
            }
        };
        gamemodeButten2 = new Butten(gamemodeButtens[1], "CO-OP", screenFactory) {
            @Override
            public void isPushed()
            {
                gamemodeButten1.setKeepActivated(false);
                setKeepActivated(true);
                gamemodeButten3.setKeepActivated(false);
                difficulityP1Butten1.setDiactivated(false);
                difficulityP1Butten2.setDiactivated(false);
                difficulityP1Butten3.setDiactivated(false);
                difficulityP2Butten1.setDiactivated(false);
                difficulityP2Butten2.setDiactivated(false);
                difficulityP2Butten3.setDiactivated(false);
                difficulityCPButten1.setDiactivated(true);
                difficulityCPButten2.setDiactivated(true);
                difficulityCPButten3.setDiactivated(true);
                propperties.setGameMode(1);
                propperties.setP2Speed(0);
            }
        };
        gamemodeButten3 = new Butten(gamemodeButtens[2], "SinglePlayer", screenFactory) {
            @Override
            public void isPushed()
            {
                gamemodeButten1.setKeepActivated(false);
                gamemodeButten2.setKeepActivated(false);
                setKeepActivated(true);
                difficulityP1Butten1.setDiactivated(false);
                difficulityP1Butten2.setDiactivated(false);
                difficulityP1Butten3.setDiactivated(false);
                difficulityP2Butten1.setDiactivated(true);
                difficulityP2Butten2.setDiactivated(true);
                difficulityP2Butten3.setDiactivated(true);
                difficulityCPButten1.setDiactivated(false);
                difficulityCPButten2.setDiactivated(false);
                difficulityCPButten3.setDiactivated(false);
                propperties.setGameMode(3);
                propperties.setP2Speed(0);
            }
        };
        difficulityP1Butten1 = new Butten(difficulityButtens[0], "P1 Slow", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP1Butten2.setKeepActivated(false);
                difficulityP1Butten3.setKeepActivated(false);
                propperties.setP1Speed(1);
            }
        };
        difficulityP1Butten2 = new Butten(difficulityButtens[1], "P1 Normal", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP1Butten1.setKeepActivated(false);
                difficulityP1Butten3.setKeepActivated(false);
                propperties.setP1Speed(2);
            }
        };
        difficulityP1Butten3 = new Butten(difficulityButtens[2], "P1 Fast", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP1Butten2.setKeepActivated(false);
                difficulityP1Butten1.setKeepActivated(false);
                propperties.setP1Speed(3);
            }
        };
        difficulityP2Butten1 = new Butten(difficulityButtens[3], "P2 Slow", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP2Butten2.setKeepActivated(false);
                difficulityP2Butten3.setKeepActivated(false);
                propperties.setP2Speed(1);
            }
        };
        difficulityP2Butten2 = new Butten(difficulityButtens[4], "P2 Normal", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP2Butten1.setKeepActivated(false);
                difficulityP2Butten3.setKeepActivated(false);
                propperties.setP2Speed(2);
            }
        };
        difficulityP2Butten3 = new Butten(difficulityButtens[5], "P2 Fast", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityP2Butten2.setKeepActivated(false);
                difficulityP2Butten1.setKeepActivated(false);
                propperties.setP2Speed(3);
            }
        };
        difficulityCPButten1 = new Butten(difficulityButtens[6], "Easy", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityCPButten2.setKeepActivated(false);
                difficulityCPButten3.setKeepActivated(false);
                propperties.setP2Speed(1);
            }
        };
        difficulityCPButten2 = new Butten(difficulityButtens[7], "Medium", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityCPButten1.setKeepActivated(false);
                difficulityCPButten3.setKeepActivated(false);
                propperties.setP2Speed(2);
            }
        };
        difficulityCPButten3 = new Butten(difficulityButtens[8], "Hard", screenFactory, true) {
            @Override
            public void isPushed()
            {
                setKeepActivated(true);
                difficulityCPButten2.setKeepActivated(false);
                difficulityCPButten1.setKeepActivated(false);
                propperties.setP2Speed(3);
            }
        };
        doneButten1 = new Butten(doneButten[0], "Done, Start The Game!", screenFactory, true) {
            @Override
            public void isPushed()
            {
                if (propperties.getGameMode() == 2)
                {
                    getScreenFactory().showScreen(new nettworkingScreen(getScreenFactory()));
                } else
                {
                    getScreenFactory().showScreen(new gameScreen(getScreenFactory()));
                }
            }
        };
        renderButtens = true;
    }


    @Override
    public void onCreate()
    {
        generateButtens();
    }

    @Override
    public void onUpdate()
    {
        if (regenButten)
        {
            generateButtens();
            regenButten = false;
        }
        if (renderButtens)
        {
            if (propperties.getGameMode() != 0 && propperties.getP1Speed() != 0 && propperties.getP2Speed() != 0 || propperties.getGameMode() == 2 && propperties.getP1Speed() != 0)
            {
                doneButten1.setDiactivated(false);
            } else
            {
                doneButten1.setDiactivated(true);
            }
            Butten.ressButtenToggler(ressButten1, ressButten2);
            ressButten1.update();
            ressButten2.update();
            gamemodeButten1.update();
            gamemodeButten2.update();
            gamemodeButten3.update();
            difficulityP1Butten1.update();
            difficulityP1Butten2.update();
            difficulityP1Butten3.update();
            difficulityP2Butten1.update();
            difficulityP2Butten2.update();
            difficulityP2Butten3.update();
            difficulityCPButten1.update();
            difficulityCPButten2.update();
            difficulityCPButten3.update();
            doneButten1.update();
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setColor(screenFactory.getGame().bacgroundColor());
        g2d.fillRect(0, 0, Reference.getWidth(screenFactory), Reference.getHeight(screenFactory));
        Butten.DrawTxtRess(g2d);
        ressButten1.draw(g2d);
        ressButten2.draw(g2d);
        gamemodeButten1.draw(g2d);
        gamemodeButten2.draw(g2d);
        gamemodeButten3.draw(g2d);
        difficulityP1Butten1.draw(g2d);
        difficulityP1Butten2.draw(g2d);
        difficulityP1Butten3.draw(g2d);
        difficulityP2Butten1.draw(g2d);
        difficulityP2Butten2.draw(g2d);
        difficulityP2Butten3.draw(g2d);
        difficulityCPButten1.draw(g2d);
        difficulityCPButten2.draw(g2d);
        difficulityCPButten3.draw(g2d);
        doneButten1.draw(g2d);
    }
}
