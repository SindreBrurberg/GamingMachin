package Java.com.dethsanius.Game.PongV3.lib;

/**
 * Created by Dethsanius on 28.12.2014.
 */
public class propperties {
    private static int gameMode = 0;
    private static double p1Speed = 0;
    private static double p2Speed = 0;

    public static int getGameMode(){return gameMode;}
    public static double getP1Speed(){return p1Speed;}
    public static double getP2Speed(){return p2Speed;}

    public static void setGameMode(int setGameMode){
        gameMode = setGameMode;
    }

    public static void setP1Speed(double speed){
        p1Speed = speed;
    }

    public static void setP2Speed(double speed){
        p2Speed = speed;
    }
}
