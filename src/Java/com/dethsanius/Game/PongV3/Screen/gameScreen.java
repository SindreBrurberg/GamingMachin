package Java.com.dethsanius.Game.PongV3.Screen;

import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;
import Engin.Time;
import Java.com.dethsanius.Game.PongV3.AI.Computer;
import Java.com.dethsanius.Game.PongV3.Entity.Ball;
import Java.com.dethsanius.Game.PongV3.Entity.Paddel;
import Java.com.dethsanius.Game.PongV3.Entity.Score;
import Java.com.dethsanius.Game.PongV3.lib.propperties;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dethsanius on 06.04.2014, project is GamingMachin package are Java.com.dethsanius.Game.PongV3.
 */
public class gameScreen extends Screen {
    private Time time;
    private Score score;
    private StringTxt timeString;
    private Paddel paddel1, paddel2;
    private Ball ball;
    private Computer computer;
    private int scoreP1 = 0, scoreP2 = 0, milli = 0, sec = 0, min = 0, houer = 0;
    private double paddleWidth = screenFactory.getGame().getWindowWidth() / 20, paddleHeight = screenFactory.getGame().getWindowHeight() / 4, ballDim = screenFactory.getGame().getWindowWidth() / 40;

    public gameScreen(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    @Override
    public void onCreate()
    {
        paddel1 = new Paddel(25, screenFactory.getGame().getWindowHeight() / 2 - paddleHeight / 2, paddleWidth, paddleHeight) {
            @Override
            public void onUpdate()
            {
                if (propperties.getGameMode() == 1) {
                    if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_W)) {
                        paddel1.setY(paddel1.getY() - propperties.getP1Speed());
                    } else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_S)) {
                        paddel1.setY(paddel1.getY() + propperties.getP1Speed());
                    }
                }
                else {
                    if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP))
                    {
                        paddel1.setY(paddel1.getY() - propperties.getP2Speed());
                    } else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN))
                    {
                        paddel1.setY(paddel1.getY() + propperties.getP2Speed());
                    }
                }
            }
        };
        paddel2 = new Paddel(screenFactory.getGame().getWindowWidth() - 25 - paddleWidth, screenFactory.getGame().getWindowHeight() / 2 - paddleHeight / 2, paddleWidth, paddleHeight) {
            @Override
            public void onUpdate()
            {
                if (propperties.getGameMode() == 1) {
                    if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP))
                    {
                        paddel2.setY(paddel2.getY() - propperties.getP2Speed());
                    } else if (screenFactory.getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN))
                    {
                        paddel2.setY(paddel2.getY() + propperties.getP2Speed());
                    }
                }
                else if (propperties.getGameMode() == 3){
                    computer.Update();
                    setY(computer.getPaddleY());
                }
            }
        };
        ball = new Ball(screenFactory.getGame().getWindowWidth() / 2, screenFactory.getGame().getWindowWidth() / 2, (ballDim < 25 ? 25 : ballDim), (ballDim < 25 ? 25 : ballDim)) {
            @Override
            public void update()
            {
                if (paddel1.getPaddle().intersects(getBall()))
                {
                    velX = -velX;
                } else if (paddel2.getPaddle().intersects(getBall()))
                {
                    velX = -velX;
                }
                if (getY() <= 0)
                {
                    velY = -velY;
                } else if (getY() + ball.getHeight() >= screenFactory.getGame().getWindowHeight())
                {
                    velY = -velY;
                }
                setX(getX() + velX);
                setY(getY() + velY);
            }
        };
        computer = new Computer(propperties.getGameMode(), paddel2.getX(), paddel2.getY(), screenFactory.getGame().getWindowWidth(), paddel2.getHeight(), ball.getHeight()) {
            @Override
            public void updateVariables() {
                setBallY(ball.getY());
                setBallX(ball.getX());
            }
        };
        score = new Score(screenFactory.getGame().getWindow().getWidth() / 2 - 45, 25, 100, 25, scoreP1, scoreP2, "%02d:%02d") {
            @Override
            public void onUpdate()
            {
                if (ball.getX() + ball.getWidth() > paddel2.getX() + paddel2.getWidth())
                {
                    scoreP1 += 1;
                    setScoreP1(scoreP1);
                    updated = false;
                } else if (ball.getX() < paddel1.getX())
                {
                    scoreP2 += 1;
                    setScoreP2(scoreP2);
                    updated = false;
                }
                if (!updated)
                {
                    ball.setX(screenFactory.getGame().getWindowWidth() / 2);
                    ball.setY(screenFactory.getGame().getWindowHeight() / 2);
                    ball.velX = -ball.velX;
                }
            }
        };
        time = new Time(houer, min, sec);
        timeString = new StringTxt(screenFactory.getGame().getWindowWidth() / 2 - 55, screenFactory.getGame().getWindowHeight() - 50, 150, 25, time.toMilitary()) {
            @Override
            public void onUpdate()
            {
                milli++;
                if (milli == 60)
                {
                    sec++;
                    milli = 0;
                }
                if (sec == 60)
                {
                    min++;
                    sec = 0;
                }
                if (min == 60)
                {
                    houer++;
                    min = 0;
                }
                time.setTime(houer, min, sec);
                setTXT(time.toMilitary());
            }
        };
    }

    @Override
    public void onUpdate()
    {
        timeString.update();
        score.update();
        ball.update();
        paddel1.update();
        paddel2.update();
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, screenFactory.getGame().getWindow().getWidth(), screenFactory.getGame().getWindow().getHeight());
        paddel1.draw(g2d);
        paddel2.draw(g2d);
        ball.draw(g2d);
        score.draw(g2d);
        timeString.draw(g2d);
    }
}
