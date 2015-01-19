package Java.com.dethsanius.Game.SaladLabyrint.Entity;

import Engin.Entity.AbstractEntity;
import Java.com.dethsanius.Game.SaladLabyrint.Screan.gameScrean;

import java.awt.*;

/**
 * Created by sindre on 18.01.2015.
 */
public class Eater extends AbstractEntity {

    public int Route = 0;

    public Eater(double x, double y, double height, double width) {
        super(x, y);
        setHeight(height);
        setWidth(width);

    }

    public void moveUp(){
        Route = Route - 25;
        switch (gameScrean.routeStatus[Route]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Route = Route + 25;
                break;
            case 5:
                if (gameScrean.routeStatus[Route - 25] != 0) {
                    Route = Route + 25;
                }
                else {
                    gameScrean.routeStatus[Route - 25] = 5;
                    gameScrean.bomb[gameScrean.bombTranslater[Route]].setY(gameScrean.routes[Route - 25].getY());
                    gameScrean.bombTranslater[Route - 25] = gameScrean.bombTranslater[Route];
                    gameScrean.bombTranslater[Route] = 0;
                    gameScrean.bomb[gameScrean.bombTranslater[Route - 25]].setBomb(Route - 25);
                }
                break;
            default:
        }
        if (gameScrean.routes[Route].getY() + 4 != getY())
            gameScrean.routeStatus[Route + 25] = 0;
        this.setY(gameScrean.routes[Route].getY() + 4);
        update();
    }

    public void moveDown(){
        Route = Route + 25;
        switch (gameScrean.routeStatus[Route]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Route = Route - 25;
                break;
            case 5:
                Route = Route - 25;
                break;
            default:
        }
        if (gameScrean.routes[Route].getY() + 4 != getY())
            gameScrean.routeStatus[Route - 25] = 0;
        this.setY(gameScrean.routes[Route].getY() + 4);
        update();
    }

    public void moveLeft(){
        Route = Route - 1;
        switch (gameScrean.routeStatus[Route]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Route = Route + 1;
                break;
            case 5:
                if (gameScrean.routeStatus[Route - 1] != 0)
                    Route = Route + 1;
                else {
                    gameScrean.routeStatus[Route - 1] = 5;
                    gameScrean.bomb[gameScrean.bombTranslater[Route]].setX(gameScrean.routes[Route - 1].getX());
                    gameScrean.bombTranslater[Route - 1] = gameScrean.bombTranslater[Route];
                    gameScrean.bombTranslater[Route] = 0;
                    gameScrean.bomb[gameScrean.bombTranslater[Route - 1]].setBomb(Route - 1);
                }
                break;
            default:
        }
        if (gameScrean.routeStatus[Route - 24] == 5) {
            if (gameScrean.routeStatus[Route - 25] == 0) {
                gameScrean.routeStatus[Route - 25] = 5;
                gameScrean.bomb[gameScrean.bombTranslater[Route - 24]].setX(gameScrean.routes[Route - 25].getX());
                gameScrean.bombTranslater[Route - 25] = gameScrean.bombTranslater[Route - 24];
                gameScrean.bombTranslater[Route - 24] = 0;
                gameScrean.routeStatus[Route - 24] = 0;
                gameScrean.bomb[gameScrean.bombTranslater[Route - 25]].setBomb(Route - 25);
            }
        }
        if (gameScrean.routes[Route].getX() + 4 != getX())
            gameScrean.routeStatus[Route + 1] = 0;
        this.setX(gameScrean.routes[Route].getX() + 4);
        update();
    }

    public void moveRight(){
        Route = Route + 1;
        switch (gameScrean.routeStatus[Route]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Route = Route - 1;
                break;
            case 5:
                if (gameScrean.routeStatus[Route + 1] != 0)
                    Route = Route - 1;
                else{
                    gameScrean.routeStatus[Route + 1] = 5;
                    gameScrean.bomb[gameScrean.bombTranslater[Route]].setX(gameScrean.routes[Route + 1].getX());
                    gameScrean.bombTranslater[Route + 1] = gameScrean.bombTranslater[Route];
                    gameScrean.bombTranslater[Route] = 0;
                    gameScrean.bomb[gameScrean.bombTranslater[Route + 1]].setBomb(Route + 1);
                }
                break;
            default:
        }
        if (gameScrean.routeStatus[Route - 26] == 5) {
            System.out.println("True");
            if (gameScrean.routeStatus[Route - 25] == 0) {
                gameScrean.routeStatus[Route - 25] = 5;
                gameScrean.bomb[gameScrean.bombTranslater[Route - 26]].setX(gameScrean.routes[Route - 25].getX());
                gameScrean.bombTranslater[Route - 25] = gameScrean.bombTranslater[Route - 26];
                gameScrean.bombTranslater[Route - 26] = 0;
                gameScrean.routeStatus[Route - 26] = 0;
                gameScrean.bomb[gameScrean.bombTranslater[Route - 25]].setBomb(Route - 25);
            }
        }
        if (gameScrean.routes[Route].getX() + 4 != getX())
            gameScrean.routeStatus[Route - 1] = 0;
        this.setX(gameScrean.routes[Route].getX() + 4);
        update();
    }


    @Override
    public void update() {
        gameScrean.routeStatus[Route] = 7;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.cyan);
        g2d.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
}
