package Java.com.dethsanius.Game.Lib;

import Engin.Core.Game;
import Engin.ScreenFactory;

/**
 * Created by Haxer on 09.02.14.
 */
public class Reference {
    public static final int winX = 800, winY = 600;
    public static final int layeringWinX = 750, layeringWinY = 1000;
    public static final int pongV2WinX = 1200, pongV2WinY = 768;
    public static final int gameOfLifeWinX = 800, gameOfLifeWinY = 600;
    public static String Title = "GameMachin", TitleGameOfLife = "Wreck-It Ralph", TitlePongV2 = "PonvV2", TitlePongV3 = "PonvV3";

    public static String resorcess(String game)
    {
        return Game.projectPath() + "Resorsess/" + game + "/";
    }

    public static int getWidth(ScreenFactory screenFactory)
    {
        return (int)screenFactory.getGame().getWindowWidth();
    }

    public static int getHeight(ScreenFactory screenFactory)
    {
        return (int)screenFactory.getGame().getWindowHeight();
    }
}
