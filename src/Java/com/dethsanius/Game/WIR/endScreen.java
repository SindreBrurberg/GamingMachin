package Java.com.dethsanius.Game.WIR;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;
import Java.com.dethsanius.Game.Lib.Reference;
import Java.com.dethsanius.Game.Main.mainScrean;

import java.awt.*;

import static Java.com.dethsanius.Game.WIR.lib.refferences.*;

/**
 * Created by Dethsanius on 29.06.2014, project is Games 2D package are Game
 */
public class endScreen extends Screen {
    private int total;
    private StringTxt win, los;
    private Rectangle rects[];
    private Butten mainMenu;
    private String winner, loser, variable1, variable2, felix = "felix",
            ralph = "ralph", comp = "Computer", you = "You",
            player1 = "1 Player", player2 = "2 Player";
    private int val1 = 0, val2 = 1, fullGlases[] = {3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3};

    public endScreen(ScreenFactory screenFactory, int total) {
        super(screenFactory);
        this.total = total;
    }

    @Override
    public void onCreate() {
        if (total < 150) {
            winner = ralph;
            loser = felix;
            if (ralphComp && !felixComp) {
                variable1 = comp;
                variable2 = you;
            } else if (!ralphComp) {
                variable1 = you;
                variable2 = comp;
            } else {
                variable1 = comp;
                variable2 = comp;
            }
        } else {
            winner = felix;
            loser = ralph;
            if (ralphComp && !felixComp) {
                variable1 = you;
                variable2 = comp;
            } else if (!ralphComp) {
                variable1 = comp;
                variable2 = you;
            } else {
                variable1 = comp;
                variable2 = comp;
            }
        }
        if (!ralphComp && !felixComp) {
            if (winner.equals(ralph)) {
                variable1 = player1;
                variable2 = player2;
            } else {
                variable1 = player2;
                variable2 = player1;
            }
        } else {
            //test
            System.out.println("Empty else got fired off inn WIR\\endScreen.java");
        }
        Butten.generateButtons(50, 100, 0, 0, Reference.getWidth(screenFactory),
                                Reference.getHeight(screenFactory), 3);
        rects = Butten.buttens;
        win = new StringTxt(rects[val1], variable1 + " Win the game: " + winner) {
            @Override
            public void onUpdate() {

            }
        };
        los = new StringTxt(rects[val2], variable2 + " Los the game: " + loser) {
            @Override
            public void onUpdate() {

            }
        };
        mainMenu = new Butten(rects[2], "Main Menu", screenFactory) {
            @Override
            public void isPushed() {
                Screen.getScreenFactory().getGame().setWindowSize(Reference.winX,
                                                                  Reference.winY);
                getScreenFactory().showScreen(new mainScrean(getScreenFactory()));
            }
        };
        breaking = false;
        rightBoolRalph = true;
        rightBoolFelix = true;
        hammerTime = false;
        coop = false;
        felixComp = false;
        ralphComp = false;
        ralphRight = false;
        ralphUp = true;
        felixRight = false;
        felixUp = true;
        pause = true;
        winSice = 0;
        possRalph = 56;
        possFelix = 59;
        vertRalph = 0;
        horiRalph = 0;
        fullWindows = 0;
        halfWindows = 0;
        brokenWindows = 0;
        milli = 0;
        sec = 0;
        min = 0;
        winState = fullGlases;
    }

    @Override
    public void onUpdate() {
        mainMenu.update();
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        win.draw(g2d);
        los.draw(g2d);
        mainMenu.draw(g2d);
    }
}
