package Java.com.dethsanius.Game.Main;

import Engin.Core.Game;
import Java.com.dethsanius.Game.Lib.Reference;


public class Main {

    private final Game game;

    Main()
    {
        game = new Game(Reference.winX, Reference.winY, Reference.Title);
        game.getScreenFactory().showScreen(new mainScrean(game.getScreenFactory()));
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
