package Java.com.dethsanius.Game.SaladLabyrint.Entity;

import Engin.Entity.AbstractEntity;
import Engin.StringTxt;
import Java.com.dethsanius.Game.SaladLabyrint.Screan.gameScrean;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.awt.*;

/**
 * Created by sindre on 18.01.2015.
 */
public class Bomb extends AbstractEntity {
    private int bomb = 0, bombNum, fallen = 0, updates = 0;
    private boolean notFalling = true, exploded = false;
    private StringTxt stringTxt;
    public Bomb(double x, double y, double width, double height, int bombInit, int bombNumInit) {
        super(x, y);
        setWidth(width);
        setHeight(height);
        bomb = bombInit;
        bombNum = bombNumInit;
        stringTxt = new StringTxt(x, y, width, height, String.valueOf(bombNumInit)) {
            @Override
            public void onUpdate() {

            }
        };
    }

    public void explode() {
        exploded = true;
        gameScrean.routeStatus[bomb] = 0;
        gameScrean.bombTranslater[bomb] = 0;
        if (gameScrean.bombTranslater[bomb - 26] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb - 26]].explode();
        else
            gameScrean.routeStatus[bomb - 26] = 0;
        if (gameScrean.bombTranslater[bomb - 25] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb - 25]].explode();
        else
            gameScrean.routeStatus[bomb - 25] = 0;
        if (gameScrean.bombTranslater[bomb - 24] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb - 24]].explode();
        else
            gameScrean.routeStatus[bomb - 24] = 0;
        if (gameScrean.bombTranslater[bomb - 1] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb - 1]].explode();
        else
            gameScrean.routeStatus[bomb - 1] = 0;
        if (gameScrean.bombTranslater[bomb + 1] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb + 1]].explode();
        else
            gameScrean.routeStatus[bomb + 1] = 0;
        if (gameScrean.bombTranslater[bomb + 24] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb + 24]].explode();
        else
            gameScrean.routeStatus[bomb + 24] = 0;
        if (gameScrean.bombTranslater[bomb + 25] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb + 25]].explode();
        else
            gameScrean.routeStatus[bomb + 25] = 0;
        if (gameScrean.bombTranslater[bomb + 26] > 0)
            gameScrean.bomb[gameScrean.bombTranslater[bomb + 26]].explode();
        else
            gameScrean.routeStatus[bomb + 26] = 0;
    }

    public void setBomb(int bomb) {
        this.bomb = bomb;
    }

    @Override
    public void update() {
        if (!exploded) {
            if (gameScrean.routeStatus[bomb + 25] == 0) {
                bomb = bomb + 25;
                gameScrean.routeStatus[bomb - 25] = 0;
                gameScrean.routeStatus[bomb] = 5;
                gameScrean.bombTranslater[bomb - 25] = 0;
                gameScrean.bombTranslater[bomb] = bombNum;
                setY(gameScrean.routes[bomb].getY());
                fallen++;
            }
            else {
                if (fallen >= 3) {
                    explode();
                }
                fallen = 0;
            }
            stringTxt.setX(getX());
            stringTxt.setY(getY());
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (!exploded){
            g2d.setColor(Color.black);
            g2d.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
            stringTxt.draw(g2d);
        }
    }
}
