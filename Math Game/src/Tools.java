import java.util.Random;
import java.util.Scanner;

/**
 * Write a description of class Tools here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tools
{
    private int score;
    private int attempt;
    
    public static int Random()
    {
        Random random = new Random();
        return random.nextInt(9 - 1) + 1;
    }
    
    public void setScore(int x)
    {
        x = score;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void addScore()
    {
        score++;
    }
    
    public void removeScore()
    {
        score--;
    }
    
    public void setAttempt(int y)
    {
        y = attempt;
    }
    
    public int getAttempt()
    {
        return attempt;
    }
    
    public void addAttempt()
    {
        attempt++;
    }
    
    public void removeAttempt()
    {
        attempt--;
    }
    
    public boolean check()
    {
        if (this.score == 5 && this.attempt < 2)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
}
