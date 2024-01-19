import java.util.Scanner;

public class L3
{
    Question third = new Question();
    Question thirdRight = new Question();
    
    Tools score = new Tools();
    Tools attempt = new Tools();

    public L3()
    {
        System.out.println("\nWelcome to Level 3");
        
        System.out.println("Your score is: " + score.getScore());
        
        //Question and Answer
        while (score.getScore() < 5)
        {
            Tools num1 = new Tools();
            Tools num2 = new Tools();
            
            int x = num1.Random();
            int y = num2.Random();
            
            int answer = (x - y);
            
            Scanner input = new Scanner(System.in);
            
            if (x > y)
            {
                third.setText("\nWhat is " + x + " - " + y + "?: ");
                third.display();
                
                int response = input.nextInt();
                
                if (response == answer)
                {
                    score.addScore();
                    
                    System.out.println("Correct, " + x + " - " + y + " = " + answer);
                    System.out.println("\nYour score is: " + score.getScore() + "/5");
                }
                
                if (response != answer)
                {
                    score.removeScore();
                    attempt.addAttempt();
                    
                    System.out.println("Wrong, " + x + " - " + y + " = " + answer);
                    System.out.println("\nOne Attempt Left");
                    System.out.println("Your score is: " + score.getScore() + "/5");
                }
            }
            
            if (this.score.getScore() == 5)
            {
                System.out.println("\nCongrats, you won!");
            }
            
            if (this.attempt.getAttempt() == 2)
            {
                System.out.println("Out of Attempts, Game Over");
            }
        }
    }
}
