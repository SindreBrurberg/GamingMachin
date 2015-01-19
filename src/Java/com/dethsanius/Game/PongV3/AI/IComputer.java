package Java.com.dethsanius.Game.PongV3.AI;

/**
 * Created by Dethsanius on 28.12.2014.
 */
public interface IComputer {
    public void setBallX(double X);
    public void setBallY(double Y);
    public void setPaddleSpeed(double Speed);
    public void setPaddleY(double Y);
    public void updateVariables();
}
