package Java.com.dethsanius.Game.SaladLabyrint.Screan;

import Engin.Entity.Butten;
import Engin.Listener.KeyboardListener;
import Engin.ReadWriteFile;
import Engin.Screen;
import Engin.ScreenFactory;
import Java.com.dethsanius.Game.Lib.Colors;
import Java.com.dethsanius.Game.Lib.Reference;
import Java.com.dethsanius.Game.SaladLabyrint.Entity.Bomb;
import Java.com.dethsanius.Game.SaladLabyrint.Entity.Eater;
import Java.com.dethsanius.Game.SaladLabyrint.Handlers.KeyboardHandlerGameScreen;
import Java.com.dethsanius.Game.SaladLabyrint.Handlers.MouseHandlerEditorScreen;

import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Dethsanius on 25.07.2014, project is Games 2D package are Java.com.dethsanius.Game.SaladLabyrint.Screan.
 */
public class gameScrean extends Screen {
    public gameScrean(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    private ReadWriteFile readWriteFile;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private KeyboardHandlerGameScreen keyboardListener;
    public static Eater eater;
    private Butten butten1, butten2, butten3, butten4, butten5, butten6, butten7, butten8, butten9, butten10, butten11;
    private int startRoute = 0;
    private boolean initialised;
    private static int maxRectangles = 420;
    public static int maxRectanglesDrawn = 0;
    public static int routeStat = 0;
    private int bombNum = 0;
    public static Bomb[] bomb = new Bomb[maxRectangles];
    public static int bombTranslater[] = new int[maxRectangles];
    public static int[] routeStatus = new int[maxRectangles];
    public static Rectangle[] routes = new Rectangle[maxRectangles];

    @Override
    public void onCreate()
    {
        int route = 0;
        for (int x = 1; x <= 15; x++) {
            for (int i = 0; i < 25; i++) {
                routes[route] = new Rectangle(48 * i, 48 * x, 48, 48);
                route++;
            }
        }
        maxRectanglesDrawn = route;
        butten1 = new Butten(0, 0, 48, 48, "E", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten2 = new Butten(48, 0, 48, 48, "G", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten3 = new Butten(96, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten4 = new Butten(48*3, 0, 48, 48, "S", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten5 = new Butten(48*4, 0, 48, 48, "B", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten6 = new Butten(48*5, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten7 = new Butten(48*7, 0, 48, 48, "T", screenFactory) {
            @Override
            public void isPushed() {
            }
        };
        butten8 = new Butten(48*8, 0, 48, 48, "L", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = readWriteFile.getIntLine(i + 1, Reference.resorcess("SL") + "First file structure.txt");
                    if (routeStatus[i] == 1)
                        startRoute = i;
                    else if (routeStatus[i] == 5) {
                        bombNum++;
                        bomb[bombNum] = new Bomb(routes[i].x, routes[i].y, 48, 30, i, bombNum);
                        bombTranslater[i] = bombNum;
                        System.out.println(i + "\t" + bombNum);
                        initialised = true;
                    }
                }
                eater.Route = startRoute;
                eater.setX(routes[startRoute].x + 4);
                eater.setY(routes[startRoute].y + 4);
            }
        };
        butten9 = new Butten(48*9, 0, 48, 48, "S", screenFactory) {
            @Override
            public void isPushed() {
                butten7.isPushed();
                String filname = "First file structure";
                String filpath = Reference.resorcess("SL") + filname + ".txt";
                fileWriter = readWriteFile.getFile(filpath);
                printWriter = readWriteFile.StartWrite(fileWriter);
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    readWriteFile.Write(printWriter, Integer.toString(routeStatus[i]));
                }
                readWriteFile.EndWrite(fileWriter);
            }
        };
        butten10 = new Butten(48*10, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = 0;
                }
            }
        };
        butten11 = new Butten(48*11, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = 0;
                }
                screenFactory.getGame().getWindow().removeKeyListener(keyboardListener);
                getScreenFactory().showScreen(new gameMenuScrean(getScreenFactory()));
            }
        };
        readWriteFile = new ReadWriteFile();
        eater = new Eater(routes[startRoute].x + 4, routes[startRoute].y + 4, 40, 40);
        keyboardListener = new KeyboardHandlerGameScreen();
        screenFactory.getGame().getWindow().addKeyListener(keyboardListener);
    }

    @Override
    public void onUpdate()
    {
        butten1.update();
        butten2.update();
        butten3.update();
        butten4.update();
        butten5.update();
        butten6.update();
        butten7.update();
        butten8.update();
        butten9.update();
        butten10.update();
        butten11.update();
        if (initialised) {
            for (int i = 0; i < bombNum; i++) {
                bomb[i + 1].update();
            }
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(0, 0, Reference.getWidth(screenFactory), 48);
        for (int i = 0; i <= 50; i = i + 2) {
            g2d.setColor(Color.cyan);
            g2d.fillRect(48 * i, 0, 48, 48);
        }
        int rute = 0;
        for (int i = 0; i < maxRectanglesDrawn; i++) {
            switch (routeStatus[i]) {
                case 1:
                    g2d.setColor(Color.white);
                    g2d.fill(routes[i]);
                    break;
                case 2:
                    g2d.setColor(Color.orange);
                    g2d.fill(routes[i]);
                    break;
                case 3:
                    g2d.setColor(Color.RED);
                    g2d.fill(routes[i]);
                    break;
                case 4:
                    g2d.setColor(Color.GRAY);
                    g2d.fill(routes[i]);
                    break;
                case 5:
                    g2d.setColor(Color.BLUE);
                    g2d.fill(routes[i]);
                    break;
                case 6:
                    g2d.setColor(Color.GREEN);
                    g2d.fill(routes[i]);
                    break;
                case 7:
                    g2d.setColor(Color.PINK);
                    g2d.fill(routes[i]);
                    break;
                default:
                    if (rute % 2 == 1) {
                        g2d.setColor(Colors.bacgroundColor());
                    }
                    else
                        g2d.setColor(Colors.bacgroundColorBrighter());
                    g2d.fill(routes[i]);
            }
            rute++;
        }
        g2d.setColor(Color.white);
        g2d.fill(MouseHandlerEditorScreen.path);
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        butten4.draw(g2d);
        butten5.draw(g2d);
        butten6.draw(g2d);
        butten7.draw(g2d);
        butten8.draw(g2d);
        butten9.draw(g2d);
        butten10.draw(g2d);
        butten11.draw(g2d);
        if (initialised) {
            for (int i = 0; i < bombNum; i++) {
                bomb[i + 1].draw(g2d);
            }
        }
        eater.draw(g2d);
    }
}