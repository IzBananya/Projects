import java.util.Scanner;

public class L1
{
    //Variables
    Question first = new Question();
    Question firstRight = new Question();
    Tools score = new Tools();
    Tools attempt = new Tools();
    
    public L1()
    {
        System.out.println("Welcome to Level 1");
        
        this.score.setScore(0);
        this.attempt.setAttempt(0);
        
        System.out.println("Your score is: " + score.getScore());
        
        //Question and Answer
        while (score.getScore() < 5)
        {
            Tools num1 = new Tools();
            Tools num2 = new Tools();
            
            int x = num1.Random();
            int y = num2.Random();
            int answer = (x + y);
            
            Scanner input = new Scanner(System.in);
            
            if (answer < 10)
            {
                first.setText("\nIs " + x + " + " + y + " less than 10? (Yes/No): ");
                first.display();
                first.setAnswer("Yes");
                String choice = input.next();
                if (choice.equalsIgnoreCase(first.getAnswer()))
                {
                    System.out.println("Correct, " + x + " + " + y + " is < 10");
                    
                    firstRight.setText("\nWhat is " + x + " + " + y + "?: ");
                    firstRight.display();
                    int response = input.nextInt();
                    if (response == answer)
                    {
                        score.addScore();
                        System.out.println("Correct, " + x + " + " + y + " = " + answer);
                        System.out.println("\nYour score is: " + score.getScore() + "/5");
                    }
                    if (response != answer)
                    {
                        score.removeScore();
                        attempt.addAttempt();
                        
                        System.out.println("Wrong, " + x + " + " + y + " = " + answer);
                        System.out.println("\nOne Attempt Left");
                        System.out.println("Your score is: " + score.getScore() + "/5");
                    }
                }
                if (choice.equalsIgnoreCase(first.getAnswer()) == false)
                {
                    score.removeScore();
                    attempt.addAttempt();
                    
                    System.out.println();
                    
                    System.out.println("False, " + x + " + " + y + " is < 10");
                    System.out.println("\nOne Attempt Left");
                    System.out.println("Your score is: " + score.getScore() + "/5");
                }
            }
            
            if (this.score.getScore() == 5)
            {
                System.out.println("\nAdvancing to Next Level");
            }
            
            if (this.attempt.getAttempt() == 2)
            {
                System.out.println("\nOut of lives, Game Over");
                break;
            }
        }
    }
}