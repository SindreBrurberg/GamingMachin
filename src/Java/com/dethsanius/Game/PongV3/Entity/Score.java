package Java.com.dethsanius.Game.PongV3.Entity;

import Engin.StringTxt;

/**
 * Created by Dethsanius on 13.04.2014, project is Games 2D package are Java.com.dethsanius.Game.PongV3.AI.
 */
public abstract class Score extends StringTxt {
    public boolean updated = true;
    private int scoreP1, scoreP2;
    private String stringFormate;

    public Score(double x, double y, double Width, double Height, int P1, int P2, String stringFormate)
    {
        super(x, y, Width, Height, String.format(stringFormate, P1, P2));
        this.stringFormate = stringFormate;
        this.scoreP1 = P1;
        this.scoreP2 = P2;
    }

    @Override
    public void update()
    {
        super.update();
        if (!updated)
        {
            setTXT(String.format(stringFormate, scoreP1, scoreP2));
            updated = true;
        }
    }

    public void setScoreP1(int scoreP1)
    {
        this.scoreP1 = scoreP1;
    }

    public void setScoreP2(int scoreP2)
    {
        this.scoreP2 = scoreP2;
    }
}
