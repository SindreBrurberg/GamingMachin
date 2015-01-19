package Java.com.dethsanius.Game.PongV3.AI;

/**
 * Created by Dethsanius on 28.12.2014.
 */
public abstract class Computer extends Engin.Entity.Computer implements IComputer{

    private double ballX = 0;
    private double ballY = 0;
    private double paddleSpeed = 0;
    private double paddleMaxSpeed = 0;
    private double paddleX = 0;
    private double paddleY = 0;
    private int computerDiff = 0;
    private double screenWidth = 0;
    private double paddleHeiht = 0;
    private double ballDiameter  = 0;
    private double[] speed = new double[]{0.3D, 0.7D, 1.5D, 3D, 5D};
    private double playground;
    private double[] presented;
    private boolean[] distances;

    public double getPaddleY(){return paddleY;}

    public Computer(int initComputerDiff, double initPaddleX, double initPaddleY, double initScreenWidth, double initPaddleHeight, double initBallDiameter){
        computerDiff = initComputerDiff;
        paddleX = initPaddleX;
        paddleY = initPaddleY;
        screenWidth = initScreenWidth;
        paddleHeiht = initPaddleHeight - 20;
        ballDiameter = initBallDiameter;
        switch (computerDiff){
            case 1:
                paddleMaxSpeed = screenWidth / 535;
                break;
            case 2:
                paddleMaxSpeed = screenWidth / 355;
                break;
            case 3:
                paddleMaxSpeed = screenWidth / 250;
                break;
            default:
                paddleMaxSpeed = 100;
                computerDiff = 4;
        }
    }

    public void setBallX(double X){
        ballX = X;
    }

    public void setBallY(double Y){
        ballY = Y;
    }

    public void setPaddleSpeed(double Speed){
        paddleSpeed = Speed;
    }

    public void setPaddleY(double Y){
        paddleY = Y;
    }

    @Override
    public void Update() {
        updateVariables();
        ballX += ballDiameter;
        double Formula = (screenWidth / 3.2 / ((screenWidth - 2 * (screenWidth - paddleX)) - (ballX - (screenWidth - paddleX))));
        double formula = Formula < 0 ? 0 : Formula;
        setPaddleSpeed(formula > paddleMaxSpeed ? paddleMaxSpeed : formula);
        if (ballY + ballDiameter > paddleY + paddleHeiht - 10){

            setPaddleY(paddleY + paddleSpeed);
        }
        else if (ballY < paddleY + 10){
            setPaddleY(paddleY - paddleSpeed);
        }
    }
}
